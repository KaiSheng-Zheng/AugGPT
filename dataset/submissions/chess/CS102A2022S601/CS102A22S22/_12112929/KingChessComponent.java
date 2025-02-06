import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    ChessComponent[][]chessComponents;
    public KingChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, ChessComponent[][] chessComponents) {
       // super(chessColor);
        this.chessboardPoint=chessboardPoint;
        this.chessComponents=chessComponents;
        if(chessColor==ChessColor.BLACK)
            name='K';
        if(chessColor==ChessColor.WHITE)
            name='k';
        setSource(chessboardPoint);
        setChessColor(chessColor);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>list=new ArrayList<>();
        int i=chessboardPoint.getX();
        int j=chessboardPoint.getY();
        if(i>=1&&j>=1){
        ChessboardPoint c1=new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()-1);
        if(chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()-1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c1);}}
        if(i>=1&&j<=7&&j>=0){
        ChessboardPoint c2=new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY());
        if((chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()))
        {list.add(c2);}}
        if(i>=1&&j<=6){
        ChessboardPoint c3=new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()+1);
        if(chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()+1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c3);}}
        if(i>=0&&j>=1){
        ChessboardPoint c4=new ChessboardPoint(chessboardPoint.getX(),chessboardPoint.getY()-1);
        if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()-1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c4);}}
        if(i>=0&&j<=6){
        ChessboardPoint c5=new ChessboardPoint(chessboardPoint.getX(),chessboardPoint.getY()+1);
        if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()+1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c5);}}
        if(i<=6&&j>=1){
        ChessboardPoint c6=new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()-1);
        if(chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()-1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c6);}}
        if(i<=6&&j>=0&&j<=7){
        ChessboardPoint c7=new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY());
        if(chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c7);}}
        if(i<=6&&j<=6){
        ChessboardPoint c8=new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()+1);
        if(chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()+1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c8);}}
        return list;

    }
}
