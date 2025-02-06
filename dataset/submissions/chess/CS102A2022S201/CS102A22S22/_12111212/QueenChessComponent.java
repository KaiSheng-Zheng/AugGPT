import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        setSource(source);
        setChessColor(chessColor);
        switch (chessColor){
            case WHITE -> this.name = 'q';
            case BLACK -> this.name = 'Q';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList = new ArrayList<>();
        ChessComponent[][] chessComponents = getChessComponents();
        int X = getSource().getX();
        int Y = getSource().getY();
        ChessColor chessColor = getChessColor();

        for (int i = 1 ; X - i >= 0; i++){
            if (chessComponents[X - i][Y].getChessColor() == chessColor)
                break;
            pointList.add(chessComponents[X - i][Y].getSource());
            if (!(chessComponents[X - i][Y] instanceof EmptySlotComponent))
                break;
        }
        for (int i = 1 ; X + i <= 7; i++){
            if (chessComponents[X + i][Y].getChessColor() == chessColor)
                break;
            pointList.add(chessComponents[X + i][Y].getSource());
            if (!(chessComponents[X + i][Y] instanceof EmptySlotComponent))
                break;
        }
        for (int i = 1 ; Y - i >= 0; i++){
            if (chessComponents[X][Y - i].getChessColor() == chessColor)
                break;
            pointList.add(chessComponents[X][Y - i].getSource());
            if (!(chessComponents[X][Y - i] instanceof EmptySlotComponent))
                break;
        }
        for (int i = 1 ; Y + i <= 7; i++){
            if (chessComponents[X][Y + i].getChessColor() == chessColor)
                break;
            pointList.add(chessComponents[X][Y + i].getSource());
            if (!(chessComponents[X][Y + i] instanceof EmptySlotComponent))
                break;
        }
        for (int i = 1 ; X - i >= 0 && Y - i >= 0; i++){
            if (chessComponents[X - i][Y - i].getChessColor() == chessColor)
                break;
            pointList.add(chessComponents[X - i][Y - i].getSource());
            if (!(chessComponents[X - i][Y - i] instanceof EmptySlotComponent))
                break;
        }
        for (int i = 1 ; X + i <= 7 && Y - i >= 0; i++){
            if (chessComponents[X + i][Y - i].getChessColor() == chessColor)
                break;
            pointList.add(chessComponents[X + i][Y - i].getSource());
            if (!(chessComponents[X + i][Y - i] instanceof EmptySlotComponent))
                break;
        }
        for (int i = 1 ; X - i >= 0 && Y + i <= 7; i++){
            if (chessComponents[X - i][Y + i].getChessColor() == chessColor)
                break;
            pointList.add(chessComponents[X - i][Y + i].getSource());
            if (!(chessComponents[X - i][Y + i] instanceof EmptySlotComponent))
                break;
        }
        for (int i = 1 ; X + i <= 7 && Y + i <= 7; i++){
            if (chessComponents[X + i][Y + i].getChessColor() == chessColor)
                break;
            pointList.add(chessComponents[X + i][Y + i].getSource());
            if (!(chessComponents[X + i][Y + i] instanceof EmptySlotComponent))
                break;
        }
        return pointList;
    }
}