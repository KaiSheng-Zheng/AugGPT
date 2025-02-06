import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;



    public void loadChessGame(List<String> chessboard){
        chessComponents=new ChessComponent[8][8];
        if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }else{
            currentPlayer=ChessColor.BLACK;
        }
        for(int x=0;x<8;x++){
            String str=chessboard.get(x);
            for (int y=0;y<8;y++){
                switch (str.charAt(y)){
                    case'R':
                        chessComponents[x][y]=new RookChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'N':
                        chessComponents[x][y]=new KnightChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'B':
                        chessComponents[x][y]=new BishopChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'Q':
                        chessComponents[x][y]=new QueenChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'K':
                        chessComponents[x][y]=new KingChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'P':
                        chessComponents[x][y]=new PawnChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'_':
                        chessComponents[x][y]=new EmptySlotComponent('_','n',x,y,this);
                        break;
                    case'r':
                        chessComponents[x][y]=new RookChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                    case'n':
                        chessComponents[x][y]=new KnightChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                    case'b':
                        chessComponents[x][y]=new BishopChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                    case'q':
                        chessComponents[x][y]=new QueenChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                    case'k':
                        chessComponents[x][y]=new KingChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                    case'p':
                        chessComponents[x][y]=new PawnChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                }
            }
        }

    }
    public void loadChessGameInGame(List<String> chessboard){
        chessComponents=new ChessComponent[8][8];
        for(int x=0;x<8;x++){
            String str=chessboard.get(x);
            for (int y=0;y<8;y++){
                switch (str.charAt(y)){
                    case'R':
                        chessComponents[x][y]=new RookChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'N':
                        chessComponents[x][y]=new KnightChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'B':
                        chessComponents[x][y]=new BishopChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'Q':
                        chessComponents[x][y]=new QueenChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'K':
                        chessComponents[x][y]=new KingChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'P':
                        chessComponents[x][y]=new PawnChessComponent(str.charAt(y),'b',x,y,this);
                        break;
                    case'_':
                        chessComponents[x][y]=new EmptySlotComponent('_','n',x,y,this);
                        break;
                    case'r':
                        chessComponents[x][y]=new RookChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                    case'n':
                        chessComponents[x][y]=new KnightChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                    case'b':
                        chessComponents[x][y]=new BishopChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                    case'q':
                        chessComponents[x][y]=new QueenChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                    case'k':
                        chessComponents[x][y]=new KingChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                    case'p':
                        chessComponents[x][y]=new PawnChessComponent(str.charAt(y),'w',x,y,this);
                        break;
                }
            }
        }

    }
    public String getChessboardGraph(){
        StringBuffer str=new StringBuffer();
        for(int x=0;x<8;x++){
            for(int y=0;y<8;y++){
                str.append(chessComponents[x][y].toString());
            }
            if(x!=7){
                str.append("\n");
            }

        }

        return str.toString();
    }
    public List<String> getChessboardGraphInGame(){
        StringBuffer str=new StringBuffer();
        ArrayList a=new ArrayList<>();
        for(int x=0;x<8;x++){
            for(int y=0;y<8;y++){
                str.append(chessComponents[x][y].toString());
            }
            a.add(str.toString());
            str=new StringBuffer();
        }
        ;
        return a;
    }

    public String getCapturedChess(ChessColor player) {
        int King=1;
        int Queen=1;
        int Rooks=2;
        int Bishops=2;
        int Knights=2;
        int Pawns=8;
        if(player==ChessColor.WHITE){
            for(int y=0;y<8;y++){
                for(int x=0;x<8;x++){
                    char n=getChess(x,y).name;
                    if(n=='k'){
                        King--;
                    }else if(n=='q'){
                        Queen--;
                    }else if(n=='r'){
                        Rooks--;
                    }else if(n=='b'){
                        Bishops--;
                    }else if(n=='n'){
                        Knights--;
                    }else if(n=='p'){
                        Pawns--;
                    }
                }
            }
            StringBuffer str=new StringBuffer();
            if(King!=0){
                str.append("k ");
                str.append(King);
                str.append("\n");
            }
            if(Queen!=0){
                str.append("q ");
                str.append(Queen);
                str.append("\n");
            }
            if(Rooks!=0){
                str.append("r ");
                str.append(Rooks);
                str.append("\n");
            }
            if(Bishops!=0){
                str.append("b ");
                str.append(Bishops);
                str.append("\n");
            }
            if(Knights!=0){
                str.append("n ");
                str.append(Knights);
                str.append("\n");
            }
            if(Pawns!=0){
                str.append("p ");
                str.append(Pawns);
                str.append("\n");
            }
        return str.toString();


        }else{
            for(int y=0;y<8;y++){
                for(int x=0;x<8;x++){
                    char n=getChess(x,y).name;
                    if(n=='K'){
                        King--;
                    }else if(n=='Q'){
                        Queen--;
                    }else if(n=='R'){
                        Rooks--;
                    }else if(n=='B'){
                        Bishops--;
                    }else if(n=='N'){
                        Knights--;
                    }else if(n=='P'){
                        Pawns--;
                    }
                }
            }
            StringBuffer str=new StringBuffer();
            if(King!=0){
                str.append("K ");
                str.append(King);
                str.append("\n");
            }
            if(Queen!=0){
                str.append("Q ");
                str.append(Queen);
                str.append("\n");
            }
            if(Rooks!=0){
                str.append("R ");
                str.append(Rooks);
                str.append("\n");
            }
            if(Bishops!=0){
                str.append("B ");
                str.append(Bishops);
                str.append("\n");
            }
            if(Knights!=0){
                str.append("N ");
                str.append(Knights);
                str.append("\n");
            }
            if(Pawns!=0){
                str.append("P ");
                str.append(Pawns);
                str.append("\n");
            }
            return str.toString();
        }
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        if(chessComponents[source.getX()][source.getY()].canMoveTo()==null){
            return new ArrayList<>();
        }
        ArrayList<ChessboardPoint> possible=new ArrayList<>(chessComponents[source.getX()][source.getY()].canMoveTo());
                Collections.sort(possible, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX()>o2.getX()){
                    return 1;
                }else if (o1.getX()<o2.getX()){
                    return -1;
                }else{
                    if(o1.getY()>o2.getY()){
                        return 1;
                    }else if(o1.getY()<o2.getY()){
                        return -1;
                    }else{
                        return 0;
                    }
                }

            }
        });
        return possible;
    }
    public ChessColor getCurrentPlayer(){
        return currentPlayer;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public ChessComponent[][] getChessComponents(){
        return this.chessComponents;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(currentPlayer!=chessComponents[sourceX][sourceY].getChessColor()){
            return false;
        }
        ChessboardPoint b=new ChessboardPoint(targetX,targetY);
        if(getChess(sourceX,sourceY).canMoveTo().size()==0){
            return false;
        }
        if(getChess(sourceX,sourceY).canMoveTo()==null){
            return false;
        }
        if(new ChessboardPoint(targetX,targetY).offset(0,0)==null){
            return false;
        }
        if(new ChessboardPoint(sourceX,sourceY).offset(0,0)==null){
            return false;
        }
        if(new ChessboardPoint(sourceX,sourceY).offset(0,0)==new ChessboardPoint(targetX,targetY).offset(0,0)){
            return false;
        }
        for(ChessboardPoint a:getChess(sourceX,sourceY).canMoveTo()){
            if (b.equalsTo(a)){
                if(getCurrentPlayer()==ChessColor.WHITE){
                    this.currentPlayer=ChessColor.BLACK;
                }else if(getCurrentPlayer()==ChessColor.BLACK){
                    this.currentPlayer=ChessColor.WHITE;
                }
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY]=new EmptySlotComponent('_','n',sourceX,sourceY,this);


                loadChessGameInGame(this.getChessboardGraphInGame());


                return true;
            }
        }
        return false;
    }

}
