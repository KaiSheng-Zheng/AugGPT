public enum Direction {
    LEFT("1"),
    RIGHT("2"),
    UP("3"),
    DOWN("4");

    private final String d;

    Direction(String t){
        d=t;
    }

    public int Getv(){
        return Integer.parseInt(d);
    }

}
