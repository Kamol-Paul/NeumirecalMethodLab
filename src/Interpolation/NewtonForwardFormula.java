package Interpolation;

public class NewtonForwardFormula {
    double[] X;
    double[] Y;
    double [][] delY;
    double []cof;
    int n;
    double h;
    NewtonForwardFormula(double []x, double[] y){
        this.X = x;
        this.Y = y;
        this.n = this.X.length;
        delY = new double[n][n];
        cof = new double[this.n];
        this.h = this.X[1]-this.X[0];
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.n-i;j++){
                if(i==0) delY[j][0]=Y[j];
                else delY[j][i] = delY[j+1][i-1]-delY[j][i-1];
                //System.out.print(delY[i][j]+" ");
            }
            //System.out.println("");
        }
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.n-i;j++){
                System.out.print(String.format("%5f",delY[i][j])+" ");
            }
            System.out.println();
        }
        this.getCofficient();

    }
    private void getCofficient(){
        double curH = 1;
        double curFac = 1;
        cof[0] = Y[0];
        for(int i=1;i<this.n;i++){
            curH*=h;
            curFac *= i;
            cof[i] = delY[0][i]/(curFac*curH);
        }
    }
    double F(double x){
        double y;
        double last = 1;
        y = cof[0];
        for(int i=1;i<this.n;i++){
            last = last * (x-X[i-1]);
            y += last*cof[i];
        }
        return y;
    }

}
