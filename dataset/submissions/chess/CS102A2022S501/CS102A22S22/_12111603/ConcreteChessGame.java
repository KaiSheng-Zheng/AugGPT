

import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer=ChessColor.WHITE;
    public ConcreteChessGame(ChessColor blackOrWhite){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=blackOrWhite;

    }
    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer =  ChessColor.BLACK;
        }
        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer =  ChessColor.WHITE;
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'R');
                }
                else if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'r');
                }
                else if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'N');
                }
                else if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'n');
                }
                else if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'K');
                }
                else if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'k');
                }
                else if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'Q');
                }
                else if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'q');
                }
                else if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'B');
                }
                else if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'b');
                }
                else if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'P');
                }
                else if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'p');
                }
                else{
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j));
                }

                chessComponents[i][j].setChessboard(chessComponents);
                chessComponents[i][j].setItsConcreteGame(this);
            }
        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getColor()==ChessColor.BLACK){
                    stringBuilder.append('R');
                }
                else if(chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getColor()==ChessColor.WHITE){
                    stringBuilder.append('r');
                }
                else if(chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getColor()==ChessColor.BLACK){
                    stringBuilder.append('Q');
                }
                else if(chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getColor()==ChessColor.WHITE){
                    stringBuilder.append('q');
                }
                else if(chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getColor()==ChessColor.BLACK){
                    stringBuilder.append('N');
                }
                else if(chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getColor()==ChessColor.WHITE){
                    stringBuilder.append('n');
                }
                else if(chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getColor()==ChessColor.BLACK){
                    stringBuilder.append('K');
                }
                else if(chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getColor()==ChessColor.WHITE){
                    stringBuilder.append('k');
                }
                else if(chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getColor()==ChessColor.BLACK){
                    stringBuilder.append('B');
                }
                else if(chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getColor()==ChessColor.WHITE){
                    stringBuilder.append('b');
                }
                else if(chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getColor()==ChessColor.BLACK){
                    stringBuilder.append('P');
                }
                else if(chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getColor()==ChessColor.WHITE){
                    stringBuilder.append('p');
                }
                if(chessComponents[i][j]instanceof EmptySlotComponent){
                    stringBuilder.append('_');
                }
            }
            if(i!=7)
                stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getCapturedChess(ChessColor player) {
        int King = 0, Queen = 0, Rook = 0, Bishop = 0, Knight = 0, Pawn = 0;
        String temp = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j]instanceof KingChessComponent&&(chessComponents[i][j]).getColor()==player){
                    King ++;
                }
                else if(chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getColor()==player){
                    Queen ++;
                }
                else if(chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getColor()==player){
                    Rook ++;
                }
                else if(chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getColor()==player){
                    Bishop ++;
                }
                else if(chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getColor()==player){
                    Knight ++;
                }
                else if(chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getColor()==player){
                    Pawn ++;
                }
            }
        }

        if(player == ChessColor.BLACK){
            if(King !=1){
                temp+="K "+(1-King)+"\n";
            }
            if(Queen !=1){
                temp+= "Q "+(1-Queen)+"\n";
            }
            if(Rook !=2){
                temp+="R "+(2-Rook)+"\n";
            }
            if(Bishop !=2){
                temp+="B "+(2-Bishop)+"\n";
            }
            if(Knight !=2){
                temp+="N "+(2-Knight)+"\n";
            }
            if(Pawn !=8){
                temp+="P "+(8-Pawn)+"\n";
            }
        }
        else {
            if(King !=1){
                temp+="k "+(1-King)+"\n";
            }
            if(Queen !=1){
                temp+= "q "+(1-Queen)+"\n";
            }
            if(Rook !=2){
                temp+="r "+(2-Rook)+"\n";
            }
            if(Bishop !=2){
                temp+="b "+(2-Bishop)+"\n";
            }
            if(Knight !=2){
                temp+="n "+(2-Knight)+"\n";
            }
            if(Pawn !=8){
                temp+="p "+(8-Pawn)+"\n";
            }
        }
        return temp;
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return true;
    }
}

