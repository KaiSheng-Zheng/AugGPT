public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;

        fillGrids();
    }


    @Override
    public void fillGrids() {

        int length = radius*2;
        int width = radius*2;
        char[][] circleGrids = new char[length][width];
        for (int i = 0; i < circleGrids.length; i++) {
            for (int j = 0; j < circleGrids[0].length; j++) {

                if((i+1 <= radius) && (j+1 <= radius)) {
                    double horizonDistance = (i + 1) - radius;
                    double verticalDistance = (j + 1) - radius;
                    if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                        circleGrids[i][j] = pattern;
                    } else {
                        circleGrids[i][j] = ' ';
                    }
                }

                if((i+1 <= radius) && (j+1  > radius)) {
                    double horizonDistance = (i + 1) - radius;
                    double verticalDistance = j - radius;
                    if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                        circleGrids[i][j] = pattern;
                    } else {
                        circleGrids[i][j] = ' ';
                    }
                }

                if((i+1 > radius) && (j+1 <= radius)) {
                    double horizonDistance = i - radius;
                    double verticalDistance = (j + 1) - radius;
                    if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                        circleGrids[i][j] = pattern;
                    } else {
                        circleGrids[i][j] = ' ';
                    }
                }

                if((i+1 > radius) && (j+1 > radius)) {
                    double horizonDistance = i - radius;
                    double verticalDistance = (j) - radius;
                    if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                        circleGrids[i][j] = pattern;
                    } else {
                        circleGrids[i][j] = ' ';
                    }
                }

            }
        }

        super.setGrids(circleGrids);
    }


    @Override
    public void enlarge() {

        radius++;
        int length = radius*2;
        int width = radius*2;
        char[][] circleGrids = new char[length][width];
        for (int i = 0; i < circleGrids.length; i++) {
            for (int j = 0; j < circleGrids[0].length; j++) {

                if((i+1 <= radius) && (j+1 <= radius)) {
                    double horizonDistance = (i + 1) - radius;
                    double verticalDistance = (j + 1) - radius;
                    if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                        circleGrids[i][j] = pattern;
                    } else {
                        circleGrids[i][j] = ' ';
                    }
                }

                if((i+1 <= radius) && (j+1  > radius)) {
                    double horizonDistance = (i + 1) - radius;
                    double verticalDistance = j - radius;
                    if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                        circleGrids[i][j] = pattern;
                    } else {
                        circleGrids[i][j] = ' ';
                    }
                }

                if((i+1 > radius) && (j+1 <= radius)) {
                    double horizonDistance = i - radius;
                    double verticalDistance = (j + 1) - radius;
                    if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                        circleGrids[i][j] = pattern;
                    } else {
                        circleGrids[i][j] = ' ';
                    }
                }

                if((i+1 > radius) && (j+1 > radius)) {
                    double horizonDistance = i - radius;
                    double verticalDistance = (j) - radius;
                    if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                        circleGrids[i][j] = pattern;
                    } else {
                        circleGrids[i][j] = ' ';
                    }
                }

            }
        }

        super.setGrids(circleGrids);
    }


    @Override
    public void shrink() {
        if(radius > 1){

            radius--;
            int length = radius*2;
            int width = radius*2;
            char[][] circleGrids = new char[length][width];
            for (int i = 0; i < circleGrids.length; i++) {
                for (int j = 0; j < circleGrids[0].length; j++) {

                    if((i+1 <= radius) && (j+1 <= radius)) {
                        double horizonDistance = (i + 1) - radius;
                        double verticalDistance = (j + 1) - radius;
                        if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                            circleGrids[i][j] = pattern;
                        } else {
                            circleGrids[i][j] = ' ';
                        }
                    }

                    if((i+1 <= radius) && (j+1  > radius)) {
                        double horizonDistance = (i + 1) - radius;
                        double verticalDistance = j - radius;
                        if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                            circleGrids[i][j] = pattern;
                        } else {
                            circleGrids[i][j] = ' ';
                        }
                    }

                    if((i+1 > radius) && (j+1 <= radius)) {
                        double horizonDistance = i - radius;
                        double verticalDistance = (j + 1) - radius;
                        if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                            circleGrids[i][j] = pattern;
                        } else {
                            circleGrids[i][j] = ' ';
                        }
                    }

                    if((i+1 > radius) && (j+1 > radius)) {
                        double horizonDistance = i - radius;
                        double verticalDistance = (j) - radius;
                        if (horizonDistance * horizonDistance + verticalDistance * verticalDistance < radius * radius) {
                            circleGrids[i][j] = pattern;
                        } else {
                            circleGrids[i][j] = ' ';
                        }
                    }

                }
            }

            super.setGrids(circleGrids);
        }
    }



    @Override
    public int area() {
        int gridCount = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if(grids[i][j] ==  pattern){
                    gridCount++;
                }
            }
        }
        return gridCount;
    }




    public String toString(){
        String result = "Circle: " + location + " area=" + area() + " pattern=" + pattern;
        return result;
    }

}
