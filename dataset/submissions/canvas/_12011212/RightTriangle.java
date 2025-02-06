public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids=new char[height][width];
        for(int i=0;i<height;i++)
            for(int j=0;j<width;j++){
                super.grids[i][j]=(check(i,j,height,width,d))?pattern:' ';
            }
    }

    private boolean check(int x,int y,int height,int width,Direction d){
        final int[] goI={0,0,1,1};
        final int[] goJ={0,1,0,1};
        for(int i=0;i<=3;i++)
            if(checkDirection(x+goI[i],y+goJ[i],height,width,d))return true;
        return false;
    }

    private boolean checkDirection(int x,int y,int height,int width,Direction d){
        double slopeFactor=0;
        int checkFactor=0;
        double interception=0;
        switch (d){
            case RIGHT_UP:   slopeFactor=1;  checkFactor=1; interception=0;        break;
            case LEFT_UP:    slopeFactor=-1; checkFactor=1; interception=height;   break;
            case RIGHT_DOWN: slopeFactor=-1; checkFactor=-1;  interception=height; break;
            case LEFT_DOWN:  slopeFactor=1;  checkFactor=-1;  interception=0;      break;
        }
        //System.out.printf("%d\n",interception);
        double h=(double)height;
        double w=(double)width;
        double slope=(double)(h/w)*slopeFactor;
        double dx=(double)x;
        double dy=(double)y;
        //System.out.printf("%.2f\n",slope);
        return((interception+slope*dy-dx)*checkFactor>0)?true:false;
    }

    @Override
    public void enlarge() {
        this.height++;
        this.width++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.height--;
        this.width--;
        fillGrids();
    }

    public int area() {
        int a=0;
        for(int i=0;i<grids.length;i++)
            for(int j=0;j<grids[i].length;j++)
                a+=(grids[i][j]==' ')?0:1;
        return a;
    }

    public String toString(){
        return "RightTriangle: ("+Integer.toString(location.getX())+","+Integer.toString(location.getY())+") area="+Integer.toString(area())+" pattern="+pattern;
    }
}

