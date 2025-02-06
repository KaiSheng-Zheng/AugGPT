public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location,char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        grids = new char[height][width];
        fillGridsWithSpace();
        fillGrids();
    }
    public double[] Line(int[] point1, int[] point2){
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];
        double k = ((double)y1-y2)/(x1-x2);
        double b = y1 - k*x1;
        double[] line = {k,b};
        return line;
    }

    @Override
    public void fillGrids() {
        if(d.equals(Direction.LEFT_DOWN)){
            int[] point01 = {0,0};
            int[] point02 = {height,width};
            double[] line = Line(point01,point02);
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if(i*line[0]+line[1]>j){
                        grids[i][j] = pattern;
                    } else if ((i+1)*line[0]+line[1]>j) {
                        grids[i][j] = pattern;
                    } else if (i*line[0]+line[1]>j+1) {
                        grids[i][j] = pattern;
                    } else if ((i+1)*line[0]+line[1]>j+1) {
                        grids[i][j] = pattern;
                    }
                }
            }
        }
        if(d.equals(Direction.LEFT_UP)){
            int[] point01 = {0,width};
            int[] point02 = {height,0};
            double[] line = Line(point01,point02);
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if(i*line[0]+line[1]>j){
                        grids[i][j] = pattern;
                    } else if ((i+1)*line[0]+line[1]>j) {
                        grids[i][j] = pattern;
                    } else if (i*line[0]+line[1]>j+1) {
                        grids[i][j] = pattern;
                    } else if ((i+1)*line[0]+line[1]>j+1) {
                        grids[i][j] = pattern;
                    }
                }
            }
        }
        if(d.equals(Direction.RIGHT_UP)){
            int[] point01 = {0,0};
            int[] point02 = {height,width};
            double[] line = Line(point01,point02);
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if(i*line[0]+line[1]<j){
                        grids[i][j] = pattern;
                    } else if ((i+1)*line[0]+line[1]<j) {
                        grids[i][j] = pattern;
                    } else if (i*line[0]+line[1]<j+1) {
                        grids[i][j] = pattern;
                    } else if ((i+1)*line[0]+line[1]<j+1) {
                        grids[i][j] = pattern;
                    }
                }
            }
        }
        if(d.equals(Direction.RIGHT_DOWN)){
            int[] point01 = {0,width};
            int[] point02 = {height,0};
            double[] line = Line(point01,point02);
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if(i*line[0]+line[1]<j){
                        grids[i][j] = pattern;
                    } else if ((i+1)*line[0]+line[1]<j) {
                        grids[i][j] = pattern;
                    } else if (i*line[0]+line[1]<j+1) {
                        grids[i][j] = pattern;
                    } else if ((i+1)*line[0]+line[1]<j+1) {
                        grids[i][j] = pattern;
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        grids = new char[height][width];
        fillGridsWithSpace();
        fillGrids();
    }
    public void shrink(){
        height--;
        width--;
        grids = new char[height][width];
        fillGridsWithSpace();
        fillGrids();
    }
    public int area(){
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if(grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public char[][] ConflictShapeCanvasCheck(char[][] canvas) {
        char[][] tempCanvas = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < tempCanvas.length; i++) {
            for (int j = 0; j < tempCanvas[i].length; j++) {
                tempCanvas[i][j] = canvas[i][j];
            }
        }
        if(location.getX()<0||location.getY()<0||location.getX()+grids.length>canvas.length||location.getY()+grids[0].length>canvas[0].length){
            return null;
        }
        boolean returnKey = true;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if(grids[i][j]!=' '){
                    if(tempCanvas[location.getX()+i][location.getY()+j]!=' '&&tempCanvas[location.getX()+i][location.getY()+j]!='\0'){
                        returnKey = false;
                    } else {
                        tempCanvas[location.getX()+i][location.getY()+j] = pattern;
                    }
                }
            }
        }
        if(!returnKey){
            return null;
        } else {
            return tempCanvas;
        }
    }

    public String toString(){
        String str = "RightTriangle: "+location.toString()+" area="+area()+" pattern="+pattern;
        return str;
    }

    @Override
    public char[][] RePaint(char[][] canvas) {
        boolean keyOfPaint = false; 
        char[][] tempCanvas = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < tempCanvas.length; i++) {
            for (int j = 0; j < tempCanvas[i].length; j++) {
                tempCanvas[i][j] = canvas[i][j];
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                try{
                    if(grids[i][j]!=' '){
                        tempCanvas[location.getX()+i][location.getY()+j] = pattern;
                        keyOfPaint = true;
                    }
                }catch (ArrayIndexOutOfBoundsException e ){
                    continue;
                }
            }
        }
        if(keyOfPaint){
            return tempCanvas;
        } else{
            return null;
        }
    }
}
