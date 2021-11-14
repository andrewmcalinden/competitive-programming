#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    vector<int> primes = {2, 3, 5, 7, 11, 13};
    int c = 14;
    while(primes.at(primes.size() - 1) < 2000000)
    {
        bool passed = 1;
        for (int prime : primes)
        {
            if (c % prime == 0)
            {
                passed = 0;
                break;
            }
        }

        if (passed)
        {
            primes.push_back(c);
        }
        c++;
        //cout << c << endl;
    }
    primes.erase(primes.end() - 1);

    long long sum = 0;
    for (int prime : primes)
    {
        sum += prime;
    }
    cout << sum << endl;
}