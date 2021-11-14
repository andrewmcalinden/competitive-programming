#include <bits/stdc++.h>

using namespace std;

string windows[] = {"01", "12", "23", "34", "45", "56", "67", "78", "89", "90"};
string rep[] = {"2", "3", "4", "5", "6", "7", "8", "9", "0", "1"};

set<int> modify2;
set<int> modify1;

string modifyString(string s, int step)
{
    set<int> check(modify2);
    for (const int &el : modify1)
    {
        check.insert(el - 1);
    }

    modify2.clear();
    modify2.insert(modify1.begin(), modify1.end());

    modify1.clear();
    for (int val : check)
    {
        //cout << "val: " << val << endl;
        if (val + 1 >= s.length() || val < 0)
        {
            continue;
        }
        string window = s.substr(val, 2);
        if (window == windows[step])
        {
            s = s.substr(0, val) + rep[step];
            if (val + 2 <= s.length() - 1)
            {
                s += s.substr(val + 2);
            } 
            modify1.insert(val);
        }
    }
    return s;
}

string modifyClean(string s, int step, bool remember)
{
    if (remember)
    {
        modify2.clear();
        modify2.insert(modify1.begin(), modify1.end());

        modify1.clear();
    }

    for (int i = 0; i < s.length() - 1; i++)
    {
        string window = s.substr(i, 2);
        if (window == windows[step])
        {
            s = s.substr(0, i) + rep[step] + s.substr(i + 2);
            if (remember)
            {
                modify1.insert(i);
            }
        }
    }
    return s;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int n;
        cin >> n;

        string s;
        cin >> s;

        //check every index for the first pass
        for (int i = 0; i < 8; i++)
        {
            s = modifyClean(s, i, false);
        }

        //remember which indices were changed by steps 8 and 9, they 
        for (int i = 8; i < 10; i++)
        {
            s = modifyClean(s, i, true);
        }

        //cout << "got here" << endl;

        int step = 0;
        while (s != modifyString(s, step))
        {
            step++;
            if (step == 10)
            {
                step = 0;
            }
            cout << s << endl;
        }
        cout << "Case #" << run << ": " << s << endl;
    }
}