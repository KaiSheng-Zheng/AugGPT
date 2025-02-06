public class Circle extends Shape{
    private int radius;
    public Circle(Location location,char pattern,int radius){
        super(location,pattern);
        this.radius=radius;
        grids=new char[radius*2][radius*2];
        this.fillGrids();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    @Override
    public void fillGrids() {
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                this.grids[i][j] = ' ';
            }

        }
        for (int i = 1; i < radius + 1; i++) {
            for (int j = 1; j < radius + 1; j++) {
                if (Math.sqrt((radius - i) * (radius - i) + (radius - j) * (radius - j)) < radius) {
                    this.grids[i - 1][j - 1] = pattern;
                }
            }
        }
        for (int i = 1; i < radius + 1; i++) {
            for (int j =  radius; j < radius * 2; j++) {
                if (Math.sqrt((radius - i) * (radius - i) + (radius - j) * (radius - j)) < radius) {
                    this.grids[i - 1][j] = pattern;
                }
            }
        }
        for (int i =  radius; i < radius * 2; i++) {
            for (int j = 1; j < radius + 1; j++) {
                if (Math.sqrt((radius - i) * (radius - i) + (radius - j) * (radius - j)) < radius) {
                    this.grids[i][j - 1] = pattern;
                }
            }

        }
        for (int i =  radius; i < radius * 2; i++) {
            for (int j =  radius; j < radius * 2; j++) {
                if (Math.sqrt((radius - i) * (radius - i) + (radius - j) * (radius - j)) < radius) {
                    this.grids[i][j] = pattern;
                }
            }

        }
    }
    @Override
    public void enlarge(){
        this.radius++;
        this.grids=new char[radius*2][radius*2];
        fillGrids();
    }
    @Override
    public void shrink(){
        this.radius--;
        this.grids=new char[radius*2][radius*2];
        fillGrids();
    }
    @Override
    public int area(){
        int count = 0;
        for (int i=0;i<radius*2;i++){
            for(int j=0;j<radius*2;j++){
                if(grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }
}
