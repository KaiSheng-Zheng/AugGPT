import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(0).length(); j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R': {
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    }
                    case 'r': {
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].name = Character.toLowerCase(chessComponents[i][j].name);
                        break;
                    }
                    case 'Q': {
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    }
                    case 'q': {
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].name = Character.toLowerCase(chessComponents[i][j].name);
                        break;
                    }
                    case 'K': {
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    }
                    case 'k': {
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].name = Character.toLowerCase(chessComponents[i][j].name);
                        break;
                    }
                    case '_': {
                        chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(i, j));
                        break;
                    }
                    case 'N': {
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    }
                    case 'n': {
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].name = Character.toLowerCase(chessComponents[i][j].name);
                        break;
                    }
                    case 'P': {
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    }
                    case 'p': {
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].name = Character.toLowerCase(chessComponents[i][j].name);
                        break;
                    }
                    case 'B': {
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    }
                    case 'b': {
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].name = Character.toLowerCase(chessComponents[i][j].name);
                        break;
                    }
                    default:


                }
            }

        }
        if (Objects.equals(chessboard.get(chessboard.size() - 1), "b")) {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setSource(new ChessboardPoint(i, j));
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(chessComponents);
            }
        }
    }

    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder answer = new StringBuilder();
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                answer.append(component);
            }
            answer.append("\n");
        }
        answer.deleteCharAt(answer.length() - 1);
        return answer.toString();
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder answer = new StringBuilder();
        int r = 2, q = 1, b = 2, n = 2, k = 1, p = 8, R = 2, Q = 1, B = 2, N = 2, K = 1, P = 8;
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                switch (component.toString()) {
                    case "R": {
                        R--;
                        break;
                    }
                    case "r": {
                        r--;
                        break;
                    }
                    case "Q": {
                        Q--;
                        break;
                    }
                    case "q": {
                        q--;
                        break;
                    }
                    case "K": {
                        K--;
                        break;
                    }
                    case "k": {
                        k--;
                        break;
                    }
                    case "N": {
                        N--;
                        break;
                    }
                    case "n": {
                        n--;
                        break;
                    }
                    case "P": {
                        P--;
                        break;
                    }
                    case "p": {
                        p--;
                        break;
                    }
                    case "B": {
                        B--;
                        break;
                    }
                    case "b": {
                        b--;
                        break;
                    }
                    default:


                }
            }

        }
        if (player == ChessColor.WHITE) {
            if (k != 0) {
                answer.append("k ").append(k).append("\n");
            }
            if (q != 0) {
                answer.append("q ").append(q).append("\n");
            }
            if (r != 0) {
                answer.append("r ").append(r).append("\n");
            }
            if (b != 0) {
                answer.append("b ").append(b).append("\n");
            }
            if (n != 0) {
                answer.append("n ").append(n).append("\n");
            }
            if (p != 0) {
                answer.append("p ").append(p).append("\n");
            }
        } else {
            if (K != 0) {
                answer.append("K ").append(K).append("\n");
            }
            if (Q != 0) {
                answer.append("Q ").append(Q).append("\n");
            }
            if (R != 0) {
                answer.append("R ").append(R).append("\n");
            }
            if (B != 0) {
                answer.append("B ").append(B).append("\n");
            }
            if (N != 0) {
                answer.append("N ").append(N).append("\n");
            }
            if (P != 0) {
                answer.append("P ").append(P).append("\n");
            }
        }
        return answer.toString();
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint point) {
        return chessComponents[point.getX()][point.getY()].canMoveTo();
    }

    public boolean moveChess(int x, int y, int dx, int dy) {
        if (chessComponents[x][y].name == '_') {
            return false;
        } else if (currentPlayer==chessComponents[x][y].getChessColor()){
            if (dx >= 0 && dx <= 7 && dy >= 0 && dy <= 7) {
                if (getCanMovePoints(new ChessboardPoint(x, y)).contains(new ChessboardPoint(dx, dy))) {
                    chessComponents[dx][dy]=chessComponents[x][y];
                    chessComponents[dx][dy].setSource(new ChessboardPoint(dx,dy));
                    chessComponents[x][y]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(x,y));
                    chessComponents[x][y].chessboard=chessComponents;
                    if (currentPlayer==ChessColor.BLACK){
                        currentPlayer=ChessColor.WHITE;
                    }else {
                        currentPlayer=ChessColor.BLACK;
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else return false;
    }


}
