import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
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
        ArrayList<ChessboardPoint> ret=new ArrayList<>();
        int a=super.getSource().getX(),b=super.getSource().getY();
        if(a-2>=0&&a-2<8&&b-1>=0&&b-1<8&&(chessComponents[a-2][b-1] instanceof EmptySlotComponent||!chessComponents[a-2][b-1].getChessColor().equals(super.getChessColor()))){
            ret.add(new ChessboardPoint(a-2,b-1));
        }
        if(a-2>=0&&a-2<8&&b+1>=0&&b+1<8&&(chessComponents[a-2][b+1] instanceof EmptySlotComponent||chessComponents[a-2][b+1].getChessColor()==(super.getChessColor()))){
            ret.add(new ChessboardPoint(a-2,b+1));
        }
        if(a-1>=0&&a-1<8&&b-2>=0&&b-2<8&&(chessComponents[a-1][b-2] instanceof EmptySlotComponent||chessComponents[a-1][b-2].getChessColor()!=(super.getChessColor()))){
            ret.add(new ChessboardPoint(a-1,b-2));
        }
        if(a-1>=0&&a-1<8&&b+2>=0&&b+2<8&&(chessComponents[a-1][b+2] instanceof EmptySlotComponent||chessComponents[a-1][b+2].getChessColor()!=(super.getChessColor()))){
            ret.add(new ChessboardPoint(a-1,b+2));
        }
        if(a+1>=0&&a+1<8&&b-2>=0&&b-2<8&&(chessComponents[a+1][b-2] instanceof EmptySlotComponent||chessComponents[a+1][b-2].getChessColor()!=(super.getChessColor()))){
            ret.add(new ChessboardPoint(a+1,b-2));
        }
        if(a+1>=0&&a+1<8&&b+2>=0&&b+2<8&&(chessComponents[a+1][b+2] instanceof EmptySlotComponent||chessComponents[a+1][b+2].getChessColor()!=(super.getChessColor()))){
            ret.add(new ChessboardPoint(a+1,b+2));
        }
        if(a+2>=0&&a+2<8&&b-1>=0&&b-1<8&&(chessComponents[a+2][b-1] instanceof EmptySlotComponent||chessComponents[a+2][b-1].getChessColor()!=(super.getChessColor()))){
            ret.add(new ChessboardPoint(a+2,b-1));
        }
        if(a+2>=0&&a+2<8&&b+1>=0&&b+1<8&&(chessComponents[a+2][b+1] instanceof EmptySlotComponent||chessComponents[a+2][b+1].getChessColor()!=(super.getChessColor()))){
            ret.add(new ChessboardPoint(a+2,b+1));
        }
        return ret;
    }
    public String toString(){
        if(super.getChessColor().equals(ChessColor.BLACK)){
            return "N";
        }else{
            return "n";
        }
    }
}
