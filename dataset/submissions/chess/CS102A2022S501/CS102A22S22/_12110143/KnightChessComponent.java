import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
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
                /*if(chessComponents[x][y].name!='_'){
                    continue;
                }*/
                if(x==this.GetChessboardPoint().getX() && y==this.GetChessboardPoint().getY()){
                    continue;
                }
                if(Math.abs(x-this.GetChessboardPoint().getX())==2 &&Math.abs(y-this.GetChessboardPoint().getY())==1){
                    res.add(new ChessboardPoint(x,y));
                }
                if(Math.abs(y-this.GetChessboardPoint().getY())==2 &&Math.abs(x-this.GetChessboardPoint().getX())==1){
                    res.add(new ChessboardPoint(x,y));
                }
            }
        }
        return res;
    }
}
