import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    @Override
    public List<ChessboardPoint> canMoveTo() {
         ArrayList<ChessboardPoint> ans = new ArrayList<>();
        ChessboardPoint up = new ChessboardPoint(getSource().getX()-1, getSource().getY());
        ChessboardPoint down = new ChessboardPoint(getSource().getX()+1, getSource().getY());
       ChessboardPoint left = new ChessboardPoint(getSource().getX(), getSource().getY()-1);
       ChessboardPoint right = new ChessboardPoint(getSource().getX(), getSource().getY()+1);
       ChessboardPoint uR = new ChessboardPoint(getSource().getX()-1, getSource().getY()+1);
       ChessboardPoint dR = new ChessboardPoint(getSource().getX()+1, getSource().getY()+1);
       ChessboardPoint ul = new ChessboardPoint(getSource().getX()+1, getSource().getY()-1);
       ChessboardPoint dl = new ChessboardPoint(getSource().getX()-1, getSource().getY()-1);
       ans.add(up);
       ans.add(down);
       ans.add(left);
       ans.add(right);
       ans.add(uR);
       ans.add(ul);
       ans.add(dR);
       ans.add(dl);
        for (int i = 0; i <ans.size(); i++) {
            if (ans.get(i).getX()==-1){
                ans.remove(ans.get(i));
                i = i - 1;
            }
        }
        for (int i = 0; i <ans.size() ; i++) {
            if (chessBoard[getSource().getX()][getSource().getY()].getChessColor() == chessBoard[ans.get(i).getX()][ans.get(i).getY()].getChessColor()){
                ans.remove(ans.get(i));
                i = i - 1;
            }
        }

        return  ans;
    }
}
