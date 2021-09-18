#include <bits/stdc++.h>

using namespace std;

int main()
{
    //you can either use interators with struct.begin() or enhanced for loop for any of these

    set<long long> set;
    set.insert(1);
    int size = set.size();
    bool inSet = set.count(1);
    for (auto it = set.begin(); it != set.end(); it++)
    {
        cout << *it << endl;
    }
    set.erase(1); //removes value 1

    vector<int> vec;
    vec.push_back(1);
    vec.insert(vec.begin(), 5);
    size = vec.size();
    int val = vec.at(0);
    vec.erase(vec.begin() + 1); //removes 2nd value

    map<string, int> map;
    map.insert(make_pair("dog", 1));
    val = map.at("dog");
    size = map.size();
    bool inMap = map.count("dog");
    map.erase("dog");

    priority_queue<int> q; //first element is greatest
    q.push(1);
    q.push(2);
    size = q.size();
    int top = q.top(); //2
    q.pop();           //removes 2
}