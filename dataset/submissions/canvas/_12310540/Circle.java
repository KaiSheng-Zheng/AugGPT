public class Circle extends Shape {

    private int radius;
    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.grids = new char[radius * 2][radius * 2];
        fillGrids();
    }



    public void fillGrids(){
        grids = new char[radius*2][radius*2];
        for(int i = 0; i < radius*2; i++){
            if(i<radius){
                for(int j = 0; j < radius*2; j++){
                    if(j<radius){
                        double distance = Math.sqrt(Math.pow(i+1-radius,2) + Math.pow(j+1-radius, 2));
                        if(distance < radius){
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j] = ' ';
                        }
                    }
                    if(j>=radius){
                        double distance = Math.sqrt(Math.pow(i+1-radius,2) + Math.pow(j-radius, 2));
                        if(distance < radius){
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j] = ' ';
                        }
                    }
                }
            }
            if(i>=radius){
                for(int j = 0; j < radius*2; j++){
                    if(j<radius){
                        double distance = Math.sqrt(Math.pow(i-radius, 2) + Math.pow(j+1-radius, 2));
                        if(distance < radius){
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j] = ' ';
                        }
                    }
                    if(j>=radius){
                        double distance = Math.sqrt(Math.pow(i-radius, 2) + Math.pow(j-radius, 2));
                        if(distance < radius){
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j] = ' ';
                        }
                    }
                }
            }
        }
    }

    public void enlarge(){
        radius += 1;
        fillGrids();
    }

    public void shrink(){
        radius -= 1;
        fillGrids();
    }
    public int area(){
        int count = 0;
        for(int i = 0; i < grids.length; i++){
            for(int j = 0; j < grids[i].length; j++){
                if(grids[i][j] == pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){
        return "Circle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }



}



