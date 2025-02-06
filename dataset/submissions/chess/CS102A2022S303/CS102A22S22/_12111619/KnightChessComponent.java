import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int xAxis = source.getX();
        int yAxis = source.getY();
        List<ChessboardPoint> returnValue = new ArrayList<>();
        returnValue.add(new ChessboardPoint(xAxis + 1, yAxis + 2));
        returnValue.add(new ChessboardPoint(xAxis + 2, yAxis + 1));
        returnValue.add(new ChessboardPoint(xAxis + 2, yAxis - 1));
        returnValue.add(new ChessboardPoint(xAxis + 1, yAxis - 2));
        returnValue.add(new ChessboardPoint(xAxis - 1, yAxis - 2));
        returnValue.add(new ChessboardPoint(xAxis - 2, yAxis - 1));
        returnValue.add(new ChessboardPoint(xAxis - 2, yAxis + 1));
        returnValue.add(new ChessboardPoint(xAxis - 1, yAxis + 2));
        for (int i = 0; i < returnValue.size(); i++) {
            if (returnValue.get(i).offset() == null) {
                returnValue.remove(i);
                i--;
                continue;
            }
            if (chessComponents[returnValue.get(i).getX()][returnValue.get(i).getY()].getChessColor() == chessColor){
                returnValue.remove(i);
                i--;
            }
        }
        return returnValue;
    }
}
