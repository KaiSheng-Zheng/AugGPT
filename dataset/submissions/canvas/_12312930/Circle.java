public class Circle extends Shape implements Comparable<Shape>{
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location,pattern);
        this.radius = radius;
        repaint();
        fillGrids();

    }

    public void fillGrids(){
        for(int i=0;i<2*radius;i++){
            for(int j=0;j<2*radius;j++){
               grids[i][j]=' ';
            }
        }
        for(int i=0;i<2*radius+1;i++){
            for(int j=0;j<2*radius+1;j++){
                if((i-radius)*(i-radius)+(j-radius)*(j-radius)<radius*radius){
                    if(i-1>=0&&j-1>=0){grids[i-1][j-1]=pattern;}
                    if(i-1>=0&&j<2*radius){grids[i-1][j]=pattern;}
                    if(i<2*radius&&j-1>=0){grids[i][j-1]=pattern;}
                    if(i<2*radius&&j<2*radius){grids[i][j]=pattern;}
                }
            }
        }


    }

    @Override
    public void enlarge() {
        radius++;
        repaint();
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        repaint();
        fillGrids();
    }

    @Override
    public int area() {
        int t=0;
        for(int i=0;i<2*radius;i++){
            for(int j=0;j<2*radius;j++){
                {if(grids[i][j] == pattern)
                    {t++;}
                }
            }
        }
        return t;
    }
    public void repaint(){
        grids=new char[2*radius][2*radius];
    }

    @Override
    public String toString() {
        return "Circle: "+location.toString()+" area="+ this.area()+" pattern="+pattern;
    }

    @Override
    public int compareTo(Shape o) {
        return 0;
    }
}
