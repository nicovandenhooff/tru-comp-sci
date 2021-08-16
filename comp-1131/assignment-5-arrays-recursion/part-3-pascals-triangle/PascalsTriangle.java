//****************************************************************************************************
// COMP 1131 Assignment 5 Question 3 (Part 1: Pascal's Triangle Recursive Program)
// This is a recursive program that determines and prints up to the Nth line of Pascal's triangle.
//****************************************************************************************************

public class PascalsTriangle {
    // instance variable that will hold pascals triangle values in a 2D array
    private int[][] triangle;

    // -----------------------------------------------------------------------------------------------
    // sets up an array to hold the values of pascal's triangle
    // -----------------------------------------------------------------------------------------------
    public PascalsTriangle(int rows, int columns) {
        triangle = new int[rows][columns];
    }

    // -----------------------------------------------------------------------------------------------
    // recursive method that will fill the rows/columns of pascal's triangle
    // -----------------------------------------------------------------------------------------------
    public int pascal(int n, int d) {
        // fills a 1 into the array for column 0, or where row index = column index
        if (d == 0 || n == d)
            return 1;
        // fills all other values using a recursive definition
        else
            return pascal(n - 1, d - 1) + pascal(n - 1, d);
    }

    // -----------------------------------------------------------------------------------------------
    // fills a PascalsTriangle array with the relevant values using recursive method
    // above
    // -----------------------------------------------------------------------------------------------
    public void fillarray(int k) {
        for (int i = 0; i < k; i++)
            for (int j = 0; j <= i; j++)
                triangle[i][j] = pascal(i, j);
    }

    // -----------------------------------------------------------------------------------------------
    // returns a string representation of pascal's triangle
    // -----------------------------------------------------------------------------------------------
    public String toString() {
        String triangleString = "";

        // loops through array printing all values except 0s in array
        for (int row = 0; row < triangle.length; row++) {
            for (int col = 0; col < triangle[row].length; col++) {
                if (triangle[row][col] == 0)
                    triangleString += "";
                else
                    triangleString += triangle[row][col];
            }
            triangleString += "\n";
        }

        return triangleString;
    }
}
