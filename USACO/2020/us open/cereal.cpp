#include <bits/stdc++.h>

bool cereal[100001];
int n, m;

typedef std::pair<int, int> Cow;

Cow cows[100001];

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("cereal.in");
    ofstream output("cereal.out");

    int n, m;
    input >> n >> m;

    for (int i = 1; i < n + 1; i++)
    {
        int c1, c2;
        input >> c1 >> c2;
        cows[i] = make_pair(c1, c2);
    }

    for (int start = 1; start <= n; start++)
    {
        fill(begin(cereal) + 1, begin(cereal) + m + 1, 1);
        int count = 0;
        for (int i = start; i <= n; i++)
        {
            Cow current = cows[i];
            if (cereal[current.first])
            {
                cereal[current.first] = 0;
                count++;
            }
            else if(cereal[current.second])
            {
                cereal[current.second] = 0;
                count++;
            }
        }
        output << count << endl;
    }
}