import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                char chess = chessboard.get(i).charAt(j);
                switch (chess) {
                    case 'P' ->
                            chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                    case 'R' ->
                            chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                    case 'B' ->
                            chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                    case 'Q' ->
                            chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                    case 'K' ->
                            chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                    case 'N' ->
                            chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                    case 'p' ->
                            chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                    case 'r' ->
                            chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                    case 'q' ->
                            chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                    case 'k' ->
                            chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                    case 'n' ->
                            chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                    case 'b' ->
                            chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                    case '_' ->
                            chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                }
            }
            if (Objects.equals(chessboard.get(chessboard.size() - 1), "w")) {
                currentPlayer = ChessColor.WHITE;
            } else if (Objects.equals(chessboard.get(chessboard.size() - 1), "b")) {
                currentPlayer = ChessColor.BLACK;
            }
        }
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                component.setChessComponents(chessComponents);
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
        StringBuilder chessboardStatus = new StringBuilder();
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                chessboardStatus.append(component.toString());
            }
            chessboardStatus.append("\n");
        }
        return chessboardStatus.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int queenCounter = 0;
        int kingCounter = 0;
        int rookCounter = 0;
        int knightCounter = 0;
        int bishopCounter = 0;
        int pawnCounter = 0;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < getChessboardGraph().length(); i++) {
                if (getChessboardGraph().charAt(i) != '\n') {
                    switch (getChessboardGraph().charAt(i)) {
                        case 'P' -> pawnCounter++;
                        case 'K' -> kingCounter++;
                        case 'R' -> rookCounter++;
                        case 'N' -> knightCounter++;
                        case 'B' -> bishopCounter++;
                        case 'Q' -> queenCounter++;
                    }
                }
            }
            StringBuilder str = new StringBuilder();
            if (kingCounter < 1) {
                str.append("K ");
                str.append(1);
                str.append("\n");
            }
            if (queenCounter < 1) {
                str.append("Q ");
                str.append(1);
                str.append("\n");
            }
            if (rookCounter < 2) {
                str.append("R ");
                str.append(2 - rookCounter);
                str.append("\n");
            }
            if (bishopCounter < 2) {
                str.append("B ");
                str.append(2 - bishopCounter);
                str.append("\n");
            }
            if (knightCounter < 2) {
                str.append("N ");
                str.append(2 - knightCounter);
                str.append("\n");
            }
            if (pawnCounter < 8) {
                str.append("P ");
                str.append(8 - pawnCounter);
                str.append("\n");
            }
            return str.toString();
        } else {
            for (int i = 0; i < getChessboardGraph().length(); i++) {
                if (getChessboardGraph().charAt(i) != '\n') {
                    switch (getChessboardGraph().charAt(i)) {
                        case 'p' -> pawnCounter++;
                        case 'k' -> kingCounter++;
                        case 'r' -> rookCounter++;
                        case 'n' -> knightCounter++;
                        case 'b' -> bishopCounter++;
                        case 'q' -> queenCounter++;
                    }
                }
            }
            StringBuilder str = new StringBuilder();
            if (kingCounter < 1) {
                str.append("k ");
                str.append(1);
                str.append("\n");
            }
            if (queenCounter < 1) {
                str.append("q ");
                str.append(1);
                str.append("\n");
            }
            if (rookCounter < 2) {
                str.append("r ");
                str.append(2 - rookCounter);
                str.append("\n");
            }
            if (bishopCounter < 2) {
                str.append("b ");
                str.append(2 - bishopCounter);
                str.append("\n");
            }
            if (knightCounter < 2) {
                str.append("n ");
                str.append(2 - knightCounter);
                str.append("\n");
            }
            if (pawnCounter < 8) {
                str.append("p ");
                str.append(8 - pawnCounter);
                str.append("\n");
            }
            return str.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        return chess.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer) {
            List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
            for (ChessboardPoint chessboardPoint : move) {
                if (targetX==chessboardPoint.getX()&&targetY==chessboardPoint.getY()) {
                    ChessComponent chessComponent=chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY]=chessComponent;
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                    currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
                    for (ChessComponent[] component : chessComponents) {
                        for (ChessComponent value : component) {
                            value.setChessComponents(chessComponents);
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
