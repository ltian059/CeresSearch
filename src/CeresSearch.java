
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CeresSearch {

    /// PART1 solution
    public int search() {
        final int[][] DIRS = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        }; //8 directions
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        scanner.close();
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

    /// PART2 solution
    public int search2() {
        // X-MASs.
        // 2 directions:
        final int[][] DIRS = {
                {1, 1}, {1, -1}
        };
        //MAS, SAM
        final String[] TARGETS = {"MAS", "SAM"};
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        scanner.close();
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

    public static void main(String[] args) {
        CeresSearch cs = new CeresSearch();
        int result = cs.search2();
        System.out.println(result);
    }
}
