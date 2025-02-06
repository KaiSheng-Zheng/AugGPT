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
    private int[][] capturedChess;
    public ConcreteChessGame(List<String> chessboard,ChessColor currentPlayer){
        this.currentPlayer=currentPlayer;
        this.chessComponents=new ChessComponent[8][8];
        this.capturedChess=new int[2][6];
        loadChessGame(chessboard);
    }
    public ConcreteChessGame(List<String> chessboard){
        this.currentPlayer=ChessColor.WHITE;
        this.chessComponents=new ChessComponent[8][8];
        this.capturedChess=new int[2][6];
        loadChessGame(chessboard);
    }
    public ConcreteChessGame(){
        this.currentPlayer=ChessColor.WHITE;
        this.chessComponents=new ChessComponent[8][8];
        this.capturedChess=new int[2][6];
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void refreshCapturedChess(char a){
        if (a == 'R') {
            capturedChess[0][2]+= 1;
        } else if (a == 'r') {
            capturedChess[1][2]+=1;
        } else if (a == 'N') {
            capturedChess[0][4]+=1;
        } else if (a == 'n') {
            capturedChess[1][4]+=1;
        } else if (a == 'B') {
            capturedChess[0][3]+=1;
        } else if (a == 'b') {
            capturedChess[1][3]+=1;
        } else if (a == 'Q') {
            capturedChess[0][1]+=1;
        } else if (a == 'q') {
            capturedChess[1][1]+=1;
        } else if (a == 'K') {
            capturedChess[0][0]+=1;
        } else if (a == 'k') {
            capturedChess[1][0]+=1;
        } else if (a == 'P') {
            capturedChess[0][5]+=1;
        } else if (a == 'p') {
            capturedChess[1][5]+=1;
        }
    }

    public void findChessComponent(int i, int j, char a) {
        if (a == 'R') {
            this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
            capturedChess[0][2]-= 1;
        } else if (a == 'r') {
            this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
            capturedChess[1][2]-=1;
        } else if (a == 'N') {
            this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
            capturedChess[0][4]-=1;
        } else if (a == 'n') {
            this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
            capturedChess[1][4]-=1;
        } else if (a == 'B') {
            this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
            capturedChess[0][3]-=1;
        } else if (a == 'b') {
            this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
            capturedChess[1][3]-=1;
        } else if (a == 'Q') {
            this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
            capturedChess[0][1]-=1;
        } else if (a == 'q') {
            this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
            capturedChess[1][1]-=1;
        } else if (a == 'K') {
            this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
            capturedChess[0][0]-=1;
        } else if (a == 'k') {
            this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
            capturedChess[1][0]-=1;
        } else if (a == 'P') {
            this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
            capturedChess[0][5]-=1;
        } else if (a == 'p') {
            this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
            capturedChess[1][5]-=1;
        } else if (a == '_') {
            this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
        }
    }
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                findChessComponent(i,j,chessboard.get(i).charAt(j));
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
            setCurrentPlayer(ChessColor.WHITE);
        }else if (chessboard.get(8).charAt(0)=='b'){
            setCurrentPlayer(ChessColor.BLACK);
        }
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                if (i1==0||i1==1){
                    capturedChess[i][i1]+=1;
                }else if (i1==2||i1==3||i1==4){
                    capturedChess[i][i1]+=2;
                }else {
                    capturedChess[i][i1]+=8;
                }
            }
        }
        loadChessGameForComponents();
    }
    public void loadChessGameForComponents(){
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 8; i1++) {
                getChessComponents()[i][i1].loadChessGame(getChessComponents());
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder a=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 8; i1++) {
                a.append(this.chessComponents[i][i1]);
            }
            if (i!=7) {
                a.append('\n');
            }
        }
        return a.toString();
    }
    public String getCapturedChess(ChessColor player){
        StringBuilder output=new StringBuilder();
        if (player.equals(ChessColor.BLACK)){
            for (int i = 0; i < 6; i++) {
                if (i==0&&this.capturedChess[0][i]!=0){
                    output.append(String.format("K %d\n",this.capturedChess[0][0]));
                }else if (i==1&&this.capturedChess[0][i]!=0){
                    output.append(String.format("Q %d\n",this.capturedChess[0][1]));
                }else if (i==2&&this.capturedChess[0][i]!=0){
                    output.append(String.format("R %d\n",this.capturedChess[0][2]));
                }else if (i==3&&this.capturedChess[0][i]!=0){
                    output.append(String.format("B %d\n",this.capturedChess[0][3]));
                }else if (i==4&&this.capturedChess[0][i]!=0){
                    output.append(String.format("N %d\n",this.capturedChess[0][4]));
                }else if (i==5&&this.capturedChess[0][i]!=0){
                    output.append(String.format("P %d\n",this.capturedChess[0][5]));
                }
            }
            return output.toString();
        }else{
            for (int i = 0; i < 6; i++) {
                if (i==0&&this.capturedChess[1][i]!=0){
                    output.append(String.format("k %d\n",this.capturedChess[1][0]));
                }else if (i==1&&this.capturedChess[1][i]!=0){
                    output.append(String.format("q %d\n",this.capturedChess[1][1]));
                }else if (i==2&&this.capturedChess[1][i]!=0){
                    output.append(String.format("r %d\n",this.capturedChess[1][2]));
                }else if (i==3&&this.capturedChess[1][i]!=0){
                    output.append(String.format("b %d\n",this.capturedChess[1][3]));
                }else if (i==4&&this.capturedChess[1][i]!=0){
                    output.append(String.format("n %d\n",this.capturedChess[1][4]));
                }else if (i==5&&this.capturedChess[1][i]!=0){
                    output.append(String.format("p %d\n",this.capturedChess[1][5]));
                }
            }
            return output.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> getCanMovePoints= getChessComponents()[source.getX()][source.getY()].canMoveTo();
        return getCanMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChessComponents()[sourceX][sourceY].getChessColor().equals(getCurrentPlayer())) {
            for (int i = 0; i < getChessComponents()[sourceX][sourceY].canMoveTo().size(); i++) {
                if (getChessComponents()[sourceX][sourceY].canMoveTo().get(i).getX() == targetX && getChessComponents()[sourceX][sourceY].canMoveTo().get(i).getY() == targetY) {
                    refreshCapturedChess(getChessComponents()[targetX][targetY].getName());

                    getChessComponents()[targetX][targetY]=getChessComponents()[sourceX][sourceY];
                    getChessComponents()[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    getChessComponents()[targetX][targetY].setChessColor(getChessComponents()[sourceX][sourceY].getChessColor());
                    getChessComponents()[targetX][targetY].setName(getChessComponents()[sourceX][sourceY].getName());

                    getChessComponents()[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                    if (getCurrentPlayer()==ChessColor.WHITE){
                        setCurrentPlayer(ChessColor.BLACK);
                    }else if (getCurrentPlayer()==ChessColor.BLACK){
                        setCurrentPlayer(ChessColor.WHITE);
                    }
                    System.out.println(getChessboardGraph());
                    return true;
                }
            }
        }
        return false;
    }
    public ChessComponent getChess(int x, int y){
            return getChessComponents()[x][y];
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public int[][] getCapturedChess() {
        return capturedChess;
    }
    public void setCapturedChess(int[][] capturedChess) {
        this.capturedChess = capturedChess;
    }

    public static void main(String[] args) {
        List<String> input=new ArrayList<>();
//        input.add("R_BQK__R");
//        input.add("PPPP_PPP");
//        input.add("__N_P___");
//        input.add("___Np___");
//        input.add("_B_p____");
//        input.add("___q_n__");
//        input.add("ppp__ppp");
//        input.add("ppp__ppp");
//        input.add("w");
//                 012345678
        input.add("R_BQK___");
        input.add("PPP__PP_");
        input.add("__NPP_n_");
        input.add("___Np___");
        input.add("___p____");
        input.add("__p_____");
        input.add("pp___pp_");
        input.add("rnb_kb_R");
        input.add("b");
        ConcreteChessGame yes=new ConcreteChessGame();
        yes.loadChessGame(input);
//        System.out.println(yes.getChessComponents()[7][4]);
//        System.out.println(yes.getChessComponents()[7][4].canMoveTo());

//        System.out.println(yes.getChess(2,0));
//        System.out.println(yes.getChessComponents()[2][0].getChessColor());
//        System.out.println(yes.getChessComponents()[4][4]);
//        System.out.println(yes.getChessComponents()[4][5]);
//        System.out.println(yes.getCanMovePoints(new ChessboardPoint(7,5)));
        System.out.println(yes.getCurrentPlayer());
        System.out.println(yes.moveChess(7,7,5,7));
        System.out.println(yes.getCapturedChess(yes.getCurrentPlayer()));
        System.out.println(yes.getCurrentPlayer());
        System.out.println(yes.moveChess(3,4,2,3));
        System.out.println(yes.getCapturedChess(yes.getCurrentPlayer()));
        System.out.println(yes.moveChess(5,7,5,2));
        System.out.println(yes.getCapturedChess(yes.getCurrentPlayer()));
    }
}
