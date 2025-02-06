
public class Circle extends Shape{
    private int radius;
    private char[][]grids;
    private int x;
    private int y;

    public Circle(int x,int y, char pattern, int radius){
        super(x, y, pattern);
        this.x=x;
        this.y=y;
        this.pattern=pattern;
        this.radius=radius;

    }

    public void enlarge(){
        radius++;
        fillGrids();
    }

    public void shrink(){
        radius--;
        fillGrids();
    }

    public char[][] fillGrids(){

        this.grids=new char[2*radius][2*radius];
        int v=radius*radius;
        for(int i= 0;i< radius*2;i++){
            for(int m= 0;m< radius*2;m++){
                int a=(i-radius)*(i-radius)+(m-radius)*(m-radius);
                int b=(i-radius+1)*(i-radius+1)+(m-radius)*(m-radius);
                int c=(i-radius)*(i-radius)+(m-radius+1)*(m-radius+1);
                int d=(i-radius+1)*(i-radius+1)+(m-radius+1)*(m-radius+1);
                int s=0;
                if(a<=v){s++;}
                if(b<=v){s++;}
                if(c<=v){s++;}
                if(d<=v){s++;}
                if(s>=2){grids[i][m]=pattern;}
                else if (s==1&&a!=v&&b!=v&&c!=v&&d!=v)
                {grids[i][m]=pattern;

                }
                else {grids[i][m]=' ';}

            }
            }

        return grids;

        }


    public char[][] getGrids(){
        return grids;
    }
    public int area() {
        int n=0;
        for(int i=0;i<radius*2;i++){
            for(int m=0;m<radius*2;m++){
                if(fillGrids()[i][m]==pattern){
                    n++;
                }


    }} return n;
    }
    public String toString(){
        int m=area();
        String toString=String.format("Circle: (%d,%d) area=%d pattern=%c", x, y,m, pattern);
        return toString;





}}
