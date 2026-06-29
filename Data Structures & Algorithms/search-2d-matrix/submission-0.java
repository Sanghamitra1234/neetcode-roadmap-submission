class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

     //   System.out.println(row+" "+col);

        while (row >= 0 && row < matrix.length 
            && col >= 0 && col < matrix[0].length) {
                int searchNumber = matrix[row][col];
                
                if (target == searchNumber) return true;
                if (target > searchNumber) row++;
                else col--;
               // System.out.println("searchNumber: "+ searchNumber +" row: "+ row + " col: " +col);
            }
            return false;
    }
}
