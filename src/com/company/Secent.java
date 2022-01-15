package com.company;

public class Secent {
    private Polynomial polynomial;

    Secent(){};

    public void setPolynomial(Polynomial polynomial) {
        this.polynomial = polynomial;
    }
    public double getRoot(double x, double x1){
        double next;
        int iter = 10;
        while (iter-->0){
            if(polynomial.F(x)==0){
                break;
            }

            next = x1 - ((polynomial.F(x1) * (x-x1))/(polynomial.F(x)-polynomial.F(x1)));

            x = x1;
            x1 = next;

        }
        return x1;
    }
}
