import java.util.List;
import java.util.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int y = 0; y < 8; y++)
            for (int x = 0; x < 8; x++)
                this.chessComponents[x][y] = ChessComponent.construct(this, chessboard.get(x).charAt(y), x, y);

        this.currentPlayer = chessboard.get(8).equals("w") ? ChessColor.WHITE : ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    public ChessComponent getChess(ChessboardPoint point) {
        return this.getChess(point.getX(), point.getY());
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++)
                sb.append(this.chessComponents[x][y].name);
            sb.append('\n');
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private int getCapturedChessCountByName(char name) {
        return (int) Arrays.stream(chessComponents).flatMap(Arrays::stream).filter(c -> c.name == name).count();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        final char[] names = new char[]{'K', 'Q', 'R', 'B', 'N', 'P'};
        final int[] total = new int[]{1, 1, 2, 2, 2, 8};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            char name = names[i];
            if (player == ChessColor.WHITE)
                name = Character.toLowerCase(name);

            int left = total[i] - this.getCapturedChessCountByName(name);
            if (left > 0)
                sb.append(name).append(" ").append(left).append('\n');
        }

        return sb.toString();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        //Find chess according to source
        ChessComponent chess = this.getChess(source.getX(),source.getY());
        // chess.chessboard = chessComponents;
        //As below statement
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        for(int i=0; i<canMovePoints.size();i++){
            for(int j=1; j<canMovePoints.size();j++){
                if(canMovePoints.get(j-1).getX()>canMovePoints.get(j).getX()){
                    Collections.swap(canMovePoints,j-1,j);
                }else if(canMovePoints.get(j-1).getX()==canMovePoints.get(j).getX() && canMovePoints.get(j-1).getY()>canMovePoints.get(j).getY()){
                    Collections.swap(canMovePoints,j-1,j);
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = chessComponents[sourceX][sourceY];
        List<ChessboardPoint> can= chess.canMoveTo();
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        if (currentPlayer == chess.getChessColor()) {
            for (ChessboardPoint point : can) {
                if (targetX==point.getX() && targetY==point.getY()) {
                    chessComponents[sourceX][sourceY].setSource(target);
                    chessComponents[targetX][targetY] =  chessComponents[sourceX][sourceY];
//                    chessComponents[targetX][targetY].setSource(target);
//                    chessComponents[targetX][targetY].setChessColor(chess.getChessColor());
//                    chessComponents[targetX][targetY].setName(chess.getName());
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].setSource(source);
                    chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                    chessComponents[sourceX][sourceY].setName('_');
                    if (currentPlayer == ChessColor.BLACK)
                        currentPlayer = ChessColor.WHITE;
                    else if(currentPlayer ==ChessColor.WHITE)
                        currentPlayer = ChessColor.BLACK;
                    return true;
                }
            }
        }
        return false;
    }

    public PieceStatus getPieceStatus(ChessboardPoint point, ChessboardPoint origin) {
        ChessComponent dst = this.getChess(point);
        if (dst instanceof EmptySlotComponent)
            return PieceStatus.EMPTY;
        if (dst.getChessColor() != this.getChess(origin).getChessColor())
            return PieceStatus.OPPONENT;
        return PieceStatus.OWN;
    }
}
