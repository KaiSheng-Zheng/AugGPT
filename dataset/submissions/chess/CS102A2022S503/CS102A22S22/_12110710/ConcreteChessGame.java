import java.beans.BeanInfo;
import java.net.CookieHandler;
import java.util.*;

public class ConcreteChessGame implements ChessGame{

    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
//    public static ChessComponent[][] concreteChessComponents;

    public ConcreteChessGame(){
        this.currentPlayer =ChessColor.WHITE;
        this.chessComponents =new ChessComponent[8][8];
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessboardPoint source=new ChessboardPoint(i,j);
                switch (chessboard.get(i).charAt(j)){
                    case 'R':chessComponents[i][j]=new RookChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'N':chessComponents[i][j]=new KnightChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'B':chessComponents[i][j]=new BishopChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'Q':chessComponents[i][j]=new QueenChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'K':chessComponents[i][j]=new KingChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'P':chessComponents[i][j]=new PawnChessComponent(source,ChessColor.BLACK,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case '_':chessComponents[i][j]=new EmptySlotComponent(source,ChessColor.NONE,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'r':chessComponents[i][j]=new RookChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'n':chessComponents[i][j]=new KnightChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'b':chessComponents[i][j]=new BishopChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'q':chessComponents[i][j]=new QueenChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'k':chessComponents[i][j]=new KingChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    case 'p':chessComponents[i][j]=new PawnChessComponent(source,ChessColor.WHITE,chessboard.get(i).charAt(j));chessComponents[i][j].setWholeChessGame(chessComponents);break;
                    default:break;
                }
            }
        }
        if(chessboard.get(chessboard.size()-1).equals("w")){
            setCurrentPlayer(ChessColor.WHITE);
        }
        else if(chessboard.get(chessboard.size()-1).equals("b")){
            setCurrentPlayer(ChessColor.BLACK);
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String preanswer = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent helper = chessComponents[i][j];
                if (helper instanceof EmptySlotComponent) {
                    preanswer += "_";
                } else if (helper instanceof KingChessComponent && helper.getChessColor() == ChessColor.BLACK) {
                    preanswer += "K";
                } else if (helper instanceof KingChessComponent && helper.getChessColor() == ChessColor.WHITE) {
                    preanswer += "k";
                } else if (helper instanceof QueenChessComponent && helper.getChessColor() == ChessColor.WHITE) {
                    preanswer += "q";
                } else if (helper instanceof QueenChessComponent && helper.getChessColor() == ChessColor.BLACK) {
                    preanswer += "Q";
                } else if (helper instanceof RookChessComponent && helper.getChessColor() == ChessColor.WHITE) {
                    preanswer += "r";
                } else if (helper instanceof RookChessComponent && helper.getChessColor() == ChessColor.BLACK) {
                    preanswer += "R";
                } else if (helper instanceof BishopChessComponent && helper.getChessColor() == ChessColor.WHITE) {
                    preanswer += "b";
                } else if (helper instanceof BishopChessComponent && helper.getChessColor() == ChessColor.BLACK) {
                    preanswer += "B";
                } else if (helper instanceof KnightChessComponent && helper.getChessColor() == ChessColor.WHITE) {
                    preanswer += "n";
                } else if (helper instanceof KnightChessComponent && helper.getChessColor() == ChessColor.BLACK) {
                    preanswer += "N";
                } else if (helper instanceof PawnChessComponent && helper.getChessColor() == ChessColor.WHITE) {
                    preanswer += "p";
                } else {
                    preanswer += "P";
                }
            }
            preanswer+="\n";
        }
        return preanswer;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        List<ChessComponent> whoChess=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(Character.isLetter(chessComponents[i][j].name)) {
                    if(player.equals(ChessColor.WHITE)){
                        if(Character.isLowerCase(chessComponents[i][j].name)){
                            whoChess.add(chessComponents[i][j]);
                        }
                    }
                    else {
                        if(Character.isUpperCase(chessComponents[i][j].name)){
                            whoChess.add(chessComponents[i][j]);
                        }
                    }
                }
            }
        }
        int[] numberHelper={0,0,0,0,0,0};
        for(int k=0;k<whoChess.size();k++){
            if(whoChess.get(k)instanceof KingChessComponent){numberHelper[0]++;}
            else if(whoChess.get(k)instanceof QueenChessComponent){numberHelper[1]++;}
            else if(whoChess.get(k)instanceof RookChessComponent){numberHelper[2]++;}
            else if(whoChess.get(k)instanceof BishopChessComponent){numberHelper[3]++;}
            else if(whoChess.get(k)instanceof KnightChessComponent){numberHelper[4]++;}
            else {numberHelper[5]++;}
        }
        String answer="";
        if(player.equals(ChessColor.BLACK)){
            if (numberHelper[0]!=1){answer=answer+"K 1\n";}
            if(numberHelper[1]!=1){answer=answer+"Q 1\n";}
            if(numberHelper[2]!=2){answer=answer+"R "+(2-numberHelper[2])+"\n";}
            if(numberHelper[3]!=2){answer=answer+"B "+(2-numberHelper[3])+"\n";}
            if(numberHelper[4]!=2){answer=answer+"N "+(2-numberHelper[4])+"\n";}
            if(numberHelper[5]!=6){answer=answer+"P "+(8-numberHelper[5])+"\n";}
        }
        else if(player.equals(ChessColor.WHITE)){
            if (numberHelper[0]!=1){answer=answer+"k 1\n";}
            if(numberHelper[1]!=1){answer=answer+"q 1\n";}
            if(numberHelper[2]!=2){answer=answer+"r "+(2-numberHelper[2])+"\n";}
            if(numberHelper[3]!=2){answer=answer+"b "+(2-numberHelper[3])+"\n";}
            if(numberHelper[4]!=2){answer=answer+"n "+(2-numberHelper[4])+"\n";}
            if(numberHelper[5]!=6){answer=answer+"p "+(8-numberHelper[5])+"\n";}
        }
        else {
            return "";
        }
        return answer;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        for(int i=0;i<canMovePoints.size()-1;i++){
            if(canMovePoints.get(i).getX()>canMovePoints.get(i+1).getX()){
                Collections.swap(canMovePoints,i,i+1);
                i=-1;
            }
        }
        for(int j=0;j<canMovePoints.size()-1;j++){
            if(canMovePoints.get(j).getX()==canMovePoints.get(j+1).getX()&&canMovePoints.get(j).getY()>canMovePoints.get(j+1).getY()){
                Collections.swap(canMovePoints,j,j+1);
                j=-1;
            }
        }
        return canMovePoints;

//        ChessComponent chess=chessComponents[source.getX()][source.getY()];
//        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
//        for(int i=0;i<canMovePoints.size()-1;i++){
//            if(canMovePoints.get(i).getX()>canMovePoints.get(i+1).getX()){
//                Collections.swap(canMovePoints,i,i+1);
//                i=-1;
//            }
//        }
//        for(int i=0;i<canMovePoints.size()-1;i++){
//            if(canMovePoints.get(i).getY()>canMovePoints.get(i).getY()&&canMovePoints.get(i).getX()==canMovePoints.get(i).getX()){
//                Collections.swap(canMovePoints,i,i+1);
//                i=-1;
//            }
//        }
//        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(!(chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer))){//different color
            return false;
        }
        else {
            int countHelper=0;
            for(ChessboardPoint chessboardPoint:chessComponents[sourceX][sourceY].canMoveTo()){
                if(chessboardPoint.getY()==targetY&&chessboardPoint.getX()==targetX){
                    countHelper++;
                }
            }
            if(countHelper==0){//cant move
                return false;
            }
            else {
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                if(getCurrentPlayer().equals(ChessColor.WHITE)){
                    currentPlayer=ChessColor.BLACK;
                }
                else {
                    currentPlayer=ChessColor.WHITE;
                }
                return true;
            }
        }
    }


//    public static ChessComponent[][] getChessComponents() {
//        return chessComponents;
//    }

}
