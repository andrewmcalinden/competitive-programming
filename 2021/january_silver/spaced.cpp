#include <bits/stdc++.h>

bool grid[1000][1000];
int values[1000][1000];

bool canUse(int y, int x)
{
    if (grid[y][x])
        return 0;
    if (y == 0 || x == 0)
    {
        if (x != 0) //y == 0
        {
            int cnt = grid[y][x - 1] + grid[y + 1][x - 1] + grid[y + 1][x];
            if (cnt >= 2)
                return 0;

            cnt = grid[y][x + 1] + grid[y + 1][x + 1] + grid[y + 1][x];
            if (cnt >= 2)
                return 0;
        }
        else if (y != 0) //x == 0
        {
            int cnt = grid[y - 1][x] + grid[y - 1][x + 1] + grid[y][x + 1];
            if (cnt >= 2)
                return 0;

            cnt = grid[y + 1][x] + grid[y + 1][x + 1] + grid[y][x + 1];
            if (cnt >= 2)
                return 0;
        }
        else //both 0
        {
            int cnt = grid[y + 1][x] + grid[y + 1][x + 1] + grid[y][x + 1];
            if (cnt >= 2)
                return 0;
        }
    }
    else
    {
        int cnt = grid[y][x - 1] + grid[y + 1][x - 1] + grid[y + 1][x];
        if (cnt >= 2)
            return 0;

        cnt = grid[y][x + 1] + grid[y + 1][x + 1] + grid[y + 1][x];
        if (cnt >= 2)
            return 0;

        cnt = grid[y - 1][x] + grid[y - 1][x + 1] + grid[y][x + 1];
        if (cnt >= 2)
            return 0;

        cnt = grid[y - 1][x - 1] + grid[y][x - 1] + grid[y - 1][x];
        if (cnt >= 2)
            return 0;
    }
    return 1;
}

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> values[i][j];
        }
    }

    int ans = 0;
    for (int row = 0; row < n - 1; row += 2)
    {
        for (int col = 0; col < n - 1; col += 2)
        {
            vector<int> options;
            options.push_back(values[row][col]);
            options.push_back(values[row][col + 1]);
            options.push_back(values[row + 1][col]);
            options.push_back(values[row + 1][col + 1]);

            int numChosen = 0;
            while (numChosen < 2)
            {
                int max = options.at(0);
                int index = 0;
                int y = row;
                int x = col;
                for (int i = 1; i < 4; i++)
                {
                    if (options.at(i) > max)
                    {
                        max = options.at(i);
                        index = i;
                        switch (i)
                        {
                        case 1:
                            y = row;
                            x = col + 1;
                            break;
                        case 2:
                            y = row + 1;
                            x = col;
                            break;
                        case 3:
                            y = row + 1;
                            x = col + 1;
                            break;
                        }
                    }
                }
                //cout << y << " " << x << endl;
                if (canUse(y, x))
                {
                    grid[y][x] = 1;
                    ans += values[y][x];
                    numChosen++;
                    //cout << "used it" << endl;
                }
                else
                {
                    
                }
                options.at(index) = -1;
            }
        }
    }
    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < n; j++)
    //     {
    //         cout << grid[i][j] << " ";
    //     }
    //     cout << endl;
    // }
    cout << ans << endl;
}