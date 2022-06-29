#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        string iString, p;
        cin >> iString >> p;

        int cur = 0;
        int ans = 0;
        bool done = false;
        for (int i = 0; i < iString.length() && !done; i++)
        {
            char c = iString[i];
            while (p[cur] != c && cur < p.length()){
                cur++;
                ans++;
            }
            if (cur >= p.length())
            {
                done = true;
                cout << "Case #" << run << ": IMPOSSIBLE " << endl;
            }
            
            cur++;
        }

        if (cur != p.length()){
            ans = p.length() - iString.length();
        }

        if (!done)
        cout << "Case #" << run << ": " << ans << endl;
    }
}