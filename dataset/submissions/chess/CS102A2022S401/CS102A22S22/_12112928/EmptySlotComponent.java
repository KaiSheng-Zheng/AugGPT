

import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public ChessColor getChessColor(){
        return chessColor;
    }
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        super.name=name;
    }
    @Override
    public void setName(char name){
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
         return new ArrayList<>();
    }
}