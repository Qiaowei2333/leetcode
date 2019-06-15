package src.algorithms.String;

import java.util.ArrayList;
import java.util.HashSet;

class Solution345 {
    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++){
            if(set.contains(arr[i])) list.add(i);
        }
        int i = 0;
        int j = list.size()-1;
        if(j<1) return s;
        char temp;
        while(i<j){
            temp = arr[list.get(i)];
            arr[list.get(i)] = arr[list.get(j)];
            arr[list.get(j)] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
