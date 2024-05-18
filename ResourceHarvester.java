import java.util.*;
import java.util.stream.Stream;

public class ResourceHarvester {

    private static final int[] dirX = {-1, -1, +0, +1, +1, +1, +0, -1};
    private static final int[] dirY = {+0, +1, +1, +1, +0, -1, -1, -1};

    public static int mine(int[][] map, List<Integer> moves, List<String> history) {
        int mine = map[0][0];
        map[0][0] = 0;
        history.add(formatHistoryInput(0, 0));
        int elementI = 0;
        int elementJ = 0;
        for (int i = 0; i < moves.size(); i++) {
            int neighI = elementI + dirX[moves.get(i) - 1];
            int neighJ = elementJ + dirY[moves.get(i) - 1];
            if (neighI >= 0 && neighI < map.length && neighJ >= 0 && neighJ < map[0].length) {
                mine += map[neighI][neighJ];
                map[neighI][neighJ] = 0;
                history.add(formatHistoryInput(neighI, neighJ));
                elementI = neighI;
                elementJ = neighJ;
            }
        }
        return mine;
    }

    private static String formatHistoryInput(int i, int j) {
        String s = "(" + i + ", " + j + ")";
        return s;
    }

    public static List<String> mostVisitedLocation(List<String> history) {
        Map<String, Integer> countOcc = new HashMap<>();
        List<String> mostVisited = new ArrayList<>();
        for (String s : history) {
            if (countOcc.containsKey(s)) {
                int value = countOcc.get(s) + 1;
                countOcc.replace(s, value);
            } else {
                countOcc.put(s, 1);
            }
        }
        int maxOcc = 0;
        for (int values : countOcc.values()) {
            if (values > maxOcc) {
                maxOcc = values;
            }
        }
        for (Map.Entry<String, Integer> entry : countOcc.entrySet()) {
            if (entry.getValue() == maxOcc) {
                mostVisited.add(entry.getKey());
            }
        }
        Stream<String> sorted = mostVisited.stream().sorted();
        mostVisited = sorted.toList();
        return mostVisited;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                map[i][j] = scanner.nextInt();

        scanner.nextLine();
        String line = scanner.nextLine();
        String[] elems = line.split("\\s+");
        ArrayList<Integer> moves = new ArrayList<Integer>();
        for (String elem : elems) {
            moves.add(Integer.parseInt(elem));
        }

        ArrayList<String> history = new ArrayList<String>();

        System.out.println(mine(map, moves, history));

        List<String> loc = mostVisitedLocation(history);
        System.out.print(loc);
    }
}
