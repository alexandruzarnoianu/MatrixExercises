import java.util.Scanner;
import java.util.ArrayList;

public class CustomZonesMatrixInitialization {
    private static int[][] arrayMatrix(int matrixDimension, int mainDiagValue, int sndDiagValue, int centerValue,
                                       int leftValue, int upValue, int rightValue, int bottomValue) {

        int[][] array = new int[matrixDimension][matrixDimension];
        boolean hasCenter = matrixDimension % 2 == 1 ? true : false;
        for (int row = 0; row < matrixDimension; row++) {
            for (int col = 0; col < matrixDimension; col++) {
                if (row == col) {
                    array[row][col] = mainDiagValue;
                    if (row == matrixDimension / 2 && hasCenter) {
                        array[row][col] = centerValue;
                    }
                    continue;
                }
                if (row + col == matrixDimension - 1) {
                    array[row][col] = sndDiagValue;
                    continue;
                }
                if (row < col && row + col < matrixDimension - 1) {
                    array[row][col] = upValue;
                    continue;
                }
                if (row > col && row + col > matrixDimension - 1) {
                    array[row][col] = bottomValue;
                    continue;
                }
                if (row > col && row + col < matrixDimension - 1) {
                    array[row][col] = leftValue;
                    continue;
                }
                if (row < col && row + col > matrixDimension - 1) {
                    array[row][col] = rightValue;
                }
            }
        }
        return array;
    }

    private static ArrayList<ArrayList<Integer>> arrayListMatrix(int matrixDimension, int mainDiagValue, int sndDiagValue,
                                                                 int centerValue, int leftValue, int upValue, int rightValue, int bottomValue) {

        ArrayList<ArrayList<Integer>> array = new ArrayList<>(matrixDimension);
        for (int row = 0; row < matrixDimension; row++) {
            ArrayList<Integer> newRow = new ArrayList<>(matrixDimension); // new row
            for (int col = 0; col < matrixDimension; col++) {
                newRow.add(0);
            }
            array.add(newRow);
        }

        boolean hasCenter = matrixDimension % 2 == 1 ? true : false;

        for (int row = 0; row < matrixDimension; row++) {
            for (int col = 0; col < matrixDimension; col++) {
                if (row == col) {
                    array.get(row).set(col, mainDiagValue);
                    if (row == matrixDimension / 2 && hasCenter) {
                        array.get(row).set(col, centerValue);
                    }
                    continue;
                }
                if (row + col == matrixDimension - 1) {
                    array.get(row).set(col, sndDiagValue);
                    continue;
                }
                if (row < col && row + col < matrixDimension - 1) {
                    array.get(row).set(col, upValue);
                    continue;
                }
                if (row > col && row + col > matrixDimension - 1) {
                    array.get(row).set(col, bottomValue);
                    continue;
                }
                if (row > col && row + col < matrixDimension - 1) {
                    array.get(row).set(col, leftValue);
                    continue;
                }
                if (row < col && row + col > matrixDimension - 1) {
                    array.get(row).set(col, rightValue);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseV = scanner.nextInt();

        int matrixDimension = scanner.nextInt();
        int mainDiagValue = scanner.nextInt();
        int sndDiagValue = scanner.nextInt();
        int centerValue = 0;
        if (matrixDimension % 2 != 0)
            centerValue = scanner.nextInt();
        int leftValue = scanner.nextInt();
        int upValue = scanner.nextInt();
        int rightValue = scanner.nextInt();
        int bottomValue = scanner.nextInt();

        switch (caseV) {
            case 1:
                // arrays
                int[][] array = arrayMatrix(matrixDimension, mainDiagValue, sndDiagValue, centerValue, leftValue, upValue, rightValue, bottomValue);
                for (int[] row : array) {
                    for (int elem : row) {
                        System.out.print(elem + " ");
                    }
                    System.out.println();
                }
                break;

            case 2:
                // ArrayList
                ArrayList<ArrayList<Integer>> arrayList =
                        arrayListMatrix(matrixDimension, mainDiagValue, sndDiagValue, centerValue, leftValue, upValue, rightValue, bottomValue);
                for (ArrayList<Integer> row : arrayList) {
                    for (Integer elem : row) {
                        System.out.print(elem + " ");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
