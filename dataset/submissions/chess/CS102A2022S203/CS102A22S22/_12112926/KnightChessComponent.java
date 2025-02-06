import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor, char name,ChessboardPoint source) {
        this.name = name;
        setChessColor(chessColor);
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cor= new ArrayList<>();
        ChessboardPoint chess= new ChessboardPoint(getSource().getX(), getSource().getY());
        int[] x = {2,2,-2,-2,1,1,-1,-1};
        int[] y = {1,-1,-1,1,2,-2,2,-2};
        for(int i = 0;i<8;i++){
            if(chess.offset(x[i],y[i])!=null){
                if(getChessBoard()[chess.getX()+x[i]][chess.getY()+y[i]]instanceof EmptySlotComponent){
                    cor.add(new ChessboardPoint(chess.getX()+x[i],chess.getY()+y[i]));

                }
                else{
                    if(getChessBoard()[chess.getX()+x[i]][chess.getY()+y[i]].getChessColor()!=
                            getChessColor()){
                        cor.add(new ChessboardPoint(chess.getX()+x[i],chess.getY()+y[i]));
                    }
                }
            }
        }
        return cor;
    }
}
