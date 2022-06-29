#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int n;
        cin >> n;

        map<int, int> fun;
        map<int, int> point;

        bool pointedTo[n + 1];
        fill(pointedTo, pointedTo + n + 1, false);

        for (int i = 1; i <= n; i++)
        {
            int f;
            cin >> f;
            fun[i] = f;
        }

        for (int i = 1; i <= n; i++)
        {
            int p;
            cin >> p;
            point[i] = p;
            pointedTo[p] = true;
        }

        vector<int> initiators;
        for (int i = 1; i <= n; i++)
        {
            if (!pointedTo[i])
            {
                initiators.push_back(i);
            }
        }

        int order[initiators.size()];
        for (int i = 0; i < initiators.size(); i++)
        {
            order[i] = initiators.at(i);
        }
        sort(order, order + initiators.size());

        int ans = 0;
        do
        {
            bool visited[n + 1];
            fill(visited, visited + n + 1, false);

            int total = 0;
            for (int i = 0; i < initiators.size(); i++)
            {
                int cur = order[i];
                int most = 0;
                while (cur != 0 && !visited[cur])
                {
                    visited[cur] = true;
                    most = max(most, fun[cur]);
                    cur = point[cur];
                }
                total += most;
            }
            ans = max(ans, total);
        } while (next_permutation(order, order + initiators.size()));

        cout << "Case #" << run << ": " << ans << endl;
    }
}