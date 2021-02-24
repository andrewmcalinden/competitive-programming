#include <bits/stdc++.h>

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);

    vector<int> values;
    int i = 7;
    while(i--)
    {
        int val;
        cin >> val;
        values.push_back(val);
    }

    sort(values.begin(), values.end());

    int a = values.at(0);
    int abc = values.at(values.size() - 1); //a + b + c
    int bc = abc - a;
    int ac = values.at(values.size() - 3);
    int c = ac - a;
    int b = abc - a - c;
    cout << a << " " << b << " " << c << endl;
}