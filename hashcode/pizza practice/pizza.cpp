#include <bits/stdc++.h>

using namespace std;

struct Team
{
    set<string> toppings;
    set<long long> pizzas;
    int numPeople;
};

struct Pizza
{
    long long numToppings;
    set<string> toppings;
    long long numP;
};

int m;
Pizza pizzas[100000];
vector<Pizza> pizzaBuffer;

int lastPizza = 0;

long long benefit(Team team, set<string> newToppings)
{
    set<string> initialToppings = team.toppings;
    long long initialScore = initialToppings.size() * initialToppings.size();
    for (string topping : newToppings)
    {
        initialToppings.insert(topping);
    }
    long long finalScore = initialToppings.size() * initialToppings.size();
    long long benefit = finalScore - initialScore;
    return benefit;
}

bool compare(Pizza p1, Pizza p2)
{
    return p1.numToppings > p2.numToppings;
}

bool getPizzas()
{
    if (lastPizza == m) //dont have any more pizzas 
    {
        return 0;
    }
    pizzaBuffer.push_back(pizzas[lastPizza]);
    lastPizza++;
    return 1;
}

void solve(string inputFile, string outputFile)
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input(inputFile);
    ofstream output("temp");

    int t2, t3, t4;
    input >> m >> t2 >> t3 >> t4;

    string garbage;
    getline(input, garbage);

    for (int i = 0; i < m; i++)
    {
        string pizzaData;
        getline(input, pizzaData);

        stringstream pizzaStream(pizzaData);
        long long numToppings;
        pizzaStream >> numToppings;

        long long read = numToppings;
        set<string> toppings;
        while (read--)
        {
            string topping;
            pizzaStream >> topping;
            toppings.insert(topping);
        }

        Pizza p{numToppings, toppings, i};
        pizzas[i] = p;
    }
    sort(pizzas, pizzas + m, compare);

    Team teams[30];
    for (int i = 0; i < 10; i++) 
    {
        teams[i] = {};
        teams[i].numPeople = 2;
    }
    for (int i = 10; i < 20; i++)
    {
        teams[i] = {};
        teams[i].numPeople = 3;
    }
    for (int i = 20; i < 30; i++)
    {
        teams[i] = {};
        teams[i].numPeople = 4;
    }

    int numDeliv = 0;
    while (getPizzas() && pizzaBuffer.size() > 0)
    {
        if (t2 == 0 && t3 == 0 && t4 == 0) break;

        int maxB = -2;
        pair<int, int> pizzaTeam; //first is what pizza in the buffer it is, second is the team
        for (int i = 0; i < pizzaBuffer.size(); i++)
        {
            Pizza current = pizzaBuffer.at(i);
            int num = current.numP;
            set<string> toppings = current.toppings;

            long long benefits[30];
            for (int i = 0; i < 30; i++)
            {
                benefits[i] = benefit(teams[i], toppings) * teams[i].pizzas.size();
            }

            if (t2 == 0)
            {
                for (int i = 0; i < 10; i++)
                {
                    benefits[i] = -1;
                }
                //cout << "all t2 neg" << endl;
            }
            if (t3 == 0)
            {
                for (int i = 10; i < 20; i++)
                {
                    benefits[i] = -1;
                }
                //cout << "all t3 neg" << endl;
            }
            if (t4 == 0)
            {
                for (int i = 20; i < 30; i++)
                {
                    benefits[i] = -1;
                }
                //cout << "all t4 neg" << endl;
            }

            for (int index = 29; index >= 0; index--)
            {
                if (benefits[index] > maxB)
                {
                    maxB = benefits[index];
                    //cout << "changed max to this loc: " << index << endl;
                    pizzaTeam = make_pair(i, index);
                }
            }
        }

        cout << (pizzaBuffer.at(pizzaTeam.first)).numP << " " << pizzaTeam.second << endl;

        int loc = pizzaTeam.second;
        int checkVar = t2;
        if (10 <= loc && loc <= 19) checkVar = t3;
        else if (20 <= loc && loc <= 29) checkVar = t4;

        if(checkVar > 0)
        {
            Pizza realPizza = pizzaBuffer.at(pizzaTeam.first);
            teams[loc].pizzas.insert(realPizza.numP);
            for (string s : realPizza.toppings)
            {
                teams[loc].toppings.insert(s);
                if (teams[loc].pizzas.size() == teams[loc].numPeople)
                {
                    output << teams[loc].numPeople << " ";
                    auto it = teams[loc].pizzas.begin();
                    while (it != teams[loc].pizzas.end())
                    {
                        output << *(it) << " ";
                        it++;
                    }
                    teams[loc].toppings = {};
                    teams[loc].pizzas = {};

                    if (teams[loc].numPeople == 2)
                        t2--;
                    else if (teams[loc].numPeople == 3)
                        t3--;
                    else
                        t4--;
                    output << endl;
                    numDeliv++;
                }
            }
            pizzaBuffer.erase(pizzaBuffer.begin() + pizzaTeam.first);
        }
    }

    input.close();

    ofstream realoutput(outputFile);
    realoutput << numDeliv << endl;

    ifstream intermediate("temp");
    string line;
    while(getline(intermediate, line))
    {
        realoutput << line << endl;
    }

    output.close();
    realoutput.close();
    intermediate.close();

    for (Team t : teams)
    {
        if(t.pizzas.size() > 0)
        {
            cout << "wasted pizzas: " << t.pizzas.size() << " " << t.numPeople << endl;
        }
    }
}

int main()
{
    //solve("a_example.in", "submission_a.out");
    solve("b_little_bit_of_everything.in", "submission_b.out");
    // solve("c_many_ingredients.in", "submission_c.out");
    // solve("d_many_pizzas.in", "submission_d.out");
    // solve("e_many_teams.in", "submission_e.out");
}