import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }


    public RookChessComponent(){
        if (this.getChessColor() == ChessColor.BLACK){
            setName('R');
        }else if (this.getChessColor() == ChessColor.WHITE){
            setName('r');
        }
    }

    //ConcreteChessGame concreteChessGame;
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        int row = getSource().getX();
        int col = getSource().getY();

        for (int i = row - 1; i >= 0; i--){
            if (chessComponents[i][col] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(i, col));
            }else if (chessComponents[i][col].getChessColor() != this.getChessColor()){
                points.add(new ChessboardPoint(i, col));
                break;
            }else if (chessComponents[i][col].getChessColor() == this.getChessColor()){
                break;
            }
        }


        for (int i = row + 1; i < 8; i++){
            if (chessComponents[i][col] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(i, col));
            }else if (chessComponents[i][col].getChessColor() != this.getChessColor()){
                points.add(new ChessboardPoint(i, col));
                break;
            }else if (chessComponents[i][col].getChessColor() == this.getChessColor()){
                break;
            }
        }


        for (int j = col - 1; j >= 0; j--){
            if (chessComponents[row][j] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(row, j));
            }else if (chessComponents[row][j].getChessColor() != this.getChessColor()){
                points.add(new ChessboardPoint(row, j));
                break;
            }else if (chessComponents[row][j].getChessColor() == this.getChessColor()){
                break;
            }
        }


        for (int j = col + 1; j < 8; j++){
            if (chessComponents[row][j] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(row, j));
            }else if (chessComponents[row][j].getChessColor() != this.getChessColor()){
                points.add(new ChessboardPoint(row, j));
                break;
            }else if (chessComponents[row][j].getChessColor() == this.getChessColor()){
                break;
            }
        }

        return points;
    }
}
