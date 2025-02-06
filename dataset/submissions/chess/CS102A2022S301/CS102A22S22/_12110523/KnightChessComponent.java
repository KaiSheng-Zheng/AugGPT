import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.source = source;
        this.chessColor = chessColor;

    }
    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l=new ArrayList<>() ;
        int x=source.getX();
        int y=source.getY();
        ChessboardPoint n1=new ChessboardPoint(x-2,y+1);
        ChessboardPoint n2=new ChessboardPoint(x-2,y-1);
        ChessboardPoint n3=new ChessboardPoint(x-1,y+2);
        ChessboardPoint n4=new ChessboardPoint(x-1,y-2);
        ChessboardPoint n5=new ChessboardPoint(x+2,y+1);
        ChessboardPoint n6=new ChessboardPoint(x+2,y-1);
        ChessboardPoint n7=new ChessboardPoint(x+1,y+2);
        ChessboardPoint n8=new ChessboardPoint(x+1,y-2);
        if (n1.getX()==-996){}
        else{
            if (chessboard[x-2][y+1].getChessColor()!=chessColor)
           {l.add(n1);}
        }

        if (n2.getX()==-996){}
        else{
            if (chessboard[x-2][y-1].getChessColor()==chessColor){}
            else {l.add(n2);}
        }

        if (n3.getX()==-996){}
        else{
            if (chessboard[x-1][y+2].getChessColor()==chessColor){}
            else {l.add(n3);}
        }

        if (n4.getX()==-996){}
        else{
            if (chessboard[x-1][y-2].getChessColor()==chessColor){}
            else {l.add(n4);}
        }

        if (n5.getX()==-996){}
        else{
            if (chessboard[x+2][y+1].getChessColor()==chessColor){}
            else {l.add(n5);}
        }

        if (n6.getX()==-996){}
        else{
            if (chessboard[x+2][y-1].getChessColor()==chessColor){}
            else {l.add(n6);}
        }

        if (n7.getX()==-996){}
        else{
            if (chessboard[x+1][y+2].getChessColor()==chessColor){}
            else {l.add(n7);}
        }

        if (n8.getX()==-996){}
        else{
            if (chessboard[x+1][y-2].getChessColor()==chessColor){}
            else {l.add(n8);}
        }


        return l;

    }
}
