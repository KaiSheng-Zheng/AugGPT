import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        setSource(source);
        setChessColor(chessColor);
        switch (chessColor){
            case WHITE -> this.name = 'k';
            case BLACK -> this.name = 'K';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList = new ArrayList<>();
        ChessComponent[][] chessComponents = getChessComponents();
        int X = getSource().getX();
        int Y = getSource().getY();
        ChessColor chessColor = getChessColor();

        if (X > 0 && chessComponents[X - 1][Y].getChessColor() != chessColor)
            pointList.add(chessComponents[X - 1][Y].getSource());
        if (Y > 0 && chessComponents[X][Y - 1].getChessColor() != chessColor)
            pointList.add(chessComponents[X][Y - 1].getSource());
        if (X < 7 && chessComponents[X + 1][Y].getChessColor() != chessColor)
            pointList.add(chessComponents[X + 1][Y].getSource());
        if (Y < 7 && chessComponents[X][Y + 1].getChessColor() != chessColor)
            pointList.add(chessComponents[X][Y + 1].getSource());
        if (X > 0 && Y > 0 && chessComponents[X - 1][Y - 1].getChessColor() != chessColor)
            pointList.add(chessComponents[X - 1][Y - 1].getSource());
        if (X > 0 && Y < 7 && chessComponents[X - 1][Y + 1].getChessColor() != chessColor)
            pointList.add(chessComponents[X - 1][Y + 1].getSource());
        if (X < 7 && Y > 0 && chessComponents[X + 1][Y - 1].getChessColor() != chessColor)
            pointList.add(chessComponents[X + 1][Y - 1].getSource());
        if (X < 7 && Y < 7 && chessComponents[X + 1][Y + 1].getChessColor() != chessColor)
            pointList.add(chessComponents[X + 1][Y + 1].getSource());

        return pointList;
    }
}