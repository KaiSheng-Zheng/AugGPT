public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;


    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }

    public void fillGrids(){
        grids = new char[this.height][this.width];
        switch(this.d) {
            case LEFT_UP:
                for(int i=0;i<this.height;i++){
                    for(int j=0;j<this.width;j++){
                        if(i*this.width+j*this.height<this.height*this.width){
                            grids[i][j]=getPattern();
                        }else{
                            grids[i][j]=' ';
                        }
                    }
                }
                break;
            case RIGHT_UP:
                for(int i=0;i<this.height;i++){
                    for(int j=0;j<this.width;j++){
                        if(i*this.width+(this.width-j-1)*this.height<this.height*this.width){
                            grids[i][j]=getPattern();
                        }else{
                            grids[i][j]=' ';
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for(int i=0;i<this.height;i++){
                    for(int j=0;j<this.width;j++){
                        if((this.height-i-1)*this.width+(this.width-j-1)*this.height<this.height*this.width){
                            grids[i][j]=getPattern();
                        }else{
                            grids[i][j]=' ';
                        }
                    }
                }
                break;
            case LEFT_DOWN:
                for(int i=0;i<this.height;i++){
                    for(int j=0;j<this.width;j++){
                        if((this.height-i-1)*this.width+j*this.height<this.height*this.width){
                            grids[i][j]=getPattern();
                        }else{
                            grids[i][j]=' ';
                        }
                    }
                }
                break;
        }
    }
    public void enlarge(){
        this.width++;
        this.height++;
        fillGrids();
        area();
    }
    public void shrink(){
        this.width--;
        this.height--;
        fillGrids();
        area();
    }
    int S=0;
    public int area(){
        int Q = 0;
        for(int i=0;i<this.height;i++) {
            for (int j=0;j<this.width;j++) {
                if(getGrids()[i][j]==getPattern()){
                    Q++;
                }
            }
        }
        S=Q;
        return Q;
    }
    public String toString() {
        String P = "RightTriangle: " + this.location.toString() + " area=" + S + " pattern=" + getPattern();
        return P;
    }
}
