class Circle extends Shape{
    private int radius;

    public Circle(Location location,char pattern,int radius){
        super(location,pattern);
        this.location=new Location(location.getX(), location.getY());
        this.pattern=pattern;
        this.radius=radius;
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        grids=new char[2*radius][2*radius];
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                grids[i][j] = ' ';
            }
        }
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if (i<radius&j<radius) {
                    if ((radius - j - 1) * (radius - j - 1) + (radius - i - 1) * (radius - i - 1) < radius * radius) {
                        grids[i][j] = pattern;
                    } else if ((radius - j - 1) * (radius - j - 1) + (radius - i - 1) * (radius - i - 1) >= radius * radius) {
                        grids[i][j] =grids[i][j];
                    }
                }else if (i<radius&j>=radius) {
                    if ((radius - j) * (radius - j) + (radius - i - 1) * (radius - i - 1) < radius * radius) {
                        grids[i][j] = pattern;
                    } else if ((radius - j) * (radius - j) + (radius - i - 1) * (radius - i - 1) >= radius * radius) {
                        grids[i][j] =grids[i][j];
                    }
                }else if (i>=radius&j<radius){
                    if ((radius - j-1) * (radius - j-1) + (radius - i) * (radius - i) < radius * radius) {
                        grids[i][j] = pattern;
                    } else if ((radius - j-1) * (radius - j-1) + (radius - i) * (radius - i) >= radius * radius) {;
                        grids[i][j] = grids[i][j];
                    }
                }else if (i>=radius&j>=radius){
                    if ((radius - j) * (radius - j) + (radius - i) * (radius - i) < radius * radius) {
                        grids[i][j] = pattern;
                    } else if ((radius - j) * (radius - j) + (radius - i) * (radius - i) >= radius * radius) {
                        grids[i][j] = grids[i][j];
                    }
                }
            }
        }
    }

    public char[][] getGrids() {
        return grids;
    }

    @Override
    public void enlarge() {
        radius++;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        this.fillGrids();
    }

    @Override
    public int area() {
        int a=0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j]==pattern){
                 a++;
                }
            }
        }
        return a;
    }

    public String toString(){
        return "Circle: "+location+" area="+area()+" pattern="+pattern;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}