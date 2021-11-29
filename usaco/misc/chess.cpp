#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    bool free[8][8];
    for (int i = 0; i < 8; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < 8; j++)
        {
            if (s[j] == '.')
            {
                free[i][j] = 1;
            }
            else
            {
                free[i][j] = 0;
            }
        }
    }

    int rows[8];
    for (int i = 0; i < 8; i++)
    {
        rows[i] = i;
    }

    long long ans = 0;
    do
    {
        bool works = 1;
        for (int col = 0; col < 8; col++)
        {
            int row = rows[col];
            int r = row;
            int c = col;
            if (!free[r][c])
            {
                works = 0;
                goto next;
            }

            r = row - 1;
            c = col - 1;
            //top left
            while (r >= 0 && c >= 0)
            {
                if (rows[c] == r)
                {
                    works = 0;
                    goto next;
                }
                r--;
                c--;
            }

            r = row - 1;
            c = col + 1;
            //top right
            while (r >= 0 && c < 8)
            {
                if (rows[c] == r)
                {
                    works = 0;
                    goto next;
                }
                r--;
                c++;
            }

            r = row + 1;
            c = col + 1;
            //bottom right
            while (r < 8 && c < 8)
            {
                if (rows[c] == r)
                {
                    works = 0;
                    goto next;
                }
                r++;
                c++;
            }

            r = row + 1;
            c = col - 1;
            //bottom left
            while (r < 8 && c >= 0)
            {
                if (rows[c] == r)
                {
                    works = 0;
                    goto next;
                }
                r++;
                c--;
            }
        }
    next:
        if (works)
            ans++;
    } while (next_permutation(rows, rows + 8));
    cout << ans << endl;
}