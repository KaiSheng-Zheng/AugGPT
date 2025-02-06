import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ConcreteChessGame() {
        this.chessComponents= new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                char chessIJ=chessboard.get(i).charAt(j);
                if(chessIJ=='Q'||chessIJ=='q'){chessComponents[i][j]=new QueenChessComponent();}
                else if(chessIJ=='K'||chessIJ=='k'){chessComponents[i][j]=new KingChessComponent();}
                else if(chessIJ=='B'||chessIJ=='b'){chessComponents[i][j]=new BishopChessComponent();}
                else if(chessIJ=='P'||chessIJ=='p'){chessComponents[i][j]=new PawnChessComponent();}
                else if(chessIJ=='R'||chessIJ=='r'){chessComponents[i][j]=new RookChessComponent();}
                else if(chessIJ=='N'||chessIJ=='n'){chessComponents[i][j]=new KnightChessComponent();}
                else{chessComponents[i][j]=new EmptySlotComponent();}
                chessComponents[i][j].name = chessIJ;
                ChessboardPoint x =new ChessboardPoint(i,j);
                chessComponents[i][j].setSource(x);
                int ASCII =(int)chessboard.get(i).charAt(j);
                if(ASCII<91&&ASCII>64){chessComponents[i][j].setChessColor(ChessColor.BLACK);}
                else if(ASCII>96&&ASCII<123){chessComponents[i][j].setChessColor(ChessColor.WHITE);}
                else {chessComponents[i][j].setChessColor(ChessColor.NONE);}
            }
        }
        saveChessComponent();
        if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }else{ currentPlayer=ChessColor.BLACK;}
    }
    public void saveChessComponent(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                getChessComponents()[i][j].loadChessBoardComponent(getChessComponents());
            }
        }
    }
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder chessboardRecord=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                chessboardRecord.append(chessComponents[i][j].name);
                if(j==7){chessboardRecord.append('\n');}
            }
        }
        return String.valueOf(chessboardRecord);
    }
    public String getCapturedChess(ChessColor player){
        StringBuilder capturedChessNumber=new StringBuilder();
        String chessboard=getChessboardGraph();
        if(player==ChessColor.BLACK){
            capturedChessNumber.append(capturedChess(1,chessboard,'K'));
            capturedChessNumber.append(capturedChess(1,chessboard,'Q'));
            capturedChessNumber.append(capturedChess(2,chessboard,'R'));
            capturedChessNumber.append(capturedChess(2,chessboard,'B'));
            capturedChessNumber.append(capturedChess(2,chessboard,'N'));
            capturedChessNumber.append(capturedChess(8,chessboard,'P'));
            return String.valueOf(capturedChessNumber);
        }
        else {
            capturedChessNumber.append(capturedChess(1,chessboard,'k'));
            capturedChessNumber.append(capturedChess(1,chessboard,'q'));
            capturedChessNumber.append(capturedChess(2,chessboard,'r'));
            capturedChessNumber.append(capturedChess(2,chessboard,'b'));
            capturedChessNumber.append(capturedChess(2,chessboard,'n'));
            capturedChessNumber.append(capturedChess(8,chessboard,'p'));
            return String.valueOf(capturedChessNumber);
        }
    }
    public String capturedChess(int initialNumber,String chessboardRecord,char x){
        int Number=0;
        for(int i=0;i<chessboardRecord.length();i++){
            if(x==chessboardRecord.charAt(i)){Number++;}
        }
        if(initialNumber-Number==0){return "";}
        else{return String.format("%c %d\n",x,initialNumber-Number);}
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        return ArraySort(this.chessComponents[source.getX()][source.getY()].canMoveTo());
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessboardPoint initialSource=new ChessboardPoint(sourceX,sourceY);
        if (getChessComponents()[sourceX][sourceY].getChessColor().equals(getCurrentPlayer())) {
            for(int i=0;i<getCanMovePoints(initialSource).size();i++) {
                if (getCanMovePoints(initialSource).get(i).getX() == targetX && getCanMovePoints(initialSource).get(i).getY() == targetY) {
                    getChessComponents()[targetX][targetY] = getChessComponents()[sourceX][sourceY];
                    getChessComponents()[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                    getChessComponents()[targetX][targetY].setChessColor(getChessComponents()[sourceX][sourceY].getChessColor());
                    getChessComponents()[targetX][targetY].setName(getChessComponents()[sourceX][sourceY].getName());
                    getChessComponents()[sourceX][sourceY] = new EmptySlotComponent(initialSource, ChessColor.NONE, '_');
                    saveChessComponent();
                    if (currentPlayer == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    } else if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public List<ChessboardPoint> ArraySort(List<ChessboardPoint> points){
        List<ChessboardPoint> newPoints =new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                for(int m=0;m< points.size();m++) {
                    if (points.get(m).getX()==i&&points.get(m).getY()==j) {
                        newPoints.add(points.get(m));
                    }
                }
            }
        }
        return newPoints;
    }
}
