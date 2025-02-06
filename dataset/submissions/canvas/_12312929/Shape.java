public abstract class Shape {
        protected char[][] grids;
        protected char pattern;
        protected Location location;
        public Shape(Location location,char pattern){
            this.location = location;
            this.pattern = pattern;
        };


        public char[][] getGrids(){
            return grids;
        };
        public abstract void fillGrids();
        public abstract void enlarge();
        public abstract void shrink();
        public abstract int area();

        public String toString() {
            return String.format("%s: (%d,%d) area=%d pattern=%c", this.getClass().getSimpleName(), location.getX(), location.getY(), area(), pattern);
        }

    public char getPattern() {
        return pattern;
    }

    public Location getLocation() {
        return location;
    }
        public int getWidth(){
            return grids[0].length;
        }
        public int getHeight(){
            return grids.length;
        }
}