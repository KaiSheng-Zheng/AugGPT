import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer = ChessColor.WHITE;
    public void setChessComponent(int i, int j, ChessComponent chessComponent) {
        chessComponents[i][j] = chessComponent;
    }
    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public ChessComponent switchchess(int i, int j, char c){
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
    @Override
    public void loadChessGame(List<String> chessboard) {
        chessComponents = new ChessComponent[8][8];
        for (int i = 0;i < 8;i++)
            for (int j = 0;j < 8;j++)
            {
                setChessComponent(i, j ,switchchess(i, j, chessboard.get(i).charAt(j)));
            }
        if(chessboard.get(8).charAt(0) == 'w')
            currentPlayer =  ChessColor.WHITE;
        else{ if(chessboard.get(8).charAt(0) == 'b')
        {currentPlayer = ChessColor.BLACK ;}
        else{currentPlayer =ChessColor.NONE;}
        }
        for (int i = 0;i < chessComponents.length;i++)
            for (int j = 0;j < chessComponents[i].length;j++)
                chessComponents[i][j].setChessComponents(chessComponents);
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
    @Override
    public String getCapturedChess(ChessColor player) {
        int[] alive = new int[6];
        int[] death = new int[6];
        int re=0;
        for (int i = 0;i < 8;i++)
            for (int j = 0;j < 8;j++)
                if ((player == ChessColor.WHITE&& chessComponents[i][j].name >= 'a' &&chessComponents[i][j].name <= 'z')||(player == ChessColor.BLACK&& chessComponents[i][j].name >= 'A' &&chessComponents[i][j].name <= 'Z')) {
                    if (chessComponents[i][j].name == 'K' || chessComponents[i][j].name == 'k') {
                        re = 0;
                    }
                    if (chessComponents[i][j].name == 'Q' || chessComponents[i][j].name == 'q') {
                        re = 1;
                    }
                    if (chessComponents[i][j].name == 'R' || chessComponents[i][j].name == 'r') {
                        re = 2;
                    }
                    if (chessComponents[i][j].name == 'B' || chessComponents[i][j].name == 'b') {
                        re = 3;
                    }
                    if (chessComponents[i][j].name == 'N' ||chessComponents[i][j].name == 'n') {
                        re = 4;
                    }
                    if (chessComponents[i][j].name == 'P' ||chessComponents[i][j].name=='p'){re = 5;}
                    death[re]++;
                }
        alive[0] = 1 - death[0];
        alive[1] = 1 - death[1];
        alive[2] = 2 - death[2];
        alive[3] = 2 - death[3];
        alive[4] = 2 - death[4];
        alive[5] = 8 - death[5];
        return  (alive[0] > 0 ? ((player == ChessColor.BLACK ? "K " : "k ") + alive[0] + "\n") : "") +
                (alive[1] > 0 ? ((player == ChessColor.BLACK ? "Q " : "q ") + alive[1] + "\n") : "") +
                (alive[2] > 0 ? ((player == ChessColor.BLACK ? "R " : "r ") + alive[2] + "\n") : "") +
                (alive[3] > 0 ? ((player == ChessColor.BLACK ? "B " : "b ") + alive[3] + "\n") : "") +
                (alive[4] > 0 ? ((player == ChessColor.BLACK ? "N " : "n ") + alive[4] + "\n") : "") +
                (alive[5] > 0 ? ((player == ChessColor.BLACK ? "P " : "p ") + alive[5] + "\n") : "");
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
    public ChessComponent getChessComponent(ChessboardPoint point) {
        return chessComponents[point.getX()][point.getY()];
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        if (!source.right())
            return false;
        if ( (getChessComponent(source).judgecolor() != (currentPlayer == ChessColor.WHITE)))
            return false;
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        ArrayList<ChessboardPoint> CanMoveTo = new ArrayList<>(getChessComponent(source).canMoveTo());
        boolean bo = false;
        for (ChessboardPoint i : CanMoveTo)
            if (target.equals(i))
            {
                bo = true;
                break;
            }
        if (bo) {
            chessComponents[targetX][targetY] = getChessComponent(source);
            getChessComponent(source).setSource(target);
            chessComponents[sourceX][sourceY] = new EmptyChessComponent(source);
            for (int i = 0;i < chessComponents.length;i++)
                for (int j = 0;j < chessComponents[i].length;j++)
                    chessComponents[i][j].setChessComponents(chessComponents);
            setCurrentPlayer(currentPlayer.exchangecolor());
        }
        return bo;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChessComponent(source).canMoveTo();
        canMovePoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if( o1.getX() > o2.getX())
                    return 1;
                else{
                    if(o1.getX() < o2.getX())
                        return -1;
                    else
                        return Integer.compare(o1.getY(), o2.getY());
                }
            }
        });
        return canMovePoints;
    }
}
