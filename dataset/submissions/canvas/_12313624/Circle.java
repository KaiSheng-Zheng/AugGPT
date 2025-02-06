public class Circle extends Shape{
    private int radius;
    public Circle(Location location,char pattern,int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids(){
        super.grids=new char[radius*2][radius*2];
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = 0; i1 < grids[0].length; i1++) {
                int x=i;
                int y=i1;
                if (i<=radius-1)x=i+1;
                if (i1<=radius-1)y=i1+1;
                if ((radius-x)*(radius-x)+(radius-y)*(radius-y)<(radius*radius)){
                    grids[i][i1]=pattern;
                }else grids[i][i1]=' ';
            }
        }
    }
    @Override
    public void enlarge(){
        radius++;
        fillGrids();
    }
    @Override
    public void shrink(){
        radius--;
        fillGrids();
    }
    @Override
    public int area(){
        int number=0;
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = 0; i1 < grids[0].length; i1++) {
                if (grids[i][i1]==pattern){
                    number++;
                }
            }
        }
        return number;
    }
    @Override
    public String toString(){
        return String.format("Circle: "+
                location.toString()+" area="+area()+" pattern="+pattern);
    }



}
