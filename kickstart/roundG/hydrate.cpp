#include <bits/stdc++.h>

using namespace std;

int main()
{
    cin.tie(0)->sync_with_stdio(0);

    int t;
    cin >> t;

    //ofstream output("out.txt");
    for (int run = 1; run <= t; run++)
    {
        int k;
        cin >> k;

        map<int, int> startX;
        map<int, int> endX;

        map<int, int> startY;
        map<int, int> endY;

        for (int i = 0; i < k; i++)
        {
            int x1, y1, x2, y2;
            cin >> x1 >> y1 >> x2 >> y2;

            if (startX.count(x1))
            {
                startX.at(x1)++;
            }
            else
            {
                startX.insert(make_pair(x1, 1));
            }

            if (endX.count(x2))
            {
                endX.at(x2)++;
            }
            else
            {
                endX.insert(make_pair(x2, 1));
            }

            if (startY.count(y1))
            {
                startY.at(y1)++;
            }
            else
            {
                startY.insert(make_pair(y1, 1));
            }

            if (endY.count(y2))
            {
                endY.at(y2)++;
            }
            else
            {
                endY.insert(make_pair(y2, 1));
            }
        }

        auto startPairX = startX.begin();
        auto endPairX = endX.begin();

        int onThisX = 0;
        long long left = 0;
        long long right = 1;

        int ansX = -1;
        while (right - left > 0)
        {
            if (startPairX->first < endPairX->first)
            {
                ansX = startPairX->first;
                startPairX++;
            }
            else if (startPairX->first > endPairX->first)
            {
                ansX = endPairX->first;
                endPairX++;
            }
            else
            {
                ansX = endPairX->first;
                endPairX++;
                startPairX++;
            }

            int numStart = 0;
            int numEnd = 0;
            if (startX.count(ansX))
            {
                numStart = startX.at(ansX);
            }
            if (endX.count(ansX))
            {
                numEnd = endX.at(ansX);
            }

            onThisX += (numStart - numEnd);
            left += numEnd;
            right = k - onThisX - left;

            // cout << "ansX: " << ansX << endl;
            // cout << "start: " << numStart << endl;
            // cout << "end: " << numEnd << endl;
            // cout << "on: " << onThisX << endl;
            // cout << "left: " << left << endl;
            // cout << "right: " << right << endl;
            // cout << endl;
        }

        auto startPairY = startY.begin();
        auto endPairY = endY.begin();

        int onThisY = 0;
        left = 0;
        right = 1;

        int ansY = -1;
        while (right - left > 0)
        {
            if (startPairY->first < endPairY->first)
            {
                ansY = startPairY->first;
                startPairY++;
            }
            else if (startPairY->first > endPairY->first)
            {
                ansY = endPairY->first;
                endPairY++;
            }
            else
            {
                ansY = endPairY->first;
                endPairY++;
                startPairY++;
            }

            int numStart = 0;
            int numEnd = 0;
            if (startY.count(ansY))
            {
                numStart = startY.at(ansY);
            }
            if (endY.count(ansY))
            {
                numEnd = endY.at(ansY);
            }

            onThisY += (numStart - numEnd);
            left += numEnd;
            right = k - onThisY - left;

            // cout << "ansY: " << ansY << endl;
            // cout << "start: " << numStart << endl;
            // cout << "end: " << numEnd << endl;
            // cout << "on: " << onThisY << endl;
            // cout << "left: " << left << endl;
            // cout << "right: " << right << endl;
            // cout << endl;
        }

        cout << "Case #" << run << ": " << ansX << " " << ansY << endl;
    }
    //output.close();
}