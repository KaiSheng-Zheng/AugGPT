import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = ChessComponent.chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
        this.currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++){
            String line = chessboard.get(i);
            for (int j=0;j<8;j++){
                ChessboardPoint temp = new ChessboardPoint(i,j);
                if (line.charAt(j)=='K'){
                    chessComponents[i][j] = new KingChessComponent(temp,ChessColor.BLACK,'K');
                }
                if (line.charAt(j)=='k'){
                    chessComponents[i][j] = new KingChessComponent(temp,ChessColor.WHITE,'k');
                }
                if (line.charAt(j)=='Q'){
                    chessComponents[i][j] = new QueenChessComponent(temp,ChessColor.BLACK,'Q');
                }
                if (line.charAt(j)=='q'){
                    chessComponents[i][j] = new QueenChessComponent(temp,ChessColor.WHITE,'q');
                }
                if (line.charAt(j)=='R'){
                    chessComponents[i][j] = new RookChessComponent(temp,ChessColor.BLACK,'R');
                }
                if (line.charAt(j)=='r'){
                    chessComponents[i][j] = new RookChessComponent(temp,ChessColor.WHITE,'r');
                }
                if (line.charAt(j)=='B'){
                    chessComponents[i][j] = new BishopChessComponent(temp,ChessColor.BLACK,'B');
                }
                if (line.charAt(j)=='b'){
                    chessComponents[i][j] = new BishopChessComponent(temp,ChessColor.WHITE,'b');
                }
                if (line.charAt(j)=='N'){
                    chessComponents[i][j] = new KnightChessComponent(temp,ChessColor.BLACK,'N');
                }
                if (line.charAt(j)=='n'){
                    chessComponents[i][j] = new KnightChessComponent(temp,ChessColor.WHITE,'n');
                }
                if (line.charAt(j)=='P'){
                    chessComponents[i][j] = new PawnChessComponent(temp,ChessColor.BLACK,'P');
                }
                if (line.charAt(j)=='p'){
                    chessComponents[i][j] = new PawnChessComponent(temp,ChessColor.WHITE,'p');
                }
                if (line.charAt(j)=='_'){
                    chessComponents[i][j] = new EmptySlotComponent(temp,ChessColor.NONE,'_');
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")){
            this.currentPlayer = ChessColor.WHITE;
        }
        else if (Objects.equals(chessboard.get(8), "b")){
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                line.append(chessComponents[i][j].name);
            }
            line.append("\n");
        }
        line.deleteCharAt(line.length()-1);
        String str = line.toString();
        return str;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder chess = new StringBuilder();
        int testKingBlack = 0;
        int testKingWhite = 0;
        int testQueenBlack = 0;
        int testQueenWhite = 0;
        int testRookBlack = 0;
        int testRookWhite = 0;
        int testBishopBlack = 0;
        int testBishopWhite = 0;
        int testKnightBlack = 0;
        int testKnightWhite = 0;
        int testPawnBlack = 0;
        int testPawnWhite = 0;

        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (player==ChessColor.BLACK){
                    String kingBlack = "K";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(kingBlack)){
                        testKingBlack++;
                    }

                    String queenBlack = "Q";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(queenBlack)){
                        testQueenBlack++;
                    }

                    String rookBlack = "R";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(rookBlack)){
                        testRookBlack++;
                    }

                    String bishopBlack = "B";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(bishopBlack)){
                        testBishopBlack++;
                    }

                    String knightBlack = "N";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(knightBlack)){
                        testKnightBlack++;
                    }

                    String pawnBlack = "P";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(pawnBlack)){
                        testPawnBlack++;
                    }
                }
                else if (player==ChessColor.WHITE){
                    String kingWhite = "k";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(kingWhite)){
                        testKingWhite++;
                    }

                    String queenWhite = "q";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(queenWhite)){
                        testQueenWhite++;
                    }

                    String rookWhite = "r";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(rookWhite)){
                        testRookWhite++;
                    }

                    String bishopWhite = "b";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(bishopWhite)){
                        testBishopWhite++;
                    }

                    String knightWhite = "n";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(knightWhite)){
                        testKnightWhite++;
                    }

                    String pawnWhite = "p";
                    if (String.valueOf(this.chessComponents[i][j].name).equals(pawnWhite)){
                        testPawnWhite++;
                    }
                }
            }
        }
        if (player==ChessColor.BLACK){
            if (testKingBlack==0){
                chess.append("K 1\n");
            }
            if (testQueenBlack==0){
                chess.append("Q 1\n");
            }
            if (testRookBlack<2){
                chess.append("R ");
                int a = 2-testRookBlack;
                chess.append(a);
                chess.append("\n");
            }
            if (testBishopBlack<2){
                chess.append("B ");
                int a = 2-testBishopBlack;
                chess.append(a);
                chess.append("\n");
            }
            if (testKnightBlack<2){
                chess.append("N ");
                int a = 2-testKnightBlack;
                chess.append(a);
                chess.append("\n");
            }
            if (testPawnBlack<8){
                chess.append("P ");
                int a = 8-testPawnBlack;
                chess.append(a);
                chess.append("\n");
            }
            String str = chess.toString();
            return str;
        }
        else if (player==ChessColor.WHITE){
            if (testKingWhite==0){
                chess.append("k 1\n");
            }

            if (testQueenWhite==0){
                chess.append("q 1\n");
            }

            if (testRookWhite<2){
                chess.append("r ");
                int a = 2-testRookWhite;
                chess.append(a);
                chess.append("\n");
            }

            if (testBishopWhite<2){
                chess.append("b ");
                int a = 2-testBishopWhite;
                chess.append(a);
                chess.append("\n");
            }

            if (testKnightWhite<2){
                chess.append("n ");
                int a = 2-testKnightWhite;
                chess.append(a);
                chess.append("\n");
            }

            if (testPawnWhite<8){
                chess.append("p ");
                int a = 8-testPawnWhite;
                chess.append(a);
                chess.append("\n");
            }
            String str = chess.toString();
            return str;
        }
        else {
            return null;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> disorderedPoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        if(!disorderedPoints.isEmpty()){
            for (int i=0;i<disorderedPoints.size();i++){
                for (int j=0;j<disorderedPoints.size()-1-i;j++){
                    if (disorderedPoints.get(j).getX()>disorderedPoints.get(j+1).getX()){
                        ChessboardPoint temp = disorderedPoints.get(j);
                        disorderedPoints.set(j,disorderedPoints.get(j+1));
                        disorderedPoints.set(j+1,temp);
                    }
                    else if (disorderedPoints.get(j).getX()==disorderedPoints.get(j+1).getX()){
                        if (disorderedPoints.get(j).getY()>disorderedPoints.get(j+1).getY()){
                            ChessboardPoint temp = disorderedPoints.get(j);
                            disorderedPoints.set(j,disorderedPoints.get(j+1));
                            disorderedPoints.set(j+1,temp);
                        }
                    }
                }
            }
        }
        return disorderedPoints;
    }

    public void swapChess (ChessComponent p1 , ChessComponent p2){
        int x1 = p1.getSource().getX();
        int y1 = p1.getSource().getY();
        int x2 = p2.getSource().getX();
        int y2 = p2.getSource().getY();
        char b = p1.getName();
        if(b =='b'||b=='B'){
            chessComponents[x2][y2] = new BishopChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        else if(b == 'k'||b == 'K'){
            chessComponents[x2][y2] = new KingChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        else if(b == 'n'||b == 'N'){
            chessComponents[x2][y2] = new KnightChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        else if(b == 'p'||b == 'P'){
            chessComponents[x2][y2] = new PawnChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        else if(b == 'q'||b == 'Q'){
            chessComponents[x2][y2] = new QueenChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        else {
            chessComponents[x2][y2] = new RookChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        chessComponents[x1][y1] = new EmptySlotComponent(new ChessboardPoint(x1,y1),ChessColor.NONE,'_');

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(sourceX<0||sourceX>7||sourceY<0||sourceY>7||targetX<0||targetX>7||targetY<0||targetY>7){
            return false;
        }
        else {
            boolean ans = false;
            ChessboardPoint start = new ChessboardPoint(sourceX,sourceY);
            ChessboardPoint end = new ChessboardPoint(targetX,targetY);
            ChessComponent start1 = getChess(sourceX,sourceY);
            ChessComponent end1 = getChess(targetX,targetY);
            if(start1.getChessColor() == getCurrentPlayer()){
                if(!getCanMovePoints(start).isEmpty()){
                    for(ChessboardPoint p : getCanMovePoints(start)){
                        if(p.getX() == targetX && p.getY() == targetY){
                            ans = true;
                            break;
                        }
                    }
                    if(ans){
                        swapChess(start1,end1);
                        if(getCurrentPlayer()==ChessColor.BLACK){
                            setCurrentPlayer(ChessColor.WHITE);
                        }
                        else setCurrentPlayer(ChessColor.BLACK);
                    }
                }
            }
            return ans;
        }
    }
}
