

public class RightTriangle extends Shape{
    
        private int height;
        private int width;
        private Direction direction;
    
        
        public RightTriangle(Location location, char pattern, int width, int height, Direction direction) {
            super(location, pattern);
            this.height = height;
            this.width = width;
            this.direction = direction;
            fillGrids();
        }
    
        @Override
        public void fillGrids() {

            grids = new char[height][width];

            double _height = height;
            double _width = width;
            int[] border = new int[width]; 
            char[][] template = new char[height][width];

                for (int i = 0; i < width; i++) {
                    double temp = _height / _width * i;
                    border[i] = (int)Math.floor(temp);
                }

            for (int j = 0; j < width; j++) {
                for (int i = 0; i < height; i++) {
                    if (i >= border[j]) {
                        template[i][j] = pattern;
                    } else {
                        template[i][j] = ' ';
                    }
                }
            }
            switch (direction) {
                case LEFT_DOWN:
                    grids = template;
                    break;

                case LEFT_UP:
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            grids[height - i - 1][j] = template[i][j];
                        }
                    }
                    break;

                case RIGHT_DOWN:
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            grids[i][width - j - 1] = template[i][j];
                        }
                    }
                    break;
                
                case RIGHT_UP:
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            grids[height - i - 1][width - j - 1] = template[i][j];
                        }
                    }
                    break;
            
                default:
                    break;
            }
        }
    
        @Override
        public void enlarge() {
            height++;
            width++;
            fillGrids();
        }
    
        @Override
        public void shrink() {
            height--;
            width--;
            fillGrids();
        }
    
        @Override
        public int area() {
            int area = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grids[i][j] == pattern) {
                        area++;
                    }
                }
            }
            return area;
        }

        @Override
        public String toString() {
            return "RightTriangle: " + location.toString() + " area=" + area() + " pattern=" + pattern;
        }

}
