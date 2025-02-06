import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private int[][] countOnTheChess = new int[2][6];


    @Override
    public void loadChessGame(List<String> chessboard) {
        char mm;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                countOnTheChess[i][j] = 0;
            }
        }
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                mm = chessboard.get(x).charAt(y);
                switch (mm) {
                    case 'R':
                        chessComponents[x][y] = new RookChessComponent(x, y, ChessColor.BLACK);
                        countOnTheChess[1][2]++;
                        break;

                    case 'r':
                        chessComponents[x][y] = new RookChessComponent(x, y, ChessColor.WHITE);
                        countOnTheChess[0][2]++;
                        break;

                    case 'K':
                        chessComponents[x][y] = new KingChessComponent(x, y, ChessColor.BLACK);
                        countOnTheChess[1][0]++;
                        break;

                    case 'k':
                        chessComponents[x][y] = new KingChessComponent(x, y, ChessColor.WHITE);
                        countOnTheChess[0][0]++;
                        break;

                    case 'B':
                        chessComponents[x][y] = new BishopChessComponent(x, y, ChessColor.BLACK);
                        countOnTheChess[1][3]++;
                        break;

                    case 'b':
                        chessComponents[x][y] = new BishopChessComponent(x, y, ChessColor.WHITE);
                        countOnTheChess[0][3]++;
                        break;

                    case 'N':
                        chessComponents[x][y] = new KnightChessComponent(x, y, ChessColor.BLACK);
                        countOnTheChess[1][4]++;
                        break;

                    case 'n':
                        chessComponents[x][y] = new KnightChessComponent(x, y, ChessColor.WHITE);
                        countOnTheChess[0][4]++;
                        break;

                    case 'Q':
                        chessComponents[x][y] = new QueenChessComponent(x, y, ChessColor.BLACK);
                        countOnTheChess[1][1]++;
                        break;

                    case 'q':
                        chessComponents[x][y] = new QueenChessComponent(x, y, ChessColor.WHITE);
                        countOnTheChess[0][1]++;
                        break;

                    case 'P':
                        chessComponents[x][y] = new PawnChessComponent(x, y, ChessColor.BLACK);
                        countOnTheChess[1][5]++;
                        break;

                    case 'p':
                        chessComponents[x][y] = new PawnChessComponent(x, y, ChessColor.WHITE);
                        countOnTheChess[0][5]++;
                        break;

                    default:
                        chessComponents[x][y] = new EmptySlotComponent(x, y, ChessColor.NONE);
                        break;
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        }
       else if (chessboard.get(8).charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }


    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        ArrayList<String> arrayList = new ArrayList<>();
        char[] djb = new char[8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                djb[j] = chessComponents[i][j].name;
            }
            arrayList.add(String.valueOf(djb));
        }
        StringBuilder theAnswer = new StringBuilder();
        theAnswer.append(arrayList.get(0));
        for (int i = 1; i <= 7; i++) {
            theAnswer.append("\n").append(arrayList.get(i));
        }
        theAnswer.append("\n");
        return String.valueOf(theAnswer);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder theAnswer = new StringBuilder();
        int[][] capturedChess = new int[2][6];
        int[] base = {1, 1, 2, 2, 2, 8};
        char[] blackChess = {'K', 'Q', 'R', 'B', 'N', 'P'};
        char[] whiteChess = {'k', 'q', 'r', 'b', 'n', 'p'};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                capturedChess[i][j] = base[j] - countOnTheChess[i][j];
            }
        }
        if (player.equals(ChessColor.BLACK)) {

            for (int i = 0; i < 6; i++) {
                if (capturedChess[1][i] != 0) {
                    theAnswer.append(blackChess[i]).append(' ').append(capturedChess[1][i]).append("\n");
                }
            }
        }
        if (player.equals(ChessColor.WHITE)) {

            for (int i = 0; i < 6; i++) {
                if (capturedChess[0][i] != 0) {
                    theAnswer.append(whiteChess[i]).append(' ').append(capturedChess[0][i]).append("\n");
                }
            }
        }
        return String.valueOf(theAnswer);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> theList=new ArrayList<>();
     int x=source.getX();
     int y=source.getY();
     theList=chessComponents[x][y].canMoveTo();
     boolean t1;
     boolean t3;
     int targetX;
     int targetY;
      for(int i=0;i<theList.size();i++){
          if(chessComponents[x][y].getCheckPolymorphism()==0) {break;}
          if(chessComponents[x][y].name=='_'){break;}
        targetX=theList.get(i).getX();
        targetY=theList.get(i).getY();
         t1=true;
         t3=checkBlock(x, y, targetX, targetY);
         ChessColor a=chessComponents[targetX][targetY].getChessColor();
         if(a.equals(chessComponents[x][y].getChessColor())){
             t1=false;
         }
         if((!t1)||(!t3)){theList.remove(i);i=i-1;}
      }
    return theList;
    }

    public List<String> SaveChessboard (){
        String text2;
        text2=getChessboardGraph();
        List<String> test=new ArrayList<>();
        char[] demo=new char[65];
        for(int p=0;p<8;p++) {
            for (int i = 0; i <8; i++) {
                demo[8*p+i] = text2.charAt(9*p+i);
            }
        }

        if(currentPlayer.equals(ChessColor.BLACK)){demo[64]='b';}
       else if(currentPlayer.equals(ChessColor.WHITE)){demo[64]='w';}

        for(int i=0;i<8;i++){
            char[] inter=new char[8];
            for(int j=0;j<8;j++){
                inter[j]=demo[8*i+j];
            }
            test.add(String.valueOf(inter));
        }

        test.add(String.valueOf(demo[64]));
        return test;
    }

public boolean checkBlock(int sourceX, int sourceY, int targetX, int targetY){
    boolean t3;
    t3 = true;
    int Mx, mX, My, mY,dpx,dpy;
    Mx = Math.max(sourceX, targetX);
    mX = Math.min(sourceX, targetX);
    My = Math.max(sourceY, targetY);
    mY = Math.min(sourceY, targetY);
    char mm = getChess(sourceX, sourceY).getName();
    switch (mm) {
        case 'R':
        case 'r':
            if (Mx != mX && My == mY) {
            dpx = (targetX - sourceX) / (Mx - mX);
            for (int i = 1; i < (Mx - mX); i++) {
                if (!getChess(sourceX + i * dpx, sourceY).getChessColor().equals(ChessColor.NONE)) {
                    t3 = false;
                    break;
                }
            }
        }
            if (mY != My && mX == Mx) {
                dpy = (targetY - sourceY) / (My - mY);
                for (int i = 1; i < (My - mY); i++) {
                    if (!getChess(sourceX, sourceY + dpy * i).getChessColor().equals(ChessColor.NONE)) {
                        t3 = false;
                        break;
                    }
                }
            }
            break;

        case 'B':
        case 'b':
            if ((Mx != mX) && (mY != My)) {
                dpx = (targetX - sourceX) / (Mx - mX);
                dpy = (targetY - sourceY) / (My - mY);
                int times;
                if(Mx-mX>=My-mY){times=My-mY;}
                else times=Mx-mX;

                for (int i = 1; i <times; i++) {
                    if (!(chessComponents[sourceX+(dpx*i)][sourceY+(dpy*i)].getChessColor().equals(ChessColor.NONE))) {
                        t3 = false;
                        break;
                    }
                }

            }
            break;
        case 'Q':
        case 'q':
            if ((Mx != mX) &&( My == mY)) {
            dpx = (targetX - sourceX) / (Mx - mX);
            for (int i = 1; i < (Mx - mX); i++) {
                if (!getChess(sourceX + i * dpx, sourceY).getChessColor().equals(ChessColor.NONE)) {
                    t3 = false;
                    break;
                }
            }
        }
            if ((mY != My) &&( mX == Mx)) {
                dpy = (targetY - sourceY) / (My - mY);
                for (int i = 1; i < (My - mY); i++) {
                    if (!(getChess(sourceX, sourceY + dpy * i).getChessColor().equals(ChessColor.NONE))) {
                        t3 = false;
                        break;
                    }
                }
            }
            if ((Mx != mX) && (mY != My)) {
                dpx = (targetX - sourceX) / (Mx - mX);
                dpy = (targetY - sourceY) / (My - mY);
                int times;
                if(Mx-mX>=My-mY){times=My-mY;}
                else times=Mx-mX;

                for (int i = 1; i <times; i++) {
                    if (!(chessComponents[sourceX+(dpx*i)][sourceY+(dpy*i)].getChessColor().equals(ChessColor.NONE))) {
                        t3 = false;
                        break;
                    }
                }

            }
            if((Mx==mX)&&(My==mY)) {
                t3 = false;
            }
            break;

        case'P':
           if ((targetY == sourceY + 1) && (targetX == sourceX + 1)){
               t3=false;
           if(chessComponents[targetX][targetY].getChessColor().equals(ChessColor.WHITE)){t3=true;}
           }
            if ((targetY == sourceY -1) && (targetX == sourceX + 1)){
                t3=false;
            if(chessComponents[targetX][targetY].getChessColor().equals(ChessColor.WHITE)){t3=true;}
            }
            if(sourceX==1){
                            if((targetX==3)&&(sourceY==targetY)) {
                                t3 = false;
                                char pp1=chessComponents[2][sourceY].name;
                                char pp2=chessComponents[3][sourceY].name;
                                if(pp1=='_'&&pp2=='_')t3=true;
                            }}
            if((targetX==sourceX+1)&&(sourceY==targetY)){
                if(chessComponents[targetX][targetY].getName()!='_')t3=false;
            }
            break;

        case 'p':
            if(sourceX==6){
                            if((targetX==4)&&(sourceY==targetY)) {
                                t3 = false;
                                char pp1=chessComponents[4][sourceY].name;
                                char pp2=chessComponents[5][sourceY].name;
                                if(pp1=='_'&&pp2=='_')t3=true;
                        }}
            if ((targetY == sourceY + 1) && (targetX == sourceX -1)){
                t3=false;
            if(chessComponents[targetX][targetY].getChessColor().equals(ChessColor.BLACK)){t3=true;}
            }
            if ((targetY == sourceY -1) && (targetX == sourceX - 1)){
                t3=false;
            if(chessComponents[targetX][targetY].getChessColor().equals(ChessColor.BLACK)){t3=true;}
            }
            if((targetX==sourceX-1)&&(sourceY==targetY)){
                if(chessComponents[targetX][targetY].name!='_')t3=false;
            }break;

        default:
            break;
    }//for t3
    return t3;
}

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {;
        String c="("+targetX+","+targetY+")";
        boolean t0=false;
        boolean t1=false;
        boolean t2=true;
        boolean t3=true;
        boolean ans=false;
        ChessColor ss=chessComponents[sourceX][sourceY].getChessColor();
        ChessColor tt=currentPlayer;
        ChessColor mm=chessComponents[targetX][targetY].getChessColor();
        if(tt.equals(ChessColor.NONE)){t3=false;}
        if(tt.equals(ss)){t0=true;}
        if(mm.equals(ss)){t2=false;}

        List<ChessboardPoint> theList=new ArrayList<>();
        ArrayList<String> ctb=new ArrayList<>();

        theList=getCanMovePoints(new ChessboardPoint(sourceX,sourceY));

        for (ChessboardPoint chessboardPoint : theList) {
            ctb.add(chessboardPoint.toString());
        }

        for (String s : ctb) {
            if (c.equals(s)) {
                t1 = true;
                break;
            }
        }

        if(t1&&t2&&t0&&t3){ans=true;}

        if(ans){
            ChessColor dd=ChessColor.NONE;
            chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY);
            loadChessGame(SaveChessboard());
            if(currentPlayer.equals(ChessColor.BLACK)){dd=ChessColor.WHITE;}
           else if(currentPlayer.equals(ChessColor.WHITE)){dd=ChessColor.BLACK;}
            currentPlayer=dd;
        }

        return ans;
    }


}
