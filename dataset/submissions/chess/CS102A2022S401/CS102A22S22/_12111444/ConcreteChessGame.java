import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    public static ChessComponent[][] chessComponent = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    int m = 0;
    public void ConcreteChessGame(ChessColor currentPlayer, ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint source=new ChessboardPoint(i,j);
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK);
                    chessComponent[i][j] = new KingChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);

                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK);
                    chessComponent[i][j] = new QueenChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK);
                    chessComponent[i][j] = new RookChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK);
                    chessComponent[i][j] = new BishopChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK);
                    chessComponent[i][j] = new KnightChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK);
                    chessComponent[i][j] = new PawnChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE);
                    chessComponent[i][j] = new EmptySlotComponent(ChessColor.NONE);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE);
                    chessComponent[i][j] = new KingChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE);
                    chessComponent[i][j] = new QueenChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE);
                    chessComponent[i][j] = new RookChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE);
                    chessComponent[i][j] = new BishopChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE);
                    chessComponent[i][j] = new KnightChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE);
                    chessComponent[i][j] = new PawnChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(source);
                    chessComponent[i][j].setSource(source);
                }
            }
        }
        if(chessboard.get(8).charAt(0) == 'w'){
            currentPlayer = ChessColor.WHITE;
        }
        if(chessboard.get(8).charAt(0) == 'b'){
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j<8; j++){
                out.append(chessComponents[i][j].getName());
            }
            out.append("\n");
        }
        String ans = out.toString();
        return ans;
    }

    public String getCapturedChess(ChessColor player) {
        int counterK = 0;
        int counterQ = 0;
        int counterR = 0;
        int counterB = 0;
        int counterN = 0;
        int counterP = 0;
        int counter_k = 0;
        int counter_q = 0;
        int counter_r = 0;
        int counter_b = 0;
        int counter_n = 0;
        int counter_p = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'K'){
                    counterK += 1;
                }
                if(chessComponents[i][j].name == 'Q'){
                    counterQ += 1;
                }
                if(chessComponents[i][j].name == 'R'){
                    counterR += 1;
                }
                if(chessComponents[i][j].name == 'B'){
                    counterB += 1;
                }
                if(chessComponents[i][j].name == 'N'){
                    counterN += 1;
                }
                if(chessComponents[i][j].name == 'P'){
                    counterP += 1;
                }
                if (chessComponents[i][j].name == 'k'){
                    counter_k += 1;
                }
                if(chessComponents[i][j].name == 'q'){
                    counter_q += 1;
                }
                if(chessComponents[i][j].name == 'r'){
                    counter_r += 1;
                }
                if(chessComponents[i][j].getName() == 'b'){
                    counter_b += 1;
                }
                if(chessComponents[i][j].getName() == 'n'){
                    counter_n += 1;
                }
                if(chessComponents[i][j].getName() == 'p'){
                    counter_p += 1;
                }
            }
        }
        StringBuilder out = new StringBuilder();
        if(player.equals(ChessColor.BLACK)){
            if(counterQ < 1){
                out.append("Q 1\n");
            }
            if(counterK < 1){
                out.append("K 1\n");
            }
            if(counterR < 2){
                counterR = 2-counterR;
                out.append("R ");
                out.append(counterR);
                out.append("\n");
            }
            if(counterB < 2){
                counterB = 2-counterB;
                out.append("B ");
                out.append(counterB);
                out.append("\n");
            }
            if(counterN < 2){
                counterN = 2-counterN;
                out.append("N ");
                out.append(counterN);
                out.append("\n");
            }
            if(counterP < 8){
                counterP = 8- counterP;
                out.append("P ");
                out.append(counterP);
                out.append("\n");
            }
        }
        if(player.equals(ChessColor.WHITE)){
            if(counter_q < 1){
                out.append("q 1\n");
            }
            if(counter_k < 1){
                out.append("k 1\n");
            }
            if(counter_r < 2){
                counter_r = 2-counter_r;
                out.append("r ");
                out.append(counter_r);
                out.append("\n");
            }
            if(counter_b < 2){
                counter_b = 2-counter_b;
                out.append("b ");
                out.append(counter_b);
                out.append("\n");
            }
            if(counter_n < 2){
                counter_n = 2-counter_n;
                out.append("n ");
                out.append(counter_n);
                out.append("\n");
            }
            if(counter_p < 8){
                counter_p = 8- counter_p;
                out.append("p ");
                out.append(counter_p);
                out.append("\n");
            }
        }
        String answer = out.toString();
        return answer;
    }
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessboardPoint target=new ChessboardPoint(targetX,targetY);
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        if(chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){
            for(int j = 0; j<chessComponents[sourceX][sourceY].canMoveTo().size(); j++){
                if(chessComponents[sourceX][sourceY].canMoveTo().get(j).getX() == targetX && chessComponents[sourceX][sourceY].canMoveTo().get(j).getY() == targetY){
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(target);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE);
                    chessComponents[sourceX][sourceY].setSource(source);
                    if(currentPlayer == ChessColor.WHITE){
                        currentPlayer = ChessColor.BLACK;
                    }else if(currentPlayer == ChessColor.BLACK){
                        currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }
            }
        }return false;
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        canMovePoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX()==o2.getX()){
                    if(o1.getY()<o2.getY()){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                if(o1.getX()<o2.getX()){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        return canMovePoints;
    }
}