public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;


    public RightTriangle(Location location, char t, int width, int height, Direction d) {
        super(location,t);
        this.d = d;
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public char[][] getGrids() {
        fillGrids();
        return grids;
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        switch (d) {
            case LEFT_UP:
                for(int i=0;i<width;i++){grids[0][i]=pattern;}
                for(int i=0;i<height;i++){grids[i][0]=pattern;}
                for (int i=1;i < height;i++) {
                    for (int j=1; j < width;j++) {
                        if (i<height- (double) (height * j) /width) {
                            if(grids[i][j]!=pattern)grids[i][j]= pattern;
                            if(grids[i-1][j]!=pattern)grids[i-1][j]= pattern;
                            if(grids[i][j-1]!=pattern)grids[i][j-1]= pattern;
                            if(grids[i-1][j-1]!=pattern)grids[i-1][j-1]= pattern;
                        }
                    }
                }
                break;
            case LEFT_DOWN:
                for(int i=0;i<height;i++){grids[i][0]=pattern;}
                for(int i=0;i<width;i++){grids[height-1][i]=pattern;}
                for (int i=1;i < height;i++) {
                    for (int j=1; j < width;j++) {
                        if (i>(double)height*j/width) {
                            if(grids[i][j]!=pattern)grids[i][j]= pattern;
                            if(grids[i-1][j]!=pattern)grids[i-1][j]= pattern;
                            if(grids[i][j-1]!=pattern)grids[i][j-1]= pattern;
                            if(grids[i-1][j-1]!=pattern)grids[i-1][j-1]= pattern;
                        }
                    }
                }
                break;
            case RIGHT_UP:
                for(int i=0;i<width;i++){grids[0][i]=pattern;}
                for(int i=0;i<height;i++){grids[i][width-1]=pattern;}
                for (int i=1;i < height;i++) {
                    for (int j=1; j < width;j++) {
                        if (i<(double)height*j/width) {
                            if(grids[i][j]!=pattern)grids[i][j]= pattern;
                            if(grids[i-1][j]!=pattern)grids[i-1][j]= pattern;
                            if(grids[i][j-1]!=pattern)grids[i][j-1]= pattern;
                            if(grids[i-1][j-1]!=pattern)grids[i-1][j-1]= pattern;
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for(int i=0;i<width;i++){grids[height-1][i]=pattern;}
                for(int i=0;i<height;i++){grids[i][width-1]=pattern;}
                for (int i=1;i < height;i++) {
                    for (int j=1; j < width;j++) {
                        if (i>height- (double) (height * j) /width) {
                            if(grids[i][j]!=pattern)grids[i][j]= pattern;
                            if(grids[i-1][j]!=pattern)grids[i-1][j]= pattern;
                            if(grids[i][j-1]!=pattern)grids[i][j-1]= pattern;
                            if(grids[i-1][j-1]!=pattern)grids[i-1][j-1]= pattern;
                        }
                    }
                }
                break;
        }
        for (int i=0;i<grids.length;i++){
            for(int j=0;j<grids[i].length;j++){
                if(grids[i][j]!=pattern){
                    grids[i][j]= ' ';
                }
            }
        }

    }
    public int area() {
        getGrids();
        int countGrids = 0;
        for (char[] grid : grids) {
            for (char c : grid) {
                if (c == pattern) {
                    countGrids++;
                }
            }
        }
        return countGrids;
    }

    @Override
    public void enlarge() {
        ++height;
        ++width;
    }

    @Override
    public void shrink() {
        --height;
        --width;
    }
}
