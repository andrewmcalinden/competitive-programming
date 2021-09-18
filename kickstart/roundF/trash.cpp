#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int n;
        cin >> n;
        
        string s;
        cin >> s;

        long long ans = 0;
        int behindBin = -1;
        vector<int> zeros;
        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] == '0')
            {
                zeros.push_back(i);
            }
            else
            {
                int forwardBin = i;
                for (int zero : zeros)
                {
                    if (behindBin == -1)
                    {
                        ans += abs(zero - forwardBin);
                    }
                    else
                    {
                        ans += min(abs(zero - forwardBin), abs(zero - behindBin));
                    }
                }
                zeros.clear();
                behindBin = i;
            }
        }
        if (!zeros.empty())
        {
            for (int zero : zeros)
            {
                ans += abs(zero - behindBin);
            }
        }
        cout << "Case #" << run << ": " << ans << endl;
    }
}