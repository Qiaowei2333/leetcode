// https://www.1point3acres.com/bbs/thread-823882-1-1.html

// Amazon is hosting a team hackathon
// 1. Each team will have exactly teamSize developers.
// 2. A developer's skill level is dneoted by skill[i]
// 3. The difference betweeen the maximum and minimum skill levels, within a team cannot exceed a threshold, maxDiff


// skill = [3,4,3,1,6,5], teamSize = 3, maxDiff = 2

// At most 2 teams can be formed [3,3,1] and [4,6,5]. The differenc ebetewen the maximum and minimum skill levels is 2 in each case, which does no exceed the threshold value of 2.

import java.util.*;

public class MaximumTeamCount {
    public int countMaximumTeam(int[] skills, int maxDiff, int teamSize) {
        Arrays.sort(skills);
        int l = 0;
        int ct = 0;
        for (int r = 1; r < skills.length; r++) {
            int curDiff = skills[r] - skills[l];
            int curSize = r - l + 1;
            if (curDiff > maxDiff || curSize > teamSize) {
                l = r;
            }
            else if (curSize == teamSize && curDiff <= maxDiff) {
                ct++;
            }
        }
        return ct;
    }

    public static void main(String[] args) {
        MaximumTeamCount s = new MaximumTeamCount();
        int res = s.countMaximumTeam(new int[]{3,4,3,1,6,5}, 2, 3);
        System.out.println(res);
    }
}
