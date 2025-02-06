import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    ChessComponent[][]chessComponents;
    ChessColor chessColor;
    public KnightChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, ChessComponent[][] chessComponents) {
        //super(chessColor);
        this.chessboardPoint=chessboardPoint;
        this.chessComponents=chessComponents;
        this.chessColor=chessColor;
        if(chessColor==ChessColor.BLACK)
            name='N';
        if(chessColor==ChessColor.WHITE)
            name='n';
        setSource(chessboardPoint);
        setChessColor(chessColor);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>list=new ArrayList<>();
       //ChessColor cc=chessComponents[chessboardPoint.getX()-2][chessboardPoint.getY()-1].getChessColor();
      //ChessColor cc1=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor();
        int i=chessboardPoint.getX();
        int j=chessboardPoint.getY();
        ChessboardPoint c1 = null;
        if(i>=2&&j>=1)
        {c1=new ChessboardPoint(chessboardPoint.getX()-2,chessboardPoint.getY()-1);
        if(chessComponents[chessboardPoint.getX()-2][chessboardPoint.getY()-1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        { list.add(c1);}}
        if(i>=2&&j<=6){
        c1=new ChessboardPoint(chessboardPoint.getX()-2,chessboardPoint.getY()+1);
        if(chessComponents[chessboardPoint.getX()-2][chessboardPoint.getY()+1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c1);}}
        if(i>=1&&j>=2){
        c1=new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()-2);
        if(chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()-2].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c1);}}
        if(i>=1&&j<=5){
         c1=new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()+2);
        if(chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()+2].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c1);}}
        if(i<=6&&j>=2){
        c1=new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()-2);
        if(chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()-2].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c1);}}
        if(i<=6&&j<=5){
        c1=new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()+2);
        if(chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()+2].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c1);}}
        if(i<=5&&j>=1){
         c1=new ChessboardPoint(chessboardPoint.getX()+2,chessboardPoint.getY()-1);
        if(chessComponents[chessboardPoint.getX()+2][chessboardPoint.getY()-1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c1);}}
        if(i<=5&&j<=6){
       c1=new ChessboardPoint(chessboardPoint.getX()+2,chessboardPoint.getY()+1);
        if(chessComponents[chessboardPoint.getX()+2][chessboardPoint.getY()+1].getChessColor()!=chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())
        {list.add(c1);}}
        return list;
    }
}
