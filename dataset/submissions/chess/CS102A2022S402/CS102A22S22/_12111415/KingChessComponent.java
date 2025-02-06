import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public KingChessComponent(ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents,char name){
        super(chessboardPoint,chessComponents,name);
   this.source=chessboardPoint;
   this.chessComponents=chessComponents;
   this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point = new ArrayList<>();
        int x=source.getX(); int y=source.getY();
        if (name=='K') {


            if (y!=0&&chessComponents[x][y-1].getName()>90&&chessComponents[x][y-1].getName()!='k'){
                point.add(new ChessboardPoint(x,y-1));}
                if (x!=0&&chessComponents[x-1][y].getName()>90&&chessComponents[x-1][y].getName()!='k'){
                    point.add(new ChessboardPoint(x-1,y));
                }
if (y!=7&&chessComponents[x][y+1].getName()>90&&chessComponents[x][y+1].getName()!='k'){
                point.add(new ChessboardPoint(x,y+1));
        }
            if (x!=7&&chessComponents[x+1][y].getName()>90&&chessComponents[x+1][y].getName()!='k'){
                point.add(new ChessboardPoint(x+1,y));}
            if (y!=7&&x!=7&&chessComponents[x+1][y+1].getName()>90&&chessComponents[x+1][y+1].getName()!='k'){
                point.add(new ChessboardPoint(x,y+1));}
                if (x!=0&&y!=0&&chessComponents[x-1][y-1].getName()>90&&chessComponents[x-1][y-1].getName()!='k'){
                    point.add(new ChessboardPoint(x-1,y-1));}
                    if (x!=7&&y!=0&&chessComponents[x+1][y-1].getName()>90&&chessComponents[x+1][y-1].getName()!='k'){
                        point.add(new ChessboardPoint(x+1,y-1));}}
                    else if (name=='k'){
                        if (y!=0&&chessComponents[x][y-1].getName()<=96&&chessComponents[x][y-1].getName()!='K'){
                            point.add(new ChessboardPoint(x,y-1));}
                        if (x!=0&&chessComponents[x-1][y].getName()<=96&&chessComponents[x-1][y].getName()!='K'){
                            point.add(new ChessboardPoint(x-1,y));}

                            if (chessComponents[x-1][y+1].getName()<=96&&chessComponents[x][y-1].getName()!='k'){
                            point.add(new ChessboardPoint(x-1,y+1));}

            if (y!=7&&chessComponents[x][y+1].getName()<=96&&chessComponents[x][y+1].getName()!='K'){
                point.add(new ChessboardPoint(x,y+1));
            }
            if (x!=7&&chessComponents[x+1][y].getName()<=96&&chessComponents[x+1][y].getName()!='K'){
                point.add(new ChessboardPoint(x+1,y));}
            if (y!=7&&x!=7&&chessComponents[x+1][y+1].getName()<=96&&chessComponents[x+1][y+1].getName()!='K'){
                point.add(new ChessboardPoint(x,y+1));}
            if (x!=0&&y!=0&&chessComponents[x-1][y-1].getName()<=96&&chessComponents[x-1][y-1].getName()!='K'){
                point.add(new ChessboardPoint(x-1,y-1));}
            if (x!=7&&y!=0&&chessComponents[x+1][y-1].getName()<=96&&chessComponents[x+1][y-1].getName()!='K'){
                point.add(new ChessboardPoint(x+1,y-1));}
            if (chessComponents[x-1][y+1].getName()<=96&&chessComponents[x][y-1].getName()!='K'){
                point.add(new ChessboardPoint(x-1,y+1));}}


                    return point;}





}
