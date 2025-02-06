public enum Direction {
    LEFT_UP("***\n" +
            "** \n" +
            "*  "),
    LEFT_DOWN("*  \n" +
            "** \n" +
            "***"),
    RIGHT_UP("***\n" +
            " **\n" +
            "  *"),
    RIGHT_DOWN("  *\n" +
            " **\n" +
            "***");
    private final String direction;
    Direction(String direction) {
        this.direction=direction;
    }
}