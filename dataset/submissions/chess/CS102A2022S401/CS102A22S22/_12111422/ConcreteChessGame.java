import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class KingChessComponent extends ChessComponent {
    private static ChessboardPoint source;

    public KingChessComponent() {
    }

    public void setSource(ChessboardPoint source) {
        KingChessComponent.source = source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ConcreteChessGame ccg = new ConcreteChessGame();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i <= 7 && y + j <= 7 && x + i >= 0 && y + j >= 0) {
                    if (!(i == 0 && j == 0)) {
                        if (ccg.chessComponent[x + i][y + j].name == '_'
                                || ((ccg.chessComponent[x + i][y + j].name != '_')
                                && !(ccg.chessComponent[x + i][y + j].getchessColor().equals(ccg.chessComponent[x][y].getchessColor())))) {
                            chessboardPoints.add(new ChessboardPoint(x + i, y + j));
                        }
                    }
                }
            }
        }
        return chessboardPoints;
    }
}

class QueenChessComponent extends ChessComponent {
    private static ChessboardPoint source;

    public QueenChessComponent() {
    }

    public void setSource(ChessboardPoint source) {
        QueenChessComponent.source = source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ChessboardPoint chessboardPoint = new ChessboardPoint(x, y);
        ConcreteChessGame ccg = new ConcreteChessGame();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int j = y + 1; j < 8 - y; j++) {
            if (ccg.chessComponent[x][j].name == '_')
                chessboardPoints.add(chessboardPoint.offset(x, j));
        }
        for (int j = y - 1; j > 0; j--) {
            if (ccg.chessComponent[x][j].name == '_')
                chessboardPoints.add(chessboardPoint.offset(x, j));
        }
        for (int i = x + 1; i < 8 - x; i++) {
            if (ccg.chessComponent[i][y].name == '_')
                chessboardPoints.add(chessboardPoint.offset(i, y));
        }
        for (int i = x - 1; i > 0; i--) {
            if (ccg.chessComponent[i][y].name == '_')
                chessboardPoints.add(chessboardPoint.offset(i, y));
        }
        for (int i = 1; i < 8 - x && i < 8 - y; i++) {
            if (ccg.chessComponent[x + i][y + i].name == '_'
                    || (ccg.chessComponent[x + i][y + i].name != '_'
                    && ccg.chessComponent[x + i][y + i].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(chessboardPoint.offset(i, i));
            }
        }
        for (int i = -1; i > -x && i > -y; i--) {
            if (ccg.chessComponent[x + i][y + i].name == '_'
                    || (ccg.chessComponent[x + i][y + i].name != '_'
                    && ccg.chessComponent[x + i][y + i].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(chessboardPoint.offset(i, i));
            }
        }
        for (int i = 1; i < 8 - x && i < 8 - y; i++) {
            if (ccg.chessComponent[x + i][y - i].name == '_'
                    || (ccg.chessComponent[x + i][y - i].name != '_'
                    && ccg.chessComponent[x + i][y - i].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(chessboardPoint.offset(i, i));
            }
        }
        for (int i = -1; i > -x && i > -y; i--) {
            if (ccg.chessComponent[x + i][y - i].name == '_'
                    || (ccg.chessComponent[x + i][y - i].name != '_'
                    && ccg.chessComponent[x + i][y - i].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(chessboardPoint.offset(i, i));
            }
        }
        return chessboardPoints;
    }
}

class RookChessComponent extends ChessComponent {
    private static ChessboardPoint source;

    public RookChessComponent() {
    }

    public void setSource(ChessboardPoint source) {
        RookChessComponent.source = source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ChessboardPoint chessboardPoint = new ChessboardPoint(x, y);
        ConcreteChessGame ccg = new ConcreteChessGame();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int j = y + 1; j < 8 - y; j++) {
            if (ccg.chessComponent[x][j].name == '_')
                chessboardPoints.add(chessboardPoint.offset(x, j));
        }
        for (int j = y - 1; j > 0; j--) {
            if (ccg.chessComponent[x][j].name == '_')
                chessboardPoints.add(chessboardPoint.offset(x, j));
        }
        for (int i = x + 1; i < 8 - x; i++) {
            if (ccg.chessComponent[i][y].name == '_')
                chessboardPoints.add(chessboardPoint.offset(i, y));
        }
        for (int i = x - 1; i > 0; i--) {
            if (ccg.chessComponent[i][y].name == '_')
                chessboardPoints.add(chessboardPoint.offset(i, y));
        }
        return chessboardPoints;
    }
}

class BishopChessComponent extends ChessComponent {
    private static ChessboardPoint source;

    public void setSource(ChessboardPoint source) {
        BishopChessComponent.source = source;
    }

    public BishopChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ChessboardPoint chessboardPoint = new ChessboardPoint(x, y);
        ConcreteChessGame ccg = new ConcreteChessGame();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 1; i < 8 - x && i < 8 - y; i++) {
            if (ccg.chessComponent[x + i][y + i].name == '_'
                    || (ccg.chessComponent[x + i][y + i].name != '_'
                    && ccg.chessComponent[x + i][y + i].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(chessboardPoint.offset(i, i));
            }
        }
        for (int i = -1; i > -x && i > -y; i--) {
            if (ccg.chessComponent[x + i][y + i].name == '_'
                    || (ccg.chessComponent[x + i][y + i].name != '_'
                    && ccg.chessComponent[x + i][y + i].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(chessboardPoint.offset(i, i));
            }
        }
        for (int i = 1; i < 8 - x && i < 8 - y; i++) {
            if (ccg.chessComponent[x + i][y - i].name == '_'
                    || (ccg.chessComponent[x + i][y - i].name != '_'
                    && ccg.chessComponent[x + i][y - i].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(chessboardPoint.offset(i, i));
            }
        }
        for (int i = -1; i > -x && i > -y; i--) {
            if (ccg.chessComponent[x + i][y - i].name == '_'
                    || (ccg.chessComponent[x + i][y - i].name != '_'
                    && ccg.chessComponent[x + i][y - i].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(chessboardPoint.offset(i, i));
            }
        }
        return chessboardPoints;
    }
}

class KnightChessComponent extends ChessComponent {
    private static ChessboardPoint source;

    public void setSource(ChessboardPoint source) {
        KnightChessComponent.source = source;
    }

    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ChessboardPoint chessboardPoint = new ChessboardPoint(x, y);
        ConcreteChessGame ccg = new ConcreteChessGame();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();

        if (x - 2 > 0 && y - 1 > 0) {
            if (ccg.chessComponent[x - 2][y - 1].name == '_'
                    || (ccg.chessComponent[x - 2][y - 1].name != '_'
                    && ccg.chessComponent[x - 2][y - 1].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(new ChessboardPoint(x - 2, y - 1));
            }
        }
        if (x - 2 > 0 && y + 1 < 8) {
            if (ccg.chessComponent[x - 2][y + 1].name == '_'
                    || (ccg.chessComponent[x - 2][y + 1].name != '_'
                    && ccg.chessComponent[x - 2][y + 1].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(new ChessboardPoint(x - 2, y + 1));
            }
        }
        if (x - 1 > 0 && y - 2 > 0) {
            if (ccg.chessComponent[x - 1][y - 2].name == '_'
                    || (ccg.chessComponent[x - 1][y - 2].name != '_'
                    && ccg.chessComponent[x - 1][y - 2].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(new ChessboardPoint(x - 1, y - 2));
            }
        }
        if (x - 1 > 0 && y + 2 < 8) {
            if (ccg.chessComponent[x - 1][y + 2].name == '_'
                    || (ccg.chessComponent[x - 1][y + 2].name != '_'
                    && ccg.chessComponent[x - 1][y + 2].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(new ChessboardPoint(x - 1, y + 2));
            }
        }
        if (x + 1 < 8 && y - 2 > 0) {
            if (ccg.chessComponent[x + 1][y - 2].name == '_'
                    || (ccg.chessComponent[x + 1][y - 2].name != '_'
                    && ccg.chessComponent[x + 1][y - 2].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(new ChessboardPoint(x + 1, y - 2));
            }
        }
        if (x + 1 < 8 && y + 2 < 8) {
            if (ccg.chessComponent[x + 1][y + 2].name == '_'
                    || (ccg.chessComponent[x + 1][y + 2].name != '_'
                    && ccg.chessComponent[x + 1][y + 2].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(new ChessboardPoint(x + 1, y + 2));
            }
        }
        if (x + 2 < 8 && y - 1 > 0) {
            if (ccg.chessComponent[x + 2][y - 1].name == '_'
                    || (ccg.chessComponent[x + 2][y - 1].name != '_'
                    && ccg.chessComponent[x + 2][y - 1].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(new ChessboardPoint(x + 2, y - 1));
            }
        }
        if (x + 2 < 8 && y + 1 < 8) {
            if (ccg.chessComponent[x + 2][y + 1].name == '_'
                    || (ccg.chessComponent[x + 2][y + 1].name != '_'
                    && ccg.chessComponent[x + 2][y + 1].getchessColor() != ccg.chessComponent[x][y].getchessColor())) {
                chessboardPoints.add(new ChessboardPoint(x + 2, y + 1));
            }
        }
        return chessboardPoints;
    }
}

class PawnChessComponent extends ChessComponent {
    private static ChessboardPoint source;

    public void setSource(ChessboardPoint source) {
        PawnChessComponent.source = source;
    }

    public PawnChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ChessboardPoint chessboardPoint = new ChessboardPoint(x, y);
        ConcreteChessGame ccg = new ConcreteChessGame();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if (y == 1) {
            if (ccg.chessComponent[x][y + 1].name == '_') {
                chessboardPoints.add(new ChessboardPoint(x, y + 1));
            }
            if (ccg.chessComponent[x][y + 2].name == '_') {
                chessboardPoints.add(new ChessboardPoint(x, y + 2));
            }
        } else {
            if (ccg.chessComponent[x][y + 1].name == '_') {
                chessboardPoints.add(new ChessboardPoint(x, y + 1));
            }
        }
        return chessboardPoints;
    }
}

class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}


public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    ChessComponent[][] chessComponent = new ChessComponent[8][8];

    public void loadChessGame(List<String> chessboard) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            s.append(chessboard.get(i));
        }
        char[][] split = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                split[i][j] = s.charAt(8 * i + j);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (split[i][j] >= 'A' && split[i][j] <= 'Z') {
                    if (split[i][j] == 'K') chessComponents[i][j] = new KingChessComponent();
                    if (split[i][j] == 'Q') chessComponents[i][j] = new QueenChessComponent();
                    if (split[i][j] == 'R') chessComponents[i][j] = new RookChessComponent();
                    if (split[i][j] == 'B') chessComponents[i][j] = new BishopChessComponent();
                    if (split[i][j] == 'N') chessComponents[i][j] = new KnightChessComponent();
                    if (split[i][j] == 'P') chessComponents[i][j] = new PawnChessComponent();
                    ChessboardPoint c = new ChessboardPoint(i, j);
                    chessComponents[i][j].setSource(c);
                    chessComponents[i][j].setName(split[i][j]);
                    chessComponents[i][j].setchessColor(ChessColor.BLACK);
                }
                if (split[i][j] >= 'a' && split[i][j] <= 'z') {
                    if (split[i][j] == 'k') chessComponents[i][j] = new KingChessComponent();
                    if (split[i][j] == 'q') chessComponents[i][j] = new QueenChessComponent();
                    if (split[i][j] == 'r') chessComponents[i][j] = new RookChessComponent();
                    if (split[i][j] == 'b') chessComponents[i][j] = new BishopChessComponent();
                    if (split[i][j] == 'n') chessComponents[i][j] = new KnightChessComponent();
                    if (split[i][j] == 'p') chessComponents[i][j] = new PawnChessComponent();
                    ChessboardPoint c = new ChessboardPoint(i, j);
                    chessComponents[i][j].setSource(c);
                    chessComponents[i][j].setName(split[i][j]);
                    chessComponents[i][j].setchessColor(ChessColor.WHITE);
                } else {
                    chessComponents[i][j] = new EmptySlotComponent();
                    ChessboardPoint c = new ChessboardPoint(i, j);
                    chessComponents[i][j].setSource(c);
                    chessComponents[i][j].setName(split[i][j]);
                    chessComponents[i][j].setchessColor(ChessColor.NONE);
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessComponent[][] loadChessGame1() {
        this.chessComponent = chessComponents;
        return chessComponent;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String s8 = "";
        for (int j = 0; j < 8; j++) {
            s1 += String.valueOf(chessComponents[0][j].name);
        }
        for (int j = 0; j < 8; j++) {
            s2 += String.valueOf(chessComponents[1][j].name);
        }
        for (int j = 0; j < 8; j++) {
            s3 += String.valueOf(chessComponents[2][j].name);
        }
        for (int j = 0; j < 8; j++) {
            s4 += String.valueOf(chessComponents[3][j].name);
        }
        for (int j = 0; j < 8; j++) {
            s5 += String.valueOf(chessComponents[4][j].name);
        }
        for (int j = 0; j < 8; j++) {
            s6 += String.valueOf(chessComponents[5][j].name);
        }
        for (int j = 0; j < 8; j++) {
            s7 += String.valueOf(chessComponents[6][j].name);
        }
        for (int j = 0; j < 8; j++) {
            s8 += String.valueOf(chessComponents[7][j].name);
        }

        return s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s5 + "\n" + s6 + "\n" + s7 + "\n" + s8 + "\n";
    }

    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.BLACK) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    str.append(String.valueOf(chessComponents[i][j].name));
                }
            }
            int K = 0;
            int Q = 0;
            int R = 0;
            int B = 0;
            int N = 0;
            int P = 0;
            for (int i = 0; i < 64; i++) {
                String s = String.valueOf(str.charAt(i));
                switch (s) {
                    case "K":
                        K++;
                        break;
                    case "Q":
                        Q++;
                        break;
                    case "R":
                        R++;
                        break;
                    case "B":
                        B++;
                        break;
                    case "N":
                        N++;
                        break;
                    case "P":
                        P++;
                        break;
                }
            }
            int K1 = 1 - K;
            int Q1 = 1 - Q;
            int R1 = 2 - R;
            int B1 = 2 - B;
            int N1 = 2 - N;
            int P1 = 8 - P;
            int[] num = new int[]{K1, Q1, R1, B1, N1, P1};
            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < num.length; i++) {
                if (num[i] != 0) {
                    switch (i) {
                        case 0:
                            s1.append("K");
                            s1.append(" ");
                            s1.append(K1);
                            s1.append("\n");
                            break;
                        case 1:
                            s1.append("Q");
                            s1.append(" ");
                            s1.append(Q1);
                            s1.append("\n");
                            break;
                        case 2:
                            s1.append("R");
                            s1.append(" ");
                            s1.append(R1);
                            s1.append("\n");
                            break;
                        case 3:
                            s1.append("B");
                            s1.append(" ");
                            s1.append(B1);
                            s1.append("\n");
                            break;
                        case 4:
                            s1.append("N");
                            s1.append(" ");
                            s1.append(N1);
                            s1.append("\n");
                            break;
                        case 5:
                            s1.append("P");
                            s1.append(" ");
                            s1.append(P1);
                            s1.append("\n");
                            break;
                    }
                }
            }
            return s1.toString();
        } else if (player == ChessColor.WHITE) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    str.append(String.valueOf(chessComponents[i][j].name));
                }
            }
            int K = 0;
            int Q = 0;
            int R = 0;
            int B = 0;
            int N = 0;
            int P = 0;
            for (int i = 0; i < 64; i++) {
                String s = String.valueOf(str.charAt(i));
                switch (s) {
                    case "k":
                        K++;
                        break;
                    case "q":
                        Q++;
                        break;
                    case "r":
                        R++;
                        break;
                    case "b":
                        B++;
                        break;
                    case "n":
                        N++;
                        break;
                    case "p":
                        P++;
                        break;
                }
            }
            int K1 = 1 - K;
            int Q1 = 1 - Q;
            int R1 = 2 - R;
            int B1 = 2 - B;
            int N1 = 2 - N;
            int P1 = 8 - P;
            int[] num = new int[]{K1, Q1, R1, B1, N1, P1};
            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < num.length; i++) {
                if (num[i] != 0) {
                    switch (i) {
                        case 0:
                            s1.append("k");
                            s1.append(" ");
                            s1.append(K1);
                            s1.append("\n");
                            break;
                        case 1:
                            s1.append("q");
                            s1.append(" ");
                            s1.append(Q1);
                            s1.append("\n");
                            break;
                        case 2:
                            s1.append("r");
                            s1.append(" ");
                            s1.append(R1);
                            s1.append("\n");
                            break;
                        case 3:
                            s1.append("b");
                            s1.append(" ");
                            s1.append(B1);
                            s1.append("\n");
                            break;
                        case 4:
                            s1.append("n");
                            s1.append(" ");
                            s1.append(N1);
                            s1.append("\n");
                            break;
                        case 5:
                            s1.append("p");
                            s1.append(" ");
                            s1.append(P1);
                            s1.append("\n");
                            break;
                    }
                }
            }
            return s1.toString();
        } else {
            return "";
        }
    }

    public ChessComponent getChess(int x, int y) {
        ChessComponent chess = new ChessComponent() {
            @Override
            public List<ChessboardPoint> canMoveTo() {
                return null;
            }
        };
        chess.name = chessComponents[x][y].name;
        return chess;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (targetX > 7 || targetY > 7) {
            return false;
        }
        ChessComponent c = this.chessComponents[sourceX][sourceY];
        List<ChessboardPoint> chessboardPoints = c.canMoveTo();
        for (int i = 0; i < chessboardPoints.size(); i++) {
            ChessboardPoint chessboardPoint = chessboardPoints.get(i);
            int x = chessboardPoint.getX();
            int y = chessboardPoint.getY();
            if ((x == targetX && y == targetY) && (c.getchessColor().equals(getCurrentPlayer()))) {
                this.currentPlayer = getCurrentPlayer().equals(ChessColor.WHITE) ? ChessColor.BLACK : ChessColor.WHITE;
                return true;
            }
        }
        return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        ChessComponent chess = this.chessComponents[x][y];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }
}