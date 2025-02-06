import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    }
                if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                }
                if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                }
                if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                }
                if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                }
                if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                }
                if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                }
                if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }
                if (chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                }
                if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                }
                if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
                if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent();
                }
               chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
        if (Objects.equals(chessboard.get(8), "w")) {
            currentPlayer=ChessColor.WHITE;
        } else {
            currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder tmp = new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                tmp.append(chessComponents[i][j].name);
            }
            tmp.append("\n");
        }
        return tmp.toString();
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder out = new StringBuilder();
        if (player==ChessColor.BLACK){
            int[] tmp = new int[6];
            tmp[0]=1;
            tmp[1]=1;
            tmp[2]=2;
            tmp[3]=2;
            tmp[4]=2;
            tmp[5]=8;
            for (int i = 0;i<8;i++){
                for (int j =0;j<8;j++){
                    if (Objects.equals(chessComponents[i][j].toString(), "K")){
                       tmp[0]-=1;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "Q")){
                        tmp[1]-=1;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "R")){
                        tmp[2]-=1;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "B")){
                        tmp[3]-=1;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "N")){
                        tmp[4]-=1;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "P")){
                        tmp[5]-=1;
                    }
                }
            }
            if (tmp[0]!=0){
                out.append("K ").append(tmp[0]);
                out.append("\n");
            }
            if (tmp[1]!=0){
                out.append("Q ").append(tmp[1]);
                out.append("\n");
            }
            if (tmp[2]!=0){
                out.append("R ").append(tmp[2]);
                out.append("\n");
            }
            if (tmp[3]!=0){
                out.append("B ").append(tmp[3]);
                out.append("\n");
            }
            if (tmp[4]!=0){
                out.append("N ").append(tmp[4]);
                out.append("\n");
            }
            if (tmp[5]!=0){
                out.append("P ").append(tmp[5]);
                out.append("\n");
            }
        }
        if (player==ChessColor.WHITE){
            int[] tmp = new int[6];
            tmp[0]=1;
            tmp[1]=1;
            tmp[2]=2;
            tmp[3]=2;
            tmp[4]=2;
            tmp[5]=8;
            for (int i = 0;i<8;i++){
                for (int j =0;j<8;j++){
                    if (Objects.equals(chessComponents[i][j].toString(), "k")){
                        tmp[0]-=1;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "q")){
                        tmp[1]-=1;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "r")){
                        tmp[2]-=1;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "b")){
                        tmp[3]-=1;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "n")){
                        tmp[4]-=1;
                    }
                    if (Objects.equals(chessComponents[i][j].toString(), "p")){
                        tmp[5]-=1;
                    }
                }
            }
            if (tmp[0]!=0){
                out.append("k ").append(tmp[0]);
                out.append("\n");
            }
            if (tmp[1]!=0){
                out.append("q ").append(tmp[1]);
                out.append("\n");
            }
            if (tmp[2]!=0){
                out.append("r ").append(tmp[2]);
                out.append("\n");
            }
            if (tmp[3]!=0){
                out.append("b ").append(tmp[3]);
                out.append("\n");
            }
            if (tmp[4]!=0){
                out.append("n ").append(tmp[4]);
                out.append("\n");
            }
            if (tmp[5]!=0){
                out.append("p ").append(tmp[5]);
                out.append("\n");
            }
        }
        return out.toString();
    }

    public  ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public ChessComponent[][] getChessComponents(){
        return chessComponents;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints = getChess(source.getX(),source.getY()).canMoveTo();
        canMovePoints.sort(Comparator.comparingInt(ChessboardPoint::getY));
        canMovePoints.sort(Comparator.comparingInt(ChessboardPoint::getX));
        return canMovePoints;
    }
    public List<ChessboardPoint> getCanMoves(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints = getChess(source.getX(),source.getY()).canMoveTo();
        canMovePoints.sort(Comparator.comparingInt(ChessboardPoint::getY));
        canMovePoints.sort(Comparator.comparingInt(ChessboardPoint::getX));
        return canMovePoints;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        if (this.currentPlayer == getChess(sourceX,sourceY).getChessColor()){
            if (compare(source,target)){
                this.chessComponents[targetX][targetY]=this.chessComponents[sourceX][sourceY];
                this.chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                this.chessComponents[targetX][targetY].setSource(target);
                if (currentPlayer==ChessColor.WHITE){
                    this.currentPlayer=ChessColor.BLACK;
                } else {
                    this.currentPlayer=ChessColor.WHITE;
                }
                   return true;
               }
        }
        return false;
    }
    public boolean compare(ChessboardPoint source,ChessboardPoint target){
        for (int i=0; i<getCanMovePoints(source).size();i++){
            if (getCanMovePoints(source).get(i).getX()== target.getX() && getCanMovePoints(source).get(i).getY()== target.getY()){
                return true;
            }
        }
        return false;
    }
}
