//
//  main.cpp
//  money
//
//  Created by Awesomeness on 8/7/15.
//  Copyright (c) 2015 Swagmaster. All rights reserved.
//
/*
 ID: xiaoyun4
 PROG: money
 LANG: C++
 */

#include <iostream>
#include <vector>
#include <fstream>
//#include <istream>

using namespace std;



long getnum(vector<int>  x, int k, int current){
    
    //cout<<current<<"\n";
    /*
    if(test[current]!=-1){
        return test[current];
    }
     */
    if(current==k){
        return 1;
    }
    
    int m = x[x.size()-1];
    if(x.size()==1){
        if((k-current)%m==0){
            return 1;
        } else{
            return 0;
        }
    }
    long all = 0;

    //cout<<m<<"\n";
    x.erase(x.end()-1);
    for(int i = 0;i+current<=k;i+=m){
        long s = getnum(x, k,i+current);
        //cout<<s <<" "<<current<<" "<<
        all+=s;
    
    }
    //test[current]= all;
    return all;
}

int getit(vector<int> all, int tobuild, int k){
    if(tobuild==k){
        return 1;
    }
    int allo = 0;
    for(int i = 0;i<all.size();i++){
        if(tobuild+all[i]>k){
            break;
        }
        allo += getit(all,tobuild+all[i] , k);
        
    }
    //test[current]= all;
    return allo;
    
    
    
    
}


long trytogetit(vector<int>& all, int k, vector<long> & ref){
    if(ref[k]!=-1){
        return ref[k];
    }
    if(k<all[0]){
        return 0;
    }else if(std::find(all.begin(),all.end()-1,k)!=all.end()){
        return 1;
    }
    int allo = 0;
    for(int i = 0;i<=all.size()/2;i++){
        long first = trytogetit(all , i, ref);
        long second;
        if(i==all.size()/2){
            second = trytogetit(all, all.size()-i, ref);
        }
        if(first<all[i]){
            continue;
        }
        if(i!=all.size()/2){
            allo+= first*second;
        }else{
            allo+= first*first;
        }
    }
    //test[current]= all;
    ref[k]+=allo;
    return allo;
    
    
    
    
}
//int tryto(vector<>)

int main(int argc, const char * argv[]) {
    // insert code here...
    //cout<<"yo \n";
    ofstream fout ("money.out");
    //fout<< "yo";
    //fout.close();
    ifstream fin ("money.in");
    fout<<"yo";
    //fout.close();
    //cout<<"yo";
    
    int k;
    int m;
    fin >> k >> m;
    //cout << "yo";
    //getline(fin,)
    vector<int> all (k);
    //fin.getline();
    vector<int> test(k);
    for(int i = 0;i<k;i++){
        fin>>all[i];
        test[i]=-1;
    }
    vector<int> cool(k);
    
    std::sort(all.begin(),all.end());
    
    
    cout<< k<<"\n";
    
    long s = trytogetit(all,k , cool);
    cout<<s << "\n";
    fout << s << "\n";
    fout.close();
    
     
    return 0;
}
