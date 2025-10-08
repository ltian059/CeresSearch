import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

    /// PART2 solution
    public int search(List<String> input) {
        // X-MASs.
        // 2 directions:
        final int[][] DIRS = {
                {1, 1}, {1, -1}
        };
        //MAS, SAM
        final String[] TARGETS = {"MAS", "SAM"};

        int ans = 0;
        int n = input.size(), m = input.get(0).length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = input.get(i).charAt(j);
                //starting from (i,j), can only go from the first direction to form a X-MAS
                //if got a MAS, then find the next edge of X
                boolean found = findXMS(i, j, input, DIRS[0], TARGETS);
                if (found && findXMS(i, j + 2, input, DIRS[1], TARGETS)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    //find MAS/SAM starting from (x,y) in the given direction
    private boolean findXMS(int x, int y, List<String> input, int[] dir, String[] targets) {
        int n = input.size(), m = input.get(0).length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (x < 0 || x >= n || y < 0 || y >= m) {
                break;
            }
            sb.append(input.get(x).charAt(y));
            x += dir[0];
            y += dir[1];
        }
        String cur = sb.toString();
        return cur.equals(targets[0]) || cur.equals(targets[1]);
    }
}
