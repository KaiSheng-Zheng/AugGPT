import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    protected char[][] grids;
    private int a;

    private int x;

    private int y;
    private char pattern;

    private int width;
    private int height;
    private  Direction d;



    private char[][] canves;

    public OverLapShapeCanvas(int rows, int cols){

        this.canves=new char[rows][cols];
        for (int i = 0; i <cols; i++) {
            for (int j = 0; j <rows ; j++) {
                canves[j][i]=' ';
            }

        }
        this.a=0;
        this.pattern=' ';
        this.x=0;
        this.y=0;
        this.width = 0;
        this.height = 0;
        this.shapes= new ArrayList<>();



    }

    public void addcircle() {
        grids = new char[2 *a  ][2 * a ];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if ((a - i-1) * (a - i-1) + (a - j-1) * (a - j-1) < (a ) * (a))
                    if (i+x>=0&&i+x<canves.length)

                        if (j+y>=0&&j+y<canves[0].length)
                            canves[i+x][j+y] =pattern;
            }
        }

        for (int i = a; i < 2 * a; i++) {
            for (int j = 0; j < a; j++) {
                if (( i-a) * ( i-a) + (a-1 - j) * (a-1 - j) < (a ) * (a ))
                    if (i+x>=0&&i+x<canves.length)
                        if (j+y>=0&&j+y<canves[0].length)
                            canves[i+x][j+y] =pattern;

            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = a; j <2*a ; j++) {
                if((a-i-1)*(a-i-1)+( j-a) * ( j-a)<(a)*(a))
                    if (i+x>=0&&i+x<canves.length)
                        if (j+y>=0&&j+y<canves[0].length)
                            canves[i+x][j+y] =pattern;
            }
        }

        for (int i = a; i < 2*a; i++) {
            for (int j = a; j <2*a ; j++) {
                if(( i-a) * ( i-a)+( j-a) * ( j-a)<(a)*(a))
                    if (i+x>=0&&i+x<canves.length)
                        if (j+y>=0&&j+y<canves[0].length)
                            canves[i+x][j+y] =pattern;
            }
        }

    }

    public boolean ifaddcircle() {
        grids = new char[2 *a  ][2 * a ];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if ((a - i-1) * (a - i-1) + (a - j-1) * (a - j-1) < (a ) * (a))
                    if (i+x>=0&&i+x<canves.length)
                        if (j+y>=0&&j+y<canves[0].length)
                            return true;

            }
        }

        for (int i = a; i < 2 * a; i++) {
            for (int j = 0; j < a; j++) {
                if (( i-a) * ( i-a) + (a-1 - j) * (a-1 - j) < (a ) * (a ))
                    if (i+x>=0&&i+x<canves.length)
                        if (j+y>=0&&j+y<canves[0].length)
                            return true;

            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = a; j <2*a ; j++) {
                if((a-i-1)*(a-i-1)+( j-a) * ( j-a)<(a)*(a))
                    if (i+x>=0&&i+x<canves.length)
                        if (j+y>=0&&j+y<canves[0].length)
                            return true;
            }
        }

        for (int i = a; i < 2*a; i++) {
            for (int j = a; j <2*a ; j++) {
                if(( i-a) * ( i-a)+( j-a) * ( j-a)<(a)*(a))
                    if (i+x>=0&&i+x<canves.length)
                        if (j+y>=0&&j+y<canves[0].length)
                            return true;
            }
        }
        return false;
    }

    public void addTriangle() {
        grids=new char[height][width];

        switch (d){
            case RIGHT_DOWN:
                for (int i = 0; i <height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if ((height-1-i)*width+(width-j-1)*height <height*width)
                            if (i+x>=0&&i+x<canves.length)
                                if (j+y>=0&&j+y<canves[0].length)
                                    canves[i+x][j+y] =pattern;

                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 0; i <height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if ((height-1-i)*width+j*height <height*width)
                            if (i+x>=0&&i+x<canves.length)
                                if (j+y>=0&&j+y<canves[0].length)
                                    canves[i+x][j+y] =pattern;

                    }
                }


                break;
            case RIGHT_UP:
                for (int i = 0; i <height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if (i*width+(width-j-1)*height <height*width)
                            if (i+x>=0&&i+x<canves.length)
                                if (j+y>=0&&j+y<canves[0].length)
                                    canves[i+x][j+y] =pattern;

                    }
                }

                break;
            case LEFT_UP:
                for (int i = 0; i <height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if (i*width+j*height <height*width)
                            if (i+x>=0&&i+x<canves.length)
                                if (j+y>=0&&j+y<canves[0].length)
                                    canves[i+x][j+y] =pattern;

                    }
                }


                break;
        }

    }

    public boolean ifaddTriangle() {
        grids=new char[height][width];
        switch (d){
            case RIGHT_DOWN:
                for (int i = 0; i <height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if ((height-1-i)*width+(width-j-1)*height <height*width)
                            if (i+x>=0&&i+x<canves.length)
                                if (j+y>=0&&j+y<canves[0].length)
                                    return true;

                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 0; i <height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if ((height-1-i)*width+j*height <height*width)
                            if (i+x>=0&&i+x<canves.length)
                                if (j+y>=0&&j+y<canves[0].length)
                                    return true;

                    }
                }


                break;
            case RIGHT_UP:
                for (int i = 0; i <height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if (i*width+(width-j-1)*height <height*width)
                            if (i+x>=0&&i+x<canves.length)
                                if (j+y>=0&&j+y<canves[0].length)
                                    return true;

                    }
                }

                break;
            case LEFT_UP:
                for (int i = 0; i <height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        if (i*width+j*height <height*width)
                            if (i+x>=0&&i+x<canves.length)
                                if (j+y>=0&&j+y<canves[0].length)
                                    return true;

                    }
                }


                break;
        }
        return false;
    }



    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

        if (params.length == 1) {
            this.a=params[0];
            this.pattern=pattern;
            this.x=x;
            this.y=y;

            if (this.ifaddcircle()){
                this.addcircle();
                Location p1 = new Location(x, y);
                Shape s1 = new Circle(p1, pattern, params[0]);
                shapes.add(s1);
                return true;
            }
            else
                return false;


        }

        if (params.length == 3) {
            this.a=params[0];
            this.pattern=pattern;
            this.x=x;
            this.y=y;
            this.width = params[0];
            this.height = params[1];
            if ((params[2]==0))
                this.d = Direction.LEFT_UP;
            if ((params[2]==1))
                this.d = Direction.LEFT_DOWN;
            if ((params[2]==2))
                this.d = Direction.RIGHT_UP;
            if ((params[2]==3))
                this.d = Direction.RIGHT_DOWN;
            if (this.ifaddTriangle()){
                this.addTriangle();
                Location p1 = new Location(x, y);
                Shape s1 = new RightTriangle(p1, pattern, width, height,d);
                shapes.add(s1);
                return true;
            }
            else
                return false;


        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        // incomplete implementation
        return canves.length*canves[0].length;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }





    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++){
                if ( shapes.get(i).area > shapes.get(j).area) {
                    Shape mid = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,mid);

                }

            }
        }
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++){
                if ( shapes.get(i).area == shapes.get(j).area) {
                    int a1 = shapes.get(i).pattern;
                    int a2 = shapes.get(j).pattern;
                    if (a1>a2) {


                        Shape mid = shapes.get(i);
                        shapes.set(i, shapes.get(j));
                        shapes.set(j, mid);
                    }

                }
            }
        }

        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++){
                if ( shapes.get(i).location.getX() > shapes.get(j).location.getX()) {
                    Shape mid = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,mid);

                }

            }
        }

        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++){
                if ( shapes.get(i).location.getX() == shapes.get(j).location.getX()) {
                    if ( shapes.get(i).location.getY() > shapes.get(j).location.getY()) {


                        Shape mid = shapes.get(i);
                        shapes.set(i,shapes.get(j));
                        shapes.set(j,mid);}

                }

            }
        }

        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++){
                if ( shapes.get(i).location.getX() == shapes.get(j).location.getX()) {
                    if ( shapes.get(i).location.getY() == shapes.get(j).location.getY()) {
                        int a1 = shapes.get(i).pattern;
                        int a2 = shapes.get(j).pattern;
                        if (a1>a2) {


                            Shape mid = shapes.get(i);
                            shapes.set(i, shapes.get(j));
                            shapes.set(j, mid);
                        }
                    }

                }

            }
        }

        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return  canves;
    }
}

