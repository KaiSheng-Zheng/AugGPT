public class RightTriangle extends Shape{
    private int width;

    private int height;

    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }


    public void fillGrids(){
        switch (d) {
            case LEFT_DOWN:
                for(int i=0; i<height; i++){
                    for(int j=0; j<width; j++){
                        if(j < width-(width*i)/height){
                            grids[height-1-i][j] = pattern;
                        }
                        else{
                            grids[height-1-i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_UP:
                for(int i=0; i<height; i++){
                    for(int j=0; j<width; j++){
                        if(j < width-(width*i)/height){
                            grids[i][width-1-j] = pattern;
                        }
                        else{
                            grids[i][width-1-j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for(int i=0; i<height; i++){
                    for(int j=0; j<width; j++){
                        if(j < width-(width*i)/height){
                            grids[height-1-i][width-1-j] = pattern;
                        }
                        else{
                            grids[height-1-i][width-1-j] = ' ';
                        }
                    }
                }
                break;
            case LEFT_UP:
                for(int i=0; i<height; i++){
                    for(int j=0; j<width; j++){
                        if(j < width-(width*i)/height){
                            grids[i][j] = pattern;
                        }
                        else{
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
        }
    }

    public void enlarge(){
        this.height = height + 1;
        this.width = width + 1;
        this.grids = new char[height][width];
        fillGrids();
    }

    public void shrink(){
        this.height = height - 1;
        this.width = width - 1;
        this.grids = new char[height][width];
        fillGrids();
    }

    public int area(){
        int sum=0;
        for(int i=0; i<height; i++){
            sum+=width-((width*i))/height;
        }
        return sum;
    }

    public String toString(){
        return String.format("%s: (%d,%d) area=%d pattern=%c","RightTriangle",location.getX(),location.getY(),area(),pattern);
    }

}
