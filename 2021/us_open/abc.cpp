#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 0; run < t; run++)
    {
        int n;
        cin >> n;

        int nums[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            cin >> nums[i];
        }
        sort(nums);

        int abc = nums[n - 1];
        int ab = nums[n - 2];
        int c = -1;
        for (int i = 0; i < 3; i++)
        {
            if (nums[i] + ab == abc)
            {
                c = nums[i];
            }
        }
        if (c == -1)
        {
            cout << 0 << endl;
        }
    }
}