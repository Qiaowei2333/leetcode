package src.algorithms;
//�Ҹ�ϲ�����
//public class Solution {
//    public int shortestDistance(String[] words, String word1, String word2) {
//        int idx1 = -1, idx2 = -1, distance = Integer.MAX_VALUE;
//        for(int i = 0; i < words.length; i++){
//            if(words[i].equals(word1)){
//                idx1 = i;
//                // ��һ��д��idx���Ȳ��Ƚ�
//                if(idx2 != -1) distance = Math.min(distance, idx1 - idx2);
//            }
//            if(words[i].equals(word2)){
//                idx2 = i;
//                // ��һ��д��idx���Ȳ��Ƚ�
//                if(idx1 != -1) distance = Math.min(distance, idx2 - idx1);
//            }
//        }
//        return distance;
//    }
//}
public class Solution243 {
	public int shortestDistance(String[] words, String word1, String word2) {
		int p1=-1,p2=-1,result=words.length,dst=words.length;
		for(int i=0; i<words.length; i++){
			if (words[i].equals(word1)){
				p1=i;
				if(p1!=-1&&p2!=-1){
					dst=Math.abs(p1-p2);
					result = Math.min(result, dst);
				}
			}
			if (words[i].equals(word2)){  // String �ıȽ�  == �Ƚϵ����Ƿ�ָ��ͬһ��string object, ���ݱȽ��� equals
				p2=i;
				if(p1!=-1&&p2!=-1){
					dst=Math.abs(p1-p2);
					result = Math.min(result, dst);
				}
			}
		}
		if (result==words.length){
			return -1;
		}
		else return result;
	}
}

