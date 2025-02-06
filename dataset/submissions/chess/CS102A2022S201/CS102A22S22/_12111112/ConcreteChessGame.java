import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents ;
    private ChessColor currentPlayer;
    private static ChessComponent[][] chessBoard;


    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        chessBoard = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;

    }

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               if(chessboard.get(i).charAt(j)=='_'){
                   chessComponents[i][j]=new EmptySlotComponent();
                   chessBoard[i][j]=new EmptySlotComponent();
               }
               if((chessboard.get(i).charAt(j)=='K')|(chessboard.get(i).charAt(j)=='k')){
                   chessComponents[i][j]=new KingChessComponent();
                   chessBoard[i][j]=new KingChessComponent();
               }
                if((chessboard.get(i).charAt(j)=='Q')|(chessboard.get(i).charAt(j)=='q')){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessBoard[i][j]=new QueenChessComponent();
                }
                if((chessboard.get(i).charAt(j)=='R')|(chessboard.get(i).charAt(j)=='r')){
                    chessComponents[i][j]=new RookChessComponent();
                    chessBoard[i][j]=new RookChessComponent();
                }
                if((chessboard.get(i).charAt(j)=='N')|(chessboard.get(i).charAt(j)=='n')){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessBoard[i][j]=new KnightChessComponent();
                }
                if((chessboard.get(i).charAt(j)=='B')|(chessboard.get(i).charAt(j)=='b')){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessBoard[i][j]=new BishopChessComponent();
                }
                if((chessboard.get(i).charAt(j)=='P')|(chessboard.get(i).charAt(j)=='p')){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessBoard[i][j]=new PawnChessComponent();
                }
                chessComponents[i][j].setSource(i, j);
                chessBoard[i][j].setSource(i,j);
                if(chessboard.get(i).charAt(j)!='_') {
                    if (Character.isUpperCase(chessboard.get(i).charAt(j))) {
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessBoard[i][j].setChessColor(ChessColor.BLACK);
                    } else {
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessBoard[i][j].setChessColor(ChessColor.WHITE);
                    }
                }else {
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessBoard[i][j].setChessColor(ChessColor.NONE);
                }
                chessComponents[i][j].name = chessboard.get(i).charAt(j);
                chessBoard[i][j].name = chessboard.get(i).charAt(j);
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
        }
    }

    public static ChessComponent[][] getChessBoard() {
        return chessBoard;
    }



    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].name);
            }
        }
        return str.substring(0, 8) + "\n" + str.substring(8, 16) + "\n" + str.substring(16, 24) + "\n" + str.substring(24, 32) + "\n" + str.substring(32, 40) + "\n" + str.substring(40, 48) + "\n" + str.substring(48, 56) + "\n" + str.substring(56, 64);
    }

    public String getCapturedChess(ChessColor player){
        int counterK = 0;
        int counterk = 0;
        int counterQ = 0;
        int counterq = 0;
        int counterN = 0;
        int countern = 0;
        int counterB = 0;
        int counterb = 0;
        int counterR = 0;
        int counterr = 0;
        int counterP = 0;
        int counterp = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].name=='K'){
                    counterK = counterK + 1;
                }
                if(chessComponents[i][j].name=='k'){
                    counterk = counterk + 1;
                }
                if(chessComponents[i][j].name=='Q'){
                    counterQ = counterQ + 1;
                }
                if(chessComponents[i][j].name=='q'){
                    counterq = counterq + 1;
                }
                if(chessComponents[i][j].name=='N'){
                    counterN = counterN + 1;
                }
                if(chessComponents[i][j].name=='n'){
                    countern = countern + 1;
                }
                if(chessComponents[i][j].name=='B'){
                    counterB = counterB + 1;
                }
                if(chessComponents[i][j].name=='b'){
                    counterb = counterb + 1;
                }
                if(chessComponents[i][j].name=='R'){
                    counterR = counterR + 1;
                }
                if(chessComponents[i][j].name=='r'){
                    counterr = counterr + 1;
                }
                if(chessComponents[i][j].name=='P'){
                    counterP = counterP + 1;
                }
                if(chessComponents[i][j].name=='p'){
                    counterp = counterp + 1;
                }
            }
        }
        ArrayList<Integer> counter1 = new ArrayList<>();
        ArrayList<Character> name1 = new ArrayList<>();
        counter1.add(1-counterK);
        counter1.add(1-counterQ);
        counter1.add(2-counterR);
        counter1.add(2-counterB);
        counter1.add(2-counterN);
        counter1.add(8-counterP);
        name1.add('K');
        name1.add('Q');
        name1.add('R');
        name1.add('B');
        name1.add('N');
        name1.add('P');
        ArrayList<Integer> counter2 = new ArrayList<>();
        ArrayList<Character> name2 = new ArrayList<>();
        counter2.add(1-counterk);
        counter2.add(1-counterq);
        counter2.add(2-counterr);
        counter2.add(2-counterb);
        counter2.add(2-countern);
        counter2.add(8-counterp);
        name2.add('k');
        name2.add('q');
        name2.add('r');
        name2.add('b');
        name2.add('n');
        name2.add('p');
        if(player == ChessColor.BLACK){
            for (int i = 0; i < counter1.size(); i++) {
                if(counter1.get(i)==0){
                    counter1.remove(i);
                    name1.remove(i);
                    i = i-1;
                }
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < counter1.size(); i++) {
                str.append(name1.get(i)).append(" ").append(counter1.get(i)).append("\n");
            }
            return str.toString();
        }else {
            for (int i = 0; i < counter2.size(); i++) {
                if(counter2.get(i)==0){
                    counter2.remove(i);
                    name2.remove(i);
                    i = i-1;
                }
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < counter2.size(); i++) {
                str.append(name2.get(i)).append(" ").append(counter2.get(i)).append("\n");
            }
            return str.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        // 2. as below statement:
        List<ChessboardPoint> canMovePoints  = getChess(source.getX(), source.getY()).canMoveTo();
        for (int i = 0; i < canMovePoints.size()-1; i++) {
            for (int j = 0; j < canMovePoints.size()-1-i; j++) {
                if(canMovePoints.get(j).getX()>canMovePoints.get(j+1).getX()){
                    int x1 = canMovePoints.get(j).getX();
                    int x2 = canMovePoints.get(j+1).getX();
                    int y1 = canMovePoints.get(j).getY();
                    int y2 = canMovePoints.get(j+1).getY();
                    canMovePoints.get(j).setPoint(x2, y2);
                    canMovePoints.get(j+1).setPoint(x1, y1);
                }else if(canMovePoints.get(j).getX()==canMovePoints.get(j+1).getX()){
                    if (canMovePoints.get(j).getY()>canMovePoints.get(j+1).getY()){
                        int x1 = canMovePoints.get(j).getX();
                        int x2 = canMovePoints.get(j+1).getX();
                        int y1 = canMovePoints.get(j).getY();
                        int y2 = canMovePoints.get(j+1).getY();
                        canMovePoints.get(j).setPoint(x2, y2);
                        canMovePoints.get(j+1).setPoint(x1, y1);
                    }else if(canMovePoints.get(j).getY()==canMovePoints.get(j+1).getY()){
                        canMovePoints.remove(j);
                        j=j-1;
                    }
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(getChess(sourceX,sourceY).getChessColor()==getCurrentPlayer()){
            for (int i = 0; i < getChess(sourceX,sourceY).canMoveTo().size(); i++) {
                if((targetX==getChess(sourceX,sourceY).canMoveTo().get(i).getX())&(targetY==getChess(sourceX,sourceY).canMoveTo().get(i).getY())){
                    ChessComponent component = getChess(sourceX,sourceY);
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].setSource(sourceX,sourceY);
                    chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                    chessComponents[sourceX][sourceY].name='_';
                    chessComponents[targetX][targetY]=component;
                    chessComponents[targetX][targetY].setSource(targetX,targetY);
                    chessBoard[sourceX][sourceY]=new EmptySlotComponent();
                    chessBoard[sourceX][sourceY].setSource(sourceX,sourceY);
                    chessBoard[sourceX][sourceY].setChessColor(ChessColor.NONE);
                    chessBoard[sourceX][sourceY].name='_';
                    chessBoard[targetX][targetY]=component;
                    chessBoard[targetX][targetY].setSource(targetX,targetY);
                    if(getCurrentPlayer()==ChessColor.WHITE){
                        currentPlayer = ChessColor.BLACK;
                    }else if (getCurrentPlayer()==ChessColor.BLACK){
                        currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }
            }
            return false;
        }else {
            return false;
        }
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


}
