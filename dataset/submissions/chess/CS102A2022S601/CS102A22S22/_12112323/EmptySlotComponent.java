import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    @Override
    public char getName() {
        return name;
    }

    @Override
    public void setName(char name) {
        this.name = name;
    }

    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor, char name){
        this.source=source;
        this.chessColor=ChessColor.NONE;
        this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}

