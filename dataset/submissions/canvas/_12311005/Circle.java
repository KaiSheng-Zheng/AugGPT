public class Circle extends Shape{
    private int radius;



    public Circle(Location location, char pattern, int radius) {
        this.radius = radius;
        this.pattern = pattern;
        this.location = location;
    }
    @Override
    public char[][] getGrids() {
        return grids;
    }
    @Override
    public void fillGrids() {
        grids =new char[radius*2][radius*2];
        setGrids(grids);
        char[][] chars = getGrids();
        for (int i = 0; i < chars.length/2; i++) {
            for (int j = 0; j <chars[0].length/2 ; j++) {
                int x =radius;
                int y =radius;
                int x1 = i+1;
                int y1 = j+1;
              int length =(x-x1)*(x-x1) +(y-y1)*(y-y1);
                if (length<(radius*radius)){
                  chars[i][j]  =pattern;
                  chars[i][radius*2-1-j] = pattern;
                  chars[radius*2-1-i][j] = pattern;
                  chars[radius*2-1-i][radius*2-1-j]  =pattern;
                }
                else {
                    chars[i][j]  =' ';
                    chars[i][radius*2-1-j] = ' ';
                    chars[radius*2-1-i][j] =' ';
                    chars[radius*2-1-i][radius*2-1-j]  =' ';
                }

            }
        }
        setGrids(chars);
    }

    @Override
    public void enlarge() {
        radius +=1;
        grids =new char[radius*2][radius*2];
        fillGrids();
    }

    @Override
    public void shrink() {
        radius -=1;
        grids =new char[radius*2][radius*2];
        fillGrids();
    }

    @Override
    public int area() {
        fillGrids();
        int area = 0;
        char[][] chars= getGrids();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j <chars[0].length ; j++) {
                if (chars[i][j] ==pattern){
                  area +=1;
                }
            }
        }
        return area;
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName() +": "+"(" +location.getX()+"," +location.getY() +") "+"area="+area()+ " pattern="+pattern;
    }
}
