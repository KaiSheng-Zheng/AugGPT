import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(){}
    public ChessComponent(char name){
        this.name = name;
        if (Character.isUpperCase(name)){
            this.chessColor = ChessColor.BLACK;
        }else if (Character.isLowerCase(name)){
            this.chessColor = ChessColor.WHITE;
        }else {
            this.chessColor = ChessColor.NONE;
        }
    }
    public ChessComponent(char name,ChessboardPoint source){
        this.name = name;
        if (Character.isUpperCase(name)){
            this.chessColor = ChessColor.BLACK;
        }else if (Character.isLowerCase(name)){
            this.chessColor = ChessColor.WHITE;
        }else {
            this.chessColor = ChessColor.NONE;
        }
        this.source = source;
    }

    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    //get the situation on chessboard

    public ChessComponent[][] getChessBoard(){
        return ConcreteChessGame.getChessComponents();
    }

}
