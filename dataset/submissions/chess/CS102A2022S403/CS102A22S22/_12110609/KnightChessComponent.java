    import java.util.ArrayList;
    import java.util.List;

    public class KnightChessComponent extends ChessComponent{
        public KnightChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor color) {
            name = c;
            setChessColor(color);
            setSource(chessboardPoint);
        }
        @Override
        public List<ChessboardPoint> canMoveTo() {
            ChessboardPoint source = getSource();
            ChessColor color = getChessColor();
            List<ChessboardPoint> list = new ArrayList<>();

            return list;
        }
    }
