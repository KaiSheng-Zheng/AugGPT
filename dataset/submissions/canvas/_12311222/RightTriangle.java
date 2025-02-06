public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    private int count;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d= d;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public int area(){
        return getCount();
    }
    @Override
    public String toString(){
        return String.format("RightTriangle: "+getLocation()+" area="+getCount()+" pattern="+getPattern());
    }
}
