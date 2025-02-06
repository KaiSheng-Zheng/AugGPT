import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;

    //ConcreteChessGame concreteChessGame;
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public BishopChessComponent(){
        if (this.getChessColor() == ChessColor.BLACK){
            setName('B');
        }else if (this.getChessColor() == ChessColor.WHITE){
            setName('b');
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        int row = getSource().getX();
        int col = getSource().getY();

        for (int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++){
            if (chessComponents[i][j] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(i, j));
            } else if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(i, j));
                break;
            }else if (chessComponents[i][j].getChessColor() == this.getChessColor()){
                break;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if (chessComponents[i][j] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(i, j));
            } else if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(i, j));
                break;
            }else if (chessComponents[i][j].getChessColor() == this.getChessColor()){
                break;
            }
        }

        for (int i = row + 1, j = col + 1; i < 8 && j < 8; i++, j++){
            if (chessComponents[i][j] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(i, j));
            } else if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(i, j));
                break;
            }else if (chessComponents[i][j].getChessColor() == this.getChessColor()){
                break;
            }
        }

        for (int i = row + 1, j = col - 1; i < 8 && j >= 0; i++, j--){
            if (chessComponents[i][j] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(i, j));
            } else if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(i, j));
                break;
            }else if (chessComponents[i][j].getChessColor() == this.getChessColor()){
                break;
            }
        }

        return points;
    }
}
