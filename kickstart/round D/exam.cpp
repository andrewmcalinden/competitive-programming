#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int n, m;
        cin >> n >> m;
        set<long long> diff;
        for (int i = 0; i < n; i++)
        {
            int a, b;
            cin >> a >> b;
            for (int j = a; j <= b; j++)
            {
                diff.insert(j);
            }
        }

        vector<int> ans;
        for (int i = 0; i < m; i++)
        {
            int skill;
            cin >> skill;

            if (diff.count(skill))
            {
                ans.push_back(skill);
                diff.erase(skill);
            }
            else
            {
                //binary search for closest one
                
                // auto hi = (diff.upper_bound(skill));
                // if (hi == diff.begin())
                // {
                //     long long answer = *(diff.begin());
                //     ans.push_back(answer);
                //     diff.erase(answer);
                // }
                // else if (hi == diff.end())
                // {
                //     hi--;
                //     long long answer = *hi;
                //     ans.push_back(answer);
                //     diff.erase(answer);
                // }
                // else
                // {
                //     auto lo = hi--;

                //     long long hiVal = *lo;
                //     long long loVal = *hi;
                //     //cout << hiVal << " " << loVal << endl;

                //     if (abs(loVal - skill) <= abs(hiVal - skill))
                //     {
                //         ans.push_back(loVal);
                //         diff.erase(loVal);
                //     }
                //     else
                //     {
                //         ans.push_back(hiVal);
                //         diff.erase(hiVal);
                //     }
                // }
            }
        }
        cout << "Case #" << run << ": ";
        for (int &el : ans){
            cout << el << " ";
        }
        cout << endl;
    }
}