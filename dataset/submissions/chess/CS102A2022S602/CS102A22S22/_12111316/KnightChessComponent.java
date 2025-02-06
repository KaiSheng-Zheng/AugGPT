import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> list = new ArrayList<>();

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
    public KnightChessComponent(){
    }
    public KnightChessComponent(ChessboardPoint source, ChessComponent[][] chessComponents,ChessColor chessColor, char name){
        super(source,chessComponents, chessColor, name);
        this.name=name;
        this.chessColor = chessColor;
        this.chessComponents =chessComponents;
    }

    public ChessColor getChessColor(){
        return this.chessColor;
    }
    public ChessComponent getChess(int X,int Y) {
        return chessComponents[X][Y];
    }

    public boolean canMove(int X, int Y){
        ChessboardPoint source = getSource();
            if ((Math.abs(source.getX() - X) == 1) && (Math.abs(source.getY() - Y) == 2) && (chessComponents[X][Y].getChessColor() != getChess(source.getX(), source.getY()).getChessColor())) {
                return true;
            }
            if ((Math.abs(source.getX() - X) == 2) && (Math.abs(source.getY() - Y) == 1) && (chessComponents[X][Y].getChessColor() != getChess(source.getX(), source.getY()).getChessColor())) {
                return true;
            }
            return false;
    }

    public boolean chick(int x, int y){
        ChessboardPoint source = getSource();
        if (chessComponents[x][y].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor() || chessComponents[x][y] instanceof EmptyChessComponent){
            return true;
        }
        return false;
    }
}
