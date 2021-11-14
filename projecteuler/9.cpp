#include <bits/stdc++.h>
#define EPSILON 10e-6

using namespace std;

bool approxEquals(double num1, double num2)
{
    return (fabs(num1 - num2) < EPSILON);
}

int main()
{
    int leg1 = 1;
    while (leg1 < 1000)
    {
        int leg2 = 1;
        while (leg2 + leg1 < 1000)
        {
            double leg3 = sqrt((leg1 * leg1) + (leg2 * leg2));
            if (approxEquals(leg1 + leg2 + leg3, 1000.0))
            {
                cout << leg1 << " " << leg2 << " " << leg3 << endl;
                return 0;
            }
            leg2++;
        }
        leg1++;
        //cout << leg1 << " " << flush;
    }
}