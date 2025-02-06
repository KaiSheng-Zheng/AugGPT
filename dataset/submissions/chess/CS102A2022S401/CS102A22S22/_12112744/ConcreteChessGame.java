import java.util.HashMap;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    //Variables
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    //Constructor
    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.NONE;
    }

    //Methods
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessboardPoint nowPoint = new ChessboardPoint(x, y);
                char letter = chessboard.get(x).charAt(y);
                chessComponents[x][y] = letterToComponent(letter, nowPoint);
            }
        }
        String nowColor = chessboard.get(8);
        if (nowColor.equals("w"))
            currentPlayer = ChessColor.WHITE;
        else if (nowColor.equals("b"))
            currentPlayer = ChessColor.BLACK;
        else
            currentPlayer = ChessColor.NONE;

        System.out.print(getChessboardGraph());
    }

    public ChessComponent letterToComponent(char letter, ChessboardPoint chessboardPoint) {
//        ChessColor nowColor = ChessColor.NONE;
//        if (letter >= 65 && letter <= 90)
//            nowColor = ChessColor.BLACK;
//        else if (letter >= 97 && letter <= 122)
//            nowColor = ChessColor.WHITE;
//        return new ChessComponent(chessboardPoint, letter);
        if (letter == 'K' || letter == 'k')
            return new KingChessComponent(chessboardPoint, letter);
        else if (letter == 'Q' || letter == 'q')
            return new QueenChessComponent(chessboardPoint, letter);
        else if (letter == 'R' || letter == 'r')
            return new RookChessComponent(chessboardPoint, letter);
        else if (letter == 'B' || letter == 'b')
            return new BishopChessComponent(chessboardPoint, letter);
        else if (letter == 'N' || letter == 'n')
            return new KnightChessComponent(chessboardPoint, letter);
        else if (letter == 'P' || letter == 'p')
            return new PawnChessComponent(chessboardPoint, letter);
        else
            return new EmptySlotComponent(chessboardPoint, letter);
    }

        @Override
        public ChessColor getCurrentPlayer() {
            return this.currentPlayer;
        }

        @Override
        public ChessComponent getChess(int x, int y){
            return chessComponents[x][y];
        }

        @Override
        public String getChessboardGraph() {
            StringBuilder chessboard = new StringBuilder();
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    chessboard.append(chessComponents[x][y].name);
                }
                chessboard.append("\n");
            }
            return chessboard.toString();
        }

        @Override
        public String getCapturedChess (ChessColor player) {
//            HashMap<ChessComponent, Integer> existComponent = new HashMap<>();
            int lostKing = 1, lostQueen = 1, lostRook = 2, lostBishop = 2, lostKnight = 2, lostPawn = 8;
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (chessComponents[x][y].getChessColor() == player) {
                        char name = chessComponents[x][y].name;
                        if (name == 'K' || name == 'k')
                            lostKing--;
                        else if (name == 'Q' || name == 'q')
                            lostQueen--;
                        else if (name == 'R' || name == 'r')
                            lostRook--;
                        else if (name == 'B' || name == 'b')
                            lostBishop--;
                        else if (name == 'N' || name == 'n')
                            lostKnight--;
                        else if (name == 'P' || name == 'p')
                            lostPawn--;
                    }
                }
            }
            StringBuilder capturedChess = new StringBuilder();
            if (player == ChessColor.BLACK) {
                if (lostKing > 0)
                    capturedChess.append(String.format("K %d\n", lostKing));
                if (lostQueen > 0)
                    capturedChess.append(String.format("Q %d\n", lostQueen));
                if (lostRook > 0)
                    capturedChess.append(String.format("R %d\n", lostRook));
                if (lostBishop > 0)
                    capturedChess.append(String.format("B %d\n", lostBishop));
                if (lostKnight > 0)
                    capturedChess.append(String.format("N %d\n", lostKnight));
                if (lostPawn > 0)
                    capturedChess.append(String.format("P %d\n", lostPawn));
            }
            else {
                if (lostKing > 0)
                    capturedChess.append(String.format("k %d\n", lostKing));
                if (lostQueen > 0)
                    capturedChess.append(String.format("q %d\n", lostQueen));
                if (lostRook > 0)
                    capturedChess.append(String.format("r %d\n", lostRook));
                if (lostBishop > 0)
                    capturedChess.append(String.format("b %d\n", lostBishop));
                if (lostKnight > 0)
                    capturedChess.append(String.format("n %d\n", lostKnight));
                if (lostPawn > 0)
                    capturedChess.append(String.format("p %d\n", lostPawn));
            }

            return capturedChess.toString();
        }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent source = chessComponents[sourceX][sourceY];
        ChessboardPoint destination = new ChessboardPoint(targetX, targetY);
        return source.canMoveTo().contains(destination);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int srcX = source.getX();
        int srcY = source.getY();
        return chessComponents[srcX][srcY].canMoveTo();
    }
}



