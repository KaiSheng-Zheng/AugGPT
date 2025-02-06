public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern,int radius ){
        super(location,pattern);
        if (radius >=1 && radius<=15) this.radius = radius;
        fillGrids();
    }

    public int area(){
        int num = 0;
        for(int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (grids[i][j] == pattern) num++;
            }
        }
        return num;
    }

    public void enlarge(){
        radius++;
        fillGrids();
    }

    public void shrink(){
        radius--;
        fillGrids();
    }

    public void fillGrids(){
        grids = new char[2*radius][2*radius];
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if(i<radius&&j<radius){
                    if((i+1-radius)*(i+1-radius)+(j+1-radius)*(j+1-radius) < radius*radius) grids[i][j] = pattern;
                    else grids[i][j] = ' ';
                }
                else if(i>=radius&&j>=radius){
                    if((i-radius)*(i-radius)+(j-radius)*(j-radius) < radius*radius) grids[i][j] = pattern;
                    else grids[i][j] = ' ';
                }
                else if(i>=radius&&j<radius){
                    if((i-radius)*(i-radius)+(j+1-radius)*(j+1-radius) < radius*radius) grids[i][j] = pattern;
                    else grids[i][j] = ' ';
                }
                else if(i<radius&&j>=radius){
                    if((i+1-radius)*(i+1-radius)+(j-radius)*(j-radius) < radius*radius) grids[i][j] = pattern;
                    else grids[i][j] = ' ';
                }

            }
        }
    }

    public String toString(){
        return "Circle" +super.toString();
    }

}

