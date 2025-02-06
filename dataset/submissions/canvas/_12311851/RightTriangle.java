public class RightTriangle extends Shape {
    private final Direction d;
    private int width;
    private int height;

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

    ;private  int gridsNumber ;

    public int getGridsNumber() {
        return gridsNumber;
    }

    public void setGridsNumber(int gridsNumber) {
        this.gridsNumber = gridsNumber;
    }

    public RightTriangle(Location location, char pattern, int width, int height,
                         Direction d) {
        super(location,pattern);
        this.d = d;
        this.width=width;
        this.height=height;
        fillGrids();

    }

    @Override
    public char[][] getGrids() {
        return grids;
    }

    @Override
    public void fillGrids() {
        grids=new char[height][width];
        switch(d) {
// must be unqualified name of the enum constant
            case LEFT_DOWN:
                for (int i = 0; i < getHeight(); i++) {
                    for (int j = 0; j < getWidth(); j++) {
                        if((double )(i+1)/(j)>(double) height/width) {
                            getGrids()[i][j] = pattern;

                        }else{
                            getGrids()[i][j]=' ';
                        }
//                        System.out.print(grids[i][j]);//
                    }
//                    System.out.println();//

                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < getHeight(); i++) {
                    for (int j = 0; j < getWidth(); j++) {
                        if((double )(i)/(j+1)<(double) height/width) {
                            getGrids()[i][j] = pattern;

                        }else{
                            getGrids()[i][j]=' ';
                        }
//                        System.out.print(grids[i][j]);//
                    }
//                    System.out.println();//
                }
                break;
            case LEFT_UP:
                for (int i = 0; i < getHeight(); i++) {
                    for (int j = 0; j < getWidth(); j++) {
                        if((double )(i)/(width-j)<(double) height/width) {
                            getGrids()[i][j] = pattern;

                        }else{
                            getGrids()[i][j]=' ';
                        }
//                        System.out.print(grids[i][j]);//
                    }
//                    System.out.println();//
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < getHeight(); i++) {
                    for (int j = 0; j < getWidth(); j++) {
                        if((double )(width-j-1)/(i+1)<(double) width/height) {
                            getGrids()[i][j] = pattern;

                        }else{
                            getGrids()[i][j]=' ';
                        }
//                        System.out.print(grids[i][j]);//
                    }
//                    System.out.println();//
                }
                break;
        }
    }

    @Override
    public void enlarge() {
     setHeight(getHeight()+1);
     setWidth(getWidth()+1);
     fillGrids();
    }

    @Override
    public void shrink() {
        setHeight(getHeight()-1);
        setWidth(getWidth()-1);
        fillGrids();
    }

    @Override
    public int area() {
        setGridsNumber(0);

        for (int i = 0; i < getGrids().length; i++) {
            for (int j = 0; j < getGrids()[0].length; j++) {
                if(grids[i][j]==pattern){

              setGridsNumber(getGridsNumber()+1);}
            }
        }

        return gridsNumber;
        //Return the count of patterns that being filled in grids.
    }
    public String toString(){
        return "RightTriangle: ("+ location.getX()+","+ location.getY()+")"+" area="+area()+" pattern="+pattern;
    }
}
