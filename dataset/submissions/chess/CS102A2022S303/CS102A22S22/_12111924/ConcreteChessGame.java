import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (Objects.equals(chessboard.get(8), "b")){setCurrentPlayer(ChessColor.BLACK);}
        else if (Objects.equals(chessboard.get(8), "w")){setCurrentPlayer(ChessColor.WHITE);}
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint position=new ChessboardPoint(i,j);
                if (chessboard.get(i).charAt(j)=='R'){
                    this.chessComponents[i][j]=new RookChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('R');
                }else if (chessboard.get(i).charAt(j)=='N'){
                    this.chessComponents[i][j]=new KnightChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('N');
                }else if (chessboard.get(i).charAt(j)=='B'){
                    this.chessComponents[i][j]=new BishopChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('B');
                }else if (chessboard.get(i).charAt(j)=='Q'){
                    this.chessComponents[i][j]=new QueenChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('Q');
                }else if (chessboard.get(i).charAt(j)=='K'){
                    this.chessComponents[i][j]=new KingChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('K');
                }else if (chessboard.get(i).charAt(j)=='P'){
                    this.chessComponents[i][j]=new PawnChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('P');
                }else if (chessboard.get(i).charAt(j)=='r'){
                    this.chessComponents[i][j]=new RookChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('r');
                }else if (chessboard.get(i).charAt(j)=='n'){
                    this.chessComponents[i][j]=new KnightChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('n');
                }else if (chessboard.get(i).charAt(j)=='b'){
                    this.chessComponents[i][j]=new BishopChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('b');
                }else if (chessboard.get(i).charAt(j)=='q'){
                    this.chessComponents[i][j]=new QueenChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('q');
                }else if (chessboard.get(i).charAt(j)=='k'){
                    this.chessComponents[i][j]=new KingChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('k');
                }else if (chessboard.get(i).charAt(j)=='p'){
                    this.chessComponents[i][j]=new PawnChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('p');
                }else if (chessboard.get(i).charAt(j)=='_'){
                    this.chessComponents[i][j]=new EmptySlotComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                    this.chessComponents[i][j].setName('_');
                }
        }
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
        StringBuilder line1=new StringBuilder();
        StringBuilder line2=new StringBuilder();
        StringBuilder line3=new StringBuilder();
        StringBuilder line4=new StringBuilder();
        StringBuilder line5=new StringBuilder();
        StringBuilder line6=new StringBuilder();
        StringBuilder line7=new StringBuilder();
        StringBuilder line8=new StringBuilder();

        for (int i = 0; i < 8; i++) {
            line1.append(chessComponents[0][i].getName());
            line2.append(chessComponents[1][i].getName());
            line3.append(chessComponents[2][i].getName());
            line4.append(chessComponents[3][i].getName());
            line5.append(chessComponents[4][i].getName());
            line6.append(chessComponents[5][i].getName());
            line7.append(chessComponents[6][i].getName());
            line8.append(chessComponents[7][i].getName());
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",line1,line2,line3,line4,line5,line6,line7,line8);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String[] name={"K","Q","R","B","N","P"};
        int[] ori={1,1,2,2,2,8};
        int[] nowb=new int[6];
        int[] noww=new int[6];
        int[] change=new int[6];
        int[] changew=new int[6];
        StringBuilder re=new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    nowb[0]++;
                }else if (chessComponents[i][j] instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    nowb[1]++;
                }else if (chessComponents[i][j] instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    nowb[2]++;
                }else if (chessComponents[i][j] instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    nowb[3]++;
                }else if (chessComponents[i][j] instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    nowb[4]++;
                }else if (chessComponents[i][j] instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    nowb[5]++;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    noww[0]++;
                }else if (chessComponents[i][j] instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    noww[1]++;
                }else if (chessComponents[i][j] instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    noww[2]++;
                }else if (chessComponents[i][j] instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    noww[3]++;
                }else if (chessComponents[i][j] instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    noww[4]++;
                }else if (chessComponents[i][j] instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    noww[5]++;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            change[i] = ori[i] - nowb[i];
        }
        for (int i = 0; i < 6; i++) {
            changew[i] = ori[i] - noww[i];
        }
        if (player==ChessColor.BLACK){
            if (change[0]!=0){re.append(String.format("K %d\n",change[0]));}
            if (change[1]!=0){re.append(String.format("Q %d\n",change[1]));}
            if (change[2]!=0){re.append(String.format("R %d\n",change[2]));}
            if (change[3]!=0){re.append(String.format("B %d\n",change[3]));}
            if (change[4]!=0){re.append(String.format("N %d\n",change[4]));}
            if (change[5]!=0){re.append(String.format("P %d\n",change[5]));}
        }else if (player==ChessColor.WHITE){
            if (changew[0]!=0){re.append(String.format("k %d\n",changew[0]));}
            if (changew[1]!=0){re.append(String.format("q %d\n",changew[1]));}
            if (changew[2]!=0){re.append(String.format("r %d\n",changew[2]));}
            if (changew[3]!=0){re.append(String.format("b %d\n",changew[3]));}
            if (changew[4]!=0){re.append(String.format("n %d\n",changew[4]));}
            if (changew[5]!=0){re.append(String.format("p %d\n",changew[5]));}
        }
        return re.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
      ChessComponent chess=this.getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=getChess(sourceX,sourceY);
        List<ChessboardPoint> chessboardPoints=chess.canMoveTo();
        return chessboardPoints.contains(chess);
    }
}
