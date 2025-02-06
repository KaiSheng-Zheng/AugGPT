public class Circle extends Shape {
    private int radius;
    private int count;
    public Circle(Location location, char pattern, int radius) {
        super(location,pattern);
        this.location = location;
        this.pattern = pattern;
        this.radius = radius;
        this.grids=new char[2*radius][2*radius];
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (i < radius) {
                    if ((radius - i - 1) * (radius - i - 1) + (radius - j - 1) * (radius - j - 1) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }else{
                    if ((i-radius) * (i-radius) + (radius - j- 1) * (radius - j - 1) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }
            }
            for (int j = radius; j < 2*radius; j++) {
                if (i < radius) {
                    if ((radius - i - 1) * (radius - i - 1) + (j-radius) * (j-radius) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }else{
                    if ((i-radius) * (i-radius) + (j-radius) * (j-radius) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }
            }
        }
    }

    public void fillGrids() {
        count=0;
        this.grids=new char[2*radius][2*radius];
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (i < radius) {
                    if ((radius - i - 1) * (radius - i - 1) + (radius - j - 1) * (radius - j - 1) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }else{
                    if ((i-radius) * (i-radius) + (radius - j- 1) * (radius - j - 1) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }
            }
            for (int j = radius; j < 2*radius; j++) {
                if (i < radius) {
                    if ((radius - i - 1) * (radius - i - 1) + (j-radius) * (j-radius) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }else{
                    if ((i-radius) * (i-radius) + (j-radius) * (j-radius) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }
            }
        }

    }

    public void enlarge() {
        radius++;
        count=0;
        this.grids=new char[2*radius][2*radius];
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (i < radius) {
                    if ((radius - i - 1) * (radius - i - 1) + (radius - j - 1) * (radius - j - 1) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }else{
                    if ((i-radius) * (i-radius) + (radius - j- 1) * (radius - j - 1) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }
            }
            for (int j = radius; j < 2*radius; j++) {
                if (i < radius) {
                    if ((radius - i - 1) * (radius - i - 1) + (j-radius) * (j-radius) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }else{
                    if ((i-radius) * (i-radius) + (j-radius) * (j-radius) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }
            }
        }

    }

    public void shrink() {
        radius--;
        count=0;
        this.grids=new char[2*radius][2*radius];
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (i < radius) {
                    if ((radius - i - 1) * (radius - i - 1) + (radius - j - 1) * (radius - j - 1) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }else{
                    if ((i-radius) * (i-radius) + (radius - j- 1) * (radius - j - 1) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }
            }
            for (int j = radius; j < 2*radius; j++) {
                if (i < radius) {
                    if ((radius - i - 1) * (radius - i - 1) + (j-radius) * (j-radius) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }else{
                    if ((i-radius) * (i-radius) + (j-radius) * (j-radius) < radius*radius) {
                        grids[i][j] = pattern;count++;
                    }else  grids[i][j] = ' ';
                }
            }
        }


    }

    public int area() {
        return count;
    }
    public String toString()
    {
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),count,pattern);
    }
}
