package src.algorithms;

import java.util.ArrayList;
import java.util.List;

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> r = new ArrayList<Integer>();
        for(int i=0;i<rowIndex+1;i++){
            r.add(0,1);
            for(int j =1;j<i;j++){
                r.set(j,r.get(j)+r.get(j+1));
            }
        }
        return r;
    }
}