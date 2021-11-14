#include <bits/stdc++.h>

using namespace std;

int N, M;
vector<int> adjList[100001];
bool visited[100001];
string types;

bool dfs(int farm, int target, char pref, vector<int> path)
{
    if (!visited[farm])
    {
        visited[farm] = 1;
        path.push_back(farm);
        if (farm == target)
        {
            for (int f : path)
            {
                char type = types[f - 1];
                if (type == pref)
                {
                    return 1;
                }
            }
        }
        else
        {
            for (int adj : adjList[farm])
            {
                if (dfs(adj, target, pref, path))
                {
                    return 1;
                }
            }
            return 0;
        }
    }
    return 0;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("milkvisits.in");
    ofstream output("milkvisits.out");

    input >> N >> M >> types;

    for (int i = 0; i < N - 1; i++)
    {
        int f1, f2;
        input >> f1 >> f2;

        adjList[f1].push_back(f2);
        adjList[f2].push_back(f1);
    }

    stringstream ans;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        char c;
        input >> a >> b >> c;

        vector<int> initialPath;
        ans << dfs(a, b, c, initialPath);
        
        for (int j = 1; j < N + 1; j++)
        {
            visited[j] = 0;
        }
    }
    output << ans.str() << endl;
}