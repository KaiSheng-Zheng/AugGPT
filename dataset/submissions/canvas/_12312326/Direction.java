public enum Direction {
    LEFT_UP ("***\n**\n*"),
    LEFT_DOWN ("*\n**\n***"),
    RIGHT_UP ("***\n **\n  *"),
    RIGHT_DOWN ("  *\n **\n***");
    private final String s;
    private  Direction(String s) {
        this.s = s;
    }
    public String getS() {
        return s;
    }
}
