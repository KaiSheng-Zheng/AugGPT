import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
       this.setSource(source);
       this.setChessColor(chessColor);
       this.setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getChessColor() == ChessColor.BLACK && i > 0){
                    if (i == getSource().getX() + 1 && j == getSource().getY() && getChessComponents()[i][j].getChessColor() == ChessColor.NONE){
                        arrayList.add(new ChessboardPoint(i,j));
                    }
                    if (i == getSource().getX() + 1 && Math.abs(getSource().getY() - j) == 1 && getChessComponents()[i][j].getChessColor() == ChessColor.WHITE){
                        arrayList.add(new ChessboardPoint(i,j));
                    }
                    if (getSource().getX() == 1 && i == 3 && j == getSource().getY() && getChessComponents()[2][j].getChessColor() == ChessColor.NONE && getChessComponents()[3][j].getChessColor() == ChessColor.NONE){
                        arrayList.add(new ChessboardPoint(i,j));
                    }
                }
                if (getChessColor() == ChessColor.WHITE && i < 7){
                    if (i == getSource().getX() - 1 && j == getSource().getY() && getChessComponents()[i][j].getChessColor() == ChessColor.NONE){
                        arrayList.add(new ChessboardPoint(i,j));
                    }
                    if (i == getSource().getX() - 1 && Math.abs(getSource().getY() - j) == 1 && getChessComponents()[i][j].getChessColor() == ChessColor.BLACK){
                        arrayList.add(new ChessboardPoint(i,j));
                    }
                    if (getSource().getX() == 6 && i == 4 && j == getSource().getY() && getChessComponents()[5][j].getChessColor() == ChessColor.NONE && getChessComponents()[4][j].getChessColor() == ChessColor.NONE){
                        arrayList.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return arrayList;
    }



}
