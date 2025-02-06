import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    public static ChessComponent[][] components = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    @Override
    public void loadChessGame(List<String> chessboard) {

        if (chessboard.get(8).charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int c = 0; c < 8; c++) {
                ChessboardPoint source = new ChessboardPoint(i, c);
                if (chessboard.get(i).charAt(c) == '_') {
                    chessComponents[i][c] = new EmptySlotComponent(ChessColor.NONE, source);
                    components[i][c] = new EmptySlotComponent(ChessColor.NONE, source);
                }
                if (chessboard.get(i).charAt(c) == 'K') {
                    chessComponents[i][c] = new KingChessComponent(ChessColor.BLACK, source);
                    components[i][c] = new KingChessComponent(ChessColor.BLACK, source);
                }
                if (chessboard.get(i).charAt(c) == 'k') {
                    chessComponents[i][c] = new KingChessComponent(ChessColor.WHITE, source);
                    components[i][c] = new KingChessComponent(ChessColor.WHITE, source);
                }
                if (chessboard.get(i).charAt(c) == 'Q') {
                    chessComponents[i][c] = new QueenChessComponent(ChessColor.BLACK, source);
                    components[i][c] = new QueenChessComponent(ChessColor.BLACK, source);
                }
                if (chessboard.get(i).charAt(c) == 'q') {
                    chessComponents[i][c] = new QueenChessComponent(ChessColor.WHITE, source);
                    components[i][c] = new QueenChessComponent(ChessColor.WHITE, source);
                }
                if (chessboard.get(i).charAt(c) == 'B') {
                    chessComponents[i][c] = new BishopChessComponent(ChessColor.BLACK, source);
                    components[i][c] = new BishopChessComponent(ChessColor.BLACK, source);
                }
                if (chessboard.get(i).charAt(c) == 'b') {
                    chessComponents[i][c] = new BishopChessComponent(ChessColor.WHITE, source);
                    components[i][c] = new BishopChessComponent(ChessColor.WHITE, source);
                }
                if (chessboard.get(i).charAt(c) == 'N') {
                    chessComponents[i][c] = new KnightChessComponent(ChessColor.BLACK, source);
                    components[i][c] = new KnightChessComponent(ChessColor.BLACK, source);
                }
                if (chessboard.get(i).charAt(c) == 'n') {
                    chessComponents[i][c] = new KnightChessComponent(ChessColor.WHITE, source);
                    components[i][c] = new KnightChessComponent(ChessColor.WHITE, source);
                }
                if (chessboard.get(i).charAt(c) == 'P') {
                    chessComponents[i][c] = new PawnChessComponent(ChessColor.BLACK, source);
                    components[i][c] = new PawnChessComponent(ChessColor.BLACK, source);
                }
                if (chessboard.get(i).charAt(c) == 'p') {
                    chessComponents[i][c] = new PawnChessComponent(ChessColor.WHITE, source);
                    components[i][c] = new PawnChessComponent(ChessColor.WHITE, source);
                }
                if (chessboard.get(i).charAt(c) == 'R') {
                    chessComponents[i][c] = new RookChessComponent(ChessColor.BLACK, source);
                    components[i][c] = new RookChessComponent(ChessColor.BLACK, source);
                }
                if (chessboard.get(i).charAt(c) == 'r') {
                    chessComponents[i][c] = new RookChessComponent(ChessColor.WHITE, source);
                    components[i][c] = new RookChessComponent(ChessColor.WHITE, source);
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
        ArrayList<String> chessboard = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (chessComponents[i].length == 8) {
                StringBuilder Str = new StringBuilder();
                for (int m = 0; m < 8; m++) {
                    Str.append(chessComponents[i][m].name);
                }
                chessboard.add(Str.toString());
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", chessboard.get(0), chessboard.get(1), chessboard.get(2), chessboard.get(3), chessboard.get(4), chessboard.get(5), chessboard.get(6), chessboard.get(7));
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int KING = 1;// numbers of black's chess(first)
        int QUEEN = 1;
        int ROOKS = 2;
        int BISHOPS = 2;
        int KNIGHTS = 2;
        int PAWNS = 8;
        int king = 1;//numbers of white's chess(first)
        int queen = 1;
        int rooks = 2;
        int bishops = 2;
        int knights = 2;
        int pawns = 8;
        for (ChessComponent[] chessComponent : chessComponents) {
            for (int m = 0; m < 8; m++) {
                if (chessComponent[m].name == 'K') {
                    KING -= 1;
                }
                if (chessComponent[m].name == 'Q') {
                    QUEEN -= 1;
                }
                if (chessComponent[m].name == 'R') {
                    ROOKS -= 1;
                }
                if (chessComponent[m].name == 'B') {
                    BISHOPS -= 1;
                }
                if (chessComponent[m].name == 'N') {
                    KNIGHTS -= 1;
                }
                if (chessComponent[m].name == 'P') {
                    PAWNS -= 1;
                }
                if (chessComponent[m].name == 'k') {
                    king -= 1;
                }
                if (chessComponent[m].name == 'q') {
                    queen -= 1;
                }
                if (chessComponent[m].name == 'r') {
                    rooks -= 1;
                }
                if (chessComponent[m].name == 'b') {
                    bishops -= 1;
                }
                if (chessComponent[m].name == 'n') {
                    knights -= 1;
                }
                if (chessComponent[m].name == 'p') {
                    pawns -= 1;
                }
            }
        }
        switch (player) {
            case BLACK:
                StringBuilder Str = new StringBuilder();
                Str.append("");
                if (KING != 0) {
                    Str.append('K');
                    Str.append(' ');
                    Str.append(KING);
                    Str.append("\n");
                }
                if (QUEEN != 0) {
                    Str.append('Q');
                    Str.append(' ');
                    Str.append(QUEEN);
                    Str.append("\n");
                }
                if (ROOKS != 0) {
                    Str.append('R');
                    Str.append(' ');
                    Str.append(ROOKS);
                    Str.append("\n");
                }
                if (BISHOPS != 0) {
                    Str.append('B');
                    Str.append(' ');
                    Str.append(BISHOPS);
                    Str.append("\n");
                }
                if (KNIGHTS != 0) {
                    Str.append('N');
                    Str.append(' ');
                    Str.append(KNIGHTS);
                    Str.append("\n");
                }
                if (PAWNS != 0) {
                    Str.append('P');
                    Str.append(' ');
                    Str.append(PAWNS);
                    Str.append("\n");
                }
                return Str.toString();
            case WHITE:
                StringBuilder str = new StringBuilder();
                str.append("");
                if (king != 0) {
                    str.append('k');
                    str.append(' ');
                    str.append(king);
                    str.append("\n");
                }
                if (queen != 0) {
                    str.append('q');
                    str.append(' ');
                    str.append(queen);
                    str.append("\n");
                }
                if (rooks != 0) {
                    str.append('r');
                    str.append(' ');
                    str.append(rooks);
                    str.append("\n");
                }
                if (bishops != 0) {
                    str.append('b');
                    str.append(' ');
                    str.append(bishops);
                    str.append("\n");
                }
                if (knights != 0) {
                    str.append('n');
                    str.append(' ');
                    str.append(knights);
                    str.append("\n");
                }
                if (pawns != 0) {
                    str.append('p');
                    str.append(' ');
                    str.append(pawns);
                    str.append("\n");
                }
                return str.toString();
        }
        return "";
    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint chessboardPoint) {

        List<ChessboardPoint> points;

        points = chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].canMoveTo();
        points.sort(Comparator.comparingInt(ChessboardPoint::getY));
        points.sort(Comparator.comparingInt(ChessboardPoint::getX));
        return points;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].name == '_') {
            return false;
        }
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            return false;
        }
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        List<ChessboardPoint> canMovePoints = chessComponents[sourceX][sourceY].canMoveTo();
        if (chessComponents[sourceX][sourceY].getChessColor() == chessComponents[targetX][targetY].getChessColor()) {
            return false;
        }


        for (ChessboardPoint canMovePoint : canMovePoints) {
            if (canMovePoint.getX() == targetX && canMovePoint.getY() == targetY) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(target);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, source);
                if (currentPlayer == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } 
                else if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            }
        }

        return false;
    }
}
