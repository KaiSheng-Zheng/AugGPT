import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor color, int x, int y, char name){
        setChessColor(color);
        setSource(x, y);
        setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> result = new ArrayList<>();
        int sourceX = getSource().getX();
        int sourceY = getSource().getY();
        if(getChessColor() == ChessColor.BLACK) {
            for (int i = sourceY + 1; i < 8; i++) {
                if (ConcreteChessGame.getChessComponent()[sourceX][i].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(sourceX, i));
                } else if(ConcreteChessGame.getChessComponent()[sourceX][i].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(sourceX, i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = sourceY - 1; i >= 0; i--) {
                if (ConcreteChessGame.getChessComponent()[sourceX][i].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(sourceX, i));
                } else if(ConcreteChessGame.getChessComponent()[sourceX][i].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(sourceX, i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = sourceX + 1; i < 8; i++) {
                if (ConcreteChessGame.getChessComponent()[i][sourceY].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, sourceY));
                } else if(ConcreteChessGame.getChessComponent()[i][sourceY].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(i, sourceY));
                    break;
                }else {
                    break;
                }
            }
            for (int i = sourceX - 1; i >= 0; i--) {
                if (ConcreteChessGame.getChessComponent()[i][sourceY].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, sourceY));
                } else if(ConcreteChessGame.getChessComponent()[i][sourceY].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(i, sourceY));
                    break;
                }else {
                    break;
                }
            }
        }else{
            for (int i = sourceY + 1; i < 8; i++) {
                if (ConcreteChessGame.getChessComponent()[sourceX][i].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(sourceX, i));
                } else if(ConcreteChessGame.getChessComponent()[sourceX][i].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(sourceX, i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = sourceY - 1; i >= 0; i--) {
                if (ConcreteChessGame.getChessComponent()[sourceX][i].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(sourceX, i));
                } else if(ConcreteChessGame.getChessComponent()[sourceX][i].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(sourceX, i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = sourceX + 1; i < 8; i++) {
                if (ConcreteChessGame.getChessComponent()[i][sourceY].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, sourceY));
                } else if(ConcreteChessGame.getChessComponent()[i][sourceY].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(i, sourceY));
                    break;
                }else {
                    break;
                }
            }
            for (int i = sourceX - 1; i >= 0; i--) {
                if (ConcreteChessGame.getChessComponent()[i][sourceY].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(i, sourceY));
                } else if(ConcreteChessGame.getChessComponent()[i][sourceY].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(i, sourceY));
                    break;
                }else {
                    break;
                }
            }
        }
        return result;
    }
}
