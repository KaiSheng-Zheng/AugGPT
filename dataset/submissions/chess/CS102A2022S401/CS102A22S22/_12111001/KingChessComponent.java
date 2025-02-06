import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor color, int x, int y, char name){
        setChessColor(color);
        setSource(x, y);
        setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> result = new ArrayList<>();
        int sourceX = getSource().getX();
        int sourceY = getSource().getY();
        if(sourceY + 1 < 8&&sourceY + 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX][sourceY + 1].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX,sourceY + 1));
        }
        if(sourceY - 1 < 8&&sourceY - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX][sourceY - 1].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX,sourceY - 1));
        }
        if(sourceX + 1 < 8&&sourceX + 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX + 1,sourceY));
        }
        if(sourceX - 1 < 8&&sourceX - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX - 1,sourceY));
        }
        if(sourceX + 1 < 8&&sourceX + 1 >= 0&&sourceY + 1 < 8&&sourceY + 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY + 1].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX + 1,sourceY + 1));
        }
        if(sourceX - 1 < 8&&sourceX - 1 >= 0&&sourceY + 1 < 8&&sourceY + 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY + 1].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX - 1,sourceY + 1));
        }
        if(sourceX - 1 < 8&&sourceX - 1 >= 0&&sourceY - 1 < 8&&sourceY - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY - 1].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX - 1,sourceY - 1));
        }
        if(sourceX + 1 < 8&&sourceX + 1 >= 0&&sourceY - 1 < 8&&sourceY - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY - 1].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX + 1,sourceY - 1));
        }
        return result;
    }
}
