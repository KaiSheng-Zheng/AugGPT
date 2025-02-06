import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor chessColor, char name,ChessboardPoint source) {
        this.name = name;
        setChessColor(chessColor);
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cor= new ArrayList<>();
        ChessboardPoint chess= new ChessboardPoint(getSource().getX(), getSource().getY());
        int[] x = {1,-1,0,0};
        int[] y = {0,0,-1,1};
        int n = 1;
            for(int i = 0;i<4;i++){
                while(chess.offset(n*x[i],n*y[i])!=null){
                if(getChessBoard()[chess.getX()+n*x[i]][chess.getY()+n*y[i]]instanceof EmptySlotComponent){
                    cor.add(new ChessboardPoint(chess.getX()+n*x[i],chess.getY()+n*y[i]));

                }
                else{
                    if(getChessBoard()[chess.getX()+n*x[i]][chess.getY()+n*y[i]].getChessColor()!=
                            getChessColor()){
                        cor.add(new ChessboardPoint(chess.getX()+n*x[i],chess.getY()+n*y[i]));
                        break;
                    }
                    else{
                        break;
                    }
                }
                n++;
            }
                n=1;
        }
        return cor;
    }
}
