#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int q;
    cin >> n >> q;

    for (int i = 1; i <= n; i++)
    {
        cows[i] = i;
        orig[i] = i;
        uniquePositions[i].insert(i);
    }

    for (int i = 0; i < q; i++)
    {
        int pos1, pos2;
        cin >> pos1 >> pos2;
        swaps[i] = pair<int, int>{pos1, pos2};
    }

    int pos1 = swaps[0].first;
    int pos2 = swaps[0].second;

    uniquePositions[cows[pos1]].insert(pos2);
    uniquePositions[cows[pos2]].insert(pos1);
    swap(cows[pos1], cows[pos2]);

    for (int i = 1; !areEqual(); i++)
    {
        if(i == q)
        {
            i = 0;
        }

        int pos1 = swaps[i].first;
        int pos2 = swaps[i].second;

        uniquePositions[cows[pos1]].insert(pos2);
        uniquePositions[cows[pos2]].insert(pos1);
        swap(cows[pos1], cows[pos2]);
    }
    
    for (int i = 1; i <= n; i++)
    {
        cout << uniquePositions[i].size() << endl;
    }
}