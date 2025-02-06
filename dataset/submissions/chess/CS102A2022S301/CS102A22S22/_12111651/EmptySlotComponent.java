import java.util.*;

public class EmptySlotComponent extends ChessComponent{
    private List<ChessboardPoint> chessboardPoints = new ArrayList<>();
    private ChessboardPoint source;
    private ChessColor chessColor;
    private char name;

    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor , Character name,  ChessComponent[][] chessComponents){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        super.setSource(source);
        super.setChessColor(chessColor);
        super.setName(name);
        this.chessComponents = chessComponents;
        super.setChessComponents(chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return chessboardPoints;
    }
}
