public class Circle extends Shape{
    private int radius;


    public Circle(Location location, char pattern, int radius){
        super(location, pattern );
        this.radius = radius;
    }

    @Override
    public void shrink() {
        radius -= 1;
    }

    @Override
    public void enlarge() {
        radius += 1;
    }

    @Override
    public void fillGrids() {
        grids = new char[2*radius][2*radius];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (Math.sqrt((radius - i - 1) * (radius - i - 1) + (radius - j - 1) * (radius - j - 1) + 0.0) < radius) {
                    grids[j][i] = pattern;
                    grids[radius * 2 - j - 1][i] = pattern;
                    grids[j][radius * 2 - i - 1] = pattern;
                    grids[radius * 2 - j - 1][radius * 2 - i - 1] = pattern;
                }
                else {
                    grids[j][i] = ' ';
                    grids[radius*2-j-1][i] = ' ';
                    grids[j][radius*2-i-1] = ' ';
                    grids[radius*2-j-1][radius*2-i-1] = ' ';
                }
            }
        }
    }

    @Override
    public int area() {
        fillGrids();
        int count = 0;
        for (int i = 0; i < 2*radius; i++){
            for (int j = 0; j < 2*radius; j++){
                if (grids[j][i] == pattern){
                    count += 1;
                }
                else {continue;}
            }
        }
        return count;
    }

    public String toString(){
        return String.format("Circle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern);
    }

}