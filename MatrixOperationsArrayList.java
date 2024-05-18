import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class MatrixOperationsArrayList {
    private static final int ADD = 0;
    private static final int SUBSTRACT = 1;
    private static final int MULTIPLY = 2;
    private static final int MULTIPLY_MATRIX = 3;

    private static Map<String, Integer> commandsMap = createCommandsMap();

    private static Map<String, Integer> createCommandsMap() {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("add", ADD);
        myMap.put("substract", SUBSTRACT);
        myMap.put("multiply", MULTIPLY);
        myMap.put("multiplyMatrix", MULTIPLY_MATRIX);
        return myMap;
    }

    private static ArrayList<ArrayList<Integer>> allocMatrix(int n, int m) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> newRow = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                newRow.add(0);
            }
            array.add(newRow);
        }
        return array;
    }

    private static ArrayList<ArrayList<Integer>> adunare(ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> b) {
        ArrayList<ArrayList<Integer>> array = allocMatrix(a.size(), b.size());
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                array.get(i).set(j, a.get(i).get(j) + b.get(i).get(j));
            }
        }
        return array;
    }

    private static ArrayList<ArrayList<Integer>> scadere(ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> b) {
        ArrayList<ArrayList<Integer>> array = allocMatrix(a.size(), b.size());
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                array.get(i).set(j, a.get(i).get(j) - b.get(i).get(j));
            }
        }
        return array;
    }

    private static ArrayList<ArrayList<Integer>> inmultireScalar(ArrayList<ArrayList<Integer>> a, int sc) {
        ArrayList<ArrayList<Integer>> array = allocMatrix(a.size(), a.size());
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                array.get(i).set(j, a.get(i).get(j) * sc);
            }
        }
        return array;
    }

    private static ArrayList<ArrayList<Integer>> inmultire(ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> b) {
        ArrayList<ArrayList<Integer>> array = allocMatrix(a.size(), a.size());
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                for (int k = 0; k < b.size(); k++) {
                    array.get(i).set(j, array.get(i).get(j) + a.get(i).get(k) * b.get(k).get(j));
                }
            }
        }
        return array;
    }

    private static ArrayList<ArrayList<Integer>> readMatrix(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<ArrayList<Integer>> array = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> newRow = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                newRow.add(scanner.nextInt());
            }
            array.add(newRow);
        }
        return array;
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> array) {
        for (int i = 0; i < array.size(); ++i) {
            for (int elem : array.get(i)) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayList<ArrayList<Integer>> A = readMatrix(scanner);
        ArrayList<ArrayList<Integer>> B;

        ArrayList<ArrayList<Integer>> res;
        switch (commandsMap.get(command)) {
            case ADD:
                B = readMatrix(scanner);
                res = adunare(A, B);
                printMatrix(res);
                break;
            case SUBSTRACT:
                B = readMatrix(scanner);
                res = scadere(A, B);
                printMatrix(res);
                break;
            case MULTIPLY:
                int b = scanner.nextInt();
                res = inmultireScalar(A, b);
                printMatrix(res);
                break;
            case MULTIPLY_MATRIX:
                B = readMatrix(scanner);
                res = inmultire(A, B);
                printMatrix(res);
                break;
        }
    }
}