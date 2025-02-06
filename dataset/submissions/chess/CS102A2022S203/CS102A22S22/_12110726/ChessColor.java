public enum ChessColor {   BLACK, WHITE, NONE;
    public ChessColor exchangecolor(){
        if (this == BLACK)
            return WHITE;
        if (this == WHITE)
            return BLACK;
        return NONE;
    }}

