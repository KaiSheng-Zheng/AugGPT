import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];

    }

    private ChessColor currentPlayer;


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        this.chessComponents[i][j]=new RookChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='R';
                        break;
                    case 'r':
                        this.chessComponents[i][j]=new RookChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='r';
                        break;

                    case 'N':
                        this.chessComponents[i][j]=new KnightChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='N';
                        break;
                    case 'n':
                        this.chessComponents[i][j]=new KnightChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='n';
                        break;

                    case 'B':
                        this.chessComponents[i][j]=new BishopChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='B';
                        break;
                    case 'b':
                        this.chessComponents[i][j]=new BishopChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='b';
                        break;

                    case 'Q':
                        this.chessComponents[i][j]=new QueenChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='Q';
                        break;
                    case 'q':
                        this.chessComponents[i][j]=new QueenChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='q';
                        break;

                    case 'K':
                        this.chessComponents[i][j]=new KingChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='K';
                        break;
                    case 'k':
                        this.chessComponents[i][j]=new KingChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='k';
                        break;

                    case 'P':
                        this.chessComponents[i][j]=new PawnChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='P';
                        break;
                    case 'p':
                        this.chessComponents[i][j]=new PawnChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='p';
                        break;

                    case '_':
                        this.chessComponents[i][j]=new EmptySlotComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].name='_';
                        break;
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
            this.currentPlayer=ChessColor.WHITE;
        }
        else if (chessboard.get(8).charAt(0)=='b'){
            this.currentPlayer=ChessColor.BLACK;
        }

        ChessComponent.newChessboard=chessComponents;
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
        StringBuilder temp = new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                temp.append(chessComponents[i][j].name);
            }
            temp.append("\n");
        }
        return String.valueOf(temp);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder temp = new StringBuilder();
        int count[] = new int[13];
        char flag[] = {'K','k','Q','q','R','r','B','b','N','n','P','p','_'};
        for (int i = 0; i < 13; i++) {
            count[i]=0;
        }

        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                switch (chessComponents[i][j].name){
                    case 'K':
                        count[0]++;
                        break;
                    case 'k':
                        count[1]++;
                        break;

                    case 'Q':
                        count[2]++;
                        break;
                    case 'q':
                        count[3]++;
                        break;

                    case 'R':
                        count[4]++;
                        break;
                    case 'r':
                        count[5]++;
                        break;

                    case 'B':
                        count[6]++;
                        break;
                    case 'b':
                        count[7]++;
                        break;

                    case 'N':
                        count[8]++;
                        break;
                    case 'n':
                        count[9]++;
                        break;

                    case 'P':
                        count[10]++;
                        break;
                    case 'p':
                        count[11]++;
                        break;

                    case '_':

                        break;
                }
            }
        }

        if (player==ChessColor.BLACK){
            for (int i = 0; i < 13; i++) {
                if (i==0||i==2){
                    if (count[i]!=1){
                        int lose=1-count[i];
                        temp.append(flag[i]+" "+lose+"\n");
                    }
                }
                else if (i==4||i==6||i==8){
                    if (count[i]!=2){
                        int lose=2-count[i];
                        temp.append(flag[i]+" "+lose+"\n");
                    }
                }
                else if (i==10){
                    if (count[i]!=8){
                        int lose=8-count[i];
                        temp.append(flag[i]+" "+lose+"\n");
                    }
                }
            }
        }
        else if (player==ChessColor.WHITE){
            for (int i = 0; i < 13; i++) {
                if (i==1||i==3){
                    if (count[i]!=1){
                        int lose=1-count[i];
                        temp.append(flag[i]+" "+lose+"\n");
                    }
                }
                else if (i==5||i==7||i==9){
                    if (count[i]!=2){
                        int lose=2-count[i];
                        temp.append(flag[i]+" "+lose+"\n");
                    }
                }
                else if (i==11){
                    if (count[i]!=8){
                        int lose=8-count[i];
                        temp.append(flag[i]+" "+lose+"\n");
                    }
                }
            }
        }

        return String.valueOf(temp);
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        if (getChess(sourceX,sourceY).getChessColor()==getCurrentPlayer()){
            for (ChessboardPoint temp:getCanMovePoints(new ChessboardPoint(sourceX,sourceY))) {
                if (temp.equals(new ChessboardPoint(targetX,targetY))){
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent();

                    if (getCurrentPlayer()==ChessColor.BLACK){
                        this.currentPlayer=ChessColor.WHITE;
                    }
                    else if (getCurrentPlayer()==ChessColor.WHITE){
                        this.currentPlayer=ChessColor.BLACK;
                    }

                    ChessComponent.newChessboard=chessComponents;


                    return true;
                }

            }
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(),source.getY());

        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints,new SortByXY());
        return canMovePoints;

    }


}

class SortByXY implements Comparator<ChessboardPoint> {

    @Override
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        if (o1.getX()>o2.getX()){
            return 1;
        }
        else if (o1.getX()==o2.getX()){
            if (o1.getY()>o2.getY()){
                return 1;
            }
        }
        return -1;
    }
}
