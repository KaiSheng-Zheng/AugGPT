public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
    }

    @Override
    public int getArea() {
        return (int) (Math.PI * radius * radius);
    }


    @Override
    public char[][] draw() {
        int diameter = radius * 2 + 1;
        char[][] canvas = new char[diameter][diameter];
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                if (Math.pow(i - radius, 2) + Math.pow(j - radius, 2) <= Math.pow(radius, 2)) {
                    canvas[i][j] = pattern;
                } else {
                    canvas[i][j] = ' ';
                }
            }
        }
        return canvas;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" radius=%d", radius);
    }
}
