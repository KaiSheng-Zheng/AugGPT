import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class ConcreteChessGame  implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private List<String>  ChessBoard=new ArrayList<>();
    public ConcreteChessGame() {
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }

    public List<String> getChessBoard() {
        return ChessBoard;
    }
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void loadChessGame(List<String> chessboard) {
        this.ChessBoard=chessboard;

        if (chessboard.get(8).equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        }else if (chessboard.get(8).equals("b")){
            this.currentPlayer=ChessColor.BLACK;
        }else {
            this.currentPlayer=ChessColor.NONE;
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessboard.get(i).charAt(j)=='_'){chessComponents[j][i]=new EmptySlotComponent(new ChessboardPoint(j,i),ChessColor.NONE,'_');}
                if (chessboard.get(i).charAt(j)=='K'){chessComponents[j][i]=new KingChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'K');}
                if (chessboard.get(i).charAt(j)=='Q'){chessComponents[j][i]=new QueenChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'Q');}
                if (chessboard.get(i).charAt(j)=='R'){chessComponents[j][i]=new RookChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'R');}
                if (chessboard.get(i).charAt(j)=='B'){chessComponents[j][i]=new BishopChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'B');}
                if (chessboard.get(i).charAt(j)=='N'){chessComponents[j][i]=new KnightChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'N');}
                if (chessboard.get(i).charAt(j)=='P'){chessComponents[j][i]=new PawnChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'P');}
                if (chessboard.get(i).charAt(j)=='k'){chessComponents[j][i]=new KingChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'k');}
                if (chessboard.get(i).charAt(j)=='q'){chessComponents[j][i]=new QueenChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'q');}
                if (chessboard.get(i).charAt(j)=='r'){chessComponents[j][i]=new RookChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'r');}
                if (chessboard.get(i).charAt(j)=='b'){chessComponents[j][i]=new BishopChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'b');}
                if (chessboard.get(i).charAt(j)=='n'){chessComponents[j][i]=new KnightChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'n');}
                if (chessboard.get(i).charAt(j)=='p'){chessComponents[j][i]=new PawnChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'p');}
                chessComponents[j][i].setChessGame(this);
            }
        }
    }
    public ChessColor getCurrentPlayer()  {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
    public String getChessboardGraph(){
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",ChessBoard.get(0),ChessBoard.get(1),ChessBoard.get(2),ChessBoard.get(3),ChessBoard.get(4),ChessBoard.get(5),ChessBoard.get(6),ChessBoard.get(7));
    }
    public String getCapturedChess(ChessColor player){
        loadChessGame(this.ChessBoard);
        int King=1;int Queen=1;int Rooks=2;int Bishops=2;int Knights=2;int Pawns=8;
        if (player.toString().equals("BLACK")){
            StringBuilder Captures=new StringBuilder();
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (chessComponents[j][i].toString().equals("K")){
                        King=0;
                    }
                    if (chessComponents[j][i].toString().equals("Q")){
                        Queen=0;
                    }
                    if (chessComponents[j][i].toString().equals("R")){
                        Rooks--;
                    }
                    if (chessComponents[j][i].toString().equals("B")){
                        Bishops--;
                    }
                    if (chessComponents[j][i].toString().equals("N")){
                        Knights--;
                    }
                    if (chessComponents[j][i].toString().equals("P")){
                        Pawns--;
                    }
                }
            }
            if (King!=0){
                Captures.append(String.format("K %d\n",King));
            }
            if (Queen!=0){
                Captures.append(String.format("Q %d\n",Queen));
            }
            if (Rooks!=0){
                Captures.append(String.format("R %d\n",Rooks));
            }
            if (Bishops!=0){
                Captures.append(String.format("B %d\n",Bishops));
            }
            if (Knights!=0){
                Captures.append(String.format("N %d\n",Knights));
            }
            if (Pawns!=0){
                Captures.append(String.format("P %d\n",Pawns));
            }
            return Captures.toString();
        }
        else if (player.toString().equals("WHITE")){
            StringBuilder Captures=new StringBuilder();
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (chessComponents[j][i].toString().equals("k")){
                        King=0;
                    }
                    if (chessComponents[j][i].toString().equals("q")){
                        Queen=0;
                    }
                    if (chessComponents[j][i].toString().equals("r")){
                        Rooks--;
                    }
                    if (chessComponents[j][i].toString().equals("b")){
                        Bishops--;
                    }
                    if (chessComponents[j][i].toString().equals("n")){
                        Knights--;
                    }
                    if (chessComponents[j][i].toString().equals("p")){
                        Pawns--;
                    }
                }
            }
            if (King!=0){
                Captures.append(String.format("k %d\n",King));
            }
            if (Queen!=0){
                Captures.append(String.format("q %d\n",Queen));
            }
            if (Rooks!=0){
                Captures.append(String.format("r %d\n",Rooks));
            }
            if (Bishops!=0){
                Captures.append(String.format("b %d\n",Bishops));
            }
            if (Knights!=0){
                Captures.append(String.format("n %d\n",Knights));
            }
            if (Pawns!=0){
                Captures.append(String.format("p %d\n",Pawns));
            }
            return Captures.toString();
        }
        return null;
    }





    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        List<ChessboardPoint> CanMovePointsList=new ArrayList<>();
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                if (canMovePoints.contains(new ChessboardPoint(x,y))){
                    CanMovePointsList.add(new ChessboardPoint(x,y));
                }
            }
        }
        return canMovePoints;
    }






    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent Chess=chessComponents[sourceX][sourceY];
        if (Chess.getChessColor()==this.currentPlayer){
            List<ChessboardPoint> chessboardPointList=Chess.canMoveTo();
            for (int i=0;i<chessboardPointList.size();i++){
                if (Objects.equals(chessboardPointList.get(i), new ChessboardPoint(targetX, targetY))){
                    chessComponents[targetX][targetY]=Chess;
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                    return true;
                }
            }
        }

        return false;
    }


}
