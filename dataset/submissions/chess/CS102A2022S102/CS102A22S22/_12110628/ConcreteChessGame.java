import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.size() - 1; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R' ->
                            chessComponents[i][j] = new ChessComponent.RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                    case 'N' ->
                            chessComponents[i][j] = new ChessComponent.KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                    case 'B' ->
                            chessComponents[i][j] = new ChessComponent.BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                    case 'Q' ->
                            chessComponents[i][j] = new ChessComponent.QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                    case 'K' ->
                            chessComponents[i][j] = new ChessComponent.KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                    case 'P' ->
                            chessComponents[i][j] = new ChessComponent.PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                    case 'r' ->
                            chessComponents[i][j] = new ChessComponent.RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                    case 'n' ->
                            chessComponents[i][j] = new ChessComponent.KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                    case 'b' ->
                            chessComponents[i][j] = new ChessComponent.BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                    case 'q' ->
                            chessComponents[i][j] = new ChessComponent.QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                    case 'k' ->
                            chessComponents[i][j] = new ChessComponent.KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                    case 'p' ->
                            chessComponents[i][j] = new ChessComponent.PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                    case '_' ->
                            chessComponents[i][j] = new ChessComponent.EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                }
                if (chessboard.get(8).equals("w")) {
                    currentPlayer = ChessColor.WHITE;
                } else {
                    currentPlayer = ChessColor.BLACK;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setConcreteChessGame(this);
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
        StringBuilder media = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                media.append(chessComponents[i][j].name);
            }
            media.append("\n");
        }
        return media.substring(0);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int k = 1;
        int q = 1;
        int r = 2;
        int b = 2;
        int n = 2;
        int p = 8;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor().equals(player)) {
                    if (chessComponents[i][j].name == '_') {
                        continue;
                    }
                    if (chessComponents[i][j].name == 'K' || chessComponents[i][j].name == 'k') {
                        k--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'Q' || chessComponents[i][j].name == 'q') {
                        q--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'R' || chessComponents[i][j].name == 'r') {
                        r--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'B' || chessComponents[i][j].name == 'b') {
                        b--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'N' || chessComponents[i][j].name == 'n') {
                        n--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'P' || chessComponents[i][j].name == 'p') {
                        p--;
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        if (player.equals(ChessColor.WHITE)) {
            if (k != 0) {
                result.append("k ").append(k).append("\n");
            }
            if (q != 0) {
                result.append("q ").append(q).append("\n");
            }
            if (r != 0) {
                result.append("r ").append(r).append("\n");
            }
            if (b != 0) {
                result.append("b ").append(b).append("\n");
            }
            if (n != 0) {
                result.append("n ").append(n).append("\n");
            }
            if (p != 0) {
                result.append("p ").append(p).append("\n");
            }
        } else {
            if (k != 0) {
                result.append("K ").append(k).append("\n");
            }
            if (q != 0) {
                result.append("Q ").append(q).append("\n");
            }
            if (r != 0) {
                result.append("R ").append(r).append("\n");
            }
            if (b != 0) {
                result.append("B ").append(b).append("\n");
            }
            if (n != 0) {
                result.append("N ").append(n).append("\n");
            }
            if (p != 0) {
                result.append("P ").append(p).append("\n");
            }
        }
        return result.substring(0);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = new ArrayList<>(chessComponents[source.getX()][source.getY()].canMoveTo());
        for (int i = 0; i < canMovePoints.size() - 1; i++) {
            for (int j = 0; j < canMovePoints.size() - 1 - i; j++) {
                ChessboardPoint temp;
                if (canMovePoints.get(j).getX() > canMovePoints.get(j + 1).getX()) {
                    temp = canMovePoints.get(j);
                    canMovePoints.set(j, canMovePoints.get(j + 1));
                    canMovePoints.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < canMovePoints.size() - 1; i++) {
            for (int j = 0; j < canMovePoints.size() - 1 - i; j++) {
                ChessboardPoint temp;
                if (canMovePoints.get(j).getX() == canMovePoints.get(j + 1).getX() && canMovePoints.get(j).getY() > canMovePoints.get(j + 1).getY()) {
                    temp = canMovePoints.get(j);
                    canMovePoints.set(j, canMovePoints.get(j + 1));
                    canMovePoints.set(j + 1, temp);
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getSource().offset(targetX - sourceX, targetY - sourceY) == null || (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer)) {
            return false;
        }
        for (ChessboardPoint a : chessComponents[sourceX][sourceY].canMoveTo()) {
            if (a.toString().equals(chessComponents[targetX][targetY].getSource().toString())) {
                if (chessComponents[sourceX][sourceY].getChessColor() != chessComponents[targetX][targetY].getChessColor()){
                    ChessComponent chess1 = getChess(sourceX,sourceY);
                    ChessComponent chess2 = getChess(targetX,targetY);
                    chess1.setSource(new ChessboardPoint(targetX,targetY));
                    if (chess2.getChessColor() == ChessColor.NONE){
                        chess2.setSource(new ChessboardPoint(sourceX,sourceY));
                    }

                    chessComponents[targetX][targetY] = chess1;
                    ChessComponent media = new ChessComponent.EmptySlotComponent(chessComponents[sourceX][sourceY].getSource(),ChessColor.NONE,'_');
                    chessComponents[sourceX][sourceY] = media;
                    for (ChessComponent[] chessComponent : chessComponents) {
                        for (int j = 0; j < chessComponents.length; j++) {
                            chessComponent[j].setConcreteChessGame(this);
                        }
                    }
                    currentPlayer = (currentPlayer == ChessColor.WHITE)? ChessColor.BLACK : ChessColor.WHITE;
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
}