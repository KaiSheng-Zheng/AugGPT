public class Circle extends Shape{
    private int radius; //range from 1 to 15
    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
        //grids = new char[radius * 2][radius * 2];
        this.fillGrids();
    }

    public void fillGrids(){
        grids = new char[radius*2][radius*2];
        //left-up side
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if(distance(i+1, j+1) < (double) radius){
                    grids[i][j] = pattern;
                }
                else{
                    grids[i][j] = ' ';
                }
            }
        }


        //right-up side
        for (int i = 0; i < radius; i++) {
            for (int j = radius; j < radius*2; j++) {
                if(distance(i+1, j) < (double) radius){
                    grids[i][j] = pattern;
                }
                else{
                    grids[i][j] = ' ';
                }
            }
        }


        //left-down side
        for (int i = radius; i < radius*2; i++) {
            for (int j = 0; j < radius; j++) {
                if(distance(i, j+1) < (double) radius){
                    grids[i][j] = pattern;
                }
                else{
                    grids[i][j] = ' ';
                }
            }
        }

        //right-down side
        for (int i = radius; i < radius*2; i++) {
            for (int j = radius; j < radius*2; j++) {
                if(distance(i, j) < (double) radius){
                    grids[i][j] = pattern;
                }
                else{
                    grids[i][j] = ' ';
                }
            }
        }

    }
    public double distance(int i, int j){
        return Math.sqrt((double) (i - radius) * (i - radius) + (double) (j - radius) * (j - radius));
    }

    public String toString(){
        return "Circle: (" + location.getX() + "," + location.getY()
                + ") area=" + area() + " pattern=" + pattern;
    }

    public void enlarge(){
        radius++;
        this.fillGrids();
    }

    public void shrink(){
        if(radius > 1){
            radius--;
            this.fillGrids();
        }
    }

    public int area(){
        int num = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if(grids[i][j] == pattern){
                    num++;
                }
            }
        }

        return num;
    }

    public double getRadius(){
        return radius;
    }
}




