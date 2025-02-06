public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;



    public RightTriangle(Location location, char pattern, int width, int height, int direction){
        super(location,pattern);
        this.width=width;
        this.height=height;
        switch(direction){
            case 0:
                this.d=Direction.LEFT_UP;
                break;
            case 1:
                this.d=Direction.LEFT_DOWN;
                break;
            case 2:
                this.d=Direction.RIGHT_UP;
                break;
            case 3:
                this.d=Direction.RIGHT_DOWN;
                break;
        }
        fillGrids();
    }



    public void fillGrids(){
        grids=new char[height][width];
        switch(d){
            case RIGHT_UP :
                for(int column=width-1;column>=0;column--){
                    int finalrow=height-1-((width-1-column)*(height/width)+((width-1-column)*(height%width))/width);
                    for(int row=finalrow;row>=0;row--){
                        grids[row][column]=pattern;
                    }
                }
                for(int column=0;column<width;column++){
                    for(int row=0;row<height;row++){
                        if(grids[row][column]!=pattern){
                            grids[row][column]=' ';
                        }
                    }
                }
                break;



            case LEFT_UP:
                for(int column=0;column<width;column++){
                    int finalrow=height-1-(column*(height/width)+(column*(height%width))/width);
                    for(int row=finalrow;row>=0;row--){
                        grids[row][column]=pattern;
                    }
                }
                for(int column=0;column<width;column++){
                    for(int row=0;row<height;row++){
                        if(grids[row][column]!=pattern){
                            grids[row][column]=' ';
                        }
                    }
                }
                break;

            case RIGHT_DOWN:
                for(int column=width-1;column>=0;column--){
                    int initial=(width-1-column)*(height/width)+((width-1-column)*(height%width))/width;
                    for(int row=initial;row<height;row++){
                        grids[row][column]=pattern;
                    }
                }
                for(int column=0;column<width;column++){
                    for(int row=0;row<height;row++){
                        if(grids[row][column]!=pattern){
                            grids[row][column]=' ';
                        }
                    }
                }
                break;


            case LEFT_DOWN:
                for(int column=0;column<width;column++){
                    int initial=column*(height/width)+(column*(height%width))/width;
                    for(int row=initial;row<height;row++){
                        grids[row][column]=pattern;
                    }
                }
                for(int column=0;column<width;column++){
                    for(int row=0;row<height;row++){
                        if(grids[row][column]!=pattern){
                            grids[row][column]=' ';
                        }
                    }
                }


        }

    }
    public void enlarge(){
        height++;
        width++;
        fillGrids();
    }
    public void shrink(){
        height--;
        width--;
        fillGrids();
    }
    //Both Circle and RightTriangle should return the count of filled grids.
    public int area(){
        fillGrids();
        int area=0;
        for(int column=0;column<width;column++){
            for(int row=0;row<height;row++){
                if(grids[row][column]==pattern){
                    area++;
                }
            }
        }
        return area;
    }
    public String toString(){
        return String.format("RightTriangle: %s area=%d pattern=%c",location.toString(),area(),pattern);
    }



}