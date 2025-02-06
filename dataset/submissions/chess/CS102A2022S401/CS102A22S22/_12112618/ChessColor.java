public enum ChessColor {
    BLACK,WHITE,NONE;

    public ChessColor changeTurn(){
        if(this == BLACK){
            return WHITE;
        }else {
            return BLACK;
        }
    }
}
