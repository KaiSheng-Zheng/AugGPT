import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        setSource(source);
        setChessColor(chessColor);
        switch (chessColor){
            case WHITE -> this.name = 'n';
            case BLACK -> this.name = 'N';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList = new ArrayList<>();
        ChessComponent[][] chessComponents = getChessComponents();
        int X = getSource().getX();
        int Y = getSource().getY();
        ChessColor chessColor = getChessColor();

        if (X - 2 >= 0 && Y - 1 >= 0 && chessComponents[X - 2][Y - 1].getChessColor() != chessColor)
            pointList.add(chessComponents[X - 2][Y - 1].getSource());
        if (X - 1 >= 0 && Y - 2 >= 0 && chessComponents[X - 1][Y - 2].getChessColor() != chessColor)
            pointList.add(chessComponents[X - 1][Y - 2].getSource());
        if (X + 2 <= 7 && Y - 1 >= 0 && chessComponents[X + 2][Y - 1].getChessColor() != chessColor)
            pointList.add(chessComponents[X + 2][Y - 1].getSource());
        if (X + 1 <= 7 && Y - 2 >= 0 && chessComponents[X + 1][Y - 2].getChessColor() != chessColor)
            pointList.add(chessComponents[X + 1][Y - 2].getSource());
        if (X - 2 >= 0 && Y + 1 <= 7 && chessComponents[X - 2][Y + 1].getChessColor() != chessColor)
            pointList.add(chessComponents[X - 2][Y + 1].getSource());
        if (X - 1 >= 0 && Y + 2 <= 7 && chessComponents[X - 1][Y + 2].getChessColor() != chessColor)
            pointList.add(chessComponents[X - 1][Y + 2].getSource());
        if (X + 1 <= 7 && Y + 2 <= 7 && chessComponents[X + 1][Y + 2].getChessColor() != chessColor)
            pointList.add(chessComponents[X + 1][Y + 2].getSource());
        if (X + 2 <= 7 && Y + 1 <= 7 && chessComponents[X + 2][Y + 1].getChessColor() != chessColor)
            pointList.add(chessComponents[X + 2][Y + 1].getSource());
        return pointList;
    }
}