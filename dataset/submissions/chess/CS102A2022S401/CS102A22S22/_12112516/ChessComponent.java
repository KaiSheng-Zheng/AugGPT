import jdk.dynalink.beans.StaticClass;

import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected static ChessComponent[][] chessComponents;


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

    public void setSource(ChessboardPoint chessboardPoint){
        source = chessboardPoint;
    }
    public ChessboardPoint getSource(){
        return source;
    }

    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }

    public void setName(char name){
        this.name = name;
    }
    public char getName(){
        return name;
    }

    public void setChessComponents(ChessComponent[][] chessComponents1){
        chessComponents = chessComponents1;
    }
    public ChessComponent[][] getChessComponents(){
        return chessComponents;
    }
}
