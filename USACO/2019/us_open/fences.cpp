#include <bits/stdc++.h>

using namespace std;

int n, m;
int minPeri = INT_MAX;

struct Cow
{
    int x;
    int y;
    int n;
    bool visited;
};

Cow cows[100001];
vector<int> adjList[100001];

void dfs(int cow, int &minX, int &maxX, int &minY, int &maxY)
{
    if (!cows[cow].visited)
    {
        cows[cow].visited = 1;
        minX = min(cows[cow].x, minX);
        maxX = max(cows[cow].x, maxX);
        minY = min(cows[cow].y, minY);
        maxY = max(cows[cow].y, maxY);

        for (int adj : adjList[cows[cow].n])
        {
            dfs(adj, minX, maxX, minY, maxY);
        }
    }
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("fenceplan.in");
    ofstream output("fenceplan.out");

    input >> n >> m;

    for (int i = 1; i <= n; i++)
    {
        int x, y;
        input >> x >> y;

        Cow c{x, y, i, 0};
        cows[i] = c;
    }

    for (int i = 1; i <= m; i++)
    {
        int a, b;
        input >> a >> b;

        adjList[a].push_back(b);
        adjList[b].push_back(a);
    }

    for (int i = 1; i <= n; i++)
    {
        int peri = INT_MAX;
        if (!cows[i].visited)
        {
            int minX = INT_MAX;
            int minY = INT_MAX;
            int maxX = -1;
            int maxY = -1;
            dfs(i, minX, maxX, minY, maxY);

            int w = abs(minX - maxX);
            int h = abs(minY - maxY);

            peri = 2 * w + 2 * h;
        }
        minPeri = min(peri, minPeri);
    }
    output << minPeri << endl;
}