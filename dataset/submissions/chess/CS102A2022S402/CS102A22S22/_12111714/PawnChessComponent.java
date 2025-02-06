import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ArrayList<ChessboardPoint> output = new ArrayList<>();
        if(this.getChessColor() == ChessColor.BLACK){
            if(this.getChessComponents()[x + 1][y] instanceof EmptySlotComponent && x + 1 < 8){
                output.add(new ChessboardPoint(x+1,y));
                if(movement == 0 && this.getChessComponents()[x + 2][y] instanceof EmptySlotComponent && x + 2 < 8){
                    output.add((new ChessboardPoint(x+2,y)));
                }
            }
            if(!(this.getChessComponents()[x + 1][y + 1] instanceof EmptySlotComponent) && x + 1 < 8 && y + 1 < 8){
                output.add(new ChessboardPoint(x + 1,y + 1));
            }
            if(!(this.getChessComponents()[x + 1][y - 1] instanceof EmptySlotComponent) && x + 1 < 8 && y - 1 > 0){
                output.add(new ChessboardPoint(x + 1,y - 1));
            }
        }
        if(this.getChessColor() == ChessColor.WHITE){
            if(this.getChessComponents()[x - 1][y] instanceof EmptySlotComponent && x - 1 > 0){
                output.add(new ChessboardPoint(x-1,y));
                if(movement == 0 && this.getChessComponents()[x - 2][y] instanceof EmptySlotComponent && x - 2 > 0){
                    output.add((new ChessboardPoint(x-2,y)));
                }
            }
            if(!(this.getChessComponents()[x - 1][y + 1] instanceof EmptySlotComponent) && x - 1 > 0 && y + 1 < 8){
                output.add(new ChessboardPoint(x - 1,y + 1));
            }
            if(!(this.getChessComponents()[x - 1][y - 1] instanceof EmptySlotComponent) && x - 1 > 8 && y - 1 > 0){
                output.add(new ChessboardPoint(x - 1,y - 1));
            }
        }
        return output;
    }

}
