#include <bits/stdc++.h>

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b)
{
    return a.second < b.second;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int ans = 0;
        int total = 0;

        int n, k;
        cin >> n >> k;

        int b[n];
        for (int i = 0; i < n; i++)
        {
            cin >> b[i];
        }

        int max1 = -1;
        int loc1l = -1;
        int loc1r = -1;
        for (int i = 0; i < n; i++)
        {
            if (b[i] > max1)
            {
                max1 = b[i];
                loc1l = i;
                loc1r = i;
            }
        }
        ans++;
        total += max1;
        b[loc1l] = -1;

        if (total >= k)
        {
            cout << "Case #" << run << ": " << ans << endl;
            continue;
        }
        cout << total << endl;

        int max2 = -1;
        int loc2l = -1;
        int loc2r = -1;
        for (int i = 0; i < n; i++)
        {
            if (b[i] > max2)
            {
                max2 = b[i];
                loc2l = i;
                loc2r = i;
            }
        }
        ans++;
        total += max2;
        b[loc2l] = -1;

        if (total >= k)
        {
            cout << "Case #" << run << ": " << ans << endl;
            continue;
        }
        cout << total << endl;

        while (total < k) //just keep running array of candidates instead of remaking it every time lol
        {
            //potential problem is if 2 of them are the same
            int c1 = loc1l - 1;
            int c2 = loc1r + 1;
            int c3 = loc2l - 1;
            int c4 = loc2r + 1;
            vector<pair<int, int>> can;
            if (c1 >= 0)
            {
                can.push_back(make_pair(c1, b[c1]));
            }
            if (c2 < n)
            {
                can.push_back(make_pair(c2, b[c2]));
            }
            if (c3 >= 0)
            {
                can.push_back(make_pair(c3, b[c3]));
            }
            if (c4 < n)
            {
                can.push_back(make_pair(c4, b[c4]));
            }
            for (auto &el : can)
            {
                cout << el.first << " " << el.second << endl;
            }
            
            auto max = max_element(can.begin(), can.end(), compare);
            total += max->second;
            ans++;
            b[max->first] = -1;
            if (max->first == c1)
            {
                loc1l = c1;
            }
            else if (max->first == c2)
            {
                loc1r = c2;
            }
            else if (max->first == c3)
            {
                loc2l = c3;
            }
            else
            {
                loc2r = c4;
            }
            cout << total << endl;
        }
        cout << "Case #" << run << ": " << ans << endl;
    }
}