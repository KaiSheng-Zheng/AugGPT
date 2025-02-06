
public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    public int getX(){
        return location.getX();
    }
    public int getY(){
        return location.getY();
    }
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d=d;
        setGrids();
    }
    public void setGrids(){
        grids= new char[height][width];
        fillGrids();
    }
    public void fillGrids(){
        if(d== Direction.LEFT_DOWN){
            for(int row = 0; row<height;row++)
            {
                for (int column = 0 ; column< width ;column++){
                    int points = 0 ;
                    if(row*width>column*height){
                        points++;
                    }
                    if((row+1)*width>column*height){
                        points++;
                    }
                    if(row*width>(column+1)*height){
                        points++;
                    }
                    if((row+1)*width>(column+1)*height){
                        points++;
                    }
                    if(points>=1)
                    {
                        grids[row][column]=pattern;
                    }
                    else {
                        grids[row][column]=' ';
                    }
                }
            }
        }
        if(d== Direction.LEFT_UP) {
            char[][] transit = new char[height][width];
            for(int row = 0; row<height;row++)
            {
                for (int column = 0 ; column< width ;column++){
                    int points = 0 ;
                    if(row*width>column*height){
                        points++;
                    }
                    if((row+1)*width>column*height){
                        points++;
                    }
                    if(row*width>(column+1)*height){
                        points++;
                    }
                    if((row+1)*width>(column+1)*height){
                        points++;
                    }
                    if(points>=1)
                    {
                        transit[row][column]=pattern;
                    }else {
                        transit[row][column]=' ';
                    }
                }
            }
            for(int row = 0 ; row<height;row++){
                for(int column = 0 ;column<width;column++){
                    grids[row][column]=transit[height-1-row][column];
                }
            }
        }
        if(d== Direction.RIGHT_DOWN){
            char[][] transit = new char[height][width];
            for(int row = 0; row<height;row++)
            {
                for (int column = 0 ; column< width ;column++){
                    int points = 0 ;
                    if(row*width>column*height){
                        points++;
                    }
                    if((row+1)*width>column*height){
                        points++;
                    }
                    if(row*width>(column+1)*height){
                        points++;
                    }
                    if((row+1)*width>(column+1)*height){
                        points++;
                    }
                    if(points>=1)
                    {
                        transit[row][column]=pattern;
                    }else {
                        transit[row][column]=' ';
                    }
                }
            }
            for(int column = 0 ;column< width;column++)
            {
                for(int row = 0 ;row<height;row++)
                {
                    grids[row][column]=transit[row][width-1-column];
                }
            }
        }
        if(d== Direction.RIGHT_UP){
            char[][] transit = new char[height][width];
            for(int row = 0; row<height;row++)
            {
                for (int column = 0 ; column< width ;column++){
                    int points = 0 ;
                    if(row*width>column*height){
                        points++;
                    }
                    if((row+1)*width>column*height){
                        points++;
                    }
                    if(row*width>(column+1)*height){
                        points++;
                    }
                    if((row+1)*width>(column+1)*height){
                        points++;
                    }
                    if(points>=1)
                    {
                        transit[row][column]=pattern;
                    }else {
                        transit[row][column]=' ';
                    }
                }
            }
            for(int row = 0 ;row<height;row++)
            {
                for(int column = 0 ; column<width;column++){
                    grids[row][column]=transit[height-1-row][width-1-column];
                }
            }
        }
    }
    public void enlarge(){
        height++;
        width++;
        setGrids();
    }
    public void shrink(){
        height--;
        width--;
        setGrids();
    }
    public int area(){
        int area=0;
        for(int row = 0 ;row<height;row++)
        {
            for (int column = 0 ; column<width;column++)
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
        String string = "RightTriangle: "+location.toString()+" area="+area()+" pattern="+pattern;
        return string;
    }
}
