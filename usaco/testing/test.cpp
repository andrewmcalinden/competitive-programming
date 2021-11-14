#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> Point;
int main()
{
    Point points[4];
    points[0] = make_pair(5, 3);
    points[1] = make_pair(5, 4);
    points[2] = make_pair(2, 3);
    points[3] = make_pair(1, 3);

    for (Point p : points)
    {
        cout << p.first << " " << p.second << endl;
    }
    cout << endl;

    sort(points, points + 3);

    for (Point p : points)
    {
        cout << p.first << " " << p.second << endl;
    }
    cout << endl;
}