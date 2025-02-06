public class Circle extends Shape {

    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        char a = ' ';
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = 0; i1 < grids[i].length; i1++) {
                grids[i][i1] = a;
            }
        }
        for (int i = 0; i < grids.length / 2; i++) {
            for (int i1 = 0; i1 < grids[i].length / 2; i1++) {
                double x = radius - 1 - i1;
                double y = radius - 1 - i;
                if (x * x + y * y < radius * radius) {
                    grids[i][i1] = pattern;
                }

            }


        }
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = i; i1 <grids[i].length ; i1++) {
                char temp = grids[i][i1];
                grids[i][i1] = grids[i1][i];
                grids[i1][i] = temp;
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length / 2; j++) {
                char temp = grids[i][j];
                grids[i][j] = grids[i][grids.length - 1 - j];
                grids[i][grids.length - 1 - j] = temp;
            }
        }

        for (int i = 0; i < grids.length / 2; i++) {
            for (int i1 = 0; i1 < grids[i].length / 2; i1++) {
                double x = radius - 1 - i1;
                double y = radius - 1 - i;
                if (x * x + y * y < radius * radius) {
                    grids[i][i1] = pattern;
                }

            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = i; i1 <grids[i].length ; i1++) {
                char temp = grids[i][i1];
                grids[i][i1] = grids[i1][i];
                grids[i1][i] = temp;
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length / 2; j++) {
                char temp = grids[i][j];
                grids[i][j] = grids[i][grids.length - 1 - j];
                grids[i][grids.length - 1 - j] = temp;
            }
        }

        for (int i = 0; i < grids.length / 2; i++) {
            for (int i1 = 0; i1 < grids[i].length / 2; i1++) {
                double x = radius - 1 - i1;
                double y = radius - 1 - i;
                if (x * x + y * y < radius * radius) {
                    grids[i][i1] = pattern;
                }

            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = i; i1 <grids[i].length ; i1++) {
                char temp = grids[i][i1];
                grids[i][i1] = grids[i1][i];
                grids[i1][i] = temp;
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length / 2; j++) {
                char temp = grids[i][j];
                grids[i][j] = grids[i][grids.length - 1 - j];
                grids[i][grids.length - 1 - j] = temp;
            }
        }

        for (int i = 0; i < grids.length / 2; i++) {
            for (int i1 = 0; i1 < grids[i].length / 2; i1++) {
                double x = radius - 1 - i1;
                double y = radius - 1 - i;
                if (x * x + y * y < radius * radius) {
                    grids[i][i1] = pattern;
                }

            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = i; i1 <grids[i].length ; i1++) {
                char temp = grids[i][i1];
                grids[i][i1] = grids[i1][i];
                grids[i1][i] = temp;
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length / 2; j++) {
                char temp = grids[i][j];
                grids[i][j] = grids[i][grids.length - 1 - j];
                grids[i][grids.length - 1 - j] = temp;
            }
        }

    }


    @Override
    public void enlarge() {
        radius = radius + 1;
        fillGrids();

    }

    @Override
    public void shrink() {
        radius = radius - 1;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = 0; i1 < grids[i].length; i1++) {
                if (grids[i][i1] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){
        String s= "Circle: "+"("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
        return s;
    };
}
