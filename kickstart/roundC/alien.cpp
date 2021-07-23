using namespace std;
#include<bits/stdc++.h>

int main()
{
    int t;
    cin >> t;
    ofstream output("out.txt");
    for (int run = 1; run <= t; run++) {
        long long g;
        cin >> g;

        set<long long> solutions;
        for (long long day = 1; day < g; day++){
            long long extra = (day * (day - 1)) / 2;
            if (extra >= g){
                break;
            }
            double numNeeded = g - extra;
            double kNeeded = numNeeded / day;
            if (kNeeded == floor(kNeeded)){
                long long realK = (long long)kNeeded;
                solutions.insert(realK); 
            }
        }
        long ans = solutions.size();
        output << "Case #" << run << ": " << ans << endl;
    }
    return 0;
}