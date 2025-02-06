public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }
    @Override
    public void fillGrids(){
        this.grids = new char[radius*2][radius*2];
        int count=0;
        for(int x=0; x<radius*2; x++){
            for(int y=0; y<radius*2; y++){
                int sqr1 = (int)(Math.pow(x-radius, 2)+Math.pow(y-radius, 2));
                int sqr2 = (int)(Math.pow(x+1-radius, 2)+Math.pow(y-radius, 2));
                int sqr3 = (int)(Math.pow(x-radius, 2)+Math.pow(y+1-radius, 2));
                int sqr4 = (int)(Math.pow(x+1-radius, 2)+Math.pow(y+1-radius, 2));
                int sqr = (int)(Math.pow(radius, 2));
                if(sqr1<sqr|sqr2<sqr|sqr3<sqr|sqr4<sqr){
                    this.grids[x][y] = pattern;
                    count++;
                }
                else{
                    this.grids[x][y] = ' ';
                }
            }
        }
        filledgrids = count;
    }
    @Override
    public void enlarge(){
        this.radius++;
        fillGrids();
    }
    @Override
    public  void shrink(){
        this.radius--;
        fillGrids();
    }
    @Override
    public int area(){
        return filledgrids;
    }
    @Override
    public String toString() {
        return "Circle: "+location.toString()+" area="+area()+" pattern="+this.pattern;
    }
    
}
