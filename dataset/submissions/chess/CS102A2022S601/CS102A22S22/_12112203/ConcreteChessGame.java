import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        if (Objects.equals(String.valueOf(chessboard.get(8)), "w")) currentPlayer = ChessColor.WHITE;
        if (Objects.equals(String.valueOf(chessboard.get(8)), "b")) currentPlayer = ChessColor.BLACK;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        chessComponents[i][j].setChessComponents(chessComponents);
                        break;
                }
            }
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
        StringBuilder carryStr = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                carryStr.append(chessComponents[i][j].name);
                if (j == 7 && i != 7) {
                    carryStr.append("\n");
                }
            }
        }
        return String.valueOf(carryStr);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int kingcount = 0;
        int queencount = 0;
        int rookcount = 0;
        int bishopcount = 0;
        int knightcount = 0;
        int pawncount = 0;
        String reStr = "";
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {// There is no difference between black and white, we must change it to if, because there will be requirements later
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K')
                        kingcount++;
                    if (chessComponents[i][j].name == 'Q')
                        queencount++;
                    if (chessComponents[i][j].name == 'R')
                        rookcount++;
                    if (chessComponents[i][j].name == 'B')
                        bishopcount++;
                    if (chessComponents[i][j].name == 'N')
                        knightcount++;
                    if (chessComponents[i][j].name == 'P')
                        pawncount++;
                }
            }
            if (kingcount != 1) {
                kingcount = 1 - kingcount;
                reStr = reStr + "K " + kingcount + "\n";
            }
            if (queencount != 1) {
                queencount = 1 - queencount;
                reStr = reStr + "Q " + queencount + "\n";
            }
            if (rookcount != 2) {
                rookcount = 2 - rookcount;
                reStr = reStr + "R " + rookcount + "\n";
            }
            if (bishopcount != 2) {
                bishopcount = 2 - bishopcount;
                reStr = reStr + "B " + bishopcount + "\n";
            }
            if (knightcount != 2) {
                knightcount = 2 - knightcount;
                reStr = reStr + "N " + knightcount + "\n";
            }
            if (pawncount != 8) {
                pawncount = 8 - pawncount;
                reStr = reStr + "P " + pawncount + "\n";
            }
            return reStr;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k')
                        kingcount++;
                    if (chessComponents[i][j].name == 'q')
                        queencount++;
                    if (chessComponents[i][j].name == 'r')
                        rookcount++;
                    if (chessComponents[i][j].name == 'b')
                        bishopcount++;
                    if (chessComponents[i][j].name == 'n')
                        knightcount++;
                    if (chessComponents[i][j].name == 'p')
                        pawncount++;
                }
            }
        }
        if (kingcount != 1) {
            kingcount = 1 - kingcount;
            reStr = reStr + "k " + kingcount + "\n";
        }
        if (queencount != 1) {
            queencount = 1 - queencount;
            reStr = reStr + "q " + queencount + "\n";
        }
        if (rookcount != 2) {
            rookcount = 2 - rookcount;
            reStr = reStr + "r " + rookcount + "\n";
        }
        if (bishopcount != 2) {
            bishopcount = 2 - bishopcount;
            reStr = reStr + "b " + bishopcount + "\n";
        }
        if (knightcount != 2) {
            knightcount = 2 - knightcount;
            reStr = reStr + "n " + knightcount + "\n";
        }
        if (pawncount != 8) {
            pawncount = 8 - pawncount;
            reStr = reStr + "p " + pawncount + "\n";
        }
        return reStr;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Comparator comparator = new Comparator();
        canMovePoints.sort(comparator);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() == getCurrentPlayer()) {
            if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX, targetY));//maybe need change the location of the target chess;
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                if (getCurrentPlayer() == ChessColor.WHITE){
                    setCurrentPlayer(ChessColor.BLACK);
                    return true;
                }
                if (getCurrentPlayer() == ChessColor.BLACK){
                    setCurrentPlayer(ChessColor.WHITE);
                    return true;
                }
            }
        }
        return false;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public class Comparator implements java.util.Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint point1, ChessboardPoint point2) {
            if (point1.getX() == point2.getX()) return point1.getY() - point2.getY();
            return point1.getX() - point2.getX();
        }
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
