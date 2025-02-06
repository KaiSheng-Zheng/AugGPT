public class RightTriangle extends Shape{

    private int width;
    private int height;
    private final Direction d;
    private int x;
    private int y;
    public RightTriangle(int x,int y, char pattern, int width, int height, Direction d){
        super(x, y, pattern);
        this.d=d;
        this.height=height;
        this.width=width;
        this.pattern = pattern;
        this.x=x;
        this.y=y;
    }
    public void enlarge(){
        height++;
        width++;
        fillGrids();
    }

    public void shrink(){
        height--;
        width--;
        fillGrids();
    }

    public Direction getD() {
        return d;
    }

    public char[][] fillGrids(){
        this.grids=new char[height][width];
        for(int m=0;m<height;m++){
            for (int i=0;i<width;i++){

                if(getD().equals(Direction.LEFT_UP))
        { int f=0;
            float a=m-(-(float)height*i/width+height);
            float b=m+1-(-(float)height*i/width+height);
            float c=m-(-(float)height*(i+1)/width+height);
            float d=m+1-(-(float)height*(i+1)/width+height);
        if(a<=0){f++;}
        if(b<=0){f++;}
        if(c<=0){f++;}
        if(d<=0){f++;}
        if(f>=2)
        {grids[m][i]=pattern;}
        else if (f==1&&a!=0&&b!=0&&c!=0&&d!=0) {
            grids[m][i]=pattern;}
        else {grids[m][i]=' ';}
        }

        if(getD().equals(Direction.RIGHT_UP))
        {int f=0;
                int a=m-(height*(i/width));
                int b=m+1-(height*i/width);
                int c=m-(height*(i+1)/width);
                int d=m+1-(height*(i+1)/width);
                if(a<=0){f++;}
                if(b<=0){f++;}
                if(c<=0){f++;}
                if(d<=0){f++;}
                if(f>=2)
                {grids[m][i]=pattern;}
                else if (f==1&&a!=0&&b!=0&&c!=0&&d!=0) {
                    grids[m][i]=pattern;}
                else {grids[m][i]=' ';}
            }

        if(getD().equals(Direction.LEFT_DOWN))
        {      int f=0;
                int a=m-(height*i/width);
                int b=m+1-(height*i/width);
                int c=m-(height*(i+1)/width);
                int d=m+1-(height*(i+1)/width);
            if(a>=0){f++;}
            if(b>=0){f++;}
            if(c>=0){f++;}
            if(d>=0){f++;}
            if(f>=2)
            {grids[m][i]=pattern;}
            else if (f==1&&a!=0&&b!=0&&c!=0&&d!=0) {
                grids[m][i]=pattern;}
            else {grids[m][i]=' ';}

        }



        if(getD().equals(Direction.RIGHT_DOWN))
        {int f=0;
            float a=m-(-(float)height*i/width+height);
            float b=m+1-(-(float)height*i/width+height);
            float c=m-(-(float)height*(i+1)/width+height);
            float d=m+1-(-(float)height*(i+1)/width+height);
            if(a>=0){f++;}
            if(b>=0){f++;}
            if(c>=0){f++;}
            if(d>=0){f++;}
            if(f>=2)
            {grids[m][i]=pattern;}
            else if (f==1&&a!=0&&b!=0&&c!=0&&d!=0) {
                grids[m][i]=pattern;}

            else {grids[m][i]=' ';}}
            }}return grids;}
    public int area(){
       int b=0;
        for (int m=0;m<height;m++){
        for(int i=0;i<width;i++){

                if(fillGrids()[m][i]==pattern)
                {
                    b++;
                }
            }
            }return b;
        }



    public String toString(){
        String toString=String.format("RightTriangle: (%d,%d) area=%d pattern=%c", x, y,area(), pattern);
        return toString;
    }}
