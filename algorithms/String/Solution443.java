package src.algorithms.String;

class Solution443 {
    public static int compress(char[] chars) {
        int temp = '1';
        int idx = 1;
        for(int i =1; i< chars.length; i++){
            if(chars[i-1]==chars[i]){
                temp++;
            }
            else{
                if(temp>'1'&&temp<='9'){
                    chars[idx++] = (char)temp;
                    chars[idx++] = chars[i];
                    temp = '1';
                }
                else if(temp>'9'){
                    chars[idx++] = (char)((temp-'0')/10+'0');
                    chars[idx++] = (char)((temp-'0')%10+'0');
                    chars[idx++] = chars[i];
                    temp = '1';
                }
                else if(temp=='1'){
                    chars[idx++] = chars[i];
                }
            }
        }
       if (temp>'1'&&temp<='9') 
    	   chars[idx++] = (char)temp;
       else if(temp>'9') {
           chars[idx++] = (char)((temp-'0')/10+'0');
           chars[idx++] = (char)((temp-'0')%10+'0');    	   
       }
        return idx;
    }
}