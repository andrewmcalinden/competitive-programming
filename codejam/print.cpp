#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int c[3];
        int m[3];
        int y[3];
        int k[3];

        for (int i = 0; i < 3; i++)
        {
            cin >> c[i];
            cin >> m[i];
            cin >> y[i];
            cin >> k[i];
        }

        int minC = c[0];
        int minM = m[0];
        int minY = y[0];
        int minK = k[0];
        for (int i = 1; i < 3; i++)
        {
            minC = min(minC, c[i]);
            minM = min(minM, m[i]);
            minY = min(minY, y[i]);
            minK = min(minK, k[i]);
        }
        //cout << minC << " " << minM << " " << minY << " " << minK << endl;

        int sum = minC + minM + minY + minK;
        if (sum < 1000000)
        {
            cout << "Case #" << run << ": " << "IMPOSSIBLE" << endl;
        }
        else
        {
            int takeAway = sum - 1000000;
            if (takeAway != 0)
            {
                int old = min(takeAway, minC);
                minC -= min(takeAway, minC);
                takeAway -= old;
            }
            if (takeAway != 0)
            {
                int old = min(takeAway, minM);
                minM -= min(takeAway, minM);
                takeAway -= old;
            }
            if (takeAway != 0)
            {
                int old = min(takeAway, minY);
                minY -= min(takeAway, minY);
                takeAway -= old;
            }
            if (takeAway != 0)
            {
                int old = min(takeAway, minK);
                minK -= min(takeAway, minK);
                takeAway -= old;
            }
            if (takeAway != 0){
                cout << "Case #" << run << ": "
                     << "IMPOSSIBLE" << endl;
            }
            cout << "Case #" << run << ": " << minC << " " << minM << " " << minY << " " << minK << endl;
        }
    }
}