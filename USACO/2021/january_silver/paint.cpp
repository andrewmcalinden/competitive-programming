#include <bits/stdc++.h>

using namespace std;

int minStrokes(string s)
{
    int lastLocOfColor[91];
    int minSinceLast[]


    fill(lastLocOfColor, lastLocOfColor + 91, -1);
    int ans = 0;
    for (int i = 0; i < s.length(); i++)
    {
        int currentColor = s[i];

        int lastLoc = lastLocOfColor[currentColor];
        int leastAfter = INT_MAX;
        if (lastLoc != -1)
        {
            for (int j = lastLoc; j < i; j++)
            {
                leastAfter = min(leastAfter, (int)(s[j]));
            }

            if (leastAfter >= currentColor)
            {
                //do nothing
            }
            else
            {
                ans++;
            }
        }
        else
        {
            ans++;
        }
        lastLocOfColor[currentColor] = i;
    }
    return ans;
}


int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int n, q;
    string s;
    cin >> n >> q >> s;

    while(q--)
    {
        int leftStop, leftStart;
        cin >> leftStop >> leftStart;

        leftStop--;
        string left = s.substr(0, leftStop);
        string right = s.substr(leftStart);

        cout << minStrokes(left) + minStrokes(right) << endl;
    }

}