import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    ChessComponent[][] chessComponents=new ChessComponent[8][8];

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public EmptySlotComponent(ChessboardPoint source , ChessColor chessColor , char name) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name =name;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
