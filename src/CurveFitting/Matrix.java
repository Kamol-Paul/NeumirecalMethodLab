package CurveFitting;

public class Matrix {
    private int rowNumber;
    private int colNumber;
    public double[][] data;

    Matrix(){

    }

    Matrix(int rowNumber, int colNumber){
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.data = new double[rowNumber][colNumber];
    }
    Matrix(int sq){
        this.colNumber = sq;
        this.rowNumber = sq;
        this.data = new double[this.rowNumber][this.colNumber];
    }
    Matrix(double[][] mat){
        this.data = mat;
        this.rowNumber = mat.length;
        this.colNumber = mat[0].length;
    }

    public int getColNumber() {
        return colNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    void makeIdentity(){
        if(rowNumber==colNumber){
            for(int i=0;i<rowNumber;i++){
                for(int j=0;j<colNumber;j++){
                    this.data[i][j] = (i==j)?1:0;
                }
            }
        }
        else{
            System.out.println("The Matrix is not squire. Identity matrix must be squire.");
        }
    }
    boolean isSquire(){
        return this.colNumber==this.rowNumber;
    }
    void printMatrix(){
        for(int i=0;i<rowNumber;i++){

            for(int j=0;j<colNumber;j++){
                System.out.print(this.data[i][j]+" ");
            }
            System.out.println("");
        }
    }

    Matrix trnsPose(){
        double matrix[][] = new double[colNumber][rowNumber];
        for(int i=0;i<rowNumber;i++){
            for(int j=0;j<colNumber;j++){
                matrix[j][i] = this.data[i][j];
            }

        }
        return new Matrix(matrix);
    }

    double[][] getData(){
        return this.data;
    }

    Matrix mul(Matrix second){
        // this.Maritx * second
        double[][]B = second.getData();
        if(this.colNumber != B.length){
            System.out.println("Error Diamention");
            return new Matrix();

        }
        double[][] ans = new double[this.rowNumber][B[0].length];

        for(int i=0;i<this.rowNumber;i++){
            for(int j=0;j<B[0].length;j++){
                ans[i][j] = 0;
                for(int k = 0;k<this.colNumber;k++){
                    ans[i][j] += this.data[i][k]*B[k][j];
                }
            }
        }
        return new Matrix(ans);
    }
    Matrix div(double x){
        double ans[][] = this.data.clone();
        for(int i =0;i<rowNumber;i++){
            for (int j = 0; j<colNumber;j++){
                ans[i][j] = this.data[i][j]/x;
            }
        }
        return new Matrix(ans);

    }

}
