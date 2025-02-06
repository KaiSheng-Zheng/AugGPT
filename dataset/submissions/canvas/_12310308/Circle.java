public class Circle extends Shape {
    private int radius;




    public void fillGrids() {int m= location.getX();int n= location.getY();
     grids=new char[2*radius+m][2*radius+n];
     for(int i=m;i<2*radius+m;i++){
         for(int t=n;t<2*radius+n;t++){
             int a=i;int b=t;
             if(a<radius){a++;}
             if(b<radius){b++;}
if((a-radius)*(a-radius)+(b-radius)*(b-radius)<radius*radius){
    grids[i][t]=1;
}
         }
     }changeGrids();
    }
    public String toString(){
        return "Circle: ("+ location.getX()+","+ location.getY()+") area="+area()+" pattern="+pattern;
    }
    public Circle(Location location, char pattern, int radius) {
        super();
        this.radius=radius;
        this.location=location;
        this.pattern=pattern;
        fillGrids();
    }


    public void enlarge() {
radius++;
    }


    public void shrink() {
radius--;
    }
    private void changeGrids() {for(int i=0;i<2*radius;i++){
        for(int t=0;t<2*radius;t++){
            if (grids[i][t]==1){
                grids[i][t]=pattern;
            }if (grids[i][t]==0){
                grids[i][t]=' ';
            }
        }}
    }




    public int area() {
        int ar=0;
        for(int i=0;i<2*radius;i++){
            for(int t=0;t<2*radius;t++){
                if (grids[i][t]==pattern||grids[i][t]==1){
                    ar++;
                }
            }}
        return ar;
    }
}