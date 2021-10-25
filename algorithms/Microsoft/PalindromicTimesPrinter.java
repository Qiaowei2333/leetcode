

public class PalindromicTimesPrinter {
    public void printPalindromicTimes(int hour) {
        // 00:00 -> 05:50
        for (int i = 0; i <= 5 && i < hour; i++) {
            String first = "0";
            String second = "" + i;
            String output = first + second + ":" + second + first;
            System.out.println(output);
        }

        // 10:01 -> 15:51
        for (int i = 0; i <= 5 && i + 10 < hour; i++) {
            String first = "1";
            String second = "" + i;
            String output = first + second + ":" + second + first;
            System.out.println(output);
        }

        // 20:02 -> 23:32
        for (int i = 0; i <= 3 && i + 20 < hour; i++) {
            String first = "2";
            String second = "" + i;
            String output = first + second + ":" + second + first;
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        PalindromicTimesPrinter printer = new PalindromicTimesPrinter();
        printer.printPalindromicTimes(21);
    }
}
