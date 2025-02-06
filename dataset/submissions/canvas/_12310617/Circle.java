public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        this.fillGrids();
    }
    public void fillGrids(){
         grids=new char[radius*2][radius*2];
        for (int i=0;i<radius;i++){
            for (int j=0;j<radius;j++){
                if (Math.pow(radius-i-1,2)+Math.pow(radius-j-1,2)<Math.pow(radius,2)){
                    grids[i][j]=pattern;
                }else {
                    grids[i][j]=' ';
                }
            }
        }
        for (int i=radius;i<radius*2;i++){
            for (int j=0;j<radius;j++){
                if (Math.pow(i-radius,2)+Math.pow(radius-j-1,2)<Math.pow(radius,2)){
                    grids[i][j]=pattern;
                }else {
                    grids[i][j]=' ';
                }
            }
        }
        for (int i=0;i<radius;i++){
            for (int j=radius;j<radius*2;j++){
                if (Math.pow(radius-i-1,2)+Math.pow(j-radius,2)<Math.pow(radius,2)){
                    grids[i][j]=pattern;
                }else {
                    grids[i][j]=' ';
                }
            }
        }
        for (int i=radius;i<radius*2;i++){
            for (int j=radius;j<radius*2;j++){
                if (Math.pow(i-radius,2)+Math.pow(j-radius,2)<Math.pow(radius,2)){
                    grids[i][j]=pattern;
                }else {
                    grids[i][j]=' ';
                }
            }
        }
    }
    public void enlarge(){
        this.setRadius(this.getRadius()+1);
        this.fillGrids();
    }
    public void shrink(){
        this.setRadius(this.getRadius()-1);
        this.fillGrids();
    }
    public int area(){
        int area=0;
        for (int i=0;i<radius*2;i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (grids[i][j]==pattern){
                    area++;;
                }
            }
        }
        return area;
    }
    public String toString(){
        String str="Circle: "+location+" area="+this.area()+" pattern="+pattern;
        return str;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
