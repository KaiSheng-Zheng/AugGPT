public class Circle extends Shape  {
    private int radius;

    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
    };
    public  void fillGrids(){
        this.grids=new char[this.radius*2][this.radius*2];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if ((radius-1-i)*(radius-1-i)+(radius-1-j)*(radius-1-j)<radius*radius){
                    grids[i][j]=this.pattern;
                    grids[radius*2-1-i][j]=this.pattern;
                    grids[i][radius*2-1-j]=this.pattern;
                    grids[radius*2-1-i][radius*2-1-j]=this.pattern;
                }
                else{
                    grids[i][j]=' ';
                    grids[radius*2-1-i][j]=' ';
                    grids[i][radius*2-1-j]=' ';
                    grids[radius*2-1-i][radius*2-1-j]=' ';
                }
            }
        }
    };
    public  void enlarge(){
        this.radius++;
    };
    public  void shrink(){
        this.radius--;

    };
    public  int area(){
        this.grids=new char[this.radius*2][this.radius*2];
        int area=0;
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if ((radius-1-i)*(radius-1-i)+(radius-1-j)*(radius-1-j)<radius*radius){
                    grids[i][j]=this.pattern;
                    grids[radius*2-1-i][j]=this.pattern;
                    grids[i][radius*2-1-j]=this.pattern;
                    grids[radius*2-1-i][radius*2-1-j]=this.pattern;
                    area+=4;
                }
            }
        }
        return area;
    };
    public String toString(){
        return "Circle: ("+this.location.getX()+","+this.location.getY()+") area="+this.area()+" pattern="+pattern;
    }

}
