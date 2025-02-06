
import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
        public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans= new ArrayList<>();
        ChessComponent leftup=this.SearchLeftUp(this);
        ChessComponent rightup=this.SearchRightUp(this);
        ChessComponent leftdown=this.SearchLeftDown(this);
        ChessComponent rightdown=this.SearchRightDown(this);

        for (int i=1;i<7;i++){
            if (getChess(this.getSource().getX()+i,this.getSource().getY()+i)==null||getChess(this.getSource().getX()+i,this.getSource().getY()+i).IsSame(this)){
                break;
            }
            else if (getChess(this.getSource().getX()+i,this.getSource().getY()+i).getChessColor()==ChessColor.NONE){
                ans.add(getChess(this.getSource().getX()+i,this.getSource().getY()+i).getSource());
            }
            else if (getChess(this.getSource().getX()+i,this.getSource().getY()+i).IsEnemy(this)){
                ans.add(getChess(this.getSource().getX()+i,this.getSource().getY()+i).getSource());
                break;
            }
        }
        for (int i=1;i<7;i++){
            if (getChess(this.getSource().getX()+i,this.getSource().getY()-i)==null||getChess(this.getSource().getX()+i,this.getSource().getY()-i).IsSame(this)){
                break;
            }
            else if (getChess(this.getSource().getX()+i,this.getSource().getY()-i).getChessColor()==ChessColor.NONE){
                ans.add(getChess(this.getSource().getX()+i,this.getSource().getY()-i).getSource());
            }
            else if (getChess(this.getSource().getX()+i,this.getSource().getY()-i).IsEnemy(this)){
                ans.add(getChess(this.getSource().getX()+i,this.getSource().getY()-i).getSource());
                break;
            }
        }
        for (int i=1;i<7;i++){
            if (getChess(this.getSource().getX()-i,this.getSource().getY()+i)==null||getChess(this.getSource().getX()-i,this.getSource().getY()+i).IsSame(this)){
                break;
            }
            else if (getChess(this.getSource().getX()-i,this.getSource().getY()+i).getChessColor()==ChessColor.NONE){
                ans.add(getChess(this.getSource().getX()-i,this.getSource().getY()+i).getSource());
            }
            else if (getChess(this.getSource().getX()-i,this.getSource().getY()+i).IsEnemy(this)){
                ans.add(getChess(this.getSource().getX()-i,this.getSource().getY()+i).getSource());
                break;
            }
        }
        for (int i=1;i<7;i++){
            if (getChess(this.getSource().getX()-i,this.getSource().getY()-i)==null||getChess(this.getSource().getX()-i,this.getSource().getY()-i).IsSame(this)){
                break;
            }
            else if (getChess(this.getSource().getX()-i,this.getSource().getY()-i).getChessColor()==ChessColor.NONE){
                ans.add(getChess(this.getSource().getX()-i,this.getSource().getY()-i).getSource());
            }
            else if (getChess(this.getSource().getX()-i,this.getSource().getY()-i).IsEnemy(this)){
                ans.add(getChess(this.getSource().getX()-i,this.getSource().getY()-i).getSource());
                break;
            }
        }




            return ans;
        }



}
