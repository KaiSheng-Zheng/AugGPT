import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint point;
    private ChessColor chessColor;
    private ConcreteChessGame belong;

    private char name;

    public BishopChessComponent(ChessboardPoint point, ChessColor chessColor, ConcreteChessGame concreteChessGame){
        this.point = point;
        this.chessColor = chessColor;
        this.belong = concreteChessGame;
        if (chessColor == ChessColor.BLACK)name = 'B';
        else name = 'b';
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
        List<ChessboardPoint> out = new ArrayList<ChessboardPoint>();
        int x = point.getX();
        int y = point.getY();
        boolean flag = true;

        x++;
        y++;
        while (x>=0 && x<8 && y>=0 && y<8 && flag == true){
            if (belong.getChessBoard(x).charAt(y) == '_' ){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }else if (flag == true){
                if (!belong.getChess(x,y).getChessColor().equals(chessColor)) {
                    ChessboardPoint point1 = new ChessboardPoint(x, y);
                    out.add(point1);
                }
                flag = false;
            }
            x++;
            y++;
        }

        x = point.getX()+1;
        y = point.getY()-1;
        flag = true;
        while (x>=0 && x<8 && y>=0 && y<8 && flag == true){
            if (belong.getChessBoard(x).charAt(y) == '_' ){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }else if (flag == true){
                if (!belong.getChess(x,y).getChessColor().equals(chessColor)) {
                    ChessboardPoint point1 = new ChessboardPoint(x, y);
                    out.add(point1);
                }
                flag = false;
            }
            x++;
            y--;
        }

        x = point.getX()-1;
        y = point.getY()-1;
        flag = true;
        while (x>=0 && x<8 && y>=0 && y<8 && flag == true){
            if (belong.getChessBoard(x).charAt(y) == '_' ){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }else if (flag == true){
                if (!belong.getChess(x,y).getChessColor().equals(chessColor)) {
                    ChessboardPoint point1 = new ChessboardPoint(x, y);
                    out.add(point1);
                }
                flag = false;
            }
            x--;
            y--;
        }

        x = point.getX()-1;
        y = point.getY()+1;
        flag = true;
        while (x>=0 && x<8 && y>=0 && y<8 && flag == true){
            if (belong.getChessBoard(x).charAt(y) == '_' ){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }else if (flag == true){
                if (!belong.getChess(x,y).getChessColor().equals(chessColor)) {
                    ChessboardPoint point1 = new ChessboardPoint(x, y);
                    out.add(point1);
                }
                flag = false;
            }
            x--;
            y++;
        }


        if (out == null){
            return new ArrayList<>();
        }else return out;
    }

}
