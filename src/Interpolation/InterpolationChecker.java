package Interpolation;

public class InterpolationChecker {
    public static void main(String[] args) {
//        double[] X = {0,1,2,3};
//        double[] Y = {1,0,1,10};
//        NewtonForwardFormula newtonForwardFormula = new NewtonForwardFormula(X,Y);
//        System.out.println(newtonForwardFormula.F(0.5));
        double X[] = {300,304,305,307};
        double Y[] = {2.4771,2.4829,2.4843,2.4871};
        NewtonDivided newtonDivided = new NewtonDivided(X,Y);
        System.out.println(newtonDivided.F(301));


    }
}
