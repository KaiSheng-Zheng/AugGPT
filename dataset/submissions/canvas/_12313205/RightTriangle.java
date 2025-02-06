public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;

        fillGrids();
    }

    @Override
    public void fillGrids() {
        char[][] triangleGrids = new char[height][width];

        for (int i = 0; i < triangleGrids.length; i++) {
            for (int j = 0; j < triangleGrids[0].length; j++) {
                triangleGrids[i][j] = ' ';
            }
        }


        double rate = 1.00 * width / height;


        if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i < triangleGrids.length; i++) {

                double horizonDistance = (i + 1) * rate;

                if (horizonDistance != (int) Math.floor(horizonDistance)) {
                    for (int k = 0; k < horizonDistance; k++) {
                        triangleGrids[i][k] = pattern;
                        triangleGrids[i + 1][k] = pattern;
                    }
                }

                if (horizonDistance == (int) Math.floor(horizonDistance)) {
                    for (int k = 0; k < horizonDistance; k++) {
                        triangleGrids[i][k] = pattern;
                    }
                }

            }

            super.setGrids(triangleGrids);
        }


        if (d == Direction.LEFT_UP) {
            for (int i = 0; i < triangleGrids.length; i++) {
                double horizonDistance = (i + 1) * rate;

                if (horizonDistance != (int) Math.floor(horizonDistance)) {
                    for (int k = 0; k < horizonDistance; k++) {
                        triangleGrids[height - i - 2][k] = pattern;
                        triangleGrids[height - i - 1][k] = pattern;
                    }
                }

                if (horizonDistance == (int) Math.floor(horizonDistance)) {
                    for (int k = 0; k < horizonDistance; k++) {
                        triangleGrids[height - i -1][k] = pattern;
                    }
                }
            }
            super.setGrids(triangleGrids);

        }



       if (d == Direction.RIGHT_UP) {
            for (int i = 0; i < triangleGrids.length; i++) {
                double horizonDistance = (i + 1) * rate;


                 if (horizonDistance != (int) Math.floor(horizonDistance)) {
                    for (int k = width - (int) Math.floor(horizonDistance) - 1; k < width; k++) {
                        triangleGrids[height - i - 2][k] = pattern;
                        triangleGrids[height - i - 1][k] = pattern;
                    }
                }

                if (horizonDistance == (int) Math.floor(horizonDistance)) {
                    for (int k = width - (int) Math.floor(horizonDistance); k < width; k++) {
                         triangleGrids[height - i -1][k] = pattern;
                    }
                }
            }
            super.setGrids(triangleGrids);

        }


        if (d == Direction.RIGHT_DOWN) {
            for (int i = 0; i < triangleGrids.length; i++) {

                double horizonDistance = (i + 1) * rate;
                if (horizonDistance != (int) Math.floor(horizonDistance)) {
                    for (int k = width - (int) Math.floor(horizonDistance) - 1; k < width; k++) {
                        triangleGrids[i][k] = pattern;
                        triangleGrids[i + 1][k] = pattern;
                    }
                }

                if (horizonDistance == (int) Math.floor(horizonDistance)) {
                    for (int k = width - (int) Math.floor(horizonDistance); k < width; k++) {
                        triangleGrids[i][k] = pattern;
                    }
                }

            }

            super.setGrids(triangleGrids);

        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        char[][] triangleGrids = new char[height][width];

        for (int i = 0; i < triangleGrids.length; i++) {
            for (int j = 0; j < triangleGrids[0].length; j++) {
                triangleGrids[i][j] = ' ';
            }
        }

        double rate = 1.00 * width / height;


        if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i < triangleGrids.length; i++) {

                double horizonDistance = (i + 1) * rate;
                if (horizonDistance != (int) Math.floor(horizonDistance)) {
                    for (int k = 0; k < horizonDistance; k++) {
                        triangleGrids[i][k] = pattern;
                        triangleGrids[i + 1][k] = pattern;
                    }
                }

                if (horizonDistance == (int) Math.floor(horizonDistance)) {
                    for (int k = 0; k < horizonDistance; k++) {
                        triangleGrids[i][k] = pattern;
                    }
                }

            }

            super.setGrids(triangleGrids);
        }



        if (d == Direction.LEFT_UP) {
            for (int i = 0; i < triangleGrids.length; i++) {
                double horizonDistance = (i + 1) * rate;

                if (horizonDistance != (int) Math.floor(horizonDistance)) {
                    for (int k = 0; k < horizonDistance; k++) {
                        triangleGrids[height - i - 2][k] = pattern;
                        triangleGrids[height - i - 1][k] = pattern;
                    }
                }

                if (horizonDistance == (int) Math.floor(horizonDistance)) {
                    for (int k = 0; k < horizonDistance; k++) {
                        triangleGrids[height - i -1][k] = pattern;
                    }
                }
            }
            super.setGrids(triangleGrids);

        }



        if (d == Direction.RIGHT_UP) {
            for (int i = 0; i < triangleGrids.length; i++) {
                double horizonDistance = (i + 1) * rate;


                if (horizonDistance != (int) Math.floor(horizonDistance)) {
                    for (int k = width - (int) Math.floor(horizonDistance) - 1; k < width; k++) {
                        triangleGrids[height - i - 2][k] = pattern;
                        triangleGrids[height - i - 1][k] = pattern;
                    }
                }

                if (horizonDistance == (int) Math.floor(horizonDistance)) {
                    for (int k = width - (int) Math.floor(horizonDistance); k < width; k++) {
                        triangleGrids[height - i -1][k] = pattern;//
                    }
                }
            }
            super.setGrids(triangleGrids);

        }


        if (d == Direction.RIGHT_DOWN) {
            for (int i = 0; i < triangleGrids.length; i++) {

                double horizonDistance = (i + 1) * rate;
                if (horizonDistance != (int) Math.floor(horizonDistance)) {
                    for (int k = width - (int) Math.floor(horizonDistance) - 1; k < width; k++) {
                        triangleGrids[i][k] = pattern;
                        triangleGrids[i + 1][k] = pattern;
                    }
                }

                if (horizonDistance == (int) Math.floor(horizonDistance)) {
                    for (int k = width - (int) Math.floor(horizonDistance); k < width; k++) {
                        triangleGrids[i][k] = pattern;
                    }
                }

            }

            super.setGrids(triangleGrids);

        }

    }

    @Override
    public void shrink() {
        if (height > 1 && width > 1) {
            height--;
            width--;
            char[][] triangleGrids = new char[height][width];

            for (int i = 0; i < triangleGrids.length; i++) {
                for (int j = 0; j < triangleGrids[0].length; j++) {
                    triangleGrids[i][j] = ' ';
                }
            }

            double rate = 1.00 * width / height;


            if (d == Direction.LEFT_DOWN) {
                for (int i = 0; i < triangleGrids.length; i++) {

                    double horizonDistance = (i + 1) * rate;
                    if (horizonDistance != (int) Math.floor(horizonDistance)) {
                        for (int k = 0; k < horizonDistance; k++) {
                            triangleGrids[i][k] = pattern;
                            triangleGrids[i + 1][k] = pattern;
                        }
                    }

                    if (horizonDistance == (int) Math.floor(horizonDistance)) {
                        for (int k = 0; k < horizonDistance; k++) {
                            triangleGrids[i][k] = pattern;
                        }
                    }

                }

                super.setGrids(triangleGrids);
            }



            if (d == Direction.LEFT_UP) {
                for (int i = 0; i < triangleGrids.length; i++) {
                    double horizonDistance = (i + 1) * rate;

                    if (horizonDistance != (int) Math.floor(horizonDistance)) {
                        for (int k = 0; k < horizonDistance; k++) {
                            triangleGrids[height - i - 2][k] = pattern;
                            triangleGrids[height - i - 1][k] = pattern;
                        }
                    }

                    if (horizonDistance == (int) Math.floor(horizonDistance)) {
                        for (int k = 0; k < horizonDistance; k++) {
                            triangleGrids[height - i - 1][k] = pattern;
                        }
                    }
                }
                super.setGrids(triangleGrids);

            }



            if (d == Direction.RIGHT_UP) {
                for (int i = 0; i < triangleGrids.length; i++) {
                    double horizonDistance = (i + 1) * rate;


                    if (horizonDistance != (int) Math.floor(horizonDistance)) {
                        for (int k = width - (int) Math.floor(horizonDistance) - 1; k < width; k++) {
                            triangleGrids[height - i - 2][k] = pattern;
                            triangleGrids[height - i - 1][k] = pattern;
                        }
                    }

                    if (horizonDistance == (int) Math.floor(horizonDistance)) {
                        for (int k = width - (int) Math.floor(horizonDistance); k < width; k++) {
                            triangleGrids[height - i - 1][k] = pattern;
                        }
                    }
                }
                super.setGrids(triangleGrids);

            }


            if (d == Direction.RIGHT_DOWN) {
                for (int i = 0; i < triangleGrids.length; i++) {

                    double horizonDistance = (i + 1) * rate;
                    if (horizonDistance != (int) Math.floor(horizonDistance)) {
                        for (int k = width - (int) Math.floor(horizonDistance) - 1; k < width; k++) {
                            triangleGrids[i][k] = pattern;
                            triangleGrids[i + 1][k] = pattern;
                        }
                    }

                    if (horizonDistance == (int) Math.floor(horizonDistance)) {
                        for (int k = width - (int) Math.floor(horizonDistance); k < width; k++) {
                            triangleGrids[i][k] = pattern;
                        }
                    }

                }

                super.setGrids(triangleGrids);

            }

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



    public String toString() {
        String result = "RightTriangle: " + location + " area=" + area() + " pattern=" + pattern;
        return result;
    }
}
