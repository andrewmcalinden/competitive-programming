#include <bits/stdc++.h>

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);
    ifstream input;
    input.open("gymnastics.in");

    int k, n;
    input >> k >> n;

    vector<pair<int, int>> pairs;
    for (int i = 1; i <= n; i++)
    {
        for (int j = i + 1; j <= n; j++)
        {
            if (i == j)
                continue;
            pairs.push_back(pair<int, int>(i, j));
        }
    }

    vector<vector<int>> rankings;
    for (int practice = 0; practice < k; practice++)
    {
        rankings.push_back(vector<int>(n + 1, INT_MAX));
        for (int rank = 0; rank < n; rank++)
        {
            int currentCow;
            input >> currentCow;
            vector<int> &current = rankings.at(practice);
            //current.insert(current.begin() + currentCow, rank);
            current.at(currentCow) = rank;
        }
    }

    // for (vector<int> &v : rankings)
    // {
    //     for (int el : v)
    //     {
    //         cout << el << " ";
    //     }
    //     cout << endl;
    // }

    for (int p = pairs.size() - 1; p >= 0; p--)
    {
        pair<int, int> &pair = pairs.at(p);
        int cow1 = pair.first;
        int cow2 = pair.second;
        //cout << "cow1: " << cow1 << "\tcow2: " << cow2 << endl;

        vector<int> &firstPractice = rankings.at(0);
        int initialPos1 = firstPractice.at(cow1);
        int initialPos2 = firstPractice.at(cow2);
        //cout << "initial: " << initialPos1 << " " << initialPos2 << endl;

        bool initialFirstCowBetter = initialPos1 < initialPos2 ? 1 : 0;
        for (int i = 1; i < rankings.size(); i++)
        {
            vector<int> &practice = rankings.at(i);

            int pos1 = practice.at(cow1);
            int pos2 = practice.at(cow2);
            //cout << "current: " << pos1 << " " << pos2 << endl;

            bool currentFirstCowBetter = pos1 < pos2 ? 1 : 0;
            if (currentFirstCowBetter != initialFirstCowBetter)
            {
                pairs.erase(pairs.begin() + p);
                //cout << "erased" << endl;
                break;
            }
        }
    }
    // for (pair<int, int> &p : pairs)
    // {
    //     cout << "(" << p.first << ", " << p.second << ")" << endl;
    // }
    ofstream output;
    output.open("gymnastics.out");
    output << pairs.size() << endl;
    output.close();
    input.close();
}