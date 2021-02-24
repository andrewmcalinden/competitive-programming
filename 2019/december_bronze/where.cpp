#include <bits/stdc++.h>

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);
    ifstream input;
    input.open("whereami.in");

    int n;
    input >> n;

    string street;
    input >> street;

    for (int len = 1; len <= n; len++)
    {
        set<string> set;
        for (int start = 0; start + len <= n; start++)
        {
            string s = street.substr(start, len);

            int sizeBefore = set.size();
            set.insert(s);
            int sizeAfter = set.size();

            if (sizeBefore == sizeAfter) //have duplicate, need larger length
            {
                cout << start << " " << len << endl;
                break;
            }

            if (start + len == n) //this length has no duplicates
            {
                ofstream output;
                output.open("whereami.out");
                output << len << endl;
                output.close();
                input.close();
                return 0;
            }
        }
    }
}