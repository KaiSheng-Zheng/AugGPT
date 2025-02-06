import java.util.ArrayList;
import java.util.List;


public class EmptySlotComponent extends ChessComponent {
    private ChessboardPoint source = new ChessboardPoint(0,0);
    private ChessColor chessColor;


    public ChessColor getChessColor() {
        return chessColor;
    }

    public int getPower() {
        return 0;
    }

    public EmptySlotComponent(int x, int y, char name) {
        this.source.setX(x);
        this.source.setY(y);
        this.setChessColor(name);
        super.name = '_';
        super.setSource(new ChessboardPoint(x,y));
    }

    public void setChessColor(char name){
        this.chessColor = ChessColor.NONE;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public List<ChessboardPoint> canMove(ChessComponent[][] chessComponents) {return new ArrayList<>();}

    public char getName() {
        return name;
    }
}