import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private List<String> nowChessboard=new ArrayList<>();
    private List<ChessboardPoint> CanMovePoints;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
        nowChessboard=chessboard;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (String.valueOf(chessboard.get(i).charAt(j)).equals("K")||String.valueOf(chessboard.get(i).charAt(j)).equals("k")){
                chessComponents[i][j]=new KingChessComponent();
                chessComponents[i][j].setNowqipan(chessComponents);
                }
                if (String.valueOf(chessboard.get(i).charAt(j)).equals("Q")||String.valueOf(chessboard.get(i).charAt(j)).equals("q")){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setNowqipan(chessComponents);
                }
                if (String.valueOf(chessboard.get(i).charAt(j)).equals("R")||String.valueOf(chessboard.get(i).charAt(j)).equals("r")){
                    chessComponents[i][j]=new RookChessComponent();
                    chessComponents[i][j].setNowqipan(chessComponents);
                }
                if (String.valueOf(chessboard.get(i).charAt(j)).equals("N")||String.valueOf(chessboard.get(i).charAt(j)).equals("n")){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setNowqipan(chessComponents);
                }
                if (String.valueOf(chessboard.get(i).charAt(
                        j)).equals("B")||String.valueOf(chessboard.get(i).charAt(j)).equals("b")){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setNowqipan(chessComponents);
                }
                if (String.valueOf(chessboard.get(i).charAt(j)).equals("P")||String.valueOf(chessboard.get(i).charAt(j)).equals("p")){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setNowqipan(chessComponents);
                }
                if (String.valueOf(chessboard.get(i).charAt(j)).equals("_")){
                    chessComponents[i][j]=new EmptySlotComponent();
                    chessComponents[i][j].setNowqipan(chessComponents);
                }
                chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                if (Character.isUpperCase(chessboard.get(i).charAt(j))){
                chessComponents[i][j].setChessColor(ChessColor.BLACK);}
                else if (Character.isLowerCase(chessboard.get(i).charAt(j))){
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }else {chessComponents[i][j].setChessColor(ChessColor.NONE);}
                ChessboardPoint kk=new ChessboardPoint(i,j);
                chessComponents[i][j].setSource(kk);
            }
        }
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        if (nowChessboard.get(8).equals("w")){
            return ChessColor.WHITE;
        }
        else if (nowChessboard.get(8).equals("b")){
            return ChessColor.BLACK;
        }
        else {return ChessColor.NONE;}
    }

    public String getChessboardGraph(){
        String output=String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",nowChessboard.get(0),nowChessboard.get(1),nowChessboard.get(2),nowChessboard.get(3),nowChessboard.get(4),nowChessboard.get(5),nowChessboard.get(6),nowChessboard.get(7));
        return output;
    }
    int QueenNum=1;
    int KingNum=1;
    int RookNum=2;
    int BishopNum=2;
    int KnightNum=2;
    int PawnNum=8;
    public String getCapturedChess(ChessColor player){
        if (player==ChessColor.BLACK){
             QueenNum=1;
             KingNum=1;
             RookNum=2;
             BishopNum=2;
             KnightNum=2;
             PawnNum=8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        QueenNum--;
                    }
                    if (chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        KingNum--;
                    }
                    if (chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                         KnightNum--;
                    }
                    if (chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                         RookNum--;
                    }
                    if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                         BishopNum--;
                    }
                    if (chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK) {
                         PawnNum--;
                    }
                }
            }
            String capture="";
            if (KnightNum!=0){
                capture=capture+"K "+String.valueOf(KingNum)+"\n";
            }
            if (QueenNum!=0){
                capture=capture+"Q "+String.valueOf(QueenNum)+"\n";
            }
            if (RookNum!=0){
                capture=capture+"R "+String.valueOf(RookNum)+"\n";
            }
            if (BishopNum!=0){
                capture=capture+"B "+String.valueOf(BishopNum)+"\n";
            }
            if (KnightNum!=0){
                capture=capture+"N "+String.valueOf(KnightNum)+"\n";
            }
            if (PawnNum!=0){
                capture=capture+"P "+String.valueOf(PawnNum)+"\n";
            }
            return capture;
        }

        if (player==ChessColor.WHITE){
             QueenNum=1;
             KingNum=1;
             RookNum=2;
             BishopNum=2;
             KnightNum=2;
             PawnNum=8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){//Q
                        QueenNum--;
                    }
                    if (chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        KingNum--;
                    }
                    if (chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        KnightNum--;
                    }
                    if (chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        RookNum--;
                    }
                    if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        BishopNum--;
                    }
                    if (chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE) {
                        PawnNum--;
                    }
                }
            }
            String capture="";
            if (KingNum!=0){
                capture=capture+"k "+String.valueOf(KingNum)+"\n";
            }
            if (QueenNum!=0){
                capture=capture+"q "+String.valueOf(QueenNum)+"\n";
            }
            if (RookNum!=0){
                capture=capture+"r "+String.valueOf(RookNum)+"\n";
            }
            if (BishopNum!=0){
                capture=capture+"b "+String.valueOf(BishopNum)+"\n";
            }
            if (KnightNum!=0){
                capture=capture+"n "+String.valueOf(KnightNum)+"\n";
            }
            if (PawnNum!=0){
                capture=capture+"p "+String.valueOf(PawnNum)+"\n";
            }
            return capture;
        }
        return null;
    }

    public ChessComponent getChess(int x, int y){
       return chessComponents[x][y];
    }

    public void setCanMovePoints(List<ChessboardPoint> canMovePoints) {
        CanMovePoints = canMovePoints;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint d) {
        setCanMovePoints(chessComponents[d.getX()][d.getY()].canMoveTo());
        for (int i = 0; i < CanMovePoints.size()-1; i++) {
            for (int j = 0; j < CanMovePoints.size()-i-1; j++) {
                if (CanMovePoints.get(j).getX()>CanMovePoints.get(j+1).getX()){
                    ChessboardPoint o;
                    o=CanMovePoints.get(j);
                    CanMovePoints.set(j,CanMovePoints.get(j+1));
                    CanMovePoints.set(j+1,o);
                }
                if (CanMovePoints.get(j).getX()==CanMovePoints.get(j+1).getX()&&CanMovePoints.get(j).getY()>CanMovePoints.get(j+1).getY()){
                    ChessboardPoint o;
                    o=CanMovePoints.get(j);
                    CanMovePoints.set(j,CanMovePoints.get(j+1));
                    CanMovePoints.set(j+1,o);
                }
            }
        }
        return CanMovePoints;
    }

    public boolean moveChess(int a, int b, int c, int d){
        ChessboardPoint mubiao=new ChessboardPoint(c,d);
        ChessboardPoint yidong=new ChessboardPoint(a,b);
        boolean ke=false;
        if (chessComponents[a][b].getChessColor()!=currentPlayer){return false;}
        for (int i = 0; i < chessComponents[a][b].canMoveTo().size(); i++) {
            if (chessComponents[a][b].canMoveTo().get(i).getX()==c&&chessComponents[a][b].canMoveTo().get(i).getY()==d){
                ke=true;
            }
        }
        if (a>7||a<1||b>7||b<1||chessComponents[a][b].getChessColor()==ChessColor.NONE|| !ke){
            return false;
        }
        if (chessComponents[c][d].getChessColor()==ChessColor.NONE){
        ChessComponent chucun;
        chucun=chessComponents[a][b];
        chessComponents[a][b]=chessComponents[c][d];
        ChessboardPoint q=new ChessboardPoint(c,d);
        chessComponents[a][b].setSource(q);
        ChessboardPoint w=new ChessboardPoint(a,b);
        chessComponents[c][d]=chucun;
        chessComponents[c][d].setSource(w);}
        if (this.currentPlayer==ChessColor.WHITE){
            setCurrentPlayer(ChessColor.BLACK);
        }
        if (this.currentPlayer==ChessColor.BLACK){
            setCurrentPlayer(ChessColor.WHITE);
        }
        return true;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
