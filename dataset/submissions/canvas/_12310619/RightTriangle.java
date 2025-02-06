

public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public char getPattern() {
        return pattern;
    }

    @Override
    public void fillGrids() {
        super.grids = new char [height][width];
        char [][] array = new char [height][width];
        switch (d){
            case LEFT_UP -> {
                double a = (float)height/width;
                for(int row = 0;row<height;row++){
                    for(int line = 0;line<width;line++){
                        double m = (float)(width-line)*a;
                        double n = (float)row;
                        if(m>n){
                            array[row][line]=pattern;
                        }else {
                            array[row][line]=' ';
                        }
                    }
                }
                /*for(int row = 0;row<height;row++){
                    for(int line = 0;line<width;line++){
                        if(line*height/width<row){
                            array[row][line]=pattern;
                        }else array[row][line]=' ';
                    }
                }*/
                break;
            }
            case RIGHT_UP -> {
                    for (int y = 0; y < width; y++) {
                        int a =height -(height * (width - y-1)) /width ;
                        for (int i = 0; i < a; i++) {
                            array[i][y] = pattern;
                        }
                        for (int n = a ; n < height; n++) {
                            array[n][y] = ' ';
                        }
                    }
                /*for(int row = 0;row<height;row++){
                    for(int line = 0;line<width;line++){
                        if((line+1)*height/width>row){
                            array[row][line]=pattern;
                        }else array[row][line]=' ';
                    }
                }*/
                break;
            }
            case LEFT_DOWN -> {
                for(int row = 0;row<height;row++){
                    for(int line = 0;line<width;line++){
                        if(line*height/width<row+1){
                            array[row][line]=pattern;
                        }else array[row][line]=' ';
                    }
                }
                break;
            }
            case RIGHT_DOWN -> {
                double a = (float)height/width;
                //System.out.println(a);
                for(int row = 0;row<height;row++){
                    for(int line = 0;line<width;line++){
                        double m = (float)(width-line-1)*a;
                        double n = (float)row+1;
                        //System.out.println(m);
                        //System.out.println(n);
                        if(m<n){
                            array[row][line]=pattern;
                        }else {
                            array[row][line]=' ';
                        }
                    }
                }
                break;
            }
        }
        super.setGrids(array);
    }

    @Override
    public void enlarge() {
        this.height++;
        this.width++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.width--;
        this.height--;
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for(int a = 0;a<height;a++){
            for(int b = 0;b<width;b++){
                if(getGrids()[a][b]==pattern){
                    area++;
                }
            }
        }
        return area;
    }

    public String toString(){
        return "RightTriangle: "+location.toString()+" area="+area()+" pattern="+pattern;
    }
}
