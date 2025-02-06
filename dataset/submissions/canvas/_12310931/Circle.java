public class Circle extends Shape{
    private int radius;
    private double pi = 3;
    private boolean check = true;
    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
        this.fillGrids();
    }
    public void initialGrid(){
        this.grid = new char[radius * 2+1][radius*2+1];
    }
    @Override
    public void fillGrids(){
        this.grid = new char[radius*2+1][radius*2+1];
        this.grids = new char[radius*2][radius*2];
        for(int i = 1; i <= radius * 2; i++){
            for(int j = 1; j <= radius * 2; j++){
                if(i <= radius){
                    if(j <= radius){
                        if(Math.pow( ( radius - i), 2) + Math.pow((radius - j ), 2) < Math.pow( radius, 2) ){
                            grid[i][j] = this.pattern;
                        }
                    }
                    else{
                        if(Math.pow((radius - i ), 2) + Math.pow((j - radius - 1), 2) < Math.pow( radius, 2)){
                            grid[i][j] = this.pattern;
                        }
                    }
                }
                else{
                    if(j <= radius){
                        if(Math.pow( (i - radius - 1), 2) + Math.pow((radius - j), 2) < Math.pow( radius, 2) ){
                            grid[i][j] = this.pattern;
                        }
                    }
                    else{
                        if(Math.pow( (i - radius - 1), 2) + Math.pow((j - radius - 1), 2) < Math.pow( radius, 2)){
                            grid[i][j] = this.pattern;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < radius * 2; i++){
            for(int j = 0; j < radius * 2; j++){
                if(grid[i+1][j+1] == this.pattern){
                    grids[i][j] = grid[i+1][j+1];
                }
                else grids[i][j] = ' ';
            }
        }
    }
    @Override
    public void enlarge(){
        initialGrid();
        this.radius++;
        fillGrids();
    }
    @Override
    public void shrink(){
        initialGrid();
        this.radius--;
        fillGrids();
    }
    @Override
    public int area(){
        int count = 0;
        for(int i = 0; i < grids.length; i++){
            for(int j = 0; j < grids[i].length; j++){
                if(grids[i][j] == this.pattern)count++;
            }
        }
        return count;
    }
    @Override
    public String toString(){
        return "Circle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }
}
