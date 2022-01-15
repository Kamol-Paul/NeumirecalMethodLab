package com.company;

public class FalseMethod {
    private Polynomial polynomial;
    private double rangeL,rangeR;
    FalseMethod(){};

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
        double mid = 0;
        double left = rangeL;
        double right = rangeR;

        for(int i = 0; i<1000;i++){
            mid = (left*polynomial.F(right) - right*polynomial.F(left))/(polynomial.F(right)-polynomial.F(left));
            if(polynomial.F(mid) * polynomial.F(left) <=0){
                right = mid;
            }
            else left = mid;
        }
        return mid;
    }

}
