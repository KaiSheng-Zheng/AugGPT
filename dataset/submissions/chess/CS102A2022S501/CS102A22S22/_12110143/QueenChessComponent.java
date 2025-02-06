import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
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
        char b=Character.isUpperCase(chessComponents[this.GetChessboardPoint().getX()][this.GetChessboardPoint().getY()].name)?'b':'B';
        char p=Character.isUpperCase(chessComponents[this.GetChessboardPoint().getX()][this.GetChessboardPoint().getY()].name)?'p':'P';
        System.out.println(chessComponents[this.GetChessboardPoint().getX()][this.GetChessboardPoint().getY()].name);
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
               if(i==this.GetChessboardPoint().getX() && j==this.GetChessboardPoint().getY()){
                   continue;
               }
                if(chessComponents[i][j].name!='_' &&  Character.isUpperCase(chessComponents[i][j].name)!= Character.isUpperCase(p)){
                    continue;
                }

                if(Math.abs(i-this.GetChessboardPoint().getX())==Math.abs(j-this.GetChessboardPoint().getY())){
                   if(i<this.GetChessboardPoint().getX() && j<this.GetChessboardPoint().getY()){
                       if(IsNullOnWay(i+1,j+1,p)){
                           res.add(new ChessboardPoint(i,j));
                       }
                   }
                   if(i<this.GetChessboardPoint().getX() && j>this.GetChessboardPoint().getY()){
                        if(IsNullOnWay(i+1,j-1,p)){
                            res.add(new ChessboardPoint(i,j));
                        }
                   }
                   if(i>this.GetChessboardPoint().getX() && j<this.GetChessboardPoint().getY()){
                        if(IsNullOnWay(i-1,j+1,p)){
                            res.add(new ChessboardPoint(i,j));
                        }
                   }
                   if(i>this.GetChessboardPoint().getX() && j>this.GetChessboardPoint().getY()){
                        if(IsNullOnWay(i-1,j-1,p)){
                            res.add(new ChessboardPoint(i,j));
                        }
                   }

               }
               if(i==this.GetChessboardPoint().getX()){
                   if(j<this.GetChessboardPoint().getY()){
                       if(isFullLine(i,j+1,p)){
                           res.add(new ChessboardPoint(i,j));
                       }
                   }
                   if(j>this.GetChessboardPoint().getY()){
                       if(isFullLine(i,j-1,p)){
                           res.add(new ChessboardPoint(i,j));
                       }
                   }

               }
                if(j==this.GetChessboardPoint().getY()){
                    if(i<this.GetChessboardPoint().getX()){
                        if(isFullRow(i+1,j,p)){
                            res.add(new ChessboardPoint(i,j));
                        }
                    }
                    if(i>this.GetChessboardPoint().getX()){
                        if(isFullRow(i-1,j,p)){
                            res.add(new ChessboardPoint(i,j));
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean isFullLine(int x,int y,char p){
        if(y<this.GetChessboardPoint().getY()){
            while (true){
                if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                    return true;
                }
                if(chessComponents[x][y].name!='_' && Character.isUpperCase(chessComponents[x][y].name)!= Character.isUpperCase(p)){
                    return  false;
                }
                y++;
            }
        }
        if(y>this.GetChessboardPoint().getY()){
            while (true){
                if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                    return true;
                }
                if(chessComponents[x][y].name!='_'&& Character.isUpperCase(chessComponents[x][y].name)!= Character.isUpperCase(p)){
                    return  false;
                }
                y--;
            }
        }
        return true;
    }

    public boolean isFullRow(int x,int y,char p){
        if(x <this.GetChessboardPoint().getX()){
            while (true){
                if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                    return true;
                }
                if(chessComponents[x][y].name!='_' && Character.isUpperCase(chessComponents[x][y].name)!= Character.isUpperCase(p)){
                    return  false;
                }
                x++;
            }
        }
        if(x>this.GetChessboardPoint().getX()){
            while (true){
                if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                    return true;
                }
                if(chessComponents[x][y].name!='_' && Character.isUpperCase(chessComponents[x][y].name)!= Character.isUpperCase(p) ){
                    return  false;
                }
                x--;
            }
        }
        return true;
    }

    public boolean IsNullOnWay(int x,int y,char p) {
        if(x<this.GetChessboardPoint().getX() && y<this.GetChessboardPoint().getY() ){
            while(true){
                if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                    return true;
                }
                if(chessComponents[x][y].name!='_' && Character.isUpperCase(chessComponents[x][y].name)!= Character.isUpperCase(p) ){
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
                if(chessComponents[x][y].name!='_' && Character.isUpperCase(chessComponents[x][y].name)!= Character.isUpperCase(p)){
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
                if(chessComponents[x][y].name!='_' && Character.isUpperCase(chessComponents[x][y].name)!= Character.isUpperCase(p)){
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
                if(chessComponents[x][y].name!='_' && Character.isUpperCase(chessComponents[x][y].name)!= Character.isUpperCase(p)){
                    return  false;
                }
                x--;
                y--;
            }
        }
        return true;
    }
}
