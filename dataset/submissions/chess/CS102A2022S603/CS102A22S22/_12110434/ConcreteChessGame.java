
import java.util.List;
import java.util.Objects;


public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    private ChessComponent chess;


    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessboard.get(i).charAt(j)=='p'){
                    PawnChessComponent p=new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=p;
                }else if(chessboard.get(i).charAt(j)=='P'){
                    PawnChessComponent P=new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=P;
                }else if(chessboard.get(i).charAt(j)=='r'){
                    RookChessComponent r=new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=r;
                }else if(chessboard.get(i).charAt(j)=='R'){
                    RookChessComponent R=new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=R;
                }else if(chessboard.get(i).charAt(j)=='n'){
                    KnightChessComponent n=new KnightChessComponent('n',new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=n;
                }else if(chessboard.get(i).charAt(j)=='N'){
                    KnightChessComponent N =new KnightChessComponent('N',new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=N;
                }else if(chessboard.get(i).charAt(j)=='b'){
                    BishopChessComponent b=new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=b;
                }else if(chessboard.get(i).charAt(j)=='B'){
                    BishopChessComponent B=new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=B;
                }else if(chessboard.get(i).charAt(j)=='q'){
                    QueenChessComponent q=new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=q;
                }else if(chessboard.get(i).charAt(j)=='Q'){
                    QueenChessComponent Q=new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=Q;
                }else if(chessboard.get(i).charAt(j)=='k'){
                    KingChessComponent k=new KingChessComponent('k',new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=k;
                }else if(chessboard.get(i).charAt(j)=='K'){
                    KingChessComponent K = new KingChessComponent('K',new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=K;
                }else if(chessboard.get(i).charAt(j)=='_'){
                    EmptySlotComponent e = new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(i,j),chessComponents);
                    chessComponents[i][j]=e;
                }
            }
        }if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }else if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder a=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                a.append(chessComponents[i][j].toString());
            }a.append('\n');
        }
        return a.toString();
    }

    public int countString(String s,String m){
        int count = 0;
        while(s.contains(m)){
            s=s.substring(s.indexOf(m)+1);
            count++;
        }
        return count;
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        if(player==ChessColor.BLACK) {
            if (countString(getChessboardGraph(), "K") < 1) {
                str.append("K 1\n");
            }
            if (countString(getChessboardGraph(), "Q") < 1) {
                str.append("Q 1\n");
            }
            if (countString(getChessboardGraph(), "R") < 2) {
                str.append("R ").append(2 - countString(getChessboardGraph(), "R")).append("\n");
            }
            if (countString(getChessboardGraph(), "B") < 2) {
                str.append("B ").append(2 - countString(getChessboardGraph(), "B")).append("\n");
            }
            if (countString(getChessboardGraph(), "N") < 2) {
                str.append("N ").append(2 - countString(getChessboardGraph(), "N")).append("\n");
            }
            if (countString(getChessboardGraph(), "P") < 8) {
                str.append("P ").append(8 - countString(getChessboardGraph(), "P")).append("\n");
            }
        }
        else if(player==ChessColor.WHITE){
            if (countString(getChessboardGraph(),"k") < 1) {
                str.append("k 1\n");
            }
            if (countString(getChessboardGraph(),"q") < 1) {
                str.append("q 1\n");
            }
            if (countString(getChessboardGraph(),"r") < 2) {
                str.append("r ").append(2 - countString(getChessboardGraph(),"r")).append("\n");
            }
            if (countString(getChessboardGraph(),"b") < 2) {
                str.append("b ").append(2 - countString(getChessboardGraph(),"b")).append("\n");
            }
            if (countString(getChessboardGraph(),"n") < 2) {
                str.append("n ").append(2 - countString(getChessboardGraph(),"n")).append("\n");
            }
            if (countString(getChessboardGraph(),"p") < 8) {
                str.append("p ").append(8 - countString(getChessboardGraph(),"p")).append("\n");
            }
        }
        return str.toString();
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){

        if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "N")){
            chess=new KnightChessComponent('N',source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "n")){
            chess=new KnightChessComponent('n',source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "b")){
            chess=new BishopChessComponent('b',ChessColor.WHITE,source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "B")){
            chess=new BishopChessComponent('B',ChessColor.BLACK,source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "k")){
            chess=new KingChessComponent('k',source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "K")){
            chess=new KingChessComponent('K',source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "p")){
            chess=new PawnChessComponent('p',ChessColor.WHITE,source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "P")){
            chess=new PawnChessComponent('P',ChessColor.BLACK,source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "q")){
            chess=new QueenChessComponent('q',ChessColor.WHITE,source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "Q")){
            chess=new QueenChessComponent('Q',ChessColor.BLACK,source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "r")){
            chess=new RookChessComponent('r',ChessColor.WHITE,source,chessComponents);
            return chess.canMoveTo();
        } else if(Objects.equals(chessComponents[source.getX()][source.getY()].toString(), "R")){
            chess=new RookChessComponent('R',ChessColor.BLACK,source,chessComponents);
            return chess.canMoveTo();
        }

        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint chessboardPoint=new ChessboardPoint(targetX,targetY);
        if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "N")){
            chess=new KnightChessComponent('N',new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "n")){
            chess=new KnightChessComponent('n',new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "B")){
            chess=new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "b")){
            chess=new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "R")){
            chess=new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "r")){
            chess=new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "p")){
            chess=new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "P")){
            chess=new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "Q")){
            chess=new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "q")){
            chess=new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "k")){
            chess=new KingChessComponent('k',new ChessboardPoint(sourceX,sourceY),chessComponents);
        }else if(Objects.equals(chessComponents[sourceX][sourceY].toString(), "K")){
            chess=new KingChessComponent('K',new ChessboardPoint(sourceX,sourceY),chessComponents);
        }

        return chess.canMoveTo().contains(chessboardPoint);

    }


    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
}
