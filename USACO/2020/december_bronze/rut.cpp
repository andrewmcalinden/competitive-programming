#include <bits/stdc++.h> //doesnt work

using namespace std;

struct Cow
{
    int x;
    int y;
    string type;
    bool stopped;
    int timeStopped;
};

void findInfinite(Cow cows[], string outputs[], int n);
void move(Cow cows[], int numMoves);
tuple<int, bool, bool> intersect(Cow &cow1, Cow &cow2);

int n;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    cin >> n;
    Cow cows[n];

    for (int i = 0; i < n; i++)
    {
        string type;
        int x;
        int y;
        cin >> type >> x >> y;
        cows[i] = Cow{x, y, type, 0, INT_MAX};
    }

    int currentTime = 0;

    for (int runs = 0; runs < n; runs++)
    {
        int min = INT_MAX;
        int loc1 = 0;
        int loc2 = 0;
        bool cow1stopped = 0;
        bool cow2stopped = 0;

        for (int i = 0; i < n - 1; i++)
        {
            Cow cow1 = cows[i];
            if (cow1.stopped)
                continue;

            for (int j = i + 1; j < n; j++)
            {
                Cow cow2 = cows[j];
                if (cow2.stopped)
                    continue;

                tuple<int, bool, bool> intersectInfo = intersect(cow1, cow2);
                int numStop = get<1>(intersectInfo) + get<2>(intersectInfo);

                if (get<0>(intersectInfo) <= min && numStop > 0)
                {
                    min = get<0>(intersectInfo);
                    loc1 = i;
                    loc2 = i + 1;
                    cow1stopped = get<1>(intersectInfo);
                    cow2stopped = get<2>(intersectInfo);
                }
            }
        }
        cout << "min: " << min;
        move(cows, min);
        currentTime += min;

        if (cow1stopped)
        {
            cout << "\tstoppedCow: " << loc1 << "\tintersectedWith: " << loc2 << endl;
            cows[loc1].stopped = 1;
            cows[loc1].timeStopped = currentTime;
        }
        if (cow2stopped)
        {
            cout << "\tstoppedCow: " << loc2 << "\tintersectedWith: " << loc1 << endl;
            cows[loc2].stopped = 1;
            cows[loc2].timeStopped = currentTime;
        }
        //if nothing stopped, all else is infinite
    }

    for (Cow &c : cows)
    {
        cout << c.timeStopped << endl;
    }
}

void move(Cow cows[], int numMoves)
{
    for (int j = 0; j < numMoves; j++)
    {
        for (int i = 0; i < n; i++)
        {
            if (!(cows[i].stopped))
            {
                if (cows[i].type == "N")
                {
                    cows[i].y++;
                }
                else
                {
                    cows[i].x++;
                }
            }
        }
    }
}

tuple<int, bool, bool> intersect(Cow &cow1, Cow &cow2)
{
    string t1 = cow1.type;
    string t2 = cow2.type;

    if (t1 == "N" && t2 == "N")
    {
        if (cow1.x == cow2.x)
        {
            bool cow1stopped;
            if (cow1.y < cow2.y)
            {
                cow1stopped = 1;
            }
            else
            {
                cow1stopped = 0;
            }
            return tuple<int, bool, bool>(abs(cow1.y - cow2.y), cow1stopped, !cow1stopped);
        }
        return tuple<int, bool, bool>(INT_MAX, 0, 0);
    }
    else if (t1 == "E" && t2 == "E")
    {
        if (cow1.y == cow2.y)
        {
            bool cow1stopped;
            if (cow1.x < cow2.x)
            {
                cow1stopped = 1;
            }
            else
            {
                cow1stopped = 0;
            }
            return tuple<int, bool, bool>(abs(cow1.x - cow2.x), cow1stopped, !cow1stopped);
        }
        return tuple<int, bool, bool>(INT_MAX, 0, 0);
    }
    else
    {
        int xDiff = abs(cow1.x - cow2.x);
        int yDiff = abs(cow1.y - cow2.y);

        if (cow1.type == "N")
        {
            if (cow2.y < cow1.y || cow2.x > cow1.x)
            {
                return tuple<int, bool, bool>(INT_MAX, 0, 0);
            }

            bool cow1stopped;
            bool cow2stopped;
            if (xDiff > yDiff)
            {
                cow1stopped = 0;
                cow2stopped = 1;
            }
            else if (yDiff > xDiff)
            {
                cow1stopped = 1;
                cow2stopped = 0;
            }
            else
            {
                cow1stopped = 0;
                cow2stopped = 0;
            }
            return tuple<int, bool, bool>(max(xDiff, yDiff), cow1stopped, cow2stopped);
        }
        else
        {
            if (cow2.x < cow1.x || cow2.y > cow1.y)
            {
                return tuple<int, bool, bool>(INT_MAX, 0, 0);
            }

            bool cow1stopped;
            bool cow2stopped;
            if (xDiff > yDiff)
            {
                cow1stopped = 1;
                cow2stopped = 0;
            }
            else if (yDiff > xDiff)
            {
                cow1stopped = 0;
                cow2stopped = 1;
            }
            else
            {
                cow1stopped = 0;
                cow2stopped = 0;
            }
            return tuple<int, bool, bool>(max(xDiff, yDiff), cow1stopped, cow2stopped);
        }
    }
}

void findInfinite(Cow cows[], string outputs[], int n)
{
    //find infinite cows
    int minNY = INT_MAX; //lowest ncow
    int maxNX = 0;       //rightmost ncow

    int maxEY = 0;       //highest ecow
    int minEX = INT_MAX; //leftmost ecow
    for (int i = 0; i < n; i++)
    {
        if (cows[i].type == "N")
        {
            if (cows[i].y < minNY)
            {
                minNY = cows[i].y;
            }
            if (cows[i].x > maxNX)
            {
                maxNX = cows[i].x;
            }
        }
        else
        {
            if (cows[i].y > maxEY)
            {
                maxEY = cows[i].y;
            }
            if (cows[i].x < minEX)
            {
                minEX = cows[i].x;
            }
        }
    }

    cout << minNY << " " << maxNX << " " << maxEY << " " << minEX << endl;

    for (int i = 0; i < n; i++)
    {
        if (cows[i].type == "E")
        {
            if (cows[i].y < minNY || cows[i].x > maxNX)
            {
                outputs[i] = "Infinite";
                cout << "got1" << endl;
            }
        }
        else
        {
            if (cows[i].y > maxEY || cows[i].x < minEX)
            {
                outputs[i] = "Infinite";
            }
        }
    }
}