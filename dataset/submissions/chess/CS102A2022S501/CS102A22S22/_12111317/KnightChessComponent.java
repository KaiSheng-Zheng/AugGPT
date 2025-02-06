import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint){
        this.chessComponents = chessComponents;
        setSource(chessboardPoint);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> KnightPoints = new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        if (row - 2 >= 0 && col - 1 >= 0 && !(chessComponents[row - 2][col - 1].getChessColor() == this.getChessColor())){
            KnightPoints.add(new ChessboardPoint(row - 2, col - 1));
        }
        if (row - 1 >= 0 && col - 2 >= 0 && !(chessComponents[row - 1][col - 2].getChessColor() == this.getChessColor())){
            KnightPoints.add(new ChessboardPoint(row - 1, col - 2));
        }
        if (row + 1 <= 7 && col - 2 >= 0 && !(chessComponents[row + 1][col - 2].getChessColor() == this.getChessColor())){
            KnightPoints.add(new ChessboardPoint(row + 1, col - 2));
        }
        if (row + 2 <= 7 &&  col - 1 >= 0 && !(chessComponents[row + 2][col - 1].getChessColor() == this.getChessColor())){
            KnightPoints.add(new ChessboardPoint(row + 2, col - 1));
        }
        if (row + 2 <= 7 &&  col + 1 <= 7 && !(chessComponents[row + 2][col + 1].getChessColor() == this.getChessColor())){
            KnightPoints.add(new ChessboardPoint(row + 2, col + 1));
        }
        if (row + 1 <= 7 &&  col + 2 <=7 && !(chessComponents[row + 1][col + 2].getChessColor() == this.getChessColor())){
            KnightPoints.add(new ChessboardPoint(row + 1, col + 2));
        }
        if (row - 1 >= 0 &&  col + 2 <= 7 && !(chessComponents[row - 1][col + 2].getChessColor() == this.getChessColor())){
            KnightPoints.add(new ChessboardPoint(row - 1, col + 2));
        }
        if (row - 2 <= 7 && col + 1 <= 7 && !(chessComponents[row - 2][col + 1].getChessColor() == this.getChessColor())){
            KnightPoints.add(new ChessboardPoint(row - 2, col + 1));
        }
        return KnightPoints;
    }
}
