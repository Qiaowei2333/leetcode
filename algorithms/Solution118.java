package src.algorithms;

import java.util.ArrayList;
import java.util.List;
public class Solution118 {
public List<List<Integer>> generate(int numRows)
{
	List<List<Integer>> allrows = new ArrayList<List<Integer>>();
	ArrayList<Integer> row = new ArrayList<Integer>();
	for(int i=0;i<numRows;i++)
	{
		row.add(0, 1);
		for(int j=1;j<row.size()-1;j++)
			row.set(j, row.get(j)+row.get(j+1));
		allrows.add(new ArrayList<Integer>(row));
	}
	return allrows;
	
}
}
//public class Solution118 {
//	public List<List<Integer>> generate(int numRows) {
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		List<Integer> row, pre = null;
//		for (int i = 0; i < numRows; ++i) {
//			row = new ArrayList<Integer>();
//			for (int j = 0; j <= i; ++j)
//				if (j == 0 || j == i)
//					row.add(1);
//				else
//					row.add(pre.get(j - 1) + pre.get(j));
//			pre = row;
//			res.add(row);
//		}
//		return res;
//	}
//}
//class Solution118 {
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        List<Integer> row = new ArrayList<Integer>();
//        List<Integer> temp = null;
//        for(int i=0;i<numRows;i++){
//            for(int j=1;j<i;j++){
//                int a = temp.get(j)+temp.get(j-1);
//                row.set(j,a);
//            }
//            row.add(1);
//            temp = new ArrayList<Integer>(row);
//            result.add(temp);
//        }
//        return result;
//    }   
//}
