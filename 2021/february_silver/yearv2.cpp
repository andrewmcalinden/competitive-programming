#include <bits/stdc++.h>

using namespace std;

int n, k;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    cin >> n >> k;
    vector<int> years;
    int maxYear = 0;
    int minYear = INT_MAX;
    for (int i = 0; i < n; i++)
    {
        int year;
        cin >> year;
        years.push_back(year);

        minYear = min(year, minYear);
        maxYear = max(maxYear, year);
    }
    //cout << minYear << " " << maxYear << endl;

    int realStart = floor(minYear / 12.0) * 12;
    int realEnd = ceil(maxYear / 12.0) * 12;
    //cout << realEnd << " " << realStart << endl;
    for (int i = realStart; i <= realEnd; i += 12)
    {
        years.push_back(i);
    }
    sort(years.begin(), years.end());
    reverse(years.begin(), years.end());

    // for (int el : years)
    // {
    //     cout << el << " ";
    // }
    // cout << endl;

    int start = years.at(0);
    int total = 0;
    for (int i = 1; i < years.size() - 1; i++) //make sure to visit years of the ox (if they are repeated)
    {
        if (years.at(i) % 12 == 0)
        {
            if (years.at(i) != years.at(i + 1)) //this is a portal year, not a year we need to visit
            {
                int j = i + 1;
                int naturalEnd = years.at(i);
                while (years.at(j) % 12 == 0)
                {
                    j++;
                }

                if (j != i + 1) //we want to portal
                {
                    int numYears = start - naturalEnd; //years spent naturally
                    //cout << start << " " << naturalEnd << endl;

                    start = years.at(j - 1);
                    i = j;
                    total += numYears;
                }
            }
        }
        if (i == years.size() - 2)
        {
            total += start - years.at(years.size() - 1);
        }
    }
    cout << total << endl;
}