import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer = ChessColor.WHITE;

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        }
        else if (chessboard.get(8).charAt(0) == 'b') {
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint source = new ChessboardPoint(i, j);
                PawnChessComponent pw = new PawnChessComponent(ChessColor.WHITE, source,chessComponents);
                BishopChessComponent bw = new BishopChessComponent(ChessColor.WHITE, source, chessComponents);
                KingChessComponent kw = new KingChessComponent(ChessColor.WHITE, source, chessComponents);
                QueenChessComponent qw = new QueenChessComponent(ChessColor.WHITE, source,chessComponents);
                KnightChessComponent nw = new KnightChessComponent(ChessColor.WHITE, source, chessComponents);
                RookChessComponent rw = new RookChessComponent(ChessColor.WHITE, source, chessComponents);
                PawnChessComponent pb = new PawnChessComponent(ChessColor.BLACK, source,chessComponents);
                BishopChessComponent bb = new BishopChessComponent(ChessColor.BLACK, source, chessComponents);
                KingChessComponent kb = new KingChessComponent(ChessColor.BLACK, source, chessComponents);
                QueenChessComponent qb = new QueenChessComponent(ChessColor.BLACK, source,chessComponents);
                KnightChessComponent nb = new KnightChessComponent(ChessColor.BLACK, source, chessComponents);
                RookChessComponent rb = new RookChessComponent(ChessColor.BLACK, source, chessComponents);
                EmptySlotComponent e = new EmptySlotComponent(ChessColor.NONE, source);
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = pw;
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = bw;
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = kw;
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = qw;
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = nw;
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = rw;
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = pb;
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = bb;
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = kb;
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = qb;
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = nb;
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = rb;
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = e;
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
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String a;
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                b.append(this.chessComponents[i][j].name);
            }
            b.append("\n");
        }
        a = String.valueOf(b);
        return a;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int numKing = 0;
        int numQueen = 0;
        int numRooks = 0;
        int numBishops = 0;
        int numKnights = 0;
        int numPawns = 0;
        StringBuilder b = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((Objects.equals(chessComponents[i][j].toString(), "K"))) {
                        numKing++;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "Q")) {
                        numQueen++;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "R")) {
                        numRooks++;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "B")) {
                        numBishops++;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "N")) {
                        numKnights++;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "P")) {
                        numPawns++;
                    }
                }
            }
            if (numKing - 1 != 0) {
                b.append("K ").append(1 - numKing).append("\n");
            }
            if (numQueen - 1 != 0) {
                b.append("Q ").append(1 - numQueen).append("\n");
            }
            if (numRooks != 2) {
                b.append("R ").append(2 - numRooks).append("\n");
            }
            if (numBishops != 2) {
                b.append("B ").append(2 - numBishops).append("\n");
            }
            if (numKnights != 2) {
                b.append("N ").append(2 - numKnights).append("\n");
            }
            if (numPawns != 8) {
                b.append("P ").append(8 - numPawns).append("\n");
            }
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Objects.equals(chessComponents[i][j].toString(), "k")) {
                        numKing++;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "q")) {
                        numQueen++;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "r")) {
                        numRooks++;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "b")) {
                        numBishops++;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "n")) {
                        numKnights++;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "p")) {
                        numPawns++;
                    }
                }
            }
            if (numKing - 1 != 0) {
                b.append("k ").append(1 - numKing).append("\n");
            }
            if (numQueen - 1 != 0) {
                b.append("q ").append(1 - numQueen).append("\n");
            }
            if (numRooks != 2) {
                b.append("r ").append(2 - numRooks).append("\n");
            }
            if (numBishops != 2) {
                b.append("b ").append(2 - numBishops).append("\n");
            }
            if (numKnights != 2) {
                b.append("n ").append(2 - numKnights).append("\n");
            }
            if (numPawns != 8) {
                b.append("p ").append(8 - numPawns).append("\n");
            }
        }
        return String.valueOf(b);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> a=new ArrayList<>();
        for (int i=0;i<getChess(source.getX(), source.getY()).canMoveTo().size();i++){
            a.add(getChess(source.getX(), source.getY()).canMoveTo().get(i));
        }
        return a;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint a = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint b = new ChessboardPoint(targetX, targetY);
        if (getChess(sourceX, sourceY).getChessColor().equals(currentPlayer)) {
            for (int i = 0; i < getCanMovePoints(a).size(); i++) {
                if (getCanMovePoints(a).get(i).getX() == b.getX()&&getCanMovePoints(a).get(i).getY()==b.getY()) {
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else if (currentPlayer == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    }
//                    char name=chessComponents[targetX][targetY].name;
//                    ChessColor color=chessComponents[targetX][targetY].getChessColor();
                    ChessboardPoint t=new ChessboardPoint(targetX,targetY);
                    ChessboardPoint t1=new ChessboardPoint(sourceX,sourceY);
                    ChessColor colors=chessComponents[sourceX][sourceY].getChessColor();
                    if (chessComponents[sourceX][sourceY] instanceof QueenChessComponent){
                            chessComponents[targetX][targetY]=new QueenChessComponent(colors,t,chessComponents);
                        }
                    if (chessComponents[sourceX][sourceY] instanceof BishopChessComponent){
                            chessComponents[targetX][targetY]=new BishopChessComponent(colors,t,chessComponents);
                        }
                    if (chessComponents[sourceX][sourceY] instanceof KnightChessComponent){
                            chessComponents[targetX][targetY]=new KnightChessComponent(colors,t,chessComponents);
                        }
                    if (chessComponents[sourceX][sourceY] instanceof PawnChessComponent){
                            chessComponents[targetX][targetY]=new PawnChessComponent(colors,t,chessComponents);
                        }
                    if (chessComponents[sourceX][sourceY] instanceof RookChessComponent){
                            chessComponents[targetX][targetY]=new RookChessComponent(colors,t,chessComponents);
                        }
                    if (chessComponents[sourceX][sourceY] instanceof KingChessComponent){
                            chessComponents[targetX][targetY]=new KingChessComponent(colors,t,chessComponents);
                        }
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,t1);
                    return true;
                }
            }
        }
        return false;
    }
}

