import java.util.*;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    public ConcreteChessGame() {
        this.chessComponents =new  ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void loadChessGame(List<String> chessboard){
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (Character.isUpperCase(chessboard.get(i).charAt(j))){
                        if (chessboard.get(i).charAt(j) == 'B')
                            this.chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,i,j,chessComponents);
                        if (chessboard.get(i).charAt(j) == 'K')
                            this.chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,i,j,chessComponents);
                        if (chessboard.get(i).charAt(j) == 'N')
                            this.chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,i,j,chessComponents);
                        if (chessboard.get(i).charAt(j) == 'Q')
                            this.chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,i,j,chessComponents);
                        if (chessboard.get(i).charAt(j) == 'P')
                            this.chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,i,j,chessComponents);
                        if (chessboard.get(i).charAt(j) == 'R')
                            this.chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,i,j,chessComponents);
                    }
                    else if (Character.isLowerCase(chessboard.get(i).charAt(j))){
                        if (chessboard.get(i).charAt(j) == 'b')
                            this.chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,i,j,chessComponents);
                        if (chessboard.get(i).charAt(j) == 'k')
                            this.chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,i,j,chessComponents);
                        if (chessboard.get(i).charAt(j) == 'n')
                            this.chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,i,j,chessComponents);
                        if (chessboard.get(i).charAt(j) == 'q')
                            this.chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,i,j,chessComponents);
                        if (chessboard.get(i).charAt(j) == 'p')
                            this.chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,i,j,chessComponents);
                        if (chessboard.get(i).charAt(j) == 'r')
                            this.chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,i,j,chessComponents);
                    }
                    else this.chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,i,j);
                }
            }
            if (chessboard.get(8).equals("w")){
                this.currentPlayer = ChessColor.WHITE;
            }else if (chessboard.get(8).equals("b")){
                this.currentPlayer = ChessColor.BLACK;
            }
    }
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder sc = new StringBuilder();
        for (int i=0;i<8;i++){
            sc.append('\n');
            for (int j=0;j<8;j++) {
                sc.append(chessComponents[i][j].name);
            }
        }
        sc.delete(0,1);
        return sc.toString();
    }
    public String getCapturedChess(ChessColor player){
        String str = getChessboardGraph();
        int[] num = new int[12];
        int[] minus = new int[12];
        String[] strings = str.split("\n");
        StringBuilder sc = new StringBuilder();
        for (int j=0;j<8;j++) {
            for (int i = 0; i < 8; i++) {
                if (strings[j].charAt(i) == 'K'){num[0]++;}
                else if (strings[j].charAt(i) =='k'){num[1]++;}
                else if (strings[j].charAt(i) =='Q'){num[2]++;}
                else if (strings[j].charAt(i) =='q'){num[3]++;}
                else if (strings[j].charAt(i) =='R'){num[4]++;}
                else if (strings[j].charAt(i) =='r'){num[5]++;}
                else if (strings[j].charAt(i) =='B'){num[6]++;}
                else if (strings[j].charAt(i) =='b'){num[7]++;}
                else if (strings[j].charAt(i) =='N'){num[8]++;}
                else if (strings[j].charAt(i) =='n'){num[9]++;}
                else if (strings[j].charAt(i) =='P'){num[10]++;}
                else if (strings[j].charAt(i) =='p'){num[11]++;}
            }
        }
        for (int i=0;i<4;i++){
            minus[i]=1-num[i];
        }
        for (int i=4;i<10;i++){
            minus[i]=2-num[i];
        }
        minus[10]=8-num[10];
        minus[11]=8-num[11];
        if (player == ChessColor.WHITE){
            for (int i=1;i<12;i+=2){
                if (minus[i]>0){
                    if(i==1){sc.append("k ");}
                    else if (i==3){sc.append("q ");}
                    else if (i==5){sc.append("r ");}
                    else if (i==7){sc.append("b ");}
                    else if (i==9){sc.append("n ");}
                    else if (i==11){sc.append("p ");}
                    sc.append(minus[i]);
                    sc.append("\n");
                }
            }
            return sc.toString();
        }else if (player == ChessColor.BLACK){
            for (int i=0;i<12;i+=2){
                if (minus[i]>0){
                    if(i==0){sc.append("K ");}
                    else if (i==2){sc.append("Q ");}
                    else if (i==4){sc.append("R ");}
                    else if (i==6){sc.append("B ");}
                    else if (i==8){sc.append("N ");}
                    else if (i==10){sc.append("P ");}
                    sc.append(minus[i]);
                    sc.append("\n");
                }
            }return sc.toString();
        }return null;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        // 1. find chess according to source
        ChessComponent chessComponent = getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chessComponent.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        if (canMovePoints.size() == 0){
            return canMovePoints;
        }else {
            for (int i = 0; i < canMovePoints.size() - 1; i++) {
                for (int j = 0; j < canMovePoints.size() - i - 1; j++) {
                    if (canMovePoints.get(j).getX() > canMovePoints.get(j + 1).getX()) {
                        ChessboardPoint aaa = canMovePoints.get(j);
                        canMovePoints.set(j, canMovePoints.get(j + 1));
                        canMovePoints.set(j + 1, aaa);
                    } else if (canMovePoints.get(j).getX() == canMovePoints.get(j + 1).getX() &&
                            canMovePoints.get(j).getY() > canMovePoints.get(j + 1).getY()) {
                        ChessboardPoint aaa = canMovePoints.get(j);
                        canMovePoints.set(j, canMovePoints.get(j + 1));
                        canMovePoints.set(j + 1, aaa);
                    }
                }
            }
        }
        return canMovePoints;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer) {
            for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
                if (getCanMovePoints(new ChessboardPoint(sourceX,sourceY)).get(i).getX() == targetX
                        && getCanMovePoints(new ChessboardPoint(sourceX,sourceY)).get(i).getY() == targetY) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setX(targetX);
                    chessComponents[targetX][targetY].setY(targetY);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, sourceX, sourceY);
                    if (getCurrentPlayer() == ChessColor.WHITE) {
                        this.currentPlayer = ChessColor.BLACK;
                    }else if (getCurrentPlayer() == ChessColor.BLACK) {
                        this.currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
