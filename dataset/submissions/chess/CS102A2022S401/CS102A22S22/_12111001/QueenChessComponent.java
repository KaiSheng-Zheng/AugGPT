import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessColor color, int x, int y, char name){
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
            for (int a = sourceY + 1; a < 8; a++) {
                if (ConcreteChessGame.getChessComponent()[sourceX][a].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(sourceX, a));
                } else if(ConcreteChessGame.getChessComponent()[sourceX][a].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(sourceX, a));
                    break;
                }else {
                    break;
                }
            }
            for (int a = sourceY - 1; a >= 0; a--) {
                if (ConcreteChessGame.getChessComponent()[sourceX][a].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(sourceX, a));
                } else if(ConcreteChessGame.getChessComponent()[sourceX][a].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(sourceX, a));
                    break;
                }else {
                    break;
                }
            }
            for (int a = sourceX + 1; a < 8; a++) {
                if (ConcreteChessGame.getChessComponent()[a][sourceY].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(a, sourceY));
                } else if(ConcreteChessGame.getChessComponent()[a][sourceY].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(a, sourceY));
                    break;
                }else {
                    break;
                }
            }
            for (int a = sourceX - 1; a >= 0; a--) {
                if (ConcreteChessGame.getChessComponent()[a][sourceY].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(a, sourceY));
                } else if(ConcreteChessGame.getChessComponent()[a][sourceY].getChessColor() == ChessColor.WHITE){
                    result.add(new ChessboardPoint(a, sourceY));
                    break;
                }else {
                    break;
                }
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
            for (int a = sourceY + 1; a < 8; a++) {
                if (ConcreteChessGame.getChessComponent()[sourceX][a].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(sourceX, a));
                } else if(ConcreteChessGame.getChessComponent()[sourceX][a].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(sourceX, a));
                    break;
                }else {
                    break;
                }
            }
            for (int a = sourceY - 1; a >= 0; a--) {
                if (ConcreteChessGame.getChessComponent()[sourceX][a].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(sourceX, a));
                } else if(ConcreteChessGame.getChessComponent()[sourceX][a].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(sourceX, a));
                    break;
                }else {
                    break;
                }
            }
            for (int a = sourceX + 1; a < 8; a++) {
                if (ConcreteChessGame.getChessComponent()[a][sourceY].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(a, sourceY));
                } else if(ConcreteChessGame.getChessComponent()[a][sourceY].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(a, sourceY));
                    break;
                }else {
                    break;
                }
            }
            for (int a = sourceX - 1; a >= 0; a--) {
                if (ConcreteChessGame.getChessComponent()[a][sourceY].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(a, sourceY));
                } else if(ConcreteChessGame.getChessComponent()[a][sourceY].getChessColor() == ChessColor.BLACK){
                    result.add(new ChessboardPoint(a, sourceY));
                    break;
                }else {
                    break;
                }
            }
        }
        return result;
    }
}
