import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessColor color, int x, int y, char name){
        setChessColor(color);
        setSource(x, y);
        setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> result = new ArrayList<>();
        int sourceX = getSource().getX();
        int sourceY = getSource().getY();
        int i,j;
        if(getChessColor() == ChessColor.BLACK) {
            i = sourceX + 1;
            j = sourceY + 1;
            while(i < 8&&j < 8){
                if (ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, j));
                } else if(ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(i, j));
                    break;
                }else {
                    break;
                }
                i++;
                j++;
            }
            i = sourceX + 1;
            j = sourceY - 1;
            while(i < 8&&j >= 0){
                if (ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, j));
                } else if(ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(i, j));
                    break;
                }else {
                    break;
                }
                i++;
                j--;
            }
            i = sourceX - 1;
            j = sourceY - 1;
            while(i >= 0&&j >= 0){
                if (ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, j));
                } else if(ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(i, j));
                    break;
                }else {
                    break;
                }
                i--;
                j--;
            }
            i = sourceX - 1;
            j = sourceY + 1;
            while(i >= 0&&j < 8){
                if (ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, j));
                } else if(ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(i, j));
                    break;
                }else {
                    break;
                }
                i--;
                j++;
            }
        }else{
            i = sourceX + 1;
            j = sourceY + 1;
            while(i < 8&&j < 8){
                if (ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, j));
                } else if(ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(i, j));
                    break;
                }else {
                    break;
                }
                i++;
                j++;
            }
            i = sourceX + 1;
            j = sourceY - 1;
            while(i < 8&&j >= 0){
                if (ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, j));
                } else if(ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(i, j));
                    break;
                }else {
                    break;
                }
                i++;
                j--;
            }
            i = sourceX - 1;
            j = sourceY - 1;
            while(i >= 0&&j >= 0){
                if (ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, j));
                } else if(ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(i, j));
                    break;
                }else {
                    break;
                }
                i--;
                j--;
            }
            i = sourceX - 1;
            j = sourceY + 1;
            while(i >= 0&&j < 8){
                if (ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, j));
                } else if(ConcreteChessGame.getChessComponent()[i][j].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(i, j));
                    break;
                }else {
                    break;
                }
                i--;
                j++;
            }
        }
        return result;
    }
}
