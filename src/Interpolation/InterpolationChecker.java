package Interpolation;

public class InterpolationChecker {
    public static void main(String[] args) {
        double[] X = {0,1,2,3};
        double[] Y = {1,0,1,10};
        NewtonForwardFormula newtonForwardFormula = new NewtonForwardFormula(X,Y);
        System.out.println(newtonForwardFormula.F(0.5));

    }
}
