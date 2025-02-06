public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius) {
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }

    public void fillGrids(){
        grids = new char[this.radius*2][this.radius*2];
        for(int i=0;i<this.radius*2;i++){
            for(int j=0;j<this.radius*2;j++){
                if((this.radius-i)*(this.radius-i)+(this.radius-j)*(this.radius-j)>=this.radius*this.radius && (this.radius-i-1)*(this.radius-i-1)+(this.radius-j)*(this.radius-j)>=this.radius*this.radius && (this.radius-i)*(this.radius-i)+(this.radius-j-1)*(this.radius-j-1)>=this.radius*this.radius && (this.radius-i-1)*(this.radius-i-1)+(this.radius-j-1)*(this.radius-j-1)>=this.radius*this.radius){
                    grids[i][j]=' ';
                }else{
                    grids[i][j]=getPattern();
                }
            }
        }
    }
    public void enlarge(){
        this.radius++;
        fillGrids();
        area();
    }
    public void shrink(){
        this.radius--;
        fillGrids();
        area();
    }
    int S = 0;
    public int area(){
        int Q = 0;
        for(int i=0;i<this.radius*2;i++) {
            for (int j=0;j<this.radius*2;j++) {
                if (getGrids()[i][j] == getPattern()) {
                    Q++;
                }
            }
        }
        S=Q;
        return Q;
    }
    public String toString(){
        // S will be zero if not calling area() before toString()!
        String P = "Circle: "+this.location.toString()+" area="+S+" pattern="+getPattern();
        return P;
    }
}
