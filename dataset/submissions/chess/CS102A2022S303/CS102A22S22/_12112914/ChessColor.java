public enum ChessColor {
    BLACK, WHITE, NONE;
    public ChessColor gatInverseColor(ChessColor color){
        if (color.equals(BLACK)){
            return WHITE;
        }else {return BLACK;}
    }


}
