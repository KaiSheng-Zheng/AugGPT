public class Circle extends Shape {

    private int radius;

    public void fillGrids(){
        for(int i = 0 ; i < grids.length ; i++){
            for (int j = 0 ; j < grids[i].length ; j++){
                if (Math.pow(radius,2) > Math.pow(Math.abs(radius-i-0.5)-0.5,2)+Math.pow(Math.abs(radius-j-0.5)-0.5,2)){
                    grids[i][j] = this.pattern;
                }else {
                    grids[i][j] = ' ';
                }
            }
        }
    }
    public Circle(Location location, char pattern, int radius){
       super(location, pattern);
        this.radius = radius;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }

    public char getPattern(){
        return this.pattern;
    }
    public void enlarge(){
        this.radius++;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }
    public void shrink(){
        this.radius--;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }
    public int area(){
        int count = 0;
        for (int i = 0 ; i < grids.length ; i++){
            for (int j = 0 ; j < grids[i].length ; j++){
                if(grids[i][j] == this.pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){

        return  "Circle: (" + location.getX() + "," + location.getY() + ") area=" +area()+" pattern=" +pattern;
    }
}
