import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        //ChessboardPoint source , ChessColor chessColor , char name
        //super(source,chessColor,name,chessComponents);
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List CanMovePoint = new ArrayList<ChessboardPoint>();

            for(int e=0 ; e<Math.min(7-source.getX(),7-source.getY()); e++){//slope ,right down
                ChessboardPoint afterMove = source.offset(e+1,e+1);
                if(BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(chessColor)){
                    break;
                }
                CanMovePoint.add(afterMove);
                if(chessComponents[afterMove.getX()][afterMove.getY()].getName()!='_'){
                    break;
                }
            }
            for(int j=0 ; j<Math.min(7-source.getX(),source.getY());j++){//slope,left down
                ChessboardPoint afterMove = source.offset(j+1,-j-1);
                if(BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(chessColor)){
                    break;
                }
                CanMovePoint.add(afterMove);
                if(chessComponents[afterMove.getX()][afterMove.getY()].getName()!='_'){
                    break;
                }
            }

            for(int f=0 ; f<Math.min(source.getX(),source.getY());f++){//slope, left up
                ChessboardPoint afterMove = source.offset(-f-1,-f-1);
                if(BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(chessColor)){
                    break;
                }
                CanMovePoint.add(afterMove);
                if(chessComponents[afterMove.getX()][afterMove.getY()].getName()!='_'){
                    break;
                }
            }
            for(int i=0 ; i<Math.min(source.getX(),7-source.getY());i++){//slop,right up
                ChessboardPoint afterMove = source.offset(-i-1,i+1);
                if(BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(chessColor)){
                    break;
                }
                CanMovePoint.add(afterMove);
                if(chessComponents[afterMove.getX()][afterMove.getY()].getName()!='_'){
                    break;
                }
            }


        List noNullCanMovePoint = new ArrayList<ChessboardPoint>();
        for(int j=0 ; j<CanMovePoint.size();j++){
            if(CanMovePoint.get(j)!=null){
                noNullCanMovePoint.add(CanMovePoint.get(j));
            }
        }
        if(noNullCanMovePoint!=null){
            return noNullCanMovePoint;
        }else{
            return new ArrayList<>();
        }
    }
}
