public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location,pattern);
        this.radius=radius;
    }

    public void fillGrids() {
        grids=new char[2*radius][2*radius];
        for(int i=0;i<2*radius;i++){
            for (int j=0;j<2*radius;j++){
                grids[i][j]=' ';
            }
        }
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (Math.pow(i - radius, 2) + Math.pow(j - radius, 2) < Math.pow(radius, 2) |
                        Math.pow(i + 1 - radius, 2) + Math.pow(j - radius, 2) < Math.pow(radius, 2) |
                        Math.pow(i - radius, 2) + Math.pow(j + 1 - radius, 2) < Math.pow(radius, 2) |
                        Math.pow(i + 1 - radius, 2) + Math.pow(j + 1 - radius, 2) < Math.pow(radius, 2)) {
                 grids[i][j] = pattern;
                }
            }
        }
    }

    public void enlarge() {
        this.radius++;
        fillGrids();
    }

    public void shrink() {
        this.radius--;
        fillGrids();
    }

    public int area() {
        fillGrids();
        int a=0;
        for (int i=0;i<2*radius;i++){
            for (int j=0;j<2*radius;j++){
                if(this.grids[i][j]==pattern){
                    a++;
                }
            }
        }
        return a;

    }
    public String toString(){
        return "Circle: "+this.location.toString()+" area="+this.area()+" pattern="+this.pattern;
    }

}
