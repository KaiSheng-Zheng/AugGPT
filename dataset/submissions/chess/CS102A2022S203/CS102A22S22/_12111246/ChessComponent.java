import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public static void setChessboard(ChessComponent[][] chessboard1) {
        chessboard = chessboard1;
    }
    public static ChessComponent[][] getChessboard() {
        return chessboard;
    }


  static ChessComponent[][] chessboard;



    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    //should design


    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }



    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }



    //should design
    public ChessComponent(){

      this.chessboard=chessboard;
    
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

}

