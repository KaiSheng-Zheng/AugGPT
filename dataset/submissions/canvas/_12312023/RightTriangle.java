public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.location=location;
        this.pattern=pattern;
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        super.area=0;
        switch (this.d){
            case LEFT_UP -> {
                grids=new char[height][width];
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[i].length; j++) {
                        if(width*(i)+height*(j)<width*height){
                            grids[i][j]=pattern;
                            super.area++;
                        }else grids[i][j]=' ';
                    }
                }
            }
            case LEFT_DOWN -> {
                grids=new char[height][width];
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[i].length; j++) {
                        if(width*(i+1)-height*j>0){
                            grids[i][j]=pattern;
                            super.area++;
                        }else grids[i][j]=' ';
                    }
                }
            }
            case RIGHT_UP -> {
                grids=new char[height][width];
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[i].length; j++) {
                        if(width*(i)-height*(j+1)<0){
                            grids[i][j]=pattern;
                            super.area++;
                        }else grids[i][j]=' ';
                    }
                }
            }
            case RIGHT_DOWN -> {
                grids=new char[height][width];
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[i].length; j++) {
                        if(width*(i+1)+height*(j+1)>width*height){
                            grids[i][j]=pattern;
                            super.area++;
                        }else grids[i][j]=' ';
                    }
                }
            }

        }
    }

    @Override
    public void enlarge() {
        this.height++;
        this.width++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.height--;
        this.width--;
        fillGrids();
    }

    @Override
    public int area() {
        return super.area;
    }

    @Override
    public String toString() {
        return "RightTriangle: ("+this.location.getX()+","+this.location.getY()+") area="+this.area+" pattern="+this.pattern;
    }
}
