public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
    }


    public void fillGrids(){
        grids=new char[2*radius][2*radius];
        for(int row=0;row<radius;row++){
            for(int column=0;column<radius;column++){
                if((radius-1-row)*(radius-1-row)+(radius-1-column)*(radius-1-column)-radius*radius>=0){
                    grids[row][column]=' ';
                }
            }
        }
        for(int row=0;row<radius;row++){
            for(int column=radius;column<2*radius;column++){
                if((radius-1-row)*(radius-1-row)+(column-radius)*(column-radius)-radius*radius>=0){
                    grids[row][column]=' ';
                }
            }
        }
        for(int row=radius;row<2*radius;row++){
            for(int column=0;column<radius;column++){
                if((row-radius)*(row-radius)+(radius-1-column)*(radius-1-column)-radius*radius>=0){
                    grids[row][column]=' ';
                }
            }
        }
        for(int row=radius;row<2*radius;row++){
            for(int column=radius;column<2*radius;column++){
                if((row-radius)*(row-radius)+(column-radius)*(column-radius)-radius*radius>=0){
                    grids[row][column]=' ';
                }
            }
        }
        for(int row=0;row<2*radius;row++){
            for(int column=0;column<2*radius;column++){
                if(grids[row][column]!=' '){
                    grids[row][column]=pattern;
                }
            }
        }
    }
    public void enlarge(){
        radius++;
        fillGrids();

    }
    public void shrink(){
        radius--;
        fillGrids();

    }

    //Both Circle and RightTriangle should return the count of filled grids.
    public int area(){
        fillGrids();
        int area=0;
        for(int column=0;column<2*radius;column++){
            for(int row=0;row<2*radius;row++){
                if(grids[row][column]==pattern){
                    area++;
                }
            }
        }
        return area;
    }
    public String toString(){
        return String.format("Circle: %s area=%d pattern=%c",location.toString(),area(),pattern);
    }

}