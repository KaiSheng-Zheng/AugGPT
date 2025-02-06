import java.util.List;
import java.util.Objects;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame() {}


    public void loadChessGame(List<String> chessboard) {
       for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
               toChess(i,j,chessboard.get(i).charAt(j));
           }
       }
       if(chessboard.get(8).charAt(0)=='w'){
           currentPlayer=ChessColor.WHITE;
       }
       else if (chessboard.get(8).charAt(0) == 'b') {
               currentPlayer = ChessColor.BLACK;
       }
       
       String StringChessboard="";
       
       for(int i=0;i<8;i++) {
           for (int j = 0; j < 8; j++) {
               StringChessboard+=chessboard.get(i).charAt(j);
           }
           StringChessboard+="\n";
       }
       for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
               chessComponents[i][j].setChessComponents(chessComponents);
           }
       }
    }


    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public String getChessboardGraph() {
        String StringChessboard="";
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                StringChessboard += chessComponents[i][j].name;
            }
            StringChessboard += "\n";
        }
        return StringChessboard;
    }


    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.BLACK) {
            String finalString="";
            int Kcounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "K")){
                        Kcounter++;
                    }
                }
            }
            int Knumber=1-Kcounter;
            if(Knumber!=0){
                finalString+="K "+Knumber+"\n";
            }

            int Qcounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "Q")){
                        Qcounter++;
                    }
                }
            }
            int Qnumber=1-Qcounter;
            if(Qnumber!=0){
                finalString+="Q "+Qnumber+"\n";
            }

            int Rcounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "R")){
                        Rcounter++;
                    }
                }
            }
            int Rnumber=2-Rcounter;
            if(Rnumber!=0){
                finalString+="R "+Rnumber+"\n";
            }

            int Bcounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "B")){
                        Bcounter++;
                    }
                }
            }
            int Bnumber=2-Bcounter;
            if(Bnumber!=0){
                finalString+="B "+Bnumber+"\n";
            }

            int Ncounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "N")){
                        Ncounter++;
                    }
                }
            }
            int Nnumber=2-Ncounter;
            if(Nnumber!=0){
                finalString+="N "+Nnumber+"\n";
            }


            int Pcounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "P")){
                        Pcounter++;
                    }
                }
            }
            int Pnumber=8-Pcounter;
            if(Pnumber!=0){
                finalString+="P "+Pnumber+"\n";
            }
            return finalString;
        }

        else{
            String finalString="";

            int kcounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "k")){
                        kcounter++;
                    }
                }
            }
            int knumber=1-kcounter;
            if(knumber!=0){
                finalString+="k "+knumber+"\n";
            }

            int qcounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "q")){
                        qcounter++;
                    }
                }
            }
            int qnumber=1-qcounter;
            if(qnumber!=0){
                finalString+="q "+qnumber+"\n";
            }

            int rcounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "r")){
                        rcounter++;
                    }
                }
            }
            int rnumber=2-rcounter;
            if(rnumber!=0){
                finalString+="r "+rnumber+"\n";
            }

            int bcounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "b")){
                        bcounter++;
                    }
                }
            }
            int bnumber=2-bcounter;
            if(bnumber!=0){
                finalString+="b "+bnumber+"\n";
            }

            int ncounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "n")){
                        ncounter++;
                    }
                }
            }
            int nnumber=2-ncounter;
            if(nnumber!=0){
                finalString+="n "+nnumber+"\n";
            }


            int pcounter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "p")){
                        pcounter++;
                    }
                }
            }
            int pnumber=8-pcounter;
            if(pnumber!=0){
                finalString+="p "+pnumber+"\n";
            }
            return finalString;
        }
    }

    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }
    public void toChess(int a,int b,char l){
        switch (l) {
            case 'R' -> {
                chessComponents[a][b] = new RookChessComponent(ChessColor.BLACK);
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
            }
            case 'N' -> {
                chessComponents[a][b] = new KnightChessComponent(ChessColor.BLACK);
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
            }
            case 'B' -> {
                chessComponents[a][b] = new BishopChessComponent(ChessColor.BLACK);
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
            }
            case 'Q' -> {
                chessComponents[a][b] = new QueenChessComponent(ChessColor.BLACK);
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
            }
            case 'K' -> {
                chessComponents[a][b] = new KingChessComponent(ChessColor.BLACK);
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
            }
            case 'P' -> {
                chessComponents[a][b] = new PawnChessComponent(ChessColor.BLACK);
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
            }
            case 'r' -> {
                chessComponents[a][b] = new RookChessComponent(ChessColor.WHITE);
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
            }
            case 'n' -> {
                chessComponents[a][b] = new KnightChessComponent(ChessColor.WHITE);
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
            }
            case 'b' -> {
                chessComponents[a][b] = new BishopChessComponent(ChessColor.WHITE);
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
            }
            case 'q' -> {
                chessComponents[a][b] = new QueenChessComponent(ChessColor.WHITE);
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
            }
            case 'k' -> {
                chessComponents[a][b] = new KingChessComponent(ChessColor.WHITE);
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
            }
            case 'p' -> {
                chessComponents[a][b] = new PawnChessComponent(ChessColor.WHITE);
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
            }
            case '_' -> {
                chessComponents[a][b] = new EmptySlotComponent();
                chessComponents[a][b].setChessColor(ChessColor.NONE);
            }
        }
        chessComponents[a][b].name = l; chessComponents[a][b].setSource(new ChessboardPoint(a,b));
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }
    public boolean moveChess(int X1, int Y1, int X2, int Y2) {
        List<ChessboardPoint> canMovePoints=chessComponents[X1][Y1].canMoveTo();
        System.out.println(canMovePoints);
        ChessboardPoint targetPoint=new ChessboardPoint(X2,Y2);
        System.out.println(targetPoint);
        boolean w=false;
        for (ChessboardPoint chessboardPoint : canMovePoints) {
            System.out.println(chessboardPoint);
            if (chessboardPoint.getX() == X2 && chessboardPoint.getY() == Y2) {
                w = true;
                break;
            }
        }
        if(w){
            if(chessComponents[X1][Y1].getChessColor()==currentPlayer) {
                chessComponents[X1][Y1].source = new ChessboardPoint(X2, Y2);
                chessComponents[X2][Y2] = chessComponents[X1][Y1];
                chessComponents[X1][Y1] = new EmptySlotComponent();
                chessComponents[X1][Y1].setSource(new ChessboardPoint(X1, Y1));
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        chessComponents[i][j].setChessComponents(chessComponents);
                    }
                }
                currentPlayer = reverseChessColor(currentPlayer);
                return true;
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }
    public ChessColor reverseChessColor(ChessColor chessColor) {
        if (chessColor == ChessColor.BLACK) {
            return ChessColor.WHITE;
        } else {
            if (chessColor == ChessColor.WHITE) {
                return ChessColor.BLACK;
            } else {
                return ChessColor.NONE;
            }
        }
    }
}