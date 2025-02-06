public class Circle extends Shape{

    private  int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }
    public boolean inTheCircle(int row,int column){
        double x = column;
        double y = row;
        double r = radius;
        if(row<=(radius-1)&column<=(radius-1)){
            if(Math.pow(r-x-1,2)+Math.pow(r-y-1,2)<Math.pow(r,2)){
                return true;
            }
            return  false;
        }
        else if (row>(radius-1)&column<=(radius-1)){
            if(Math.pow(r-x-1,2)+Math.pow(r-y,2)<Math.pow(r,2)){
                return true;
            }
            return false;
        }
        else if(row<=(radius-1)&column>(radius-1)){
            if(Math.pow(r-x,2)+Math.pow(r-y-1,2)<Math.pow(r,2)){
                return true;
            }
            return false;
        }
        else if(row>=(radius-1)&column>=(radius-1)){
            if(Math.pow(r-x,2)+Math.pow(r-y,2)<Math.pow(r,2)){
                return true;
            }
            return false;
        }
        return true;
    }
    public void fillGrids(){
        for (int i = 0; i < grids.length ; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if(inTheCircle(i,j)){
                    grids[i][j]=pattern;
                }else {
                    grids[i][j]=' ';
                }
            }
        }
    }
    public void enlarge(){
        radius++;
        grids =new char[2*radius][2*radius];
        fillGrids();
    }

    public void shrink(){
         if(radius>0) {
             radius--;
             grids = new char[2 * radius][2 * radius];
             fillGrids();
         }
    }

    @Override
    public int area() {
        int area = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (!(grids[i][j]==' ')){area++;}
            }
        }
        return area;
    }
    public String toString(){
        return String.format("Circle: %s area=%d pattern=%s",location.toString(),area(),pattern);
    }
}
