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

    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public ChessColor getColor(char c){
        if (c>'A'&c<'Z'){
            return ChessColor.BLACK;
        }else if (c>'a'&c<'z'){
            return ChessColor.WHITE;
        }else return ChessColor.NONE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int l=0;l<8;l++){
                char c=chessboard.get(i).charAt(l);
                if(c=='K'|c=='k'){
                    chessComponents[i][l]=new KingChessComponent(new ChessboardPoint(i, l),getColor(c));
                }
                else if(c=='Q'|c=='q'){
                    chessComponents[i][l]=new QueenChessComponent(new ChessboardPoint(i, l),getColor(c));
                }
                else if(c=='R'||c=='r'){
                    chessComponents[i][l]=new RookChessComponent(new ChessboardPoint(i, l),getColor(c));
                }
                else if(c=='B'|c=='b'){
                    chessComponents[i][l]=new BishopChessComponent(new ChessboardPoint(i, l),getColor(c));
                }
                else if(c=='N'|c=='n'){
                    chessComponents[i][l]=new KnightChessComponent(new ChessboardPoint(i, l),getColor(c));
                }
                else if(c=='P'|c=='p'){
                    chessComponents[i][l]=new PawnChessComponent(new ChessboardPoint(i, l),getColor(c));
                }
                else{
                    chessComponents[i][l]=new EmptySlotComponent(new ChessboardPoint(i, l),ChessColor.NONE);
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }else if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder chessboardBuilder = new StringBuilder();
        for(int i = 0; i<8; i++){
            for(int l=0;l<8;l++){
                char c= chessComponents[i][l].toString().charAt(0);
                   chessboardBuilder.append(c);
            }
            chessboardBuilder.append("\n");
        }
//        if (getCurrentPlayer()==ChessColor.BLACK){
//            chessboardBuilder.append("b");
//        }else if (getCurrentPlayer()==ChessColor.WHITE){
//            chessboardBuilder.append("w");
//        }
        String chessboard = chessboardBuilder.toString();
        return chessboard;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] a=new int[]{'K','Q','R','B','N','P'},b=new int[]{'k','q','r','b','n','p'},c=new int[]{1,1,2,2,2,8};
        StringBuilder sb=new StringBuilder();
        if (player==ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (getColor(chessComponents[i][j].toString().charAt(0)) == ChessColor.BLACK) {
                        for (int l = 0; l < 6; l++) {
                            if (chessComponents[i][j].toString().charAt(0) == a[l]) {
                                c[l] -= 1;
                            }
                        }
                    }
                }
            }
            for (int l =0;l<6;l++){
                if (c[l]!=0){
                    sb.append((char)a[l]).append(" ").append(c[l]).append("\n");
                }
            }
        }else if (player==ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (getColor(chessComponents[i][j].toString().charAt(0)) == ChessColor.WHITE) {
                        for (int l = 0; l < 6; l++) {
                            if (chessComponents[i][j].toString().charAt(0) == b[l]) {
                                c[l] -= 1;
                            }
                        }
                    }
                }
            }
            for (int l =0;l<6;l++){
                if (c[l]!=0){
                    sb.append((char)b[l]).append(" ").append(c[l]).append("\n");
                }
            }
        }
        return sb.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].chessColor0==getCurrentPlayer()) {
            List<ChessboardPoint> canMovePoints = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
            for (ChessboardPoint canMovePoint : canMovePoints) {
                if (targetX == canMovePoint.getX() &
                        targetY == canMovePoint.getY()) {
                    chessComponents[sourceX][sourceY].setChessboardPoint(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY)
                            ,ChessColor.NONE);
                            if (getCurrentPlayer()==ChessColor.WHITE){
                        currentPlayer=ChessColor.BLACK;
                    }else if (getCurrentPlayer()==ChessColor.BLACK){
                        currentPlayer=ChessColor.WHITE;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessBoard(chessComponents);
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        ChessboardPoint[][] chessboardPoints=new ChessboardPoint[8][8];
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        if (canMovePoints != null) {
            for (int l = 0; l < canMovePoints.size(); l++) {
                chessboardPoints[canMovePoints.get(l).getX()][canMovePoints.get(l).getY()]=canMovePoints.get(l);
            }
            for (int l = 0; l < 8; l++){
                for (int i = 0; i < 8; i++){
                    if (chessboardPoints[l][i]!=null){
                        chessboardPointList.add(chessboardPoints[l][i]);
                    }
                }
            }
        }
        return chessboardPointList;
    }
}
