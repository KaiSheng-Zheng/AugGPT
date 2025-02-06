import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ChessComponent toChessComponent(int i, int j, char c){
        return switch (c){
            case 'K' -> new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c);
            case 'k' -> new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c);
            case 'Q' -> new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c);
            case 'q' -> new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c);
            case 'R' -> new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c);
            case 'r' -> new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c);
            case 'B' -> new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c);
            case 'b' -> new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c);
            case 'N' -> new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c);
            case 'n' -> new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c);
            case 'P' -> new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c);
            case 'p' -> new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c);
            default -> new EmptyChessComponent(new ChessboardPoint(i, j));
        };
    }

    public void setChessComponent(int i, int j, ChessComponent chessComponent) {
        chessComponents[i][j] = chessComponent;
    }

    public void syncChessComponents(){
        for (int i = 0;i < chessComponents.length;i++)
            for (int j = 0;j < chessComponents[i].length;j++)
                chessComponents[i][j].setChessComponents(chessComponents);
    }

    public void syncChessComponents(ChessComponent moved){
        chessComponents = moved.getChessComponents();
        syncChessComponents();
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

//    public void initboard(){
//        for (int i = 0;i < chessComponents.length;i++)
//            System.arraycopy(chessComponents[i], 0, chessComponents1[i], 0, chessComponents[i].length);
//    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        chessComponents = new ChessComponent[8][8];
        for (int i = 0;i < 8;i++)
            for (int j = 0;j < 8;j++)
                setChessComponent(i, j ,toChessComponent(i, j, chessboard.get(i).charAt(j)));
        currentPlayer = chessboard.get(8).charAt(0) == 'w' ? ChessColor.WHITE : (chessboard.get(8).charAt(0) == 'b' ? ChessColor.BLACK : ChessColor.NONE);
        syncChessComponents();
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
        char[][] graph = new char[8][8];
        for (int i = 0;i < 8;i++)
            for (int j = 0;j < 8;j++)
                graph[i][j] = chessComponents[i][j].name;
        return  String.valueOf(graph[0]) + "\n" +
                String.valueOf(graph[1]) + "\n" +
                String.valueOf(graph[2]) + "\n" +
                String.valueOf(graph[3]) + "\n" +
                String.valueOf(graph[4]) + "\n" +
                String.valueOf(graph[5]) + "\n" +
                String.valueOf(graph[6]) + "\n" +
                String.valueOf(graph[7]);
    }

    public boolean isUpperLetter(char c){
        return c >= 'A' && c <= 'Z';
    }

    public boolean isLowerLetter(char c){
        return c >= 'a' && c <= 'z';
    }

    public boolean remains(ChessComponent chessComponent, ChessColor player){
        if (chessComponent.name == '_')
            return false;
        if (player == ChessColor.WHITE)
            return isLowerLetter(chessComponent.name);
        return isUpperLetter(chessComponent.name);
    }

    public int toRemainingIndex(char c){
        return switch (c){
            case 'K', 'k' -> 0;
            case 'Q', 'q' -> 1;
            case 'R', 'r' -> 2;
            case 'B', 'b' -> 3;
            case 'N', 'n' -> 4;
            case 'P', 'p' -> 5;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] remaining = new int[6];
        for (int i = 0;i < 8;i++)
            for (int j = 0;j < 8;j++)
                if (remains(chessComponents[i][j], player))
                    remaining[toRemainingIndex(chessComponents[i][j].name)]++;
        remaining[0] = 1 - remaining[0];
        remaining[1] = 1 - remaining[1];
        remaining[2] = 2 - remaining[2];
        remaining[3] = 2 - remaining[3];
        remaining[4] = 2 - remaining[4];
        remaining[5] = 8 - remaining[5];
        return  (remaining[0] > 0 ? ((player == ChessColor.BLACK ? "K " : "k ") + remaining[0] + "\n") : "") +
                (remaining[1] > 0 ? ((player == ChessColor.BLACK ? "Q " : "q ") + remaining[1] + "\n") : "") +
                (remaining[2] > 0 ? ((player == ChessColor.BLACK ? "R " : "r ") + remaining[2] + "\n") : "") +
                (remaining[3] > 0 ? ((player == ChessColor.BLACK ? "B " : "b ") + remaining[3] + "\n") : "") +
                (remaining[4] > 0 ? ((player == ChessColor.BLACK ? "N " : "n ") + remaining[4] + "\n") : "") +
                (remaining[5] > 0 ? ((player == ChessColor.BLACK ? "P " : "p ") + remaining[5] + "\n") : "");
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }

//    public static ChessComponent getChessComponent(ChessboardPoint point) {
//        if (point == null || !point.legal())
//            return new EmptyChessComponent(point);
//        return chessComponents[point.getX()][point.getY()];
//    }

    public ChessComponent getChessComponent(ChessboardPoint point) {
        return chessComponents[point.getX()][point.getY()];
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        if (!source.legal() || (getChessComponent(source).isWhite() != (currentPlayer == ChessColor.WHITE)))
            return false;
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        ArrayList<ChessboardPoint> CanMoveTo = new ArrayList<>(getChessComponent(source).canMoveTo());
        boolean flag = false;
        for (ChessboardPoint i : CanMoveTo)
            if (target.equals(i)) {
                flag = true;
                break;
            }
        if (flag) {
            chessComponents[targetX][targetY] = getChessComponent(source);
            getChessComponent(source).setSource(target);
            chessComponents[sourceX][sourceY] = new EmptyChessComponent(source);
            syncChessComponents();
            setCurrentPlayer(currentPlayer.oppositePlayer());
        }
        return flag;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
//        if (getChessComponent(source) == null) {
//            TestChessComponent ans = new TestChessComponent();
//            return ans.canMoveTo();
//        }
        List<ChessboardPoint> canMovePoints = getChessComponent(source).canMoveTo();
        canMovePoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                return o1.getX() > o2.getX() ? 1 :
                       (o1.getX() < o2.getX() ? -1 :
                       (Integer.compare(o1.getY(), o2.getY())));
            }
        });
        return canMovePoints;
    }
}
