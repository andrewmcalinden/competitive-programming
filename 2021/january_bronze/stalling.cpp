#include <bits/stdc++.h>

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int n;
    cin >> n;

    int heights[n];
    for (int i = 0; i < n; i++)
    {
        int height;
        cin >> height;
        heights[i] = height;
    }
    sort(heights, heights + n);

    int limits[n];
    for (int i = 0; i < n; i++)
    {
        int limit;
        cin >> limit;
        limits[i] = limit;
    }
    sort(limits, limits + n);

    // for (int el : heights)
    // {
    //     cout << el << " ";
    // }
    // cout << endl;

    // for (int el : limits)
    // {
    //     cout << el << " ";
    // }
    // cout << endl;

    long long numWays = 1;
    int start = 0;
    for (int i = 0; i < n; i++)
    {
        int curLimit = limits[i];
        //find how many cows fit in this stall
        int count = 0;
        for (int j = start; j < n; j++)
        {
            if (heights[j] > curLimit)
            {
                break;
            }
            count++;
        }
        numWays *= count;
        start++; //"remove" 1st cow from the array of heights
    }

    cout << numWays << endl;
}