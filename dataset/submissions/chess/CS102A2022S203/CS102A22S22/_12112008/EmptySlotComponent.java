import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    private ChessComponent[][] chessComponents=belonging.getChessComponents();
    public EmptySlotComponent(int x, int y, ChessColor color,ConcreteChessGame concreteChessGame) {
        super(x, y, color,concreteChessGame);
    }


    public boolean move(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        return false;
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
