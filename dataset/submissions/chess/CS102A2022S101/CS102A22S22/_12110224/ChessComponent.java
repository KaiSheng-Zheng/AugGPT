import java.util.List;

public abstract class ChessComponent {
    protected ChessboardPoint source;
    protected ChessColor chessColor = ChessColor.NONE;
    protected char name;

    //should design
    public ChessColor getChessColor() {
        return chessColor;
    }

    public boolean validMove(ChessboardPoint destination){
        if(destination.getX()<8&&destination.getX()>=0&&destination.getY()<8&&destination.getY()>=0&&destination.getX()!=source.getX()&&destination.getY()!=source.getY())
            return true;
        else
            return false;

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
