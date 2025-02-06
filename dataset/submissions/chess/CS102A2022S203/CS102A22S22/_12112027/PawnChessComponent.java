import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint point;
    private ChessColor chessColor;
    private ConcreteChessGame belong;
    private char name;

    private boolean firstStep = true;

    public PawnChessComponent(ChessboardPoint point, ChessColor chessColor, ConcreteChessGame concreteChessGame){
        this.point = point;
        this.chessColor = chessColor;
        this.belong = concreteChessGame;
        if (chessColor == ChessColor.BLACK)name = 'P';
        else name = 'p';
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
        boolean flag = true;
        int color;
        if (this.chessColor.equals(ChessColor.BLACK)){
            color = 1;
        }else color = -1;
        if (firstStep){
            if (belong.getChessBoard(x+color).charAt(y) == '_'){
                ChessboardPoint point1 = new ChessboardPoint(x+color,y);
                out.add(point1);
            }else flag =false;
            if (belong.getChessBoard(x+2*color).charAt(y) == '_' && flag){
                ChessboardPoint point1 = new ChessboardPoint(x+2*color,y);
                out.add(point1);
            }
        }else {
            if (x+color<8 && x+color>=0){
                if (belong.getChessBoard(x+color).charAt(y) == '_'){
                    ChessboardPoint point1 = new ChessboardPoint(x+color,y);
                    out.add(point1);
                }
            }
        }

        if (x+color>=0 && x+color<8 && y+1<8){
            if (belong.getChessBoard(x+color).charAt(y+1) != '_' && !belong.getChess(x+color,y+1).getChessColor().equals(chessColor)){
                ChessboardPoint point1 = new ChessboardPoint(x+color,y+1);
                out.add(point1);
            }
        }
        if (x+color>=0 && x+color<8 && y-1>=0){
            if (belong.getChessBoard(x+color).charAt(y-1) != '_' && !belong.getChess(x+color,y-1).getChessColor().equals(chessColor)){
                ChessboardPoint point1 = new ChessboardPoint(x+color,y-1);
                out.add(point1);
            }
        }
        if (out != null)return out;
        else return new ArrayList<>();
    }
}
