import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        super(chessboardPoint,chessColor,name,chessComponents);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list=new ArrayList<>();
        ChessboardPoint destination;
        ChessboardPoint sourse;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                destination=new ChessboardPoint(i,j);
                sourse=this.getChessboardPoint();
                if((destination.getX()- sourse.getX()==1||destination.getX()- sourse.getX()==-1)&&(destination.getY()-sourse.getY()==2||destination.getY()-sourse.getY()==-2)&&chessComponents[i][j].getChessColor() != this.getChessColor())
                    list.add(new ChessboardPoint(i,j));
                else if((destination.getX()- sourse.getX()==2||destination.getX()- sourse.getX()==-2)&&(destination.getY()-sourse.getY()==1||destination.getY()-sourse.getY()==-1)&&chessComponents[i][j].getChessColor() != this.getChessColor())
                    list.add(new ChessboardPoint(i,j));
            }
        }
        return list;
    }

}
