import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        super(chessboardPoint,chessColor,name,chessComponents);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list=new ArrayList<>();
        ChessboardPoint destination;
        ChessboardPoint source;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                destination=new ChessboardPoint(i,j);
                source=this.getChessboardPoint();
                if(Math.abs(destination.getY()-source.getY())<=1&&Math.abs(destination.getX()-source.getX())<=1&&!(destination.getX()== source.getX()&&destination.getY()== source.getY()))
                {if(this.getChessboardPoint()!=new ChessboardPoint(i,j)&&chessComponents[i][j].getChessColor() != this.getChessColor() )
                    list.add(new ChessboardPoint(i,j));
            }}
        }
        return list;
    }

}
