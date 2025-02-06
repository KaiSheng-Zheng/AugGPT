import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    ChessComponent[][]chessComponents;
    public QueenChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, ChessComponent[][] chessComponents) {
        //super(chessColor);
        this.chessboardPoint=chessboardPoint;
        this.chessComponents=chessComponents;
        if(chessColor==ChessColor.BLACK)
            name='Q';
        if(chessColor==ChessColor.WHITE)
            name='q';
        setSource(chessboardPoint);
        setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>list=new ArrayList<>();
        for (int i = chessboardPoint.getX() - 1; i >= 0; i--) {
            if ((chessComponents[i][chessboardPoint.getY()] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(i, chessboardPoint.getY());

            }
            if (!(chessComponents[i][chessboardPoint.getY()] instanceof EmptySlotComponent) || i == 0) {
                ChessboardPoint c = new ChessboardPoint(i, chessboardPoint.getY());
                if ((chessComponents[i][chessboardPoint.getY()].getChessColor() != chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())) {
                    for (int j = i; j < chessboardPoint.getX(); j++) {
                        list.add(new ChessboardPoint(j, chessboardPoint.getY()));
                    }
                }
                break;
            }
        }
        for (int i = chessboardPoint.getX() + 1; i < 8; i++) {
            if ((chessComponents[i][chessboardPoint.getY()] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(i, chessboardPoint.getY());
                list.add(c);
            }
            if (!(chessComponents[i][chessboardPoint.getY()] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(i, chessboardPoint.getY());
                if ((chessComponents[i][chessboardPoint.getY()].getChessColor() != chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())) {
                    list.add(c);
                }
                break;
            }
        }
        for (int i = chessboardPoint.getY() - 1; i >= 0; i--) {
            if ((chessComponents[chessboardPoint.getX()][i] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(chessboardPoint.getX(), i);
            }
            if (!(chessComponents[chessboardPoint.getX()][i] instanceof EmptySlotComponent) || i == 0) {
                ChessboardPoint c = new ChessboardPoint(chessboardPoint.getX(), i);
                if ((chessComponents[chessboardPoint.getX()][i].getChessColor() != chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())) {
                    for (int j = i; j < chessboardPoint.getY(); j++) {
                        list.add(new ChessboardPoint(chessboardPoint.getX(), j));
                    }
                }
                break;
            }
        }
        for (int i = chessboardPoint.getY() + 1; i < 8; i++) {
            if ((chessComponents[chessboardPoint.getX()][i] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(chessboardPoint.getX(), i);
                list.add(c);
            }
            if (!(chessComponents[chessboardPoint.getX()][i] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(chessboardPoint.getX(), i);
                if ((chessComponents[chessboardPoint.getX()][i].getChessColor() != chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())) {
                    list.add(c);
                }
                break;
            }
        }
        List<ChessboardPoint>list1=new ArrayList<>();
        int l1=0,l2=0,l3=0,l4=0;
        int d1=0,d2=0,d3=0,d4=0;
        for(int i=1;i<=Math.min(chessboardPoint.getX(),chessboardPoint.getY());i++){
            if ((chessComponents[chessboardPoint.getX()-i][chessboardPoint.getY()-i] instanceof EmptySlotComponent)){
                ChessboardPoint c=new ChessboardPoint(chessboardPoint.getX()-i,chessboardPoint.getY()-i);
                list.add(c);
            }
            if (!(chessComponents[chessboardPoint.getX()-i][chessboardPoint.getY()-i] instanceof EmptySlotComponent)){
                ChessboardPoint c=new ChessboardPoint(chessboardPoint.getX()-i,chessboardPoint.getY()-i);
                if((chessComponents[chessboardPoint.getX()-i][chessboardPoint.getY()-i].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()))
                {list.add(c);}
                break;
            }
        }
        l1=list.size();
        d1=l1;
        for(int i=1;i<=7-Math.max(chessboardPoint.getX(),chessboardPoint.getY());i++){
            if ((chessComponents[chessboardPoint.getX()+i][chessboardPoint.getY()+i] instanceof EmptySlotComponent)){
                ChessboardPoint c=new ChessboardPoint(chessboardPoint.getX()+i,chessboardPoint.getY()+i);
                list.add(c);
            }
            if (!(chessComponents[chessboardPoint.getX()+i][chessboardPoint.getY()+i] instanceof EmptySlotComponent)){
                ChessboardPoint c=new ChessboardPoint(chessboardPoint.getX()+i,chessboardPoint.getY()+i);
                if((chessComponents[chessboardPoint.getX()+i][chessboardPoint.getY()+i].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()))
                {list.add(c);}
                break;
            }
        }
        l2=list.size();
        d2=l2-l1;
        for(int i=1;i<=Math.min(chessboardPoint.getX(),7-chessboardPoint.getY());i++){
            if ((chessComponents[chessboardPoint.getX()-i][chessboardPoint.getY()+i] instanceof EmptySlotComponent)){
                ChessboardPoint c=new ChessboardPoint(chessboardPoint.getX()-i,chessboardPoint.getY()+i);
                list.add(c);
            }
            if (!(chessComponents[chessboardPoint.getX()-i][chessboardPoint.getY()+i] instanceof EmptySlotComponent)){
                ChessboardPoint c=new ChessboardPoint(chessboardPoint.getX()-i,chessboardPoint.getY()+i);
                if((chessComponents[chessboardPoint.getX()-i][chessboardPoint.getY()+i].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()))
                {list.add(c);}
                break;
            }
        }
        l3=list.size();
        d3=l3-l2;
        for(int i=1;i<=Math.min(chessboardPoint.getY(),7-chessboardPoint.getX());i++){
            if ((chessComponents[chessboardPoint.getX()+i][chessboardPoint.getY()-i] instanceof EmptySlotComponent)){
                ChessboardPoint c=new ChessboardPoint(chessboardPoint.getX()+i,chessboardPoint.getY()-i);
                list.add(c);
            }
            if (!(chessComponents[chessboardPoint.getX()+i][chessboardPoint.getY()-i] instanceof EmptySlotComponent)){
                ChessboardPoint c=new ChessboardPoint(chessboardPoint.getX()+i,chessboardPoint.getY()-i);
                if((chessComponents[chessboardPoint.getX()+i][chessboardPoint.getY()-i].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()))
                {list.add(c);}
                break;
            }
        }
        l4=list.size();
        d4=l4-l3;
        if(d1>=d3){
            for(int i=0;i<d1-d3;i++){
                list1.add(new ChessboardPoint(chessboardPoint.getX()-d1+i,chessboardPoint.getY()-d1+i));
            }
            for(int i=0;i<d3;i++){
                list1.add(new ChessboardPoint(chessboardPoint.getX()-d3+i,chessboardPoint.getY()-d3+i));
                list1.add(new ChessboardPoint(chessboardPoint.getX()-d3+i,chessboardPoint.getY()+d3-i));
            }
        }
        if(d3>d1){
            for(int i=0;i<d3-d1;i++){
                list1.add(new ChessboardPoint(chessboardPoint.getX()-d3+i,chessboardPoint.getY()+d3-i));
            }
            for(int i=0;i<d1;i++){
                list1.add(new ChessboardPoint(chessboardPoint.getX()-d1+i,chessboardPoint.getY()-d1+i));
                list1.add(new ChessboardPoint(chessboardPoint.getX()-d1+i,chessboardPoint.getY()+d1-i));
            }
        }
        if(d2>=d4){
            for(int i=1;i<=d4;i++){
                list1.add(new ChessboardPoint(chessboardPoint.getX()+i,chessboardPoint.getY()-i));
                list1.add(new ChessboardPoint(chessboardPoint.getX()+i,chessboardPoint.getY()+i));
            }
            for(int i=1;i<=d2-d4;i++){
                list1.add(new ChessboardPoint(chessboardPoint.getX()+i+d4,chessboardPoint.getY()+i+d4));
            }
        }
        if(d2<d4){
            for(int i=1;i<=d2;i++){
                list1.add(new ChessboardPoint(chessboardPoint.getX()+i,chessboardPoint.getY()-i));
                list1.add(new ChessboardPoint(chessboardPoint.getX()+i,chessboardPoint.getY()+i));
            }
            for(int i=1;i<=d4-d2;i++){
                list1.add(new ChessboardPoint(chessboardPoint.getX()+i+d2,chessboardPoint.getY()-i-d2));
            }
        }
        return list;
    }
}
