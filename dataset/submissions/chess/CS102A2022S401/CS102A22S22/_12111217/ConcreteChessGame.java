import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.NONE;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> init=getChess(source).canMoveTo();
        List<ChessboardPoint> result=new ArrayList<>();
        if (init.size()==0){
            return init;
        }
        else {
            result.add(init.get(0));
            for (int i=1;i<init.size();i++){
                for (int j=0;j< result.size();j++){
                    if (init.get(i).getX()<result.get(j).getX()){
                        result.add(j,init.get(i));
                        break;
                    }
                    if (init.get(i).getX()==result.get(j).getX()
                            &&init.get(i).getY()<result.get(j).getY()){
                        result.add(j,init.get(i));
                        break;
                    }
                    if (j== result.size()-1){
                        result.add(init.get(i));
                        break;
                    }
                }
            }
            return result;
        }
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
         if (this.getChess(sourceX,sourceY).getChessColor()==currentPlayer){
            boolean t=false;
            List<ChessboardPoint> movePoints=this.getChess(sourceX,sourceY).canMoveTo();
            for (int i=0;i<movePoints.size();i++){
                if (movePoints.get(i).getX()==targetX&&movePoints.get(i).getY()==targetY){
                    t=true;
                    break;
                }
            }
            if (t){
                this.getChess(sourceX,sourceY).setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=this.getChess(sourceX,sourceY);
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY);
                if (currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                }
                else if (currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }
                return true;
            }
        }
        return false;
    }

    public void loadChessGame(List<String> chessboard){
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                switch (chessboard.get(x).charAt(y)) {
                    case '_' -> chessComponents[x][y] = new EmptySlotComponent(x,y);
                    case 'R' -> chessComponents[x][y] = new RookChessComponent(x,y,ChessColor.BLACK,this);
                    case 'r' -> chessComponents[x][y] = new RookChessComponent(x,y,ChessColor.WHITE,this);
                    case 'N' -> chessComponents[x][y] = new KnightChessComponent(x,y,ChessColor.BLACK,this);
                    case 'n' -> chessComponents[x][y] = new KnightChessComponent(x,y,ChessColor.WHITE,this);
                    case 'B' -> chessComponents[x][y] = new BishopChessComponent(x,y,ChessColor.BLACK,this);
                    case 'b' -> chessComponents[x][y] = new BishopChessComponent(x,y,ChessColor.WHITE,this);
                    case 'Q' -> chessComponents[x][y] = new QueenChessComponent(x,y,ChessColor.BLACK,this);
                    case 'q' -> chessComponents[x][y] = new QueenChessComponent(x,y,ChessColor.WHITE,this);
                    case 'K' -> chessComponents[x][y] = new KingChessComponent(x,y,ChessColor.BLACK,this);
                    case 'k' -> chessComponents[x][y] = new KingChessComponent(x,y,ChessColor.WHITE,this);
                    case 'P' -> chessComponents[x][y] = new PawnChessComponent(x,y,ChessColor.BLACK,this);
                    case 'p' -> chessComponents[x][y] = new PawnChessComponent(x,y,ChessColor.WHITE,this);
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")){
            currentPlayer=ChessColor.WHITE;
        }
        if (Objects.equals(chessboard.get(8), "b")){
            currentPlayer=ChessColor.BLACK;
        }
    }


    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }


    public String getChessboardGraph(){
        StringBuilder result=new StringBuilder();
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                result.append(chessComponents[x][y].toString());
            }
            result.append("\n");
        }
        return result.toString();
    }

    public String getCapturedChess(ChessColor chessColor){
        int k=0;
        int q=0;
        int r=0;
        int b=0;
        int n=0;
        int p=0;
        StringBuilder result=new StringBuilder();

        if (chessColor==ChessColor.WHITE){
            for (int x=0;x<8;x++){
                for (int y=0;y<8;y++){
                    switch (chessComponents[x][y].toString()){
                        case "k" -> k=k+1;
                        case "q" -> q=q+1;
                        case "r" -> r=r+1;
                        case "b" -> b=b+1;
                        case "n" -> n=n+1;
                        case "p" -> p=p+1;
                    }
                }
            }
            if (k!=1){
                result.append("k ").append(1 - k).append("\n");
            }
            if (q!=1){
                result.append("q ").append(1 - q).append("\n");
            }
            if (r!=2){
                result.append("r ").append(2 - r).append("\n");
            }
            if (b!=2){
                result.append("b ").append(2 - b).append("\n");
            }
            if (n!=2){
                result.append("n ").append(2 - n).append("\n");
            }
            if (p!=8){
                result.append("p ").append(8 - p).append("\n");
            }
        }

        if (chessColor==ChessColor.BLACK){
            for (int x=0;x<8;x++){
                for (int y=0;y<8;y++){
                    switch (chessComponents[x][y].toString()){
                        case "K" -> k=k+1;
                        case "Q" -> q=q+1;
                        case "R" -> r=r+1;
                        case "B" -> b=b+1;
                        case "N" -> n=n+1;
                        case "P" -> p=p+1;
                    }
                }
            }
            if (k!=1){
                result.append("K ").append(1 - k).append("\n");
            }
            if (q!=1){
                result.append("Q ").append(1 - q).append("\n");
            }
            if (r!=2){
                result.append("R ").append(2 - r).append("\n");
            }
            if (b!=2){
                result.append("B ").append(2 - b).append("\n");
            }
            if (n!=2){
                result.append("N ").append(2 - n).append("\n");
            }
            if (p!=8){
                result.append("P ").append(8 - p).append("\n");
            }
        }
        return result.toString();
    }
    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }
    public ChessComponent getChess(ChessboardPoint a){ return chessComponents[a.getX()][a.getY()]; }
}