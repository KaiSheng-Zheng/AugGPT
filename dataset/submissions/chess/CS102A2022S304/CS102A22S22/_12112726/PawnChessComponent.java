import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent() {
    }

    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'P';
        } else if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'p';
        } else {
            super.name = '_';
        }
    }

    @Override
    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }

    @Override
    public void setChessColor(ChessColor chessColor) {
        super.setChessColor(chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'p';
        } else {
            super.name = 'P';
        }
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    public PawnChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'p';
        } else {
            super.name = 'P';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Points=new ArrayList<>();
        ChessComponent[][] chessboard =getChessComponents();
        int targetX = getSource().getX();
        int targetY = getSource().getY();
        if (super.getChessColor()==ChessColor.BLACK){
            if (targetX==1){
                if (targetY-1>=0&&chessboard[targetX+1][targetY-1].getChessColor()==ChessColor.WHITE)
                    Points.add(new ChessboardPoint(targetX+1,targetY-1));
                if (chessboard[targetX+1][targetY].getChessColor()==ChessColor.NONE)
                    Points.add(new ChessboardPoint(targetX+1,targetY));
                if (targetY+1<=7&&chessboard[targetX+1][targetY+1].getChessColor()==ChessColor.WHITE)
                    Points.add(new ChessboardPoint(targetX+1,targetY+1));
                if (chessboard[targetX+1][targetY].getChessColor()==ChessColor.NONE&&chessboard[targetX+2][targetY].getChessColor()==ChessColor.NONE)
                    Points.add(new ChessboardPoint(targetX+2,targetY));
            }
            if (targetX!=1&&targetX+1<=7){
                if (targetY-1>=0&&chessboard[targetX+1][targetY-1].getChessColor()==ChessColor.WHITE)
                    Points.add(new ChessboardPoint(targetX+1,targetY-1));
                if (chessboard[targetX+1][targetY].getChessColor()==ChessColor.NONE)
                    Points.add(new ChessboardPoint(targetX+1,targetY));
                if (targetY+1<=7&&chessboard[targetX+1][targetY+1].getChessColor()==ChessColor.WHITE)
                    Points.add(new ChessboardPoint(targetX+1,targetY+1));
            }
        }
        if (super.getChessColor()==ChessColor.WHITE){
            if (targetX==6){
                if (targetY-1>=0&&chessboard[targetX-1][targetY-1].getChessColor()==ChessColor.BLACK)
                    Points.add(new ChessboardPoint(targetX-1,targetY-1));
                if (chessboard[targetX-1][targetY].getChessColor()==ChessColor.NONE)
                    Points.add(new ChessboardPoint(targetX-1,targetY));
                if (targetY+1<=7&&chessboard[targetX-1][targetY+1].getChessColor()==ChessColor.BLACK)
                    Points.add(new ChessboardPoint(targetX-1,targetY+1));
                if (chessboard[targetX-1][targetY].getChessColor()==ChessColor.NONE&&chessboard[targetX-2][targetY].getChessColor()==ChessColor.NONE)
                    Points.add(new ChessboardPoint(targetX-2,targetY));
            }
            if (targetX!=6&&targetX-1>=0){
                if (targetY-1>=0&&chessboard[targetX-1][targetY-1].getChessColor()==ChessColor.WHITE)
                    Points.add(new ChessboardPoint(targetX-1,targetY-1));
                if (chessboard[targetX-1][targetY].getChessColor()==ChessColor.NONE)
                    Points.add(new ChessboardPoint(targetX-1,targetY));
                if (targetY+1<=7&&chessboard[targetX-1][targetY+1].getChessColor()==ChessColor.WHITE)
                    Points.add(new ChessboardPoint(targetX-1,targetY+1));
            }
        }
        return Points;
    }
}
