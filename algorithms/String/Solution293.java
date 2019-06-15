package src.algorithms.String;

import java.util.ArrayList;
import java.util.List;

public class Solution293 {
	public static List<String> generatePossibleNextMoves(String s) {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<s.length()-1;i++) {
			char[] ss = s.toCharArray();
			if(ss[i]=='+' && ss[i+1]=='+') {
				ss[i]='-';
				ss[i+1]='-';
				list.add(new String(ss));
			}
		}
		return list;
	}
}
