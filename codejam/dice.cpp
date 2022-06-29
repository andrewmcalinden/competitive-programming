#include <bits/stdc++.h>

using namespace std;


int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {

        const int N = 1000001;
        int prefix[N];

        fill(prefix, prefix + N, 0);

        int n;
        cin >> n;

        for (int i = 0; i < n; i++)
        {
            int num;
            cin >> num;
            prefix[num]++;
        }

        int sum = 0;
        for (int i = 1; i < N; i++)
        {
            sum += prefix[i];
            sum = min(sum, i);
        }

        cout << "Case #" << run << ": " << sum << endl;
    }
}