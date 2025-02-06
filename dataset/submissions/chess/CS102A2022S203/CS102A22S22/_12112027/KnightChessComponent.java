import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint point;
    private ChessColor chessColor;
    private ConcreteChessGame belong ;
    private char name;

    public KnightChessComponent(ChessboardPoint point, ChessColor chessColor, ConcreteChessGame concreteChessGame){
        this.point = point;
        this.chessColor = chessColor;
        this.belong = concreteChessGame;
        if (chessColor == ChessColor.BLACK)name = 'N';
        else name = 'n';
    }

    public ChessboardPoint getPoint() {
        return point;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public ConcreteChessGame getBelong() {
        return belong;
    }

    @Override
    public char getName() {
        return name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> out = new ArrayList<>();
        int x = point.getX();
        int y = point.getY();

        for (int i = 0; i<8 ; i++){
            for (int j = 0; j < 8 ; j++){
                if (Math.abs((x-i)*(y-j)) == 2){
                    if (!belong.getChess(i,j).getChessColor().equals(chessColor)){
                        ChessboardPoint point1 = new ChessboardPoint(i,j);
                        out.add(point1);
                    }
                }
            }
        }
        if (out == null){
            return new ArrayList<>();
        }else return out;
    }
}
