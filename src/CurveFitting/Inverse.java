package CurveFitting;

public class Inverse{
    private Matrix matrix;
    Inverse(Matrix matrix) {
        if(matrix.isSquire())
            this.matrix = matrix;
        else {
            System.out.println("NO Inverse exist");
        }
    }

    public double getDet(){
        //matrix.printMatrix();
        double ans = 0;
        int sign = 1;
        if(matrix.getColNumber() == 1) return matrix.getData()[0][0];

        for(int i=0;i<matrix.getColNumber();i++){
            Matrix newM = spanMatrix(0,i);
            //newM.printMatrix();
            Inverse temp = new Inverse(newM);

            ans += sign * temp.getDet() * matrix.getData()[0][i];
            sign *= -1;
        }
        return ans;
    }
    Matrix spanMatrix(int row, int col){
        double[][] newMat = new double[matrix.getColNumber()-1][matrix.getColNumber()-1];
        double[][] data = matrix.getData();
        for(int i=0;i<matrix.getRowNumber();i++){
            for(int j=0;j<matrix.getColNumber();j++){
                if(i==row || j==col) continue;
                int x = i;
                int y = j;
                if(x>row) x--;
                if(y>col) y--;
                newMat[x][y] = data[i][j];
            }
        }
        return new Matrix(newMat);
    }

    public Matrix getMatrix() {
        return matrix;
    }
    public Matrix getAdjoint(){
        double ans[][] = new double[matrix.getColNumber()][matrix.getColNumber()];
        int sign = 1;
        for (int i=0;i<matrix.getColNumber();i++){
            for(int j= 0;j<matrix.getColNumber();j++){
                if(((i+j)&1) == 0) sign = 1;
                else sign = -1;
                ans[i][j] = sign * (new Inverse(spanMatrix(i,j))).getDet();
            }
        }

        return new Matrix(ans).trnsPose();
    }

    public Matrix getInverse(){
        double det = getDet();
        if(det == 0){
            System.out.println("Inverse does not exist");
            return new Matrix();
        }
        return getAdjoint().div(det);
    }

}
