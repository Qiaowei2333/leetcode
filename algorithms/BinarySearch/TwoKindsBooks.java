// instabase oa
// https://www.1point3acres.com/bbs/thread-625352-1-1.html
public class TwoKindsBooks {
//     two kinds of books, [a, b]
//     given [x] book a, trade for as many b as you can
//     you will start with [x] book a and [y] dollars in your pocket.
//     for [each] book b, you need to give out [1] book a and [w] dollars
//     also, you can trade in 1 book a for [z] dollars
    public int tradeMaxB(int x, double y, double w, double z) {
        int res = 0;
        int start = 0;
        int end = x;
        while (start <= end) {// 先用二分法找到最后一个<= y的位置，再过去就大于y了
            int mid = (start + end) / 2;
            double amount = w * mid;
            if (y >= amount) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        res += end;
        if (end >= 0) {// 确定end valid
            int remainBooks = x - end;
            double remainMoney = y - w * end;// 0 <= remainMoney < w
            // while (remainBooks > 0) {
            //     remainBooks--;
            //     remainMoney += z;
            //     if (remainMoney > w && remainBooks > 0) {
            //         res++;
            //         remainMoney -= w;
            //         remainBooks--;
            //     }
            // }
            int i = 0, j = remainBooks;
            while (i < j) { // find first element >= w
                int mid = (i + j) / 2;
                if ((remainMoney + mid * z) < w) {
                    i = mid + 1;
                }
                else if ((remainMoney + mid * z) >= w) {
                    j = mid - 1;
                }
            }
            // return i;
            if (i <= remainBooks) {
                // 从头再来一次
            }
        }
        return res;
    }
}
