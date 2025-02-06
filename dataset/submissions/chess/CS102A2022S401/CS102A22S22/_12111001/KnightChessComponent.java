import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessColor color, int x, int y, char name){
        setChessColor(color);
        setSource(x, y);
        setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int sourceX = getSource().getX();
        int sourceY = getSource().getY();
        ArrayList<ChessboardPoint> result = new ArrayList<>();
        if(sourceX + 2 < 8&&sourceX + 2 >= 0&&sourceY + 1 < 8&&sourceY + 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX + 2][sourceY + 1].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX + 2,sourceY + 1));
        }
        if(sourceX + 2 < 8&&sourceX + 2 >= 0&&sourceY - 1 < 8&&sourceY - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX + 2][sourceY - 1].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX + 2,sourceY - 1));
        }
        if(sourceX - 2 < 8&&sourceX - 2 >= 0&&sourceY + 1 < 8&&sourceY + 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX - 2][sourceY + 1].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX - 2,sourceY + 1));
        }
        if(sourceX - 2 < 8&&sourceX - 2 >= 0&&sourceY - 1 < 8&&sourceY - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX - 2][sourceY - 1].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX - 2,sourceY - 1));
        }
        if(sourceX + 1 < 8&&sourceX + 1 >= 0&&sourceY + 2 < 8&&sourceY + 2 >= 0&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY + 2].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX + 1,sourceY + 2));
        }
        if(sourceX + 1 < 8&&sourceX + 1 >= 0&&sourceY - 2 < 8&&sourceY - 2 >= 0&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY - 2].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX + 1,sourceY - 2));
        }
        if(sourceX - 1 < 8&&sourceX - 1 >= 0&&sourceY + 2 < 8&&sourceY + 2 >= 0&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY + 2].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX - 1,sourceY + 2));
        }
        if(sourceX - 1 < 8&&sourceX - 1 >= 0&&sourceY - 2 < 8&&sourceY - 2 >= 0&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY - 2].getChessColor() != getChessColor()){
            result.add(new ChessboardPoint(sourceX - 1,sourceY - 2));
        }
        return result;
    }
}
