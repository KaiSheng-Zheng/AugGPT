import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(char name, ChessboardPoint source, ChessColor chessColor) {
            setName(name);
            setChessColor(chessColor);
            setSource(source);
        }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        ChessboardPoint source = getSource();
        if (source != null) {
            ChessColor chessColor = getChessColor();

            if (source.getX() - 1 >= 0 && source.getY() - 1 >= 0) {
                if (CommonUtils.addWedig(chessColor.name(), source.getX() - 1, source.getY() - 1))
                chessboardPointList.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
            }
            if (source.getX() - 1 >= 0) {
                if (CommonUtils.addWedig(chessColor.name(), source.getX() - 1, source.getY()))
                chessboardPointList.add(new ChessboardPoint(source.getX() - 1, source.getY()));
            }
            if (source.getX() - 1 >= 0 && source.getY() + 1 < 8) {
                if (CommonUtils.addWedig(chessColor.name(), source.getX() - 1, source.getY() + 1))
                chessboardPointList.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
            }
            if (source.getY() - 1 >= 0) {
                if (CommonUtils.addWedig(chessColor.name(), source.getX(), source.getY() - 1))
                chessboardPointList.add(new ChessboardPoint(source.getX(), source.getY() - 1));
            }
            if (source.getY() + 1 < 8) {
                if (CommonUtils.addWedig(chessColor.name(), source.getX(), source.getY() + 1))
                chessboardPointList.add(new ChessboardPoint(source.getX(), source.getY() + 1));
            }

            if (source.getX() + 1 < 8 && source.getY() - 1 >= 0) {
                if (CommonUtils.addWedig(chessColor.name(), source.getX() + 1, source.getY() - 1))
                chessboardPointList.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
            }
            if (source.getX() + 1 < 8) {
                if (CommonUtils.addWedig(chessColor.name(), source.getX() + 1, source.getY()))
                chessboardPointList.add(new ChessboardPoint(source.getX() + 1, source.getY()));
            }
            if (source.getX() + 1 < 8 && source.getY() + 1 < 8) {
                if (CommonUtils.addWedig(chessColor.name(), source.getX() + 1, source.getY() + 1))
                chessboardPointList.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
            }
        }

        return chessboardPointList;
    }
}
