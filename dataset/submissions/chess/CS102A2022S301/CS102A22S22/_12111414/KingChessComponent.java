import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();

        if (x + 1 <= 7 && y + 1 <= 7){
            if (chessComponents[x + 1][y + 1].getChessColor() != this.getChessColor()){
                canMovePoints.add(new ChessboardPoint(x + 1, y + 1));
            }
        }

        if (x - 1 >= 0 && y + 1 <= 7){
            if (chessComponents[x - 1][y + 1].getChessColor() != this.getChessColor()){
                canMovePoints.add(new ChessboardPoint(x - 1, y + 1));
            }
        }

        if (x + 1 <= 7 && y - 1 >= 0){
            if (chessComponents[x + 1][y - 1].getChessColor() != this.getChessColor()){
                canMovePoints.add(new ChessboardPoint(x + 1, y - 1));
            }
        }

        if (x - 1 >= 0 && y - 1 >= 0){
            if (chessComponents[x - 1][y - 1].getChessColor() != this.getChessColor()){
                canMovePoints.add(new ChessboardPoint(x - 1, y - 1));
            }
        }

        if (y + 1 <= 7){
            if (chessComponents[x][y + 1].getChessColor() != this.getChessColor()){
                canMovePoints.add(new ChessboardPoint(x, y + 1));
            }
        }

        if (y - 1 >= 0){
            if (chessComponents[x][y - 1].getChessColor() != this.getChessColor()){
                canMovePoints.add(new ChessboardPoint(x, y - 1));
            }
        }

        if (x + 1 <= 7){
            if (chessComponents[x + 1][y].getChessColor() != this.getChessColor()){
                canMovePoints.add(new ChessboardPoint(x + 1, y));
            }
        }

        if (x - 1 >= 0){
            if (chessComponents[x - 1][y].getChessColor() != this.getChessColor()){
                canMovePoints.add(new ChessboardPoint(x - 1, y));
            }
        }
        return canMovePoints;
    }

}