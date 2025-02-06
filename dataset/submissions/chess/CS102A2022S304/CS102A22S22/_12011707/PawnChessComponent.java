import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class PawnChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> sc=new ArrayList<>();
        if(super.getName()=='p'){
            if (super.getSource().getX()-1>=0&&chessBoard[super.getSource().getX()-1][super.getSource().getY()].getChessColor()==ChessColor.NONE){
                sc.add(new ChessboardPoint(super.getSource().getX()-1,super.getSource().getY()));
            }
            if(super.getSource().getX()==6){
                if(chessBoard[5][super.getSource().getY()].getName()=='_'&&chessBoard[4][super.getSource().getY()].getChessColor()== ChessColor.NONE){
                    sc.add(new ChessboardPoint(4,super.getSource().getY()));
                }
            }
            if(super.getSource().getY()-1>=0&&super.getSource().getX()-1>=0&&chessBoard[super.getSource().getX()-1][super.getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                sc.add(new ChessboardPoint(super.getSource().getX()-1,super.getSource().getY()-1));
            }
            if(super.getSource().getY()+1<=7&&super.getSource().getX()-1>=0&&chessBoard[super.getSource().getX()-1][super.getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                sc.add(new ChessboardPoint(super.getSource().getX()-1,super.getSource().getY()+1));
            }
        }else if(super.getName()=='P'){
            if (super.getSource().getX()+1<=7&&chessBoard[super.getSource().getX()+1][super.getSource().getY()].getChessColor()==ChessColor.NONE){
                sc.add(new ChessboardPoint(super.getSource().getX()+1,super.getSource().getY()));
            }
            if(super.getSource().getX()==1){
                if(chessBoard[2][super.getSource().getY()].getName()=='_'&&chessBoard[3][super.getSource().getY()].getChessColor()== ChessColor.NONE){
                    sc.add(new ChessboardPoint(3,super.getSource().getY()));
                }
            }
            if(super.getSource().getY()-1>=0&&super.getSource().getX()+1<=7&&chessBoard[super.getSource().getX()+1][super.getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                sc.add(new ChessboardPoint(super.getSource().getX()+1,super.getSource().getY()-1));
            }
            if(super.getSource().getY()+1<=7&&super.getSource().getX()+1<=7&&chessBoard[super.getSource().getX()+1][super.getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                sc.add(new ChessboardPoint(super.getSource().getX()+1,super.getSource().getY()+1));
            }
        }
        return sc;
    }
}
