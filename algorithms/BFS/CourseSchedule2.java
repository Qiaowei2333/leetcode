// lt 210
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[][] edges = new int[numCourses][numCourses];
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            indegree[course]++;
            edges[preCourse][course] = 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            result[index++] = curCourse;
            for (int i = 0; i < numCourses; i++) {
                if (edges[curCourse][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        
        if (index == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}