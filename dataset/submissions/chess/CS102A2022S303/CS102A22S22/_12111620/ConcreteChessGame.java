import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    private final int[] captureCode;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        captureCode = new int[]{1,1,2,2,2,8,1,1,2,2,2,8};
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char a = chessboard.get(i).charAt(j);
                if (a == 'K'){
                    captureCode[0]--;
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, 'K',this.chessComponents);
                }else if (a == 'Q'){
                    captureCode[1]--;
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, 'Q',this.chessComponents);
                }else if (a == 'R'){
                    captureCode[2]--;
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, 'R',this.chessComponents);
                }else if (a == 'B'){
                    captureCode[3]--;
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, 'B',this.chessComponents);
                }else if (a == 'N'){
                    captureCode[4]--;
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, 'N',this.chessComponents);
                }else if (a == 'P'){
                    captureCode[5]--;
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, 'P',this.chessComponents);
                }else if (a == 'k'){
                    captureCode[6]--;
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, 'k',this.chessComponents);
                }else if (a == 'q'){
                    captureCode[7]--;
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, 'q',this.chessComponents);
                }else if (a == 'r'){
                    captureCode[8]--;
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, 'r',this.chessComponents);
                }else if (a == 'b'){
                    captureCode[9]--;
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, 'b',this.chessComponents);
                }else if (a == 'n'){
                    captureCode[10]--;
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, 'n',this.chessComponents);
                }else if (a == 'p'){
                    captureCode[11]--;
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, 'p',this.chessComponents);
                }else{
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j), ChessColor.NONE, '_');
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w'){
            setCurrentPlayer(ChessColor.WHITE);
        }else{
            setCurrentPlayer(ChessColor.BLACK);
        }
    }

    @Override
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(this.chessComponents[i][j]);
                if (j == 7){
                    str.append("\n");
                }
            }
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player){
        if (player == ChessColor.BLACK){
            StringBuilder blackString = new StringBuilder();
            if (captureCode[0] != 0){
                blackString.append("K ").append(captureCode[0]).append("\n");
            }
            if (captureCode[1] != 0){
                blackString.append("Q ").append(captureCode[1]).append("\n");
            }
            if (captureCode[2] != 0){
                blackString.append("R ").append(captureCode[2]).append("\n");
            }
            if (captureCode[3] != 0){
                blackString.append("B ").append(captureCode[3]).append("\n");
            }
            if (captureCode[4] != 0){
                blackString.append("N ").append(captureCode[4]).append("\n");
            }
            if (captureCode[5] != 0){
                blackString.append("P ").append(captureCode[5]).append("\n");
            }

            return blackString.toString();
        }else if (player == ChessColor.WHITE){
            StringBuilder whiteString = new StringBuilder();
            if (captureCode[6] != 0){
                whiteString.append("k ").append(captureCode[6]).append("\n");
            }
            if (captureCode[7] != 0){
                whiteString.append("q ").append(captureCode[7]).append("\n");
            }
            if (captureCode[8] != 0){
                whiteString.append("r ").append(captureCode[8]).append("\n");
            }
            if (captureCode[9] != 0){
                whiteString.append("b ").append(captureCode[9]).append("\n");
            }
            if (captureCode[10] != 0){
                whiteString.append("n ").append(captureCode[10]).append("\n");
            }
            if (captureCode[11] != 0){
                whiteString.append("p ").append(captureCode[11]).append("\n");
            }

            return whiteString.toString();

        }else{
            return null;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> chessCanMove = chessComponents[sourceX][sourceY].canMoveTo();

        if (chessCanMove.size() == 0){
            return false;
        }
        if (currentPlayer == chessComponents[sourceX][sourceY].getChessColor()){
            int a = 0;
            for (ChessboardPoint chessboardPoint : chessCanMove) {
                if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                    a++;
                    if (chessComponents[targetX][targetY].getName() == 'K'){
                        captureCode[0]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'Q'){
                        captureCode[1]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'R'){
                        captureCode[2]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'B'){
                        captureCode[3]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'N'){
                        captureCode[4]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'P'){
                        captureCode[5]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'k'){
                        captureCode[6]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'q'){
                        captureCode[7]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'r'){
                        captureCode[8]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'b'){
                        captureCode[9]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'n'){
                        captureCode[10]++;
                    }
                    if (chessComponents[targetX][targetY].getName() == 'p'){
                        captureCode[11]++;
                    }
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                }
            }

            if (a == 0){
                return false;
            }
            if (currentPlayer == ChessColor.WHITE){
                setCurrentPlayer(ChessColor.BLACK);
            }else{
                setCurrentPlayer(ChessColor.WHITE);
            }
            return true;
        }
        return false;
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

//    public static void main(String[] args) {
//        List<String> input=new ArrayList<>();
////        input.add("R_BQK__R");
////        input.add("PPPP_PPP");
////        input.add("__N_P___");
////        input.add("___Np___");
////        input.add("_B_p____");
////        input.add("___q_n__");
////        input.add("ppp__ppp");
////        input.add("ppp__ppp");
////        input.add("w");
////                 01234567
//        input.add("R_BQK_PR");
//        input.add("PPP__P__");
//        input.add("__NPP__n");
//        input.add("__N__p__");
//        input.add("_____p__");
//        input.add("p_______");
//        input.add("p___ppp_");
//        input.add("_nbrkb__");
//        input.add("b");
//        ConcreteChessGame yes=new ConcreteChessGame();
//        yes.loadChessGame(input);
//
//        System.out.println(yes.getCapturedChess(ChessColor.WHITE));
//        System.out.println(yes.getCanMovePoints(new ChessboardPoint(0,7)));
//        System.out.println(yes.moveChess(0,7,2,7));
//        System.out.println(yes.getCapturedChess(yes.getCurrentPlayer()));
//        System.out.println(yes.getCurrentPlayer());
//        System.out.println(yes.getChessboardGraph());
//
//
//    }

}
