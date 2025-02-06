public class Circle extends Shape {
    private int radius;
    private int fillCount;

    //public Circle() {super();}

    public Circle(Location location, char pattern, int radius) {
        this.radius = radius;
        this.location = location;
        this.pattern = pattern;
        fillCount = 0;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        fillCount = 0;
        grids = new char[radius*2][radius*2];
        int center_x = radius;
        int center_y = radius;
        for(int x=1; x<=radius;x++) {
            for (int y=1; y<=radius;y++) {
                int dis2 =(center_x-x)*(center_x-x)+(center_y-y)*(center_y-y);
                if( dis2< (radius*radius) ) {
                    grids[x-1][y-1] = this.pattern;
                    fillCount +=1;
                }
                else {
                    grids[x-1][y-1] = ' ';
                }
            }
        }

        //left flip to right
        for(int x=radius+1; x<=2*radius;x++) {
            for(int y=1; y<=radius;y++) {
                grids[x-1][y-1] = grids[2*radius-x][y-1];
            }
        }

        //up flip to down
        for(int x=1;x<=2*radius;x++) {
            for(int y=radius+1;y<=2*radius;y++) {
                grids[x-1][y-1] = grids[x-1][2*radius-y];
            }
        }
        fillCount *=4;

    }

    @Override
    public void enlarge() {
        if(radius<15) {
            radius +=1;
            fillGrids();
        }
    }

    @Override
    public void shrink() {
        if(radius>1) {
            radius -=1;
            fillGrids();
        }

    }

    @Override
    public int area() {
        return fillCount;
    }

    public String toString() {
        return "Circle: ("+location.getX()+","+location.getY()+") area="+fillCount+" pattern="+pattern;
    }

    public int getRadius() {
        return radius;
    }


}
