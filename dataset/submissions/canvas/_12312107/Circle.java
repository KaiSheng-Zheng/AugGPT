public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    };

    @Override
    public void fillGrids() {
        grids=new char[2*radius][2*radius];
        for (int i = 0; i <radius ; i++) {
            for (int j = 0; j < radius; j++) {
                if((i-radius)*(i-radius)+(j-radius)*(j-radius)>=radius*radius&&(i+1-radius)*(i+1-radius)+(j-radius)*(j-radius)>=radius*radius&&(i-radius)*(i-radius)+(j-radius+1)*(j-radius+1)>=radius*radius&&(i+1-radius)*(i+1-radius)+(j+1-radius)*(j+1-radius)>=radius*radius)
                {grids[i][j]=' ';grids[2*radius-i-1][2*radius-j-1]=' ';grids[i][2*radius-j-1]=' ';grids[2*radius-i-1][j]=' ';}
                else{count+=4;grids[i][j]=pattern;grids[2*radius-i-1][2*radius-j-1]=pattern;grids[i][2*radius-j-1]=pattern;grids[2*radius-1-i][j]=pattern;}
        }

        }
    }


    @Override
    public void enlarge() {
        radius+=1;
        count=0;
        fillGrids();
    }

    @Override
    public void shrink() {
        count=0;
        radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int num=0;
        for (int i = 0; i <2*radius ; i++) {
            for (int j = 0; j <2*radius ; j++) {
                if(grids[i][j]!=' '){num++;}
            }
        }
        return num;
    }
    public String toString(){
        return "Circle: "+"("+location.getX()+","+location.getY()+") "+"area="+area()+" pattern="+pattern;
    }
}
