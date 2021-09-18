#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int d, n, k;
        cin >> d >> n >> k;

        map<string, priority_queue<int, vector<int>, greater<int>>> days;
        for (int i = 0; i < n; i++)
        {
            int h, s, e;
            cin >> h >> s >> e;

            stringstream ss;
            ss << s << "-" << e;

            if (map.count(ss.str()))
            {
                map.at(ss.str()) += h;
            }
            else
            {
                        }

            for (int j = s; j <= e; j++)
            {
                if (days[j].size() < k)
                {
                    days[j].push(h);
                }
                else if (days[j].top() < h)
                {
                    days[j].pop();
                    days[j].push(h);
                }
            }
        }

        long long ans = 0;
        for (int i = 0; i <= d; i++)
        {
            long long current = 0;
            for (int j = 0; j < k && !days[i].empty(); j++)
            {
                current += days[i].top();
                days[i].pop();
            }
            if (current > ans)
            {
                ans = current;
            }
        }
        cout << "Case #" << run << ": " << ans << endl;
    }
}