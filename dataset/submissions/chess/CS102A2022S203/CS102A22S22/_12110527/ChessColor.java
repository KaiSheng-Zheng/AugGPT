public enum ChessColor {
    BLACK("B"), WHITE("W"), NONE("N");
    private String name;
    private ChessColor(String a){
        name = a;
    }

    public String toString(){
        return name;
    }
}
