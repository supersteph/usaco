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
        othercomps= *new vector<int>;
        percent = *new vector<int>;
        owned = *new vector<int>;
        touched = false;
        
    }
};

vector<int> get(company* x){
    if(x->othercomps.size()==0){
        return *new vector<int>(0);
    }
    
    for(int i = 0; i<x->othercomps.size();i++){
        if(x->percent[i]>50){
            
            
        }
        /*
        //vector<int> stuff = get(x->othercomps[i]);
        for(int i = 0; i<stuff.size();i++){
            //x->owned.push_back(stuff[i]);
        }
         */
        
    }
    
    return x->owned;
    
}
/*
void tryget(company* x){
    if(x->othercomps.size()==0){
        return;
    }
    
    for(int i = 0; i<x->othercomps.size();i++){
        if(x->percent[i]>50){
            x->owned.push_back(x->othercomps[i]->num);
        }
        tryget(x->othercomps[i]);
        company m = *x->othercomps[i];
        for(int j = 0; j<m.othercomps.size();j++){
            
        }
        
    }
    
}
*/


int getindex(company x, int k){

    
    for(int i = 0; i < x.percent.size();i++){
        if(x.othercomps[i]==k){
            return i;
        }
    }
    return -1;
    
}

int getcomp(vector<company> n, int num){
    
    for(int i = 0; i< n.size();i++){
        if(n[i].num==num){
            return i;
        }
    }
    return -1;
    
}

bool inowned(company n, int s){
    for (int i = 0; i< n.owned.size(); i++) {
        if(n.owned[i]==s){
            return true;
        }
    }
    return false;
}


void tryto(vector<company> & x , int k){

    if(x[k].touched==true){
        return;
    }
    x[k].touched = true;
    
    for(int i = 0; i<x[k].othercomps.size();i++){
        
        
        if(x[k].percent[i]>50){
            
            if(inowned(x[k], x[k].othercomps[i])){
                continue;
            }
            x[k].owned.push_back(x[k].othercomps[i]);
        } else{
            continue;
        }
        
        
        int l = getcomp(x, x[k].othercomps[i]);
        if(l==-1){
            continue;
        }
        tryto(x, l);
        
        cout<< k <<" "<< i << "\n";
        
        /*
        
        if(x[k].percent[i]>50){
        
            for(int j = 0; j< x[l].owned.size();j++){
            
            //removeIndex(x[k], m.owned[j]);
                //x[k].owned.push_back(x[l].owned[j]);
            
            
            }
        }
        
        */
        
        
        if(x[k].percent[i]>50){
        
            for(int j = 0; j< x[l].percent.size();j++){
                int s = getindex(x[k], x[l].othercomps[j]);
                if(s==-1){
                    x[k].othercomps.push_back(x[l].othercomps[j]);
                    x[k].percent.push_back(x[l].percent[j]);
                }else {
                    
                    if(inowned(x[k], x[l].othercomps[j])){
                        continue;
                    }
                
                    int sum = x[l].percent[j]+x[k].percent[s];
                    x[k].percent[s] = sum;
                
                    if(sum>50){
                        x[k].owned.push_back(x[l].othercomps[j]);
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
    vector<company> n = *new vector<company>;
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
    //cout<<"yo"<<"\n";
    for(int i = 0; i< k;i++){
        tryto(n, i);
    }
    
    for(int i = 0; i<k;i++){
        for(int j = 0;j<n[i].owned.size();j++){
            fout<<n[i].num<<" "<<n[i].owned[j]<< "\n";
            cout<<n[i].num<<" "<<n[i].owned[j] << "\n";
        }
    }
    
    

    fout.close();
     
    
    
    
    
    return 0;
}

