import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        this.chessComponents =new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK,'K');
                } else if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE,'k');
                } else if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK,'Q');
                } else if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE,'q');
                } else if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK,'R');
                } else if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE,'r');
                } else if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK,'N');
                } else if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE,'n');
                } else if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK,'B');
                } else if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE,'b');
                } else if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK,'P');
                } else if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE,'p');
                } else if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j), ChessColor.NONE,'_');
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")){
            currentPlayer=ChessColor.WHITE;
        } else if (Objects.equals(chessboard.get(8), "b")){
            currentPlayer=ChessColor.BLACK;
        }
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
        ArrayList<String> graph=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String s="";
            for (int j = 0; j < 8; j++) {
                s+=chessComponents[i][j].name;
            }
            graph.add(s);
        }
        return graph.get(0)+"\n"+graph.get(1)+"\n"+graph.get(2)+"\n"+graph.get(3)+"\n"+graph.get(4)+"\n"+graph.get(5)+"\n"+graph.get(6)+"\n"+graph.get(7);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if (player==ChessColor.WHITE){
            int pCount=8; int nCount=2; int bCount=2; int rCount=2; int qCount=1; int kCount=1;
            String s="";
            for (int i = 0; i < 71; i++) {
                if (getChessboardGraph().charAt(i)=='p'){
                    pCount--;
                }
                else if (getChessboardGraph().charAt(i)=='n'){
                    nCount--;
                }
                else if (getChessboardGraph().charAt(i)=='b'){
                    bCount--;
                }
                else if (getChessboardGraph().charAt(i)=='r'){
                    rCount--;
                }
                else if (getChessboardGraph().charAt(i)=='q'){
                    qCount--;
                }
                else if (getChessboardGraph().charAt(i)=='k'){
                    kCount--;
                }
            }
            if (kCount!=0){
                s+="k "+kCount+"\n";
            }
            if (qCount!=0){
                s+="q "+qCount+"\n";
            }
            if (rCount!=0){
                s+="r "+rCount+"\n";
            }
            if (bCount!=0){
                s+="b "+bCount+"\n";
            }
            if (nCount!=0){
                s+="n "+nCount+"\n";
            }
            if (pCount!=0){
                s+="p "+pCount+"\n";
            }
            return s;
        }
        else if (player==ChessColor.BLACK){
            int pCount=8; int nCount=2; int bCount=2; int rCount=2; int qCount=1; int kCount=1;
            String s="";
            for (int i = 0; i < 71; i++) {
                if (getChessboardGraph().charAt(i)=='P'){
                    pCount--;
                }
                else if (getChessboardGraph().charAt(i)=='N'){
                    nCount--;
                }
                else if (getChessboardGraph().charAt(i)=='B'){
                    bCount--;
                }
                else if (getChessboardGraph().charAt(i)=='R'){
                    rCount--;
                }
                else if (getChessboardGraph().charAt(i)=='Q'){
                    qCount--;
                }
                else if (getChessboardGraph().charAt(i)=='K'){
                    kCount--;
                }
            }
            if (kCount!=0){
                s+="K "+kCount+"\n";
            }
            if (qCount!=0){
                s+="Q "+qCount+"\n";
            }
            if (rCount!=0){
                s+="R "+rCount+"\n";
            }
            if (bCount!=0){
                s+="B "+bCount+"\n";
            }
            if (nCount!=0){
                s+="N "+nCount+"\n";
            }
            if (pCount!=0){
                s+="P "+pCount+"\n";
            }
            return s;
        }
        return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess= this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
}