

import java.util.ArrayList;
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
        String s = chessboard.get(8);
        if ("w".equalsIgnoreCase(s)) {
            this.currentPlayer = ChessColor.WHITE;
        } else if ("b".equalsIgnoreCase(s)) {
            this.currentPlayer = ChessColor.BLACK;
        }

        for (int i = 0; i < 8; i++) {
            String line = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                char c = line.charAt(j);
                switch (c) {
                    case 'R':
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, c);
                        break;
                    case 'r':
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, c);
                        break;
                    case 'N':
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, c);
                        break;
                    case 'n':
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, c);
                        break;
                    case 'B':
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, c);
                        break;
                    case 'b':
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, c);
                        break;
                    case 'Q':
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, c);
                        break;
                    case 'q':
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, c);
                        break;
                    case 'K':
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, c);
                        break;
                    case 'k':
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, c);
                        break;
                    case 'P':
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, c);
                        break;
                    case 'p':
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, c);
                        break;
                    case '_':
                    default:
                        this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j), null, c);
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
        char c = chessComponents[x][y].name;
        switch (c) {
            case 'R':
                return new RookChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, c);
            case 'r':
                return new RookChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, c);
            case 'N':
                return new KnightChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, c);
            case 'n':
                return new KnightChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, c);
            case 'B':
                return new BishopChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, c);
            case 'b':
                return new BishopChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, c);
            case 'Q':
                return new QueenChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, c);
            case 'q':
                return new QueenChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, c);
            case 'K':
                return new KingChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, c);
            case 'k':
                return new KingChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, c);
            case 'P':
                return new PawnChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, c);
            case 'p':
                return new PawnChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, c);
            case '_':
            default:
                return new EmptySlotComponent(c);
        }
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                builder.append(this.chessComponents[i][j].name);
            }
            if (i != 7) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K = 1, k = 1, Q = 1, q = 1;
        int R = 2, r = 2, B = 2, b = 2, N = 2, n = 2;
        int P = 8, p = 8;

        this.currentPlayer = player;
        String chessboardGraph = this.getChessboardGraph();
        for (int i = 0; i < chessboardGraph.length(); i++) {
            char c = chessboardGraph.charAt(i);
            switch (c) {
                case 'R':
                    R--;
                    break;
                case 'r':
                    r--;
                    break;
                case 'N':
                    N--;
                    break;
                case 'n':
                    n--;
                    break;
                case 'B':
                    B--;
                    break;
                case 'b':
                    b--;
                    break;
                case 'Q':
                    Q--;
                    break;
                case 'q':
                    q--;
                    break;
                case 'K':
                    K--;
                    break;
                case 'k':
                    k--;
                    break;
                case 'P':
                    P--;
                    break;
                case 'p':
                    p--;
                    break;
                default:
                    break;
            }
        }

        StringBuilder builder = new StringBuilder();
        if (currentPlayer.equals(ChessColor.BLACK)) {
            if (K > 0) {
                builder.append("K ").append(K).append("\n");
            }
            if (Q > 0) {
                builder.append("Q ").append(Q).append("\n");
            }
            if (R > 0) {
                builder.append("R ").append(R).append("\n");
            }
            if (B > 0) {
                builder.append("B ").append(B).append("\n");
            }
            if (N > 0) {
                builder.append("N ").append(N).append("\n");
            }
            if (P > 0) {
                builder.append("P ").append(P);
            }
        }else if (currentPlayer.equals(ChessColor.WHITE)) {
            if (k > 0) {
                builder.append("k ").append(k).append("\n");
            }
            if (q > 0) {
                builder.append("q ").append(q).append("\n");
            }
            if (r > 0) {
                builder.append("r ").append(r).append("\n");
            }
            if (b > 0) {
                builder.append("b ").append(b).append("\n");
            }
            if (n > 0) {
                builder.append("n ").append(n).append("\n");
            }
            if (p > 0) {
                builder.append("p ").append(p);
            }
        }

        return builder.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX<0 || sourceX>7 || sourceY<0 || sourceY>7
                ||targetX<0 || targetX>7 || targetY<0 || targetY>7) {
            return false;
        }

        ChessComponent sourceComponent = getChess(sourceX, sourceY);
        if (sourceComponent.getChessColor().equals(this.currentPlayer)) {
            ChessComponent.chessComponents = chessComponents;
            List<ChessboardPoint> pointList = sourceComponent.canMoveTo();
            ChessboardPoint targetComponent = new ChessboardPoint(targetX, targetY);
            for (ChessboardPoint chessboardPoint : pointList) {
                if (chessboardPoint.getX() == targetComponent.getX()
                        && chessboardPoint.getY() == targetComponent.getY()) {
                    this.chessComponents[sourceX][sourceY] = new EmptySlotComponent('_');
                    this.chessComponents[targetX][targetY] = sourceComponent;
                    sourceComponent.setSource(new ChessboardPoint(targetX, targetY));

                    String name = sourceComponent.getChessColor().name();
                    if ("WHITE".equalsIgnoreCase(name)) {
                        this.currentPlayer = ChessColor.BLACK;
                    }else {
                        this.currentPlayer = ChessColor.WHITE;
                    }

                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent.chessComponents = this.chessComponents;
        // 1. find chess according to source
        ChessComponent sourceComponent = getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = sourceComponent.canMoveTo();
        if (canMovePoints == null || canMovePoints.size() == 0) {
            return new ArrayList<>();
        }
        // 3.sort canMovePoints by x - y ascending order
        List<Integer> points = new ArrayList<>();
        for (ChessboardPoint canMovePoint : canMovePoints) {
            ChessComponent targetPoint = getChess(canMovePoint.getX(), canMovePoint.getY());
            boolean flag = targetPoint.getChessColor() != null && targetPoint.getChessColor().equals(sourceComponent.getChessColor());
            if (flag) {
                continue;
            }
            points.add(canMovePoint.getX()*10 + canMovePoint.getY());
        }
        points.sort(Integer::compareTo);

        canMovePoints.clear();
        for (Integer point : points) {
            ChessboardPoint chessboardPoint = new ChessboardPoint(point/10, point%10);
            canMovePoints.add(chessboardPoint);
        }

        return canMovePoints;
    }
}

