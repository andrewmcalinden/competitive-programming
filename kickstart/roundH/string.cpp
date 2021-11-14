#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        string s, f;
        cin >> s >> f;

        int ans = 0;
        for (char c : s)
        {
            int minDist = INT_MAX;
            for (char c2 : f)
            {
                int guess = min(abs(c2 - c), 26 - abs(c2 - c));
                if (guess < minDist)
                {
                    minDist = guess;
                }
            }
            ans += minDist;
        }
        cout << "Case #" << run << ": " << ans << endl;
    }
}