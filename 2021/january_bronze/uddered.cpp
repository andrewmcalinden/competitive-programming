#include <bits/stdc++.h>

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);

    string alpha, text;
    cin >> alpha >> text;

    string first = text.substr(0, 1);
    int pastLoc = alpha.find(first);

    int count = 1;
    int currentLoc;
    for (int i = 1; i < text.length(); i++)
    {
        string current = text.substr(i, 1);
        currentLoc = alpha.find(current);

        if (currentLoc <= pastLoc) //in new alphabet
        {
            count++;
        }
        pastLoc = currentLoc;
    }

    cout << count << endl;
}