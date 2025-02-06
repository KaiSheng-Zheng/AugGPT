import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;


    private List<String> chessboard1 = new ArrayList<>();


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'K' -> {
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), 'K', ChessColor.BLACK);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case 'Q' -> {
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), 'Q', ChessColor.BLACK);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case 'R' -> {
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), 'R', ChessColor.BLACK);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;

                    }
                    case 'B' -> {
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), 'B', ChessColor.BLACK);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case 'N' -> {
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), 'N', ChessColor.BLACK);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case 'P' -> {
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), 'P', ChessColor.BLACK);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case 'k' -> {
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), 'k', ChessColor.WHITE);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case 'q' -> {
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), 'q', ChessColor.WHITE);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case 'r' -> {
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), 'r', ChessColor.WHITE);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case 'b' -> {
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), 'b', ChessColor.WHITE);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case 'n' -> {
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), 'n', ChessColor.WHITE);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case 'p' -> {
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), 'p', ChessColor.WHITE);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                    case '_' -> {
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), '_', ChessColor.NONE);
                        ChessComponent.chess[i][j] = chessComponents[i][j];
                        break;
                    }
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")) {
            currentPlayer = ChessColor.WHITE;
        }
        if (Objects.equals(chessboard.get(8), "b")) {
            currentPlayer = ChessColor.BLACK;
        }
        chessboard1 = chessboard;
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
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= 6; i++) {
            s.append(chessboard1.get(i)).append("\n");
        }
        s.append(chessboard1.get(7));
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {

        int BlackKingCount = 0;
        int BlackQueenCount = 0;
        int BlackRooksCount = 0;
        int BlackBishopsCount = 0;
        int BlackKnightsCount = 0;
        int BlackPawnsCount = 0;

        int WhiteKingCount = 0;
        int WhiteQueenCount = 0;
        int WhiteRooksCount = 0;
        int WhiteBishopsCount = 0;
        int WhiteKnightsCount = 0;
        int WhitePawnsCount = 0;

        String a = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[j][i].name) {
                    case 'K' -> BlackKingCount++;
                    case 'Q' -> BlackQueenCount++;
                    case 'R' -> BlackRooksCount++;
                    case 'B' -> BlackBishopsCount++;
                    case 'N' -> BlackKnightsCount++;
                    case 'P' -> BlackPawnsCount++;

                    case 'k' -> WhiteKingCount++;
                    case 'q' -> WhiteQueenCount++;
                    case 'r' -> WhiteRooksCount++;
                    case 'b' -> WhiteBishopsCount++;
                    case 'n' -> WhiteKnightsCount++;
                    case 'p' -> WhitePawnsCount++;
                }
            }
        }


        if (player == ChessColor.BLACK) {
            if (1 - BlackKingCount > 0) {
                a += "K " + (1 - BlackKingCount) + "\n";
            }
            if (1 - BlackQueenCount > 0) {
                a += "Q " + (1 - BlackQueenCount) + "\n";
            }
            if (2 - BlackRooksCount > 0) {
                a += "R " + (2 - BlackRooksCount) + "\n";
            }
            if (2 - BlackBishopsCount > 0) {
                a += "B " + (2 - BlackBishopsCount) + "\n";
            }
            if (2 - BlackKnightsCount > 0) {
                a += "N " + (2 - BlackKnightsCount) + "\n";
            }
            if (8 - BlackPawnsCount > 0) {
                a += "P " + (8 - BlackPawnsCount) + "\n";
            }
        } else {
            if (1 - WhiteKingCount > 0) {
                a += "k " + (1 - WhiteKingCount) + "\n";
            }
            if (1 - WhiteQueenCount > 0) {
                a += "q " + (1 - WhiteQueenCount) + "\n";
            }
            if (2 - WhiteRooksCount > 0) {
                a += "r " + (2 - WhiteRooksCount) + "\n";
            }
            if (2 - WhiteBishopsCount > 0) {
                a += "b " + (2 - WhiteBishopsCount) + "\n";
            }
            if (2 - WhiteKnightsCount > 0) {
                a += "n " + (2 - WhiteKnightsCount) + "\n";
            }
            if (8 - WhitePawnsCount > 0) {
                a += "p " + (8 - WhitePawnsCount) + "\n";
            }
        }
        return a;
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> Chess1 = chessComponents[source.getX()][source.getY()].canMoveTo();
        List<ChessboardPoint> Chess2 = new ArrayList<>();
        int[][] Chessboard = new int[8][8];
        for (int i = 0; i < Chess1.size(); i++) {
            Chessboard[Chess1.get(i).getX()][Chess1.get(i).getY()] = 1;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Chessboard[i][j] == 1) {
                    Chess2.add(new ChessboardPoint(i, j));
                }
            }
        }
        return Chess2;
    }

 @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> Chess1 = chessComponents[sourceX][sourceY].canMoveTo();
        boolean valid = false;
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer) {
            for (ChessboardPoint chessboardPoint : Chess1) {
                valid = targetX == chessboardPoint.getX() && targetY == chessboardPoint.getY();
            }


        }
        if (valid ) {
            if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer = ChessColor.WHITE;
            }
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), '_', ChessColor.NONE);
            return true;
        } else {
            return false;
        }
    }
}
