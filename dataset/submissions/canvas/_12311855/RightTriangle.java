public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d = Direction.LEFT_UP;
    private int fillCount;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        this.location = location;
        this.pattern = pattern;
        this.width = width;
        this.height = height;
        this.d = d;
        fillCount = 0;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        fillCount = 0;
        grids = new char[height][width];
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                grids[i][j] =' ';
            }
        }
        float slop = (float)this.height/(float)this.width;
        for(int h=1;h<=height;h++) {
            for (int w=0;w<width;w++) {
                if (w==0) {
                    grids[h-1][w] = pattern;
                    fillCount +=1;
                }
                else {
                    float currentSlop = (float)h/(float)(w);
                    if(currentSlop>slop) {
                        grids[h-1][w] = pattern;
                        fillCount +=1;
                    }
                    else {
                        grids[h-1][w] = ' ';
                    }
                }
            }
        }

        if(this.d == Direction.LEFT_DOWN) {

        }
        else if(this.d == Direction.LEFT_UP) {
            char tmpgrids[][] = new char[height][width];
            for(int i=0;i<height;i++) {
                for(int j=0;j<width;j++) {
                    tmpgrids[i][j] =' ';
                }
            }

            for (int h=0;h<height;h++) {
                for (int w=0; w<width;w++) {
                    tmpgrids[h][w] = grids[height-h-1][w];
                }
            }
            for (int h=0;h<height;h++) {
                for (int w=0; w<width; w++) {
                    grids[h][w] = tmpgrids[h][w];
                }
            }
        }
        else if(this.d == Direction.RIGHT_DOWN) {
            char tmpgrids[][] = new char[height][width];
            for(int i=0;i<height;i++) {
                for(int j=0;j<width;j++) {
                    tmpgrids[i][j] =' ';
                }
            }
            for (int h=0;h<height;h++) {
                for (int w=0; w<width;w++) {
                    tmpgrids[h][w] = grids[h][width-w-1];
                }
            }
            for (int h=0;h<height;h++) {
                for (int w=0; w<width; w++) {
                    grids[h][w] = tmpgrids[h][w];
                }
            }

        }else if(this.d == Direction.RIGHT_UP) {
            char tmpgrids[][] = new char[height][width];
            for(int i=0;i<height;i++) {
                for(int j=0;j<width;j++) {
                    tmpgrids[i][j] =' ';
                }
            }
            for (int h=0;h<height;h++) {
                for (int w=0; w<width;w++) {
                    tmpgrids[h][w] = grids[height-h-1][width-w-1];
                }
            }
            for (int h=0;h<height;h++) {
                for (int w=0; w<width; w++) {
                    grids[h][w] = tmpgrids[h][w];
                }
            }
        }
    }

    @Override
    public void enlarge() {
        if(height<18 && width<18) {
            height +=1;
            width +=1;
            fillGrids();
        }
    }

    @Override
    public void shrink() {
        if(height>1 && width>1) {
            height -=1;
            width -=1;
            fillGrids();
        }
    }

    @Override
    public int area() {
        return fillCount;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return "RightTriangle: ("+location.getX()+","+location.getY()+") area="+fillCount+" pattern="+pattern;
    }
}
