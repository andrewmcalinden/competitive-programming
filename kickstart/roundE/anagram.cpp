#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        string s;
        cin >> s;

        int len = s.length();
        map<char, int> freq;

        for (char &c : s)
        {
            if (freq.count(c))
            {
                freq.at(c)++;
            }
            else
            {
                freq.insert(make_pair(c, 1));
            }
        }

        stringstream ans;
        // for (auto el : freq)
        // {
        //     cout << el.first << " " << el.second << endl;
        // }
        char current = s[0];
        while (ans.str().length() < len)
        {
            cout << current << " " << ans.str() << endl;
            bool foundSomething = 0;
            for (auto &el : freq)
            {
                if (el.first != current)
                {
                    ans << el.first;
                    el.second--;
                    foundSomething = 1;
                    current = el.first; //look for somewhere to put current
                    if (el.second == 0)
                    {
                        freq.erase(el.first);
                    }
                    break;
                }
            }
            if (!foundSomething)
            {
                ans.str("IMPOSSIBLE");
                break;
            }
        }
        cout << "Case #" << run << ": " << ans.str() << endl;
    }
}