import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

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

    public KingChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor, name);
    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = destination.getX();
        int y2 = destination.getY();

        if(x2>7||x2<0||y2>7||y2<0){return false;}
        if(Math.abs(x2-x1)<=1&&Math.abs(y2-y1)<=1&&chessComponents[x1][y1].getChessColor()!=chessComponents[x2][y2].getChessColor()){
            return true;
        }else return false;}

    public ChessboardPoint getChessboardPoint(){
        return super.getChessboardPoint();
    }

    public ChessColor getChessColor(){
        return super.getChessColor();
    }
}
