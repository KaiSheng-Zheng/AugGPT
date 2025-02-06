import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private  ChessComponent[][]chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    public static ChessComponent[][]CopyOne=new ChessComponent[8][8];
    protected static ArrayList<ChessComponent> BlackChess=new ArrayList<>();
    protected static ArrayList<ChessComponent> WhiteChess=new ArrayList<>();


    public void loadChessGame(List<String> chessboard) {
        for (int x = 0; x< 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (chessboard.get(x).charAt(y) == 'B') {
                    chessComponents[x][y] = new BishopChessComponent(ChessColor.BLACK);
                    CopyOne[x][y] = new BishopChessComponent(ChessColor.BLACK);
                    BlackChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                } else if (chessboard.get(x).charAt(y) == 'b') {
                    chessComponents[x][y] = new BishopChessComponent(ChessColor.WHITE);
                    CopyOne[x][y] = new BishopChessComponent(ChessColor.WHITE);
                    WhiteChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                }else if(chessboard.get(x).charAt(y)=='N'){
                    chessComponents[x][y]=new KnightChessComponent(ChessColor.BLACK);
                    CopyOne[x][y]=new KnightChessComponent(ChessColor.BLACK);
                    BlackChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                }else if(chessboard.get(x).charAt(y)=='n'){
                    chessComponents[x][y]=new KnightChessComponent(ChessColor.WHITE);
                    CopyOne[x][y]=new KnightChessComponent(ChessColor.WHITE);
                    WhiteChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                } else if (chessboard.get(x).charAt(y) == 'Q') {
                    chessComponents[x][y] = new QueenChessComponent(ChessColor.BLACK);
                    CopyOne[x][y] = new QueenChessComponent(ChessColor.BLACK);
                    BlackChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                } else if (chessboard.get(x).charAt(y) =='q') {
                    chessComponents[x][y] = new QueenChessComponent(ChessColor.WHITE);
                    CopyOne[x][y] = new QueenChessComponent(ChessColor.WHITE);
                    WhiteChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
//                    System.out.println(chessComponents[x][y].name);
                } else if (chessboard.get(x).charAt(y) == 'K') {
                    chessComponents[x][y] = new KingChessComponent(ChessColor.BLACK);
                    CopyOne[x][y] = new KingChessComponent(ChessColor.BLACK);
                    BlackChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                } else if (chessboard.get(x).charAt(y) =='k') {
                    chessComponents[x][y] = new KingChessComponent(ChessColor.WHITE);
                    CopyOne[x][y] = new KingChessComponent(ChessColor.WHITE);
                    WhiteChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                } else if (chessboard.get(x).charAt(y) == 'P') {
                    chessComponents[x][y] = new PawnChessComponent(ChessColor.BLACK);
                    CopyOne[x][y] = new PawnChessComponent(ChessColor.BLACK);
                    BlackChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                } else if (chessboard.get(x).charAt(y) == 'p') {
                    chessComponents[x][y] = new PawnChessComponent(ChessColor.WHITE);
                    CopyOne[x][y] = new PawnChessComponent(ChessColor.WHITE);
                    WhiteChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                } else if(chessboard.get(x).charAt(y)=='r'){
                    chessComponents[x][y]=new RookChessComponent(ChessColor.WHITE);
                    CopyOne[x][y]=new RookChessComponent(ChessColor.WHITE);
                    WhiteChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                } else if (chessboard.get(x).charAt(y) =='R') {
                    chessComponents[x][y] = new RookChessComponent(ChessColor.BLACK);
                    CopyOne[x][y] = new RookChessComponent(ChessColor.BLACK);
                    BlackChess.add(chessComponents[x][y]);
                    chessComponents[x][y].setSource(x,y);
                } else if (chessboard.get(x).charAt(y) == '_') {
                    chessComponents[x][y] = new EmptySlotComponent();
                    CopyOne[x][y] = new EmptySlotComponent();
                    chessComponents[x][y].setSource(x,y);
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
         currentPlayer=ChessColor.WHITE;
        }else if(chessboard.get(8).charAt(0)=='b'){
           currentPlayer=ChessColor.BLACK;
        }
    }



     public ChessColor getCurrentPlayer() {
return this.currentPlayer;
}




    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder theChessGraph= new StringBuilder();
       for(int x=0;x<8;x++){
           for(int y=0;y<8;y++ ){
            theChessGraph.append(chessComponents[x][y]);
           }
           theChessGraph.append("\n");
       }
       return theChessGraph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int allR=2;
        int Rjs=0;
        int allN=2;
        int Njs=0;
        int allB=2;
        int Bjs=0;
        int allQ=1;
        int Qjs=0;
        int allK=1;
        int Kjs=0;
        int allP=8;
        int Pjs=0;
        //-----------------------------------------------------------
        int allr=2;
        int rjs=0;
        int alln=2;
        int njs=0;
        int allb=2;
        int bjs=0;
        int allq=1;
        int qjs=0;
        int allk=1;
        int kjs=0;
        int allp=8;
        int pjs=0;
        //---------------------------------------------------------------
        if(player==ChessColor.BLACK){
            for(int x=0;x<8;x++){
           //     System.out.println();
                for(int y=0;y<8;y++){
//                    System.out.print(chessComponents[y][x]);???right???
             //       System.out.print(chessComponents[y][x].name);  ???null???
                    if(chessComponents[x][y].toString().equals("R")){
                        Rjs++;
                    }else if(chessComponents[x][y].toString().equals("N")){
                        Njs++;
                    }else if(chessComponents[x][y].toString().equals("B")){
                        Bjs++;
                    }else if(chessComponents[x][y].toString().equals("Q")){
                        Qjs++;
                    }else if(chessComponents[x][y].toString().equals("K")){
                        Kjs++;
                    }else if(chessComponents[x][y].toString().equals("P")){
                        Pjs++;
                    }
                }
            }
        }else if(player==(ChessColor.WHITE)){
            for(int x=0;x<8;x++){
                for(int y=0;y<8;y++){
                    if(chessComponents[x][y].toString().equals("r")){
                        rjs++;
                    }else if(chessComponents[x][y].toString().equals("n")){
                        njs++;
                    }else if(chessComponents[x][y].toString().equals("b")){
                        bjs++;
                    }else if(chessComponents[x][y].toString().equals("q")){
                        qjs++;
                    }else if(chessComponents[x][y].toString().equals("k")){
                        kjs++;
                    }else if(chessComponents[x][y].toString().equals("p")){
                        pjs++;
                    }
                }
            }
        }
        String answer="";
        if(player.equals(ChessColor.BLACK)){
            if(allK-Kjs!=0){
                 answer=  "K "+ String.valueOf(allK-Kjs);
            }
            if(allQ-Qjs!=0){
                answer=answer+"\n"+"Q "+String.valueOf(allQ-Qjs);
            }
            if(allR-Rjs!=0){
                answer=answer+"\n"+"R "+String.valueOf(allR-Rjs);
            }
            if(allB-Bjs!=0){
                answer=answer+"\n"+"B "+String.valueOf(allB-Bjs);
            }
            if(allN-Njs!=0){
                answer=answer+"\n"+"N "+String.valueOf(allN-Njs);
            }
            if(allP-Pjs!=0){
                answer=answer+"\n"+"P "+String.valueOf(allP-Pjs);
            }
        }else if(player.equals(ChessColor.WHITE)){
            if(allk-kjs!=0){
                answer="k "+String.valueOf(allk-kjs);
            }
            if(allq-qjs!=0){
                answer=answer+"\n"+"q "+String.valueOf(allq-qjs);
            }
            if(allr-rjs!=0){
                answer=answer+"\n"+"r "+String.valueOf(allr-rjs);
            }
            if(allb-bjs!=0){
                answer=answer+"\n"+"b "+String.valueOf(allb-bjs);
            }
            if(alln-njs!=0){
                answer=answer+"\n"+"n "+String.valueOf(alln-njs);
            }
            if(allp-pjs!=0){
                answer=answer+"\n"+"p "+String.valueOf(allp-pjs);
            }
        }
return answer;
    }
// Comparator<ChessboardPoint> chessboardPointComparator=new Comparator<ChessboardPoint>() {
//     @Override
//     public int compare(ChessboardPoint o1, ChessboardPoint o2) {
//       if(o1.getX()>o2.getX()){
//           return
//       }
//
//     }
// }



   public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
       int x=source.getX();
       int y=source.getY();
//       String log = getChessboardGraph();
//       System.out.println(chessComponents[x][y]);
       List<ChessboardPoint>WeiPaiXu= chessComponents[x][y].canMoveTo();

       for(int j=0;j<WeiPaiXu.size()-1;j++) {
           for (int i = 0; i < WeiPaiXu.size() - 1; i++) {
               if (WeiPaiXu.get(i).getX() > WeiPaiXu.get(i + 1).getX()) {
                   ChessboardPoint temp=new ChessboardPoint(WeiPaiXu.get(i).getX(),WeiPaiXu.get(i).getY());
                   WeiPaiXu.set(i, WeiPaiXu.get(i + 1));
                   WeiPaiXu.set(i + 1, temp);
               }
               if (WeiPaiXu.get(i).getX() == WeiPaiXu.get(i + 1).getX()&&WeiPaiXu.get(i).getY()>WeiPaiXu.get(i+1).getY()) {
                   ChessboardPoint temp=new ChessboardPoint(WeiPaiXu.get(i).getX(),WeiPaiXu.get(i).getY());
                   WeiPaiXu.set(i, WeiPaiXu.get(i + 1));
                   WeiPaiXu.set(i + 1, temp);
               }
           }
       }
     return   WeiPaiXu;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(currentPlayer==chessComponents[sourceX][sourceY].chessColor) {
            List<ChessboardPoint> theMovedChess = chessComponents[sourceX][sourceY].canMoveTo();
            ChessboardPoint targetPoint = new ChessboardPoint(targetX, targetY);
            if(!(targetPoint==null)){
            for (int i = 0; i < theMovedChess.size(); i++) {
                if (theMovedChess.get(i).equals(targetPoint)) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(targetX,targetY);
                    CopyOne[targetX][targetY] = CopyOne[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    CopyOne[sourceX][sourceY] = new EmptySlotComponent();
                    currentPlayer = (currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK);
                    return true;
                }
                }
            }
        }
//        System.out.println("dajdoaw");
       return false;

    }


}
