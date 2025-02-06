import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void loadChessGame(List<String> chessboard) {
        String line;
        for (int i = 0; i < chessboard.size() - 1; i++) {
            line = chessboard.get(i);
            for (int j = 0; j < line.length(); j++) {
                ChessboardPoint point = new ChessboardPoint(i, j);
                switch (line.charAt(j)) {
                    case 'R' -> this.chessComponents[i][j] = new RookChessComponent(point, ChessColor.BLACK, 'R');
                    case 'K' -> {
                        KingChessComponent kingChessComponent = new KingChessComponent(point, ChessColor.BLACK, 'K');
                        chessComponents[i][j] = kingChessComponent;
                    }
                    case 'N' -> {
                        KnightChessComponent knightChessComponent = new KnightChessComponent(point, ChessColor.BLACK, 'N');
                        chessComponents[i][j] = knightChessComponent;
                    }
                    case 'P' -> {
                        PawnChessComponent pawnChessComponent = new PawnChessComponent(point, ChessColor.BLACK, 'P');
                        chessComponents[i][j] = pawnChessComponent;
                    }
                    case 'Q' -> {
                        QueenChessComponent queenChessComponent = new QueenChessComponent(point, ChessColor.BLACK, 'Q');
                        chessComponents[i][j] = queenChessComponent;
                    }
                    case 'B' -> {
                        BishopChessComponent bishopChessComponent = new BishopChessComponent(point, ChessColor.BLACK, 'B');
                        chessComponents[i][j] = bishopChessComponent;
                    }
                    case '_' -> {
                        EmptySlotComponent emptySlotComponent = new EmptySlotComponent(point, ChessColor.NONE, '_');
                        chessComponents[i][j] = emptySlotComponent;
                    }
                    case 'r' -> {
                        RookChessComponent rookChessComponent1 = new RookChessComponent(point, ChessColor.WHITE, 'r');
                        chessComponents[i][j] = rookChessComponent1;
                    }
                    case 'k' -> {
                        KingChessComponent kingChessComponent1 = new KingChessComponent(point, ChessColor.WHITE, 'k');
                        chessComponents[i][j] = kingChessComponent1;
                    }
                    case 'n' -> {
                        KnightChessComponent knightChessComponent1 = new KnightChessComponent(point, ChessColor.WHITE, 'n');
                        chessComponents[i][j] = knightChessComponent1;
                    }
                    case 'p' -> {
                        PawnChessComponent pawnChessComponent1 = new PawnChessComponent(point, ChessColor.WHITE, 'p');
                        chessComponents[i][j] = pawnChessComponent1;
                    }
                    case 'q' -> {
                        QueenChessComponent queenChessComponent1 = new QueenChessComponent(point, ChessColor.WHITE, 'q');
                        chessComponents[i][j] = queenChessComponent1;
                    }
                    case 'b' -> {
                        BishopChessComponent bishopChessComponent1 = new BishopChessComponent(point, ChessColor.WHITE, 'b');
                        chessComponents[i][j] = bishopChessComponent1;
                    }
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(chessComponents);
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        } else {
            currentPlayer = ChessColor.NONE;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                stringBuilder.append(chessComponents[i][j].getName());
            }
            stringBuilder.append("\n");
        }
        return String.valueOf(stringBuilder);
    }

    public String getCapturedChess(ChessColor player) {
        int numr = 2, numb = 2, numn = 2, numk = 1, numq = 1, nump = 8;
        int numR = 2, numB = 2, numN = 2, numK = 1, numQ = 1, numP = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName() == 'R') {
                    numR--;
                } else if (chessComponents[i][j].getName() == 'B') {
                    numB--;
                } else if (chessComponents[i][j].getName() == 'N') {
                    numN--;
                } else if (chessComponents[i][j].getName() == 'K') {
                    numK--;
                } else if (chessComponents[i][j].getName() == 'Q') {
                    numQ--;
                } else if (chessComponents[i][j].getName() == 'P') {
                    numP--;
                } else if (chessComponents[i][j].getName() == 'r') {
                    numr--;
                } else if (chessComponents[i][j].getName() == 'b') {
                    numb--;
                } else if (chessComponents[i][j].getName() == 'n') {
                    numn--;
                } else if (chessComponents[i][j].getName() == 'k') {
                    numk--;
                } else if (chessComponents[i][j].getName() == 'q') {
                    numq--;
                } else if (chessComponents[i][j].getName() == 'p') {
                    nump--;
                }
            }
        }
        StringBuilder str = new StringBuilder();
        if (player.equals(ChessColor.BLACK)) {
            if (numK != 0) {
                str.append("K ").append(numK).append("\n");
            }
            if (numQ != 0) {
                str.append("Q ").append(numQ).append("\n");
            }
            if (numR != 0) {
                str.append("R ").append(numR).append("\n");
            }
            if (numB != 0) {
                str.append("B ").append(numB).append("\n");
            }
            if (numN != 0) {
                str.append("N ").append(numN).append("\n");
            }
            if (numP != 0) {
                str.append("P ").append(numP).append("\n");
            }
        } else if (player.equals(ChessColor.WHITE)) {
            if (numk != 0) {
                str.append("k ").append(numk).append("\n");
            }
            if (numq != 0) {
                str.append("q ").append(numq).append("\n");
            }
            if (numr != 0) {
                str.append("r ").append(numr).append("\n");
            }
            if (numb != 0) {
                str.append("b ").append(numb).append("\n");
            }
            if (numn != 0) {
                str.append("n ").append(numn).append("\n");
            }
            if (nump != 0) {
                str.append("p ").append(nump).append("\n");
            }
        }
        return String.valueOf(str);
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint start = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint end = new ChessboardPoint(targetX, targetY);
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            return false;
        } else {
            if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(end);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(start, ChessColor.NONE, '_');
                if (currentPlayer.equals(ChessColor.WHITE)) {
                    currentPlayer = ChessColor.BLACK;
                } else {
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        //1.comparable lab  2.comparator
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() != o2.getX()) {
                    return o1.getX() - o2.getX();
                } else {
                    return o1.getY() - o2.getY();
                }
            }
        });
        return canMovePoints;
    }


    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
}

//1.empty
class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public EmptySlotComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

//2.King
class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KingChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint point = getSource();
        int[][] directions = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}, {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < 8; i++) {
            int[] a = directions[i];
            ChessboardPoint newK = point.offset(a[0], a[1]);
            if (newK != null && getChessColor() != chessboard[newK.getX()][newK.getY()].getChessColor()) {
                list.add(newK);
            }
        }
        return list;
    }
}

//3.Queen
class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public QueenChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint point = getSource();
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newR1 = point.offset(i, 0);
            if (newR1 != null && getChessColor() == chessboard[newR1.getX()][newR1.getY()].getChessColor()) {
                break;
            } else if (newR1 != null && chessboard[newR1.getX()][newR1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newR1);
            } else if (newR1!=null){
                list.add(newR1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newR1 = point.offset(-i, 0);
            if (newR1 != null && getChessColor() == chessboard[newR1.getX()][newR1.getY()].getChessColor()) {
                break;
            } else if (newR1 != null && chessboard[newR1.getX()][newR1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newR1);
            } else if (newR1!=null){
                list.add(newR1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newR1 = point.offset(0, i);
            if (newR1 != null && getChessColor() == chessboard[newR1.getX()][newR1.getY()].getChessColor()) {
                break;
            } else if (newR1 != null && chessboard[newR1.getX()][newR1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newR1);
            } else if (newR1!=null){
                list.add(newR1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newR1 = point.offset(0, -i);
            if (newR1 != null && getChessColor() == chessboard[newR1.getX()][newR1.getY()].getChessColor()) {
                break;
            } else if (newR1 != null && chessboard[newR1.getX()][newR1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newR1);
            } else if (newR1!=null){
                list.add(newR1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newB1 = point.offset(i, i);
            if (newB1 != null && getChessColor() == chessboard[newB1.getX()][newB1.getY()].getChessColor()) {
                break;
            } else if (newB1 != null && chessboard[newB1.getX()][newB1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newB1);
            } else if (newB1!=null){
                list.add(newB1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newB1 = point.offset(-i, i);
            if (newB1 != null && getChessColor() == chessboard[newB1.getX()][newB1.getY()].getChessColor()) {
                break;
            } else if (newB1 != null && chessboard[newB1.getX()][newB1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newB1);
            } else if (newB1!=null){
                list.add(newB1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newB1 = point.offset(i, -i);
            if (newB1 != null && getChessColor() == chessboard[newB1.getX()][newB1.getY()].getChessColor()) {
                break;
            } else if (newB1 != null && chessboard[newB1.getX()][newB1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newB1);
            } else if (newB1!=null){
                list.add(newB1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newB1 = point.offset(-i, -i);
            if (newB1 != null && getChessColor() == chessboard[newB1.getX()][newB1.getY()].getChessColor()) {
                break;
            } else if (newB1 != null && chessboard[newB1.getX()][newB1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newB1);
            } else if (newB1!=null){
                list.add(newB1);
                break;
            }
        }
        return list;
    }
}

//4.Rook
class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public RookChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint point = getSource();
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newR1 = point.offset(i, 0);
            if (newR1 != null && getChessColor() == chessboard[newR1.getX()][newR1.getY()].getChessColor()) {
                break;
            } else if (newR1 != null && chessboard[newR1.getX()][newR1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newR1);
            } else if (newR1!=null){
                list.add(newR1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newR1 = point.offset(-i, 0);
            if (newR1 != null && getChessColor() == chessboard[newR1.getX()][newR1.getY()].getChessColor()) {
                break;
            } else if (newR1 != null && chessboard[newR1.getX()][newR1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newR1);
            } else if (newR1!=null){
                list.add(newR1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newR1 = point.offset(0, i);
            if (newR1 != null && getChessColor() == chessboard[newR1.getX()][newR1.getY()].getChessColor()) {
                break;
            } else if (newR1 != null && chessboard[newR1.getX()][newR1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newR1);
            } else if (newR1!=null){
                list.add(newR1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newR1 = point.offset(0, -i);
            if (newR1 != null && getChessColor() == chessboard[newR1.getX()][newR1.getY()].getChessColor()) {
                break;
            } else if (newR1 != null && chessboard[newR1.getX()][newR1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newR1);
            } else if (newR1!=null){
                list.add(newR1);
                break;
            }
        }
        return list;
    }
}

//5.Bishop
class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public BishopChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint point = getSource();
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newB1 = point.offset(i, i);
            if (newB1 != null && getChessColor() == chessboard[newB1.getX()][newB1.getY()].getChessColor()) {
                break;
            } else if (newB1 != null && chessboard[newB1.getX()][newB1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newB1);
            } else if (newB1!=null){
                list.add(newB1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newB1 = point.offset(-i, i);
            if (newB1 != null && getChessColor() == chessboard[newB1.getX()][newB1.getY()].getChessColor()) {
                break;
            } else if (newB1 != null && chessboard[newB1.getX()][newB1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newB1);
            } else if (newB1!=null){
                list.add(newB1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newB1 = point.offset(i, -i);
            if (newB1 != null && getChessColor() == chessboard[newB1.getX()][newB1.getY()].getChessColor()) {
                break;
            } else if (newB1 != null && chessboard[newB1.getX()][newB1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newB1);
            } else if (newB1!=null){
                list.add(newB1);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newB1 = point.offset(-i, -i);
            if (newB1 != null && getChessColor() == chessboard[newB1.getX()][newB1.getY()].getChessColor()) {
                break;
            } else if (newB1 != null && chessboard[newB1.getX()][newB1.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newB1);
            } else if (newB1!=null){
                list.add(newB1);
                break;
            }
        }
        return list;
    }
}

//6.Knight
class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
//???         setChessboard(chessboard);
        ChessComponent chessN = new KnightChessComponent(getSource(), getChessColor(), getName());
        ChessboardPoint point = getSource();
        int[][] directions = {{-2, -1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, 2}, {1, -2}, {-2, 1}};
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int[] a = directions[i];
            ChessboardPoint newN = point.offset(a[0], a[1]);
            if (newN != null && chessN.getChessColor() != chessboard[newN.getX()][newN.getY()].getChessColor()) {
                list.add(newN);
            }
        }
        return list;
    }

}

//7.Pawn
class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public PawnChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint point = getSource();
        List<ChessboardPoint> list = new ArrayList<>();
        if (getName() == 'P') {
            if (point.getX() == 1) {
                for (int i = 1; i < 3; i++) {
                    ChessboardPoint new1 = point.offset(i, 0);
                    if (chessboard[new1.getX()][new1.getY()].getChessColor() == ChessColor.NONE) {
                        list.add(new1);
                    } else {
                        break;
                    }
                }
            } else {
                ChessboardPoint new1 = point.offset(1, 0);
                if (new1 != null && chessboard[new1.getX()][new1.getY()].getChessColor() == ChessColor.NONE) {
                    list.add(new1);
                }
            }
            ChessboardPoint new1 = point.offset(1, -1);
            if (new1 != null && chessboard[new1.getX()][new1.getY()].getChessColor() == ChessColor.WHITE) {
                list.add(new1);
            }
            ChessboardPoint new2 = point.offset(1, 1);
            if (new2 != null && chessboard[new2.getX()][new2.getY()].getChessColor() == ChessColor.WHITE) {
                list.add(new2);
            }
        } else if (getName() == 'p') {
            if (point.getX() == 6) {
                for (int i = 1; i < 3; i++) {
                    ChessboardPoint new1 = point.offset(-i, 0);
                    if (new1 != null && chessboard[new1.getX()][new1.getY()].getChessColor() == ChessColor.NONE) {
                        list.add(new1);
                    } else {
                        break;
                    }
                }
            } else {
                ChessboardPoint new1 = point.offset(-1, 0);
                if (new1 != null && chessboard[new1.getX()][new1.getY()].getChessColor() == ChessColor.NONE) {
                    list.add(new1);
                }
            }
            ChessboardPoint new1 = point.offset(-1, -1);
            if (new1 != null && chessboard[new1.getX()][new1.getY()].getChessColor() == ChessColor.BLACK) {
                list.add(new1);
            }
            ChessboardPoint new2 = point.offset(-1, 1);
            if (new2 != null && chessboard[new2.getX()][new2.getY()].getChessColor() == ChessColor.BLACK) {
                list.add(new1);
            }
        }
        return list;
    }
}

