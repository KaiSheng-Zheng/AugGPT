import java.util.regex.Pattern;

public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern,int radius){
        super(location,pattern);
        this.radius=radius;
        this.grids = new char[this.radius*2][this.radius*2];
        this.fillGrids();
    };
    @Override
    public void fillGrids() {

        
        grids = null;
        
        grids = new char [radius*2][radius*2];
        for(int i=0;i<=this.radius*2-1;i++){
            for(int j=0;j<=this.radius*2-1;j++){
                if(((this.radius-i)*(this.radius-i)+(this.radius-j)*(this.radius-j))>=this.radius*this.radius&&((this.radius-i-1)*(this.radius-i-1)+(this.radius-j)*(this.radius-j))>=this.radius*this.radius&&((this.radius-i)*(this.radius-i)+(this.radius-j-1)*(this.radius-j-1))>=this.radius*this.radius&&((this.radius-i-1)*(this.radius-i-1)+(this.radius-j-1)*(this.radius-j-1))>=this.radius*this.radius){
                    grids[i][j]=' ';
                }
                else{
                    grids[i][j]=this.pattern;
                }

            }
        }



    }

    @Override
    public void enlarge() {
        if(radius<15) {
            radius++;
            fillGrids();
        }
    }

    @Override
    public void shrink() {
        if(radius>1) {
            radius--;
            fillGrids();
        }

    }

    @Override
    public int area() {
        int k=0;
        for(int i=0;i<=this.radius*2-1;i++){
            for(int j=0;j<=this.radius*2-1;j++){
                if(grids[i][j]==this.pattern){
                    k++;
                }
            }
        }
        return k;
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%s",this.location.getX(),this.location.getY(),this.area(),String.valueOf(this.pattern));
    }
}

