import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessBoard;

    public void setChessBoard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }
    //should design
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name = name;
    };
    public ChessComponent(){}


    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessColor getChessColor(char name) {
        if (name > 'a' && name < 'z'){
            return ChessColor.WHITE;
        }else if (name > 'A' && name < 'Z'){
            return ChessColor.BLACK;
        }else {
         return ChessColor.NONE;
        }
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
