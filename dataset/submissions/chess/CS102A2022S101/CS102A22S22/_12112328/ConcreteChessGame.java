import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.

     static public ChessComponent[][] board= new ChessComponent[9][9];
    private ChessComponent[][] chessComponents= new ChessComponent[9][9];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer=ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard) {

           for (int i=0;i<=7;i++){
               for (int j=0;j<=7;j++){
                   if (chessComponents[i][j]==null){
                       chessComponents[i][j]=new test();
                   }
                   if (board[i][j]==null){
                       board[i][j]=new test();
                   }
                  // System.out.println(chessboard.get(i).charAt(j));
           chessComponents[i][j].name=chessboard.get(i).charAt(j);
                   board[i][j].name=chessboard.get(i).charAt(j);



               }
           }
           if (chessboard.get(8).equals("b")){
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
        StringBuilder b=new StringBuilder();
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
            b.append(chessComponents[i][j].name);}
            b.append("\n");
        }
        return String.format(b.toString());
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K = 0;
        int Q=0;
        int R=0;
        int B=0;
        int N=0;
        int P=0;
        StringBuilder b=new StringBuilder();
        if (player==ChessColor.BLACK){
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                if (chessComponents[i][j].name=='K') K++;
                if (chessComponents[i][j].name=='Q') Q++;
                if (chessComponents[i][j].name=='R') R++;
                if (chessComponents[i][j].name=='B') B++;
                if (chessComponents[i][j].name=='N') N++;
                if (chessComponents[i][j].name=='P') P++;
            }
        }
        if (1-K>0){
            b.append("K ");
            b.append(1-K);
            b.append("\n");
        }
            if (1-Q>0){
                b.append("Q ");
                b.append(1-Q);
                b.append("\n");
            }
            if (2-R>0){
                b.append("R ");
                b.append(2-R);
                b.append("\n");
            }
            if (2-B>0){
                b.append("B ");
                b.append(2-B);
                b.append("\n");
            }
            if (2-N>0){
                b.append("N ");
                b.append(2-N);
                b.append("\n");
            }
            if (8-P>0){
                b.append("P ");
                b.append(8-P);
                b.append("\n");
            }
            return b.toString();
        }
        else{
            for (int i=0;i<=7;i++){
                for (int j=0;j<=7;j++){
                    if (chessComponents[i][j].name=='k') K++;
                    if (chessComponents[i][j].name=='q') Q++;
                    if (chessComponents[i][j].name=='r') R++;
                    if (chessComponents[i][j].name=='b') B++;
                    if (chessComponents[i][j].name=='n') N++;
                    if (chessComponents[i][j].name=='p') P++;
                }
            }
            if (1-K>0){
                b.append("k ");
                b.append(1-K);
                b.append("\n");
            }
            if (1-Q>0){
                b.append("q ");
                b.append(1-Q);
                b.append("\n");
            }
            if (2-R>0){
                b.append("r ");
                b.append(2-R);
                b.append("\n");
            }
            if (2-B>0){
                b.append("b ");
                b.append(2-B);
                b.append("\n");
            }
            if (2-N>0){
                b.append("n ");
                b.append(2-N);
                b.append("\n");
            }
            if (8-P>0){
                b.append("p ");
                b.append(8-P);
                b.append("\n");
            }
            return b.toString();
        }

       // return null;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        int sourceX=source.getX();
        int sourceY=source.getY();

        if (chessComponents[sourceX][sourceY].name=='_'){
            ChessComponent chess=new EmptySlotComponent();
            List<ChessboardPoint> canMovePoints = chess.canMoveTo();
            // 3.sort canMovePoints by x - y ascending order
            canMovePoints.sort ( new Comparator<ChessboardPoint>(){
                @Override
                public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                    if (o1.getX()==o2.getX()) {
                        return o1.getY()- o2.getY();
                    }
                    return o1.getX()-o2.getX();
                }

            });
            return canMovePoints;
        }
        else {
            if (chessComponents[sourceX][sourceY].name=='K'||chessComponents[sourceX][sourceY].name=='k'){
                ChessComponent chess=new KingChessComponent(sourceX,sourceY);
                //System.out.println(sourceX);
                //System.out.println(b.toString());

                List<ChessboardPoint> canMovePoints = chess.canMoveTo();
                // 3.sort canMovePoints by x - y ascending order
                canMovePoints.sort ( new Comparator<ChessboardPoint>(){
                    @Override
                    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                        if (o1.getX()==o2.getX()) {
                            return o1.getY()- o2.getY();
                        }
                        return o1.getX()-o2.getX();
                    }

                });
                return canMovePoints;
            }
            if (chessComponents[sourceX][sourceY].name=='Q'||chessComponents[sourceX][sourceY].name=='q'){
                ChessComponent chess=new QueenChessComponent(sourceX,sourceY,chessComponents[sourceX][sourceY].name);
                List<ChessboardPoint> canMovePoints = chess.canMoveTo();
                // 3.sort canMovePoints by x - y ascending order
                canMovePoints.sort ( new Comparator<ChessboardPoint>(){
                    @Override
                    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                        if (o1.getX()==o2.getX()) {
                            return o1.getY()- o2.getY();
                        }
                        return o1.getX()-o2.getX();
                    }

                });
                return canMovePoints;
            }


            if (chessComponents[sourceX][sourceY].name=='R'||chessComponents[sourceX][sourceY].name=='r'){
                ChessComponent chess=new RookChessComponent(sourceX,sourceY,chessComponents[sourceX][sourceY].name);
                List<ChessboardPoint> canMovePoints = chess.canMoveTo();
                // 3.sort canMovePoints by x - y ascending order
                canMovePoints.sort ( new Comparator<ChessboardPoint>(){
                    @Override
                    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                        if (o1.getX()==o2.getX()) {
                            return o1.getY()- o2.getY();
                        }
                        return o1.getX()-o2.getX();
                    }

                });
                return canMovePoints;
            }

            if (chessComponents[sourceX][sourceY].name=='B'||chessComponents[sourceX][sourceY].name=='b'){
                ChessComponent chess=new BishopChessComponent(sourceX,sourceY,chessComponents[sourceX][sourceY].name);
                List<ChessboardPoint> canMovePoints = chess.canMoveTo();
                // 3.sort canMovePoints by x - y ascending order
                canMovePoints.sort ( new Comparator<ChessboardPoint>(){
                    @Override
                    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                        if (o1.getX()==o2.getX()) {
                            return o1.getY()- o2.getY();
                        }
                        return o1.getX()-o2.getX();
                    }

                });
                return canMovePoints;
            }

            if (chessComponents[sourceX][sourceY].name=='N'||chessComponents[sourceX][sourceY].name=='n'){
                ChessComponent chess=new KnightChessComponent(sourceX,sourceY,chessComponents[sourceX][sourceY].name);
                List<ChessboardPoint> canMovePoints = chess.canMoveTo();
                // 3.sort canMovePoints by x - y ascending order
                canMovePoints.sort ( new Comparator<ChessboardPoint>(){
                    @Override
                    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                        if (o1.getX()==o2.getX()) {
                            return o1.getY()- o2.getY();
                        }
                        return o1.getX()-o2.getX();
                    }

                });
                return canMovePoints;
            }

            if (chessComponents[sourceX][sourceY].name=='P'||chessComponents[sourceX][sourceY].name=='p'){
                ChessComponent chess=new PawnChessComponent(sourceX,sourceY,chessComponents[sourceX][sourceY].name);
                // System.out.println("1");
                List<ChessboardPoint> canMovePoints = chess.canMoveTo();
                // 3.sort canMovePoints by x - y ascending order
                canMovePoints.sort ( new Comparator<ChessboardPoint>(){
                    @Override
                    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                        if (o1.getX()==o2.getX()) {
                            return o1.getY()- o2.getY();
                        }
                        return o1.getX()-o2.getX();
                    }

                });
                return canMovePoints;
            }
            ChessComponent chess=new EmptySlotComponent();
            List<ChessboardPoint> canMovePoints = chess.canMoveTo();
            // 3.sort canMovePoints by x - y ascending order
            return canMovePoints;

        }

    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        StringBuilder b=new StringBuilder();
        b.append("(" + targetX +
                "," + targetY +
                ")");
        if (sourceX<0||sourceX>7||sourceY<0||sourceY>7||targetX<0||targetX>7||targetY<0||targetY>7||chessComponents[sourceX][sourceY].name=='_'||('A'<=chessComponents[sourceX][sourceY].name&&chessComponents[sourceX][sourceY].name<='Z'&&currentPlayer!=ChessColor.BLACK)||('a'<=chessComponents[sourceX][sourceY].name&&chessComponents[sourceX][sourceY].name<='z'&&currentPlayer!=ChessColor.WHITE)){
            ChessComponent chess=new EmptySlotComponent();
            List<ChessboardPoint> ans=chess.canMoveTo();
            return false;
        }
        else {
            if (chessComponents[sourceX][sourceY].name=='K'||chessComponents[sourceX][sourceY].name=='k'){
                ChessComponent chess=new KingChessComponent(sourceX,sourceY);
                //System.out.println(sourceX);
               //System.out.println(b.toString());
                List<ChessboardPoint> ans=chess.canMoveTo();
                 for (int i=0;i<=ans.size()-1;i++){
                    //System.out.println(ans.get(i).toString());
                     // b.toString().equals(ans.get(i).toString())
                     if (ans.get(i).getX()==targetX&&ans.get(i).getY()==targetY){
                         chessComponents[targetX][targetY].name=chessComponents[sourceX][sourceY].name;
                         chessComponents[sourceX][sourceY].name='_';
                         board[targetX][targetY].name=chessComponents[targetX][targetY].name;
                         board[sourceX][sourceY].name=chessComponents[sourceX][sourceY].name;
                         if (currentPlayer==ChessColor.BLACK){
                             currentPlayer=ChessColor.WHITE;
                         }
                         else currentPlayer=ChessColor.BLACK;
                         return true;
                     }
                 }
                 return false;
            }
            if (chessComponents[sourceX][sourceY].name=='Q'||chessComponents[sourceX][sourceY].name=='q'){
                ChessComponent chess=new QueenChessComponent(sourceX,sourceY,chessComponents[sourceX][sourceY].name);
                List<ChessboardPoint> ans=chess.canMoveTo();
                for (int i=0;i<=ans.size()-1;i++){
                    // System.out.println(ans.get(i).toString());
                    if (b.toString().equals(ans.get(i).toString())){
                        chessComponents[targetX][targetY].name=chessComponents[sourceX][sourceY].name;
                        chessComponents[sourceX][sourceY].name='_';
                        board[targetX][targetY].name=chessComponents[targetX][targetY].name;
                        board[sourceX][sourceY].name=chessComponents[sourceX][sourceY].name;
                        if (currentPlayer==ChessColor.BLACK){
                            currentPlayer=ChessColor.WHITE;
                        }
                        else currentPlayer=ChessColor.BLACK;
                        return true;
                    }
                }
                return false;
            }


            if (chessComponents[sourceX][sourceY].name=='R'||chessComponents[sourceX][sourceY].name=='r'){
                ChessComponent chess=new RookChessComponent(sourceX,sourceY,chessComponents[sourceX][sourceY].name);
                List<ChessboardPoint> ans=chess.canMoveTo();
                for (int i=0;i<=ans.size()-1;i++){
                    // System.out.println(ans.get(i).toString());
                    if (b.toString().equals(ans.get(i).toString())){
                        chessComponents[targetX][targetY].name=chessComponents[sourceX][sourceY].name;
                        chessComponents[sourceX][sourceY].name='_';
                        board[targetX][targetY].name=chessComponents[targetX][targetY].name;
                        board[sourceX][sourceY].name=chessComponents[sourceX][sourceY].name;
                        if (currentPlayer==ChessColor.BLACK){
                            currentPlayer=ChessColor.WHITE;
                        }
                        else currentPlayer=ChessColor.BLACK;
                        return true;
                    }
                }
                return false;
            }

            if (chessComponents[sourceX][sourceY].name=='B'||chessComponents[sourceX][sourceY].name=='b'){
                ChessComponent chess=new BishopChessComponent(sourceX,sourceY,chessComponents[sourceX][sourceY].name);
                List<ChessboardPoint> ans=chess.canMoveTo();
                for (int i=0;i<=ans.size()-1;i++){
                    // System.out.println(ans.get(i).toString());
                    if (b.toString().equals(ans.get(i).toString())){
                        chessComponents[targetX][targetY].name=chessComponents[sourceX][sourceY].name;
                        chessComponents[sourceX][sourceY].name='_';
                        board[targetX][targetY].name=chessComponents[targetX][targetY].name;
                        board[sourceX][sourceY].name=chessComponents[sourceX][sourceY].name;
                        if (currentPlayer==ChessColor.BLACK){
                            currentPlayer=ChessColor.WHITE;
                        }
                        else currentPlayer=ChessColor.BLACK;
                        return true;
                    }
                }
                return false;
            }

            if (chessComponents[sourceX][sourceY].name=='N'||chessComponents[sourceX][sourceY].name=='n'){
                ChessComponent chess=new KnightChessComponent(sourceX,sourceY,chessComponents[sourceX][sourceY].name);
                List<ChessboardPoint> ans=chess.canMoveTo();
                for (int i=0;i<=ans.size()-1;i++){
                    // System.out.println(ans.get(i).toString());
                    if (b.toString().equals(ans.get(i).toString())){
                        chessComponents[targetX][targetY].name=chessComponents[sourceX][sourceY].name;
                        chessComponents[sourceX][sourceY].name='_';
                        board[targetX][targetY].name=chessComponents[targetX][targetY].name;
                        board[sourceX][sourceY].name=chessComponents[sourceX][sourceY].name;
                        if (currentPlayer==ChessColor.BLACK){
                            currentPlayer=ChessColor.WHITE;
                        }
                        else currentPlayer=ChessColor.BLACK;
                        return true;
                    }
                }
                return false;
            }

            if (chessComponents[sourceX][sourceY].name=='P'||chessComponents[sourceX][sourceY].name=='p'){
                ChessComponent chess=new PawnChessComponent(sourceX,sourceY,chessComponents[sourceX][sourceY].name);
               // System.out.println("1");
                List<ChessboardPoint> ans=chess.canMoveTo();
                for (int i=0;i<=ans.size()-1;i++){
                   //  System.out.println(ans.get(i).toString());
                    if (b.toString().equals(ans.get(i).toString())){
                        chessComponents[targetX][targetY].name=chessComponents[sourceX][sourceY].name;
                        chessComponents[sourceX][sourceY].name='_';
                        board[targetX][targetY].name=chessComponents[targetX][targetY].name;
                        board[sourceX][sourceY].name=chessComponents[sourceX][sourceY].name;
                        if (currentPlayer==ChessColor.BLACK){
                            currentPlayer=ChessColor.WHITE;
                        }
                        else currentPlayer=ChessColor.BLACK;
                        return true;
                    }
                }
                return false;
            }



        }



        return true;




    }
}


