import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        for(int i =0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessboardPoint des=new ChessboardPoint(i,j);
                if(this.canMoveTo(ConcreteChessGame.getStaticchessComponents(),des)){
                    result.add(des);
                }
            }
        }
        return result;
    }

    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor, name);
    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if(destination.getX()>7||destination.getX()<0||destination.getY()>7||destination.getY()<0){return false;}
        if (Math.abs(source.getX() - destination.getX())==1&&
                Math.abs(source.getY() - destination.getY())==2) {
            if(!chessComponents[destination.getX()][destination.getY()].getChessColor().
                    equals(chessComponents[source.getX()][source.getY()].getChessColor())){
                return true;
            }
        } else if (Math.abs(source.getX() - destination.getX())==2&&
                Math.abs(source.getY() - destination.getY())==1) {
            if(!chessComponents[destination.getX()][destination.getY()].getChessColor().
                    equals(chessComponents[source.getX()][source.getY()].getChessColor())){
                return true;
            }
        }
        return false;
    }

    public ChessboardPoint getChessboardPoint(){
        return super.getChessboardPoint();
    }

    public ChessColor getChessColor(){
        return super.getChessColor();
    }
}