public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[2*this.radius][2*this.radius];
        for(int i=0;i<grids.length;i++){
            for(int j=0;j< grids.length;j++){
                if(isIn(i,j)){
                    grids[i][j] = this.pattern;
                }
                else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    public boolean isIn(int i,int j) {
        if((i-radius)*(i-radius) + (j-radius)*(j-radius) < radius*radius){
            return true;
        }
        else if((i+1-radius)*(i+1-radius) + (j-radius)*(j-radius) < radius*radius){
            return true;
        }
        else if((i-radius)*(i-radius) + (j+1-radius)*(j+1-radius) < radius*radius){
            return true;
        }
        else return (i+1-radius)*(i+1-radius) + (j+1-radius)*(j+1-radius) < radius*radius;
    }

    @Override
    public void enlarge() {
        this.radius ++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.radius --;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for(char[] line: this.grids){
            for(char c: line){
                if(c == this.pattern){
                    count ++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Circle: " + super.toString();
    }
}
