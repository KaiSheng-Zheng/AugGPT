public class Circle extends Shape{
    private int radius;
    public int count;
    public Circle(Location location, char pattern,int radius){
        super(location,pattern);
        this.radius = radius;
        setLocation(location);
        setPattern(pattern);
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public int area() {
        return getCount();
    }
    @Override
    public String toString(){
        return String.format("Circle: "+getLocation()+" area="+area()+" pattern="+getPattern());
    }
}
