import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ConcreteChessGame() {}

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE);
                    chessComponents[i][j].name = 'r';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK);
                    chessComponents[i][j].name = 'R';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE);
                    chessComponents[i][j].name = 'q';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK);
                    chessComponents[i][j].name = 'Q';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE);
                    chessComponents[i][j].name = 'p';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK);
                    chessComponents[i][j].name = 'P';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE);
                    chessComponents[i][j].name = 'n';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK);
                    chessComponents[i][j].name = 'N';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE);
                    chessComponents[i][j].name = 'k';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK);
                    chessComponents[i][j].name = 'K';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE);
                    chessComponents[i][j].name = 'b';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK);
                    chessComponents[i][j].name = 'B';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j), ChessColor.NONE);
                    chessComponents[i][j].name = '_';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
        else
            currentPlayer = ChessColor.WHITE;
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
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        String e = "";
        String f = "";
        String g = "";
        String h = "";
        for (int i = 0; i < 8; i++) {
            a += chessComponents[0][i];
            b += chessComponents[1][i];
            c += chessComponents[2][i];
            d += chessComponents[3][i];
            e += chessComponents[4][i];
            f += chessComponents[5][i];
            g += chessComponents[6][i];
            h += chessComponents[7][i];
        }
        return a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int kingBlack = 0;
        int queenBlack = 0;
        int bishopBlack = 0;
        int knightBlack = 0;
        int rookBlack = 0;
        int pawnBlack = 0;
        int kingWhite = 0;
        int queenWhite = 0;
        int bishopWhite = 0;
        int knightWhite = 0;
        int rookWhite = 0;
        int pawnWhite = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'K')
                    kingBlack++;
                if (chessComponents[i][j].name == 'Q')
                    queenBlack++;
                if (chessComponents[i][j].name == 'B')
                    bishopBlack++;
                if (chessComponents[i][j].name == 'N')
                    knightBlack++;
                if (chessComponents[i][j].name == 'R')
                    rookBlack++;
                if (chessComponents[i][j].name == 'P')
                    pawnBlack++;
                if (chessComponents[i][j].name == 'k')
                    kingWhite++;
                if (chessComponents[i][j].name == 'q')
                    queenWhite++;
                if (chessComponents[i][j].name == 'b')
                    bishopWhite++;
                if (chessComponents[i][j].name == 'n')
                    knightWhite++;
                if (chessComponents[i][j].name == 'r')
                    rookWhite++;
                if (chessComponents[i][j].name == 'p')
                    pawnWhite++;
            }
        }

        StringBuilder sbBlack = new StringBuilder();
        StringBuilder sbWhite = new StringBuilder();
        if (kingBlack<1)
            sbBlack.append("K ").append(1 - kingBlack).append("\n");
        if (queenBlack<1)
            sbBlack.append("Q ").append(1 - queenBlack).append("\n");
        if (rookBlack<2)
            sbBlack.append("R ").append(2 - rookBlack).append("\n");
        if (bishopBlack<2)
            sbBlack.append("B ").append(2 - bishopBlack).append("\n");
        if (knightBlack<2)
            sbBlack.append("N ").append(2 - knightBlack).append("\n");
        if (pawnBlack<8)
            sbBlack.append("P ").append(8 - pawnBlack).append("\n");
        if (kingWhite<1)
            sbWhite.append("k ").append(1 - kingWhite).append("\n");
        if (queenWhite<1)
            sbWhite.append("q ").append(1 - queenWhite).append("\n");
        if (rookWhite<2)
            sbWhite.append("r ").append(2 - rookWhite).append("\n");
        if (bishopWhite<2)
            sbWhite.append("b ").append(2 - bishopWhite).append("\n");
        if (knightWhite<2)
            sbWhite.append("n ").append(2 - knightWhite).append("\n");
        if (pawnWhite<8)
            sbWhite.append("p ").append(8 - pawnWhite).append("\n");

        if (player == ChessColor.BLACK){
            return String.valueOf(sbBlack);
        }
        return String.valueOf(sbWhite);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChess(source.getX(), source.getY()).canMoveTo();
        for (int i = 1; i < canMovePoints.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (canMovePoints.get(i).getX()<canMovePoints.get(j).getX())
                    Collections.swap(canMovePoints,i,j);
                else if (canMovePoints.get(i).getX()==canMovePoints.get(j).getX()){
                    if (canMovePoints.get(i).getY()<canMovePoints.get(j).getY())
                        Collections.swap(canMovePoints,i,j);
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        boolean a = false;

        if (getChess(sourceX, sourceY).getChessColor() != getCurrentPlayer())
            return false;
        else {
            for (int i=0; i<getCanMovePoints(source).size();i++){
                if (getCanMovePoints(source).get(i).getX() == targetX && getCanMovePoints(source).get(i).getY() == targetY){
                    a = true;
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(target);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                    chessComponents[sourceX][sourceY].name = '_';
                    if (getCurrentPlayer() == ChessColor.WHITE)
                        currentPlayer = ChessColor.BLACK;
                    else if (getCurrentPlayer() == ChessColor.BLACK)
                        currentPlayer = ChessColor.WHITE;
                    break;
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessComponents[i][j].setChessboard(chessComponents);
                }
            }
            return a;
        }
    }
}
