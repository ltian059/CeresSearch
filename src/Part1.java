import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    /// PART1 solution
    public int search(List<String> input) {
        final int[][] DIRS = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        }; //8 directions
        //Determine directions:
        //1.horizontal(2 dirs), vertical (2 dirs), diagonal(4 dirs)
        //2. total 8 directions to find the word(XMAS)
        String target = "XMAS";
        int n = input.size(), m = input.get(0).length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = input.get(i).charAt(j);
                if (c == target.charAt(0)) {
                    for (int[] dir : DIRS) {
                        // For each direction, check the next 3 characters in this direction
                        StringBuilder cur = new StringBuilder();
                        cur.append(c);
                        int cnt = 3;
                        int nx = i, ny = j;
                        while (cnt-- > 0) {
                            nx += dir[0];
                            ny += dir[1];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                break;
                            }
                            cur.append(input.get(nx).charAt(ny));
                        }
                        if (cur.toString().equals(target)) {
                            ans++;
                        }
                    }
                }

            }
        }

        return ans;
    }

}
