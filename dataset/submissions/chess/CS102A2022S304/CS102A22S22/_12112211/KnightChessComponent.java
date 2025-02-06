import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public void setChessColor(ChessColor chessColor){
        super.setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint p1 = new ChessboardPoint(getSource().getX()+2, getSource().getY()+1 );
        ChessboardPoint p2 = new ChessboardPoint(getSource().getX()+1, getSource().getY()+2);
         ChessboardPoint p3 = new ChessboardPoint(getSource().getX()-1, getSource().getY()+2);
         ChessboardPoint p4 = new ChessboardPoint(getSource().getX()-2, getSource().getY()+1);
         ChessboardPoint p5 = new ChessboardPoint(getSource().getX()+1, getSource().getY()-2);
         ChessboardPoint p6 = new ChessboardPoint(getSource().getX()+2, getSource().getY()-1);
         ChessboardPoint p7 = new ChessboardPoint(getSource().getX()-1, getSource().getY()-2);
         ChessboardPoint p8 = new ChessboardPoint(getSource().getX()-2, getSource().getY()-1);
         ArrayList<ChessboardPoint> points = new ArrayList<>();
         ArrayList<ChessboardPoint> ans = new ArrayList<>();
         points.add(p1);
         points.add(p2);
         points.add(p3);
         points.add(p4);
         points.add(p5);
         points.add(p6);
         points.add(p7);
         points.add(p8);
        for (int i = 0; i <points.size() ; i++) {
            if (points.get(i).getX() == -1){
                points.remove(points.get(i));
                i=i-1;
            }
        }
        for (int i = 0; i <points.size() ; i++) {
            if (chessBoard[getSource().getX()][getSource().getY()].getChessColor() == chessBoard[points.get(i).getX()][points.get(i).getY()].getChessColor() ){
                points.remove(points.get(i));
                i = i-1;
            }
        }


        return points;
    }
}

