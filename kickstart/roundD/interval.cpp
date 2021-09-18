#include <bits/stdc++.h>

using namespace std;

int main()
{
    long long t;
    cin >> t;

    for (long long run = 1; run <= t; run++)
    {
        long long n, c;
        cin >> n >> c;

        map<long long, long long> freq;
        for (long long line = 0; line < n; line++)
        {
            long long l, r;
            cin >> l >> r;

            for (long long i = l + 1; i < r; i++)
            {
                if (freq.count(i))
                {
                    freq.at(i)++;
                }
                else
                {
                    freq.insert(pair<long long, long long>(i, 1));
                }
            }
        }

        priority_queue<long long> sorted;
        for (auto &el : freq)
        {
            sorted.push(el.second);
        }


        long long extra = 0;
        long long count = 0;
        while (count < c && sorted.top() != 0 && sorted.size() > 0)
        {
            extra += sorted.top();
            sorted.pop();
            count++;
        }
        long long ans = n + extra;
        cout << "Case #" << run << ": " << ans << endl;
    }
}