#include <bits/stdc++.h>

using namespace std;

void eLogV(int a, int n, vector<pair<int, int>> adjList[])
{
    long long shortest[n + 1];
    for(int i = 1; i <= n; i++)
    {
        shortest[i] = LONG_MAX;
    }
    shortest[a] = 0;

    priority_queue<pair<long long, int>> pq;
    pq.push(make_pair(0, a));
    while(!pq.empty())
    {
        int node = pq.top().second;
        long long dist = -1 * pq.top().first; //convert it back to a positive
        pq.pop();
        if(dist != shortest[node]) continue;

        for(pair<int, int> &adj : adjList[node])
        {
            long long newDist = dist + adj.second;
            if(newDist < shortest[adj.first])
            {
                shortest[adj.first] = newDist;
                pq.push(make_pair(-newDist, adj.first));
            }
        }
    }

    for(int i = 1; i <= n; i++)
    {
        if (shortest[i] == INT_MAX)
        {
            cout << -1;
        }
        else
        {
            cout << shortest[i];
        }
        cout << " ";
    }
    cout << endl;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int n, m;
    cin >> n >> m;

    vector<pair<int, int>> adjList[n+1];

    for(int i = 0; i < m; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        adjList[a].push_back(make_pair(b, c));
    }
    eLogV(1, n, adjList);
}