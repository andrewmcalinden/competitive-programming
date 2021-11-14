#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> Point;

vector<Point> xSorted[20001];
vector<Point> ySorted[20001];

#define MOD 1000000007

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("triangles.in");
    ofstream output("triangles.out");

    int n;
    input >> n;

    Point points[n];
    for (int i = 0; i < n; i++)
    {
        int x, y;
        input >> x >> y;

        x += 10000;
        y += 10000;

        Point p = make_pair(x, y);
        xSorted[x].push_back(p);
        ySorted[y].push_back(p);
        points[i] = p;
    }
    
    long long totalArea = 0;
    for (Point &p : points)
    {
        int x = p.first;
        int y = p.second;
        if (xSorted[x].size() == 0 || ySorted[y].size() == 0) continue;
        
        for (int i = 0; i < xSorted[x].size(); i++)
        {
            Point p2 = xSorted[x].at(i);
            if (p2.second != y)
            {
                for (int j = 0; j < ySorted[y].size(); j++)
                {
                    Point p3 = ySorted[y].at(j);
                    if (p3.first != x)
                    {
                        long long area = (abs(y - p2.second) * abs(x - p3.first)) % MOD;
                        totalArea  = (totalArea + area) % MOD;
                        //cout << x << " " << y << "\t" << p2.first << " " << p2.second
                             //<< "\t" << p3.first << " " << p3.second << endl;
                    }
                }
            }
            
        }
    }
    output << totalArea << endl;
}