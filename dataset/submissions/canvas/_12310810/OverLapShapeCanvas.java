import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    public int rowaaa;
    public int colaaa;
    public int count;
    public int spaceCount=0;
    public OverLapShapeCanvas(int rows,int cols){
        rowaaa=rows;colaaa=cols;
        canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int i1 = 0; i1 < cols; i1++) {
                canvas[i][i1]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean flag = false;
        Location l = new Location(x, y);

        if (params.length == 1) {
            Circle c = new Circle(l, pattern, params[0]);
            int radius = params[0];
            int bian = radius * 2;
            for (int i = x; i < x + bian; i++) {
                for (int i1 = y; i1 < y + bian; i1++) {
                    double distance1 = Math.pow(i - radius - x, 2) + Math.pow(i1 - radius - y, 2);
                    double distance2 = Math.pow(i + 1 - radius - x, 2) + Math.pow(i1 + 1 - radius - y, 2);
                    double distance3 = Math.pow(i + 1 - radius - x, 2) + Math.pow(i1 - radius - y, 2);
                    double distance4 = Math.pow(i - radius - x, 2) + Math.pow(i1 + 1 - radius - y, 2);
                    double distance = Math.min(distance4, Math.min(distance3, Math.min(distance1, distance2)));
                    if (distance < radius * radius) {
                        if (i >= rowaaa || i1 >= colaaa) {
                            spaceCount++;
                            c.area++;
                            continue;
                        }
                        spaceCount++;
                        c.area++;
                        canvas[i][i1] = pattern;
                        flag = true;
                    }
                }
            }
            if (flag) {
                shapes.add(c);
                count++;
            }

            return flag;
        } else if (params.length == 3) {
            Direction d = Direction.RIGHT_DOWN;
            if (params[2] == 0) {
                d = Direction.LEFT_UP;
            } else if (params[2] == 1) {
                d = Direction.LEFT_DOWN;
            } else if (params[2] == 2) {
                d = Direction.RIGHT_UP;
            }
            double width = params[0];
            double height = params[1];
            RightTriangle r = new RightTriangle(l, pattern, (int) width, (int) height, d);

            double slope = height / width;
            if (params[2] == 0) {
                for (int i = x; i < x + height; i++) {
                    for (int i1 = y + 1; i1 < y + width; i1++) {
                        double slopex = (i - x) * 1.0 / (i1 - y);
                        if (slopex < slope) {
                            if (i >= rowaaa ||  (2 * y + width - i1)>= colaaa) {
                                spaceCount++;
                                r.area++;
                                continue;
                            }
                                spaceCount++;
                                r.area++;
                            canvas[i][(int) (2 * y + width - i1)] = pattern;
                        }
                    }
                    if (i >= rowaaa) {
                        spaceCount++;
                        r.area++;
                        continue;
                    }
                        r.area++;
                        spaceCount++;
                    canvas[i][y] = pattern;
                    flag = true;

                }
                if (flag) {
                    shapes.add(r);
                    count++;
                }
                return flag;
            } else if (params[2] == 1) {
                for (int i = x; i < x + height; i++) {
                    for (int i1 = 1 + y; i1 < y + width; i1++) {
                        double slopex = (i + 1 - x) * 1.0 / (i1 - y);
                        if (slopex > slope) {
                            if(i>=rowaaa||i1>=colaaa){
                                spaceCount++;
                                r.area++;continue;
                            }
                                spaceCount++;
                                r.area++;
                            canvas[i][i1] = pattern;
                        }
                    }
                    if(i>=rowaaa){
                        r.area++;
                        continue;
                    }
                        r.area++;
                        canvas[i][y] = pattern;
                        flag = true;
                }

                if (flag) {
                    shapes.add(r);
                    count++;
                }
                return flag;
            } else if (params[2] == 2) {
                for (int i = x; i < x + height; i++) {
                    for (int i1 = y; i1 < y + width - 1; i1++) {
                        double slopex = (i - x) * 1.0 / (i1 - y + 1);

                        if (slopex < slope) {
                            if (i >= rowaaa || i1 >= colaaa) {
                                r.area++;
                                continue;
                            }
                                spaceCount++;
                                r.area++;
                            canvas[i][i1] = pattern;
                            flag = true;
                        }
                    }
                    if (i >= rowaaa || (y + width - 1) >= colaaa) {
                        spaceCount++;
                        r.area++;
                        continue;
                    }
                        spaceCount++;
                        r.area++;
                    canvas[i][(int) (y + width - 1)] = pattern;
                    flag = true;

                }
                if (flag) {
                    shapes.add(r);
                    count++;
                }
                return flag;
            } else {
                for (int i = x; i < x + height; i++) {
                    for (int i1 = y; i1 < y + width - 1; i1++) {
                        double slopex = (i - x + 1) * 1.0 / (y + width - i1 - 1);
                        if (slopex > slope) {
                            if (i1 >= colaaa || i >= rowaaa) {
                                spaceCount++;
                                r.area++;
                                continue;
                            }
                            spaceCount++;
                            r.area++;
                            canvas[i][i1] = pattern;
                        }
                    }
                    if (i >= rowaaa || (y + width - 1) >= colaaa) {
                        spaceCount++;
                        r.area++;
                        continue;
                    }
                    canvas[i][(int) (y + width - 1)] = pattern;
                    flag = true;
                    spaceCount++;
                    r.area++;
                }
                if (flag) {
                    shapes.add(r);
                    count++;
                }
                return flag;
            }

        }return flag;
    }






    @Override
    public int getSpaceGridCount() {
        return spaceCount;
    }

    @Override
    public int getShapeCount() {
        return count;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(shapes.get(i).area);
        }
        for (int k=0;k<shapes.size();k++) {
            for (int i = 0; i < shapes.size()-1; i++) {
                if(shapes.get(i).area>shapes.get(i+1).area){
                    Shape temp=shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp);
                }else if(shapes.get(i).area==shapes.get(i+1).area){
                    if(shapes.get(i).pattern>shapes.get(i+1).pattern){
                        Shape temp=shapes.get(i);
                        shapes.set(i,shapes.get(i+1));
                        shapes.set(i+1,temp);
                    }
                }
            }}
        return shapes;}

    @Override
    public List<Shape> getShapesByLocation() {
        for (int k=0;k<shapes.size();k++) {
            for (int i = 0; i < shapes.size()-1; i++) {
                if(shapes.get(i).location.getX()>shapes.get(i+1).location.getX()){
                    Shape temp=shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp);
                }else if(shapes.get(i).location.getX()==shapes.get(i+1).location.getX()){
                    if(shapes.get(i).location.getY()>shapes.get(i+1).location.getY()){
                        Shape temp=shapes.get(i);
                        shapes.set(i,shapes.get(i+1));
                        shapes.set(i+1,temp);}else if(shapes.get(i).location.getY()==shapes.get(i+1).location.getY()){
                        if(shapes.get(i).pattern>shapes.get(i+1).pattern){
                            Shape temp=shapes.get(i);
                            shapes.set(i,shapes.get(i+1));
                            shapes.set(i+1,temp);
                        }
                    }}
            }}
        return shapes;}


    @Override
    public char[][] getCanvas() {

        return canvas;
    }

}
