import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.

    private ChessColor currentPlayer;
    public void loadChessGame(List<String> chessboard) {
        chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
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
        return chessComponents[0][0].toString() + chessComponents[0][1].toString()+ chessComponents[0][2].toString()
                + chessComponents[0][3].toString() + chessComponents[0][4].toString()+ chessComponents[0][5].toString()
                + chessComponents[0][6].toString()+ chessComponents[0][7].toString()+ "\n" + chessComponents[1][0].toString()
                + chessComponents[1][1].toString()+ chessComponents[1][2].toString()
                + chessComponents[1][3].toString() + chessComponents[1][4].toString()+ chessComponents[1][5].toString()
                + chessComponents[1][6].toString()+ chessComponents[1][7].toString()+ "\n" + chessComponents[2][0].toString() + chessComponents[2][1].toString()+ chessComponents[2][2].toString()
                + chessComponents[2][3].toString() + chessComponents[2][4].toString()+ chessComponents[2][5].toString()
                + chessComponents[2][6].toString()+ chessComponents[2][7].toString()+ "\n" + chessComponents[3][0].toString() + chessComponents[3][1].toString()+ chessComponents[3][2].toString()
                + chessComponents[3][3].toString() + chessComponents[3][4].toString()+ chessComponents[3][5].toString()
                + chessComponents[3][6].toString()+ chessComponents[3][7].toString()+ "\n" + chessComponents[4][0].toString() + chessComponents[4][1].toString()+ chessComponents[4][2].toString()
                + chessComponents[4][3].toString() + chessComponents[4][4].toString()+ chessComponents[4][5].toString()
                + chessComponents[4][6].toString()+ chessComponents[4][7].toString()+ "\n" + chessComponents[5][0].toString() + chessComponents[5][1].toString()+ chessComponents[5][2].toString()
                + chessComponents[5][3].toString() + chessComponents[5][4].toString()+ chessComponents[5][5].toString()
                + chessComponents[5][6].toString()+ chessComponents[5][7].toString()+ "\n" + chessComponents[6][0].toString() + chessComponents[6][1].toString()+ chessComponents[6][2].toString()
                + chessComponents[6][3].toString() + chessComponents[6][4].toString()+ chessComponents[6][5].toString()
                + chessComponents[6][6].toString()+ chessComponents[6][7].toString()+ "\n" + chessComponents[7][0].toString() + chessComponents[7][1].toString()+ chessComponents[7][2].toString()
                + chessComponents[7][3].toString() + chessComponents[7][4].toString()+ chessComponents[7][5].toString()
                + chessComponents[7][6].toString()+ chessComponents[7][7].toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int kingNum = 0;
        int queenNum = 0;
        int bishopNum = 0;
        int knightNum = 0;
        int rookNum = 0;
        int pawnNum = 0;
        String king = "";
        String queen = "";
        String bishop = "";
        String knight = "";
        String rook = "";
        String pawn = "";
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'K') {
                        kingNum++;
                    }
                    if (chessComponents[i][j].getName() == 'Q') {
                        queenNum++;
                    }
                    if (chessComponents[i][j].getName() == 'B') {
                        bishopNum++;
                    }
                    if (chessComponents[i][j].getName() == 'N') {
                        knightNum++;
                    }
                    if (chessComponents[i][j].getName() == 'R') {
                        rookNum++;
                    }
                    if (chessComponents[i][j].getName() == 'P') {
                        pawnNum++;
                    }
                }
            }
            if (kingNum < 1) {
                king = "K 1\n";
            }
            if (queenNum < 1) {
                queen = "Q 1\n";
            }
            if (bishopNum < 2) {
                bishop = "B " + (2 - bishopNum) + "\n";
            }
            if (knightNum < 2) {
                knight = "N " + (2 - knightNum) + "\n";
            }
            if (rookNum < 2) {
                rook = "R " + (2 - rookNum) + "\n";
            }
            if (pawnNum < 8) {
                pawn = "P " + (8 - pawnNum) + "\n";
            }
            return king + queen + rook + bishop + knight + pawn;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'k') {
                        kingNum++;
                    }
                    if (chessComponents[i][j].getName() == 'q') {
                        queenNum++;
                    }
                    if (chessComponents[i][j].getName() == 'b') {
                        bishopNum++;
                    }
                    if (chessComponents[i][j].getName() == 'n') {
                        knightNum++;
                    }
                    if (chessComponents[i][j].getName() == 'r') {
                        rookNum++;
                    }
                    if (chessComponents[i][j].getName() == 'p') {
                        pawnNum++;
                    }
                }
            }
            if (kingNum < 1) {
                king = "k 1\n";
            }
            if (queenNum < 1) {
                queen = "q 1\n";
            }
            if (bishopNum < 2) {
                bishop = "b " + (2 - bishopNum) + "\n";
            }
            if (knightNum < 2) {
                knight = "n " + (2 - knightNum) + "\n";
            }
            if (rookNum < 2) {
                rook = "r " + (2 - rookNum) + "\n";
            }
            if (pawnNum < 8) {
                pawn = "p " + (8 - pawnNum) + "\n";
            }
        return king + queen + rook + bishop + knight + pawn;
    }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
       ChessComponent chess = chessComponents[source.getX()][source.getY()];
        chess.setChessColor(chessComponents[source.getX()][source.getY()].getChessColor());
        chess.setSource(chessComponents[source.getX()][source.getY()].getSource());
        chess.setChessComponents(chessComponents);
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        if (canMovePoints.size() == 0){
            return new ArrayList<>();
        }else {
            for (int i = 0; i < canMovePoints.size(); i++) {
                for (int j = 0; j < canMovePoints.size() - 1 - i; j++) {
                    if (canMovePoints.get(j).getX() > canMovePoints.get(j + 1).getX()) {
                        ChessboardPoint cp = canMovePoints.get(j);
                        canMovePoints.set(j, canMovePoints.get(j + 1));
                        canMovePoints.set(j + 1, cp);
                    } else if (canMovePoints.get(j).getX() == canMovePoints.get(j + 1).getX()) {
                        if (canMovePoints.get(j).getY() > canMovePoints.get(j + 1).getY()) {
                            ChessboardPoint cp = canMovePoints.get(j);
                            canMovePoints.set(j, canMovePoints.get(j + 1));
                            canMovePoints.set(j + 1, cp);
                        }
                    }
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
          ChessComponent chess1 = chessComponents[sourceX][sourceY];
        if (chess1.getChessColor() != currentPlayer){
            return false;
        }
        
        List<ChessboardPoint> chessboardPoints = getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        for (int i = 0; i < chessboardPoints.size(); i++) {
                if (chessboardPoints.get(i).getX() == targetX && chessboardPoints.get(i).getY() == targetY){
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setName(chessComponents[sourceX][sourceY].getName());
                    chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));

                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].setName('_');
                    chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                    if(currentPlayer == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    }else {
                        currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }
            return false;
    }

}