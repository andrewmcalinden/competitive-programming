#include <bits/stdc++.h>

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("word.in");
    ofstream output("word.out");

    int n, k;
    input >> n >> k;

    int lineLength = 0;
    bool go = 0;
    while (n--)
    {
        string word;
        input >> word;

        int length = word.length();
        if (lineLength + length > k)
        {
            output << endl << word;
            lineLength = length;
        }
        else
        {
            cout << lineLength + length << " " << k << endl;
            if (go)
            {
                output << " ";
            }
            else
            {
                go = 1;
            }
            output << word;
            lineLength += length;
        }
    }
}