package src.algorithms.String;

public class Solution758 {
	public String boldWords(String[] words, String S) {
		boolean[] bold = new boolean[S.length()];
		for (String word:words) {
			int l = word.length();
			int idx = S.indexOf(word);
			if(idx>0) UpdBoldArr(bold, idx, l);
		}
		return "";
	}
	private void UpdBoldArr(boolean[] bold, int start, int l) {
		int i = 0;
		while(i<l) {
			bold[start+i]=true;
		}
	}
}
