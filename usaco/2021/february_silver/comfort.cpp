#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> Point;

int n;
bool pasture[2002][2002]; //might not be big enough
int adj[2002][2002];
int numAdded = 0;

void makeUncomfort(int x, int y);

void addCow(int x, int y)
{
    if (!pasture[x][y])
    {
        pasture[x][y] = 1;
        adj[x][y + 1]++;
        adj[x][y - 1]++;
        adj[x + 1][y]++;
        adj[x - 1][y]++;

        makeUncomfort(x, y);
        makeUncomfort(x, y + 1);
        makeUncomfort(x, y - 1);
        makeUncomfort(x + 1, y);
        makeUncomfort(x - 1, y);
    }
}

void makeUncomfort(int x, int y)
{
    if (adj[x][y] == 3 && pasture[x][y]) //need to add in a 4th cow to make uncomfortable
    {
        if (!pasture[x][y + 1])
        {
            numAdded++;
            addCow(x, y + 1);
        }
        else if (!pasture[x][y - 1])
        {
            numAdded++;
            addCow(x, y - 1);
        }
        else if (!pasture[x + 1][y])
        {
            numAdded++;
            addCow(x + 1, y);
        }
        else
        {
            numAdded++;
            addCow(x - 1, y);
        }
    }
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int x, y;
        cin >> x >> y;

        x += 1000;
        y += 1000;

        if (pasture[x][y])
        {
            numAdded--;
        }
        else
        {
            addCow(x, y);
        }
        cout << numAdded << endl;
    }
}