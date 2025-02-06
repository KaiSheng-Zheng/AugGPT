import java.util.List;

public class ConcreteChessGame implements ChessGame{


    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((chessboard.get(i).charAt(j))=='_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='Q'){
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='B'){
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='N'){
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='R'){
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='P'){
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if ((chessboard.get(i).charAt(j))=='p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        }else{
            this.currentPlayer=ChessColor.BLACK;
        }

    }
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        String[] lines= new String[]{"", "", "", "", "", "", "", ""};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                lines[i]+=chessComponents[i][j].toString();
            }
        }
        String chessboardGraph="";
        for (int i = 0; i < 8; i++) {
            chessboardGraph+=String.format("%s\n",lines[i]);
        }
        return chessboardGraph;
    }
    public String getCapturedChess(ChessColor player){
        StringBuilder capturedChess=new StringBuilder();
        int[] remainAmount=new int[6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (player==ChessColor.BLACK) {
                    if (chessComponents[i][j].name == 'K') {
                        remainAmount[0]++;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        remainAmount[1]++;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        remainAmount[2]++;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        remainAmount[3]++;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        remainAmount[4]++;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        remainAmount[5]++;
                    }
                }
                if (player==ChessColor.WHITE) {
                    if (chessComponents[i][j].name == 'k') {
                        remainAmount[0]++;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        remainAmount[1]++;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        remainAmount[2]++;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        remainAmount[3]++;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        remainAmount[4]++;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        remainAmount[5]++;
                    }
                }
            }
        }
        char[] components=new char[]{'k','q','r','b','n','p'};
        int[] originalAmount=new int[]{1,1,2,2,2,8};
        for (int i = 0; i < 6; i++) {
            if (remainAmount[i]!=originalAmount[i]){
                String str;
                if (player==ChessColor.WHITE) {
                    str = String.format("%s %d\n", components[i], originalAmount[i] - remainAmount[i]);
                }else{
                    str = String.format("%s %d\n", Character.toUpperCase(components[i]), originalAmount[i] - remainAmount[i]);
                }
                capturedChess.append(str);
            }
        }
        return capturedChess.toString();
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
            if (chessComponents[targetX][targetY].getChessColor()==currentPlayer){return false;}
            else {
                ChessboardPoint source=new ChessboardPoint(sourceX, sourceY);
                for (int i = 0; i < getCanMovePoints(source).size(); i++) {
                    if (targetX == getCanMovePoints(source).get(i).getX()
                            && targetY == getCanMovePoints(source).get(i).getY()) {
                        chessComponents[sourceX][sourceY].setSource(chessComponents[sourceX][sourceY].getSource().offset(targetX - sourceX, targetY - sourceY));
                        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                        chessComponents[sourceX][sourceY]=new EmptySlotComponent(source,ChessColor.NONE,'_');
                        if (currentPlayer==ChessColor.WHITE){currentPlayer=ChessColor.BLACK;}
                        else{currentPlayer=ChessColor.WHITE;}
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints= getChess(source.getX(), source.getY()).canMoveTo();
        return canMovePoints;
    }
}
