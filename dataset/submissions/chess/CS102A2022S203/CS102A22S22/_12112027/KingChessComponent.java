import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint point;
    private ChessColor chessColor;
    private ConcreteChessGame belong ;
    private char name;

    public KingChessComponent(ChessboardPoint point, ChessColor chessColor, ConcreteChessGame concreteChessGame){
        this.point = point;
        this.chessColor = chessColor;
        this.belong = concreteChessGame;
        if (chessColor == ChessColor.BLACK)name = 'K';
        else name = 'k';
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
        int x;
        int y;

        x = point.getX()+1;
        y = point.getY()+1;
        if (x>=0 && x<8 && y>=0 && y<8){
            if (!belong.getChess(x,y).getChessColor().equals(chessColor)){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }
        }

        x = point.getX()+1;
        y = point.getY()-1;
        if (x>=0 && x<8 && y>=0 && y<8){
            if (!belong.getChess(x,y).getChessColor().equals(chessColor)){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }
        }

        x = point.getX()-1;
        y = point.getY()+1;
        if (x>=0 && x<8 && y>=0 && y<8){
            if (!belong.getChess(x,y).getChessColor().equals(chessColor)){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }
        }

        x = point.getX()-1;
        y = point.getY()-1;
        if (x>=0 && x<8 && y>=0 && y<8){
            if (!belong.getChess(x,y).getChessColor().equals(chessColor)){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }
        }

        x = point.getX()-1;
        y = point.getY();
        if (x>=0 && x<8 && y>=0 && y<8){
            if (!belong.getChess(x,y).getChessColor().equals(chessColor)){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }
        }

        x = point.getX()+1;
        y = point.getY();
        if (x>=0 && x<8 && y>=0 && y<8){
            if (!belong.getChess(x,y).getChessColor().equals(chessColor)){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }
        }

        x = point.getX();
        y = point.getY()+1;
        if (x>=0 && x<8 && y>=0 && y<8){
            if (!belong.getChess(x,y).getChessColor().equals(chessColor)){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }
        }

        x = point.getX();
        y = point.getY()-1;
        if (x>=0 && x<8 && y>=0 && y<8){
            if (!belong.getChess(x,y).getChessColor().equals(chessColor)){
                ChessboardPoint point1 = new ChessboardPoint(x,y);
                out.add(point1);
            }
        }

        if (out == null){
            return new ArrayList<>();
        }else return out;
    }
}
