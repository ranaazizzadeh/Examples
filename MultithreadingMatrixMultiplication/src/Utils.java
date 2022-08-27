import java.util.Scanner;

public class Utils {
    public static int[][] getMatrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter matrix's row size: ");
        int rowSize = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter matrix's column size: ");
        int columnSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                System.out.println("Enter element of " + i + "," + j + " :");
                matrix[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("given matrix is:");
        printMatrix(matrix);
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
