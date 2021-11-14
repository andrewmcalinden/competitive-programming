#include <bits/stdc++.h>

using namespace std;

string getColors(char color)
{
    if (color == 'R' || color == 'Y' || color == 'B' || color == 'U')
    {
        string s;
        return s + color;
    }
    if (color == 'O')
    {
        return "RY";
    }
    if (color == 'P')
    {
        return "RB";
    }
    if (color == 'G')
    {
        return "YB";
    }
    if (color == 'A')
    {
        return "RYB";
    }
    return "something is wrong";
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int n;
        cin >> n;

        string p;
        cin >> p;

        string colors[n];

        for (int i = 0; i < n; i++)
        {
            colors[i] = getColors(p[i]);
        }
        // for (string s : colors)
        // {
        //     cout << s << endl;
        // }

        int ans = 0;
        char primary[] = {'R', 'Y', 'B'};
        for (char prim = 0; prim < 3; prim++)
        {
            char current = primary[prim];
            bool painting = colors[0].find(current) < colors[0].length();
            if (painting)
            {
                ans++;
            }
            for (int i = 1; i < n; i++)
            {
                bool found = colors[i].find(current) < colors[i].length();
                if (found && !painting)
                {
                    painting = true;
                    ans++;
                }
                else if (!found && painting)
                {
                    painting = false;
                }
            }
        }
        cout << "Case #" << run << ": " << ans << endl;
    }
}