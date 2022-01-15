package CurveFitting;

public class GaussinanElemination {
    private Matrix systemOfLinearEquation;

    GaussinanElemination(Matrix matrix){
        this.systemOfLinearEquation = matrix;
    }

    public Matrix getAns(){
        int row = systemOfLinearEquation.getRowNumber();
        int col = systemOfLinearEquation.getColNumber();
        int span = 0;

        for(int index = 0;index<row;index++){
            int pivot = findPivot(index,span);
            while (pivot == -1 && span<col){
                span = span + 1;
                pivot = findPivot(index,span);
            }
            System.out.println("Pivot: "+ pivot);
            if(pivot == -1) break;
            if(pivot != index){
                for(int i = 0; i<col;i++){
                    double temp = systemOfLinearEquation.data[index][i];
                    systemOfLinearEquation.data[index][i] = systemOfLinearEquation.data[pivot][i];
                    systemOfLinearEquation.data[pivot][i]= temp;
                }
            }
            double val = systemOfLinearEquation.data[index][span];
            System.out.println("val: "+ val);

            for(int i = span;i<col;i++){
                systemOfLinearEquation.data[index][i] /= val;
            }

            for(int i=0;i<row;i++){
                if(i==index) continue;
                if(systemOfLinearEquation.data[i][span] == 0) continue;
                double div = -systemOfLinearEquation.data[i][span];
                System.out.println("div: "+ div);

                for(int j=span;j<col;j++){
                        systemOfLinearEquation.data[i][j] += systemOfLinearEquation.data[index][j]*div;
                }
            }
            System.out.println("After A Iteration");
            systemOfLinearEquation.printMatrix();
            span++;
        }
        return systemOfLinearEquation;
    }
    int findPivot(int from, int in){
        for(int i=from;i<systemOfLinearEquation.getRowNumber();i++){
            if(systemOfLinearEquation.getData()[i][in] != 0) return i;
        }
        return -1;
    }
    void printAns(){
        for (int i=0;i<systemOfLinearEquation.getRowNumber();i++){
            System.out.print("X"+i+": "+systemOfLinearEquation.data[i][systemOfLinearEquation.getRowNumber()]+" ");
        }
        System.out.println("");
    }
}
