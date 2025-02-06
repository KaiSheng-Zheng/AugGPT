public enum LossWhite {
    King("k"),Queen("q"),Rook("r"),Bishop("b"),Knights("n"),Pawns("p");
    private String name;
    LossWhite(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
