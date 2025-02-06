

public abstract class Shape {
   int x;
   int y;
 char[][] grids;
 char pattern;


    public Shape(){

    }
    public Shape(int x,int y, char pattern, int... params){
        this.x=x;
        this.y=y;
        this.pattern=pattern;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract char[][]fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    public Object pattern() {return pattern;
    }


   public int getX(){
        return x;
   }

    public int getY(){
        return y;
    }



}
