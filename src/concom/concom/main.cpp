/*
 ID: xiaoyun4
 PROG: concom
 LANG: C++
 */

#include <iostream>
#include <vector>
#include <fstream>
#include <algorithm>
//#include <istream>

using namespace std;

class company {
    public:
    int num;
    vector<company*> othercomps;
    vector<int> percent;
    vector<int> owned;
};

vector<int> get(company* x){
    if(x->othercomps.size()==0){
        return *new vector<int>(0);
    }
    
    for(int i = 0; i<x->othercomps.size();i++){
        if(x->percent[i]>50){
            
            
        }
        
        vector<int> stuff = get(x->othercomps[i]);
        for(int i = 0; i<stuff.size();i++){
            x->owned.push_back(stuff[i]);
        }
        
    }
    
    return x->owned;
    
}

void tryget(company* x){
    if(x->othercomps.size()==0){
        return;
    }
    
    for(int i = 0; i<x->othercomps.size();i++){
        if(x->percent[i]>50){
            x->owned.push_back(x->othercomps[i]->num);
            x->percent.erase(x->percent.begin()+i-1);
            x->othercomps.erase(x->othercomps.begin()+i-1);
        }
        tryget(x->othercomps[i]);
        
    }
    
}


int main(int argc, const char * argv[]) {
    // insert code here...
    //cout<<"yo \n";
    ofstream fout ("money.out");
    //fout<< "yo";
    //fout.close();
    
    ifstream fin ("money.in");
    //fout<<"yo"<<"\n";
    //fout.close();
    //cout<<"yo";
    
    int k;
    fin>>k;
    for(int i = 0; i<k;i++){
        
    }
    

    fout.close();
    
    
    
    return 0;
}

