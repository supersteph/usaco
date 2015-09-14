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
    //find the integer k in the vector k
    for(int i = 0; i<nums.size();i++){
        if(nums[i]==k){
            return i;
        }
    }
    return -1;
}

void addstuff(vector<vector<int> >&  kindofowned, int index, int i){
    // go through everthing in the ith row of kindofowned and add it to the index row of kindofowned
    for(int j = 0; j<kindofowned.size();j++){
        kindofowned[index][j] += kindofowned[i][j];
        
    }
}

void doarow(vector<bool>& beento, vector<vector<int> >& kindofowned, int index){
    //figure out what each row owns
    if(beento[index]==true){
        return;
    }
    //if you've been here you stop
    
    beento[index]=true;
    //make a note that you've been here
    for(int i = 0; i<kindofowned.size();i++){
        
        doarow(beento, kindofowned, i);
        // do that row in case you need to use it
        
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
    //fill out everything in the table
    vector<bool> beento = *new vector<bool>;
    beento.resize(part.size());
    //this is to tell if you have been through everything or not
    for(int i = 0;i<part.size();i++){
        // go through all the rows and call the function doarow
        doarow(beento, part, i);
    }

    
    
}


vector<int> getindexes(vector<int> & sorted, vector<int> & unsorted){
    //find where the unsorted elemests are in the sorted elements
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
    // n[i][j] how much the company m[i] owns the company m[j]
    //vector<bool> doesown;
    //if a certain company has been touched yet
    vector<int> m;
    // the order of the companies
    //int l = 0;
    
    for(int i = 0; i<k;i++){
        int first;
        int second;
        int percent;
        fin>>first>>second>>percent;
        int k = searchto(m, first);
        int s = searchto(m,second);
        
        //find out if the companies have already been seen before if it has then you find the index
        


        
        if(k==-1&&s==-1){
            for(int i = 0; i<n.size();i++){
                n[i].push_back(0);
                n[i].push_back(0);
                //means that both elements have not been declared before
                //so you add an extra two elements to each row
            }
            
            m.push_back(first);
            m.push_back(second);
            //add two elements in m
            vector <int> x;
            x.resize(m.size());
            
            n.push_back(x);
            n.push_back(x);
            
            // add two rows at the bottom of the 2d vector
        }else if(k==-1||s==-1){
            //same thing as above except adding only one thing to each
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
        //add the percent to the twod vector
        
        
        
        
    }
    trytotwo(n);
    
    vector<int> notsort = m;
    sort(m.begin(), m.end());
    // have m be a sorted version and notsort be an unsorted version
    vector<int> indexes = getindexes(notsort, m);
    // have the indexes of how in nosort where it corresponds in m
    for(int i = 0; i<n.size();i++){
        
        for(int j = 0;j<n.size();j++){
            
            if(n[indexes[i]][indexes[j]]>50){
                fout<<notsort[indexes[i]]<<" "<<notsort[indexes[j]]<<"\n";
                cout<<notsort[indexes[i]]<<" "<<notsort[indexes[j]]<<"\n";
                // go through everything and print them out in the sorted way
            }
            
        }
    }
    
    
    fout.close();
    return 0;
}
