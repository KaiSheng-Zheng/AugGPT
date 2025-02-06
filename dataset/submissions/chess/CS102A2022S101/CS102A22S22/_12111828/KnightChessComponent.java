import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setChessColor(chessColor);setSource(source);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move=new ArrayList<>();
        ChessboardPoint offset1=getSource().offset(-2,-1);
        if(offset1!=null)
            if(chessComponent[offset1.getX()][offset1.getY()].getName()=='_'||chessComponent[offset1.getX()][offset1.getY()].getChessColor()!=getChessColor())
                move.add(offset1);
        ChessboardPoint offset2=getSource().offset(-2,1);
        if(offset2!=null)
            if(chessComponent[offset2.getX()][offset2.getY()].getName()=='_'||chessComponent[offset2.getX()][offset2.getY()].getChessColor()!=getChessColor())
                move.add(offset2);
        ChessboardPoint offset3=getSource().offset(-1,-2);
        if(offset3!=null)
            if(chessComponent[offset3.getX()][offset3.getY()].getName()=='_'||chessComponent[offset3.getX()][offset3.getY()].getChessColor()!=getChessColor())
                move.add(offset3);
        ChessboardPoint offset4=getSource().offset(-1,2);
        if(offset4!=null)
            if(chessComponent[offset4.getX()][offset4.getY()].getName()=='_'||chessComponent[offset4.getX()][offset4.getY()].getChessColor()!=getChessColor())
                move.add(offset4);
        ChessboardPoint offset5=getSource().offset(1,-2);
        if(offset1!=null)
            if(chessComponent[offset5.getX()][offset5.getY()].getName()=='_'||chessComponent[offset5.getX()][offset5.getY()].getChessColor()!=getChessColor())
                move.add(offset5);
        ChessboardPoint offset6=getSource().offset(1,2);
        if(offset6!=null)
            if(chessComponent[offset6.getX()][offset6.getY()].getName()=='_'||chessComponent[offset6.getX()][offset6.getY()].getChessColor()!=getChessColor())
                move.add(offset6);
        ChessboardPoint offset7=getSource().offset(2,-1);
        if(offset7!=null)
            if(chessComponent[offset7.getX()][offset7.getY()].getName()=='_'||chessComponent[offset7.getX()][offset7.getY()].getChessColor()!=getChessColor())
                move.add(offset7);
        ChessboardPoint offset8=getSource().offset(2,1);
        if(offset8!=null)
            if(chessComponent[offset8.getX()][offset8.getY()].getName()=='_'||chessComponent[offset8.getX()][offset8.getY()].getChessColor()!=getChessColor())
                move.add(offset8);
        return move;
    }
}
