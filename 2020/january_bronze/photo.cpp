#include <bits/stdc++.h>

using namespace std;

int n;

bool isValid(vector<int> perm)
{
    set<int> els;
    for (int i = 0; i < n; i++)
    {
        int el = perm.at(i);
        if (els.count(el) || el > n || el < 1)
        {
            return false;
        }
        els.insert(el);
    }
    return true;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("photo.in");
    ofstream output("photo.out");

    input >> n;

    int bSequence[n-1];
    for (int loop = 0; loop < n; loop++)
    {
        input >> bSequence[loop]; 
    }

    for (int shift = bSequence[0] - 1; shift >= 1; shift--)
    {
        vector<int> perm;

        int start = bSequence[0];
        int first = start - shift;
        int second = shift;

        perm.push_back(first);
        perm.push_back(second);

        for (int i = 1; i < n - 1; i++)
        {
            int current = bSequence[i];
            int next = current - perm.at(perm.size() - 1);
            perm.push_back(next);
        }

        if (isValid(perm))
        {
            for (int i = 0; i < perm.size() - 1; i++)
            {
                output << perm.at(i) << " ";
            }
            output << perm.at(perm.size() - 1);
            return 0;
        }
    }
}