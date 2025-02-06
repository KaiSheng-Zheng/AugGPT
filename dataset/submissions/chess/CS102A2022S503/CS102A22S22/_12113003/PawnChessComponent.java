import java.util.*;

public class PawnChessComponent extends ChessComponent{
    private int FirstStep;
    public PawnChessComponent(ChessColor color) {
        if(color==ChessColor.BLACK){
            name='P';
        }
        if(color==ChessColor.WHITE){
            name='p';
        }
    }

    public int getFirstStep() {
        return FirstStep;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        if(super.getChessColor()==ChessColor.WHITE){
            if(x==6&&chessComponents[x-1][y].getChessColor() == ChessColor.NONE&&chessComponents[x-2][y].getChessColor() == ChessColor.NONE){
                canMove.add(new ChessboardPoint(x-1,y));
                canMove.add(new ChessboardPoint(x-2,y));
            }
            if(x==6&&chessComponents[x-1][y].getChessColor() == ChessColor.NONE&&chessComponents[x-2][y].getChessColor() == super.getChessColor()){
                canMove.add(new ChessboardPoint(x-1,y));
            }
            if(x!=6&&chessComponents[x-1][y].getChessColor()==ChessColor.NONE){
                canMove.add(new ChessboardPoint(x-1,y));
            }

            if(y == 0 && chessComponents[x - 1][y + 1].getChessColor() == reverseChessColor(super.getChessColor())){
                canMove.add(new ChessboardPoint(x-1,y+1));
            }
            if(y==7&&chessComponents[x-1][y-1].getChessColor()==reverseChessColor(super.getChessColor())){
                canMove.add(new ChessboardPoint(x-1,y-1));
            }
            if(y<7&&y>0&&chessComponents[x - 1][y + 1].getChessColor() == reverseChessColor(super.getChessColor())){
                canMove.add(new ChessboardPoint(x-1,y+1));
            }
            if(y<7&&y>0&&chessComponents[x - 1][y - 1].getChessColor() == reverseChessColor(super.getChessColor())){
                canMove.add(new ChessboardPoint(x-1,y-1));
            }
        }
        else{
            if(x==1&&chessComponents[x+1][y].getChessColor() == ChessColor.NONE&&chessComponents[x+2][y].getChessColor() ==ChessColor.NONE){
                canMove.add(new ChessboardPoint(x+1,y));
                canMove.add(new ChessboardPoint(x+2,y));
            }
            if(x==1&&chessComponents[x+1][y].getChessColor() == ChessColor.NONE&&chessComponents[x+2][y].getChessColor() == super.getChessColor()){
                canMove.add(new ChessboardPoint(x+1,y));
            }
            if(x!=1&&chessComponents[x+1][y].getChessColor()==ChessColor.NONE){
                canMove.add(new ChessboardPoint(x+1,y));
            }

            if(y==0&&chessComponents[x+1][y+1].getChessColor()==reverseChessColor(super.getChessColor())){
                canMove.add(new ChessboardPoint(x+1,y+1));
            }
            if(y==7&&chessComponents[x+1][y-1].getChessColor()==reverseChessColor(super.getChessColor())){
                canMove.add(new ChessboardPoint(x+1,y-1));
            }
            if(y<7&&y>0&&chessComponents[x + 1][y + 1].getChessColor() == reverseChessColor(super.getChessColor())){
                canMove.add(new ChessboardPoint(x+1,y+1));
            }
            if(y<7&&y>0&&chessComponents[x + 1][y - 1].getChessColor() == reverseChessColor(super.getChessColor())){
                canMove.add(new ChessboardPoint(x+1,y-1));
            }
        }
        canMove.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) return 1;
                if (o1.getX() == o2.getX()) {
                    if (o1.getY() > o2.getY()) return 1;
                    else return -1;
                } else return -1;
            }
        });
        return canMove;


    }
    public ChessColor reverseChessColor(ChessColor chessColor) {
        if (chessColor == ChessColor.BLACK) {
            return ChessColor.WHITE;
        }
        if (chessColor == ChessColor.WHITE) {
            return ChessColor.BLACK;
        } else {
            return ChessColor.NONE;
        }
    }

}
