public class Circle extends Shape{
    private int radius;
    public char[][] getGrids(int radius){
        return grids;
    }
    public void fillGrids() {
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if ((radius - i - 1) * (radius - 1 - i) + (radius - j - 1) * (radius - j - 1) < radius * radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
        for (int i = radius; i < 2 * radius; i++) {
            for (int j = 0; j < radius; j++) {
                grids[i][j] = grids[2 * radius - 1 - i][j];
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = radius; j < 2 * radius; j++) {
                grids[i][j] = grids[i][2 * radius - 1 - j];
            }
        }
        for (int i = radius; i < 2 * radius; i++) {
            for (int j = radius; j < 2 * radius; j++) {
                grids[i][j] = grids[2 * radius - 1 - i][2 * radius - 1 - j];
            }
        }
    }
        public void enlarge(){
            radius+=1;
            this.grids=new char[2*radius][2*radius];
            this.fillGrids();
        }
        public void shrink(){
            radius-=1;
            this.grids=new char[2*radius][2*radius];
            this.fillGrids();
        }
        public int area(){
            int area=0;
            for (int i = 0; i < 2*radius; i++) {
                for (int j = 0; j < 2*radius; j++) {
                    if(grids[i][j]==pattern){
                        area+=1;
                    }
                }
            }
            return area;
        }
        public char[][] getGrids(){
            return grids;
        }



    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        this.grids=new char[2*radius][2*radius];
        this.fillGrids();
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }

}