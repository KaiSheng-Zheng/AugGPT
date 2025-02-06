import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
        super(chessboardPoint,
                chessColor,
                name);
    }
    private ChessComponent[][] chessComponents;
    public void SetChessComponent(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j].name!='_' && chessComponents[i][j].name!='k' && chessComponents[i][j].name!='K'){
                    continue;
                }
                if(i==this.GetChessboardPoint().getX() && j==this.GetChessboardPoint().getY()){
                    continue;
                }
                if(Math.abs(i-this.GetChessboardPoint().getX())==Math.abs(j-this.GetChessboardPoint().getY())){
                    if(i<this.GetChessboardPoint().getX() && j<this.GetChessboardPoint().getY()){
                      if(IsNullOnWay(i+1,j+1)){
                          res.add(new ChessboardPoint(i,j));
                      }
                    }
                    if(i<this.GetChessboardPoint().getX() && j>this.GetChessboardPoint().getY()){
                        if(IsNullOnWay(i+1,j-1)){
                            res.add(new ChessboardPoint(i,j));
                        }

                    }
                    if(i>this.GetChessboardPoint().getX() && j<this.GetChessboardPoint().getY()){
                        if(IsNullOnWay(i-1,j+1)){
                            res.add(new ChessboardPoint(i,j));
                        }

                    }
                    if(i>this.GetChessboardPoint().getX() && j>this.GetChessboardPoint().getY()){
                        if(IsNullOnWay(i-1,j-1)){
                            res.add(new ChessboardPoint(i,j));
                        }
                    }
                }
            }
        }
        return res;
    }
   public boolean IsNullOnWay(int x,int y) {
       if(x<this.GetChessboardPoint().getX() && y<this.GetChessboardPoint().getY() ){
           while(true){
               if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                   return true;
               }
               if(chessComponents[x][y].name!='_'){
                   return  false;
               }
               x++;
               y++;
           }
       }
       if(x<this.GetChessboardPoint().getX() && y>this.GetChessboardPoint().getY() ){
           while(true){
               if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                   return true;
               }
               if(chessComponents[x][y].name!='_'){
                   return  false;
               }
               x++;
               y--;
           }
       }
       if(x>this.GetChessboardPoint().getX() && y<this.GetChessboardPoint().getY() ){
           while(true){
               if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                   return true;
               }
               if(chessComponents[x][y].name!='_'){
                   return  false;
               }
               x--;
               y++;
           }
       }
       if(x>this.GetChessboardPoint().getX() && y>this.GetChessboardPoint().getY() ){
           while(true){
               if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                   return true;
               }
               if(chessComponents[x][y].name!='_'){

                   return  false;
               }
               x--;
               y--;
           }
       }
       return true;
   }

}
