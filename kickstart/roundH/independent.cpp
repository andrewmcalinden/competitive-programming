#include <bits/stdc++.h>

using namespace std;

int events[1001][3];

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int n, q, k;
        cin >> n >> q >> k;

        events[1] = {-1, k, k};
        for (int i = 2; i <= n; i++)
        {
            int p, a, b;
            events[i] = {p, a, b};
        }

        for (int i = 0; i < q; i++)
        {
            int u, v;
            cin >> u >> v;
        }

        cout << "Case #" << run << ": " << ans << endl;
    }
}