
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public void loadChessGame(List<String> chessboard) {
        this.currentPlayer = ChessColor.WHITE;
        this.chessComponents = new ChessComponent[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                char chessLetter = chessboard.get(i).charAt(j);
                if (chessLetter == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent('R');
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);


                }//duo tai fu lei shi chessComponent de er wei shu zu zi lei shi te ding lei chess
                else if (chessLetter == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent('K');
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    //this.chessComponents[i][j].setSource(i,j);

                } else if (chessLetter == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent('Q');
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);


                } else if (chessLetter == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent('B');
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);


                } else if (chessLetter == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent('P');
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);


                } else if (chessLetter == 'N') {
                    this.chessComponents[i][j] = new KnightChessComponent('N');
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);


                } else if (chessLetter == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent('r');
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);


                } else if (chessLetter == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent('k');
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
//
                } else if (chessLetter == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent('q');
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);


                } else if (chessLetter == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent('b');
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);


                } else if (chessLetter == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent('p');
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);



                } else if (chessLetter == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent('n');

                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);


                } else if (chessLetter == '_') {
                    this.chessComponents[i][j] = new EmptySlotComponent('_');

                    this.chessComponents[i][j].setChessColor(ChessColor.NONE);

                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].chessBoard = this.chessComponents;
            }
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder chessLetter = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessLetter.append(this.chessComponents[i][j]);
            }
            chessLetter.append("\n");
        }
        return String.valueOf(chessLetter);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder outChess = new StringBuilder();
        if (player == ChessColor.BLACK) {
            int K = 0, Q = 0, R = 0, B = 0, N = 0, P = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char chessLetter = chessComponents[i][j].name;
                    if (chessLetter == 'K') {
                        K++;
                    } else if (chessLetter == 'Q') {
                        Q++;
                    } else if (chessLetter == 'R') {
                        R++;
                    } else if (chessLetter == 'B') {
                        B++;
                    } else if (chessLetter == 'N') {
                        N++;
                    } else if (chessLetter == 'P') {
                        P++;
                    }
                }
            }
            if (1 - K > 0) outChess.append("K ").append(1 - K).append("\n");
            if (1 - Q > 0) outChess.append("Q ").append(1 - Q).append("\n");
            if (2 - R > 0) outChess.append("R ").append(2 - R).append("\n");
            if (2 - B > 0) outChess.append("B ").append(2 - B).append("\n");
            if (2 - N > 0) outChess.append("N ").append(2 - N).append("\n");
            if (8 - P > 0) outChess.append("P ").append(8 - P);
        } else if (player == ChessColor.WHITE) {
            int K = 0, Q = 0, R = 0, B = 0, N = 0, P = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char chessLetter = chessComponents[i][j].name;
                    if (chessLetter == 'k') {
                        K++;
                    } else if (chessLetter == 'q') {
                        Q++;
                    } else if (chessLetter == 'r') {
                        R++;
                    } else if (chessLetter == 'b') {
                        B++;
                    } else if (chessLetter == 'n') {
                        N++;
                    } else if (chessLetter == 'p') {
                        P++;
                    }
                }
            }
            if (1 - K > 0) outChess.append("k ").append(1 - K).append("\n");
            if (1 - Q > 0) outChess.append("q ").append(1 - Q).append("\n");
            if (2 - R > 0) outChess.append("r ").append(2 - R).append("\n");
            if (2 - B > 0) outChess.append("b ").append(2 - B).append("\n");
            if (2 - N > 0) outChess.append("n ").append(2 - N).append("\n");
            if (8 - P > 0) outChess.append("p ").append(8 - P);
        }
        return String.valueOf(outChess);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        chess.setSource(source);
        chess.setChessColor(chessComponents[source.getX()][source.getY()].getChessColor());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints,new sort());
//        canMovePoints.sort(new sort());
        return canMovePoints;
    }

    private static class sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint x, ChessboardPoint y) {
            if (x.getX() > y.getX()) {
                return 1;
            } else if (x.getX() < y.getX()) {
                return -1;
            } else {
                if (x.getY() > y.getY()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = chessComponents[sourceX][sourceY];
        if (chess.getChessColor() == this.getCurrentPlayer()) {
            List<ChessboardPoint> canMovePoints = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
            for (ChessboardPoint canMovePoint : canMovePoints) {
                if (canMovePoint.getX() == targetX && canMovePoint.getY() == targetY) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];

                    chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());

                    chessComponents[sourceX][sourceY] = new EmptySlotComponent('_');

                    chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                    this.chessComponents[targetX][targetX].setChessBoard(this.chessComponents);
                    this.chessComponents[sourceX][sourceY].setChessBoard(this.chessComponents);
                    if (currentPlayer == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    } else if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }

        }
            return false;
    }
}
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(char name){
        super(name);
        if (name=='q'){setChessColor(ChessColor.WHITE);}else {setChessColor(ChessColor.BLACK);}

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> list=new ArrayList<>();
        for (int i=1; source.getX()+i<=7;i++){
            if (!(chessBoard[source.getX()+i][source.getY()] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()+i][source.getY()].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(i, 0));
                }
                break;
            }else {
                list.add(source.offset(i, 0));
            }
        }
        for (int i=1; source.getX()-i>=0;i++){
            if (!(chessBoard[source.getX()-i][source.getY()] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()-i][source.getY()].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(-i, 0));
                }
                break;
            }else {
                list.add(source.offset(-i, 0));
            }
        }
        for (int i=1; source.getY()+i<=7;i++){
            if (!(chessBoard[source.getX()][source.getY()+i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()][source.getY()+i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(0, i));
                }
                break;
            }else {
                list.add(source.offset(0, i));
            }
        }
        for (int i=1; source.getY()-i>=0;i++){
            if (!(chessBoard[source.getX()][source.getY()-i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()][source.getY()-i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(0, -i));
                }
                break;
            }else {
                list.add(source.offset(0, -i));
            }
        }
        for (int i=1; source.getX()+i<=7 && source.getY()+i<=7; i++){
            if (!(chessBoard[source.getX()+i][source.getY()+i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()+i][source.getY()+i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(i, i));
                }
                break;
            }else
                list.add(source.offset(i,i));
        }
        for (int i=1; source.getX()+i<=7 && source.getY()-i>=0; i++){
            if (!(chessBoard[source.getX()+i][source.getY()-i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()+i][source.getY()-i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(i, -i));
                }
                break;
            }else
                list.add(source.offset(i,-i));
        }
        for (int i=1; source.getX()-i>=0 && source.getY()+i<=7; i++){
            if (!(chessBoard[source.getX()-i][source.getY()+i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()-i][source.getY()+i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(-i, i));
                }
                break;
            }else
                list.add(source.offset(-i,i));
        }
        for (int i=1; source.getX()-i>=0 && source.getY()-i>=0; i++){
            if (!(chessBoard[source.getX()-i][source.getY()-i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()-i][source.getY()-i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(-i, -i));
                }
                break;
            }else
                list.add(source.offset(-i,-i));
        }
        if (list.size()==0){return new ArrayList<>();}
        else {return list;}

    }
}
class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(char name){super(name);
        if (name=='n'){setChessColor(ChessColor.WHITE);}else {setChessColor(ChessColor.BLACK);}
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> list=new ArrayList<>();
        if (source.getX() - 2 >= 0 && source.getX() - 2 <= 7 && source.getY() - 1 >= 0 && source.getY() - 1 <= 7
                && chessBoard[source.getX() - 2][source.getY() - 1].getChessColor() !=this.getChessColor())
            list.add(source.offset(-2, -1));
        if (source.getX() - 1 >= 0 && source.getX() - 1 <= 7 && source.getY() - 2 >= 0 && source.getY() - 2 <= 7
                && chessBoard[source.getX() - 1][source.getY() - 2].getChessColor() != this.getChessColor())
            list.add(source.offset(-1, -2));
        if (source.getX() - 1 >= 0 && source.getX() - 1 <= 7 && source.getY() + 2 >= 0 && source.getY() + 2 <= 7
                && chessBoard[source.getX() - 1][source.getY() + 2].getChessColor() != this.getChessColor())
            list.add(source.offset(-1, +2));
        if (source.getX() - 2 >= 0 && source.getX() - 2 <= 7 && source.getY() + 1 >= 0 && source.getY() + 1 <= 7
                && chessBoard[source.getX() - 2][source.getY() + 1].getChessColor() !=this.getChessColor())
            list.add(source.offset(-2, +1));
        if (source.getX() + 2 >= 0 && source.getX() + 2 <= 7 && source.getY() - 1 >= 0 && source.getY() - 1 <= 7
                && chessBoard[source.getX() + 2][source.getY() - 1].getChessColor() != this.getChessColor())
            list.add(source.offset(+2, -1));
        if (source.getX() + 1 >= 0 && source.getX() + 1 <= 7 && source.getY() - 2 >= 0 && source.getY() - 2 <= 7
                && chessBoard[source.getX() + 1][source.getY() - 2].getChessColor() != this.getChessColor())
            list.add(source.offset(+1, -2));
        if (source.getX() + 1 >= 0 && source.getX() + 1 <= 7 && source.getY() + 2 >= 0 && source.getY() + 2 <= 7
                && chessBoard[source.getX() + 1][source.getY() + 2].getChessColor() != this.getChessColor())
            list.add(source.offset(+1, +2));
        if (source.getX() + 2 >= 0 && source.getX() + 2 <= 7 && source.getY() + 1 >= 0 && source.getY() + 1 <= 7
                && chessBoard[source.getX() + 2][source.getY() + 1].getChessColor() != this.getChessColor())
            list.add(source.offset(+2, +1));
        return list;
    }
}
class RookChessComponent extends ChessComponent{

    public RookChessComponent(char name){super(name);
        if (name=='r'){setChessColor(ChessColor.WHITE);}else {setChessColor(ChessColor.BLACK);}
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> list=new ArrayList<>();
        for (int i=1; source.getX()+i<=7;i++){
            if (!(chessBoard[source.getX()+i][source.getY()] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()+i][source.getY()].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(i, 0));
                }
                break;
            }else {
                list.add(source.offset(i, 0));
            }
        }
        for (int i=1; source.getX()-i>=0;i++){
            if (!(chessBoard[source.getX()-i][source.getY()] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()-i][source.getY()].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(-i, 0));
                }
                break;
            }else {
                list.add(source.offset(-i, 0));
            }
        }
        for (int i=1; source.getY()+i<=7;i++){
            if (!(chessBoard[source.getX()][source.getY()+i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()][source.getY()+i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(0, i));
                }
                break;
            }else {
                list.add(source.offset(0, i));
            }
        }
        for (int i=1; source.getY()-i>=0;i++){
            if (!(chessBoard[source.getX()][source.getY()-i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()][source.getY()-i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(0, -i));
                }
                break;
            }else {
                list.add(source.offset(0, -i));
            }
        }
        if (list.size()==0){return new ArrayList<>();}
        else {return list;}
    }
}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char name){super(name);
        if (name=='b'){setChessColor(ChessColor.WHITE);}else {setChessColor(ChessColor.BLACK);}
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> list=new ArrayList<>();
        for (int i=1; source.getX()+i<=7 && source.getY()+i<=7; i++){
            if (!(chessBoard[source.getX()+i][source.getY()+i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()+i][source.getY()+i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(i, i));
                }
                break;
            }else
                list.add(source.offset(i,i));
        }
        for (int i=1; source.getX()+i<=7 && source.getY()-i>=0; i++){
            if (!(chessBoard[source.getX()+i][source.getY()-i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()+i][source.getY()-i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(i, -i));
                }
                break;
            }else
                list.add(source.offset(i,-i));
        }
        for (int i=1; source.getX()-i>=0 && source.getY()+i<=7; i++){
            if (!(chessBoard[source.getX()-i][source.getY()+i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()-i][source.getY()+i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(-i, i));
                }
                break;
            }else
                list.add(source.offset(-i,i));
        }
        for (int i=1; source.getX()-i>=0 && source.getY()-i>=0; i++){
            if (!(chessBoard[source.getX()-i][source.getY()-i] instanceof EmptySlotComponent)){
                if (chessBoard[source.getX()-i][source.getY()-i].getChessColor() != this.getChessColor()) {
                    list.add(source.offset(-i, -i));
                }
                break;
            }else
                list.add(source.offset(-i,-i));
        }
        if (list.size()==0){
            return new ArrayList<>();}else {
            return list;
        }
    }
}
class KingChessComponent extends ChessComponent{
    public KingChessComponent(char name){super(name);
        if (name=='k'){setChessColor(ChessColor.WHITE);}else {setChessColor(ChessColor.BLACK);}
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> list=new ArrayList<>();

       if (source.getX()+1<=7){

                if (chessBoard[source.getX()+1][source.getY()].getChessColor() != this.getChessColor()||(chessBoard[source.getX()+1][source.getY()] instanceof EmptySlotComponent)) {
                    list.add(source.offset(1, 0));
                }

            }


       if (source.getX()-1>=0){

                if (chessBoard[source.getX()-1][source.getY()].getChessColor() != this.getChessColor()||(chessBoard[source.getX()-1][source.getY()] instanceof EmptySlotComponent)) {
                    list.add(source.offset(-1, 0));
                }

            }
        if(source.getX()+1<=7 && source.getY()+1<=7){

            if (chessBoard[source.getX() + 1][source.getY() + 1].getChessColor() != this.getChessColor()||(chessBoard[source.getX()+1][source.getY()+1] instanceof EmptySlotComponent)) {
                list.add(source.offset(1, 1));
            }
        }

        if(source.getX()+1<=7 && source.getY()-1>=0){

            if (chessBoard[source.getX() + 1][source.getY() - 1].getChessColor() != this.getChessColor()||(chessBoard[source.getX()+1][source.getY()-1] instanceof EmptySlotComponent)) {
                list.add(source.offset(1, -1));
            }
        }
        if( source.getX()-1>=0 && source.getY()+1<=7){

            if (chessBoard[source.getX() - 1][source.getY() + 1].getChessColor() != this.getChessColor()||(chessBoard[source.getX()-1][source.getY()+1] instanceof EmptySlotComponent)) {
                list.add(source.offset(-1, 1));
            }
        }

        if (source.getX()-1>=0 && source.getY()-1>=0){

            if (chessBoard[source.getX()-1][source.getY()-1].getChessColor() != this.getChessColor()||(chessBoard[source.getX()-1][source.getY()-1] instanceof EmptySlotComponent)) {
                list.add(source.offset(-1, -1));
            }


        }
        if( source.getY()+1<=7){

                if (chessBoard[source.getX()][source.getY()+1].getChessColor() != this.getChessColor()||(chessBoard[source.getX()][source.getY()+1] instanceof EmptySlotComponent)) {
                    list.add(source.offset(0, 1));
                }

            }

        if( source.getY()-1>=0){

                if (chessBoard[source.getX()][source.getY()-1].getChessColor() != this.getChessColor()||(chessBoard[source.getX()][source.getY()-1] instanceof EmptySlotComponent)) {
                    list.add(source.offset(0, -1));
                }

            }


        if (list.size()==0){return new ArrayList<>();}
        else {return list;}}
}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(char name){super(name);
        if (name=='p'){setChessColor(ChessColor.WHITE);}else {setChessColor(ChessColor.BLACK);}
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list=new ArrayList<>();
        ChessboardPoint source=getSource();
      if (getChessColor()==ChessColor.WHITE){
          if (source.getX()==6&&(chessBoard[source.getX()-1][source.getY()] instanceof EmptySlotComponent)){list.add(source.offset(-1, 0));}
           if (source.getX()==6&&(chessBoard[source.getX()-2][source.getY()] instanceof EmptySlotComponent)){list.add(source.offset(-2, 0));}

              if (source.getX()!=6&&chessBoard[source.getX()-1][source.getY()] instanceof EmptySlotComponent) {list.add(source.offset(-1, 0));}

              if (source.getX()-1>-1 && source.getY()+1<=7){
                  if (chessBoard[source.getX()-1][source.getY()+1].getChessColor() != this.getChessColor() && !(chessBoard[source.getX()-1][source.getY()+1] instanceof EmptySlotComponent)) {
                      list.add(source.offset(-1, 1));}
              }
              if (source.getX()-1>-1 && source.getY()-1>=0){
                  if (chessBoard[source.getX()-1][source.getY()-1].getChessColor() != this.getChessColor() && !(chessBoard[source.getX()-1][source.getY()-1] instanceof EmptySlotComponent)) {
                      list.add(source.offset(-1, -1));}
              }

          }else if (getChessColor()==ChessColor.BLACK){
          if (source.getX()==1&&(chessBoard[source.getX()+1][source.getY()] instanceof EmptySlotComponent)){list.add(source.offset(1, 0));}
     if (source.getX()==1&&(chessBoard[source.getX()+2][source.getY()] instanceof EmptySlotComponent)){list.add(source.offset(2,0));}

              if (source.getX()!=1&&chessBoard[source.getX() + 1][source.getY()] instanceof EmptySlotComponent) {
                  list.add(source.offset(1, 0));
              }

          if (source.getX()+1<=7&& source.getY()+1<=7){
            if (chessBoard[source.getX()+1][source.getY()+1].getChessColor() != this.getChessColor() && !(chessBoard[source.getX()+1][source.getY()+1] instanceof EmptySlotComponent) ) {
                list.add(source.offset(1, 1));}
          }
          if (source.getX()+1<=7 && source.getY()-1>=0){
            if (chessBoard[source.getX()+1][source.getY()-1].getChessColor() != this.getChessColor() && !(chessBoard[source.getX()+1][source.getY()-1] instanceof EmptySlotComponent)) {
                list.add(source.offset(1, -1));}
        }

      }
        if (list.size()==0){return new ArrayList<>();}
        else {return list;}
    }
}
class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(char name){super(name);setChessColor(ChessColor.NONE);}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}