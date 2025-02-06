import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessColor color, int x, int y, char name){
        setChessColor(color);
        setSource(x, y);
        setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> result = new ArrayList<>();
        int sourceX = getSource().getX();
        int sourceY = getSource().getY();
        if(getChessColor() == ChessColor.WHITE&&sourceX == 6){
            if(sourceY < 8&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY].getChessColor() == ChessColor.NONE){
                result.add(new ChessboardPoint(sourceX - 1,sourceY));
            }
            if(sourceY < 8&&ConcreteChessGame.getChessComponent()[sourceX - 2][sourceY].getChessColor() == ChessColor.NONE&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY].getChessColor() == ChessColor.NONE){
                result.add(new ChessboardPoint(sourceX - 2,sourceY));
            }
            if(sourceY + 1 < 8&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY + 1].getChessColor() == ChessColor.BLACK){
                result.add(new ChessboardPoint(sourceX - 1,sourceY + 1));
            }
            if(sourceY - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY - 1].getChessColor() == ChessColor.BLACK){
                result.add(new ChessboardPoint(sourceX - 1,sourceY - 1));
            }
        }else if(getChessColor() == ChessColor.BLACK&&sourceX == 1){
            if(sourceY < 8&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY].getChessColor() == ChessColor.NONE){
                result.add(new ChessboardPoint(sourceX + 1,sourceY));
            }
            if(sourceY < 8&&ConcreteChessGame.getChessComponent()[sourceX + 2][sourceY].getChessColor() == ChessColor.NONE&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY].getChessColor() == ChessColor.NONE){
                result.add(new ChessboardPoint(sourceX + 2,sourceY));
            }
            if(sourceY + 1 < 8&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY + 1].getChessColor() == ChessColor.WHITE){
                result.add(new ChessboardPoint(sourceX + 1,sourceY + 1));
            }
            if(sourceY - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY - 1].getChessColor() == ChessColor.WHITE){
                result.add(new ChessboardPoint(sourceX + 1,sourceY - 1));
            }
        }else if(getChessColor() == ChessColor.WHITE){
            if(sourceX - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY].getChessColor() == ChessColor.NONE){
                result.add(new ChessboardPoint(sourceX - 1,sourceY));
            }
            if(sourceX - 1 >= 0&&sourceY + 1 < 8&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY + 1].getChessColor() == ChessColor.BLACK){
                result.add(new ChessboardPoint(sourceX - 1,sourceY + 1));
            }
            if(sourceX - 1 >= 0&&sourceY - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX - 1][sourceY - 1].getChessColor() == ChessColor.BLACK){
                result.add(new ChessboardPoint(sourceX - 1,sourceY - 1));
            }
        }else{
            if(sourceX + 1 < 8&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY].getChessColor() == ChessColor.NONE){
                result.add(new ChessboardPoint(sourceX + 1,sourceY));
            }
            if(sourceX + 1 < 8&&sourceY - 1 >= 0&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY - 1].getChessColor() == ChessColor.WHITE){
                result.add(new ChessboardPoint(sourceX + 1,sourceY - 1));
            }
            if(sourceX + 1 < 8&&sourceY + 1 < 8&&ConcreteChessGame.getChessComponent()[sourceX + 1][sourceY + 1].getChessColor() == ChessColor.WHITE){
                result.add(new ChessboardPoint(sourceX + 1,sourceY + 1));
            }
        }
        return result;
    }
}