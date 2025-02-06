import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer ;

    public ConcreteChessGame(){
        this.currentPlayer = ChessColor.WHITE;
        this.chessComponents = new ChessComponent[8][8];
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if(chessboard.size()==9&&chessboard.get(0).length()==8&&chessboard.get(1).length()==8&&chessboard.get(2).length()==8
        &&chessboard.get(3).length()==8&&chessboard.get(4).length()==8&&chessboard.get(5).length()==8&&
                chessboard.get(6).length()==8&&chessboard.get(7).length()==8&&chessboard.get(8).length()==1)
        {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessboard.get(i).charAt(j)=='R'){
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='r'){
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    }
                    if(chessboard.get(i).charAt(j)=='N'){
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='n'){
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                    }
                    if(chessboard.get(i).charAt(j)=='B'){
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='b'){
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                    }
                    if(chessboard.get(i).charAt(j)=='Q'){
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='q'){
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                    }
                    if(chessboard.get(i).charAt(j)=='K'){
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='k'){
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                    }
                    if(chessboard.get(i).charAt(j)=='P'){
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='p'){
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                    }
                    if(chessboard.get(i).charAt(j)=='_'){
                        this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j));
                    }
                }
            }
            if(chessboard.get(8).equals("w"))
                currentPlayer = ChessColor.WHITE;
            if(chessboard.get(8).equals("b"))
                currentPlayer = ChessColor.BLACK;
            ChessComponent.setChessboard(chessComponents);
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
        StringBuilder Answer = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Answer.append(chessComponents[i][j].getName());
                if(j==7)
                    Answer.append('\n');
            }
        }
        return Answer.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int Rook = 0,Knight = 0,Bishop = 0,Queen = 0,King = 0,Pawn = 0;
        StringBuilder answer = new StringBuilder();
        if(player == ChessColor.BLACK){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (this.chessComponents[i][j].getName()){
                        case 'R':
                            Rook++;
                            break;
                        case 'N':
                            Knight++;
                            break;
                        case 'B':
                            Bishop++;
                            break;
                        case 'Q':
                            Queen++;
                            break;
                        case 'K':
                            King++;
                            break;
                        case 'P':
                            Pawn++;
                            break;
                        default:break;
                    }
                }
            }
            if(King<1)
                answer.append("K 1\n");
            if(Queen<1)
                answer.append("Q 1\n");
            if(Rook<2)
                answer.append("R ").append(2-Rook).append("\n");
            if(Bishop<2)
                answer.append("B ").append(2-Bishop).append("\n");
            if(Knight<2)
                answer.append("N ").append(2-Knight).append("\n");
            if(Pawn<8)
                answer.append("P ").append(8-Pawn).append("\n");
            return answer.toString();
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (this.chessComponents[i][j].getName()){
                    case 'r':
                        Rook++;
                        break;
                    case 'n':
                        Knight++;
                        break;
                    case 'b':
                        Bishop++;
                        break;
                    case 'q':
                        Queen++;
                        break;
                    case 'k':
                        King++;
                        break;
                    case 'p':
                        Pawn++;
                        break;
                    }
                }
            }
            if(King<1)
                answer.append("k 1\n");
            if(Queen<1)
                answer.append("q 1\n");
            if(Rook<2)
                answer.append("r ").append(2-Rook).append("\n");
            if(Bishop<2)
                answer.append("b ").append(2-Bishop).append("\n");
            if(Knight<2)
                answer.append("n ").append(2-Knight).append("\n");
            if(Pawn<8)
                answer.append("p ").append(8-Pawn).append("\n");
            return answer.toString();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint chessboardPoint){
        ChessComponent chess = getChess(chessboardPoint.getX(),chessboardPoint.getY());
        chess.setChessboardPoint(chessboardPoint);
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }
    public void setCurrentPlayer(ChessColor chessColor){this.currentPlayer=chessColor;}
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (this.getChess(sourceX,sourceY).getChessColor()!=this.currentPlayer) {
            return false;
        }
        boolean flag=false;
        for (ChessboardPoint test:this.getChess(sourceX,sourceY).canMoveTo()){
            if (test.getX()==targetX&&test.getY()==targetY) {
                flag=true;
                break;
            }
        }

        if (flag){
            this.chessComponents[targetX][targetY]=this.getChess(sourceX,sourceY);
            this.chessComponents[targetX][targetY].setChessboardPoint(new ChessboardPoint(targetX,targetY));
            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY);
            this.chessComponents[sourceX][sourceY].setName('_');
            this.chessComponents[sourceX][sourceY].setChessboardPoint(new ChessboardPoint(sourceX,sourceY));
            if (this.currentPlayer == ChessColor.BLACK) {
                this.setCurrentPlayer(ChessColor.WHITE);
            } else {
                this.setCurrentPlayer(ChessColor.BLACK);
            }
            ChessComponent.setChessboard(this.chessComponents);
        }
        return flag;
    }

}