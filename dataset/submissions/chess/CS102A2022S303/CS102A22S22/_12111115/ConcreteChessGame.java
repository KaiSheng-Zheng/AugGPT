import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        for (String line:chessboard) {
            if (chessboard.get(8).equals("b")){
                currentPlayer=ChessColor.BLACK;
            }
            if (chessboard.get(8).equals("w")){
                currentPlayer=ChessColor.WHITE;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='R';
                }
                if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='N';
                }
                if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='B';
                }
                if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='Q';
                }
                if (chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='K';
                }
                if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='P';
                }

                if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='r';
                }
                if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='n';
                }
                if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='b';
                }
                if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='q';
                }
                if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='k';
                }
                if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='p';
                }

                if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent();
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].name='_';
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder x0 =new StringBuilder();
        StringBuilder x1 =new StringBuilder();
        StringBuilder x2 =new StringBuilder();
        StringBuilder x3 =new StringBuilder();
        StringBuilder x4 =new StringBuilder();
        StringBuilder x5 =new StringBuilder();
        StringBuilder x6 =new StringBuilder();
        StringBuilder x7 =new StringBuilder();

        for (int i = 0; i < 8; i++) {
            if (chessComponents[0][i] == null) {
                x0.append("_");
            } else {
                x0.append(chessComponents[0][i]);
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chessComponents[1][i] == null) {
                x1.append("_");
            } else {
                x1.append(chessComponents[1][i]);
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chessComponents[2][i] == null) {
                x2.append("_");
            } else {
                x2.append(chessComponents[2][i]);
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chessComponents[3][i] == null) {
                x3.append("_");
            } else {
                x3.append(chessComponents[3][i]);
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chessComponents[4][i] == null) {
                x4.append("_");
            } else {
                x4.append(chessComponents[4][i]);
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chessComponents[5][i] == null) {
                x5.append("_");
            } else {
                x5.append(chessComponents[5][i]);
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chessComponents[6][i] == null) {
                x6.append("_");
            } else {
                x6.append(chessComponents[6][i]);
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chessComponents[7][i] == null) {
                x7.append("_");
            } else {
                x7.append(chessComponents[7][i]);
            }
        }

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",x0,x1,x3,x4,x5,x6,x7);
    }

    @Override
    public String getCapturedChess(ChessColor player){
        int a1 = 1;
        int a2 = 1;
        int a3 = 2;
        int a4 = 2;
        int a5 = 2;
        int a6 = 8;
        StringBuilder sb = new StringBuilder();
        if (player==ChessColor.WHITE){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        a1--;
                    }
                    if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        a2--;
                    }
                    if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        a3--;
                    }
                    if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        a4--;
                    }
                    if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        a5--;
                    }
                    if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        a6--;
                    }
                }
            }
            if (a1!=0){
                sb.append("k ");
                sb.append(a1);
                sb.append("\n");
            }
            if (a2!=0){
                sb.append("q ");
                sb.append(a2);
                sb.append("\n");
            }
            if (a3!=0){
                sb.append("r ");
                sb.append(a3);
                sb.append("\n");
            }
            if (a4!=0){
                sb.append("b ");
                sb.append(a4);
                sb.append("\n");
            }
            if (a5!=0){
                sb.append("n ");
                sb.append(a5);
                sb.append("\n");
            }
            if (a6!=0){
                sb.append("p ");
                sb.append(a6);
                sb.append("\n");
            }
        }
        if (player==ChessColor.BLACK){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    a1--;
                }
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    a2--;
                }
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    a3--;
                }
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    a4--;
                }
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    a5--;
                }
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    a6--;
                }
            }
        }
            if (a1!=0){
                sb.append("K ");
                sb.append(a1);
                sb.append("\n");
            }
            if (a2!=0){
                sb.append("Q ");
                sb.append(a2);
                sb.append("\n");
            }
            if (a3!=0){
                sb.append("R ");
                sb.append(a3);
                sb.append("\n");
            }
            if (a4!=0){
                sb.append("B ");
                sb.append(a4);
                sb.append("\n");
            }
            if (a5!=0){
                sb.append("N ");
                sb.append(a5);
                sb.append("\n");
            }
            if (a6!=0){
                sb.append("P ");
                sb.append(a6);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(),source.getY());
        if(chess instanceof EmptySlotComponent){
            return new ArrayList<>();
        }else {
            List<ChessboardPoint> canMovePoints = chess.canMoveTo();
            return canMovePoints;
        }
    }

    @Override
    public boolean moveChess (int sourceX, int sourceY, int targetX, int targetY)  {
        return false;
    }

}
