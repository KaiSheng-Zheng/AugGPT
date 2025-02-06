public enum ChessColor {
    BLACK, WHITE, NONE;

    public ChessColor reverse() {
        if (this == BLACK)
            return WHITE;
        else
            return BLACK;
    }
}
