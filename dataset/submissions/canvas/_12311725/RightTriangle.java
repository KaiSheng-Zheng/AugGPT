public class RightTriangle extends Shape{
    private int width;
    private int height;

    private final Direction d;

    
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        Direction[]directions=Direction.values();
        this.width=width;
        this.height=height;
        this.d=d;
        this.grids = new char[this.height][this.width];
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        
        grids = null;
        
        grids = new char [this.height][this.width];

        
        if(this.d== Direction.LEFT_DOWN){
            for(int i=0;i<=this.height-1;i++){
                for(int j=0;j<=this.width-1;j++){
                    if(j*(height)>=(width)*i&&(j+1)*(height)>=(width)*i&&j*(height)>=(width)*(i+1)&&(j+1)*(height)>=(width)*(i+1)){
                        grids[i][j]=' ';

                    }
                    else{
                        grids[i][j]=pattern;
                    }
                }
            }

        }
        if(this.d== Direction.LEFT_UP){
            for(int i=0;i<=this.height-1;i++){
                for(int j=0;j<=this.width-1;j++){
                    if((j-width)*(height)>=-(width)*i&&(j+1-width)*(height)>=-(width)*i&&(j-width)*(height)>=-(width)*(i+1)&&(j+1-width)*(height)>=-(width)*(i+1)){
                        grids[i][j]=' ';

                    }
                    else{
                        grids[i][j]=pattern;
                    }
                }
            }

        }
        if(this.d== Direction.RIGHT_DOWN){
            for(int i=0;i<=this.height-1;i++){
                for(int j=0;j<=this.width-1;j++){
                    if((j-width)*(height)<=-(width)*i&&(j+1-width)*(height)<=-(width)*i&&(j-width)*(height)<=-(width)*(i+1)&&(j+1-width)*(height)<=-(width)*(i+1)){
                        grids[i][j]=' ';

                    }
                    else{
                        grids[i][j]=pattern;
                    }
                }
            }

        }
        if(this.d== Direction.RIGHT_UP){
            for(int i=0;i<=this.height-1;i++){
                for(int j=0;j<=this.width-1;j++){
                    if(j*(height)<=(width)*i&&(j+1)*(height)<=(width)*i&&j*(height)<=(width)*(i+1)&&(j+1)*(height)<=(width)*(i+1)){
                        grids[i][j]=' ';

                    }
                    else{
                        grids[i][j]=pattern;
                    }
                }
            }

        }




    }

    @Override
    public void enlarge() {
        if(width<20&&height<20) {
            width++;height++;
            fillGrids();
        }

    }

    @Override
    public void shrink() {
        if(width>1&&height>1) {
            width--;height--;
            fillGrids();
        }

    }

    @Override
    public int area() {
        int k=0;
        for(int i=0;i<=this.height-1;i++){
            for(int j=0;j<=this.width-1;j++){
                if(grids[i][j]==this.pattern){
                    k++;
                }
            }
        }
        return k;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%s",this.location.getX(),this.location.getY(),this.area(),String.valueOf(this.pattern));
    }
}
