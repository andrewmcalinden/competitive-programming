#include <bits/stdc++.h>

using namespace std;

int n, k, l;

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    
    cin >> n >> k >> l;
    int ratings[n];
    for(int i = 0; i < n; i++)
    {
        cin >> ratings[i];
    }
    sort(ratings);

    int maxCites = l * k;

    map<int, int> numGreater;
    for (int i = 0; i < n; i++)
    {
        int key = ratings[i];
        int val = n - i;
        numGreater.insert(make_pair(key, val));
    }

}