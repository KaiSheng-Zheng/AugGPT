import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ConcreteChessGame() {
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                    chessComponents[i][j].ChessBoard = chessComponents;
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 7) {
                    out.append(chessComponents[i][j].name + "\n");
                } else {
                    out.append(chessComponents[i][j].name);
                }
            }
        }
        return out.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int King = 0;
        int Queen = 0;
        int Rook = 0;
        int Bishop = 0;
        int Knight = 0;
        int Pawn = 0;

        if (player == ChessColor.WHITE) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if (chessComponents[j][k].name == 'k') {
                        King++;
                    }
                    if (chessComponents[j][k].name == 'q') {
                        Queen++;
                    }
                    if (chessComponents[j][k].name == 'r') {
                        Rook++;
                    }
                    if (chessComponents[j][k].name == 'b') {
                        Bishop++;
                    }
                    if (chessComponents[j][k].name == 'n') {
                        Knight++;
                    }
                    if (chessComponents[j][k].name == 'p') {
                        Pawn++;
                    }
                }
            }
            StringBuilder out = new StringBuilder();
            if (King != 1) {
                out.append("k 1\n");
            }
            if (Queen != 1) {
                out.append("q 1\n");
            }
            if (Rook != 2) {
                out.append("r " + (2 - Rook) + "\n");
            }
            if (Bishop != 2) {
                out.append("b " + (2 - Bishop) + "\n");
            }
            if (Knight != 2) {
                out.append("n " + (2 - Knight) + "\n");
            }
            if (Pawn != 8) {
                out.append("p " + (8 - Pawn) + "\n");
            }
            return out.toString();
        }


        if (player == ChessColor.BLACK) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if (chessComponents[j][k].name == 'K') {
                        King++;
                    }
                    if (chessComponents[j][k].name == 'Q') {
                        Queen++;
                    }
                    if (chessComponents[j][k].name == 'R') {
                        Rook++;
                    }
                    if (chessComponents[j][k].name == 'B') {
                        Bishop++;
                    }
                    if (chessComponents[j][k].name == 'N') {
                        Knight++;
                    }
                    if (chessComponents[j][k].name == 'P') {
                        Pawn++;
                    }
                }
            }
            StringBuilder out = new StringBuilder();
            if (King != 1) {
                out.append("K 1\n");
            }
            if (Queen != 1) {
                out.append("Q 1\n");
            }
            if (Rook != 2) {
                out.append("R " + (2 - Rook) + "\n");
            }
            if (Bishop != 2) {
                out.append("B " + (2 - Bishop) + "\n");
            }
            if (Knight != 2) {
                out.append("N " + (2 - Knight) + "\n");
            }
            if (Pawn != 8) {
                out.append("P " + (8 - Pawn) + "\n");
            }
            return out.toString();
        }
        return null;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent a = getChess(source.getX(), source.getY());
        if (a.canMoveTo().size() == 0) {
            return a.canMoveTo();
        }

        List<ChessboardPoint> out = new ArrayList<>();
        for (int x = 0; x <= 7; x++) {
            for (int y = 0; y <= 7; y++) {
                for (int k = 0; k < a.canMoveTo().size(); k++) {
                    if (a.canMoveTo().get(k).getX() == x && a.canMoveTo().get(k).getY() == y) {
                        out.add(a.canMoveTo().get(k));
                    }
                }
            }
        }
        return out;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent a = getChess(sourceX, sourceY);
        if (a.getChessColor()==currentPlayer){
        if (a.getChessColor() == ChessColor.NONE) {
            return false;
        }
        for (int i = 0; i < a.canMoveTo().size(); i++) {
            if (a.canMoveTo().get(i).getX() == targetX && a.canMoveTo().get(i).getY() == targetY) {
                ChessboardPoint tagt=new ChessboardPoint(targetX,targetY);
                a.setSource(tagt);
                chessComponents[targetX][targetY] = a;
                chessComponents[targetX][targetY].ChessBoard = chessComponents;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                chessComponents[sourceX][sourceY].ChessBoard = chessComponents;
                if (currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                }else {
                    currentPlayer=ChessColor.BLACK;
               }
                return true;
            }
        }
        }
        return false;
    }
}
