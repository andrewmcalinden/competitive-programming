#include <bits/stdc++.h>

using namespace std;
int main()
{
    cin.tie(0)->sync_with_stdio(0);

    ifstream input;
    input.open("5.in");

    int n;
    input >> n;

    string garbage;
    getline(input, garbage);

    pair<string, string> pairs[n];
    vector<string> originalOrder{"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
    for (int i = 0; i < n; i++)
    {
        string line;
        getline(input, line);
        stringstream linestream(line);

        string name1;
        linestream >> name1;

        auto rem = find(originalOrder.begin(), originalOrder.end(), name1);
        if (rem != originalOrder.end())
        {
            originalOrder.erase(rem);
        }

        string extra1;
        string extra2;
        string extra3;
        string extra4;
        linestream >> extra1 >> extra2 >> extra3 >> extra4;

        string name2;
        linestream >> name2;

        auto rem2 = find(originalOrder.begin(), originalOrder.end(), name2);
        if (rem2 != originalOrder.end())
        {
            originalOrder.erase(rem2);
        }

        if (name1.compare(name2) > 0)
        {
            swap(name1, name2);
        }
        pairs[i] = pair<string, string>{name1, name2};
    }
    input.close();

    set<string> specialCows;
    vector<vector<string>> output;
    for (pair<string, string> &p : pairs)
    {
        //p.first already in the set, 2 things are adjacent to it
        if (specialCows.count(p.first))
        {
            vector<string> fixed;

            string middle = p.first;
            string origAdjacent = p.second;
            string otherAdjacent;
            for (pair<string, string> &otherPair : pairs)
            {
                if (middle == otherPair.first && origAdjacent != otherPair.second)
                {
                    otherAdjacent = otherPair.second;
                    otherPair = pair<string, string>{"", ""};
                }
                else if (middle == otherPair.second)
                {
                    otherAdjacent = otherPair.first;
                    otherPair = pair<string, string>{"", ""};
                }
            }

            if (origAdjacent.compare(otherAdjacent) < 0)
            {
                fixed.push_back(origAdjacent);
                fixed.push_back(middle);
                fixed.push_back(otherAdjacent);
            }
            else
            {
                fixed.push_back(otherAdjacent);
                fixed.push_back(middle);
                fixed.push_back(origAdjacent);
            }

            int position = 0;
            while (position < output.size() && fixed.at(0) < output.at(position).at(0))
            {
                position++;
            }
            output.insert(output.begin() + position, fixed);
            p = pair<string, string>{"", ""};
        }

        //p.second already in set, 2 things adjacent
        else if (specialCows.count(p.second))
        {
            vector<string> fixed;

            string middle = p.second;
            string origAdjacent = p.first;
            string otherAdjacent;
            for (pair<string, string> &otherPair : pairs)
            {
                if (middle == otherPair.first && origAdjacent != otherPair.second)
                {
                    otherAdjacent = otherPair.second;
                    otherPair = pair<string, string>{"", ""};
                }
                else if (middle == otherPair.second)
                {
                    otherAdjacent = otherPair.first;
                    otherPair = pair<string, string>{"", ""};
                }
            }

            if (origAdjacent.compare(otherAdjacent) < 0)
            {
                fixed.push_back(origAdjacent);
                fixed.push_back(middle);
                fixed.push_back(otherAdjacent);
            }
            else
            {
                fixed.push_back(otherAdjacent);
                fixed.push_back(middle);
                fixed.push_back(origAdjacent);
            }
            int position = 0;
            while (position < output.size() && fixed.at(0) < output.at(position).at(0))
            {
                position++;
            }
            output.insert(output.begin() + position, fixed);
            p = pair<string, string>{"", ""};
        }

        //no duplicates in this pair, insert normally
        else
        {
            specialCows.insert(p.first);
            specialCows.insert(p.second);
        }
    }

    for (pair<string, string> &p : pairs)
    {
        if (p.first != "")
        {
            vector<string> fixed{p.first, p.second};
            int position = 0;
            while (position < output.size() && fixed.at(0) > output.at(position).at(0))
            {
                position++;
            }
            output.insert(output.begin() + position, fixed);
        }
    }

    vector<string> finalOutput;
    while (originalOrder.size() > 0 || output.size() > 0)
    {
        if (originalOrder.size() == 0)
        {
            for (string s : output.at(0))
            {
                finalOutput.push_back(s);
            }
            output.erase(output.begin());
            continue;
        }
        if (output.size() == 0)
        {
            finalOutput.push_back(originalOrder.at(0));
            originalOrder.erase(originalOrder.begin());
            continue;
        }

        string origOption = originalOrder.at(0);
        string fixedOption = output.at(0).at(0);

        if (fixedOption.compare(origOption) < 0)
        {
            for (string s : output.at(0))
            {
                finalOutput.push_back(s);
            }
            output.erase(output.begin());
        }
        else
        {
            finalOutput.push_back(origOption);
            originalOrder.erase(originalOrder.begin());
        }
    }

    ofstream outputFile;
    outputFile.open("lineup.out");
    for (string s : finalOutput)
    {
        cout << s << endl;
        outputFile << s << endl;
    }
    outputFile.close();
}