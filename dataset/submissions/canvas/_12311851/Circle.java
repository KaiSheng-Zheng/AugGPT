public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public char[][] getGrids() {

        return grids;
    }

    @Override
    public void fillGrids() {
        grids = new char[2 * radius][2 * radius];
        //left up

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (i < radius && j < radius) {
                    if ((radius - i - 1) * (radius - i - 1) + (radius - j - 1) * (radius - j - 1) < radius * radius) {
                        getGrids()[i][j] = pattern;
                    } else {
                        getGrids()[i][j] = ' ';
                    }
                }
                if (i > radius && j < radius) {
                    if ((radius - i) * (radius - i) + (radius - j - 1) * (radius - j - 1) < radius * radius) {
                        getGrids()[i][j] = pattern;
                    } else {
                        getGrids()[i][j] = ' ';
                    }
                }
                if (i > radius && j > radius) {
                    if ((radius - i) * (radius - i) + (radius - j) * (radius - j) < radius * radius) {
                        getGrids()[i][j] = pattern;
                    } else {
                        getGrids()[i][j] = ' ';
                    }
                }
                if (i < radius && j > radius) {
                    if ((radius - i-1) * (radius - i-1) + (radius - j) * (radius - j) < radius * radius) {
                        getGrids()[i][j] = pattern;
                    } else {
                        getGrids()[i][j] = ' ';
                    }


                }if(j==radius||i==radius){
                    getGrids()[i][j]=pattern;
                }
                }
            }
        }

        @Override
        public void enlarge () {
            radius++;
            fillGrids();
        }

        @Override
        public void shrink () {
            radius--;
            fillGrids();
        }

        @Override
        public int area () {
        int number =0;
            for (int i = 0; i <getGrids().length ; i++) {
                for (int j = 0; j < getGrids()[0].length; j++) {
                    if(getGrids()[i][j]==pattern){
                        number++;
                    }
                }
            }
            return number;
        }
        public String toString(){
        return  "Circle: ("+ location.getX()+","+ location.getY()+")"+" area="+area()+" pattern="+pattern;
    }
    }
