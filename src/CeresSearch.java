import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CeresSearch {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        System.out.println("Please input the grid (end with CTRL+D/CTRL+Z):");
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        scanner.close();

        Part1 part1 = new Part1();
        Part2 part2 = new Part2();
        //System.in input
        int result1 = part1.search(input);
        System.out.println("part1 answer is:" + result1);
        System.out.println("-----");
        int result2 = part2.search(input);
        System.out.println("part2 answer is:" + result2);
    }
}
