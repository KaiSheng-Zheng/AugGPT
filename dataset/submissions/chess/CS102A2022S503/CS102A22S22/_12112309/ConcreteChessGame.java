import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame  implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public  List<String> getChessBoard() {
        return ChessBoard;
    }

    public List<String>  ChessBoard=new ArrayList<>();

    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
this.ChessBoard=chessboard;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char a=chessboard.get(i).charAt(j);
                if(a=='R'){
                    chessComponents[i][j]= new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='r'){
                    chessComponents[i][j]= new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='N'){
                    chessComponents[i][j]= new KnightChessComponent('N',ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='n'){
                    chessComponents[i][j]= new KnightChessComponent('n',ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='B'){
                    chessComponents[i][j]= new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='b'){
                    chessComponents[i][j]= new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='Q'){
                    chessComponents[i][j]= new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='q'){
                    chessComponents[i][j]= new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='K'){
                    chessComponents[i][j]= new KingChessComponent('K',ChessColor.BLACK,new ChessboardPoint(i,j));
                   chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='k'){
                    chessComponents[i][j]= new KingChessComponent('k',ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='P'){
                    chessComponents[i][j]= new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='p'){
                    chessComponents[i][j]= new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
                if(a=='_'){
                    chessComponents[i][j]= new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setConcreteChessGame(this);
                    continue;
                }
            }
        }

        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }
         if(chessboard.get(8).charAt(0)=='b'){
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
        StringBuilder buffer=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            StringBuilder buffer1=new StringBuilder();
            for (int j = 0; j < 8; j++) {
                buffer1.append(chessComponents[i][j].name);
            }
            buffer.append(buffer1);
            buffer.append("\n");
        }
        buffer.deleteCharAt(buffer.length()-1);
        return buffer.toString();

    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if(player==ChessColor.BLACK){
            int upkingNum=0;
            int upqueenNum=0;
            int uprookNum=0;
            int upbishopNum=0;
            int upknightNum=0;
            int uppawnNum=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].name=='K'){
                        upkingNum++;
                    }
                    if(chessComponents[i][j].name=='Q'){
                        upqueenNum++;
                    }
                    if(chessComponents[i][j].name=='R'){
                        uprookNum++;
                    }
                    if(chessComponents[i][j].name=='B'){
                        upbishopNum++;
                    }
                    if(chessComponents[i][j].name=='N'){
                        upknightNum++;
                    }
                    if(chessComponents[i][j].name=='P'){
                        uppawnNum++;
                    }
                }
            }
            StringBuilder buffer=new StringBuilder();
            if(upkingNum==0){
                buffer.append("K"+" "+1+"\n");
            }
            if(upqueenNum==0){
                buffer.append("Q"+" "+1+"\n");
            }
            if(uprookNum<2){
                buffer.append("R"+" "+(2-uprookNum)+"\n");
            }
            if(upbishopNum<2){
                buffer.append("B"+" "+(2-upbishopNum)+"\n");
            }
            if(upknightNum<2){
                buffer.append("N"+" "+(2-upknightNum)+"\n");
            }
            if(uppawnNum<8){
                buffer.append("P"+" "+(8-uppawnNum)+"\n");
            }

            return buffer.toString();
        }
        if(player==ChessColor.WHITE){
            int lowkingNum=0;
            int lowqueenNum=0;
            int lowrookNum=0;
            int lowbishopNum=0;
            int lowknightNum=0;
            int lowpawnNum=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].name=='k'){
                        lowkingNum++;
                    }
                    if(chessComponents[i][j].name=='q'){
                        lowqueenNum++;
                    }
                    if(chessComponents[i][j].name=='r'){
                        lowrookNum++;
                    }
                    if(chessComponents[i][j].name=='b'){
                        lowbishopNum++;
                    }
                    if(chessComponents[i][j].name=='n'){
                        lowknightNum++;
                    }
                    if(chessComponents[i][j].name=='p'){
                        lowpawnNum++;
                    }
                }
            }
            StringBuilder buffer=new StringBuilder();
            if(lowkingNum==0){
                buffer.append("k"+" "+1+"\n");
            }
            if(lowqueenNum==0){
                buffer.append("q"+" "+1+"\n");
            }
            if(lowrookNum<2){
                buffer.append("r"+" "+(2-lowrookNum)+"\n");
            }
            if(lowbishopNum<2){
                buffer.append("b"+" "+(2-lowbishopNum)+"\n");
            }
            if(lowknightNum<2){
                buffer.append("n"+" "+(2-lowknightNum)+"\n");
            }
            if(lowpawnNum<8){
                buffer.append("p"+" "+(8-lowpawnNum)+"\n");
            }

            return buffer.toString();
        }
        return null;
    }



    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess=this.getChess(source.getX(),source.getY());
// 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
// 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX()==o2.getX()) {
                    if(o1.getY()>o2.getY()){return 1;}
                    else if(o1.getY()<o2.getY()){return -1;}
                    else{return 0;}
                }
                else if(o1.getX()>o2.getX()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
        return canMovePoints;
    }



    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
      ChessboardPoint chessboardPoint=new ChessboardPoint(sourceX,sourceY);
      ChessboardPoint chessboardPoint1=new ChessboardPoint(targetX,targetY);
        for (int i = 0; i < getCanMovePoints(chessboardPoint).size(); i++) {
            if(getCanMovePoints(chessboardPoint).get(i).equals(chessboardPoint1)&&chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY]=new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
                if (currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;}
                    else {currentPlayer=ChessColor.WHITE;}
                return true;
            }
        }
        return false;
        }



}

