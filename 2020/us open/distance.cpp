#include <bits/stdc++.h>

using namespace std;

long long n;
long long maxGrass = 0;

typedef pair<long long, long long> Interval;

vector<Interval> intervals;

bool works(long long d)
{
    long long numPlaced = 1;
    long long lastLoc = intervals.at(0).first;
    long long i = 0;
    while (i < intervals.size() && numPlaced < n)
    {
        Interval current = intervals.at(i);
        long long minLoc = lastLoc + d; //must be at this loc or further on
        if (minLoc <= current.second) //we can place next item somewhere in this interval
        {
            lastLoc = max(current.first, minLoc);
            numPlaced++;
        }
        else
        {
            i++;
        }
    }
    return numPlaced == n;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("socdist.in");
    ofstream output("socdist.out");

    long long m;
    input >> n >> m;

    while (m--)
    {
        long long a, b;
        input >> a >> b;

        maxGrass = max(maxGrass, b);
        intervals.push_back(make_pair(a, b));
    }
    sort(intervals.begin(), intervals.end());

    long long hi = (maxGrass / n) + 1;
    long long lo = 1;
    long long ans = -1;

    while (lo <= hi)
    {
        long long mid = (lo + hi) / 2;
        if (works(mid))
        {
            ans = mid;
            lo = mid + 1;
        }
        else
        {
            hi = mid - 1;
        }
    }
    output << ans << endl;
}