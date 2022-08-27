public class MatrixRowColumnMultiplier extends Thread{
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] result;
    private int rowNumber;
    private int columnNumber;

    public MatrixRowColumnMultiplier(int[][] matrix1, int[][] matrix2, int[][] result, int rowNumber, int columnNumber) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    @Override
    public void run() {
            result[rowNumber][columnNumber] = 0;
            for (int j = 0; j < matrix1[rowNumber].length; j++)
                result[rowNumber][columnNumber] += matrix1[rowNumber][j] * matrix2[j][columnNumber];

    }
}
