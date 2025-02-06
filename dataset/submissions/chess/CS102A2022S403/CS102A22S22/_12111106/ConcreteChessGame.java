import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    public static ChessComponent[][] chess = new ChessComponent[8][8];
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void loadChessGame(List<String> chessboard) {
        for(int n=0; n<8; n++){
            String s = chessboard.get(n);
            String[] ar = s.split("");
            for(int m=0; m<8; m++){
                if(Objects.equals(ar[m], "R")){
                    chessComponents[n][m]= new RookChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.BLACK);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'R';
                }else if(Objects.equals(ar[m], "r")){
                    chessComponents[n][m] = new RookChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.WHITE);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'r';
                }else if(Objects.equals(ar[m], "N")){
                    chessComponents[n][m] = new KnightChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.BLACK);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'N';
                }else if(Objects.equals(ar[m], "n")){
                    chessComponents[n][m] = new KnightChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.WHITE);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'n';
                }else if(Objects.equals(ar[m], "B")){
                    chessComponents[n][m] = new BishopChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.BLACK);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'B';
                }else if(Objects.equals(ar[m], "b")){
                    chessComponents[n][m] = new BishopChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.WHITE);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'b';
                }else if(Objects.equals(ar[m], "P")){
                    chessComponents[n][m] = new PawnChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.BLACK);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'P';
                }else if(Objects.equals(ar[m], "p")){
                    chessComponents[n][m] = new PawnChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.WHITE);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'p';
                }else if(Objects.equals(ar[m], "K")){
                    chessComponents[n][m] = new KingChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.BLACK);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'K';
                }else if(Objects.equals(ar[m], "k")){
                    chessComponents[n][m] = new KingChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.WHITE);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'k';
                }else if(Objects.equals(ar[m], "Q")){
                    chessComponents[n][m] = new QueenChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.BLACK);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'Q';
                }else if(Objects.equals(ar[m], "q")){
                    chessComponents[n][m] = new QueenChessComponent();
                    chessComponents[n][m].setChessColor(ChessColor.WHITE);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = 'q';
                }else if(Objects.equals(ar[m],"_")){
                    chessComponents[n][m] = new EmptySlotComponent();
                    chessComponents[n][m].setChessColor(ChessColor.NONE);
                    chessComponents[n][m].setSource(new ChessboardPoint(m,n));
                    chessComponents[n][m].name = '_';
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")){
            currentPlayer = ChessColor.WHITE;
        }else currentPlayer = ChessColor.BLACK;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String s8 = "";
        StringBuilder sb1 = new StringBuilder();
        for(int n=0; n<8; n++){
            if(chessComponents[0][n]==null){
                sb1.append("_");
            }else {
                sb1.append(chessComponents[0][n]);
            }
            if(n==7){
                s1 = sb1.toString();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for(int n=0; n<8; n++){
            if(chessComponents[1][n]==null){
                sb2.append("_");
            }else {
                sb2.append(chessComponents[1][n]);
            }
            if(n==7){
                s2 = sb2.toString();
            }
        }
        StringBuilder sb3 = new StringBuilder();
        for(int n=0; n<8; n++){
            if(chessComponents[2][n]==null){
                sb3.append("_");
            }else {
                sb3.append(chessComponents[2][n]);
            }
            if(n==7){
                s3 = sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder();
        for(int n=0; n<8; n++){
            if(chessComponents[3][n]==null){
                sb4.append("_");
            }else {
                sb4.append(chessComponents[3][n]);
            }
            if(n==7){
                s4 = sb4.toString();
            }
        }
        StringBuilder sb5 = new StringBuilder();
        for(int n=0; n<8; n++){
            if(chessComponents[4][n]==null){
                sb5.append("_");
            }else {
                sb5.append(chessComponents[4][n]);
            }
            if(n==7){
                s5 = sb5.toString();
            }
        }
        StringBuilder sb6 = new StringBuilder();
        for(int n=0; n<8; n++){
            if(chessComponents[5][n]==null){
                sb6.append("_");
            }else {
                sb6.append(chessComponents[5][n]);
            }
            if(n==7){
                s6 = sb6.toString();
            }
        }
        StringBuilder sb7 = new StringBuilder();
        for(int n=0; n<8; n++){
            if(chessComponents[6][n]==null){
                sb7.append("_");
            }else {
                sb7.append(chessComponents[6][n]);
            }
            if(n==7){
                s7 = sb7.toString();
            }
        }
        StringBuilder sb8 = new StringBuilder();
        for(int n=0; n<8; n++){
            if(chessComponents[7][n]==null){
                sb8.append("_");
            }else {
                sb8.append(chessComponents[7][n]);
            }
            if(n==7){
                s8 = sb8.toString();
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",s1,s2,s3,s4,s5,s6,s7,s8);
    }

    public String getCapturedChess(ChessColor player) {
        currentPlayer = player;
        int n1=0;
        int n2=0;
        int n3=0;
        int n4=0;
        int n5=0;
        int n6=0;
        if(player==ChessColor.BLACK){
            for(int p=0; p<8; p++){
                for(int q=0; q<8; q++){
                    if(chessComponents[p][q]instanceof RookChessComponent && chessComponents[p][q].getChessColor()==ChessColor.BLACK){
                        n1++;
                    }else if(chessComponents[p][q]instanceof KnightChessComponent && chessComponents[p][q].getChessColor()==ChessColor.BLACK){
                        n2++;
                    }else if(chessComponents[p][q]instanceof BishopChessComponent && chessComponents[p][q].getChessColor()==ChessColor.BLACK){
                        n3++;
                    }else if(chessComponents[p][q]instanceof KingChessComponent && chessComponents[p][q].getChessColor()==ChessColor.BLACK){
                        n4++;
                    }else if(chessComponents[p][q]instanceof QueenChessComponent && chessComponents[p][q].getChessColor()==ChessColor.BLACK){
                        n5++;
                    }else if(chessComponents[p][q]instanceof PawnChessComponent && chessComponents[p][q].getChessColor()==ChessColor.BLACK){
                        n6++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if(n4!=1){
                sb.append("K ");
                sb.append(1-n4);
                sb.append("\n");
            }
            if(n5!=1){
                sb.append("Q ");
                sb.append(1-n5);
                sb.append("\n");
            }
            if(n1!=2){
                sb.append("R ");
                sb.append(2-n1);
                sb.append("\n");
            }
            if(n3!=2){
                sb.append("B ");
                sb.append(2-n3);
                sb.append("\n");
            }
            if(n2!=2){
                sb.append("N ");
                sb.append(2-n2);
                sb.append("\n");
            }
            if(n6!=8){
                sb.append("P ");
                sb.append(8-n6);
                sb.append("\n");
            }
            return sb.toString();
        }else {
            for(int p=0; p<8; p++){
                for(int q=0; q<8; q++){
                    if(chessComponents[p][q]instanceof RookChessComponent && chessComponents[p][q].getChessColor()==ChessColor.WHITE){
                        n1++;
                    }else if(chessComponents[p][q]instanceof KnightChessComponent && chessComponents[p][q].getChessColor()==ChessColor.WHITE){
                        n2++;
                    }else if(chessComponents[p][q]instanceof BishopChessComponent && chessComponents[p][q].getChessColor()==ChessColor.WHITE){
                        n3++;
                    }else if(chessComponents[p][q]instanceof KingChessComponent && chessComponents[p][q].getChessColor()==ChessColor.WHITE){
                        n4++;
                    }else if(chessComponents[p][q]instanceof QueenChessComponent && chessComponents[p][q].getChessColor()==ChessColor.WHITE){
                        n5++;
                    }else if(chessComponents[p][q]instanceof PawnChessComponent && chessComponents[p][q].getChessColor()==ChessColor.WHITE){
                        n6++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if(n4!=1){
                sb.append("k ");
                sb.append(1-n4);
                sb.append("\n");
            }
            if(n5!=1){
                sb.append("q ");
                sb.append(1-n5);
                sb.append("\n");
            }
            if(n1!=2){
                sb.append("r ");
                sb.append(2-n1);
                sb.append("\n");
            }
            if(n3!=2){
                sb.append("b ");
                sb.append(2-n3);
                sb.append("\n");
            }
            if(n2!=2){
                sb.append("n ");
                sb.append(2-n2);
                sb.append("\n");
            }
            if(n6!=8){
                sb.append("p ");
                sb.append(8-n6);
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(),source.getY());
        if(chess instanceof EmptySlotComponent){
            return new ArrayList<>();
        }else {
            List<ChessboardPoint> canMovePoints = chess.canMoveTo();
            return canMovePoints;
        }
    }

    @Override
    public boolean moveChess (int sourceX, int sourceY, int targetX, int targetY)  {
        if(chessComponents[sourceX][sourceY] instanceof EmptySlotComponent){
            return false;
        }else {
            if(chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                chessComponents[sourceX][sourceY].name = '_';
                return true;
            }else return false;
        }
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public ChessComponent[][] getChess() {
        for (int m=0; m<8; m++){
            for(int n=0; n<8; n++){
                chess[m][n]=chessComponents[m][n];
            }
        }
        return chess;
    }

    public void setChess(ChessComponent[][] chess) {
        this.chess = chess;
    }
}
