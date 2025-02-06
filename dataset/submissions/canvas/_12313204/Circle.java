public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
        grids = new char[radius*2][radius*2];
        fillGridsWithSpace();
        fillGrids();
    }
    public void fillGrids(){
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                double l1 = Math.pow(radius-i,2)+Math.pow(radius-j,2);
                double l2 = Math.pow(radius-i-1,2)+Math.pow(radius-j-1,2);
                double l3 = Math.pow(radius-i-1,2)+Math.pow(radius-j,2);
                double l4 = Math.pow(radius-i,2)+Math.pow(radius-j-1,2);
                if(l1<radius*radius||l2<radius*radius||l3<radius*radius||l4<radius*radius){
                    grids[i][j] = pattern;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius = radius +1;
        grids = new char[radius*2][radius*2];
        fillGridsWithSpace();
        fillGrids();
    }

    @Override
    public void shrink() {
        radius = radius -1;
        grids = new char[radius*2][radius*2];
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

    @Override
    public char[][] ConflictShapeCanvasCheck(char[][] canvas) {
        char[][] tempCanvas = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < tempCanvas.length; i++) {
            for (int j = 0; j < tempCanvas.length; j++) {
                tempCanvas[i][j] = canvas[i][j];
            }
        }
        if(location.getX()<0||location.getY()<0||location.getX()+radius>tempCanvas.length||location.getY()+radius>tempCanvas[0].length){
            return null;
        }
        boolean returnKey = true;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if(grids[i][j]!=' '){
                    if(tempCanvas[location.getX()+i][location.getY()+j]!=' '){
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
        String str = "Circle: "+location.toString()+" area="+area()+" pattern="+pattern;
        return str;
    }
}
