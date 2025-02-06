public  class Circle extends  Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        fillGrids();
    };
    public int getRadius(){
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public char getPattern() {
        return super.getPattern();
    }

    public void fillGrids(){
        int r = radius;
        char p = pattern;
        char[][] map = new char[r*2][r*2] ;

        for( int  i = 0;i<r;i++ ){
            for ( int j =0;j<r;j++ ){
                if(  ( (r-1-i)*(r-1-i)+(r-1-j)*(r-1-j) )  <  r*r  ) {
                    map[i][j] = p;
                    map[r+r-i-1][j] = p;
                    map[i][r+r-j-1] = p;
                    map[r+r-i-1][r+r-j-1] = p;
                }else{
                    map[i][j] = ' ';
                    map[r+r-i-1][j] =  ' ';
                    map[i][r+r-j-1] = ' ';
                    map[r+r-i-1][r+r-j-1] =  ' ';
                }
            }
        }
        grids = map;

    }
    public void enlarge(){
        setRadius(getRadius()+1);
        fillGrids();

    }
    public void shrink(){
        setRadius(getRadius()-1);
        fillGrids();

    }
    public int area(){
        int num = 0;
        char[][] map = getGrids();
        for( int i=0;i<getRadius()*2;i++ ){
            for (int j=0;j<getRadius()*2;j++){
                if( map[i][j] == getPattern() ) num++;
            }
        }
        return num;
    }
    public String toString(){
        return "Circle: ("+ location.getX()+","+location.getY()+") area="+area()+" pattern="+getPattern();
    }



}
