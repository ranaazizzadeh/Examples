public class MatrixRowMultiplier extends Thread {

    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] result;
    private int rowNumber;

    public MatrixRowMultiplier(int[][] matrix1, int[][] matrix2, int[][] result, int rowNumber) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.rowNumber = rowNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < matrix2[0].length; i++) {
            result[rowNumber][i] = 0;
            for (int j = 0; j < matrix1[rowNumber].length; j++)
                result[rowNumber][i] += matrix1[rowNumber][j] * matrix2[j][i];
        }
    }
}
