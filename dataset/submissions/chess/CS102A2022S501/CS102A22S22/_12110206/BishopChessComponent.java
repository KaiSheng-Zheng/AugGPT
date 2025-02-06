import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(int i, int j, char identity){
        super(i,j,identity);
        this.name='B';
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> all = new ArrayList<>();
        all.addAll(canMoveToPart(-1,-1));
        all.addAll(canMoveToPart(1,1));
        all.addAll(canMoveToPart(-1,1));
        all.addAll(canMoveToPart(1,-1));
        return all;
    }
    public List<ChessboardPoint> canMoveToPart(int a,int b) {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for(int i=1;i<=7;i++){
            int xOriginal = this.getSource().getX();
            int yOriginal = this.getSource().getY();
            int x = xOriginal + a*i;
            int y = yOriginal + b*i;
            if(x<0||x>7||y<0||y>7){
                break;
            }
            if(chessboard[x][y].name!='_'){
                if(chessboard[x][y].chessColor()==this.chessColor()){
                    break;
                }
                else{
                    canMoveTo.add(this.getSource().offset(a*i,b*i));
                    break;
                }
            }
            else{
                canMoveTo.add(this.getSource().offset(a*i,b*i));
            }
        }
        // while(canMoveTo.contains(null)){
        //     canMoveTo.remove(null);
        // }
        return canMoveTo;
    }
}
