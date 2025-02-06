import java.util.List;

public class ConcreteChessGame implements ChessGame {

    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
    private ChessColor nowChess;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[9][8];
        this.currentPlayer = ChessColor.WHITE;
    }



    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 95:{
                        this.chessComponents[i][j]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(i,j));
                        break;
                    }
                    case 112:{
                        this.chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    }
                    case 80:{
                        this.chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    }
                    case 114:{
                        this.chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    }
                    case 82:{
                        this.chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));

                        break;
                    }
                    case 110:{
                        this.chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));

                        break;
                    }
                    case 78:{
                        this.chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));

                        break;
                    }
                    case 98:{
                        this.chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));

                        break;
                    }
                    case 66:{
                        this.chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));

                        break;
                    }
                    case 113:{
                        this.chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));

                        break;
                    }
                    case 81:{
                        this.chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));

                        break;
                    }
                    case 107:{
                        this.chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));

                        break;
                    }
                    case 75:{
                        this.chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    }

                }
            }
        }
        if ( chessboard.get ( 8 ).charAt ( 0 )=='b'  ){
            currentPlayer=ChessColor.BLACK;
        }

    }

     @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void changeCurrentPlayer(){
        if (getCurrentPlayer() == ChessColor.WHITE){
            setCurrentPlayer(ChessColor.BLACK);
        }
        else {
            setCurrentPlayer(ChessColor.WHITE);
        }
    }


   


    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

 
    @Override
    public String getChessboardGraph() {
        String[] str=new String[8];
        for (int i = 0; i < 8; i++) {
            str[i]="";
            for (int j = 0; j < 8; j++) {
                str[i] += chessComponents[i][j].toString ();
           /*     if (getNowChess(i,j).equals(ChessColor.BLACK)){
                }else {
                }*/

            }
        }

        return str[0]+"\n"+
                str[1]+"\n"+
                str[2]+"\n"+
                str[3]+"\n"+
                str[4]+"\n"+
                str[5]+"\n"+
                str[6]+"\n"+
                str[7];

    }

    
    @Override
    public String getCapturedChess(ChessColor player) {

        int p=0,r=0,n=0,b=0,q=0,k=0;
        int P=0,R=0,N=0,B=0,Q=0,K=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               if (chessComponents[i][j].toString ().equals ( "p" )){
                   p++;
               }
                if (chessComponents[i][j].toString ().equals ( "r" )){
                    r++;
                }
                if (chessComponents[i][j].toString ().equals ( "n" )){
                    n++;
                }
                if (chessComponents[i][j].toString ().equals ( "b" )){
                    b++;
                }
                if (chessComponents[i][j].toString ().equals ( "q" )){
                    q++;
                }
                if (chessComponents[i][j].toString ().equals ( "k" )){
                    k++;
                }
                ///
                if (chessComponents[i][j].toString ().equals ( "P" )){
                    P++;
                }
                if (chessComponents[i][j].toString ().equals ( "R" )){
                    R++;
                }
                if (chessComponents[i][j].toString ().equals ( "N" )){
                    N++;
                }
                if (chessComponents[i][j].toString ().equals ( "B" )){
                    B++;
                }
                if (chessComponents[i][j].toString ().equals ( "Q" )){
                    Q++;
                }
                if (chessComponents[i][j].toString ().equals ( "K" )){
                    K++;
                }
            }
        }
        String str = "";
        if ( player.equals ( ChessColor.BLACK ) ) {
            if ( (1-K) != 0 ) {
                str += "K " + 1+"\n";
            }
            if ( 1 - Q != 0 ) {
                str += "Q " + ( 1 - Q )+"\n";
            }
            if ( 2 - R != 0 ) {
                str += "R " + ( 2 - R )+"\n";
            }
            if ( 2 - B != 0 ) {
                str += "B " + ( 2 - B )+"\n";
            }
            if ( 2 - N != 0 ) {
                str += "N " + ( 2 - N )+"\n";
            }
            if ( 8 - P != 0 ) str += "P " + ( 8 - P );
        }
        if ( player.equals ( ChessColor.WHITE) ) {
            if ( k != 1 ) {
                str += "k " + 0+"\n";
            }
            if ( 1 - q != 0 ) {
                str += "q " + ( 1 - q )+"\n";
            }
            if ( 2 - r != 0 ) {
                str += "r " + ( 2 - r )+"\n";
            }
            if ( 2 - b != 0 ) {
                str += "b " + ( 2 - b )+"\n";
            }
            if ( 2 - n != 0 ) {
                str += "n " + ( 2 - n )+"\n";
            }
            if ( 8 - p != 0 ) str += "p " + ( 8 - p );
        }


        return str;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(),source.getY());
        chess.loadChessboard(chessComponents);

        return chess.canMoveTo();
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
       if ( getChess ( sourceX,sourceY ).getChessColor () == getCurrentPlayer () ){
           boolean b=false;
           List<ChessboardPoint> pointList =getCanMovePoints(getChess(sourceX,sourceY).getSource());
           for ( ChessboardPoint chessboardPoint : pointList ) {
               if ( chessboardPoint.getX () == targetX && chessboardPoint.getY () == targetY ) {
                   b = true;
                   break;
               }
           }
           if ( b ){
               this.chessComponents[targetX][targetY]=getChess ( sourceX,sourceY );
               this.chessComponents[targetX][targetY].setSource ( new ChessboardPoint ( targetX,targetY ) ) ;
               this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
                changeCurrentPlayer();
               return true;
           }
       }
       return false;
    }

    public ChessColor getNowChess(int i,int j) {
        return chessComponents[i][j].getChessColor();
    }



}
