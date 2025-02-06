

public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        setGrids();
    }
    public int getX(){
        return location.getX();
    }
    public int getY(){
        return location.getY();
    }
    public void setGrids(){
        this.grids = new char[radius*2][radius*2];
        fillGrids();
    }
    public void fillGrids(){
        for(int row = 0 ; row<radius*2;row++ )
        {
            for(int column = 0 ; column<radius*2;column++){
                int points = 0;
                if((row-radius)*(row-radius)+(column-radius)*(column-radius)<radius*radius){
                    points++;
                }
                if((row+1-radius)*(row+1-radius)+(column-radius)*(column-radius)<radius*radius){
                    points++;
                }
                if((row-radius)*(row-radius)+(column+1-radius)*(column+1-radius)<radius*radius){
                    points++;
                }
                if((row+1-radius)*(row+1-radius)+(column+1-radius)*(column+1-radius)<radius*radius){
                    points++;
                }
                if(points>=1){
                    grids[row][column]= pattern;
                }
                else {
                    grids[row][column]=' ';
                }
            }
        }
    }
    public void enlarge(){
        radius++;
        setGrids();
    }
    public void shrink(){
        radius--;
        setGrids();
    }
    public int area(){
        int area=0;
        for(int row = 0 ;row<2*radius;row++)
        {
            for (int column = 0 ; column<2*radius;column++)
            {
                if (grids[row][column]==pattern)
                {
                    area++;
                }
            }
        }
        return area;
    }
    public String toString(){
        String string = "Circle: "+location.toString()+" area="+area()+" pattern="+pattern;
        return string;
    }
}
