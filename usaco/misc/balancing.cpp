#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main()
{
    ifstream in("balancing.in");

    int n, b;
    in >> n >> b;

    int xs[n];
    int ys[n];

    set<int> checkX;
    set<int> checkY;

    for (int i = 0; i < n; i++)
    {
        int x, y;
        in >> x >> y;
        checkX.insert(x);
        checkY.insert(y);

        xs[i] = x;
        ys[i] = y;
    }

    int m = INT_MAX;
    for (int x : checkX)
    {
        for (int y : checkY)
        {
            int realX = x - 1;
            int realY = y - 1;

            int tl = 0, tr = 0, bl = 0, br = 0;
            for (int i = 0; i < n; i++)
            {
                if (xs[i] < realX && ys[i] < realY)
                    bl++;
                else if (xs[i] < realX && ys[i] > realY)
                    tl++;
                else if (xs[i] > realX && ys[i] > realY)
                    tr++;
                else if (xs[i] > realX && ys[i] < realY)
                    br++;
            }
            m = min(m, max({tl, tr, bl, br}));
        }
    }
    ofstream out("balancing.out");
    out << m << endl;
}
