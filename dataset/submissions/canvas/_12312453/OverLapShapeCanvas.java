import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                canvas[i][j] = ' ';
            }
        }
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        boolean flag = false;
        if (params.length == 1){
            boolean ifPrint = false;
            boolean ifJudge = true;
            for (int n = 1; n <= 2; n++) {
                here:
                for (int i = 0; i < params[0] * 2; i++) {
                    for (int j = 0; j < params[0] * 2; j++) {
                        if (i < params[0]) {
                            if (j < params[0]) {
                                if (Math.pow(params[0] - j - 1, 2) + Math.pow(params[0] - i - 1, 2) < Math.pow(params[0], 2)) {
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (ifJudge){
                                            flag = true;
                                            break here;
                                        }
                                        else if (ifPrint){
                                            canvas[x + i][y + j] = pattern;
                                        }
                                    }
                                }
                            } else {
                                if (Math.pow(params[0] - j, 2) + Math.pow(params[0] - i - 1, 2) < Math.pow(params[0], 2)) {
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (ifJudge){
                                            flag = true;
                                            break here;
                                        }
                                        else if (ifPrint){
                                            canvas[x + i][y + j] = pattern;
                                        }
                                    }
                                }
                            }
                        } else {
                            if (j < params[0]) {
                                if (Math.pow(params[0] - j - 1, 2) + Math.pow(params[0] - i, 2) < Math.pow(params[0], 2)) {
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (ifJudge){
                                            flag = true;
                                            break here;
                                        }
                                        else if (ifPrint){
                                            canvas[x + i][y + j] = pattern;
                                        }
                                    }
                                }
                            } else {
                                if (Math.pow(params[0] - j, 2) + Math.pow(params[0] - i, 2) < Math.pow(params[0], 2)) {
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (ifJudge){
                                            flag = true;
                                            break here;
                                        }
                                        else if (ifPrint){
                                            canvas[x + i][y + j] = pattern;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                ifJudge = false;
                ifPrint = true;
            }
            if (flag){
                Circle circle = new Circle(location, pattern, params[0]);
                shapes.add(circle);
            }
        }
        else {
            Direction d = null;
            switch (params[2]){
                case 0:
                    d = Direction.LEFT_UP;
                    break;
                case 1:
                    d = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d = Direction.RIGHT_UP;
                    break;
                case 3:
                    d = Direction.RIGHT_DOWN;
                    break;
            }
            boolean ifPrint = false;
            boolean ifJudge = true;
            for (int n = 1; n <= 2; n++){
                here2:
                for (int i = 0; i < params[1]; i++){
                    for (int j = 0; j < params[0]; j++){
                        switch (d){
                            case LEFT_UP:
                                if (j == 0){
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (ifJudge){
                                            flag = true;
                                            break here2;
                                        }
                                        if (ifPrint) {
                                            canvas[x + i][y + j] = pattern;
                                        }
                                    }
                                }
                                else {
                                    if (((double)(params[1] - i) / j) > ((double) params[1] / params[0])){
                                        if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                            if (ifJudge){
                                                flag = true;
                                                break here2;
                                            }
                                            if (ifPrint) {
                                                canvas[x + i][y + j] = pattern;
                                            }
                                        }
                                    }
                                }
                                break;
                            case LEFT_DOWN:
                                if (j == 0){
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (ifJudge){
                                            flag = true;
                                            break here2;
                                        }
                                        if (ifPrint) {
                                            canvas[x + i][y + j] = pattern;
                                        }
                                    }
                                }
                                else {
                                    if (((double) (i + 1) / j) >  ((double) params[1] / params[0])){
                                        if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                            if (ifJudge){
                                                flag = true;
                                                break here2;
                                            }
                                            if (ifPrint) {
                                                canvas[x + i][y + j] = pattern;
                                            }
                                        }
                                    }
                                }
                                break;
                            case RIGHT_UP:
                                if ((params[0] - 1 - j) == 0){
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (ifJudge){
                                            flag = true;
                                            break here2;
                                        }
                                        if (ifPrint) {
                                            canvas[x + i][y + j] = pattern;
                                        }
                                    }
                                }
                                else {
                                    if (((double)(params[1] - i) / (params[0] - 1 - j)) >  ((double) params[1] / params[0])){
                                        if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                            if (ifJudge){
                                                flag = true;
                                                break here2;
                                            }
                                            if (ifPrint) {
                                                canvas[x + i][y + j] = pattern;
                                            }
                                        }
                                    }
                                }
                                break;
                            case RIGHT_DOWN:
                                if ((params[0] - 1 - j) == 0){
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (ifJudge){
                                            flag = true;
                                            break here2;
                                        }
                                        if (ifPrint) {
                                            canvas[x + i][y + j] = pattern;
                                        }
                                    }
                                }
                                else {
                                    if (((double) (i + 1) / (params[0] - 1 - j)) >  ((double) params[1] / params[0])){
                                        if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                            if (ifJudge){
                                                flag = true;
                                                break here2;
                                            }
                                            if (ifPrint) {
                                                canvas[x + i][y + j] = pattern;
                                            }
                                        }
                                    }
                                }
                                break;
                        }
                    }
                }
                ifJudge = false;
                ifPrint = true;
            }
            if (flag){
                RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], d);
                shapes.add(rightTriangle);
            }
        }
        return flag;
    }

    @Override
    public int getSpaceGridCount() {
        int space = 0;
        for (char[] testRow : canvas){
            for (char test : testRow){
                if (test == ' '){
                    space++;
                }
            }
        }
        return space;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Shape[] AreaRanking = new Shape[shapes.size()];
        shapes.toArray(AreaRanking);
        Arrays.sort(AreaRanking, new Comparator<>(){
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.area() != o2.area()){
                    return o1.area() - o2.area();
                }
                else {
                    return o1.pattern - o2.pattern;
                }
            }
        });
        return Arrays.asList(AreaRanking);
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Shape[] LocationRanking = new Shape[shapes.size()];
        shapes.toArray(LocationRanking);
        Arrays.sort(LocationRanking, new Comparator<>(){
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.location.getX() != o2.location.getX()){
                    return o1.location.getX() - o2.location.getX();
                }
                else if (o1.location.getY() != o2.location.getY()){
                    return o1.location.getY() - o2.location.getY();
                }
                else {
                    return o1.pattern - o2.pattern;
                }
            }
        });
        return Arrays.asList(LocationRanking);
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
