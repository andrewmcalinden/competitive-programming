#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        string num;
        cin >> num;

        string ans = num;

        int sum = 0;
        for (char c : num)
        {
            sum += c - 48;
        }

        int extra = 9 - (sum - (sum / 9) * 9);
        if (extra == 9)
            extra = 0;

        bool done = false;
        for (int i = 0; i < num.length(); i++)
        {
            if (extra == 0 && i == 0)
            {
                continue;
            }
            if (num[i] - 48 > extra)
            {
                ans = num.substr(0, i) + to_string(extra) + num.substr(i);
                done = true;
                break;
            }
        }

        if (!done)
        {
            ans = num + to_string(extra);
        }
        cout << "Case #" << run << ": " << ans << endl;
    }
}