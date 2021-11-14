#include <bits/stdc++.h>

using namespace std;

int n, m, k;

void reverse(int left, int right, int array[])
{
    int shift = 0;
    int mid = (left + right) / 2;
    while (left + shift <= mid)
    {
        swap(array[left + shift], array[right - shift]);
        shift++;
    }
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    cin >> n >> m >> k;

    int orig[n];
    int cows[n];
    int netMovement[n];
    for (int i = 0; i < n; i++)
    {
        orig[i] = i + 1;
        netMovement[i] = i + 1;
        cows[i] = i + 1;
    }

    while(m--) //O(NM)
    {
        int l, r;
        cin >> l >> r;

        l--;
        r--;
        reverse(l, r, netMovement);
    }

    int newCows[n];
    for (int i = 0; i < n; i++)
    {
        newCows[i] = cows[i];
    }

    int cnt = 0;
    int mods[n];

    vector<int> notFound;
    for (int i = 0; i < n; i++)
    {
        notFound.push_back(i);
    }

    while(notFound.size() > 0)
    {
        for (int i = 0; i < n; i++)
        {
            newCows[i] = cows[netMovement[i] - 1];
        }

        for (int i = notFound.size() - 1; i >= 0; i--)
        {
            int index = notFound.at(i);
            if (newCows[index] == orig[index])
            {
                mods[index] = k % cnt;
                notFound.erase(notFound.begin() + index);
            }
        }

        for (int i = 0; i < n; i++)
        {
            cows[i] = newCows[i];
        }
        cnt++;
    }
    //make 2d array to keep track of p[1], p[2], etc

    int ans[n];
    for (int i = 0; i < n; i++)
    {
        for (int i = 0; i < mods[i]; i++)
        {

        }
    }
}