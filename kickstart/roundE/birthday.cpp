#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int r, c, k;
        cin >> r >> c >> k;

        int r1, c1, r2, c2;
        cin >> r1 >> c1 >> r2 >> c2;

        double height = r2 - r1 + 1;
        double width = c2 - c1 + 1;
        //cout << height << " " << width << endl;

        int shortestDist = min({r1 - 1, c1 - 1, r - r2, c - c2});
        int initialCut = (int)(ceil(shortestDist / k));
        //cout << shortestDist << " " << initialCut << endl;

        int sideEdgeCuts = 0;
        if (c1 != 1)
        {
            sideEdgeCuts += (int)(ceil(height / k));
        }
        if (c2 != c)
        {
            sideEdgeCuts += (int)(ceil(height / k));
        }

        int vertEdgeCuts = 0;
        if (r1 != 1)
        {
            vertEdgeCuts += (int)(ceil(width / k));
        }
        if (r2 != r)
        {
            vertEdgeCuts += (int)(ceil(width / k));
        }

        int numInsideVert = (width - 1) * height;
        int numInsideHor = (height - 1) * width;

        int insideVert;
        int insideHor;

        if (numInsideHor < numInsideVert)
        {
            int cutsPerVertEdge = (int)(ceil(height / k));
            insideVert = cutsPerVertEdge * (width - 1);

            insideHor = numInsideHor;
        }
        else
        {
            int cutsPerHorRow = (int)(ceil(width / k));
            int insideHor = cutsPerHorRow * (height - 1);
            
            insideVert = numInsideVert;
        }
        int ans = insideHor + insideVert + vertEdgeCuts + sideEdgeCuts + initialCut;
        cout << "Case #" << run << ": " << ans << endl;
    }
}