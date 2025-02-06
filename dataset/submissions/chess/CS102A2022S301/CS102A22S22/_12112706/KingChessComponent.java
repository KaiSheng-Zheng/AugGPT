import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessComponents) {

        this.source=source;
        this.chessColor=chessColor;
        this.chessComponents=chessComponents;
        super.source = source;
        if (super.chessColor.getName().equals("Black"))
            super.name = 'K';
        if (super.chessColor.getName().equals("White"))
            super.name = 'k';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }

    public String toString() {
        return String.valueOf(this.name);
    }
}