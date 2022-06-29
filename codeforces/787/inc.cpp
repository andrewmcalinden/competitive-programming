#include <bits/stdc++.h>

using namespace std;

int nums[30];

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int n;
        cin >> n;

        for (int i = 0; i < n; i++)
        {
            cin >> nums[i];
        }

        int ans = 0;
        for (int i = n - 1; i > 0; i--)
        {
            while (nums[i - 1] >= nums[i])
            {
                if (nums[i - 1] == 0)
                {
                    ans = -1;
                    goto end;
                }

                nums[i - 1] /= 2;
                ans++;
            }

            if (nums[i - 1] <= nums[i - 2])
        }
        end:
        cout << ans << endl;
    }
}