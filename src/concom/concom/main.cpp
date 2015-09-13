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


int searchto(vector<int> nums, int k){
    for(int i = 0; i<nums.size();i++){
        if(nums[i]==k){
            return i;
        }
    }
    return -1;
}

void addstuff(vector<vector<int> > kindofowned, int index, int i){
    for(int j = 0; j<kindofowned.size();j++){
        kindofowned[index][j] += kindofowned[i][j];
        
    }
}

void doarow(vector<bool>& beento, vector<vector<int> >& kindofowned, int index){
    if(beento[index]==true){
        return;
    }
    
    beento[index]=true;
    
    if(index==3)
    {
        
    }
    for(int i = 0; i<kindofowned.size();i++){
        
        doarow(beento, kindofowned, i);
        
        if(kindofowned[index][i]>50){
            for(int j = 0; j<kindofowned.size();j++){
                kindofowned[index][j] += kindofowned[i][j];
                
                if(kindofowned[index][j]>50&&j<i){
                    addstuff(kindofowned,index,i);
                }
            }
        }
        
        
    }
    
    
}



void trytotwo(vector<vector<int> >& part){
    vector<bool> beento = *new vector<bool>;
    beento.resize(part.size());
    for(int i = 0;i<part.size();i++){
        doarow(beento, part, i);
    }

    
    
}


vector<int> getindexes(vector<int> sorted, vector<int> unsorted){
    vector<int> x;
    for(int i = 0;i<unsorted.size();i++){
        for(int j = 0;j<sorted.size();j++){
            if(unsorted[i]==sorted[j]){
                x.push_back(j);
            }
        }
        
    }
    return x;
    
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
    vector<vector<int> > n;
    vector<bool> doesown;
    vector<int> m;
    int l = 0;
    
    for(int i = 0; i<k;i++){
        int first;
        int second;
        int percent;
        fin>>first>>second>>percent;
        int k = searchto(m, first);
        int s = searchto(m,second);
        if(k==-1){
            doesown.push_back(first);
            l++;
        }
        if(s==-1){
            doesown.push_back(second);
            l++;
        }
        
        if(k==-1&&s==-1){
            for(int i = 0; i<n.size();i++){
                n[i].push_back(0);
                n[i].push_back(0);
                
            }
            
            m.push_back(first);
            m.push_back(second);
            vector <int> x;
            x.resize(m.size());
            n.push_back(x);
            n.push_back(x);
        }else if(k==-1||s==-1){
            for(int i = 0; i<n.size();i++){
                n[i].push_back(0);
            
                
            }
            
            vector <int> x;
            x.resize(n.size()+1);
            n.push_back(x);
            if(k==-1){
                m.push_back(first);
            }else{
                m.push_back(second);
                
            }
            
        }
        

        k = searchto(m, first);
        s = searchto(m,second);
        
        n[k][s]=percent;
        
        
        
        
    }
    trytotwo(n);
    
    vector<int> notsort = m;
    sort(m.begin(), m.end());
    vector<int> indexes = getindexes(notsort, m);
    
    for(int i = 0; i<n.size();i++){
        
        for(int j = 0;j<n.size();j++){
            
            if(n[indexes[i]][indexes[j]]>50){
                fout<<notsort[indexes[i]]<<" "<<notsort[indexes[j]]<<"\n";
                cout<<notsort[indexes[i]]<<" "<<notsort[indexes[j]]<<"\n";
            }
            
        }
    }
    
    
    fout.close();
    return 0;
}
