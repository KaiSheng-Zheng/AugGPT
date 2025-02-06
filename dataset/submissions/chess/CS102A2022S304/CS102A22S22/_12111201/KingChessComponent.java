import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
        super();
        super.setSource(chessboardPoint);
        super.setChessColor(chessColor);
    }
    private ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveposition=new ArrayList<>();
        int a=super.getSource().getX(),b=super.getSource().getY();
        if(a>0&&b>0&&(chessComponents[a-1][b-1] instanceof EmptySlotComponent||(!chessComponents[a-1][b-1].getChessColor().equals(super.getChessColor())))){
            canmoveposition.add(new ChessboardPoint(a-1,b-1));
        }
        if(a>0&&(chessComponents[a-1][b] instanceof EmptySlotComponent||(!chessComponents[a-1][b].getChessColor().equals(super.getChessColor())))){
            canmoveposition.add(new ChessboardPoint(a-1,b));
        }if(a>0&&b<7&&(chessComponents[a-1][b+1] instanceof EmptySlotComponent||(!chessComponents[a-1][b+1].getChessColor().equals(super.getChessColor())))){
            canmoveposition.add(new ChessboardPoint(a-1,b+1));
        }
        if(b>0&&(chessComponents[a][b-1] instanceof EmptySlotComponent||(!chessComponents[a][b-1].getChessColor().equals(super.getChessColor())))){
            canmoveposition.add(new ChessboardPoint(a,b-1));
        }
        if(b<7&&(chessComponents[a][b+1] instanceof EmptySlotComponent||(!chessComponents[a][b+1].getChessColor().equals(super.getChessColor())))){
            canmoveposition.add(new ChessboardPoint(a,b+1));
        }
        if(a<7&&b>0&&(chessComponents[a+1][b-1] instanceof EmptySlotComponent||(!chessComponents[a+1][b-1].getChessColor().equals(super.getChessColor())))){
            canmoveposition.add(new ChessboardPoint(a+1,b-1));
        }
        if(a<7&&(chessComponents[a+1][b] instanceof EmptySlotComponent||(!chessComponents[a+1][b].getChessColor().equals(super.getChessColor())))){
            canmoveposition.add(new ChessboardPoint(a+1,b));
        }
        if(a<7&&b<7&&(chessComponents[a+1][b+1] instanceof EmptySlotComponent||(!chessComponents[a+1][b+1].getChessColor().equals(super.getChessColor())))){
            canmoveposition.add(new ChessboardPoint(a+1,b+1));
        }

        return canmoveposition;
    }
    public String toString(){
        if(super.getChessColor().equals(ChessColor.BLACK)){
            return "K";
        }else{
            return "k";
        }
    }
}
