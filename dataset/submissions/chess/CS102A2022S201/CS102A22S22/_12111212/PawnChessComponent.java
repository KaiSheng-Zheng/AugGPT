import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        setSource(source);
        setChessColor(chessColor);
        switch (chessColor){
            case WHITE -> this.name = 'p';
            case BLACK -> this.name = 'P';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList = new ArrayList<>();
        ChessComponent[][] chessComponents = getChessComponents();
        int X = getSource().getX();
        int Y = getSource().getY();
        ChessColor chessColor = getChessColor();
        boolean move = false;

        if (this.getChessColor() == ChessColor.WHITE){
            if (X > 0){
                if (chessComponents[X - 1][Y] instanceof EmptySlotComponent){
                    pointList.add(chessComponents[X - 1][Y].getSource());
                    move = true;
                }
                if (X == 6 && move && chessComponents[X - 2][Y] instanceof EmptySlotComponent){
                    pointList.add(chessComponents[X - 2][Y].getSource());
                }
                if (Y > 0 && !(chessComponents[X - 1][Y - 1] instanceof EmptySlotComponent)
                && chessComponents[X - 1][Y - 1].getChessColor() != chessColor){
                    pointList.add(chessComponents[X - 1][Y - 1].getSource());
                }
                if (Y < 7 && !(chessComponents[X - 1][Y + 1] instanceof EmptySlotComponent
                && chessComponents[X - 1][Y + 1].getChessColor() != chessColor)){
                    pointList.add(chessComponents[X - 1][Y + 1].getSource());
                }
            }
        }
        else {
            if (X < 7){
                if (chessComponents[X + 1][Y] instanceof EmptySlotComponent){
                    pointList.add(chessComponents[X + 1][Y].getSource());
                    move = true;
                }
                if (X == 1 && move && chessComponents[X + 2][Y] instanceof EmptySlotComponent){
                    pointList.add(chessComponents[X + 2][Y].getSource());
                }
                if (Y > 0 && !(chessComponents[X + 1][Y - 1] instanceof EmptySlotComponent)
                && chessComponents[X + 1][Y - 1].getChessColor() != chessColor){
                    pointList.add(chessComponents[X + 1][Y - 1].getSource());
                }
                if (Y < 7 && !(chessComponents[X + 1][Y + 1] instanceof EmptySlotComponent)
                && chessComponents[X + 1][Y + 1].getChessColor() != chessColor){
                    pointList.add(chessComponents[X + 1][Y + 1].getSource());
                }
            }
        }
        return pointList;
    }
}