#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;

    //can only do anything with middle if difference is an even number
    //check to see if middle row/collum/diagonals have any differences in common

    for (int run = 1; run <= t; run++)
    {
        long long tl, tm, tr;
        long long ml, mr;
        long long bl, bm, br;

        cin >> tl >> tm >> tr >> ml >> mr >> bl >> bm >> br;

        long long rowDiff = abs(ml - mr);
        long long colDiff = abs(tm - bm);
        long long diag1 = abs(tl - br);
        long long diag2 = abs(tr - bl);

        int initial = 0;
        if (tl - tm == tm - tr){
            initial++;
        }
        if (bl - bm == bm - br)
        {
            initial++;
        }
        if (tl - ml == ml - bl)
        {
            initial++;
        }
        if (tr - mr == mr - br)
        {
            initial++;
        }

        int extra = 0;
        if (rowDiff % 2 == 0){
            int numSame = 1;
            int diff = rowDiff / 2;
            int mid = min(ml, mr) + diff;
            if (tm - mid == mid - bm)
            {
                numSame++;
            }
            if (tl - mid == mid - br)
            {
                numSame++;
            }
            if (tr - mid == mid - bl)
            {
                numSame++;
            }
            extra = max(extra, numSame);
        }

        if (colDiff % 2 == 0)
        {
            int numSame = 1;
            int diff = colDiff / 2;
            int mid = min(tm, bm) + diff;
            if (ml - mid == mid - mr)
            {
                numSame++;
            }
            if (tl - mid == mid - br)
            {
                numSame++;
            }
            if (tr - mid == mid - bl)
            {
                numSame++;
            }
            extra = max(extra, numSame);
        }

        if (diag1 % 2 == 0)
        {
            int numSame = 1;
            int diff = diag1 / 2;
            int mid = min(tl, br) + diff;
            if (tm - mid == mid - bm)
            {
                numSame++;
            }
            if (ml - mid == mid - mr)
            {
                numSame++;
            }
            if (tr - mid == mid - bl)
            {
                numSame++;
            }
            extra = max(extra, numSame);
        }

        if (diag2 % 2 == 0)
        {
            int numSame = 1;
            int diff = diag2 / 2;
            int mid = min(tr, bl) + diff;
            if (tm - mid == mid - bm)
            {
                numSame++;
            }
            if (ml - mid == mid - mr)
            {
                numSame++;
            }
            if (tl - mid == mid - br)
            {
                numSame++;
            }
            extra = max(extra, numSame);
        }

        int ans = initial + extra;
        //cout << "info: " << initial << " " << extra << endl;
        cout << "Case #" << run << ": " << ans << endl;
    }
}