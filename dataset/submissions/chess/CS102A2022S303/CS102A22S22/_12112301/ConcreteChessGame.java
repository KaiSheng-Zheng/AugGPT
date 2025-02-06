import javax.xml.transform.Source;
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

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            String str = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                char chess = str.charAt(j);
                if (chess == 'R')
                    this.chessComponents[i][j] = new RookChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chess == 'N')
                    this.chessComponents[i][j] = new KnightChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chess == 'B')
                    this.chessComponents[i][j] = new BishopChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chess == 'Q')
                    this.chessComponents[i][j] = new QueenChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chess == 'K')
                    this.chessComponents[i][j] = new KingChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chess == 'P')
                    this.chessComponents[i][j] = new PawnChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chess == 'r')
                    this.chessComponents[i][j] = new RookChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chess == 'n')
                    this.chessComponents[i][j] = new KnightChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chess == 'b')
                    this.chessComponents[i][j] = new BishopChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chess == 'q')
                    this.chessComponents[i][j] = new QueenChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chess == 'k')
                    this.chessComponents[i][j] = new KingChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chess == 'p')
                    this.chessComponents[i][j] = new PawnChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chess == '_')
                    this.chessComponents[i][j] = new EmptySlotComponent(chess, new ChessboardPoint(i, j), ChessColor.NONE);
                chessComponents[i][j].setChessboard(chessComponents);
            }

        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String s = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String str = chessComponents[i][j].toString();
                s += str;
            }
            s += String.valueOf('\n');
        }
        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String str = "";
        int Rcnt = 0;
        int Ncnt = 0;
        int Bcnt = 0;
        int Qcnt = 0;
        int Kcnt = 0;
        int Pcnt = 0;
        int rcnt = 0;
        int ncnt = 0;
        int bcnt = 0;
        int qcnt = 0;
        int kcnt = 0;
        int pcnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char chess = chessComponents[i][j].name;
                if (chess == 'R')
                    Rcnt++;
                else if (chess == 'N')
                    Ncnt++;
                else if (chess == 'B')
                    Bcnt++;
                else if (chess == 'Q')
                    Qcnt++;
                else if (chess == 'K')
                    Kcnt++;
                else if (chess == 'P')
                    Pcnt++;
                else if (chess == 'r')
                    rcnt++;
                else if (chess == 'n')
                    ncnt++;
                else if (chess == 'b')
                    bcnt++;
                else if (chess == 'q')
                    qcnt++;
                else if (chess == 'k')
                    kcnt++;
                else if (chess == 'p')
                    pcnt++;
            }
        }
        if (player == ChessColor.BLACK) {
            if (Kcnt != 1) {
                str += "K " + String.valueOf(1 - Kcnt) + String.valueOf('\n');
            }
            if (Qcnt != 1) {
                str += "Q " + String.valueOf(1 - Qcnt) + String.valueOf('\n');
            }
            if (Rcnt != 2) {
                str += "R " + String.valueOf(2 - Rcnt) + String.valueOf('\n');
            }
            if (Bcnt != 2) {
                str += "B " + String.valueOf(2 - Bcnt) + String.valueOf('\n');
            }
            if (Ncnt != 2) {
                str += "N " + String.valueOf(2 - Ncnt) + String.valueOf('\n');
            }
            if (Pcnt != 8) {
                str += "P " + String.valueOf(8 - Pcnt) + String.valueOf('\n');
            }
        } else {
            if (kcnt != 1) {
                str += "k " + String.valueOf(1 - kcnt) + String.valueOf('\n');
            }
            if (qcnt != 1) {
                str += "q " + String.valueOf(1 - qcnt) + String.valueOf('\n');
            }
            if (rcnt != 2) {
                str += "r " + String.valueOf(2 - rcnt) + String.valueOf('\n');
            }
            if (bcnt != 2) {
                str += "b " + String.valueOf(2 - bcnt) + String.valueOf('\n');
            }
            if (ncnt != 2) {
                str += "n " + String.valueOf(2 - ncnt) + String.valueOf('\n');
            }
            if (pcnt != 8) {
                str += "p " + String.valueOf(8 - pcnt) + String.valueOf('\n');
            }
        }
        return str;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        int X = source.getX();
        int Y = source.getY();
        ChessComponent chess = getChess(X, Y);
        List<ChessboardPoint> steps = chess.canMoveTo();
        steps.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return steps;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = getChess(sourceX, sourceY);
        if(chess.getChessColor() != getCurrentPlayer()){
            return false;
        }
        List<ChessboardPoint> steps = getCanMovePoints(chess.getSource());
        boolean found = false;
        for (ChessboardPoint p : steps) {
            if (p.getX() == targetX && p.getY() == targetY) {
                ChessboardPoint newPos = new ChessboardPoint(targetX, targetY);
                chess.setSource(newPos);
                found = true;
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
                if(getCurrentPlayer() == ChessColor.WHITE){
                    setCurrentPlayer(ChessColor.BLACK);
                }else{
                    setCurrentPlayer(ChessColor.WHITE);
                }
                break;
            }
        }
        return found;
    }
}

