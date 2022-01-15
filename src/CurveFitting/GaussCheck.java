package CurveFitting;

public class GaussCheck {
    public static void main(String[] args) {
        //double equ[][]={{1,1,1,6},{2,1,1,7},{1,2,1,8}};
        double equ[][]={{1,2,-1,5},{3,3,2,1},{-1,2,-1,2}};
        GaussinanElemination gaussinanElemination = new GaussinanElemination(new Matrix(equ));
        gaussinanElemination.getAns().printMatrix();
        gaussinanElemination.printAns();
    }
}
