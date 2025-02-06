import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans=new ArrayList<>();
        List<ChessComponent> test=new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (this.getSource().getX()-i==1&&this.getSource().getY()-j==2){test.add(getChess(i,j));}
                if (this.getSource().getX()-i==1&&this.getSource().getY()-j==-2){test.add(getChess(i,j));}
                if (this.getSource().getX()-i==-1&&this.getSource().getY()-j==2){test.add(getChess(i,j));}
                if (this.getSource().getX()-i==-1&&this.getSource().getY()-j==-2){test.add(getChess(i,j));}
                if (this.getSource().getX()-i==2&&this.getSource().getY()-j==1){test.add(getChess(i,j));}
                if (this.getSource().getX()-i==2&&this.getSource().getY()-j==-1){test.add(getChess(i,j));}
                if (this.getSource().getX()-i==-2&&this.getSource().getY()-j==1){test.add(getChess(i,j));}
                if (this.getSource().getX()-i==-2&&this.getSource().getY()-j==-1){test.add(getChess(i,j));}

            }
        }

        for (int i=0;i<test.size();i++){
            if (!this.IsSame(test.get(i))){
               ans.add(test.get(i).getSource());
            }
        }


        return ans;
    }

}
