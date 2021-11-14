#include <bits/stdc++.h>

#define MAX 2000000

using namespace std;

int main()
{
    vector<long long> primes; //will contain values from 2 to MAX - 1
    for (long long i = 2; i < MAX; i++)
    {
        primes.push_back(i);
    }

    long long size = primes.size();
    bool marked[size] = {0}; //to mark numbers, we will change the index of this array to a 1

    //find first non marked value greater than start
    for (long long j = 0; j < size; j++)
    {
        if (!(marked[j]))
        {
            long long p = primes.at(j);
            //p*p is at index p*p - 2
            for (long long k = p * p - 2; k < size; k += p)
            {
                marked[k] = 1;
            }
        }
    }

    long long sum = 0;
    for (long long i = 0; i < size; i++)
    {
        if (!marked[i])
        {
            sum += primes.at(i);
        }
    }
    cout << sum << endl;
}