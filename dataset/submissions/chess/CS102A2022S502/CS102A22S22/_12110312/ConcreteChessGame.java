import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            String line = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point = new ChessboardPoint(i, j);
                ChessComponent chess = CharToChess(point, line.charAt(j));
                chessComponents[i][j] = chess;
                chessComponents[i][j].setChessBoard(this.chessComponents);
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String graph = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] == null) {
                    graph += "_";
                } else {
                    graph += chessComponents[i][j].toString();
                }
            }
            graph += "\n";
        }
        return graph;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int knight = 2;
        int pawn = 8;
        String captured = "";
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    ChessComponent chess = chessComponents[i][j];
                    if (chess == null) {
                        continue;
                    } else if (chess.name == 'k') {
                        king--;
                    } else if (chess.name == 'q') {
                        queen--;
                    } else if (chess.name == 'r') {
                        rook--;
                    } else if (chess.name == 'b') {
                        bishop--;
                    } else if (chess.name == 'n') {
                        knight--;
                    } else if (chess.name == 'p') {
                        pawn--;
                    } else {
                        continue;
                    }
                }
            }
            if (king == 1) {
                captured += "k " + king + "\n";
            }
            if (queen == 1) {
                captured += "q " + queen + "\n";
            }
            if (rook > 0) {
                captured += "r " + rook + "\n";
            }
            if (bishop > 0) {
                captured += "b " + bishop + "\n";
            }
            if (knight > 0) {
                captured += "n " + knight + "\n";
            }
            if (pawn > 0) {
                captured += "p " + pawn + "\n";
            }
            return captured;
        } else if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    ChessComponent chess = chessComponents[i][j];
                    if (chess == null) {
                        continue;
                    } else if (chess.name == 'K') {
                        king--;
                    } else if (chess.name == 'Q') {
                        queen--;
                    } else if (chess.name == 'R') {
                        rook--;
                    } else if (chess.name == 'B') {
                        bishop--;
                    } else if (chess.name == 'N') {
                        knight--;
                    } else if (chess.name == 'P') {
                        pawn--;
                    }
                    else {
                        continue;
                    }
                }
            }
            if (king == 1) {
                captured += "K " + king + "\n";
            }
            if (queen == 1) {
                captured += "Q " + queen + "\n";
            }
            if (rook > 0) {
                captured += "R " + rook + "\n";
            }
            if (bishop > 0) {
                captured += "B " + bishop + "\n";
            }
            if (knight > 0) {
                captured += "N " + knight + "\n";
            }
            if (pawn > 0) {
                captured += "P " + pawn + "\n";
            }
            return captured;
        } else {
            return "";
        }


    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = this.getChess(sourceX, sourceY);
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        char name = chess.name;
        ChessComponent target = CharToChess(new ChessboardPoint(targetX, targetY), name);
        if (currentPlayer == chess.getChessColor()) {
            for (ChessboardPoint point : canMovePoints) {
                if (point.getX() == targetX && point.getY() == targetY) {
                    currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
                    this.chessComponents[targetX][targetY] = target;
                    this.chessComponents[targetX][targetY].setChessBoard(this.chessComponents);
                    this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                    return true;
                }
            }
        }
        return false;
    }

    public ChessComponent CharToChess(ChessboardPoint point ,char c) {
        switch (c) {
            case '_':
                return new EmptySlotComponent(point, ChessColor.NONE);
            case 'k':
                return new KingChessComponent(point, ChessColor.WHITE);
            case 'K':
                return new KingChessComponent(point, ChessColor.BLACK);
            case 'q':
                return new QueenChessComponent(point, ChessColor.WHITE);
            case 'Q':
                return new QueenChessComponent(point, ChessColor.BLACK);
            case 'r':
                return new RookChessComponent(point, ChessColor.WHITE);
            case 'R':
                return new RookChessComponent(point, ChessColor.BLACK);
            case 'b':
                return new BishopChessComponent(point, ChessColor.WHITE);
            case 'B':
                return new BishopChessComponent(point, ChessColor.BLACK);
            case 'n':
                return new KnightChessComponent(point, ChessColor.WHITE);
            case 'N':
                return new KnightChessComponent(point, ChessColor.BLACK);
            case 'p':
                return new PawnChessComponent(point, ChessColor.WHITE);
            case 'P':
                return new PawnChessComponent(point, ChessColor.BLACK);
        }
        return null;
    }

    public ChessComponent[][] getChessboard() {
        return chessComponents;
    }
}