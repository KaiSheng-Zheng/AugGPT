import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> sc=new ArrayList<>();
        if( super.getSource().getX()-1>=0&&super.getSource().getY()-2>=0&&super.getSource().getX()-1<=7&&super.getSource().getY()-2<=7&&chessBoard[super.getSource().getX()-1][super.getSource().getY()-2].getChessColor()!=super.getChessColor()){
            sc.add(new ChessboardPoint(super.getSource().getX()-1,super.getSource().getY()-2));
        }
        if( super.getSource().getX()-1>=0&&super.getSource().getY()+2>=0&&super.getSource().getX()-1<=7&&super.getSource().getY()+2<=7&&chessBoard[super.getSource().getX()-1][super.getSource().getY()+2].getChessColor()!=super.getChessColor()){
            sc.add(new ChessboardPoint(super.getSource().getX()-1,super.getSource().getY()+2));
        }
        if( super.getSource().getX()+1>=0&&super.getSource().getY()-2>=0&&super.getSource().getX()+1<=7&&super.getSource().getY()-2<=7&&chessBoard[super.getSource().getX()+1][super.getSource().getY()-2].getChessColor()!=super.getChessColor()){
            sc.add(new ChessboardPoint(super.getSource().getX()+1,super.getSource().getY()-2));
        }
        if( super.getSource().getX()+1>=0&&super.getSource().getY()+2>=0&&super.getSource().getX()+1<=7&&super.getSource().getY()+2<=7&&chessBoard[super.getSource().getX()+1][super.getSource().getY()+2].getChessColor()!=super.getChessColor()){
            sc.add(new ChessboardPoint(super.getSource().getX()+1,super.getSource().getY()+2));
        }
        if( super.getSource().getX()-2>=0&&super.getSource().getY()-1>=0&&super.getSource().getX()-2<=7&&super.getSource().getY()-1<=7&&chessBoard[super.getSource().getX()-2][super.getSource().getY()-1].getChessColor()!=super.getChessColor()){
            sc.add(new ChessboardPoint(super.getSource().getX()-2,super.getSource().getY()-1));
        }
        if( super.getSource().getX()-2>=0&&super.getSource().getY()+1>=0&&super.getSource().getX()-2<=7&&super.getSource().getY()+1<=7&&chessBoard[super.getSource().getX()-2][super.getSource().getY()+1].getChessColor()!=super.getChessColor()){
            sc.add(new ChessboardPoint(super.getSource().getX()-2,super.getSource().getY()+1));
        }
        if( super.getSource().getX()+2>=0&&super.getSource().getY()-1>=0&&super.getSource().getX()+2<=7&&super.getSource().getY()-1<=7&&chessBoard[super.getSource().getX()+2][super.getSource().getY()-1].getChessColor()!=super.getChessColor()){
            sc.add(new ChessboardPoint(super.getSource().getX()+2,super.getSource().getY()-1));
        }
        if( super.getSource().getX()+2>=0&&super.getSource().getY()+1>=0&&super.getSource().getX()+2<=7&&super.getSource().getY()+1<=7&&chessBoard[super.getSource().getX()+2][super.getSource().getY()+1].getChessColor()!=super.getChessColor()){
            sc.add(new ChessboardPoint(super.getSource().getX()+2,super.getSource().getY()+1));
        }
        return sc;
    }
}
