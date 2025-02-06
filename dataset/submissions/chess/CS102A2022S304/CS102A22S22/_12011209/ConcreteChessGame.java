import java.util.*;

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

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R': chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK); break;
                    case 'r': chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE); break;
                    case 'N': chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK); break;
                    case 'n': chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE); break;
                    case 'B': chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK); break;
                    case 'b': chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE); break;
                    case 'Q': chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK); break;
                    case 'q': chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE); break;
                    case 'K': chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK); break;
                    case 'k': chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE); break;
                    case 'P': chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK); break;
                    case 'p': chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE); break;
                    case '_': chessComponents[i][j] = new EmptySlotComponent(); break;
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                chessComponents[i][j].setChessBoard(chessComponents);
            }
        }
        if(chessboard.get(8).equals("w")) this.currentPlayer = ChessColor.WHITE;
        else if(chessboard.get(8).equals("b")) this.currentPlayer = ChessColor.BLACK;
        else this.currentPlayer = ChessColor.NONE;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].toString());
            }
            if(i < 7) sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        HashMap<String, Integer> existChess = new HashMap<>();
        String s = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(!chessComponents[i][j].toString().equals("_")){
                    if(chessComponents[i][j].getChessColor().equals(player)){
                        if(!existChess.containsKey(chessComponents[i][j].toString()))
                            existChess.put(chessComponents[i][j].toString(), 1);
                        else existChess.replace(chessComponents[i][j].toString(), existChess.get(chessComponents[i][j].toString()) + 1);
                    }
                }
            }
        }

        if(player.equals(ChessColor.WHITE)){
            if(!existChess.containsKey("k")) s += "k 1\n";
            if(!existChess.containsKey("q")) s += "q 1\n";
            if(!existChess.containsKey("r")) s += "r 2\n";
            else if(existChess.get("r") == 1) s += "r 1\n";
            if(!existChess.containsKey("b")) s += "b 2\n";
            else if(existChess.get("b") == 1) s += "b 1\n";
            if(!existChess.containsKey("n")) s += "n 2\n";
            else if(existChess.get("n") == 1) s += "n 1\n";
            if(!existChess.containsKey("p")) s += "p 8\n";
            else if(existChess.get("p") < 8) s += "p " + (8 - existChess.get("p")) + "\n";
        }
        else if(player.equals(ChessColor.BLACK)){
            if(!existChess.containsKey("K")) s += "K 1\n";
            if(!existChess.containsKey("Q")) s += "Q 1\n";
            if(!existChess.containsKey("R")) s += "R 2\n";
            else if(existChess.get("R") == 1) s += "R 1\n";
            if(!existChess.containsKey("B")) s += "B 2\n";
            else if(existChess.get("B") == 1) s += "B 1\n";
            if(!existChess.containsKey("N")) s += "N 2\n";
            else if(existChess.get("N") == 1) s += "N 1\n";
            if(!existChess.containsKey("P")) s += "P 8\n";
            else if(existChess.get("P") < 8) s += "P " + (8 - existChess.get("P")) + "\n";
        }
        return s;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Comparator<ChessboardPoint> MyComparator = (o1, o2) -> {
            if(o1.getX() > o2.getX()) return 1;
            else if(o1.getX() == o2.getX() && o1.getY() > o2.getY()) return 1;
            else if(o1.getX() == o2.getX() && o1.getY() == o2.getY()) return 0;
            else return -1;
        };
        canMovePoints.sort(MyComparator);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent currentChess = this.getChess(sourceX, sourceY);
        if (!currentChess.getChessColor().equals(currentPlayer)) {
            return false;
        }
        for (ChessboardPoint cp: currentChess.canMoveTo()) {
            if(cp.getX() == targetX && cp.getY() == targetY) {
                //need to do: move the chess
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                chessComponents[targetX][targetY] = currentChess;
                List<String> alteredBoard = new ArrayList<>(Arrays.asList(this.getChessboardGraph().split("\n")));
                if(this.getCurrentPlayer().equals(ChessColor.WHITE)) alteredBoard.add("b");
                else if(this.getCurrentPlayer().equals(ChessColor.BLACK)) alteredBoard.add("w");
                this.loadChessGame(alteredBoard);
                return true;
            }
        }
        return false;
    }
}
