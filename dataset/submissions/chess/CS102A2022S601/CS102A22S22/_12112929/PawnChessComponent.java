import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    ChessComponent[][]chessComponents;
    ChessColor chessColor;
    int t;
    public PawnChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, ChessComponent[][] chessComponents) {
        //super(chessColor);
        this.chessboardPoint=chessboardPoint;
        this.chessComponents=chessComponents;
        this.chessColor=chessColor;
        if(chessColor==ChessColor.BLACK)
        { name='P';
        t=1;}
        if(chessColor==ChessColor.WHITE)
        {  name='p';
        t=2;}
        setChessColor(chessColor);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>list=new ArrayList<>();
        int i=chessboardPoint.getX();
        int j=chessboardPoint.getY();
        if(t==1){
        if((!(chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()-1] instanceof EmptySlotComponent))&&((chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()-1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()))){
            if(i<=6&&j>=1){
            ChessboardPoint c1=new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()-1);
            list.add(c1);}
        }
        if((chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()] instanceof EmptySlotComponent)){
            if(i<=6&&j>=0&&j<=7){
            ChessboardPoint c2=new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY());
            list.add(c2);}
        }
            if((!(chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()+1] instanceof EmptySlotComponent))&&((chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()+1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()))){
                if(i<=6&&j<=6){
                ChessboardPoint c3=new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()+1);
                list.add(c3);}
            }
            if(((chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()] instanceof EmptySlotComponent))&&((chessComponents[chessboardPoint.getX()+2][chessboardPoint.getY()] instanceof EmptySlotComponent))){
                if(i<=5&&j>=0&&j<=7)
                { ChessboardPoint c4=new ChessboardPoint(chessboardPoint.getX()+2,chessboardPoint.getY());
                list.add(c4);}
            }
        }
        if(t==2){
            if((!(chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()-1] instanceof EmptySlotComponent))&&((chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()-1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()))){
                if(i>=1&&j>=1){
                ChessboardPoint c1=new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()-1);
                list.add(c1);}
            }
            if((chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()] instanceof EmptySlotComponent)){
                if(i>=1&&j>=0&&j<=7){
                ChessboardPoint c2=new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY());
                list.add(c2);}
            }
            if((!(chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()+1] instanceof EmptySlotComponent))&&((chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()+1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()))){
                if(i>=1&&j<=6){
                ChessboardPoint c3=new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()+1);
                list.add(c3);}
            }
            if(((chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()] instanceof EmptySlotComponent))&&((chessComponents[chessboardPoint.getX()-2][chessboardPoint.getY()] instanceof EmptySlotComponent))){
               if(i>=2&&j<=7&&j>=0){
                ChessboardPoint c4=new ChessboardPoint(chessboardPoint.getX()-2,chessboardPoint.getY());
                list.add(c4);}
            }
        }
        return list;
    }

}
