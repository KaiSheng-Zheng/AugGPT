import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super(source,chessColor);
        this.chessColor = chessColor;
        this.source = source;
        if (chessColor == ChessColor.BLACK){
            name = 'P';
        }
        if (chessColor == ChessColor.WHITE){
            name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {return null;}
    }

