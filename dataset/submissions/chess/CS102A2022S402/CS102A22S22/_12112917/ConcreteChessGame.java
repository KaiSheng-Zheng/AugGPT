import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents=new ChessComponent[8][8];
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                this.chessComponents[i][j] = chartocc(chessboard.get(i).charAt(j),i,j);
            }
        }
        if(Objects.equals(chessboard.get(8), "w")){
            this.currentPlayer = ChessColor.WHITE;
        }
        if(Objects.equals(chessboard.get(8), "b")){
            this.currentPlayer = ChessColor.BLACK;
        }
        ChessComponent.chessComponents = this.chessComponents;
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
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                sb.append(chessComponents[i][j].toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if(player==ChessColor.BLACK) {
            int cntk = 0;
            int cntq = 0;
            int cntr = 0;
            int cntb = 0;
            int cntn = 0;
            int cntp = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K' ) cntk++;
                    else if (chessComponents[i][j].name == 'Q' ) cntq++;
                    else if (chessComponents[i][j].name == 'R' ) cntr++;
                    else if (chessComponents[i][j].name == 'B' ) cntb++;
                    else if (chessComponents[i][j].name == 'N' ) cntn++;
                    else if (chessComponents[i][j].name == 'P' ) cntp++;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (cntk != 1) sb.append("K 1\n");
            if (cntq != 1) sb.append("Q 1\n");
            if (cntr != 2) sb.append(String.format("R %s\n", 2 - cntr));
            if (cntb != 2) sb.append(String.format("B %s\n", 2 - cntb));
            if (cntn != 2) sb.append(String.format("N %s\n", 2 - cntn));
            if (cntp != 8) sb.append(String.format("P %s\n", 8 - cntp));
            return sb.toString();
        }else{
            int cntk = 0;
            int cntq = 0;
            int cntr = 0;
            int cntb = 0;
            int cntn = 0;
            int cntp = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') cntk++;
                    else if (chessComponents[i][j].name == 'q') cntq++;
                    else if (chessComponents[i][j].name == 'r') cntr++;
                    else if (chessComponents[i][j].name == 'b') cntb++;
                    else if (chessComponents[i][j].name == 'n') cntn++;
                    else if (chessComponents[i][j].name == 'p') cntp++;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (cntk != 1) sb.append("k 1\n");
            if (cntq != 1) sb.append("q 1\n");
            if (cntr != 2) sb.append(String.format("r %s\n", 2 - cntr));
            if (cntb != 2) sb.append(String.format("b %s\n", 2 - cntb));
            if (cntn != 2) sb.append(String.format("n %s\n", 2 - cntn));
            if (cntp != 8) sb.append(String.format("p %s\n", 8 - cntp));
            return sb.toString();
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> c1 = new ArrayList<>();
        if(chessComponents[sourceX][sourceY].getChessColor()==currentPlayer) {
            c1 = chessComponents[sourceX][sourceY].canMoveTo();
        }
        Boolean c2 = false;
        for(int i = 0;i<c1.size();i++){
            if(c1.get(i).getX()==targetX&&c1.get(i).getY()==targetY){
                c2=true;
                break;
            }
        }
        if(c2){
            chessComponents[targetX][targetY]=chartocc(chessComponents[sourceX][sourceY].name,targetX,targetY);
            chessComponents[sourceX][sourceY]=new EmptySlotComponent
                    (new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
            ChessComponent.chessComponents=this.chessComponents;
            if(currentPlayer==ChessColor.WHITE){
                currentPlayer=ChessColor.BLACK;
            }
            else if(currentPlayer==ChessColor.BLACK){
                currentPlayer=ChessColor.WHITE;
            }
        }
        return c2;
    }

    public ChessComponent chartocc(char a,int i, int j){
        if(a=='R'){
            return new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
        }else if(a=='r'){
            return new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
        }else if(a=='B'){
            return new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
        }else if(a=='b'){
            return new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
        }else if(a=='_'){
            return new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE);
        }else if(a=='K'){
            return new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
        }else if(a=='k'){
            return new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
        }else if(a=='N'){
            return new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
        }else if(a=='n'){
            return new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
        }else if(a=='P'){
            return new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
        }else if(a=='p'){
            return new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
        }else if(a=='Q'){
            return new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
        }else if(a=='q'){
            return new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
        }else
            return null;
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> c1;
                c1=chessComponents[source.getX()][source.getY()].canMoveTo();
        c1.sort(new ChessboardPointComparator());
        return c1;
    }


}
