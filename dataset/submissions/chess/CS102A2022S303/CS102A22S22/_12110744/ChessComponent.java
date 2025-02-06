import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;//where the chess is
    private ChessColor chessColor;//black white none
    protected char name;//r n B Q

    //should design
    public ChessComponent(){}

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
//t4!!!
    public ChessboardPoint getSource() {
        return source;
    }//t4!!!



    public ChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
    }
    public ChessComponent(char name){}

}
