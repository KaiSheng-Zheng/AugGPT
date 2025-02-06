public class RightTriangle extends Shape{
private int width;
private int height;
private  Direction d;
private int area;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d,int area){
        this.d=d;
        this.location=location;
        this.pattern=pattern;
        this.width=width;
        this.height=height;
        this.area=area;
        fillGrids();
    }

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        this.d=d;
        this.location=location;
        this.pattern=pattern;
        this.width=width;
        this.height=height;
        fillGrids();
    }
    public RightTriangle(){
        super();
    }
    @Override
    public void fillGrids() {
        grids=new char[height][width];
        double number= (double) grids.length /grids[0].length;
        if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i <grids.length ; i++) {
                grids[i][0]=pattern;
                for (int j = 1; j <grids[0].length ; j++) {
                  double num= (double) (i+1)/j;
                  if (number<num) {
                      grids[i][j] = pattern;
                  }else {
                      grids[i][j]=' ';
                  }
                }
            }
        }
    if (d==Direction.LEFT_UP){
        for (int i = 0; i <grids.length ; i++) {
            for (int j = 0; j <grids[0].length ; j++) {
               double num= (double) (grids.length-i)/j;
               if (num>number){
                   grids[i][j]=pattern;
               }else {
                   grids[i][j]=' ';
               }
            }
        }
    }
    if (d==Direction.RIGHT_DOWN){
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j <grids[0].length ; j++) {
              double num= (double) (grids.length - i - 1) /(j+1);
              if (num<number){
                  grids[i][j]=pattern;
              }else {
                  grids[i][j]=' ';
              }
            }
        }
    }
    if (d==Direction.RIGHT_UP){
        for (int i = 0; i <grids.length ; i++) {
            for (int j = 0; j <grids[0].length ; j++) {
               double num= (double) i/(j+1);
               if (num<number){
                   grids[i][j]=pattern;
               }else {
                   grids[i][j]=' ';
               }
            }
        }
    }
}

    @Override
    public void enlarge() {
     height=height+1;
     width=width+1;
   fillGrids();
    }

    @Override
    public void shrink() {
         height=height-1;
         width=width-1;
         fillGrids();
    }

    @Override
    public int area() {
        int number = 0;
        for (int i = 0; i <grids.length ; i++) {
            for (int j = 0; j <grids[0].length ; j++) {
                if (grids[i][j]==pattern){
                    number=number+1;
                }
            }
        }
        return number;
    }

    @Override
    public char getPattern() {
        return this.pattern;
    }

    public String toString(){
        return "RightTriangle: "+location.toString()+" area="+area()+" pattern="+pattern;
    }
    public Location getLocation(){
        return location;
    }
}


