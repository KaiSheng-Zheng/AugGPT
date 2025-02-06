import java.util.ArrayList;
import java.util.List;



public class ConcreteChessGame implements ChessGame{


    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents ;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer ;
    public static ChessComponent[][] ChessComponents;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
        ChessComponents = chessComponents;
    }

    public static ChessComponent[][] getChessComponents() {
        return ChessComponents;
    }


    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {

        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (Character.isUpperCase(chessboard.get(i).charAt(j))){
                    if (chessboard.get(i).charAt(j)-'R'==0){
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK, 'R');
                    }
                    else if (chessboard.get(i).charAt(j)-'N'==0){
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK, 'N');
                    }
                    else if (chessboard.get(i).charAt(j)-'B'==0){
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK, 'B');
                    }
                    else if (chessboard.get(i).charAt(j)-'Q'==0){
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK, 'Q');
                    }
                    else if (chessboard.get(i).charAt(j)-'K'==0){
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK, 'K');
                    }
                    else if (chessboard.get(i).charAt(j)-'P'==0){
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK, 'P');
                    }
                }
                else if (Character.isLowerCase(chessboard.get(i).charAt(j))){
                    if (chessboard.get(i).charAt(j)-'r'==0){
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE, 'r');
                    }
                    else if (chessboard.get(i).charAt(j)-'n'==0){
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE, 'n');
                    }
                    else if (chessboard.get(i).charAt(j)-'b'==0){
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE, 'b');
                    }
                    else if (chessboard.get(i).charAt(j)-'q'==0){
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE, 'q');
                    }
                    else if (chessboard.get(i).charAt(j)-'k'==0){
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE, 'k');
                    }
                    else if (chessboard.get(i).charAt(j)-'p'==0){
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE, 'p');
                    }
                }
                else if (chessboard.get(i).charAt(j)-'_'==0){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
            }
        }
        if (chessboard.get(8).charAt(0)-'b'==0)
            setCurrentPlayer(ChessColor.BLACK);
        else if (chessboard.get(8).charAt(0)-'w'==0)
            setCurrentPlayer(ChessColor.WHITE);
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
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                sb.append(chessComponents[i][j].name);
            }
            if (i<7)
                sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        int king = 0;
        int knight = 0;
        int pawn = 0;
        int queen = 0;
        int bishop = 0;
        int rook = 0;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j].getChessColor()==player) {
                    if (chessComponents[i][j] instanceof KingChessComponent)
                        king++;
                    else if (chessComponents[i][j] instanceof KnightChessComponent)
                        knight++;
                    else if (chessComponents[i][j] instanceof PawnChessComponent)
                        pawn++;
                    else if (chessComponents[i][j] instanceof QueenChessComponent)
                        queen++;
                    else if (chessComponents[i][j] instanceof BishopChessComponent)
                        bishop++;
                    else if (chessComponents[i][j] instanceof RookChessComponent)
                        rook++;

                }
            }
        }
        if (player==ChessColor.BLACK){
            if (king==0)
                str.append("K 1\n");
            if (queen==0)
                str.append("Q 1\n");
            if (rook<2)
                str.append("R ").append(2 - rook).append("\n");
            if (bishop<2)
                str.append("B ").append(2-bishop).append("\n");
            if (knight<2)
                str.append("N ").append(2-knight).append("\n");
            if (pawn<8)
                str.append("P ").append(8-pawn).append("\n");
        }
        else if (player==ChessColor.WHITE){
            if (king==0)
                str.append("k 1\n");
            if (queen==0)
                str.append("q 1\n");
            if (rook<2)
                str.append("r ").append(2 - rook).append("\n");
            if (bishop<2)
                str.append("b ").append(2-bishop).append("\n");
            if (knight<2)
                str.append("n ").append(2-knight).append("\n");
            if (pawn<8)
                str.append("p ").append(8-pawn).append("\n");
        }

        return str.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor()==getCurrentPlayer()&&chessComponents[sourceX][sourceY].canMoveTo()
                .contains(chessComponents[targetX][targetY].getSource())){
            switch (chessComponents[sourceX][sourceY].name){
                case 'B':
                    chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'B');
                    break;
                case 'K':
                    chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'K');
                    break;
                case 'N':
                    chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'N');
                    break;
                case 'P':
                    chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'P');
                    break;
                case 'Q':
                    chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'Q');
                    break;
                case 'R':
                    chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'R');
                    break;
                case 'b':
                    chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'b');
                    break;
                case 'k':
                    chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'k');
                    break;
                case 'n':
                    chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'n');
                    break;
                case 'p':
                    chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'p');
                    break;
                case 'q':
                    chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'q');
                    break;
                case 'r':
                    chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'r');
                    break;
            }
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            if (getCurrentPlayer()==ChessColor.WHITE)
                currentPlayer = ChessColor.BLACK;
            else if (getCurrentPlayer()==ChessColor.BLACK)
                currentPlayer = ChessColor.WHITE;
            return true;
        }
        return false;
    }


}
