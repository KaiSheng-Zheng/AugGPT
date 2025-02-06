public  class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        this.grids=new char[2*radius][2*radius];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                double D = Math.sqrt((i+1-radius)*(i+1-radius)+
                        (j+1-radius)*(j+1-radius));
                if(D<radius){
                    grids[i][j]=pattern;
                    grids[i][2*radius-1-j]=pattern;
                    grids[2*radius-1-i][j]=pattern;
                    grids[2*radius-1-i][2*radius-1-j]=pattern;
                }else {
                    grids[i][j]=' ';
                    grids[i][2*radius-1-j]=' ';
                    grids[2*radius-1-i][j]=' ';
                    grids[2*radius-1-i][2*radius-1-j]=' ';
                }
            }
        }
    }

    public void enlarge(){
        this.radius++;
        fillGrids();
        area();
    }
    public void shrink(){
        this.radius--;
        fillGrids();
        area();
    }

    @Override
    public int area() {
        int out = 0;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if(grids[i][j]==pattern){
                    out++;
                }
            }
        }
        return out;
    }

    public String toString(){
        String S = "Circle: "+"("+location.getX()+
                ","+location.getY()+") area="+area()+" pattern="+super.pattern;
        return S;
    }
    public char getPattern(){
        return pattern;
    }


}
