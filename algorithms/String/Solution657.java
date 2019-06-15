package src.algorithms.String;

class Solution657 {
    public static boolean judgeCircle(String moves) {
        int x=0,y=0;
        char[] movearray = moves.toCharArray();
        for(char move: movearray) {
        	switch(move) {
        		case 'U':
        			y++;
        			break;
        		case 'D':
        			y--;
        			break;
        		case 'L':
        			x--;
        			break;
        		case 'R':
        			x++;
        			break;
        	}
        }
        if(x==0&&y==0) return true;
        else return false;
    }
}
