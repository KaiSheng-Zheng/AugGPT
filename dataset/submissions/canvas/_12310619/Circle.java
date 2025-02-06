
public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();

    }

    @Override
    public char getPattern() {
        return pattern;
    }

    @Override
    public void fillGrids() {
        super.grids = new char [2*radius][2*radius];
        char [][] array = new char[2*radius][2*radius];
        for(int a = 0;a<2*radius;a++){
            for(int b = 0;b<2*radius;b++){
                if(a<radius){
                    if (b<radius){
                        if(Math.pow((radius-a-1),2)+Math.pow((radius-b-1),2)<radius*radius){
                            array[a][b]=pattern;
                        }else {array [a][b]=' ';}
                    }else {
                        if(Math.pow((radius-a-1),2)+Math.pow((radius-b),2)<radius*radius){
                            array[a][b]=pattern;
                        }else {array [a][b]=' ';}
                    }
                }else {
                    if (b<radius){
                        if(Math.pow((radius-a),2)+Math.pow((radius-b-1),2)<radius*radius){
                            array[a][b]=pattern;
                        }else {array [a][b]=' ';}
                    }else {
                        if(Math.pow((radius-a),2)+Math.pow((radius-b),2)<radius*radius){
                            array[a][b]=pattern;
                        }else {array [a][b]=' ';}
                    }
                }
            }
        }
        super.setGrids(array);
    }

    @Override
    public void enlarge() {
        this.radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for(int a = 0;a<2*radius;a++){
            for(int b = 0;b<2*radius;b++){
                if(getGrids()[a][b]==pattern){
                    area++;
                }
            }
        }
        return area;
    }
    public String toString(){
        return "Circle: "+location.toString()+" area="+area()+" pattern="+pattern;
    }
}
