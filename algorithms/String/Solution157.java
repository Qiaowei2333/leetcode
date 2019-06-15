package src.algorithms.String;

public class Solution157 {
    public static int read(char[] buf, int n) {
        int counter = 0;
        char[] buffer = new char[4];
        while(counter < n) {
            int read = read4(buffer);
            for(int i=0; i<read; i++) {
                if(counter == n) return counter;
                buf[counter] = buffer[i];
                counter++;
            }
            if(read<4) return counter;
        }
        return counter;
    }  

	public static int read4(char[] temp) {
		char[] res = new char[10];
		char[] ret = new char[4];
		int index = 0;
		for (int i = 0; i<res.length; i++){
			if(index<4) {
				ret[index++] = temp[i];
			}
		}
		return index;
	}
}
