import java.util.*;

public class ConcreteChessGame implements ChessGame {

    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.currentPlayer = ChessColor.WHITE;
    }
    public ConcreteChessGame(ChessComponent[][] chessComponents,ChessColor currentPlayer) {

        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }



    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            String s = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                switch (s.charAt(j)){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                        break;
                }
            }
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }
        else {
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].name);
            }
            if (i!=7){
                sb.append("\n");
            }
        }
        return String.valueOf(sb);
    }

    public String getCapturedChess(ChessColor player){
        if (player==ChessColor.BLACK){
            int R = 0;
            int N = 0;
            int B = 0;
            int Q = 0;
            int K = 0;
            int P = 0;
            for (int i = 0; i < getChessboardGraph().length(); i++) {
                if (getChessboardGraph().charAt(i)=='R'){
                    R++;
                }else if (getChessboardGraph().charAt(i)=='N'){
                    N++;
                }else if (getChessboardGraph().charAt(i)=='B'){
                    B++;
                }else if (getChessboardGraph().charAt(i)=='Q'){
                    Q++;
                }else if (getChessboardGraph().charAt(i)=='K'){
                    K++;
                }else if (getChessboardGraph().charAt(i)=='P'){
                    P++;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (K <1){
                sb.append("K 1\n");
            }if (Q <1){
                sb.append("Q 1\n");
            }if (R <2){
                sb.append("R ");
                int x = 2-R;
                sb.append(x);
                sb.append("\n");
            }if (B <2){
                sb.append("B ");
                int x = 2-B;
                sb.append(x);
                sb.append("\n");
            }if (N <2){
                sb.append("N ");
                int x = 2-N;
                sb.append(x);
                sb.append("\n");
            }if (P <8){
                sb.append("P ");
                int x = 8-P;
                sb.append(x);
                sb.append("\n");
            }
            return sb.toString();
        }else if (player==ChessColor.WHITE){
            int R = 0;
            int N = 0;
            int B = 0;
            int Q = 0;
            int K = 0;
            int P = 0;
            for (int i = 0; i < getChessboardGraph().length(); i++) {
                if (getChessboardGraph().charAt(i)=='r'){
                    R++;
                }else if (getChessboardGraph().charAt(i)=='n'){
                    N++;
                }else if (getChessboardGraph().charAt(i)=='b'){
                    B++;
                }else if (getChessboardGraph().charAt(i)=='q'){
                    Q++;
                }else if (getChessboardGraph().charAt(i)=='k'){
                    K++;
                }else if (getChessboardGraph().charAt(i)=='p'){
                    P++;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (K <1){
                sb.append("k 1\n");
            }if (Q <1){
                sb.append("q 1\n");
            }if (R <2){
                sb.append("r ");
                int x = 2-R;
                sb.append(x);
                sb.append("\n");
            }if (B <2){
                sb.append("b ");
                int x = 2-B;
                sb.append(x);
                sb.append("\n");
            }if (N <2){
                sb.append("n ");
                int x = 2-N;
                sb.append(x);
                sb.append("\n");
            }if (P <8){
                sb.append("p ");
                int x = 8-P;
                sb.append(x);
                sb.append("\n");
            }
            return sb.toString();
        }
        return null;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        chessComponents[source.getX()][source.getY()].setChessBoard(chessComponents);
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){

        if (whether_player_chess(sourceX,sourceY)){
            if (targetX<8&&targetX>=0&&targetY<8&&targetY>=0){
                if (!whether_player_chess(targetX,targetY)){

                    ChessComponent newpoint = getChess(sourceX,sourceY);

                    List<ChessboardPoint> listit = getCanMovePoints(newpoint.getSource());
                    for (ChessboardPoint chessboardPoint : listit) {
                        if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                            reChess(targetX, targetY, chessComponents[sourceX][sourceY].name);
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                            if (currentPlayer == ChessColor.WHITE) {
                                currentPlayer = ChessColor.BLACK;
                            } else {
                                currentPlayer = ChessColor.WHITE;
                            }
                            return true;
                        }
                    }return false;

                }else {
                    return false;
                }
            }else return false;
        }
        return false;
    }

    public boolean whether_player_chess(int sourceX, int sourceY){
        return chessComponents[sourceX][sourceY].getChessColor() == getCurrentPlayer();
    }

    public void reChess (int i,int j,char name_new ){
        switch (name_new){
            case 'R':
                chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                break;
            case 'N':
                chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                break;
            case 'B':
                chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                break;
            case 'Q':
                chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                break;
            case 'K':
                chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                break;
            case 'P':
                chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                break;
            case '_':
                chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                break;
            case 'r':
                chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                break;
            case 'n':
                chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                break;
            case 'b':
                chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                break;
            case 'q':
                chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                break;
            case 'k':
                chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                break;
            case 'p':
                chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                break;
        }

    }

}

