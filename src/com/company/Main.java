package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World!");
        System.out.println("Enter degree of polynomial");

        int deg;
        Scanner sc = new Scanner(System.in);
//        deg = sc.nextInt();
        deg = 3;
        System.out.println("Enter the polynomial as");
        for(int i =0 ;i<=deg;i++){
            System.out.print("a"+i+" * X^"+i+" ");
            if(i!= deg){
                System.out.print(" + ");
            }
        }
        System.out.println("");

        double poly[] = new double[deg+1];
//        for(int i=0;i<=deg;i++){
//            poly[i] = sc.nextInt();
//        }
        poly = new double[]{-1,0,1, 1};
        Polynomial polynomial= new Polynomial(poly);

        polynomial.showPolynomial();
        //System.out.println(polynomial.F(0));
        Bisection bisection = new Bisection();
        bisection.setPolynomial(polynomial);
        bisection.setRange( 0, 1);
//        System.out.println(polynomial.F(4));
        if(bisection.isPos()){
            System.out.println("bisection er result: " + bisection.getRoot());
        }
        else System.out.println("Wrong guess");

        FalseMethod falseMethod = new FalseMethod();
        falseMethod.setPolynomial(polynomial);
        falseMethod.setRange(0 , 1);
//        for(int i=-10;i<10;i++){
//            System.out.println("F(x= " + i +" )" +polynomial.F(i));
//
//        }
//        System.out.println(polynomial.F(4));
        if(falseMethod.isPos()){
            System.out.println("false method: "+falseMethod.getRoot());
            System.out.println(polynomial.F(falseMethod.getRoot()));

        }
        else System.out.println("Wrong guess");
//        polynomial.showPolynomial();
//        polynomial.Derivetis().showPolynomial();


        NewtonRaphson newtonRaphson = new NewtonRaphson();
        newtonRaphson.setPolynomial(polynomial);
        System.out.println("newton result: "+newtonRaphson.getRoot(1));
        System.out.println(polynomial.F(newtonRaphson.getRoot(1)));


        Secent secent = new Secent();
        secent.setPolynomial(polynomial);
        //polynomial.showPolynomial();
        System.out.println("Secent er result: " +secent.getRoot(1.0,1.5));
        System.out.println(polynomial.F(secent.getRoot(1.0,1.3)));

    }
}
