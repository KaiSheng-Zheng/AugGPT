public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }

    public void fillGrids() {
        grids=new char[2*radius][2*radius];
        for (int i=0;i<2*radius;i++){
            for (int j=0;j<2*radius;j++){
                if (i<=radius-1){
                    if (j<=radius-1){
                        if ((radius-1-i)*(radius-i-1)+(radius-1-j)*(radius-1-j)<radius*radius){
                            grids[i][j]=pattern;
                        } else {
                            grids[i][j]=' ';
                        }
                    } else {
                        if ((radius-1-i)*(radius-i-1)+(j-radius)*(j-radius)<radius*radius){
                            grids[i][j]=pattern;
                        } else {
                            grids[i][j]=' ';
                        }
                    }
                } else {
                    if (j<=radius-1){
                        if ((i-radius)*(i-radius)+(radius-1-j)*(radius-1-j)<radius*radius){
                            grids[i][j]=pattern;
                        } else {
                            grids[i][j]=' ';
                        }
                    } else {
                        if ((i-radius)*(i-radius)+(j-radius)*(j-radius)<radius*radius){
                            grids[i][j]=pattern;
                        } else {
                            grids[i][j]=' ';
                        }
                    }
                }
            }
        }
    }

    public void enlarge(){
        this.radius++;
        fillGrids();
    }

    public void shrink(){
        this.radius--;
        fillGrids();
    }

    public int area(){
        int area=0;
        for (int i=0;i<2*radius;i++){
            for (int j=0;j<2*radius;j++){
                if (grids[i][j]==pattern){
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public String toString(){
        return "Circle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
    }
}
