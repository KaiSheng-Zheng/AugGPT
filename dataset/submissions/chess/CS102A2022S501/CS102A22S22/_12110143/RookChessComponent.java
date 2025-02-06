import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
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
        for(int x=0;x<8;x++){
            for(int y=0;y<8;y++){
                if(chessComponents[x][y].name!='_' && chessComponents[x][y].name!='b' && chessComponents[x][y].name!='B'){
                    continue;
                }
                if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                    continue;
                }
                if(x==this.GetChessboardPoint().getX()){
                    boolean flag=true;
                    if(y<this.GetChessboardPoint().getY()){
                        for(int k=y+1;k<this.GetChessboardPoint().getY();k++){
                            if(chessComponents[x][k].name!='_'){
                                flag=false;
                                continue;
                            }
                        }
                    }else{
                        for(int k=y-1;k>this.GetChessboardPoint().getY();k--){
                            if(chessComponents[x][k].name!='_'){
                                flag=false;
                                continue;
                            }
                        }
                    }
                    if(flag)
                        res.add(new ChessboardPoint(x,y));
                }
                if(y==this.GetChessboardPoint().getY()){
                    boolean flag=true;
                    if(x<this.GetChessboardPoint().getX()){
                        for(int k=x+1;k<this.GetChessboardPoint().getX();k++){
                            if(chessComponents[k][y].name!='_'){
                                flag=false;
                                continue;
                            }
                        }
                    }else {
                        for(int k=x-1;k>this.GetChessboardPoint().getX();k--){
                            if(chessComponents[k][y].name!='_'){
                                flag=false;
                                continue;
                            }
                        }
                    }
                    if(flag)
                        res.add(new ChessboardPoint(x,y));
                }
            }
        }
        return res;
    }

}
