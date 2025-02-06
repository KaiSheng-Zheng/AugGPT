import java.util.List;

public class ConcreteChessGame  implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer = ChessColor.WHITE;
    int BB,BK,BP,BQ,BR,BN,wb,wk,wp,wq,wr,wn;

    public ConcreteChessGame(){}
    private ChessColor getComponentColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='A'&&component<='Z')?ChessColor.BLACK:ChessColor.WHITE);
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if( chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    BB++;
                }else if (chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    wb++;
                }else if (chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent('K',ChessColor.BLACK,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    BK++;
                }else if (chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent('k',ChessColor.WHITE,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    wk++;
                }else if (chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    BP++;
                }else if (chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    wp++;
                }else if (chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent('N',ChessColor.BLACK,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    BN++;
                }else if (chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent('n',ChessColor.WHITE,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    wn++;
                }else if (chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    BQ++;
                }else if (chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    wq++;
                }else if (chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    BR++;
                }else if (chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                    wr++;
                }else if (chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessPieces(chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
        }
        getChessboardGraph();
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder STR = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                STR.append(chessComponents[i][j].name);
            }
            STR.append("\n");
        }
        for (int i = 0; i < 8; i++) {
            STR.append(chessComponents[7][i].name);
        }
        return String.valueOf(STR);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] cntr=new int[128],sequence=new int[]{'K','Q','R','B','N','P'},fullNum=new int[]{1,1,2,2,2,8};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(getComponentColor(chessComponents[i][j].toString().charAt(0))==player){
                    cntr[chessComponents[i][j].toString().charAt(0)&(~32)]++;
                }
            }
        }
        for(int i=0;i<sequence.length;i++){
            if(cntr[sequence[i]]<fullNum[i]){
                sb.append((char) (sequence[i] | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(fullNum[i] - cntr[sequence[i]]).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return getChess(source.getX(),source.getY()).canMoveTo();
    }


    public boolean within(List<ChessboardPoint> canMoveTo, ChessboardPoint sourse){
        for (int i = 0; i < canMoveTo.size(); i++) {
            if (canMoveTo.get(i).getX() != sourse.getX() | canMoveTo.get(i).getY() != sourse.getY())
                continue;
            else
                return true;
            }
        return false;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
      if (chessComponents[sourceX][sourceY].chessColor() == currentPlayer){
          if (within(chessComponents[sourceX][sourceY].canMoveTo(),chessComponents[targetX][targetY].getSource())){
              chessComponents[sourceX][sourceY].setSource(chessComponents[targetX][targetY].getSource());
              chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
              chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
              if (currentPlayer == ChessColor.WHITE){
                  currentPlayer = ChessColor.BLACK;
              }else {
                  currentPlayer = ChessColor.WHITE;
              }
              return true;
          }else return false;
      }else return false;
    }

}
