public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids=new char[this.radius*2][this.radius*2];
        for(int i=0;i<this.radius*2;i++)
            for(int j=0;j<this.radius*2;j++){
                super.grids[i][j]=(check(i,j,this.radius))?this.pattern:' ';
            }
    }

    private boolean check(int x,int y,int radius){
        final int[] goI={0,0,1,1};
        final int[] goJ={0,1,0,1};
        for(int i=0;i<=3;i++)
            if(checkDistance(x+goI[i],y+goJ[i],radius))return true;
        return false;
    }

    private boolean checkDistance(int x,int y,int radius){
        final double distance=Math.sqrt(Math.pow(x-radius,2)+Math.pow(y-radius,2));
        return (distance<radius)?true:false;
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
        int a=0;
        for(int i=0;i<grids.length;i++)
            for(int j=0;j<grids[i].length;j++)
                a+=(grids[i][j]==' ')?0:1;
        return a;
    }

    public String toString(){
        return "Circle: ("+Integer.toString(location.getX())+","+Integer.toString(location.getY())+") area="+Integer.toString(area())+" pattern="+pattern;
    }
}
