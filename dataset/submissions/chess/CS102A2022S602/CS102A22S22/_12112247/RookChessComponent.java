import java.util.ArrayList;
import java.util.List;
public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        //ChessboardPoint source , ChessColor chessColor , char name
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List CanMovePoint = new ArrayList<ChessboardPoint>();

            for(int a=0 ; a<7-source.getX(); a++){//only change x, move down
                ChessboardPoint afterMove = source.offset(a+1,0);
                if(BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(chessColor)){
                    break;
                }
                CanMovePoint.add(afterMove);
                if(chessComponents[afterMove.getX()][afterMove.getY()].getName()!='_'){
                    break;
                }
            }
            for(int c=0; c<7-source.getY() ; c++){//only change y,move right
                ChessboardPoint afterMove = source.offset(0,c+1);
                if(BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(chessColor)){
                    break;
                }
                CanMovePoint.add(afterMove);
                if(chessComponents[afterMove.getX()][afterMove.getY()].getName()!='_'){
                    break;
                }
            }
            for(int d=0;d<source.getY();d++){//only change y, move left
                ChessboardPoint afterMove = source.offset(0,-d-1);
                if(BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(chessColor)){
                    break;
                }
                CanMovePoint.add(afterMove);
                if(chessComponents[afterMove.getX()][afterMove.getY()].getName()!='_'){
                    break;
                }
            }

            for(int b=0 ; b<source.getX() ; b++){//only change x, move up
                ChessboardPoint afterMove = source.offset(-b-1,0);
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
