#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    for (int run = 1; run <= t; run++)
    {
        int r, c;
        cin >> r >> c;

        cout << "Case #" << run << ": " << endl;

        cout << "..+";
        for (int i = 1; i < c; i++)
        {
            cout << "-+";
        }
        cout << endl;

        cout << "..|";
        for (int i = 1; i < c; i++)
        {
            cout << ".|";
        }
        cout << endl;

        for (int i = 1; i < r; i++)
        {
            cout << "+";
            for (int j = 0; j < c; j++)
            {
                cout << "-+";
            }
            cout << endl;

            cout << "|";
            for (int j = 0; j < c; j++)
            {
                cout << ".|";
            }
            cout << endl;
        }
        cout << "+";
        for (int j = 0; j < c; j++)
        {
            cout << "-+";
        }
        cout << endl;
    }
}
