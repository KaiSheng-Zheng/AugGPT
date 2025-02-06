import java.util.ArrayList;
import java.util.List;

public  class EmptySlotComponent extends ChessComponent{
//    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame concreteChessGame) {
//        this.name=name;
//        setSource(source);
//        setChessColor(chessColor);
//        this.concreteChessGame=concreteChessGame;
//    }
private ChessComponent[][] chessComponents= new ChessComponent[8][8];

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public ChessColor getChessColor() {
        return super.getChessColor();
    }
    public ChessboardPoint getSource() {
        return super.getSource();
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public String toString() {
        return String.valueOf(name);
    }
}