import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
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
        if(super.getChessColor().equals(ChessColor.BLACK)){
            if(super.getSource().getX()==1){
                if (chessComponents[a + 1][b] instanceof EmptySlotComponent) {
                    canmoveposition.add(new ChessboardPoint(a+1,b));
                    if(chessComponents[a+2][b] instanceof EmptySlotComponent){
                        canmoveposition.add(new ChessboardPoint(a+2,b));
                    }
                }
                if((b>0&&(!(chessComponents[a+1][b-1] instanceof EmptySlotComponent))&&!chessComponents[a+1][b-1].getChessColor().equals(super.getChessColor()))){
                    canmoveposition.add(new ChessboardPoint(a+1,b-1));
                }
                if(b<7&&(!(chessComponents[a+1][b+1] instanceof EmptySlotComponent))&&!chessComponents[a+1][b+1].getChessColor().equals(super.getChessColor())){
                    canmoveposition.add(new ChessboardPoint(a+1,b+1));
                }
            }else {
                if (chessComponents[a + 1][b] instanceof EmptySlotComponent) {
                    canmoveposition.add(new ChessboardPoint(a+1,b));
                }
                if((b>0&&(!(chessComponents[a+1][b-1] instanceof EmptySlotComponent))&&!chessComponents[a+1][b-1].getChessColor().equals(super.getChessColor()))){
                    canmoveposition.add(new ChessboardPoint(a+1,b-1));
                }
                if(b<7&&(!(chessComponents[a+1][b+1] instanceof EmptySlotComponent))&&!chessComponents[a+1][b+1].getChessColor().equals(super.getChessColor())){
                    canmoveposition.add(new ChessboardPoint(a+1,b+1));
                }
            }
        }else {
            if(super.getSource().getX()==6){
                if (chessComponents[a-1][b] instanceof EmptySlotComponent) {
                    canmoveposition.add(new ChessboardPoint(a-1,b));
                    if(chessComponents[a-2][b] instanceof EmptySlotComponent){
                        canmoveposition.add(new ChessboardPoint(a-2,b));
                    }
                }
                if((b>0&&(!(chessComponents[a-1][b-1] instanceof EmptySlotComponent))&&!chessComponents[a+1][b-1].getChessColor().equals(super.getChessColor()))){
                    canmoveposition.add(new ChessboardPoint(a-1,b-1));
                }
                if(b<7&&(!(chessComponents[a-1][b+1] instanceof EmptySlotComponent))&&!chessComponents[a+1][b+1].getChessColor().equals(super.getChessColor())){
                    canmoveposition.add(new ChessboardPoint(a-1,b+1));
                }
            }else {
                if (chessComponents[a-1][b] instanceof EmptySlotComponent) {
                    canmoveposition.add(new ChessboardPoint(a-1,b));
                }
                if((b>0&&(!(chessComponents[a-1][b-1] instanceof EmptySlotComponent))&&!chessComponents[a+1][b-1].getChessColor().equals(super.getChessColor()))){
                    canmoveposition.add(new ChessboardPoint(a-1,b-1));
                }
                if(b<7&&(!(chessComponents[a-1][b+1] instanceof EmptySlotComponent))&&!chessComponents[a+1][b+1].getChessColor().equals(super.getChessColor())){
                    canmoveposition.add(new ChessboardPoint(a-1,b+1));
                }
            }
        }
        for (int i=0;i<canmoveposition.size();i++){
            for (int j=i;j<canmoveposition.size();j++){
                if(canmoveposition.get(i).getX()>canmoveposition.get(j).getX()){
                    ChessboardPoint chessboardPoint=canmoveposition.get(i);
                    canmoveposition.remove(i);
                    canmoveposition.add(i,canmoveposition.get(j-1));
                    canmoveposition.remove(j);
                    canmoveposition.add(j,chessboardPoint);
                }
            }
        }
        for (int i=0;i<canmoveposition.size();i++){
            for (int j=i;j<canmoveposition.size();j++){
                if(canmoveposition.get(i).getX()==canmoveposition.get(j).getX()&&canmoveposition.get(i).getY()>canmoveposition.get(j).getY()){
                    ChessboardPoint chessboardPoint=canmoveposition.get(i);
                    canmoveposition.remove(i);
                    canmoveposition.add(i,canmoveposition.get(j-1));
                    canmoveposition.remove(j);
                    canmoveposition.add(j,chessboardPoint);
                }
            }
        }
        return canmoveposition;
    }
    @Override
    public String toString(){
        if(super.getChessColor().equals(ChessColor.BLACK)){
            return "P";
        }else{
            return "p";
        }
    }
}
