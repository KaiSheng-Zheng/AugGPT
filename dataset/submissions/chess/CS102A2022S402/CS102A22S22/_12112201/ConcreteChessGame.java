import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char component = chessboard.get(i).charAt(j), raw = (component == '_') ?(int) '_' : (char) (component & (~32));
                switch (raw) {
                    case 'K': {
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                        break;
                    }
                    case 'Q': {
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                        break;
                    }
                    case 'R': {
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                        break;
                    }
                    case 'B': {
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                        break;
                    }
                    case 'N': {
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                        break;
                    }
                    case 'P': {
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                        break;
                    }
                    case '_': {
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), getComponentColor(component));
                        break;
                    }
                }
            }
        }
        currentPlayer = chessboard.get(8).charAt(0) == 'b' ? ChessColor.BLACK : ChessColor.WHITE;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessboard(chessComponents);
        ArrayList<ChessboardPoint> willmoveTo = (ArrayList<ChessboardPoint>) chessComponents[source.getX()][source.getY()].canMoveTo();
        willmoveTo.sort(new Sort());
        return willmoveTo;
    }

    private static class Sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint p1, ChessboardPoint p2) {
            if (p1.getX() == p2.getX()) {
                return p1.getY() - p2.getY();
            } else {
                return p1.getX() - p2.getX();
            }
        }
    }
@Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j]);
                if (j == 7) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    private ChessColor getComponentColor(char component) {
        if (component == '_') {
            return ChessColor.NONE;
        }
        if (component >= 'A' && component <= 'Z') {
            return ChessColor.BLACK;
        } else {
            return ChessColor.WHITE;
        }
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] str = new int[128],
                zimu = new int[]{'K', 'Q', 'R', 'B', 'N', 'P'},
                fullNum = new int[]{1, 1, 2, 2, 2, 8};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getComponentColor(chessComponents[i][j].toString().charAt(0)) == player) {
                    str[chessComponents[i][j].toString().charAt(0) & (~32)]++;
                }
            }
        }
        for (int i = 0; i < zimu.length; i++) {
            if (str[zimu[i]] < fullNum[i]) {
                sb.append((char) (zimu[i] | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(fullNum[i] - str[zimu[i]]).append("\n");
            }
        }
        return sb.toString();
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ArrayList<ChessboardPoint> moveTo=(ArrayList<ChessboardPoint>)chessComponents[sourceX][sourceY].canMoveTo();
        if(!moveTo.contains(new ChessboardPoint(targetX, targetY))){
            return false;
        }
        chessComponents[sourceX][sourceY].setChessboard(chessComponents);
        if(currentPlayer!=getComponentColor(chessComponents[sourceX][sourceY].toString().charAt(0))){
            return false;
        }
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source=new ChessboardPoint(targetX, targetY);
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
        currentPlayer=(currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE);
        return true;
    }
    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }
}
