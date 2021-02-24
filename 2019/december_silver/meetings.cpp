#include <bits/stdc++.h>

using namespace std;

struct Cow
{
    int weight;
    double position;
    unsigned char dir;
};

int n, l;

bool comparePos(Cow &one, Cow &two){return one.position > two.position};

double timeToNextEvent(Cow *cows)
{
    sort(cows, cows + n, comparePos);

    int minTime = INT_MAX;
    if (!cows[0].dir)
    {
        minTime = cows[0].position;
    }
    if (cows[n - 1].dir)
    {
        minTime = min(minTime, cows[n - 1].position);
    }

    for (int i = 0; i < n - 1; i++)
    {
        Cow &c1 = cows[i], c2 = cows[i + 1];
        if (c1.dir && !c2.dir)
        {
            minTime = min(minTime, c2.position - c1.position);
        }
    }
    return minTime;
}

void simulateTime(double t)
{
    
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("meetings.in");
    ofstream output("meetings.out");

    input >> n >> l;

    Cow cows[n];
    for (int i = 0; i < n; i++)
    {
        input >> cows[i].weight >> cows[i].position >> cows[i].dir;
    }

}