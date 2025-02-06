public class RightTriangle extends Shape{
    private int width;

    private int height;

    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        if (width >=1 && width<=20) this.width = width;
        if (height >=1 && height<=20) this.height = height;
        this.d = d;
        fillGrids();
    }

    public int area(){
        int num = 0;
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) num++;
            }
        }
        return num;
    }

    public void enlarge(){
        width++;
        height++;
        fillGrids();
    }

    public void shrink(){
        width--;
        height--;
        fillGrids();
    }

    public void fillGrids(){
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch(d){
                    case LEFT_DOWN:
                        if((double)(height-i-1)/(width-j) < (double)height/width) grids[i][j] = pattern;
                        else grids[i][j] = ' ';
                        break;
                    case RIGHT_DOWN:
                        if((double)(height-i-1)/(j+1) < (double)height/width) grids[i][j] = pattern;
                        else grids[i][j] = ' ';
                        break;
                    case LEFT_UP:
                        if((double)i/(width-j) < (double)height/width) grids[i][j] = pattern;
                        else grids[i][j] = ' ';
                        break;
                    case RIGHT_UP:
                        if((double)i/(j+1) < (double)height/width) grids[i][j] = pattern;
                        else grids[i][j] = ' ';
                        break;
                }
            }
        }
    }
    public String toString(){
        return "RightTriangle" +super.toString();
    }


}
