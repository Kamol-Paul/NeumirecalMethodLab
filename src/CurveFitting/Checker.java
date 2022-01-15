package CurveFitting;

import com.company.Polynomial;

public class Checker {
    public static void main(String args[]){
//        Matrix matrix = new Matrix(4);
//        matrix.makeIdentity();
//        matrix.printMatrix();

        double[][] data = {{1, 4}, {1, 4.5}, {1, 5}, {1, 5.5},{1,6},{1,6.5},{1,7}};
        Matrix matrixX = new Matrix(data);
        Matrix trasposeX = matrixX.trnsPose();

        double[][] yData = {{33},{43},{45},{51},{53},{61},{63}};
        Matrix Y = new Matrix(yData);
        Matrix ans = trasposeX.mul(matrixX);
        //System.out.println("X' * X");
        //ans.printMatrix();

        Inverse make = new Inverse(ans);
        Matrix inv = make.getInverse();

        //System.out.println("Inverse of x' * x");
        //inv.printMatrix();
        //System.out.println(" ");
        Matrix right = trasposeX.mul(Y);
        //right.printMatrix();

        //System.out.println("X'");
        //trasposeX.printMatrix();

        //System.out.println('Y');
        //Y.printMatrix();
        Matrix ri = trasposeX.mul(Y);
        Matrix nas = inv.mul(ri);
        System.out.println("fsad");
        //nas.printMatrix();

        Matrix cal = matrixX.mul(nas);
        cal.printMatrix();
        double ml[][] = {{-30.14},{14}};
        Matrix ex = new Matrix(ml);
        matrixX.mul(ex).printMatrix();

        double X[] = {0,1,2};
        double YM[] = {1,6,17};

        PolynomialFitting polynomialFitting = new PolynomialFitting(X,YM,2);
        polynomialFitting.CoficientMatrix().printMatrix();

    }
}
