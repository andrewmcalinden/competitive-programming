#include <bits/stdc++.h>

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input("race.in");

    int k, n;
    input >> k >> n;

    for (int loop = 0; loop < n; loop++)
    {
        int x;
        input >> x;

        int speed = 0;
        int distRemaining = k;
        int count = 0;
        while (distRemaining > 0)
        {
            int stepsNeededIfAccel = abs(speed + 1 - x);
            int distanceNeededIfAccel = 0;

            int currentSpeed = speed + 1;
            int i = 0;
            while (i++ < stepsNeededIfAccel)
            {
                distanceNeededIfAccel += currentSpeed--;
            }

            if (distanceNeededIfAccel <= distRemaining)
            {
                speed++;
                std::cout << "acceled: " << distanceNeededIfAccel << " " << distRemaining << " " << speed << endl;
            }
            else
            {
                int stepsNeededAtSameSpeed = abs(speed - x);
                int distanceNeededAtSameSpeed = 0;

                int currentSpeed = speed;
                int i = 0;
                while (i++ < stepsNeededAtSameSpeed)
                {
                    distanceNeededAtSameSpeed += currentSpeed--;
                }
                if (distanceNeededAtSameSpeed > distRemaining)
                {
                    speed--;
                    std::cout << "slowed: " << distanceNeededAtSameSpeed << " " << distRemaining << " " << speed << endl;
                }
                else
                {
                    std::cout << "same speed: " << distanceNeededAtSameSpeed << " " << distRemaining << " " << speed << endl;
                }
            }
            distRemaining -= speed;
            count++;
        }
        std::cout << count << endl;
    }
}