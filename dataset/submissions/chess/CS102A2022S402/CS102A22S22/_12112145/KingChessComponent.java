import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(int x,int y,ChessColor chessColor) {
        super();
        this.setSource(new ChessboardPoint(x,y));
        if (chessColor.equals(ChessColor.BLACK)){
            this.name = 'K';
        } else {
            this.name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();

        ChessboardPoint curPosition = this.getSource();

        ChessboardPoint off1 = curPosition.offset(1, 0);
        if (null != off1){
            result.add(off1);
        }
        ChessboardPoint off2 = curPosition.offset(-1, 0);
        if (null != off2){
            result.add(off2);
        }
        ChessboardPoint off3 = curPosition.offset(1, 1);
        if (null != off3){
            result.add(off3);
        }
        ChessboardPoint off4 = curPosition.offset(-1, 1);
        if (null != off4){
            result.add(off4);
        }

        ChessboardPoint off5 = curPosition.offset(1, -1);
        if (null != off5){
            result.add(off5);
        }

        ChessboardPoint off6 = curPosition.offset(-1, -1);
        if (null != off6){
            result.add(off6);
        }
        ChessboardPoint off7 = curPosition.offset(0, 1);
        if (null != off7){
            result.add(off7);
        }
        ChessboardPoint off8 = curPosition.offset(0, -1);
        if (null != off8){
            result.add(off8);
        }

        return result;
    }
}
