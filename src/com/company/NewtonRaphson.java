package com.company;

public class NewtonRaphson {
    private Polynomial polynomial;
    private Polynomial derivetis;
    NewtonRaphson(){};

    public void setPolynomial(Polynomial polynomial) {
        this.polynomial = polynomial;
        this.derivetis = polynomial.Derivetis();
    }

    double getRoot(double x){
        for(int i=0;i<1000;i++){
            x = x - polynomial.F(x)/derivetis.F(x);
        }
        return x;

    }
}
