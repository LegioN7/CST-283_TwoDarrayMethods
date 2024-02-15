
// CST-283
// Aaron Pelto
// Winter 2024

// Add methods to set already completed that will do the following:
// Identify the row number of the row with the greatest sum
// Identify the column number of the column with the lowest sum
// Given an integer parameter n, average all elements in the 2-D array for row n and column n.
// Return the largest average of the two.
public class TwoDarrayMethods {
    final static int NUM_ROWS = 4;
    final static int NUM_COLS = 4;

    public static void main(String[] args) {

        // Declare and initialize an array
        double[][] matrix = {{1.2, 2.3, 3.4, 4.5},
                {6.7, 7.8, 8.9, 9.1},
                {2.4, 3.5, 4.6, 5.7},
                {7.9, 8.1, 9.3, 1.4}};

        // Print out the array
        System.out.println("Matrix:\n" + arraytoString(matrix));

        // Print out the results of the methods
        System.out.println("Results of Mr.Klingler's methods:");
        System.out.println("  Max value: " + maxValue(matrix));
        System.out.println("  Min value: " + minValue(matrix));
        System.out.println("  Sum of elements: " + sumElements(matrix));
        System.out.println("  Sum of row 2: " + sumRow(matrix, 2));
        System.out.println("  Sum of column 1: " + sumCol(matrix, 1));
        System.out.println("  Sum of diagonal: " + sumDiag(matrix));
        System.out.println("  Sum of alt. diagonal: " + sumAltDiag(matrix));

        System.out.println("\nResults of Aaron's Methods:");
        System.out.println("  Row with greatest sum: " + sumRowGreatest(matrix));
        System.out.println("  Column with lowest sum: " + sumColLowest(matrix));
        System.out.println("  Largest average of row and column: " + averageAll(2, matrix));
        System.exit(0);
    }

    //  sumAll, sumRow, sumCol, sumDiag, sumAltDiag


    // --------------------------------------------------------
    // Method coverts a two-dimensional array of doubles to on
    // a String object.  Line breaks for rows are included.
    public static String arraytoString(double[][] matrix) {
        String outString = "";

        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++)
                outString += matrix[row][col] + " ";
            outString += "\n";
        }

        return outString;
    }

    // --------------------------------------------------------
    // Method determines max value in 2-D array
    public static double maxValue(double[][] matrix) {
        double max = Double.MIN_VALUE;
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++)
                if (matrix[row][col] > max)
                    max = matrix[row][col];
        }
        return max;
    }

    // --------------------------------------------------------
    // Method determines min value in 2-D array
    public static double minValue(double[][] matrix) {
        double min = Double.MAX_VALUE;
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++)
                if (matrix[row][col] < min)
                    min = matrix[row][col];
        }
        return min;
    }

    // --------------------------------------------------------
    // Method sums all elements in 2-D array
    public static double sumElements(double[][] matrix) {
        double sum = 0.0;
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++)
                sum += matrix[row][col];
        }
        return sum;
    }

    // --------------------------------------------------------
    // Method sums all elements in a given row of a 2-D array
    public static double sumRow(double[][] matrix, int rowTarget) {
        double sum = 0.0;
        for (int col = 0; col < NUM_COLS; col++)
            sum += matrix[rowTarget][col];
        return sum;
    }

    // --------------------------------------------------------
    // Method sums all elements in a given column of a 2-D array
    public static double sumCol(double[][] matrix, int colTarget) {
        double sum = 0.0;
        for (int row = 0; row < NUM_ROWS; row++)
            sum += matrix[row][colTarget];
        return sum;
    }

    // --------------------------------------------------------
    // Method sums all elements in the main diagonal of a 2-D array
    // PRE:  Number of rows and columns are the same
    public static double sumDiag(double[][] matrix) {
        double sum = 0.0;
        for (int row = 0; row < NUM_ROWS; row++)
            sum += matrix[row][row];
        return sum;
    }

    // --------------------------------------------------------
    // Method sums all elements in the opposite diagonal of a 2-D array
    // PRE:  Number of rows and columns are the same
    public static double sumAltDiag(double[][] matrix) {
        double sum = 0.0;
        int col = NUM_COLS - 1;
        for (int row = 0; row < NUM_ROWS; row++) {
            sum += matrix[row][col];
            col--;
        }
        return sum;
    }

    // Method to identify the row number of the row with the greatest sum
    public static double sumRowGreatest(double[][] matrix) {
        double sum = 0.0;
        double greatestSum = 0.0;
        int greatestRow = 0;
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++)
                sum += matrix[row][col];
            if (sum > greatestSum) {
                greatestSum = sum;
                greatestRow = row;
            }
        }
        return greatestRow;
    }

    // Method to identify the column number of the column with the lowest sum
    public static double sumColLowest(double[][] matrix) {
        double sum = 0.0;
        double lowestSum = Double.MAX_VALUE;
        int lowestCol = 0;
        for (int col = 0; col < NUM_COLS; col++) {
            for (int row = 0; row < NUM_ROWS; row++)
                sum += matrix[row][col];
            if (sum < lowestSum) {
                lowestSum = sum;
                lowestCol = col;
            }
        }
        return lowestCol;
    }

    // Method to average all elements in the 2-D array for row n and column n.
    // Return the largest average of the two.
    public static double averageAll(int n, double[][] matrix) {
        double sumRow = 0.0;
        double sumCol = 0.0;
        for (int col = 0; col < NUM_COLS; col++)
            sumRow += matrix[n][col];
        for (int row = 0; row < NUM_ROWS; row++)
            sumCol += matrix[row][n];
        double averageRow = sumRow / NUM_COLS;
        double averageCol = sumCol / NUM_ROWS;
        if (averageRow > averageCol)
            return averageRow;
        else
            return averageCol;
    }
}