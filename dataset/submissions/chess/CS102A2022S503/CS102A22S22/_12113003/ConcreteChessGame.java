import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
    }


    public void loadChessGame(List<String> chessboard) {
       for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
               toChess(i,j,chessboard.get(i).charAt(j));
           }
       }
       if(chessboard.get(8).charAt(0)=='w'){
           currentPlayer=ChessColor.WHITE;
       }
       if(chessboard.get(8).charAt(0)=='b'){
           currentPlayer=ChessColor.BLACK;
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

            int K_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "K")){
                        K_counter++;
                    }
                }
            }
            int K_number=1-K_counter;
            if(K_number!=0){
                finalString+="K "+K_number+"\n";
            }

            int Q_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "Q")){
                        Q_counter++;
                    }
                }
            }
            int Q_number=1-Q_counter;
            if(Q_number!=0){
                finalString+="Q "+Q_number+"\n";
            }

            int R_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "R")){
                        R_counter++;
                    }
                }
            }
            int R_number=2-R_counter;
            if(R_number!=0){
                finalString+="R "+R_number+"\n";
            }

            int B_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "B")){
                        B_counter++;
                    }
                }
            }
            int B_number=2-B_counter;
            if(B_number!=0){
                finalString+="B "+B_number+"\n";
            }

            int N_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "N")){
                        N_counter++;
                    }
                }
            }
            int N_number=2-N_counter;
            if(N_number!=0){
                finalString+="N "+N_number+"\n";
            }


            int P_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "P")){
                        P_counter++;
                    }
                }
            }
            int P_number=8-P_counter;
            if(P_number!=0){
                finalString+="P "+P_number+"\n";
            }
            return finalString;
        }

        else{
            String finalString="";

            int k_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "k")){
                        k_counter++;
                    }
                }
            }
            int k_number=1-k_counter;
            if(k_number!=0){
                finalString+="k "+k_number+"\n";
            }

            int q_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "q")){
                        q_counter++;
                    }
                }
            }
            int q_number=1-q_counter;
            if(q_number!=0){
                finalString+="q "+q_number+"\n";
            }

            int r_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "r")){
                        r_counter++;
                    }
                }
            }
            int r_number=2-r_counter;
            if(r_number!=0){
                finalString+="r "+r_number+"\n";
            }

            int b_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "b")){
                        b_counter++;
                    }
                }
            }
            int b_number=2-b_counter;
            if(b_number!=0){
                finalString+="b "+b_number+"\n";
            }

            int n_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "n")){
                        n_counter++;
                    }
                }
            }
            int n_number=2-n_counter;
            if(n_number!=0){
                finalString+="n "+n_number+"\n";
            }


            int p_counter=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(Objects.equals(chessComponents[i][j].toString(), "p")){
                        p_counter++;
                    }
                }
            }
            int p_number=8-p_counter;
            if(p_number!=0){
                finalString+="p "+p_number+"\n";
            }
            return finalString;
        }
    }

    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }


    public void toChess(int x,int y,char letter){
        switch (letter) {
            case 'R' -> {
                chessComponents[x][y] = new RookChessComponent(ChessColor.BLACK);
                chessComponents[x][y].setChessColor(ChessColor.BLACK);
            }
            case 'N' -> {
                chessComponents[x][y] = new KnightChessComponent(ChessColor.BLACK);
                chessComponents[x][y].setChessColor(ChessColor.BLACK);
            }
            case 'B' -> {
                chessComponents[x][y] = new BishopChessComponent(ChessColor.BLACK);
                chessComponents[x][y].setChessColor(ChessColor.BLACK);
            }
            case 'Q' -> {
                chessComponents[x][y] = new QueenChessComponent(ChessColor.BLACK);
                chessComponents[x][y].setChessColor(ChessColor.BLACK);
            }
            case 'K' -> {
                chessComponents[x][y] = new KingChessComponent(ChessColor.BLACK);
                chessComponents[x][y].setChessColor(ChessColor.BLACK);
            }
            case 'P' -> {
                chessComponents[x][y] = new PawnChessComponent(ChessColor.BLACK);
                chessComponents[x][y].setChessColor(ChessColor.BLACK);
            }
            case 'r' -> {
                chessComponents[x][y] = new RookChessComponent(ChessColor.WHITE);
                chessComponents[x][y].setChessColor(ChessColor.WHITE);
            }
            case 'n' -> {
                chessComponents[x][y] = new KnightChessComponent(ChessColor.WHITE);
                chessComponents[x][y].setChessColor(ChessColor.WHITE);
            }
            case 'b' -> {
                chessComponents[x][y] = new BishopChessComponent(ChessColor.WHITE);
                chessComponents[x][y].setChessColor(ChessColor.WHITE);
            }
            case 'q' -> {
                chessComponents[x][y] = new QueenChessComponent(ChessColor.WHITE);
                chessComponents[x][y].setChessColor(ChessColor.WHITE);
            }
            case 'k' -> {
                chessComponents[x][y] = new KingChessComponent(ChessColor.WHITE);
                chessComponents[x][y].setChessColor(ChessColor.WHITE);
            }
            case 'p' -> {
                chessComponents[x][y] = new PawnChessComponent(ChessColor.WHITE);
                chessComponents[x][y].setChessColor(ChessColor.WHITE);
            }
            case '_' -> {
                chessComponents[x][y] = new EmptySlotComponent();
                chessComponents[x][y].setChessColor(ChessColor.NONE);
            }
        }
        chessComponents[x][y].name = letter; chessComponents[x][y].setSource(new ChessboardPoint(x,y));
    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> canMovePoint=chessComponents[sourceX][sourceY].canMoveTo();
        System.out.println(canMovePoint);
        ChessboardPoint targetPoint=new ChessboardPoint(targetX,targetY);
        System.out.println(targetPoint);
        boolean flag=false;
        for (ChessboardPoint chessboardPoint : canMovePoint) {
            System.out.println(chessboardPoint);
            if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                flag = true;
                break;
            }
        }
        if(flag){
            if(chessComponents[sourceX][sourceY].getChessColor()==currentPlayer) {
                chessComponents[sourceX][sourceY].source = new ChessboardPoint(targetX, targetY);
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX, sourceY));
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        chessComponents[i][j].setChessComponents(chessComponents);
                    }
                }
                currentPlayer = reverseChessColor(currentPlayer);
                return true;
            }
            else{return false;}
        }
        else {
            return false;
        }
    }

    public ChessColor reverseChessColor(ChessColor chessColor) {
        if (chessColor == ChessColor.BLACK) {
            return ChessColor.WHITE;
        }
        if (chessColor == ChessColor.WHITE) {
            return ChessColor.BLACK;
        } else {
            return ChessColor.NONE;
        }
    }


}


