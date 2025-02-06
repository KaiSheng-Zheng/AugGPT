import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessComponents) {

        this.source=source;
        this.chessColor=chessColor;
        this.chessComponents=chessComponents;
        super.source = source;
        if (super.chessColor.getName().equals("Black"))
            super.name = 'N';
        if (super.chessColor.getName().equals("White"))
            super.name = 'n';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }

    public String toString() {
        return String.valueOf(this.name);
    }
}