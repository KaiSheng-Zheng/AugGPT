public class Circle extends Shape{
    private int radius;
    public Circle(Location location,char pattern,int radius){
        super(location,pattern);
        this.radius = radius;
        grids = new char[radius*2][radius*2];
        for(int i = 0 ; i<radius*2 ;i++){
            for(int j = 0; j<radius*2 ;j++){
                grids[i][j]=" ".charAt(0);
            }
        }
        fillGrids();
    }

    @Override
    public void fillGrids(){
        double radius_Double = radius*1.0;
        for(int i = 1 ; i<radius*2 ; i++){
            for(int j = 1 ;j<radius*2;j++){
                double distance = Math.sqrt(Math.pow(i-radius,2)+Math.pow(j-radius,2));
                if (i<=radius && j<=radius) {
                    if(distance < radius_Double){grids[i-1][j-1] = pattern;}
                    else{grids[i-1][j-1] = " ".charAt(0);}
                }
                if (i>=radius && j<=radius) {
                    if(distance < radius_Double){grids[i][j-1] = pattern;}
                    else{grids[i][j-1] = " ".charAt(0);}
                }
                if (i<=radius && j>=radius) {
                    if(distance < radius_Double){grids[i-1][j] = pattern;}
                    else{grids[i-1][j] = " ".charAt(0);}
                }
                if (i>=radius && j>=radius) {
                    if(distance < radius_Double){grids[i][j] = pattern;}
                    else{grids[i][j] = " ".charAt(0);}
                }
            }
        }
    }
    @Override
    public void enlarge() {
        radius += 1;
        grids = new char[radius*2][radius*2];
        for(int i = 0 ; i<radius*2 ;i++){
            for(int j = 0; j<radius*2 ;j++){
                grids[i][j]=" ".charAt(0);
            }
        }
        fillGrids();
    }

    @Override
    public void shrink() {
        radius -=1 ;
        grids = new char[radius*2][radius*2];
        for(int i = 0 ; i<radius*2 ;i++){
            for(int j = 0; j<radius*2 ;j++){
                grids[i][j]=" ".charAt(0);
            }
        }
        fillGrids();
    }
    @Override
    public int area(){
        int Area = 0;
        for(int i = 0;i < 2*radius;i++){
            for(int j = 0 ; j < 2*radius ; j++){
                if (grids[i][j] == pattern){Area++;}
            }
        }
        return Area;
    }
    public String toString(){
        return("Circle: " + location.toString() + " area=" + String.valueOf(area()) +  " pattern=" + pattern);
    }

}
