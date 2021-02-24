#include <bits/stdc++.h>

using namespace std;

int cows[101];
int n;

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

bool areEqual(int other[])
{
    for (int i = 0; i < n; i++)
    {
        if (cows[i] != other[i])
        {
            return false;
        }
    }
    return true;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("swap.in");

    int k, a1, a2, b1, b2;
    input >> n >> k >> a1 >> a2 >> b1 >> b2;

    int orig[n];
    for (int i = 1; i <= n; i++)
    {
        cows[i] = i;
        orig[i] = i;
    }

    int numBeforeSame = 0;
    while(!areEqual(orig))
    {
        reverse(a1, a2, cows);
        reverse(b1, b2, cows);
        numBeforeSame++;

        if (numBeforeSame == k)
        {
            numBeforeSame = INT_MAX;
            break;
        }
    }
    cout << numBeforeSame << endl;

    int repeat = k % numBeforeSame;
    cout << repeat << endl;

    while (repeat--)
    {
        reverse(a1, a2, orig);
        reverse(b1, b2, orig);
    }

    ofstream output("swap.out");
    for (int i = 1; i <= n; i++)
    {
        std::cout << orig[i] << std::endl;
        output << orig[i] << endl;
    }
}