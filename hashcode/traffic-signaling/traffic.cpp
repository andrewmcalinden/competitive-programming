#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

bool compareStreets(const pair<string, int> &a,
                    const pair<string, int> &b)
{
    return (a.second < b.second);
}

void solve(string inputFile, string outputFile, int numCycles)
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input(inputFile);
    ofstream output(outputFile);

    vector<string> adjList[100000]; //make vector of streets if need to store the time
    map<string, double> freq;
    map<string, int> lengths;
    vector<pair<string, int>> sortedFreq;

    int d, numIntersections, s, v, f;
    input >> d >> numIntersections >> s >> v >> f;

    for (int i = 0; i < s; i++)
    {
        int b, e, l;
        string streetName;
        input >> b >> e >> streetName >> l;

        //adjList[b].push_back(streetName);
        lengths[streetName] = l;
        adjList[e].push_back(streetName);
    }

    for (int i = 0; i < v; i++)
    {
        int p;
        input >> p;

        for (int j = 0; j < p; j++)
        {
            string street;
            input >> street;

            if (freq.find(street) == freq.end())
            {
                freq[street] = 1.0 * lengths[street];
            }
            else
            {
                freq[street] += 1.0 * lengths[street];
            }
        }
    }

    for (auto &it : freq)
    {
        sortedFreq.push_back(it);
    }
    sort(sortedFreq.begin(), sortedFreq.end(), compareStreets);

    vector<pair<vector<pair<string, double>>, int>> answer;
    for (int i = 0; i < numIntersections; i++)
    {
        vector<string> &intersection = adjList[i];

        double totalCars = 0;
        for (string street : intersection)
        {
            totalCars += freq[street];
        }
        if (totalCars != 0)
        {
            vector<pair<string, double>> times; //described time each light is on for
            for (string street : intersection)
            {
                double proportion = freq[street] / totalCars;
                if (proportion != 0)
                {
                    double totalTimeOn = proportion * d;
                    int timeInCycle = ceil(totalTimeOn / numCycles);
                    times.push_back(pair<string, double>{street, timeInCycle});
                }
            }
            if (times.size() > 0)
            {
                answer.push_back(pair<vector<pair<string, double>>, int>{times, i});
            }
        }
    }

    output << answer.size() << endl;
    for (pair<vector<pair<string, double>>, int> &el : answer)
    {
        vector<pair<string, double>> &intersection = el.first;
        output << el.second << endl
               << intersection.size() << endl;
        for (pair<string, double> &street : intersection)
        {
            output << street.first << " " << street.second << endl;
        }
    }

    input.close();
    output.close();
}

int main()
{
    // solve("a.txt", "submission_a.out", 2);
    // solve("b.txt", "submission_b.out", 1000);
    // solve("c.txt", "submission_c.out", 15);
    //solve("d.txt", "submission_d.out", 80);
    solve("e.txt", "submission_e.out", 250);
    solve("f.txt", "submission_f.out", 250);
}