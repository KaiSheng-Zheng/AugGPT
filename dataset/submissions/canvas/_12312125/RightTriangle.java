public class RightTriangle extends Shape{
    private int count;
    private int width;
    private int height;
    private final Direction d;
    public boolean ifIn(int x, int y){
        if (d == Direction.LEFT_UP){
            if (y*height + x*width < width*height)
                return true;
            if ((y+1)*height + x*width < width*height)
                return true;
            if (y*height + (x+1)*width < width*height)
                return true;
            if ((y+1)*height + (x+1)*width < width*height)
                return true;
        }
        if (d == Direction.LEFT_DOWN){
            if (y*height < x*width)
                return true;
            if ((y+1)*height < x*width)
                return true;
            if (y*height < (x+1)*width)
                return true;
            if ((y+1)*height < (x+1)*width)
                return true;
        }
        if (d == Direction.RIGHT_UP){
            if (y*height > x*width)
                return true;
            if ((y+1)*height > x*width)
                return true;
            if (y*height > (x+1)*width)
                return true;
            if ((y+1)*height > (x+1)*width)
                return true;
        }
        if (d == Direction.RIGHT_DOWN){
            if (y*height + x*width > width*height)
                return true;
            if ((y+1)*height + x*width > width*height)
                return true;
            if (y*height + (x+1)*width > width*height)
                return true;
            return (y + 1) * height + (x + 1) * width > width * height;
        }
        return false;
    }
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }
    public void fillGrids(){
        count = 0;
        this.grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (ifIn(i,j)) {
                    grids[i][j] = pattern;
                    count++;
                }
                else grids[i][j] = ' ';
            }
        }
    }
    public void enlarge(){
        height ++;
        width ++;
        fillGrids();
    }
    public void shrink(){
        height --;
        width --;
        fillGrids();
    }
    public int area(){
        return count;
    }
    public String toString(){
        return "RightTriangle: (" + location.getX() + ',' + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }
}
