#include <bits/stdc++.h>

using namespace std;

int n, k;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    cin >> n >> k;
    int years[n];
    for (int i = 0; i < n; i++)
    {
        cin >> years[i];
    }

    sort(years, years + n);

    int currentMult = 0;
    vector<vector<int>> groups;
    int i = 0;
    while(i < n) //can be made faster by putting directly adjacent groups in the same group
    {
        int year = years[i];
        int maxYear = 12 * currentMult;
        if (year <= maxYear)
        {
            groups.at(groups.size() - 1).push_back(year);
        }
        else
        {
            while(year > maxYear)
            {
                currentMult++;
                maxYear = 12 * currentMult;
            }
            groups.push_back(vector<int>{});
            groups.at(groups.size() - 1).push_back(year);
        }
        i++;
    }

    // for (vector<int> &group : groups)
    // {
    //     cout << "group: ";
    //     for (int el : group)
    //     {
    //         cout << el << " ";
    //     }
    //     cout << endl;
    // }
    // cout << endl;

    while (groups.size() + 1 > k)
    {
        int minDist = INT_MAX;
        int i = 0;
        int g1 = 0;
        int g2 = 1;
        while(i + 1 < groups.size())
        {
            int g2Min = groups.at(i + 1).at(0);
            int g1Max = groups.at(i).at(groups.at(i).size() - 1);
            int dist = g2Min - g1Max;

            if (dist < minDist)
            {
                minDist = dist;
                g1 = i;
                g2 = i + 1;
                if (minDist <= 12)
                {
                    goto modifyGroups;
                }
            }
            i++;
        }
        modifyGroups:
        //cout << g1 << " " << g2 << endl;
        vector<int> oldG2 = groups.at(g2);
        for (int p = 0; p < oldG2.size(); p++)
        {
            groups.at(g1).push_back(oldG2.at(p));
        }
        groups.erase(groups.begin() + g2);
    }

    // for (vector<int> &group : groups)
    // {
    //     cout << "group: ";
    //     for (int el : group)
    //     {
    //         cout << el << " ";
    //     }
    //     cout << endl;
    // }

    //could make sizes faster by having size array update in the while loop

    //cout << endl;
    int time = 0;
    for (vector<int> &group : groups)
    {
        double start = group.at(group.size() - 1);
        int realStart = ceil(start / 12) * 12;

        double end = group.at(0);
        int realEnd = floor(end / 12) * 12;

        int yearDiff = realStart - realEnd;
        //cout << realStart << " " << realEnd << " " << yearDiff << endl;
        time += yearDiff;
    }
    cout << time << endl;
}