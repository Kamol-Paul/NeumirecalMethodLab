package com.company;

public class Bisection {
    private Polynomial polynomial;
    private double rangeL,rangeR;
    Bisection(){};

    public void setPolynomial(Polynomial polynomial) {
        this.polynomial = polynomial;
    }

    public void setRange(double rangeL, double rangeR) {

        this.rangeL = rangeL;
        this.rangeR = rangeR;

    }

    public boolean isPos(){
        return polynomial.F(rangeL)*polynomial.F(rangeR)<=0;
    }
    public double getRoot(){
        double mid = (rangeL+rangeR)/2.0;
        double left = rangeL;
        double right = rangeR;

        for(int i = 0; i<1000;i++){
            mid = (left + right)/2.0;
            if(polynomial.F(mid) * polynomial.F(left) <=0){
                right = mid;
            }
            else left = mid;
        }
        return mid;
    }

}
