import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent getChessComponent(char c, ChessboardPoint point) {
        switch (c) {
            case 'R':
                return new RookChessComponent(point, ChessColor.BLACK);
            case 'r':
                return new RookChessComponent(point, ChessColor.WHITE);
            case 'N':
                return new KnightChessComponent(point, ChessColor.BLACK);
            case 'n':
                return new KnightChessComponent(point, ChessColor.WHITE);
            case 'B':
                return new BishopChessComponent(point, ChessColor.BLACK);
            case 'b':
                return new BishopChessComponent(point, ChessColor.WHITE);
            case 'Q':
                return new QueenChessComponent(point, ChessColor.BLACK);
            case 'q':
                return new QueenChessComponent(point, ChessColor.WHITE);
            case 'K':
                return new KingChessComponent(point, ChessColor.BLACK);
            case 'k':
                return new KingChessComponent(point, ChessColor.WHITE);
            case 'P':
                return new PawnChessComponent(point, ChessColor.BLACK);
            case 'p':
                return new PawnChessComponent(point, ChessColor.WHITE);
            default:
                return new EmptySlotComponent(point, ChessColor.NONE);
        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            char[] line = chessboard.get(i).toCharArray();
            for (int j = 0; j < line.length; j++) {
                ChessboardPoint point = new ChessboardPoint(i, j);
                chessComponents[i][j] = getChessComponent(line[j], point);
            }
        }
        char player = chessboard.get(8).charAt(0);
        if (player == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
        // set chessboard of component
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].board = chessComponents;
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
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.append(chessComponents[i][j].name);
            }
            board.append("\n");
        }
        return board.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int knight = 2;
        int pawn = 8;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'K':
                            king -= 1;break;
                        case 'Q':
                            queen -= 1;break;
                        case 'R':
                            rook -= 1;break;
                        case 'B':
                            bishop -= 1;break;
                        case 'N':
                            knight -= 1;break;
                        case 'P':
                            pawn -= 1;break;
                    }
                }
            }
            String capture = "";
            if (king > 0){
                capture = capture + "K " + king + "\n";
            }
            if (queen > 0){
                capture = capture + "Q " + queen + "\n";
            }
            if (rook > 0){
                capture = capture + "R " + rook + "\n";
            }
            if (bishop > 0){
                capture = capture + "B " + bishop + "\n";
            }
            if (knight > 0){
                capture = capture + "N " + knight + "\n";
            }
            if (pawn > 0){
                capture = capture + "P " + pawn + "\n";
            }
            return capture;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'k':
                            king -= 1;break;
                        case 'q':
                            queen -= 1;break;
                        case 'r':
                            rook -= 1;break;
                        case 'b':
                            bishop -= 1;break;
                        case 'n':
                            knight -= 1;break;
                        case 'p':
                            pawn -= 1;break;
                    }
                }
            }
            String capture = "";
            if (king > 0){
                capture = capture + "k " + king + "\n";
            }
            if (queen > 0){
                capture = capture + "q " + queen + "\n";
            }
            if (rook > 0){
                capture = capture + "r " + rook + "\n";
            }
            if (bishop > 0){
                capture = capture + "b " + bishop + "\n";
            }
            if (knight > 0){
                capture = capture + "n " + knight + "\n";
            }
            if (pawn > 0){
                capture = capture + "p " + pawn + "\n";
            }
            return capture;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChess(source.getX(), source.getY()).canMoveTo();
        canMovePoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) {
                    return 1;
                } else if (o1.getX() < o2.getX()) {
                    return -1;
                } else {
                    if (o1.getY() > o2.getY()) {
                        return 1;
                    } else if (o1.getY() < o2.getY()) {
                        return -1;
                    }
                }
                return 0;
            }
        });
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        //System.out.println(sourceX+","+sourceY+","+targetX+","+targetY);
        ChessComponent source = chessComponents[sourceX][sourceY];
        if (source.getChessColor() == currentPlayer) {
            ChessboardPoint target = new ChessboardPoint(targetX, targetY);
            if (source.canMoveTo(target)) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(target);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                chessComponents[sourceX][sourceY].board = chessComponents;
                if (currentPlayer == ChessColor.WHITE){
                    currentPlayer = ChessColor.BLACK;
                }else {
                    currentPlayer = ChessColor.WHITE;
                }
                // print board
                //System.out.println(getChessboardGraph());
                return true;
            }
        }
        return false;
    }
}
