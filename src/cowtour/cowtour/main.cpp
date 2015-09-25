/*
 ID: xiaoyun4
 PROG: cowtour
 LANG: C++
 */

#include <iostream>
#include <vector>
#include <fstream>
#include <algorithm>
//#include <istream>
#include <string>

using namespace std;

class object {
public:
    int first;
    int second;
    vector<int> indexes;
};


int connect(vector<object> x){
    return 0;
}


int main(int argc, const char * argv[]) {
    // insert code here...
    //cout<<"yo \n";
    ofstream fout ("ttwo.out");
    //fout<< "yo";
    //fout.cose();
    
    ifstream fin ("ttwo.in");
    vector<object> pastures;
    
    int k;
    fin>>k;
    
    for(int i = 0; i<k;i++){
        int x, y;
        object k;
        fin>>x>>y;
        k.first = x;
        k.second = y;
        pastures.push_back(k);
    }
    
    
    fout.close();
    
    return 0;
}