import java.lang.Math;
public class Circle extends Shape{
    private int radius;
    private int areas;
    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.pattern=pattern;
        this.location=location;
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        this.grids=new char[radius*2][radius*2];
        areas=0;
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if(distance(i,j)) grids[i][j]=' ';
                else {grids[i][j]=pattern;areas++;}
            }
        }
    }
    public boolean distance(int a,int b){
        if(a<radius && b<radius) return (radius-a-1)*(radius-a-1)+(radius-b-1)*(radius-b-1)>=radius*radius;
        if(a>=radius && b<radius) return (radius-a)*(radius-a)+(radius-b-1)*(radius-b-1)>=radius*radius;
        if(a<radius && b>=radius) return (radius-a-1)*(radius-a-1)+(radius-b)*(radius-b)>=radius*radius;
        if(a>=radius && b>=radius) return (radius-a)*(radius-a)+(radius-b)*(radius-b)>=radius*radius;
        return false;
    }
    public void enlarge(){
        radius++;
        fillGrids();
    }
    public void shrink() {
        radius--;
        fillGrids();
    }
    public int area(){
        return areas;
    }
    @Override
    public String toString(){
        return "Circle: "+location.toString()+" area="+area()+" pattern="+pattern;
    }
}
