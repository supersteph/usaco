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
    object(){
        first = 0;
        second = 0;
    }
};

object newobj(int first, int second){
    object n;
    n.first = first;
    n.second = second;
    return n;
}

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
    int k;
    fin>>k;
    vector<object> coord (k,*new object());
    vector<vector<int>> stuff;
    
    
    for(int i = 0; i<k;i++){
        int x, y;
        object k;
        fin>>x>>y;
        k.first = x;
        k.second = y;
        coord.push_back(k);
    }
    
    
    fout.close();
    
    return 0;
}