

import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans=new ArrayList<ChessboardPoint>();
        List<ChessComponent> tset=new ArrayList<>();
       for (int i=0;i<8;i++){
           for (int j=0;j<8;j++){
               if (this.getSource().getX()-i<=1&&this.getSource().getX()-i>=-1&&this.getSource().getY()-j>=-1&&this.getSource().getY()-j<=1)
               {
                   tset.add(getChess(i,j));
               }
           }
       }



        for (int i=0;i<tset.size();i++){
            if (!this.IsSame(tset.get(i))){
                ans.add(tset.get(i).getSource());
            }
        }


        return ans;
    }

}
