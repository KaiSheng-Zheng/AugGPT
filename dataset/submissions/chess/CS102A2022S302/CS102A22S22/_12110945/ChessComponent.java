import java.util.List;
public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] getTarget() {
        return target;
    }

    private ChessComponent[][] target;

    //public void setTarget() {

    //}

    //should design
    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] target){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.target=target;


    }

    //add setter and getter for three for second version
    public ChessboardPoint getSource() {
        return source;
    }
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
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
    // second



    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
        //return null;
    }

}
