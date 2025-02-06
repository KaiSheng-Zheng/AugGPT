public enum LossBlack {
    King("K"),Queen("Q"),Rook("R"),Bishop("B"),Knights("N"),Pawns("P");
    private String name;
    LossBlack(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
