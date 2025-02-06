import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        super();
        setChessColor(chessColor);
        setSource(chessboardPoint);
        if(chessColor==ChessColor.BLACK)name='Q';
        if(chessColor==ChessColor.WHITE)name='q';
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
        for (int i = 1; i < 8; i++) {
            if(onBoard(getSource().getX()+i,getSource().getY())){
                if(getColor(getSource().getX()+i,getSource().getY())!=getChessColor()){
                    cMT.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
                }
                if(getColor(getSource().getX()+i,getSource().getY())!=ChessColor.NONE)break;
            }else break;
        }
        for (int i = 1; i < 8; i++) {
            if(onBoard(getSource().getX()-i,getSource().getY())){
                if(getColor(getSource().getX()-i,getSource().getY())!=getChessColor()){
                    cMT.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
                }
                if(getColor(getSource().getX()-i,getSource().getY())!=ChessColor.NONE)break;
            }else break;
        }
        for (int i = 1; i < 8; i++) {
            if(onBoard(getSource().getX(),getSource().getY()-i)){
                if(getColor(getSource().getX(),getSource().getY()-i)!=getChessColor()){
                    cMT.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
                }
                if(getColor(getSource().getX(),getSource().getY()-i)!=ChessColor.NONE)break;
            }else break;
        }
        for (int i = 1; i < 8; i++) {
            if(onBoard(getSource().getX(),getSource().getY()+i)){
                if(getColor(getSource().getX(),getSource().getY()+i)!=getChessColor()){
                    cMT.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
                }
                if(getColor(getSource().getX(),getSource().getY()+i)!=ChessColor.NONE)break;
            }else break;
        }
        return cMT;
    }
}
