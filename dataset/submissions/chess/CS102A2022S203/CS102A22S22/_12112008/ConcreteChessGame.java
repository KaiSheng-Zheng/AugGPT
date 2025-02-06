import java.util.*;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;


    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            String str = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                char c = str.charAt(j);
                switch (c) {
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(i, j, ChessColor.BLACK, this);
                        chessComponents[i][j].name='Q';
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(i, j, ChessColor.BLACK, this);
                        chessComponents[i][j].name='P';
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(i, j, ChessColor.BLACK, this);
                        chessComponents[i][j].name='K';
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(i, j, ChessColor.BLACK, this);
                        chessComponents[i][j].name='B';
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(i, j, ChessColor.BLACK, this);
                        chessComponents[i][j].name='N';
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.BLACK, this);
                        chessComponents[i][j].name='R';
                        break;

                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(i, j, ChessColor.WHITE, this);
                        chessComponents[i][j].name='q';
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(i, j, ChessColor.WHITE, this);
                        chessComponents[i][j].name='p';
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(i, j, ChessColor.WHITE, this);
                        chessComponents[i][j].name='k';
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(i, j, ChessColor.WHITE, this);
                        chessComponents[i][j].name='b';
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(i, j, ChessColor.WHITE, this);
                        chessComponents[i][j].name='n';
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.WHITE, this);
                        chessComponents[i][j].name='r';
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(i, j, ChessColor.NONE, this);
                        chessComponents[i][j].name='_';
                        break;

                }

            }
        }
        String str = chessboard.get(8);
        if (str.equals("b") ) currentPlayer = ChessColor.BLACK;
        if (str.equals("w") ) currentPlayer = ChessColor.WHITE;
    }


    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        ChessComponent e = chessComponents[x][y];
        return e;
    }

    @Override
    public String getChessboardGraph() {
        String a = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent e = chessComponents[i][j];
                if (e instanceof KingChessComponent && e.getChessColor() == ChessColor.BLACK) a += "K";
                else if (e instanceof QueenChessComponent && e.getChessColor() == ChessColor.BLACK) a += "Q";
                else if (e instanceof BishopChessComponent && e.getChessColor() == ChessColor.BLACK) a += "B";
                else if (e instanceof PawnChessComponent && e.getChessColor() == ChessColor.BLACK) a += "P";
                else if (e instanceof KnightChessComponent && e.getChessColor() == ChessColor.BLACK) a += "N";
                else if (e instanceof RookChessComponent && e.getChessColor() == ChessColor.BLACK) a += "R";

                else if (e instanceof KingChessComponent && e.getChessColor() == ChessColor.WHITE) a += "k";
                else if (e instanceof QueenChessComponent && e.getChessColor() == ChessColor.WHITE) a += "q";
                else if (e instanceof BishopChessComponent && e.getChessColor() == ChessColor.WHITE) a += "b";
                else if (e instanceof PawnChessComponent && e.getChessColor() == ChessColor.WHITE) a += "p";
                else if (e instanceof KnightChessComponent && e.getChessColor() == ChessColor.WHITE) a += "n";
                else if (e instanceof RookChessComponent && e.getChessColor() == ChessColor.WHITE) a += "r";

                else a += "_";
            }
            a += "\n";
        }

        return a;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int KingNumber = 0;
        int PawnNumber = 0;
        int QueenNumber = 0;
        int KnightNumber = 0;
        int BishopNumber = 0;
        int RookNumber = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent e = chessComponents[i][j];
                if (e instanceof KingChessComponent && e.getChessColor() == player) KingNumber += 1;
                if (e instanceof QueenChessComponent && e.getChessColor() == player) QueenNumber += 1;
                if (e instanceof RookChessComponent && e.getChessColor() == player) RookNumber += 1;
                if (e instanceof BishopChessComponent && e.getChessColor() == player) BishopNumber += 1;
                if (e instanceof KnightChessComponent && e.getChessColor() == player) KnightNumber += 1;
                if (e instanceof PawnChessComponent && e.getChessColor() == player) PawnNumber += 1;
            }
        }

        String str = "";
        if (KingNumber != 1) str += String.format("k %d\n", 1 - KingNumber);
        if (QueenNumber != 1) str += String.format("q %d\n", 1 - QueenNumber);
        if (RookNumber != 2) str += String.format("r %d\n", 2 - RookNumber);
        if (BishopNumber != 2) str += String.format("b %d\n", 2 - BishopNumber);
        if (KnightNumber != 2) str += String.format("n %d\n", 2 - KnightNumber);
        if (PawnNumber != 8) str += String.format("p %d\n", 8 - PawnNumber);
        if (player == ChessColor.BLACK) str = str.toUpperCase();
        return str;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX < 0 || sourceX > 8) return false;
        if (sourceY < 0 || sourceY > 8) return false;
        if (targetX < 0 || targetX > 8) return false;
        if (targetY < 0 || targetY > 8) return false;
        ChessComponent e = chessComponents[sourceX][sourceY];
        ChessComponent e2 = chessComponents[targetX][targetY];
        if (e.getChessColor() != currentPlayer) return false;
        if (e2.getChessColor() == currentPlayer) return false;

        ChessboardPoint chessboardPoint = new ChessboardPoint(targetX, targetY);
        for (int i = 0; i < e.canMoveTo().size(); i++) {
            if (e.canMoveTo().get(i).getX()==chessboardPoint.getX()&&e.canMoveTo().get(i).getY()==chessboardPoint.getY()){
                currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, ChessColor.NONE, this);
                chessComponents[targetX][targetY] = e;
                e.getChessboardPoint().setY(targetY);
                e.getChessboardPoint().setX(targetX);
                e.steps++;
                return true;
            }
        }return false;
//        if (e.canMoveTo().contains(chessboardPoint)) {
//            currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
//            chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, ChessColor.NONE, this);
//            chessComponents[targetX][targetY] = e;
//            e.getChessboardPoint().setY(targetY);
//            e.getChessboardPoint().setX(targetX);
//            e.steps++;
//            return true;
//        } else return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessComponent e = chessComponents[source.getX()][source.getY()];
        list = e.canMoveTo();
        Arrays.sort(list.toArray(), (o1, o2) ->
                {
                    if (((ChessboardPoint) o1).getX() != ((ChessboardPoint) o2).getX()) {
                        return ((ChessboardPoint) o1).getX() - ((ChessboardPoint) o2).getX();
                    } else return ((ChessboardPoint) o1).getY() - ((ChessboardPoint) o2).getY();
                }

        );
        return list;
    }
}
