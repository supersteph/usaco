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
#include "math.h"
#include <iomanip>
using namespace std;
/*
 First use one sentence to describe the highlevel plan, then go into the details. That will
 it easy for people to follow.

 The strategy is that I am first going to do Bellman-Ford, I am going to take the size of the
 array which means going to run through this n times. Because at most a certain point would be
 n points away from the current point you are at to run through everything so for each one of
 the iterations it goes through every element in the 2d array, so then let's say 
 I'm at an element [x][y] that means that point x [x][j] distance away from y, so then I got
 to the [y] column of the 2d array then I go through the entire column and then I i make the
 column [x] equal to [i] that is my algorithim for figuring out the shortest path to it.
 I do this to find the shortest one, like from point i to point k may be slower than from point 
 i to point j to point k, it also allows me to figure out all the places that I haven't been
 to from that point.
 
 After I figure out the shortest path to everything I got through each element of the 2d array
 that is infinity, I want to find the points that can't be connected and then I find the longest
 distance that I can go from each point, So i find the farthest distance from point I and then
 I find the farthest distance from point j, this means that if I connect these two points,
 the farthest will be the edges and the diameter would be the two farthest points plus the
 distance between I and J.  I then compare it with the maximum diamter of the field I vs the
 diiamter of field J and I find the max between the max diamter and the connected points
 */
class object {
public:
    int first;
    int second;
    object(int x, int y) : first(x), second(y) {}
};

double getdis(const object& n, const object& k){
     return sqrt((n.first-k.first)*(n.first-k.first)+(n.second-k.second)*(n.second-k.second));
}


void map(vector<vector<double> >& x){
    //if (k >= m.size()) std::cerr << "error" << endl;
    for(int k = 0; k < x.size(); k++){
        for(int i = k; i < x[k].size();i++){
            if(x[k][i] != -1) {
                //std::cout<< k << " " << i << "\n";
                // How do you know it is not the otherway around?
                x[i][k] = x[k][i];
                
                for(int j = i; j < x[i].size(); j++){
                    if(x[i][j] != -1){
                        // make the current row of the jth column equal to the minimum
                        // between what it is currently and the distance it is between
                        // the other column and the other row
                        // x[k][j] is the one i want to change
                        if(x[k][j] != -1){
                            x[k][j] = min(x[i][k]+x[i][j], x[k][j]);
                            x[j][k] = min(x[i][k]+x[i][j], x[k][j]);
                        } else if(x[i][j] != -1){
                            x[k][j] = x[i][k]+x[i][j];
                            x[j][k] = x[i][k]+x[i][j];  
                        }
                    }
                }
            }
        }
    }
}


int main(int argc, const char * argv[]) {
    ifstream fin ("cowtour.in");
    int k;
    fin >> k;
    vector<object> vertex;
    for(int i = 0; i < k; i++){
        int x, y;
        fin>>x>>y;
        vertex.push_back(object(x, y));
    }
   
    vector<vector<double> > distance(k, vector<double>(k, -1));    
    for(int i = 0; i < k; i++){
        string s;
        fin >> s;
        for(int j = i; j < k; j++){
            if(i==j){
                distance[i][j] = 0;
            }
            if(s[j] != '0'){
                distance[i][j] = getdis(vertex[i], vertex[j]);
                distance[j][i] = getdis(vertex[i], vertex[j]);
            }
        }
    }
    
    // why k-1 here?
    for(int i = 0; i < k-1; i++){
        map(distance);
    }
    
    vector<double> all;
    
    for(int i = 0;i<k;i++){
        double max = 0.0;
        for(int j = 0; j<k;j++){
            if(distance[i][j]>max){
                max = distance[i][j];
            }
        }
        all.push_back(max);
    }
    
    vector<double>diameter(k,-1);
    for(int i = 0; i<all.size();i++){
        double max = 0;
        for(int j = 0; j<all.size();j++){
            if(distance[i][j]!=0){
                if(all[j]>max){
                    max = all[j];
                }
            }
        }
        diameter[i] = max;
    }
    double min = -1.0;
    for(int i = 0; i<distance.size();i++){
        for(int j = i; j<distance.size();j++){
            if(distance[i][j]==-1){
                double maxi = all[i];
                double maxj = all[j];
                if(min == -1.0){
                    min = max(maxj+maxi+getdis(vertex[i], vertex[j]), max(diameter[i],diameter[j]));
                    
                }else if( min > maxj+maxi+getdis(vertex[i], vertex[j])){
                    
                    min = max(maxj+maxi+getdis(vertex[i], vertex[j]), max(diameter[i],diameter[j]));
                }
            }
        }
    }
    
    ofstream fout ("cowtour.out");
    fout << setprecision(6) << fixed << min << "\n";
    cout << setprecision(6) << fixed << min << "\n";
    fout.close();
    return 0;
}