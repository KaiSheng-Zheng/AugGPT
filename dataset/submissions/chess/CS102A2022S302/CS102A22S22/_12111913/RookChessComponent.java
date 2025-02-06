

import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans=new ArrayList<ChessboardPoint>();
        ChessComponent left=this.SearchLeft(this);
        ChessComponent right=this.SearchRight(this);
        ChessComponent up=this.SearchUp(this);
        ChessComponent down=this.SearchDown(this);
        for (int i=this.getSource().getX();i>=left.getSource().getX();i--){
            if (!this.IsSame(getChess(i, this.getSource().getY()))){
                ans.add(getChess(i,this.getSource().getY()).getSource());
            }
        }
        for (int i=this.getSource().getX();i<=right.getSource().getX();i++){
            if (!this.IsSame(getChess(i, this.getSource().getY()))){
                ans.add(getChess(i,this.getSource().getY()).getSource());
            }
        }
        for (int i=this.getSource().getY();i>=up.getSource().getY();i--) {
            if (!this.IsSame(getChess(this.getSource().getX(), i))) {
                ans.add(getChess(this.getSource().getX(), i).getSource());
            }
        }
            for (int i=this.getSource().getY();i<=down.getSource().getY();i++){
                if (!this.IsSame(getChess(this.getSource().getX(), i))){
                    ans.add(getChess(this.getSource().getX(), i).getSource());
                }
        }


        return ans;
    }

}
