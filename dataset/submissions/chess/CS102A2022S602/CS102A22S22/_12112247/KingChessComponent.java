import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{//8 kinds
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        //ChessboardPoint source , ChessColor chessColor , char name
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List CanMovePoint = new ArrayList<ChessboardPoint>();

        //ChessboardPoint beenMove = new ChessboardPoint(source.getX(),source.getY());CanMovePoint.add(source.offset(-1,1));

            CanMovePoint.add(canMoveToHelp(-1,-1));
            CanMovePoint.add(canMoveToHelp(-1,0));
            CanMovePoint.add(canMoveToHelp(-1,1));
            CanMovePoint.add(canMoveToHelp(0,-1));
            CanMovePoint.add(canMoveToHelp(0,1));
            CanMovePoint.add(canMoveToHelp(1,-1));
            CanMovePoint.add(canMoveToHelp(1,0));
            CanMovePoint.add(canMoveToHelp(1,1));


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









        /*ChessboardPoint afterMove1 = source.offset(-1,1);
        if(afterMove1!=null && !BlackOrWriteOrNone(chessComponents[afterMove1.getX()][afterMove1.getY()].getName()).equals(chessColor)){
            CanMovePoint.add(afterMove1);
        }
        //CanMovePoint.add(source.offset(0,1));
        ChessboardPoint afterMove2 = source.offset(0,1);
        if(afterMove2!=null && !BlackOrWriteOrNone(chessComponents[afterMove2.getX()][afterMove2.getY()].getName()).equals(chessColor)){
            CanMovePoint.add(afterMove2);
        }
        ChessboardPoint afterMove3 = source.offset(1,1);
        if(afterMove3!=null && !BlackOrWriteOrNone(chessComponents[afterMove3.getX()][afterMove3.getY()].getName()).equals(chessColor)){
            CanMovePoint.add(afterMove3);
        }
        ChessboardPoint afterMove4 = source.offset(-1,0);
        if(afterMove4!=null && !BlackOrWriteOrNone(chessComponents[afterMove4.getX()][afterMove4.getY()].getName()).equals(chessColor)){
            CanMovePoint.add(afterMove4);
        }
        ChessboardPoint afterMove5 = source.offset(1,0);
        if(afterMove5!=null && !BlackOrWriteOrNone(chessComponents[afterMove5.getX()][afterMove5.getY()].getName()).equals(chessColor)){
            CanMovePoint.add(afterMove5);
        }
        ChessboardPoint afterMove6 = source.offset(-1,-1);
        if(afterMove6!=null && !BlackOrWriteOrNone(chessComponents[afterMove6.getX()][afterMove6.getY()].getName()).equals(chessColor)){
            CanMovePoint.add(afterMove6);
        }
        ChessboardPoint afterMove7 = source.offset(0,-1);
        if(afterMove7!=null && !BlackOrWriteOrNone(chessComponents[afterMove7.getX()][afterMove7.getY()].getName()).equals(chessColor)){
            CanMovePoint.add(afterMove7);
        }
        ChessboardPoint afterMove8 = source.offset(1,-1);
        if(afterMove8!=null && !BlackOrWriteOrNone(chessComponents[afterMove8.getX()][afterMove8.getY()].getName()).equals(chessColor)){
            CanMovePoint.add(afterMove8);}*/


    /*CanMovePoint.add(source.offset(1,1));
    CanMovePoint.add(source.offset(-1,0));
    CanMovePoint.add(source.offset(1,0));
    CanMovePoint.add(source.offset(-1,-1));
    CanMovePoint.add(source.offset(0,-1));
    CanMovePoint.add(source.offset(1,-1));*/





