#include <bits/stdc++.h>

using namespace std;

int petals[101];

bool hasAvg(int i, int j)
{
    double sum = 0;
    for (int index = i; index <= j; ++index)
    {
        sum += petals[index];
    }

    double avg = sum / double(j - i + 1.0);
    if (avg != (int)avg)
    {
        return 0;
    }

    avg = (int)avg;
    for (int index = i; index <= j; ++index)
    {
        if (petals[index] == avg)
        {
            return 1;
        }
    }
    return 0;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int n;
    cin >> n;

    for (int i = 1; i < n + 1; ++i)
    {
        cin >> petals[i];
    }

    int total = 0;
    for (int i = 1; i <= n; ++i)
    {
        for (int j = i; j <= n; ++j)
        {
            if (i == j) //only 1 flower
            {
                ++total;
            }
            else
            {
                total += hasAvg(i, j);
            }
            //cout << i << " " << j << " " << hasAvg(i, j) << endl;
        }
    }
    cout << total << endl;
}