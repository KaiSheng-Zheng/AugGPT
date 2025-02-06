import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char C=chessboard.get(i).charAt(j);
                if(C=='K'||C=='k'){
                    chessComponents[i][j]=new KingChessComponent(C,i,j);
                }
                else if (C=='Q'||C=='q'){
                    chessComponents[i][j]=new QueenChessComponent(C,i,j);
                }
                else if (C=='R'||C=='r'){
                    chessComponents[i][j]=new RookChessComponent(C,i,j);
                }
                else if (C=='N'||C=='n'){
                    chessComponents[i][j]=new KnightChessComponent(C,i,j);
                }
                else if (C=='P'||C=='p'){
                    chessComponents[i][j]=new PawnChessComponent(C,i,j);
                }
                else if (C=='B'||C=='b'){
                    chessComponents[i][j]=new BishopChessComponent(C,i,j);
                }
                else{
                    chessComponents[i][j]=new EmptySlotComponent(C,i,j);
                }


            }
        }

        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }

    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    public String getChessboardGraph() {
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result.append(chessComponents[i][j]);
            }
            result.append("\n");
        }
        return result.toString();
    }


    public String getCapturedChess(ChessColor player) {
        if(player.equals(ChessColor.WHITE)){
            return getWhiteCapturedChess();
        }
        return getBlackCapturedChess();

    }

    public String getBlackCapturedChess(){
        StringBuilder result=new StringBuilder();
        int[] array=new int[]{1,1,2,2,2,8};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char C=this.chessComponents[i][j].getName();
                if(C=='K'){
                    array[0]--;
                }
                if(C=='Q'){
                    array[1]--;
                }
                if(C=='R'){
                    array[2]--;
                }
                if(C=='B'){
                    array[3]--;
                }
                if(C=='N'){
                    array[4]--;
                }
                if(C=='P'){
                    array[5]--;
                }

            }

        }
        if(array[0]!=0){
            result.append("K "+array[0]+"\n");
        }
        if(array[1]!=0){
            result.append("Q "+array[1]+"\n");
        }
        if(array[2]!=0){
            result.append("R "+array[2]+"\n");
        }
        if(array[3]!=0){
            result.append("B "+array[3]+"\n");
        }
        if(array[4]!=0){
            result.append("N "+array[4]+"\n");
        }
        if(array[5]!=0){
            result.append("P "+array[5]+"\n");
        }
        return result.toString();

    }

    public String getWhiteCapturedChess(){
        StringBuilder result=new StringBuilder();
        int[] array=new int[]{1,1,2,2,2,8};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char C=this.chessComponents[i][j].getName();
                if(C=='k'){
                    array[0]--;
                }
                if(C=='q'){
                    array[1]--;
                }
                if(C=='r'){
                    array[2]--;
                }
                if(C=='b'){
                    array[3]--;
                }
                if(C=='n'){
                    array[4]--;
                }
                if(C=='p'){
                    array[5]--;
                }

            }

        }
        if(array[0]!=0){
            result.append("k "+array[0]+"\n");
        }
        if(array[1]!=0){
            result.append("q "+array[1]+"\n");
        }
        if(array[2]!=0){
            result.append("r "+array[2]+"\n");
        }
        if(array[3]!=0){
            result.append("b "+array[3]+"\n");
        }
        if(array[4]!=0){
            result.append("n "+array[4]+"\n");
        }
        if(array[5]!=0){
            result.append("p "+array[5]+"\n");
        }
        return result.toString();

    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent TargetChess=chessComponents[source.getX()][source.getY()];
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = TargetChess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        List<ChessboardPoint>OrderedCopy=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMovePoints.contains(new ChessboardPoint(i,j))){
                    OrderedCopy.add(new ChessboardPoint(i,j));
                }
            }
        }
        return OrderedCopy;
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(!chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){
            return false;
        }
        if (targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7) {
            return false;
        }
        if(chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', sourceX, sourceY);
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            if(currentPlayer.equals(ChessColor.WHITE)){
                currentPlayer=ChessColor.BLACK;
            }
            else {
                currentPlayer=ChessColor.WHITE;
            }
            return true;
        }
        return false;

    }

}