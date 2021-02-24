#include <bits/stdc++.h>

using namespace std;

int n;
char grid[1000][1000];

void flipRow(int row)
{
    for (int c = 0; c < n; c++)
    {
        if (grid[row][c] == 'R') grid[row][c] = 'L';
        else grid[row][c] = 'R';
    }
}

void flipCol(int col)
{
    for (int r = 0; r < n; r++)
    {
        if (grid[r][col] == 'R') grid[r][col] = 'L';
        else grid[r][col] = 'R';
    }
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("leftout.in");
    ofstream output("leftout.out");

    input >> n;
    for (int i = 0; i < n; i++)
    {
        string s;
        input >> s;
        for (int j = 0; j < n; j++)
        {
            grid[i][j] = s[j];
        }
    }

    for (int r = 0; r < n; r++)
    {
        if (grid[r][0] == 'R')
        {
            flipRow(r);
        }
    }

    for (int c = 0; c < n; c++)
    {
        if (grid[0][c] == 'R')
        {
            flipCol(c);
        }
    }

    for (int i = 38; i < 39; i ++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << grid[i][j] << " ";
        }
        cout << endl;
    }

    if (grid[0][0] == 'R')
    {
        output << "1 1";
    }
    else
    {
        vector<pair<int, int>> problems;
        for (int r = 0; r < n; r++)
        {
            for (int c = 0; c < n; c++)
            {
                if (grid[r][c] == 'R')
                {
                    problems.push_back(make_pair(r + 1, c + 1));
                    //cout << "problem: " << r + 1 << " " << c + 1 << endl;
                }
            }
        }

        //cout << "size: " << problems.size() << endl;
        if (problems.size() == 0)
        {
            output << "-1";
        }
        else if(problems.size() == ((n - 1) * (n - 1)))
        {
            output << "1 1";
        }
        else 
        {
            output << problems.at(0).first << " " << problems.at(0).second;
        }
    }
    output << endl;
}