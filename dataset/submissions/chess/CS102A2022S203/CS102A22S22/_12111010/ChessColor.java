public enum ChessColor {
    BLACK, WHITE, NONE;

    public ChessColor oppositePlayer(){
        if (this == BLACK)
            return WHITE;
        if (this == WHITE)
            return BLACK;
        return NONE;
    }
}
