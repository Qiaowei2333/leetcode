// https://www.youtube.com/watch?v=ySTQCRya6B0    这个解法最好懂

package src.algorithms.Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution621 {
	public static int leastInterval(char[] tasks, int n) {
		if (n == 0)
			return tasks.length;

		Map<Character, Integer> taskToCount = new HashMap<>();
		for (char c : tasks) {
			taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
		}

		Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
		for (char c : taskToCount.keySet())
			queue.offer(taskToCount.get(c));

		Map<Integer, Integer> coolDown = new HashMap<>();
		int currTime = 0;
		while (!queue.isEmpty() || !coolDown.isEmpty()) {
			if (coolDown.containsKey(currTime - n - 1)) {
				queue.offer(coolDown.remove(currTime - n - 1));
			}
			if (!queue.isEmpty()) {
				int left = queue.poll() - 1;
				if (left != 0)
					coolDown.put(currTime, left);
			}
			currTime++;
		}

		return currTime;
		// int[] charFreqArr = new int[26];
		// int countHstCharFreq = 0;
		// int numOfHstFreqChar = 0;
		// for (char task: tasks) {
		// 	charFreqArr[task-'A']++;
		// 	if(countHstCharFreq < charFreqArr[task-'A']) {
		// 		countHstCharFreq = charFreqArr[task-'A'];
		// 		numOfHstFreqChar = 1; 
		// 	}
		// 	else if(countHstCharFreq == charFreqArr[task-'A']){
		// 		numOfHstFreqChar++;
		// 	}
		// }
		// int numOfParts = countHstCharFreq - 1;
		// int partLength = n - (numOfHstFreqChar - 1);
		// int emptySlots = numOfParts * partLength;
		// int remainTasks = tasks.length - countHstCharFreq*numOfHstFreqChar;
		// int idleSlots = Math.max(0, emptySlots - remainTasks);
		// return tasks.length + idleSlots; 
	}	
	public static void main(String[] args) {
		String test = "AAAAABBBBBBBCC";
		System.out.println(leastInterval(test.toCharArray(),2));
	}

}
