public abstract class Shape{
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Location getLocation() {
        return location;
    }

    public char[][] getGrids() {
        return grids;
    }

    public Shape( Location location,char pattern) {
        this.pattern = pattern;
        this.location = location;
    }

    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public abstract char getPattern();
    public int count(){
        int num=0;
        for (int i = 0; i <grids.length; i++) {
            for (int j = 0; j <grids[i].length; j++) {
                if (grids[i][j]==pattern){
                    num=num+1;
                }
            }
        }
        return num;
    }

    @Override
    public abstract String toString();
}

