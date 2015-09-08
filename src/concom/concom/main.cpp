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
    bool touched;
    vector<int> othercomps;
    vector<int> percent;
    vector<int> owned;
    company (int k){
        num = k;
        touched = false;
    }
    company(const company& c)
    : num(c.num), touched(c.touched),
    othercomps(c.othercomps), percent(c.percent), owned(c.owned) {}
};

bool myfunc(const company& s, const company& k){
    return s.num<k.num;
}

int getindex(const company& x, int k){
    for(int i = 0; i < x.percent.size();i++){
        if(x.othercomps[i]==k){
            return i;
        }
    }
    return -1;
}

int getcomp(const vector<company>& n, int num){
    for(int i = 0; i< n.size();i++){
        if(n[i].num==num){
            return i;
        }
    }
    return -1;
}

bool inowned(const company& n, int s){
    for (int i = 0; i< n.owned.size(); i++) {
        if(n.owned[i]==s){
            return true;
        }
    }
    return false;
}


void tryto(vector<company> & x , int k){
    
    if(k==0){
        
    
    }
    if(x[k].touched==true){
        return;
    }
    x[k].touched = true;
    
    for(int i = 0; i<x[k].othercomps.size();i++){
        
        if(k==0&&x[k].othercomps[i]==45){
            
        }
        
        if(x[k].percent[i]>100){
            cout<<"trouble yo";
        }
        if(x[k].percent[i]>50){
            x[k].owned.push_back(x[k].othercomps[i]);
            //x[k].percent.erase(x[k].percent.begin()+i+1);
            //x[k].othercomps.erase(x[k].othercomps.begin()+i+1);
        } else{
            continue;
        }
        
        
        int l = getcomp(x, x[k].othercomps[i]);
        if(l==-1){
            //cout<<"trouble";
            continue;
        }
        tryto(x, l);
        
        //cout<< k <<" "<< i << "\n";
        
        if(x[k].percent[i]>50){
            
            for(int j = 0; j< x[l].percent.size();j++){
                int s = getindex(x[k], x[l].othercomps[j]);
                if(s==-1){
                    x[k].othercomps.push_back(x[l].othercomps[j]);
                    x[k].percent.push_back(x[l].percent[j]);
                }else {
                    int sum = x[l].percent[j]+x[k].percent[s];
                    if(i>j&&sum>50){
                        x[k].owned.push_back(x[l].othercomps[j]);
                    }else {
                        x[k].percent[s] = sum;
                    }
                    
                }
            }
        }
    }
}


int main(int argc, const char * argv[]) {
    // insert code here...
    //cout<<"yo \n";
    ofstream fout ("concom.out");
    //fout<< "yo";
    //fout.close();
    
    ifstream fin ("concom.in");
    
    
    //fout<<"yo"<<"\n";
    //fout.close();
    //cout<<"yo";
    
    int k;
    fin>>k;
    //cout<<k << "\n";
    vector<company> n;
    for(int i = 0; i<k;i++){
        int first;
        int second;
        int percent;
        fin>>first>>second>>percent;
        int s = getcomp(n, first);
        if(s==-1){
            n.push_back(company(first));
            
            n[n.size()-1].othercomps.push_back(second);
            n[n.size()-1].percent.push_back(percent);
        }else{
            n[s].othercomps.push_back(second);
            n[s].percent.push_back(percent);
        }
        
    }
    cout<<n.size();
    for(int i = 0; i< n.size();i++){
        tryto(n, i);
    }
    
    sort(n.begin(),n.end(),myfunc);
    
    for(int i = 0; i<n.size();i++){
        sort(n[i].owned.begin(), n[i].owned.end());
        for(int j = 0;j<n[i].owned.size();j++){
            fout<<n[i].num<<" "<<n[i].owned[j]<< "\n";
            cout<<n[i].num<<" "<<n[i].owned[j] << "\n";
        }
    }
    
    fout.close();
    return 0;
}
