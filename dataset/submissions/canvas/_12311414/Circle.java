public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        char[][] grid = new char[2*radius][2*radius];
        for (int i = 0; i < 2*radius; i++){
            for (int j = 0; j < 2*radius; j++){
                if(i<(2*radius-1)&&j<(2*radius-1)){
                    if(ifFill(i,j)||ifFill(i+1,j)||ifFill(i,j+1)||ifFill(i+1,j+1)){
                        grid[i][j] = super.pattern;
                    }else{grid[i][j] = ' ';}
                }else if(i==(2*radius-1)&&j<(2*radius-1)){
                    if(ifFill(i,j)||ifFill(i,j+1)){
                        grid[i][j] = super.pattern;
                    }else{grid[i][j] = ' ';}
                }else if(i<(2*radius-1)&&j==(2*radius-1)){
                    if(ifFill(i,j)||ifFill(i+1,j)){
                        grid[i][j] = super.pattern;
                    }else{grid[i][j] = ' ';}
                }else if(i==(2*radius-1)&&j==(2*radius-1)){
                    if(ifFill(i,j)){
                        grid[i][j] = super.pattern;
                    }else{grid[i][j] = ' ';}
                }
            }
        }
        this.grids = grid;
    }

    @Override
    public void enlarge() {
        this.radius+=1;
        this.fillGrids();


    }

    @Override
    public void shrink() {
        this.radius-=1;
        this.fillGrids();

    }

    @Override
    public int area() {
        int area = 0;
        for (int i = 0; i < 2*radius; i++){
            for (int j = 0; j < 2*radius; j++){
                if(super.getGrids()[i][j] == super.pattern){
                    area++;
                }
            }
        }
        return area;
    }

    private boolean ifFill(int i, int j){
        int x = i - radius ;
        int y = j - radius ;
        if (x*x + y*y < radius*radius){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        String string= String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(),location.getY(),area(),pattern);
        return string;
    }
}