import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private int serialNumber=-1;
    //private ChessColor chessColor;
   // private char name;
    //private ChessboardPoint source;
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    public EmptySlotComponent() {
        super();
    }
    public EmptySlotComponent(char name,ChessColor chessColor,ChessboardPoint source,ChessComponent[][] chessComponents){
        super.setName(name);
        super.setChessColor(chessColor);
        super.setSource(source);
        this.chessComponents=chessComponents;
    }



    @Override
    public String getName() {
        return String.valueOf(name);
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }


    public ChessboardPoint getSource() {
        return super.getSource();
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
