package CurveFitting;

public class PolynomialFitting {
    private Matrix matrixX;
    private Matrix matrixY;
    PolynomialFitting (double X[],double Y[], int degree){
        if(X.length != Y.length){
            System.out.println("sorry");
            return;
        }
        double mat[][] = new double[X.length][degree+1];
        for (int i=0;i<X.length;i++){
            double ter = 1;
            mat[i][0] = 1;
            for(int j=1;j<=degree;j++){
                mat[i][j] = mat[i][j-1]*X[i];
            }
        }
        matrixX = new Matrix(mat);
        double y[][] = new double[Y.length][1];
        for (int i=0;i<Y.length;i++){
            y[i][0]= Y[i];
        }
        matrixY = new Matrix(y);
        matrixX.printMatrix();
        matrixY.printMatrix();

    }

    Matrix CoficientMatrix(){
        Matrix transpose = matrixX.trnsPose();
        Inverse inverse = new Inverse(transpose.mul(matrixX));
        Matrix right = transpose.mul(matrixY);
        return inverse.getInverse().mul(right);
    }
}
