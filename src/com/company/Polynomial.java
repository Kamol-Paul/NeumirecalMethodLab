package com.company;


public class Polynomial {
    private int degree;
    private double poly[];

    public Polynomial(){
    }
    Polynomial(double[] poly){
        this.poly = poly;
        degree = poly.length;
    }

    public void setDegree(int deg){
        this.degree = deg;
    }

    public void setPoly(double poly[]){
        this.poly = poly.clone();
        this.degree = poly.length;
    }

    public void  showPolynomial(){
        int x = this.degree-1;
        for(int i= x;i>0;i--){
            System.out.print(poly[i] + " X^" + i);
            System.out.print(" + ");
        }
        System.out.println(poly[0]);
    }
    public double F(double x){
        double ans = 0;
        double ini = 1;
        for(double it : poly){
            ans += it * ini;
            ini *= x;
        }
        return  ans;

    }
    public Polynomial Derivetis(){
        if(degree <=0){
            Polynomial ans = new Polynomial();
            ans.degree = 0;
            return  ans;
        }
        double pol[] = new double[degree];
        for(int i=1;i<degree;i++){
            pol[i-1] = i*poly[i];
        }
        Polynomial ans = new Polynomial();
        ans.setDegree(degree-1);
        ans.setPoly(pol);
        return ans;

    }

}
