package src.algorithms;

import java.util.HashMap;

public class Solution760 {
	 public static int[] anagramMappings(int[] A, int[] B) {
		 HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		 for(int i=0;i<B.length;i++) {
			 if(!map.containsKey(B[i])) map.put(B[i],i);
		 }
		 int[] p = new int[map.size()];
		 int index=0;
		 for (int a:A) {
			 if(map.containsKey(a)) {
				 p[index++]=map.get(a);
				 map.remove(a);
			 }
		 }
		 return p;
	 }
}
