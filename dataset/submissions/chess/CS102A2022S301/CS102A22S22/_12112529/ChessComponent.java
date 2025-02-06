import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(char X,ChessboardPoint point){
        this.name = X;
        if(Character.isLowerCase(X)){
            this.chessColor = ChessColor.WHITE;
        }
        else if (Character.isUpperCase(X)){
            this.chessColor = ChessColor.BLACK;
        }
        else {
            this.chessColor = ChessColor.NONE;
        }
        this.source = point;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

//    /**
//     * should design
//     * @return
//     */
//    @Override
//    public String toString() {
//        return null;
//    }
    public String toString(){
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    public char getName(){
        return name;
    }
    public ChessboardPoint getSource() {
        return source;
    }

}
