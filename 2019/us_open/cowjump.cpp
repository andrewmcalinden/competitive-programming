#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

struct Hurdle
{
    ll x1;
    ll y1;
    ll x2;
    ll y2;
};

//maybe a problem with accuracy of double
bool intersect(Hurdle &h1, Hurdle &h2)
{
    if (h1.x1 - h1.x2 == 0 && h2.x1 - h2.x2 == 0)
    {
        return h1.x1 == h2.x1;
    }
    else if (h1.x1 - h1.x2 == 0)
    {
        double slope2 = (h2.y2 - h2.y1) / (h2.x2 - h2.x1);
        ll yInt = (slope2 * (h1.x1 - h2.x1) + h2.y1);

        ll minY = min(h1.y1, h1.y2);
        ll maxY = max(h1.y1, h1.y2);

        return (yInt >= minY && yInt <= maxY);
    }
    else if (h2.x1 - h2.x2 == 0)
    {
        double slope2 = (h1.y2 - h1.y1) / (h1.x2 - h1.x1);
        ll yInt = (slope2 * (h2.x1 - h1.x1) + h1.y1);

        ll minY = min(h2.y1, h2.y2);
        ll maxY = max(h2.y1, h2.y2);

        return (yInt >= minY && yInt <= maxY);
    }

    double slope1 = (h1.y2 - h1.y1) / (h1.x2 - h1.x1);
    double slope2 = (h2.y2 - h2.y1) / (h2.x2 - h2.x1);

    double rightConstant1 = slope1 * -h1.x1;
    double rightConstant2 = slope2 * -h2.x1;

    //after subtraction
    double leftConstant = -h1.y1 + h2.y1;
    double xCoeff = slope1 - slope2;
    double rightConstant = rightConstant1 - rightConstant2;

    //x value of intersection if segments were infinite
    double xInt = (leftConstant - rightConstant) / xCoeff;
    double yInt = (slope1 * xInt) + rightConstant1 + h1.y1;

    xInt = ceil(xInt * 10000.0) / 10000.0;
    yInt = ceil(yInt * 10000.0) / 10000.0;
    cout << xInt << " " << yInt << endl;

    ll maxX = max({h1.x1, h1.x2, h2.x1, h2.x2});
    ll minX = min({h1.x1, h1.x2, h2.x1, h2.x2});

    ll maxY = max({h1.y1, h1.y2, h2.y1, h2.y2});
    ll minY = min({h1.y1, h1.y2, h2.y1, h2.y2});

    //wrong, needs to be within bounds of both lines, not their bounding box
    return (xInt >= minX && xInt <= maxX) && (yInt >= minY && yInt <= maxY);
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("cowjump.in");
    ofstream output("cowjump.out");

    int n;
    input >> n;

    Hurdle hurdles[n];
    for (int i = 0; i < n; i++)
    {
        input >> hurdles[i].x1 >> hurdles[i].y1 >> hurdles[i].x2 >> hurdles[i].y2;
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (intersect(hurdles[i], hurdles[j]))
            {
                cout << "gottem: " << i << " " << j << endl;
                int numInt = 0;
                cout << "others: ";
                for (int p = 0; p < n; p++)
                {
                    if (intersect(hurdles[i], hurdles[p]))
                    {
                        numInt++;
                        cout << p << " ";
                        if (numInt > 1)
                        {
                            output << i + 1;
                            return 0;
                        }
                    }
                }
                cout << endl;
                output << j + 1;
                return 0;
            }
        }
    }
}