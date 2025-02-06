import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    // I defined
    protected ChessComponent [][] chessboard;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessColor color,Character name,ChessboardPoint source) {
        chessColor = color;
        this.name = name;
        this.source = source;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public char getName() {return name;}

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
//    @Override
//    public int compareTo(ChessComponent o) {
//        if(getSource().getX()>o.getSource().getX()){
//            return 1;
//        }else if (getSource().getX()==o.getSource().getX()){
//            if (getSource().getY()>o.getSource().getY()){
//                return 1;
//            }else if(getSource().getY()<o.getSource().getY()){
//                return -1;
//            }else {return 0;}
//        }else {return -1;}
//
//    }

}
