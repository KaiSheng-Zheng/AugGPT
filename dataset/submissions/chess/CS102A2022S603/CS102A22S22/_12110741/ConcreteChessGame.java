import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame extends ChessComponent implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

@Override
    public void loadChessGame(List<String> chessboard){

        if (chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }else if (chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;
        }
        for (int i=0; i<8; i++){
            for (int j =0; j<8; j++) {
                ChessboardPoint chessboardPoint = new ChessboardPoint(i,j);
                char c = chessboard.get(i).charAt(j);
                if (c=='r') {
                    this.chessComponents[i][j]= new RookChessComponent(chessboardPoint,ChessColor.WHITE,c,chessComponents);
                } else if (c=='k') {
                    this.chessComponents[i][j]= new KingChessComponent(chessboardPoint,ChessColor.WHITE,c,chessComponents);
                } else if (c=='q') {
                    this.chessComponents[i][j] = new QueenChessComponent(chessboardPoint,ChessColor.WHITE,c,chessComponents);
                } else if (c=='b') {
                    this.chessComponents[i][j]= new BishopChessComponent(chessboardPoint,ChessColor.WHITE,c,chessComponents);
                } else if (c=='n') {
                    this.chessComponents[i][j]= new KnightChessComponent(chessboardPoint,ChessColor.WHITE,c,chessComponents);
                } else if (c=='p') {
                    this.chessComponents[i][j] = new PawnChessComponent(chessboardPoint,ChessColor.WHITE,c,chessComponents);
                } else if (c=='_') {
                    this.chessComponents[i][j] = new EmptySlotComponent(chessboardPoint,ChessColor.NONE,c,chessComponents);
                } else if (c=='R') {
                    this.chessComponents[i][j]=new RookChessComponent(chessboardPoint,ChessColor.BLACK,c, chessComponents);
                }else if (c=='K'){
                    this.chessComponents[i][j]=new KingChessComponent(chessboardPoint,ChessColor.BLACK,c, chessComponents);
                }else if (c=='Q'){
                    this.chessComponents[i][j]= new QueenChessComponent(chessboardPoint,ChessColor.BLACK,c, chessComponents);
                }else if (c=='B'){
                    this.chessComponents[i][j]= new BishopChessComponent(chessboardPoint,ChessColor.BLACK,c, chessComponents);
                }else if (c=='N'){
                    this.chessComponents[i][j]= new KnightChessComponent(chessboardPoint,ChessColor.BLACK,c, chessComponents);
                }else if (c=='P'){
                    this.chessComponents[i][j]= new PawnChessComponent(chessboardPoint,ChessColor.BLACK,c, chessComponents);
                }

            }
        }


    }
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
    String chessboard;
    StringBuffer str = new StringBuffer();
    for (int i = 0; i<8; i++){
        for (int j = 0; j<8; j++){
            str.append(chessComponents[i][j]);
        }
        str.append("\n");
    }
    return str.toString();


    }
    public String getCapturedChess(ChessColor player){
        int counterb = 2;int counterk = 1;int counterq = 1;int countern = 2;int counterp = 8;int counterr = 2;
        int counterB = 2;int counterK = 1;int counterQ = 1;int counterN = 2;int counterP = 8;int counterR = 2;
        String str1="";
        for (int i =0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                char name = chessComponents[i][j].name;
                if (player.equals(ChessColor.WHITE)) {
                    switch (name) {
                        case 'k' ->counterk--;
                        case 'q'->counterq--;
                        case 'r'->counterr--;
                        case 'b'->counterb--;
                        case 'n'->countern--;
                        case 'p'->counterp--;
                    }
                    if (counterk == 0) {
                        str1 = "";
                    } else {
                        str1 = "k " + counterk;
                    }
                    if (counterq == 0) {
                        str1 = str1 + "";
                    } else {
                        str1 = String.format(str1+"\n" + "q " + counterq);
                    }
                    if (counterr == 0) {
                        str1 = str1 + "";
                    } else {
                        str1 = String.format(str1+"\n" + "r " + counterr);
                    }
                    if (counterb == 0) {
                        str1 = str1 + "";
                    } else {
                        str1 = String.format(str1+"\n" + "b " + counterb);
                    }
                    if (countern == 0) {
                        str1 = str1 + "";
                    } else {
                        str1 = String.format(str1+"\n" + "n " + countern);
                    }
                    if (counterp == 0) {
                        str1 = str1 + "";
                    } else {
                        str1 = String.format(str1+"\n" + "p " + counterp)+"\n";
                    }
                }
                if (player.equals(ChessColor.BLACK)) {
                    switch (name) {
                        case 'K'->counterK--;
                        case 'Q'->counterQ--;
                        case 'R'->counterR--;
                        case 'B'->counterB--;
                        case 'N'->counterN--;
                        case 'P'->counterP--;

                    }
                    if (counterK == 0) {
                        str1 = "";
                    } else {
                        str1 = "K " + counterK;
                    }
                    if (counterQ == 0) {
                        str1 = str1 + "";
                    } else {
                        str1 = String.format(str1+"\n" + "Q " + counterQ);
                    }
                    if (counterR == 0) {
                        str1 = str1 + "";
                    } else {
                        str1 = String.format(str1+"\n" + "R " + counterR);
                    }
                    if (counterB == 0) {
                        str1 = str1 + "";
                    } else {
                        str1 = String.format(str1+"\n" + "B " + counterB);
                    }
                    if (counterN == 0) {
                        str1 = str1 + "";
                    } else {
                        str1 = String.format(str1+"\n" + "N " + counterN);
                    }
                    if (counterP == 0) {
                        str1 = str1 + "";
                    } else {
                        str1 = String.format(str1+"\n" + "P " + counterP+"\n");
                    }
                }
            }
        }
        return str1;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        int x =source.getX();
        int y= source.getY();
        ChessComponent chess = getChess(x,y);
        // 3.sort canMovePoints by x - y ascending order
        return chess.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
//        ChessboardPoint source=new ChessboardPoint(sourceX,sourceY);
//    for (int i = 0; i <getCanMovePoints(source).size(); i++) {
//            if (targetX==getCanMovePoints(){
//                return true;
//            }else {
//                return false;
//            }
        return false;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
    return  new ArrayList<>();

    }

//    @Override
//    public boolean canMoveTo(ChessComponent[][] chessboard, ChessboardPoint destination) {
//        return false;
//    }
}

