import java.util.*;


public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private String[] chessboard = new String[9];
    int BR,BN,BB,BQ,BK,BP,wr,wn,wb,wq,wk,wp;




    public void loadChessGame(List<String> chessboard){
        for(int i = 0;i<=8;i++){
                System.out.println(chessboard.get(i));
                this.chessboard[i] = chessboard.get(i);
        }
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent('N',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent('K',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent('n',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent('k',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    
                }
                if(chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(i,j));
                }
            }
        }
        if(this.chessboard[8].equals("w"))
            currentPlayer = ChessColor.WHITE;
        else
            currentPlayer = ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder OUT = new StringBuilder();
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++){
                OUT.append(chessComponents[i][j].name);
            }
            OUT.append("\n");
        }
        return String.valueOf(OUT);
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder OUT = new StringBuilder();
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++){
                if(chessComponents[i][j].getChessColor() == ChessColor.NONE)
                    continue;
                if(chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                    if(chessComponents[i][j].name == 'k')
                        wk++;
                    if(chessComponents[i][j].name == 'q')
                        wq++;
                    if(chessComponents[i][j].name == 'n')
                        wn++;
                    if(chessComponents[i][j].name == 'p')
                        wp++;
                    if(chessComponents[i][j].name == 'r')
                        wr++;
                    if(chessComponents[i][j].name == 'b')
                        wb++;
                }
                if(chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                    if(chessComponents[i][j].name == 'K')
                        BK++;
                    if(chessComponents[i][j].name == 'Q')
                        BQ++;
                    if(chessComponents[i][j].name == 'P')
                        BP++;
                    if(chessComponents[i][j].name == 'R')
                        BR++;
                    if(chessComponents[i][j].name == 'N')
                        BN++;
                    if(chessComponents[i][j].name == 'B')
                        BB++;
                }
            }
        }
        if(player == ChessColor.WHITE){
            if(wk!=1)
                OUT.append("k 1\n");
            if(wq!=1)
                OUT.append("q 1\n");
            if(wr!=2){OUT.append("r ");OUT.append(2-wr);OUT.append("\n");}
            if(wb!=2){OUT.append("b ");OUT.append(2-wb);OUT.append("\n");}
            if(wn!=2){OUT.append("n ");OUT.append(2-wn);OUT.append("\n");}
            if(wp!=8){OUT.append("p ");OUT.append(8-wp);OUT.append("\n");}
        }
        if(player == ChessColor.BLACK){
            if(BK!=1)
                OUT.append("K 1\n");
            if(BQ!=1)
                OUT.append("Q 1\n");
            if(BR!=2){OUT.append("R ");OUT.append(2-BR);OUT.append("\n");}
            if(BB!=2){OUT.append("B ");OUT.append(2-BB);OUT.append("\n");}
            if(BN!=2){OUT.append("N ");OUT.append(2-BN);OUT.append("\n");}
            if(BP!=8){OUT.append("P ");OUT.append(8-BP);OUT.append("\n");}
        }
        BR = 0;BN = 0;BB = 0;BQ = 0;BK = 0;BP = 0;wr = 0;wn = 0;wb = 0;wq = 0;wk = 0;wp = 0;
    return String.valueOf(OUT);
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){

        PriSort priSort = new PriSort();


        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    public boolean in(List<ChessboardPoint> canMoveTo,ChessboardPoint source){
        for(int i = 0;i < canMoveTo.size();i++){
            if(canMoveTo.get(i).getX() != source.getX()|canMoveTo.get(i).getY() != source.getY())
                continue;
            else 
                return true;
        }
        return false;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].getChessColor() == currentPlayer ){
            if(in(chessComponents[sourceX][sourceY].canMoveTo(),chessComponents[targetX][targetY].getSource())){
                chessComponents[sourceX][sourceY].setChessboardPoint(targetX,targetY);
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer == ChessColor.WHITE)
                    currentPlayer = ChessColor.BLACK;
                else
                    currentPlayer= ChessColor.WHITE;
                return true;
            }
            else return false;
        }
        else
            return false;
    }

}

