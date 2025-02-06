public class RightTriangle extends Shape {
    private int width;
    private int height;
    private double k;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        super.location = location;
        super.pattern = pattern;
        this.width=width;
        this.height=height;
        this.d = d;
        fillGrids();
    }

    public  void fillGrids() {
        super.grids = new char[height][width];
        this.k = (double) this.width/(double) this.height;

        switch (d){
            case LEFT_UP:
                for (int i = 1; i <=height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if (i*k>j){
                            super.grids[this.height-i][j]=super.pattern;
                        }else {
                            super.grids[this.height-i][j]= ' ';
                        }
                    }
                }

                break;
            case LEFT_DOWN:
                for (int i = 1; i <=height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if (i*k>j){
                            super.grids[i-1][j]=super.pattern;
                        }else {
                            super.grids[i-1][j]= ' ';
                        }
                    }
                }

                break;
            case RIGHT_UP:
                for (int i = 1; i <=height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if (i*k>j){
                            super.grids[this.height-i][width-j-1]=super.pattern;
                        }else {
                            super.grids[this.height-i][width-j-1]= ' ';
                        }
                    }
                }
                break;
            case RIGHT_DOWN:for (int i = 1; i <=height ; i++) {
                for (int j = 0; j <width ; j++) {
                    if (i*k>j){
                        super.grids[i-1][width-j-1]=super.pattern;
                    }else {
                        super.grids[i-1][width-j-1]= ' ';
                    }
                }
            }

                break;

        }

    }

    public  void enlarge() {
        this.width++;
        this.height++;
        fillGrids();
    }

    public  void shrink() {
        this.width--;
        this.height--;
        fillGrids();
    }

    public int area(){
        this.k =  (double) this.width/(double) this.height;
        int area =0;
        for (int i = 1; i <=this.height ; i++) {
            for (int j = 0; j <this.width ; j++) {
                if (i*k>j){
                    area++;
                }
            }
        }
        return area;
    }
    public char getPattern(){
        return super.pattern;
    }

    public String toString(){
        return "RightTriangle: "+location.toString()+" area="+area()+" pattern="+super.pattern;
    }
}

