public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        grids = new char[radius*2][radius*2];
        fillGrids();
    }
    @Override
    public void fillGrids() {
        for(int i=0; i< grids.length; i++){
            for(int j=0; j< grids.length; j++){
                if(i< radius && j< radius){
                    if((radius-1-i)*(radius-1-i)+(radius-1-j)*(radius-1-j) < radius*radius ){
                        grids[i][j] = pattern;
                    }
                    else {
                        grids[i][j] = ' ';
                    }
                }
                if(i<radius && j>=radius){
                    if((radius-1-i)*(radius-1-i)+(radius-j)*(radius-j) < radius*radius ){
                        grids[i][j] = pattern;
                    }
                    else {
                        grids[i][j] = ' ';
                    }
                }
                if(i>=radius && j<radius){
                    if((radius-i)*(radius-i)+(radius-1-j)*(radius-1-j) < radius*radius ){
                        grids[i][j] = pattern;
                    }
                    else {
                        grids[i][j] = ' ';
                    }
                }
                if(i>=radius && j>=radius){
                    if((radius-i)*(radius-i)+(radius-j)*(radius-j) < radius*radius ){
                        grids[i][j] = pattern;
                    }
                    else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius++;
        grids = new char[radius*2][radius*2];
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        grids = new char[radius*2][radius*2];
        fillGrids();
    }

    @Override
    public int area() {
        int count=0;
        for(int i=0; i<radius*2; i++){
            for(int j=0; j<radius*2; j++){
                if(grids[i][j] == pattern){
                    count++;
                }
            }
        }
        return count;
    }
    @Override
    public String toString(){
        return ("Circle: (" + location.getX() + "," + location.getY()+") area=" + area() +" pattern=" + pattern);
    }
}