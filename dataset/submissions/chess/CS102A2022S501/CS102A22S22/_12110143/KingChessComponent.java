import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
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
                if(chessComponents[i][j].name!='_'){
                    continue;
                }
                if(i==this.GetChessboardPoint().getX() && j==this.GetChessboardPoint().getY()){
                    continue;
                }
                if(Math.abs(this.GetChessboardPoint().getX()-i)==1 && Math.abs(this.GetChessboardPoint().getY()-j)==1){
                    res.add(new ChessboardPoint(i,j));
                }
                if(this.GetChessboardPoint().getX()==i && Math.abs(this.GetChessboardPoint().getY()-j)==1){
                    res.add(new ChessboardPoint(i,j));
                }
                if(Math.abs(this.GetChessboardPoint().getX()-i)==1 && this.GetChessboardPoint().getY()==j){
                    res.add(new ChessboardPoint(i,j));
                }

            }
        }
        return res;
    }


}
