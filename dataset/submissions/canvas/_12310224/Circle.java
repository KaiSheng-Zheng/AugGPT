public class Circle extends Shape {
    private int radius;
    private int width;
    private int height;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.height = radius * 2;
        this.width = radius * 2;
        this.grids = new char[height][width];
        fillGrids();
    }

    int distance;
    @Override
    public void fillGrids() {
        this.grids=new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.grids[i][j]=' ';
            }
        }
        super.fillGrids();
        for (int i = 0; i <=radius; i++) {
            for (int j = 0; j <=radius; j++) {
                distance = (radius - i) * (radius - i) + (radius - j) * (radius - j);
                if (distance<(radius)*(radius)){
                    this.grids[i-1][j-1] = this.pattern;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (this.grids[i][j]==this.pattern){
                    this.grids[height-1-i][width-1-j] = pattern;
                    this.grids[height-1-i][j] = pattern;
                    this.grids[i][width-1-j] = pattern;
                }
            }
        }
    }

    @Override
    public char[][] getGrids(){
        return this.grids;
    }
    public void enlarge(){
        this.radius+=1;
        height = radius*2;
        width = radius*2;
        fillGrids();
    }
    public void shrink(){
        this.radius-=1;
        height = radius*2;
        this.width = radius*2;
        fillGrids();
    }
    @Override
    public int area() {
        int num=0;
        for (int i = 0; i < this.height ; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.grids[i][j] == this.pattern){
                    num++;
                }
            }
        }
        return num;
    }

    public String toString(){
        return "Circle"+": "+"("+this.location.getX()+","+this.location.getY()+")"+" area="+this.area()+" pattern="+this.pattern;
    }


}


