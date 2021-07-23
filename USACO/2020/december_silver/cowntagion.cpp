#include <bits/stdc++.h>

using namespace std;

vector<int> adjList[100001];
bool visited[100001];
int totalTime = 0;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int n;
    cin >> n;
    //double until we have anough cows to populate every directly adjacent farm
    //move 1 cow to each of those farms (don't need to worry about sending extra cows 
    //since it's always at least as good to double instead of receiving another cow)
    //repeat

    for (int i = 1; i < n; i++)
    {
        int farm1, farm2;
        cin >> farm1 >> farm2;

        adjList[farm1].push_back(farm2);
        adjList[farm2].push_back(farm1);
    }
    
    queue<int> q;
    q.push(1);
    while (!q.empty())
    {
        int farm = q.front();
        q.pop();
        visited[farm] = 1;
        int numAdj = 0;
        for (int f : adjList[farm])
        {
            if (!visited[f])
            {
                numAdj++;
                q.push(f);
            }
        }
        if (numAdj != 0){
            totalTime += (int)(ceil(log2(numAdj + 1))) + numAdj;
        }
    }
    cout << totalTime << endl;
}