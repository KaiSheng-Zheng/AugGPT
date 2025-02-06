public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.d = d;
        this.width = width;
        this.height = height;
        grids = new char[height][width];
        fillGrids();
    }


    public void fillGrids() {
        double t = (double)height / (double)width;
        switch (d){
            case LEFT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((height-i)<=(j*t)) {
                            grids[i][j] = ' ';
                        } else {
                            grids[i][j] = pattern;
                        }
                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((i+1)<=(t*j)) {
                            grids[i][j] = ' ';
                        } else {
                            grids[i][j] = pattern;
                        }
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (i>=(t*(j+1))) {
                            grids[i][j] = ' ';
                        } else {
                            grids[i][j] = pattern;
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((i+1)<=(height-t*(j+1))) {
                            grids[i][j] = ' ';
                        } else {
                            grids[i][j] = pattern;
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        height--;
        width--;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if (grids[i][j] == pattern) {
//                    area++;
//                }
//            }
//        }
        double t = (double)height / (double)width;
        switch (d){
            case LEFT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((height-i)<=(j*t)) {
                            area=area+0;
                        } else {
                            area++;
                        }
                    }
                }
                return area;
            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((i+1)<=(t*j)) {
                            area=area+0;
                        } else {
                            area++;
                        }
                    }
                }
                return area;
            case RIGHT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (i>=(t*(j+1))) {
                            area=area+0;
                        } else {
                            area++;
                        }
                    }
                }
                return area;
            default:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((i+1)<=(height-t*(j+1))) {
                            area=area+0;
                        } else {
                            area++;
                        }
                    }
                }
                return area;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: (%d,%d) %s=%d %s=%c",
                "RightTriangle",location.getX(),location.getY(),
                "area",area(),"pattern",pattern);
    }

    public void setWidth(int w){
        if(w>=1 & w<=20){
            this.width = w;
        }
    }
    public int getWidth(){
        return width;
    }
    public void setHeight(int h){
        if (h>=1 & h<=20){
            this.height = h;
        }
    }
    public int getHeight(){
        return height;
    }


}