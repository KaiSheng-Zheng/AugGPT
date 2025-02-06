public class Circle extends Shape{
    private int radius;
    public Circle(Location location,char pattern,int radius) {
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[radius * 2][radius * 2];
        for(int i=0;i<radius*2;i++) {
            for (int j = 0; j < radius*2; j++) {
                grids[i][j]=' ';
            }
        }
        //leftup
        for(int i=0;i<radius;i++) {
            for (int j = 0; j < radius; j++) {
                if (Math.pow(i + 1 - radius, 2) + Math.pow(j + 1 - radius, 2) < Math.pow(radius, 2)) {
                    grids[i][j] = pattern;
                }
            }
        }
        //rightup
        for(int i=0;i<radius;i++) {
            for (int j =radius; j <radius*2; j++) {
                if (Math.pow(i + 1 - radius, 2) + Math.pow(j - radius, 2) < Math.pow(radius, 2)) {
                    grids[i][j] = pattern;
                }
            }
        }
        //leftdown
        for(int i=radius;i<radius*2;i++) {
            for (int j =0; j <radius; j++) {
                if (Math.pow(i - radius, 2) + Math.pow(j+1 - radius, 2) < Math.pow(radius, 2)) {
                    grids[i][j] = pattern;
                }
            }
        }
        //rightdown
        for(int i=radius;i<radius*2;i++) {
            for (int j =radius; j <radius*2; j++) {
                if (Math.pow(i - radius, 2) + Math.pow(j - radius, 2) < Math.pow(radius, 2)) {
                    grids[i][j] = pattern;
                }
            }
        }
    }

    /*@Override
    public void fillGrids(){
        setGrids();
        //for (char[] grid : grids) {
        //    System.out.println(grid);
        //}
        int len = grids.length;
        for(int i=0;i<len;i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(grids[i][j]);
            }
            System.out.println();
        }
    }*/

    @Override
    public void enlarge(){
        this.radius = this.radius + 1;
        fillGrids();
    }
    @Override
    public void shrink(){
        this.radius = this.radius - 1;
        fillGrids();
    }
    @Override
    public int area(){
        int count =0;
        int len = grids.length;
        for(int i=0;i<len;i++) {
            for (int j = 0; j < len; j++) {
                if (grids[i][j] != ' '){
                    count++;
                }
            }
        }
        return count;
    }
    @Override
    public String toString(){
        return "Circle: (" + location.getX() + "," + location.getY() +
                ") area=" + area() + " pattern=" + pattern;
    }
}
