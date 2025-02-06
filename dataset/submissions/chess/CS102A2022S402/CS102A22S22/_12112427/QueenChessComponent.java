import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents;

    public QueenChessComponent(ChessColor chessColor, ChessboardPoint source,ChessComponent[][] chessComponents) {
        if (chessColor == ChessColor.WHITE) {
            name = 'q';
        } else if (chessColor == ChessColor.BLACK) {
            name = 'Q';
        }
        setSource(source);
        setChessColor(chessColor);
        this.chessComponents=chessComponents;
    }



    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> can=new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int m=0;m<8;m++){
            for (int n=0;n<8;n++){
                boolean CanMove=true;
                ChessboardPoint destination=new ChessboardPoint(m,n);
                int col;
                int row;
                if (source.getY()==destination.getY()&&source.getX()==destination.getX()){
                    CanMove= false;
                }else {
                    if (chessComponents[destination.getX()][destination.getY()].getChessColor() != getChessColor()) {
                        if (Math.abs(source.getX() - destination.getX()) == Math.abs(source.getY() - destination.getY())) {
                            col = source.getY();
                            row = source.getX();
                            if (destination.getY() > source.getY() && destination.getX() > source.getX()) {
                                for (; col + 1 < destination.getY() && row + 1 < destination.getX(); col++, row++) {
                                    if (!(chessComponents[row + 1][col + 1] instanceof EmptySlotComponent)) {
                                        CanMove= false;
                                    }
                                }
                            } else if (destination.getY() < source.getY() && destination.getX() > source.getX()) {
                                for (; col - 1 > destination.getY() && row + 1 < destination.getX(); col--, row++) {
                                    if (!(chessComponents[row + 1][col - 1] instanceof EmptySlotComponent)) {
                                        CanMove= false;
                                    }
                                }
                            } else if (destination.getY() > source.getY() && destination.getX() < source.getX()) {
                                for (; col + 1 < destination.getY() && row - 1 > destination.getX(); col++, row--) {
                                    if (!(chessComponents[row - 1][col + 1] instanceof EmptySlotComponent)) {
                                        CanMove= false;
                                    }
                                }
                            } else if (destination.getY() < source.getY() && destination.getX() < source.getX()) {
                                for (; col - 1 > destination.getY() && row - 1 > destination.getX(); col--, row--) {
                                    if (!(chessComponents[row - 1][col - 1] instanceof EmptySlotComponent)) {
                                        CanMove= false;
                                    }
                                }
                            }
                            else {
                                CanMove= false;
                            }
                        } else if (source.getX() == destination.getX()) {
                            row = source.getX();
                            for (col = Math.min(source.getY(), destination.getY()) + 1;
                                 col < Math.max(source.getY(), destination.getY()); col++) {
                                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                    CanMove= false;
                                }
                            }
                        } else if (source.getY() == destination.getY()) {
                            col = source.getY();
                            for (row = Math.min(source.getX(), destination.getX()) + 1;
                                 row < Math.max(source.getX(), destination.getX()); row++) {
                                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                    CanMove= false;
                                }
                            }
                        } else { // Not on the same row or the same column.
                            CanMove= false;
                        }
                    } else {
                        CanMove= false;
                    }
                }
                if (CanMove){
                    can.add(destination);
                }
            }
        }
        return can;
    }
}


