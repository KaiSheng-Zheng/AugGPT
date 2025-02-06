import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();

        for (int i = 1; i < 8; i++) {
            if (y + i <= 7){
                ChessComponent destination = chessComponents[x][y + i];
                if (destination.getChessColor() == this.getChessColor()){
                    break;
                }else if(destination.getChessColor() == ChessColor.NONE){
                    canMovePoints.add(new ChessboardPoint(x, y + i));
                    continue;
                }else {
                    canMovePoints.add(new ChessboardPoint(x, y + i));
                    break;
                }

            }else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (y - i >= 0){
                ChessComponent destination = chessComponents[x][y - i];
                if (destination.getChessColor() == this.getChessColor()){
                    break;
                }else if(destination.getChessColor() == ChessColor.NONE){
                    canMovePoints.add(new ChessboardPoint(x, y - i));
                    continue;
                }else {
                    canMovePoints.add(new ChessboardPoint(x, y - i));
                    break;
                }

            }else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (x + i <= 7){
                ChessComponent destination = chessComponents[x + i][y];
                if (destination.getChessColor() == this.getChessColor()){
                    break;
                }else if(destination.getChessColor() == ChessColor.NONE){
                    canMovePoints.add(new ChessboardPoint(x + i, y));
                    continue;
                }else {
                    canMovePoints.add(new ChessboardPoint(x + i, y));
                    break;
                }

            }else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (x - i >= 0){
                ChessComponent destination = chessComponents[x - i][y];
                if (destination.getChessColor() == this.getChessColor()){
                    break;
                }else if(destination.getChessColor() == ChessColor.NONE){
                    canMovePoints.add(new ChessboardPoint(x - i, y));
                    continue;
                }else {
                    canMovePoints.add(new ChessboardPoint(x - i, y));
                    break;
                }

            }else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (x + i <= 7 && y + i <= 7){
                ChessComponent destination = chessComponents[x + i][y + i];
                if (destination.getChessColor() == this.getChessColor()){
                    break;
                }else if(destination.getChessColor() == ChessColor.NONE){
                    canMovePoints.add(new ChessboardPoint(x + i, y + i));
                    continue;
                }else {
                    canMovePoints.add(new ChessboardPoint(x + i, y + i));
                    break;
                }

            }else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (x - i >= 0 && y - i >= 0){
                ChessComponent destination = chessComponents[x - i][y - i];
                if (destination.getChessColor() == this.getChessColor()){
                    break;
                }else if(destination.getChessColor() == ChessColor.NONE){
                    canMovePoints.add(new ChessboardPoint(x - i, y - i));
                    continue;
                }else {
                    canMovePoints.add(new ChessboardPoint(x - i, y - i));
                    break;
                }

            }else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (x + i <= 7 && y - i >= 0){
                ChessComponent destination = chessComponents[x + i][y - i];
                if (destination.getChessColor() == this.getChessColor()){
                    break;
                }else if(destination.getChessColor() == ChessColor.NONE){
                    canMovePoints.add(new ChessboardPoint(x + i, y - i));
                    continue;
                }else {
                    canMovePoints.add(new ChessboardPoint(x + i, y - i));
                    break;
                }

            }else {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (x - i >= 0 && y + i <= 7){
                ChessComponent destination = chessComponents[x - i][y + i];
                if (destination.getChessColor() == this.getChessColor()){
                    break;
                }else if(destination.getChessColor() == ChessColor.NONE){
                    canMovePoints.add(new ChessboardPoint(x - i, y + i));
                    continue;
                }else {
                    canMovePoints.add(new ChessboardPoint(x - i, y + i));
                    break;
                }

            }else {
                break;
            }
        }
        return canMovePoints;
    }
}