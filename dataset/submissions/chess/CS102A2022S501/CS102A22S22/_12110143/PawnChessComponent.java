import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
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
        int dircet=Character.isUpperCase(chessComponents[this.GetChessboardPoint().getX()][this.GetChessboardPoint().getY()].name)?1:-1;
        char n=Character.isUpperCase(chessComponents[this.GetChessboardPoint().getX()][this.GetChessboardPoint().getY()].name)?'n':'N';

        List<ChessboardPoint> res=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(i==this.GetChessboardPoint().getX() && j==this.GetChessboardPoint().getY()){
                    continue;
                }
                if(i-this.GetChessboardPoint().getX()==dircet*1 &&  j==this.GetChessboardPoint().getY()){
                    if(chessComponents[i][j].name =='_' || chessComponents[i][j].name ==n){
                        res.add(new ChessboardPoint(i,j));
                    }

                }
                if(i-this.GetChessboardPoint().getX()==dircet*2 &&  j==this.GetChessboardPoint().getY()){
                    if(chessComponents[i][j].name =='_' && chessComponents[i-dircet*1][j].name =='_'){
                        res.add(new ChessboardPoint(i,j));
                    }

                }
                if(i-this.GetChessboardPoint().getX()==dircet*1 &&  j-this.GetChessboardPoint().getY()==dircet*1){
                    if((chessComponents[i][j].name =='_'  || chessComponents[i][j].name ==n)&& chessComponents[i][j-dircet].name =='_'){
                        res.add(new ChessboardPoint(i,j));
                    }

                }
            }
        }
        return res;
    }
}
