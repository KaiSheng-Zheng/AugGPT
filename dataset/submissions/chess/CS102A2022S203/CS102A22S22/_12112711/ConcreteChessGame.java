import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer = ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent('P',new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent('p',new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent('R',new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent('r',new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent('N',new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent('n',new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent('B',new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent('b',new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent('Q',new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent('q',new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent('K',new ChessboardPoint(i,j),ChessColor.BLACK);

                }
                if (chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent('k',new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent('_',new ChessboardPoint(i,j),ChessColor.NONE);
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")){
            currentPlayer = ChessColor.WHITE;
        }else{
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].name = chessboard.get(i).charAt(j);
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(this.chessComponents);
            }
        }

    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder s0 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s0.append(chessComponents[0][i].name);
        }

        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s1.append(chessComponents[1][i].name);
        }

        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s2.append(chessComponents[2][i].name);
        }

        StringBuilder s3 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s3.append(chessComponents[3][i].name);
        }

        StringBuilder s4 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s4.append(chessComponents[4][i].name);
        }

        StringBuilder s5 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s5.append(chessComponents[5][i].name);
        }

        StringBuilder s6 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s6.append(chessComponents[6][i].name);
        }

        StringBuilder s7 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s7.append(chessComponents[7][i].name);
        }

        return s0 + "\n" + s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s5 + "\n" + s6 + "\n" + s7 + "\n";
    }

    public String getCapturedChess(ChessColor player){
        int Rook=0;
        int rook=0;
        int Knight=0;
        int knight=0;
        int Bishop=0;
        int bishop=0;
        int Queen=0;
        int queen=0;
        int King=0;
        int king=0;
        int Pawn=0;
        int pawn=0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].name == 'R'){
                    Rook++;
                }
                if(chessComponents[i][j].name == 'r'){
                    rook++;
                }
                if(chessComponents[i][j].name == 'N'){
                    Knight++;
                }
                if(chessComponents[i][j].name == 'n'){
                    knight++;
                }
                if(chessComponents[i][j].name == 'B'){
                    Bishop++;
                }
                if(chessComponents[i][j].name == 'b'){
                    bishop++;
                }
                if(chessComponents[i][j].name == 'Q'){
                    Queen++;
                }
                if(chessComponents[i][j].name == 'q'){
                    queen++;
                }
                if(chessComponents[i][j].name == 'K'){
                    King++;
                }
                if(chessComponents[i][j].name == 'k'){
                    king++;
                }
                if(chessComponents[i][j].name == 'P'){
                    Pawn++;
                }
                if(chessComponents[i][j].name == 'p'){
                    pawn++;
                }
            }
        }

        StringBuilder strange = new StringBuilder();
        if (player == ChessColor.BLACK&&King != 1){
            strange.append("K 1\n");
        }
        if (player == ChessColor.WHITE&&king != 1){
            strange.append("k 1\n");
        }
        if (player == ChessColor.BLACK&&Queen != 1){
            strange.append("Q 1\n");
        }
        if (player == ChessColor.WHITE&&queen != 1){
            strange.append("q 1\n");
        }
        if (player == ChessColor.BLACK&&Rook != 2){
            if (2-Rook == 1){
                strange.append("R 1\n");
            }else{
                strange.append("R 2\n");
            }
        }
        if (player == ChessColor.WHITE&&rook != 2){
            if (2-rook == 1){
                strange.append("r 1\n");
            }else{
                strange.append("r 2\n");
            }
        }
        if (player == ChessColor.BLACK&&Bishop != 2){
            if (2-Bishop == 1){
                strange.append("B 1\n");
            }else{
                strange.append("B 2\n");
            }
        }
        if (player == ChessColor.WHITE&&bishop != 2){
            if (2-bishop == 1){
                strange.append("b 1\n");
            }else{
                strange.append("b 2\n");
            }
        }
        if (player == ChessColor.BLACK&&Knight != 2){
            if (2-Knight == 1){
                strange.append("N 1\n");
            }else{
                strange.append("N 2\n");
            }
        }
        if (player == ChessColor.WHITE&&knight != 2){
            if (2-knight == 1){
                strange.append("n 1\n");
            }else{
                strange.append("n 2\n");
            }
        }
        if (player == ChessColor.BLACK&&Pawn != 8){
            if (8-Pawn == 7){
                strange.append("P 7\n");
            }
            if (8-Pawn == 6){
                strange.append("P 6\n");
            }
            if (8-Pawn == 5){
                strange.append("P 5\n");
            }
            if (8-Pawn == 4){
                strange.append("P 4\n");
            }
            if (8-Pawn == 3){
                strange.append("P 3\n");
            }
            if (8-Pawn == 2){
                strange.append("P 2\n");
            }
            if (8-Pawn == 1){
                strange.append("P 1\n");
            }
        }
        if (player == ChessColor.WHITE&&pawn != 8){
            if (8-pawn == 7){
                strange.append("p 7\n");
            }
            if (8-pawn == 6){
                strange.append("p 6\n");
            }
            if (8-pawn == 5){
                strange.append("p 5\n");
            }
            if (8-pawn == 4){
                strange.append("p 4\n");
            }
            if (8-pawn == 3){
                strange.append("p 3\n");
            }
            if (8-pawn == 2){
                strange.append("p 2\n");
            }
            if (8-pawn == 1){
                strange.append("p 1\n");
            }
        }
        return strange.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> getCanMovePoints = new ArrayList<>();
        int row = source.getX();
        int col = source.getY();
        int n = chessComponents[row][col].canMoveTo().size();
        int[] get = new int[n];

        for (int i = 0; i < n; i++) {
            get[i] = chessComponents[row][col].canMoveTo().get(i).getX()*10+chessComponents[row][col].canMoveTo().get(i).getY();
        }

        Arrays.sort(get);

        for (int i = 0; i < n; i++) {
            int shiwei = get[i] / 10;
            int gewei = get[i] % 10;
            getCanMovePoints.add(new ChessboardPoint(shiwei,gewei));
        }

        return getCanMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer){
            int n = chessComponents[sourceX][sourceY].canMoveTo().size();
            for (int i = 0; i < n; i++) {
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX &&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY){
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    if (getCurrentPlayer() == ChessColor.BLACK){
                        currentPlayer = ChessColor.WHITE;
                    }else{
                        currentPlayer = ChessColor.BLACK;
                    }
                    
                    return true;
                }
            }
        }else{
            return false;
        }
        return false;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}