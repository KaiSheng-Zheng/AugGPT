public class Circle extends Shape{
    private int radius;
    private int area;
    public Circle(Location location, char pattern, int radius,int area){
        this.location=location;
        this.pattern=pattern;
        this.radius=radius;
        this.area=area;
        fillGrids();
    }

    public Circle(Location location, char pattern, int radius) {
        this.location=location;
        this.pattern=pattern;
        this.radius=radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids=new char[2*radius][2*radius];
        for (int i = 0; i < grids.length /2 ; i++) {
            for (int j = 0; j < grids[0].length /2 ; j++) {
           int num=grids.length /2-i-1;
            int num1=(grids[0].length /2)-j-1;
            if (num1*num1+num*num<radius*radius){
                grids[i][j]=pattern;
             }else {
                grids[i][j]=' ';
             }
            }
        }
        for (int i = grids.length /2; i <grids.length ; i++) {
            for (int j = grids[0].length /2; j <grids[0].length ; j++) {
                int num = i-grids.length/2;
                int num1=j- grids[0].length /2;
                if (num1*num1+num*num<radius*radius){
                    grids[i][j]=pattern;
                }else {
                    grids[i][j]=' ';
                }
            }
        }
        for (int i = 0; i < grids.length /2 ; i++) {
            for (int j = grids[0].length/2; j <grids[0].length ; j++) {
                int num=grids.length /2-i-1;
                int num1=j- grids[0].length /2;
                if (num1*num1+num*num<radius*radius) {
                    grids[i][j] = pattern;
                }else {
                    grids[i][j]=' ';
                }
            }
        }
        for (int i = grids.length /2; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length /2 ; j++) {
               int num= i-grids.length/2;
               int num1=grids[0].length /2-j-1;
                if (num1*num1+num*num<radius*radius) {
                    grids[i][j] = pattern;
                }else {
                    grids[i][j]=' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
       radius=radius+1;
       fillGrids();

    }

    @Override
    public void shrink() {
     radius=radius-1;
     fillGrids();
    }

    @Override
    public int area() {
        int number = 0;
        for (int i = 0; i <grids.length ; i++) {
            for (int j = 0; j <grids[0].length ; j++) {
                if (grids[i][j]==pattern){
                    number=number+1;
                }
            }
        }
        return number;
    }

    @Override
    public char getPattern() {
        return this.pattern;
    }

    public String toString(){

        return"Circle: "+location.toString() +" area="+area()+" pattern="+pattern;
}

public Location getLocation(){
        return location;
}
}
