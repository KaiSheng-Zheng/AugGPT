public class Circle extends Shape {

    private int radius;


    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.location=location;
        this.pattern=pattern;
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        super.area=0;
        char [][]quarter=new char[radius][radius];
        for (int i = 0; i < quarter.length; i++) {
            for (int j = 0; j < quarter[i].length; j++) {
                if (i * i + j * j < radius * radius) {
                    quarter[i][j] = this.pattern;
                }else quarter[i][j]=' ';
            }
        }
        grids=new char[radius*2][radius*2];
        for (int i = radius-1,t=0; i >= 0; i--,t++) {
            for (int i1 = radius - 1,t1=0; i1 >= 0; i1--,t1++) {
                grids[i][i1]=quarter[t][t1];
                if(quarter[t][t1]==pattern){
                    super.area++;
                }
            }
        }
        for (int i =radius-1,t=0; i >= 0; i--,t++) {
            for (int i1 =radius,t1=0; i1 <2*radius; i1++,t1++) {
                grids[i][i1]=quarter[t][t1];
                if(quarter[t][t1]==pattern){
                    super.area++;
                }
            }
        }
        for (int i = radius,t=0; i < grids.length; i++,t++) {
            for (int i1 =radius-1,t1=0; i1 >= 0; i1--,t1++) {
                grids[i][i1]=quarter[t][t1];
                if(quarter[t][t1]==pattern){
                    super.area++;
                }
            }
        }
        for (int i = radius,t=0; i < grids.length; i++,t++) {
            for (int i1 = radius,t1=0; i1 < grids[i].length; i1++,t1++) {
                grids[i][i1]=quarter[t][t1];
                if(quarter[t][t1]==pattern){
                    super.area++;
                }
            }
        }
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
        return super.area;
    }
    public String toString(){
        return "Circle: "+"("+this.location.getX()+","+this.location.getY()+") area="+area()+" pattern="+this.pattern;
    }

}