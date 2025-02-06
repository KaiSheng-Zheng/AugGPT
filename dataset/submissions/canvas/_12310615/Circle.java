public class Circle extends Shape{
    private int radius;

    public Circle(Location location,char pattern,  int radius) {
        super(location,pattern );
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        char [][] chars=new char[2*radius][2*radius];
        for (int row=0;row<radius;row++){
            for(int column=0;column<radius;column++){
                if (Math.pow(Math.pow(row-radius+1,2)+Math.pow(column-radius+1,2),0.5)<radius){
                    chars[row][column]=pattern;
                    chars[2*radius-1-row][column]=pattern;
                    chars[row][2*radius-1-column]=pattern;
                    chars[2*radius-1-row][2*radius-1-column]=pattern;
                }
                else {
                    chars[row][column]=' ';
                    chars[2*radius-1-row][column]=' ';
                    chars[row][2*radius-1-column]=' ';
                    chars[2*radius-1-row][2*radius-1-column]=' ';
                }
            }
        }
        setGrids(chars);
    }

    @Override
    public void enlarge() {
        radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int k=0;
        for (int row=0;row<radius;row++){
            for(int column=0;column<radius;column++){
                if (Math.pow(Math.pow(row-radius+1,2)+Math.pow(column-radius+1,2),0.5)<radius){
                    k=k+4;
                }
            }
        }
        return k;
    }
    public String toString(){
       return String.format( "Circle: "+location.toString()+" area="+area()+" pattern="+pattern);
    }
}
