public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        this.fillGrids();
    }
    public void fillGrids(){
        double tan= (double) width /height;
        grids=new char[height][width];
        if (d == Direction.RIGHT_UP) {
            for (int i=height-1;i>=0;i--){
                for (int j=width-1;j>=0;j--){
                    if ((height-i)*tan>width-j-1){
                        grids[i][j]=pattern;
                    }else {
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d == Direction.RIGHT_DOWN) {
            for (int i=0;i<height;i++){
                for (int j=width-1;j>=0;j--){
                    if ((i+1)*tan>width-j-1){
                        grids[i][j]=pattern;
                    }else {
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d == Direction.LEFT_UP) {
            for (int i=height-1;i>=0;i--){
                for (int j=0;j<width;j++){
                    if ((height-i)*tan>j){
                        grids[i][j]=pattern;
                    }else {
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d == Direction.LEFT_DOWN) {
            for (int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    if ((i+1)*tan>j){
                        grids[i][j]=pattern;
                    }else {
                        grids[i][j]=' ';
                    }
                }
            }

        }
    }
    public void enlarge(){
        this.setWidth(width+1);
        this.setHeight(height+1);
        this.fillGrids();
    }
    public void shrink(){
        this.setWidth(width-1);
        this.setHeight(height-1);
        this.fillGrids();
    }
    public int area(){
        int area=0;
        for (int i=0;i<height;i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j]==pattern){
                    area++;;
                }
            }
        }
        return area;
    }
    public String toString(){
        String str="RightTriangle: "+location+" area="+this.area()+" pattern="+pattern;
        return str;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
