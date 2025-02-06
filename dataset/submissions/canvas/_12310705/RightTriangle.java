public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location,char pattern,int width, int height, Direction d) {
        super(pattern, location);
        this.width = width;
        this.height = height;
        this.d = d;
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[height][width];
        if(this.d==Direction.LEFT_DOWN){
                for(int i = 0;i<height;i++){
                    for(int j = 0;j<width;j++){
                        if(width*(i+1)>j*height){
                            grids[i][j]=pattern;
                        }
                        else{
                            grids[i][j]=' ';
                        }
                    }
                }}

            else if(this.d==Direction.LEFT_UP){
                for(int i = 0;i<height;i++){
                    for(int j = 0;j<width;j++){
                        if(width*(height-i)>j*height){
                            grids[i][j]=pattern;
                        }
                        else{
                            grids[i][j]=' ';
                        }
                    }
                }}

                else if(this.d==Direction.RIGHT_DOWN){
                for(int i = 0;i<height;i++){
                    for(int j = 0;j<width;j++){
                        if(width*(i+1)>(width-j-1)*height){
                            grids[i][j]=pattern;
                        }
                        else{
                            grids[i][j]=' ';
                        }
                    }
                }}
                else if(this.d==Direction.RIGHT_UP){
                for(int i = 0;i<height;i++){
                    for(int j = 0;j<width;j++){
                        if(width*(height-i)>(width-j-1)*height){
                            grids[i][j]=pattern;
                        }
                        else{
                            grids[i][j]=' ';
                        }
                    }
                }}

        }




    @Override
    public void enlarge() {
        this.width++;
        this.height++;
        this.fillGrids();

    }

    @Override
    public void shrink() {
        this.width--;
        this.height--;
        this.fillGrids();
    }

    @Override
    public int area() {
        int count1 = 0;
        for(int i = 0;i<height;i++){
            for(int j = 0;j<width;j++){
                if(width*(i+1)>j*height){
                    count1++;
                }
            }
    }return count1;}

    @Override
    public String toString() {
        return "RightTriangle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
    }
}
