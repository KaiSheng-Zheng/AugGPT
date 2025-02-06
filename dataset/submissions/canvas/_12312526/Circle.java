import java.util.Comparator;

public class Circle extends Shape {
    public int getRadius() {
        return radius;
    }

    private int radius; // height and width of grid are 2 times radius
    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
        this.fillGrids();
    }
    @Override
    public void fillGrids(){
        int diameter = radius *2;
        grids = new char[diameter][diameter];
        for (int i = 0; i < diameter; i++){
            for (int j = 0; j < diameter; j++) {
                int rowCoordinate = i + 1;
                int colCoordinate = j + 1;

                if (rowCoordinate <= radius && colCoordinate <= radius){
                    if (calculateDistance(rowCoordinate, colCoordinate, radius) < radius){
                        grids[i][j] = pattern;

                    }
                    else{
                        grids[i][j] = ' ';
                    }
                }
                else if (rowCoordinate <= radius){
                    if (calculateDistance(rowCoordinate, 2*radius - colCoordinate+1, radius) < radius){
                        grids[i][j] = pattern;
                    }
                    else{
                        grids[i][j] = ' ';
                    }
                }

                else if (colCoordinate <= radius){
                    if (calculateDistance(2*radius - rowCoordinate+1, colCoordinate, radius) < radius){
                        grids[i][j] = pattern;
                    }
                    else{
                        grids[i][j] = ' ';
                    }
                }

                else {
                    if (calculateDistance(2*radius - rowCoordinate+1, 2*radius -colCoordinate+1, radius) < radius){
                        grids[i][j] = pattern;
                    }
                    else{
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }

    @Override
    public void enlarge(){
        radius++;
        fillGrids();
    }

    @Override
    public void shrink(){
        radius--;
        fillGrids();
    }

    @Override
    public int area(){
        int count = 0;
        int diameter = radius *2;

        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                if (grids[i][j] == pattern){
                    count++;
                }
            }
        }

        return count;
    }


    // calculaet distance from center
    private int calculateDistance(int rowCoordinate, int colCoordinate, int radius){
        return (int) Math.sqrt(Math.pow((radius-rowCoordinate), 2) + Math.pow((radius-colCoordinate), 2) );
    }



    @Override
    public String toString(){
        return String.format("%s: (%d,%d) area=%d pattern=%c", "Circle", location.getX(), location.getY(), area(), pattern);
    }


}
