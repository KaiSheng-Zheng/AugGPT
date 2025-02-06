public  class Circle extends Shape{
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    public void fillGrids(){
        int diameter = radius*2;
        grids=new char[diameter][diameter];
        for(int i=0;i<=diameter-1;i++){
            for(int j =0;j<=diameter-1;j++){
                if(i<radius&&j<radius) {
                    if ((i+1-radius) * (i+1-radius) + (j+1-radius) * (j+1-radius) < radius * radius) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }else if(i>=radius&&j<radius){
                    if ((i-radius) * (i-radius) + (j+1-radius) * (j+1-radius) < radius * radius) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }else if(i>=radius&&j>=radius) {
                    if ((i  - radius) * (i  - radius) + (j - radius) * (j - radius) < radius * radius) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }else{
                    if ((i + 1 - radius) * (i + 1 - radius) + (j  - radius) * (j  - radius) < radius * radius) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }
    public void enlarge(){
            radius++;
            fillGrids();
    }
    public void shrink(){
        if(radius>=1){
            radius--;
            fillGrids();
        }
    }
    public int area() {
        int area = 0;
        for(int i=0;i<2*radius;i++){
            for(int j=0;j<2*radius;j++){
                if(grids[i][j]==pattern){
                    area++;
                }
            }
        }
        return area;
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(),pattern);
    }

}
