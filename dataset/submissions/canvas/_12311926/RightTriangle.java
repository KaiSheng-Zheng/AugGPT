    public class RightTriangle extends Shape {
        private int width;
        private int height;
        private final Direction d;

        public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
            super(location, pattern);
            this.width = width;
            this.height = height;
            this.d = d;
            grids=new char[height][width];
            fillGrids();
        }
        public void  fillGrids(){
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    grids[i][j]='\u0020';}
            }
            if(d== Direction.LEFT_DOWN){
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[i].length; j++) {
                      if((double)(i+1)/j>(double)height/width) {
                          grids[i][j]=pattern;
                      }
                    }
                }
            }
            if(d== Direction.LEFT_UP){
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[i].length; j++) {
                        if((double)i/(width-j)<(double)height/width) {
                            grids[i][j]=pattern;
                        }
                    }
                }
            }
            if(d== Direction.RIGHT_UP){
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[i].length; j++) {
                        if(((double)i/(j+1))<((double) height/width)) {
                            grids[i][j]=pattern;
                        }
                    }
                }
            }
            if(d== Direction.RIGHT_DOWN){
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[i].length; j++) {
                        if((double)(height-(i+1))/(j+1)<(double)height/width) {
                            grids[i][j]=pattern;
                        }
                    }
                }
            }
        }
        public void enlarge(){
            this.height++;
            this.width++;
            grids=new char[height][width];
            fillGrids();
        }
        public void shrink(){
            this.height--;
            this.width--;
            grids=new char[height][width];
            fillGrids();
        }
        public int area(){
            int sum=0;
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if (grids[i][j]==pattern) {
                        sum++;
                    }
                }
            }
            return sum;
        }

        @Override
        public char getPattern() {
            return pattern;
        }

        @Override
        public Location getLocation() {
            return location;
        }

        //RightTriangle: (0,1) area=12 pattern=X
        public String toString(){
            return "RightTriangle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
        }
        @Override
        public int getX() {
            return location.getX();
        }

        @Override
        public int getY() {
            return location.getY();
        }
    }
