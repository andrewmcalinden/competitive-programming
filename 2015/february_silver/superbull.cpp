#include <bits/stdc++.h>

int n;
int teams[2000];
vector<int> usedTeams;

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("superbull.in");
    ofstream output("superbull.out");

    input >> n;
    for (int i = 0; i < n; i++)
    {
        input >> teams[i];
    }

    for (int i = 0; i < n - 1; i++)
    {
        int maxScore = -1;
        pair<int, int> teams;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                int score = teams[i] ^ teams[j];
                if (score > maxScore)
                {
                    maxScore = score;
                    teams = make_pair(i, j);
                }
            }
        }
        totalScore += maxScore;
        usedTeams.push_back(teams.first);
        usedTeams.push_back(teams.second);
    }
}