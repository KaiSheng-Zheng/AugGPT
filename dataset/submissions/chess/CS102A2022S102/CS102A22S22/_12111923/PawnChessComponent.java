import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    private int cnt = 0;

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessColor chessColor = super.getChessColor();
        for (int i = 0; i < 8; i++) {
            if (!super.getSource().canMoveTo(i, i)) break;
            ChessboardPoint chessboardPoint1 = super.getSource().offset(i, i);
            if (super.chessboard[chessboardPoint1.getX()][chessboardPoint1.getY()].getChessColor().equals(chessColor))
                break;
            if (!super.chessboard[chessboardPoint1.getX()][chessboardPoint1.getY()].getChessColor().equals(ChessColor.NONE)) {
                canMoveTo.add(chessboardPoint1);
                break;
            }
            canMoveTo.add(chessboardPoint1);
        }
        super.ComparecanMoveTo(canMoveTo);
        return canMoveTo;
    }

    public void PawnChessComponent(ChessboardPoint source,ChessColor chessColor) {
            this.chessColor = chessColor;
            this.source = source;
        }
    public void cntCnt() {
        cnt=1;
    }
        public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
            ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
            int drow=source.getX()-targetX;
            int dcol=Math.abs(targetY-source.getY());
            if (dcol==0 && drow==-1 && chessColor.equals(ChessColor.BLACK)) {
                if (!chessColor.equals(chessComponents[targetX][targetY].getChessColor())){
                    cnt=1;
                    return true;
                }else {return false;}
            }else if (dcol==0 && drow ==1 && chessColor.equals(ChessColor.WHITE)){
                if (!chessColor.equals(chessComponents[targetX][targetY].getChessColor())){
                    cnt=1;
                    return true;
                }else {return false;}
            }else if (dcol==0 && drow ==-2 && chessColor.equals(ChessColor.BLACK)){
                if ((!chessColor.equals(chessComponents[targetX][targetY].getChessColor()))&&
                        (cnt==0)&&(chessComponents[targetX-1][targetY]instanceof EmptyChessComponent)){
                    cnt=1;
                    return true;
                }else {return false;}
            }else if (dcol==0 && drow ==2 && chessColor.equals(ChessColor.WHITE)){
                if ((!chessColor.equals(chessComponents[targetX][targetY].getChessColor()))&&
                        (cnt==0)&&(chessComponents[targetY+1][targetY]instanceof EmptyChessComponent)){
                    cnt=1;
                    return true;
                }else {return false;}
            }else if (dcol==1 && Math.abs(drow)==1) {
                if (!(chessComponents[targetX][targetY] instanceof EmptyChessComponent) &&
                        (!chessColor.equals(chessComponents[targetX][targetY].getChessColor()))){
                    cnt=1;
                    return true;
                }
            }else {return false;}
            if (!chessColor.equals(chessComponents[targetX][targetY].getChessColor())){cnt=1;}
            return false;
    }
}