package Interpolation;

public class NewtonDivided {
    double[] X;
    double[] Y;
    double [][] delY;
    double []cof;
    int n;
    NewtonDivided(double[] x, double[] y){
        this.X = x;
        this.Y = y;
        this.n = this.X.length;
        delY = new double[n][n];
        cof = new double[this.n];

        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.n-i;j++){
                if(i==0) delY[j][0]=Y[j];
                else delY[j][i] = (delY[j+1][i-1]-delY[j][i-1])/(X[j+i]-X[j]);
                //if(i>0)System.out.print((delY[j+1][i-1])+" "+(delY[j][i-1])+" "+X[j+i]+" "+X[j]+" ");
            }//
            //System.out.println("");
        }
//        for(int i=0;i<this.n;i++){
//            for(int j=0;j<this.n-i;j++){
//                System.out.print(String.format("%5.10f",delY[i][j])+" ");
//            }
//            System.out.println();
//        }
        this.getCofficient();

    }
    private void getCofficient(){

        cof[0] = Y[0];
        for(int i=1;i<this.n;i++){
            cof[i] = delY[0][i];
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
