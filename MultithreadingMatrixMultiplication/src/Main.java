import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Please enter firs matrix");
//        int[][] matrix1 = Utils.getMatrix();
//        System.out.println("Please enter second matrix");
//        int[][] matrix2 = Utils.getMatrix();
        int[][] matrix1 = {{3,0,1,1},{1,0,2,3},{0,0,1,1}};
        int[][] matrix2= {{1,2},{5,1},{0,1},{1,3}};
        int[][] result = new int[matrix1.length][matrix2[0].length];
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                MatrixRowColumnMultiplier matrixRowColumnMultiplier = new MatrixRowColumnMultiplier(matrix1,matrix2,result,i,j);
                matrixRowColumnMultiplier.start();
                threadList.add(matrixRowColumnMultiplier);

            }
//            MatrixRowMultiplier matrixRowMultiplier = new MatrixRowMultiplier(matrix1, matrix2, result, i);
//            matrixRowMultiplier.start();
//            threadList.add(matrixRowMultiplier);
        }

        threadList.forEach(x-> {
            try {
                x.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("The result is");
        Utils.printMatrix(result);
    }
}
