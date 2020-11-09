// https://leetcode.com/discuss/interview-question/762546/
// combinatio of lc 392 and lc 28
import java.util.*;
public class AmazonFreshPromotion {
    // O(MN): where M is the average number of items in each code group, and N is the number of items in the shopping cart
    private static int isWinner(String[][] codeList,String[] shoppingCart){
        //check zero length...
        if(codeList == null || codeList.length == 0)
            return 1;
        if(shoppingCart == null || shoppingCart.length == 0)
            return 0;
        int i=0,j=0;
        for(int k=0;k<shoppingCart.length;k++) {
            //when match success
            if(codeList[i][j].equals(shoppingCart[k]) || codeList[i][j].equals("anything")) {
                j++;
                if(j == codeList[i].length) {
                    i++;
                    j=0;
                }
                if(i == codeList.length)
                    return 1;
            }else {
                //when match failed, k and j both go back. note k
                k-=j;
                j=0;
            }
        }
        return 0;
    }

    private static int isWinner(List<List<String>> codeList, List<String> shoppingCart){
        if (codeList == null || codeList.size() == 0) {
            return 1;
        }
        if (shoppingCart == null || shoppingCart.size() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        for (int k = 0; k < shoppingCart.size(); k++) {
            // if match, begin to check one after one
            if (codeList.get(i).get(j).equals(shoppingCart.get(k)) || codeList.get(i).get(j).equals("anything")) {
                j++;
                if (j == codeList.get(i).size()) {
                    j = 0;
                    i++;
                }
                if (i == codeList.size()) {
                    return 1;
                }
            }
            else {
            // if failed in match during check, reverse j and k, k reverse j steps, j set to 0
                k -= j;
                j = 0;
            }

        }
        return 0;
    }
}
