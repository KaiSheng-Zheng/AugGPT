import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor,source);
        if (chessColor.equals(ChessColor.BLACK)){
            this.name='Q';
        }else{
            this.name='q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (source.getX() + i < 8 && source.getY() + i < 8) {
                if (super.chessboard[source.getX() + i][source.getY() + i].chessColor.equals(
                        ChessColor.NONE)) {
                    moveTo.add(new ChessboardPoint(source.getX() + i, source.getY() + i));
                }
                else if (!super.chessboard[source.getX() + i][source.getY() + i].chessColor.equals(
                        super.chessboard[source.getX()][source.getY()].chessColor)) {
                    moveTo.add(new ChessboardPoint(source.getX() + i, source.getY() + i));
                    break;
                }
                else break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (source.getX() - i >= 0 && source.getY() + i < 8) {
                if (super.chessboard[source.getX() - i][source.getY() + i].chessColor.equals(
                        ChessColor.NONE)) {
                    moveTo.add(new ChessboardPoint(source.getX() - i, source.getY() + i));
                }
                else if (!super.chessboard[source.getX() - i][source.getY() + i].chessColor.equals(
                        super.chessboard[source.getX()][source.getY()].chessColor)) {
                    moveTo.add(new ChessboardPoint(source.getX() - i, source.getY() + i));
                    break;
                }
                else break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (source.getX() - i >= 0 && source.getY() - i >= 0) {
                if (super.chessboard[source.getX() - i][source.getY() - i].chessColor.equals(
                        ChessColor.NONE)) {
                    moveTo.add(new ChessboardPoint(source.getX() - i, source.getY() - i));
                }
                else if (!super.chessboard[source.getX() - i][source.getY() - i].chessColor.equals(
                        super.chessboard[source.getX()][source.getY()].chessColor)) {
                    moveTo.add(new ChessboardPoint(source.getX() - i, source.getY() - i));
                    break;
                }
                else break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (source.getX() + i < 8 && source.getY() - i >= 0) {
                if (super.chessboard[source.getX() + i][source.getY() - i].chessColor.equals(
                        ChessColor.NONE)) {
                    moveTo.add(new ChessboardPoint(source.getX() + i, source.getY() - i));
                }
                else if (!super.chessboard[source.getX() + i][source.getY() - i].chessColor.equals(
                        super.chessboard[source.getX()][source.getY()].chessColor)) {
                    moveTo.add(new ChessboardPoint(source.getX() + i, source.getY() - i));
                    break;
                }
                else break;
            }
        }
        //bishop



        int i = 1;
        while (i+source.getX()<8&&super.chessboard[source.getX()+i][source.getY()].chessColor.equals(ChessColor.NONE)
        ){
            moveTo.add(new ChessboardPoint(source.getX() + i, source.getY()));
            i++;
        }
        if (i+source.getX()<8&&!(super.chessboard[source.getX()+i][source.getY()].chessColor.equals
                (super.chessboard[source.getX()][source.getY()].chessColor))){
            moveTo.add(new ChessboardPoint(source.getX()+i, source.getY()));
        }
        i = 1;
        while (i+source.getY()<8&&super.chessboard[source.getX()][source.getY()+i].chessColor.equals(ChessColor.NONE)
        ){
            moveTo.add(new ChessboardPoint(source.getX() , source.getY()+i));
            i++;
        }
        if (i+source.getY()<8&&!(super.chessboard[source.getX()][source.getY()+i].chessColor.equals
                (super.chessboard[source.getX()][source.getY()].chessColor))){
            moveTo.add(new ChessboardPoint(source.getX(), source.getY()+i));
        }
        i = 1;
        while (source.getX()-i>=0 &&super.chessboard[source.getX()-i][source.getY()].chessColor.equals(ChessColor.NONE)
        ){
            moveTo.add(new ChessboardPoint(source.getX() -i , source.getY()));
            i++;
        }
        if (source.getX()-i>=0&&!(super.chessboard[source.getX()-i][source.getY()].chessColor.equals
                (super.chessboard[source.getX()][source.getY()].chessColor))){
            moveTo.add(new ChessboardPoint(source.getX()-i, source.getY()));
        }
        i = 1;
        while (source.getY()-i>=0&&super.chessboard[source.getX()][source.getY()-i].chessColor.equals(ChessColor.NONE)
        ){
            moveTo.add(new ChessboardPoint(source.getX() , source.getY()-i));
            i++;
        }
        if (source.getY()-i>=0&&!(super.chessboard[source.getX()][source.getY()-i].chessColor.equals
                (super.chessboard[source.getX()][source.getY()].chessColor))){
            moveTo.add(new ChessboardPoint(source.getX(), source.getY()-i));
        }
        return moveTo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}