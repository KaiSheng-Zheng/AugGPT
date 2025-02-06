import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent() {
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char c) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = c;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        if((this.getChessColor() == ChessColor.BLACK) && (row != 7)){
            if(chessComponents[row+1][col].getChessColor() == ChessColor.NONE){
                result.add(new ChessboardPoint(row+1,col));
                if((row == 1) && (chessComponents[row+2][col].getChessColor() == ChessColor.NONE)){
                    result.add(new ChessboardPoint(row+2,col));
                }
            }
            if((col == 0)&&(chessComponents[row+1][1].getChessColor() == ChessColor.WHITE)){
                result.add(new ChessboardPoint(row+1,1));
            }
            if((col == 7)&&(chessComponents[row+1][6].getChessColor() == ChessColor.WHITE)){
                result.add(new ChessboardPoint(row+1,6));
            }
            if((col >= 1) && (col <= 6)){
                if(chessComponents[row+1][col-1].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(row+1,col-1));
                }
                if(chessComponents[row+1][col+1].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(row+1,col+1));
                }
            }
        }
        if((this.getChessColor() == ChessColor.WHITE) && (row != 0)){
            if(chessComponents[row-1][col].getChessColor() == ChessColor.NONE){
                result.add(new ChessboardPoint(row-1,col));
                if((row == 6) && (chessComponents[row-2][col].getChessColor() == ChessColor.NONE)){
                    result.add(new ChessboardPoint(row-2,col));
                }
            }
            if((col == 0)&&(chessComponents[row-1][1].getChessColor() == ChessColor.BLACK)){
                result.add(new ChessboardPoint(row-1,1));
            }
            if((col == 7)&&(chessComponents[row-1][6].getChessColor() == ChessColor.BLACK)){
                result.add(new ChessboardPoint(row-1,6));
            }
            if((col >= 1) && (col <= 6)){
                if(chessComponents[row-1][col-1].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(row-1,col-1));
                }
                if(chessComponents[row-1][col+1].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(row-1,col+1));
                }
            }
        }
        return result;
    }
}
