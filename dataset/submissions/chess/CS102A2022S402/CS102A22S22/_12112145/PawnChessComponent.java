import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(int x, int y, ChessColor chessColor) {
        super();
        super.setSource(new ChessboardPoint(x,y));
        if (chessColor.equals(ChessColor.BLACK)){
            this.name = 'P';
        } else {
            this.name = 'p';
        }
    }


    private boolean isFirstMove = true;


    @Override
    public void setSource(ChessboardPoint source) {
        super.setSource(source);
        isFirstMove = false;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint> result = new ArrayList<>();

        ChessboardPoint source = this.getSource();
        if (isFirstMove){
            if (this.name == 'P'){
                ChessboardPoint offset1 = source.offset(1, 0);
                if (offset1 != null){
                    result.add(offset1);
                }
                ChessboardPoint offset2 = source.offset(2, 0);
                if (offset2 != null){
                    result.add(offset2);
                }
            } else {
                ChessboardPoint offset1 = source.offset(-1, 0);
                if (offset1 != null){
                    result.add(offset1);
                }
                ChessboardPoint offset2 = source.offset(-2, 0);
                if (offset2 != null){
                    result.add(offset2);
                }
            }
        } else {

            ChessboardPoint offset = null;
            if (this.name == 'P'){
                offset = source.offset(1, 0);
            } else {
                offset = source.offset(-1, 0);
            }
            if (offset != null){
                result.add(offset);
            }
        }

        return result;
    }
}
