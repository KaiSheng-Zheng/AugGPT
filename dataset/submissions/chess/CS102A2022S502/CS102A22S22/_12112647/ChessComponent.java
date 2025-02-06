import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessboardPoint source;
    //protected ChessColor chessColor;
    protected char name;
    protected ChessColor player;
    protected ChessComponent[][] chessboard;
    public void setChessboard(ChessComponent[][] chessboard){
        this.chessboard=chessboard;
    }
    //should design
    public ChessComponent() {
    }

    public ChessColor getPlayer() {
        return player;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(name);
    }



}

class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessColor player,ChessboardPoint source){
        super.player=player;
        super.source=source;
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Math.abs(source.getX()-i)==Math.abs(source.getY()-j)){
                    int distance=source.getX()-i;
                    int k=(source.getX()-i)/(source.getY()-j);
                    if(k==1){
                        if(distance<0){
                            for (int l = -1; l > distance; l--) {
                                if(chessboard[i+distance][j+distance].getPlayer()!=ChessColor.NONE)
                                    break;
                                result.add(new ChessboardPoint(i,j));
                            }
                        }
                        if(distance>0){
                            for (int l = 1; l < distance; l++) {
                                if(chessboard[i+distance][j+distance].getPlayer()!=ChessColor.NONE)
                                    break;
                                result.add(new ChessboardPoint(i,j));
                            }
                        }
                    }
                    if(k==-1){
                        if(distance<0){
                            for (int l = -1; l > distance; l--) {
                                if(chessboard[i+distance][j-distance].getPlayer()!=ChessColor.NONE)
                                    break;
                                result.add(new ChessboardPoint(i,j));
                            }
                        }
                        if(distance>0){
                            for (int l = 1; l < distance; l++) {
                                if(chessboard[i+distance][j-distance].getPlayer()!=ChessColor.NONE)
                                    break;
                                result.add(new ChessboardPoint(i,j));
                            }
                        }
                    }



                }
            }
        }
        return result;
    }
    public String toString() {
        if(player==ChessColor.WHITE)
            return "b";
        else
            return "B";
    }
}
class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessColor player,ChessboardPoint source){
        super.player=player;
        super.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        return result;
    }
    public String toString() {
        return "_";
    }


}
class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor player,ChessboardPoint source){
        super.player=player;
        super.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Math.abs(i-source.getX())<=1&&Math.abs(j-source.getY())<=1){
                    if(chessboard[i][j].getPlayer()!=player)
                        result.add(new ChessboardPoint(i,j));
                }
            }
        }
        return result;
    }
    public String toString() {
        if(player==ChessColor.WHITE)
            return "k";
        else
            return "K";
    }

}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor player,ChessboardPoint source){
        super.player=player;
        super.source=source;
    }
    boolean isgood(int x,int y){
        if(x<0||x>7||y<0||y>7)
            return false;
        else
            return true;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points=new ArrayList<>();
        int x1=source.getX()-2;
        int x2=source.getX()-1;
        int x3=source.getX()+1;
        int x4=source.getX()+2;
        int y1=source.getY()-2;
        int y2=source.getY()-1;
        int y3=source.getY()+1;
        int y4=source.getY()+2;
        if(isgood(x1,y2)&&chessboard[x1][y2].getPlayer()!=getPlayer())
            points.add(new ChessboardPoint(x1,y2));
        if(isgood(x1,y3)&&chessboard[x1][y3].getPlayer()!=getPlayer())
            points.add(new ChessboardPoint(x1,y3));
        if(isgood(x2,y1)&&chessboard[x2][y1].getPlayer()!=getPlayer())
            points.add(new ChessboardPoint(x2,y1));
        if(isgood(x2,y4)&&chessboard[x2][y4].getPlayer()!=getPlayer())
            points.add(new ChessboardPoint(x2,y4));
        if(isgood(x3,y1)&&chessboard[x3][y1].getPlayer()!=getPlayer())
            points.add(new ChessboardPoint(x3,y1));
        if(isgood(x3,y4)&&chessboard[x3][y4].getPlayer()!=getPlayer())
            points.add(new ChessboardPoint(x3,y4));
        if(isgood(x4,y2)&&chessboard[x4][y2].getPlayer()!=getPlayer())
            points.add(new ChessboardPoint(x4,y2));
        if(isgood(x4,y3)&&chessboard[x4][y3].getPlayer()!=getPlayer())
            points.add(new ChessboardPoint(x4,y3));

        return points;

    }
    public String toString() {
        if(player==ChessColor.WHITE)
            return "n";
        else
            return "N";
    }

}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor player,ChessboardPoint source){
        super.player=player;
        super.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        if(player==ChessColor.WHITE){
            if(source.getX()==6&&chessboard[4][source.getY()].getPlayer()==ChessColor.NONE&&chessboard[5][source.getY()].getPlayer()==ChessColor.NONE){
                result.add(new ChessboardPoint(4,source.getY()));
                if(source.getY()-1>=0&&chessboard[5][source.getY()-1].getPlayer()==ChessColor.BLACK)
                    result.add(new ChessboardPoint(5,source.getY()-1));
                result.add(new ChessboardPoint(5,source.getY()));
                if(source.getY()+1<=7&&chessboard[5][source.getY()+1].getPlayer()==ChessColor.BLACK)
                    result.add(new ChessboardPoint(5,source.getY()+1));
            }
            else if(chessboard[source.getX()-1][source.getY()].getPlayer()==ChessColor.NONE){
                if(source.getY()-1>=0&&chessboard[source.getX()-1][source.getY()-1].getPlayer()==ChessColor.BLACK)
                    result.add(new ChessboardPoint(source.getX()-1,source.getY()-1));
                result.add(new ChessboardPoint(source.getX()-1,source.getY()));
                if(source.getY()+1<=7&&chessboard[source.getX()-1][source.getY()+1].getPlayer()==ChessColor.BLACK)
                    result.add(new ChessboardPoint(source.getX()-1,source.getY()+1));
            }
            else{
                if(source.getY()-1>=0&&chessboard[source.getX()-1][source.getY()-1].getPlayer()==ChessColor.BLACK)
                    result.add(new ChessboardPoint(source.getX()-1,source.getY()-1));
                if(source.getY()+1<=7&&chessboard[source.getX()-1][source.getY()+1].getPlayer()==ChessColor.BLACK)
                    result.add(new ChessboardPoint(source.getX()-1,source.getY()+1));
            }
        }
        if(player==ChessColor.BLACK){
            if(source.getX()==1&&chessboard[2][source.getY()].getPlayer()==ChessColor.NONE&&chessboard[3][source.getY()].getPlayer()==ChessColor.NONE){
                if(source.getY()-1>=0&&chessboard[2][source.getY()-1].getPlayer()==ChessColor.WHITE)
                    result.add(new ChessboardPoint(2,source.getY()-1));
                result.add(new ChessboardPoint(2,source.getY()));
                if(source.getY()+1<=7&&chessboard[2][source.getY()+1].getPlayer()==ChessColor.WHITE)
                    result.add(new ChessboardPoint(2,source.getY()+1));
                result.add(new ChessboardPoint(3,source.getY()));

            }
            else if(chessboard[source.getX()+1][source.getY()].getPlayer()==ChessColor.NONE){
                if(source.getY()-1>=0&&chessboard[source.getX()+1][source.getY()-1].getPlayer()==ChessColor.WHITE)
                    result.add(new ChessboardPoint(source.getX()+1,source.getY()-1));
                result.add(new ChessboardPoint(source.getX()+1,source.getY()));
                if(source.getY()+1<=7&&chessboard[source.getX()+1][source.getY()+1].getPlayer()==ChessColor.WHITE)
                    result.add(new ChessboardPoint(source.getX()+1,source.getY()+1));
            }
            else{
                if(source.getY()-1>=0&&chessboard[source.getX()+1][source.getY()-1].getPlayer()==ChessColor.WHITE)
                    result.add(new ChessboardPoint(source.getX()+1,source.getY()-1));
                if(source.getY()+1<=7&&chessboard[source.getX()+1][source.getY()+1].getPlayer()==ChessColor.WHITE)
                    result.add(new ChessboardPoint(source.getX()+1,source.getY()+1));
            }
        }
        return result;
    }
    public String toString() {
        if(player==ChessColor.WHITE)
            return "p";
        else
            return "P";
    }
}
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor player,ChessboardPoint source){
        super.player=player;
        super.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public String toString() {
        if(player==ChessColor.WHITE)
            return "q";
        else
            return "Q";
    }
}
class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor player,ChessboardPoint source){
        super.player=player;
        super.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        int startx=0;
        for (int i = 0; i < source.getX(); i++) {
            if(!chessboard[i][source.getY()].toString().equals("_")){
                if(chessboard[i][source.getY()].getPlayer()!=getPlayer())
                    startx=i;
                else
                    startx=i+1;
            }
        }
        for (int i = startx; i < source.getX(); i++) {
            result.add(new ChessboardPoint(i,source.getY()));
        }

        int starty=0;
        for (int i = 0; i < source.getY(); i++) {
            if(!chessboard[source.getX()][i].toString().equals("_")){
                if(chessboard[source.getX()][i].getPlayer()!=getPlayer())
                    starty=i;
                else
                    starty=i+1;
            }
        }
        for (int i = starty; i < source.getY(); i++) {
            result.add(new ChessboardPoint(source.getX(),i));
        }

        int endy=7;
        for (int i = source.getY()+1; i < 8; i++) {
            if(chessboard[source.getX()][i].toString().equals("_")){
                result.add(new ChessboardPoint(source.getX(),i));
            }
            else if(chessboard[source.getX()][i].getPlayer()!=getPlayer()) {
                result.add(new ChessboardPoint(source.getX(),i));
                break;
            }
            else
                break;
        }
        for (int i = source.getX()+1; i < 8; i++) {
            if(chessboard[i][source.getY()].toString().equals("_")){
                result.add(new ChessboardPoint(i,source.getY()));
            }
            else if(chessboard[i][source.getY()].getPlayer()!=getPlayer()) {
                result.add(new ChessboardPoint(i,source.getY()));
                break;
            }
            else
                break;
        }
        return result;

    }

    @Override
    public String toString() {
        if(player==ChessColor.WHITE)
            return "r";
        else
            return "R";
    }
}