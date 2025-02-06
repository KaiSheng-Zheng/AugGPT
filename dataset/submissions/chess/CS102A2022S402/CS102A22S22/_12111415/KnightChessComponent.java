import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents,char name){
        super(chessboardPoint,chessComponents,name);
    this.source=chessboardPoint;
    this.chessComponents=chessComponents;
    this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
    if (name=='N'){
        if (y<7&&x<6&&chessComponents[x+2][y+1].getName()>90){
            point.add(new ChessboardPoint(x+2,y+1));}
        if (x<7&&y<6&&chessComponents[x+1][y+2].getName()>90){
            point.add(new ChessboardPoint(x+1,y+2));
        }
        if (x>0&&y>1&&chessComponents[x-1][y-2].getName()>90){
            point.add(new ChessboardPoint(x-1,y-2));
        }
        if (y>1&&x<7&&chessComponents[x+1][y-2].getName()>90){
            point.add(new ChessboardPoint(x+1,y-2));}
        if (x>0&&y<6&&chessComponents[x-1][y+2].getName()>90){
            point.add(new ChessboardPoint(x-1,y+2));}
        if (x>1&&y>0&&chessComponents[x-2][y-1].getName()>90){
            point.add(new ChessboardPoint(x-2,y-1));}
       if (x>1&&y<7&&chessComponents[x-2][y+1].getName()>90){
             point.add(new ChessboardPoint(x-2,y+1));}
        if (x<6&&y>0&&chessComponents[x+2][y-1].getName()>90){
            point.add(new ChessboardPoint(x+2,y-1));
        }
    }
        else if (name=='n'){
            if (y<7&&x<6&&chessComponents[x+2][y+1].getName()<=94){
                point.add(new ChessboardPoint(x+2,y+1));}
            if (x<7&&y<6&&chessComponents[x+1][y+2].getName()<=94){
                point.add(new ChessboardPoint(x+1,y+2));}
            if (x>0&&y>1&&chessComponents[x-1][y-2].getName()<=94){
                point.add(new ChessboardPoint(x-1,y-2));
            }
            if (y>1&&x<7&&chessComponents[x+1][y-2].getName()<=94){
                point.add(new ChessboardPoint(x+1,y-2));}
            if (y<6&&x>0&&chessComponents[x-1][y+2].getName()<=94){
                point.add(new ChessboardPoint(x-1,y+2));}
            if (x>1&&y>0&&chessComponents[x-2][y-1].getName()<=94){
                point.add(new ChessboardPoint(x-2,y-1));}
            if (x>1&&y<7&&chessComponents[x-2][y+1].getName()<=94){
           point.add(new ChessboardPoint(x-2,y+1)); }
        }
   return point; }
}

