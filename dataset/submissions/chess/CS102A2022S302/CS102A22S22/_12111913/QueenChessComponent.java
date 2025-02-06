

import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans= new ArrayList<>();
        ChessComponent leftup=this.SearchLeftUp(this);
        ChessComponent rightup=this.SearchRightUp(this);
        ChessComponent leftdown=this.SearchLeftDown(this);
        ChessComponent rightdown=this.SearchRightDown(this);

        for (int i=this.getSource().getX()-leftup.getSource().getX();i>=0;i--){
            if (!this.IsSame(this.getChess(this.getSource().offset(-i, -i)))){
                ans.add(this.getSource().offset(-i,-i));
            }
        }
        for (int i=rightup.getSource().getX()-this.getSource().getX();i>=0;i--){
            if (!this.IsSame(getChess(this.getSource().offset(i, -i)))){
                ans.add(this.getSource().offset(i,-i));
            }
        }
        for (int i=this.getSource().getX()-leftdown.getSource().getX();i>=0;i--){
            if (!this.IsSame(this.getChess(this.getSource().offset(-i, i)))){
                ans.add(this.getSource().offset(-i,i));
            }
        }
        for (int i=rightdown.getSource().getX()-this.getSource().getX();i>=0;i--){
            if (!this.IsSame(getChess(this.getSource().offset(i, i)))){
                ans.add(this.getSource().offset(i,i));
            }
        }

        List<ChessboardPoint> ans1=new ArrayList<ChessboardPoint>();
        ChessComponent left=this.SearchLeft(this);
        ChessComponent right=this.SearchRight(this);
        ChessComponent up=this.SearchUp(this);
        ChessComponent down=this.SearchDown(this);
        for (int i=this.getSource().getX();i>=left.getSource().getX();i--){
            if (!this.IsSame(getChess(i, this.getSource().getY()))){
                ans1.add(getChess(i,this.getSource().getY()).getSource());
            }
        }
        for (int i=this.getSource().getX();i<=right.getSource().getX();i++){
            if (!this.IsSame(getChess(i, this.getSource().getY()))){
                ans1.add(getChess(i,this.getSource().getY()).getSource());
            }
        }
        for (int i=this.getSource().getY();i>=up.getSource().getY();i--) {
            if (!this.IsSame(getChess(this.getSource().getX(), i))) {
                ans1.add(getChess(this.getSource().getX(), i).getSource());
            }
        }
        for (int i=this.getSource().getY();i<=down.getSource().getY();i++){
            if (!this.IsSame(getChess(this.getSource().getX(), i))){
                ans1.add(getChess(this.getSource().getX(), i).getSource());
            }
        }
        ans.addAll(ans1);
        return ans;
    }

}
