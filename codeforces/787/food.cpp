#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int a, b, c, x, y;
        cin >> a >> b >> c >> x >> y;

        x -= min(x, a);
        y -= min(y, b);
        c -= (x + y);
        
        if (c >= 0)
        {
            cout << "YES" << endl;
        }
        else
        {
            cout << "NO" << endl;
        }
    }
}