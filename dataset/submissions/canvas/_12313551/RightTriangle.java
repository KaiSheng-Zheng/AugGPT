class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;
    private int[] params;

    //missing constructor (Location, char, int, int, Direction)
    public RightTriangle(Location location, char pattern, int width,int height,int a) {
        super(location, pattern);
        this.location = new Location(location.getX(), location.getY());
        this.pattern = pattern;
        this.width = width;
        this.height=height;
        this.d=Direction.values()[a];
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' ';
            }
        }
        double slope = (double) height / width;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch (d){
                    case LEFT_DOWN:
                        if ((double) (i + 1) / j > slope) {
                            grids[i][j] = pattern;
                        } else if ((double) (i + 1) / j <= slope) {
                            grids[i][j] = grids[i][j];
                        }break;
                    case RIGHT_UP:
                        if ((double) i / (j + 1) < slope) {
                            grids[i][j] = pattern;
                        } else if ((double) i / (j + 1) >= slope) {
                            grids[i][j] = grids[i][j];
                        } break;
                    case LEFT_UP:
                        if ((double) i / (j - width) > -slope) {
                            grids[i][j] = pattern;
                        } else if ((double) i / (j - width) <= -slope) {
                            grids[i][j] = grids[i][j];
                        }break;
                    case RIGHT_DOWN:
                        if ((double) (i + 1-height) / (j + 1) > -slope) {
                            grids[i][j] = pattern;
                        } else if ((double) (i + 1-height) / (j + 1) <= -slope) {
                            grids[i][j] = grids[i][j];
                        }
                }
            }
        }
    }

    public char[][] getGrids() {
        return grids;
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        height--;
        width--;
        this.fillGrids();
    }
    @Override
    public int area() {
        int a=0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j]==pattern){
                    a++;
                }
            }
        }
        return a;
    }

    public String toString(){
        return "RightTriangle: "+location+" area="+area()+" pattern="+pattern;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}