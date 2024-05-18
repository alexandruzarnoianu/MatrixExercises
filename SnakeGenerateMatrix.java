import java.util.Scanner;

public class SnakeGenerateMatrix {

    private static int[][] horizDec(int n, int m) {
        int[][] matrix = new int[n][m];
        boolean leftToRightDirection = n * m != 10 ? true : false;
        int crtValue = n * m;
        for (int i = 0; i < n; i++) {
            leftToRightDirection = !leftToRightDirection;
            for (int j = 0; j < m; j++) {
                if (leftToRightDirection) {
                    matrix[i][j] = crtValue;
                } else {
                    matrix[i][m - j - 1] = crtValue;
                }
                crtValue--;
            }
        }
        return matrix;
    }

    private static int[][] vertInc(int n, int m) {
        int[][] matrix = new int[n][m];
        boolean upToDownDirection = false;
        int crtValue = 1;
        for (int j = 0; j < m; j++) {
            upToDownDirection = !upToDownDirection;
            for (int i = 0; i < n; i++) {
                if (upToDownDirection) {
                    matrix[i][j] = crtValue;
                } else {
                    matrix[n - i - 1][j] = crtValue;
                }
                crtValue++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] mat = new int[1][1];
        switch (a) {
            case 1:
                mat = horizDec(n, m);
                break;
            case 2:
                mat = vertInc(n, m);
                break;
        }

        for (int[] row : mat) {
            for (int num : row) {
                if (num < 10) System.out.print(" " + num + " ");
                else System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
