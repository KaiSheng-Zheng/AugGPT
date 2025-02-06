import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint){
    super();
    setChessColor(chessColor);
    setSource(chessboardPoint);
        if(chessColor==ChessColor.BLACK)name='B';
        if(chessColor==ChessColor.WHITE)name='b';
}

@Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> cMT=new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if(onBoard(getSource().getX()+i,getSource().getY()+i)){
                if(getColor(getSource().getX()+i,getSource().getY()+i)!=getChessColor()){
                    cMT.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
                }
                if(getColor(getSource().getX()+i,getSource().getY()+i)!=ChessColor.NONE)break;
            }else break;
        }
        for (int i = 1; i < 8; i++) {
            if(onBoard(getSource().getX()-i,getSource().getY()+i)){
                if(getColor(getSource().getX()-i,getSource().getY()+i)!=getChessColor()){
                    cMT.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
                }
                if(getColor(getSource().getX()-i,getSource().getY()+i)!=ChessColor.NONE)break;
            }else break;
        }
        for (int i = 1; i < 8; i++) {
            if(onBoard(getSource().getX()+i,getSource().getY()-i)){
                if(getColor(getSource().getX()+i,getSource().getY()-i)!=getChessColor()){
                    cMT.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));
                }
                if(getColor(getSource().getX()+i,getSource().getY()-i)!=ChessColor.NONE)break;
            }else break;
        }
        for (int i = 1; i < 8; i++) {
            if(onBoard(getSource().getX()-i,getSource().getY()-i)){
                if(getColor(getSource().getX()-i,getSource().getY()-i)!=getChessColor()){
                    cMT.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
                }
                if(getColor(getSource().getX()-i,getSource().getY()-i)!=ChessColor.NONE)break;
            }else break;
        }
        return cMT;
    }
}
