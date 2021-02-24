#include <bits/stdc++.h>

using namespace std;

vector<int> evens;
vector<int> odds;

bool makeEvenGroup()
{
    if (!evens.empty())
    {
        //cout << "took 1 from evens for even" << endl;
        evens.erase(evens.begin());
        return 1;
    }
    else
    {
        if (odds.size() >= 2)
        {
            //cout << "took 2 from odds for even" << endl;
            odds.erase(odds.begin(), odds.begin() + 2);
            return 1;
        }
        //cout << "couldnt make even" << endl;
        return 0;
    }
}

bool makeOddGroup()
{
    if (!odds.empty())
    {
        //cout << "took 1 from odds for odd" << endl;
        odds.erase(odds.begin());
        return 1;
    }
    //cout << "couldnt make odd" << endl;
    return 0;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        int num;
        cin >> num;

        if (num % 2 == 0)
        {
            evens.push_back(num);
        }
        else
        {
            odds.push_back(num);
        }
    }

    if (n == 2)
    {
        if (evens.size() > 0 && odds.size() > 0)
        {
            cout << 2 << endl;
            return 0;
        }
        else
        {
            cout << 1 << endl;
            return 0;
        }
    }

    int count = 0;
    bool stopEven = 0;
    bool stopOdd = 0;

    bool stop = 0;
    while (true)
    {
        if (makeEvenGroup())
        {
            count++;
        }
        else //can't make even but need even, evens is empty and 1 odd left
        {
            if (odds.size() == 0)
            {
                goto end;
                break;
            }
            //put the last odd number and the last solo odd group into a group with another odd
            //now a group with 3 odds, which is still odd
            //decreases count by 1
            count--;
            break; //all elements are gone
        }

        if (makeOddGroup())
        {
            count++;
        }
        else //odds is empty, distribute remaining evens to any number of groups, they wont change the even/oddness
        {
            break;
        }

        // for (int el : evens)
        // {
        //     cout << el << " ";
        // }
        // cout << endl;

        // for (int el : odds)
        // {
        //     cout << el << " ";
        // }
        // cout << endl;
    }
    end:
    cout << max(1, count) << endl;
}