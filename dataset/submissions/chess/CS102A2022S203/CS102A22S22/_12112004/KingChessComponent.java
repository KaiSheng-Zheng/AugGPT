import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ChessboardPoint = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (moveChess(source.getX(),source.getY(),i,j)){
                    ChessboardPoint.add(new ChessboardPoint(i,j));
                }

            }
        }
        return ChessboardPoint;
}

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor()!=super.getChessColor()){
            return false;
        }
        if (targetX > 7 || targetX < 0 || targetY > 7 || targetY < 0) {

            return false;
        }
        if (chessComponents[sourceX][sourceX].getChessColor()!= chessComponents[targetX][targetY].getChessColor()||chessComponents[targetX][targetY]instanceof EmptySlotComponent) {
            if (Math.abs(targetX - sourceX)==0&&  Math.abs(targetY - sourceY) == 1) {
                chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),super.getChessColor(),super.name);
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,chessComponents[targetX][targetY].name);
                return true;
            }
            if (Math.abs(targetX - sourceX)==1&&  Math.abs(targetY - sourceY) == 0) {
                chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),super.getChessColor(),super.name);
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,chessComponents[targetX][targetY].name);
                return true;
            }

            if (Math.abs(targetX - sourceX) == 1 && Math.abs(targetY - sourceY) == 1) {
                chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),super.getChessColor(),super.name);
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,chessComponents[targetX][targetY].name);
                return true;
            }
        }
        return false;
    }
}
