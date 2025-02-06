public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;


    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        this.d = d;
        this.location=location;
        this.pattern=pattern;
        this.width=width;
        this.height=height;
        fillGrids();
    }


    public void fillGrids() {int n= location.getX();int m= location.getY();

        grids=new char[height+n+100][width+m+100];
        if (d.equals(Direction.RIGHT_UP)){
            for(int i=m;i<width+m;i++){
                for(int t=n;t<height-((width-i-1)*height)/width+n;t++){
                    grids[t][i]=1;
                }}}
        if (d.equals(Direction.LEFT_UP)){
            for(int i=m;i<width+m;i++){
                for(int t=n;t<height-(i*height)/width+n;t++){
                    grids[t][i]=1;
                }}}
        if (d.equals(Direction.RIGHT_DOWN)){
            for(int i=m;i<width+m;i++){
                for(int t=(width-i-1)*height/width+n;t<height+n;t++){
                    grids[t][i]=1;
                }}}
        if (d.equals(Direction.LEFT_DOWN)){int a=1;if (width==height){a=0;}
            for(int i=m;i<width+m;i++){
                for(int t=i*height/width+n;t<height+n;t++){
                    grids[t][i]=1;
                }}}
        changeGrids();
    }
    public String toString(){
        return "RightTriangle: ("+ location.getX()+","+ location.getY()+") area="+area()+" pattern="+pattern;
    }
    private void changeGrids() {for(int i=0;i<height;i++){
        for(int t=0;t<width;t++){
            if (grids[i][t]==1){
                grids[i][t]=pattern;
            }if (grids[i][t]==0){
                grids[i][t]=' ';
            }
        }}
    }




    public void enlarge() {
        width++;height++;
    }
    public void shrink() {
        width--;height--;
    }

    public  int area() {
        int ar=0;
        for(int i=0;i<height;i++){
            for(int t=0;t<width;t++){
                if (grids[i][t]==pattern||grids[i][t]==1){
                    ar++;
                }
            }}
        return ar;
    }
}