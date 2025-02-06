import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private List<String> chessboard;
    public static ChessComponent[][] chessComponents11;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        chessComponents11 = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
        chessboard = new ArrayList<>();


        chessComponents11 = chessComponents.clone();
    }

    public void loadChessGame(List<String> chessboard) {
        this.chessboard = new ArrayList<>();
        for (int cot = 0; cot <= 7; cot++) {
            this.chessboard.add(chessboard.get(cot));

        }

        for (int i = 0; i <= 7; i++) {
            char[] chessOnLine = chessboard.get(i).toCharArray();
            for (int p = 0; p <= 7; p++) {
                switch (chessOnLine[p]) {
                    case 'R':
                        chessComponents[i][p] = new RookChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'R');
                        break;
                    case 'N':
                        chessComponents[i][p] = new KnightChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'N');
                        break;
                    case 'B':
                        chessComponents[i][p] = new BishopChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'B');
                        break;
                    case 'Q':
                        chessComponents[i][p] = new QueenChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'Q');
                        break;
                    case 'K':
                        chessComponents[i][p] = new KingChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'K');
                        break;
                    case 'P':
                        chessComponents[i][p] = new PawnChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'P');
                        break;
                    case 'r':
                        chessComponents[i][p] = new RookChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'r');
                        break;
                    case 'n':
                        chessComponents[i][p] = new KnightChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'n');
                        break;
                    case 'b':
                        chessComponents[i][p] = new BishopChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'b');
                        break;
                    case 'q':
                        chessComponents[i][p] = new QueenChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'q');
                        break;
                    case 'k':
                        chessComponents[i][p] = new KingChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'k');
                        break;
                    case 'p':
                        chessComponents[i][p] = new PawnChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'p');
                        break;

                    case '_':
                        chessComponents[i][p] = new EmptySlotComponent(new ChessboardPoint(i, p), ChessColor.NONE, '_');
                        break;
                }
            }

        }

        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
        chessComponents11 = chessComponents.clone();
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        return chessboard.get(0) + "\n" + chessboard.get(1) + "\n" + chessboard.get(2) + "\n" + chessboard.get(3) + "\n" + chessboard.get(4) + "\n" + chessboard.get(5) + "\n" + chessboard.get(6) + "\n" + chessboard.get(7) + "\n";
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    ;

  /*  public String getCapturedChess(ChessColor player) {

        int RLost = 0;
        int NLost = 0;
        int BLost = 0;
        int QLost = 0;
        int KLost = 0;
        int PLost = 0;
        int rLost = 0;
        int nLost = 0;
        int bLost = 0;
        int qLost = 0;
        int kLost = 0;
        int pLost = 0;
        String out = "";

        for (int i = 0; i <= 7; i++) {

            for (int p = 0; p <= 7; p++) {
                switch (chessComponents[i][p].getname()) {
                    case 'R':
                        RLost++;
                        break;
                    case 'N':
                        NLost++;
                        break;
                    case 'B':
                        BLost++;
                        break;
                    case 'Q':
                        QLost++;
                        break;
                    case 'K':
                        KLost++;
                        break;
                    case 'P':
                        PLost++;
                        break;
                    case 'r':
                        rLost++;
                        break;
                    case 'n':
                        nLost++;
                        break;
                    case 'b':
                        bLost++;
                        break;
                    case 'q':
                        qLost++;
                        break;
                    case 'k':
                        kLost++;
                        break;
                    case 'p':
                        pLost++;
                        break;

                }
            }

        }
        if (player.equals(ChessColor.WHITE)) {
            out = "";
            if (1 - kLost != 0) {
                out += "k" + " " + (1 - kLost) + "\n";
            }
            if (1 - qLost != 0) {
                out += "q" + " " + (1 - qLost) + "\n";
            }
            if (2 - rLost != 0) {
                out += "r" + " " + (2 - rLost) + "\n";
            }
            if (2 - bLost != 0) {
                out += "b" + " " + (2 - bLost) + "\n";
            }
            if (2 - nLost != 0) {
                out += "n" + " " + (2 - nLost) + "\n";
            }
            if (8 - pLost != 0) {
                out += "p" + " " + (8 - pLost) + "\n";
            }
            return out;
        } else {
            out = "";
            if (1 - KLost != 0) {
                out += "K" + " " + (1 - KLost) + "\n";
            }
            if (1 - QLost != 0) {
                out += "Q" + " " + (1 - QLost) + "\n";
            }
            if (2 - RLost != 0) {
                out += "R" + " " + (2 - RLost) + "\n";
            }
            if (2 - BLost != 0) {
                out += "B" + " " + (2 - BLost) + "\n";
            }
            if (2 - NLost != 0) {
                out += "N" + " " + (2 - NLost) + "\n";
            }
            if (8 - PLost != 0) {
                out += "P" + " " + (8 - PLost) + "\n";
            }
            return out;
        }
    }*/


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(targetX>7||targetY>7||sourceX>7||sourceY>7||targetX<0||targetY<0||sourceX<0||sourceY<0){return false;}

        if(!chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){return false;}
        if(chessComponents[sourceX][sourceY].getChessColor().equals(chessComponents[targetX][targetY].getChessColor())){return false;}
        for (ChessboardPoint i : chessComponents[sourceX][sourceY].canMoveTo()) {
            if (i.equals(new ChessboardPoint(targetX, targetY))) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
                
                chessComponents[targetX][targetY].changeSource(targetX,targetY);
                return true;
            }
        }
        return false;

    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

  public String getCapturedChess(ChessColor player) {
      int RLost = 0;
      int NLost = 0;
      int BLost = 0;
      int QLost = 0;
      int KLost = 0;
      int PLost = 0;
      int rLost = 0;
      int nLost = 0;
      int bLost = 0;
      int qLost = 0;
      int kLost = 0;
      int pLost = 0;
      String out = "";

      for (int i = 0; i <= 7; i++) {

          for (int p = 0; p <= 7; p++) {
              switch (chessComponents[i][p].getname()) {
                  case 'R':
                      RLost++;
                      break;
                  case 'N':
                      NLost++;
                      break;
                  case 'B':
                      BLost++;
                      break;
                  case 'Q':
                      QLost++;
                      break;
                  case 'K':
                      KLost++;
                      break;
                  case 'P':
                      PLost++;
                      break;
                  case 'r':
                      rLost++;
                      break;
                  case 'n':
                      nLost++;
                      break;
                  case 'b':
                      bLost++;
                      break;
                  case 'q':
                      qLost++;
                      break;
                  case 'k':
                      kLost++;
                      break;
                  case 'p':
                      pLost++;
                      break;

              }
          }

      }
      if (player.equals(ChessColor.WHITE)) {
          out = "";
          if (1-kLost != 0) {
              out += "k" + " " + (1-kLost) + "\n";
          }
          if (1-qLost != 0) {
              out += "q" + " " + (1-qLost) + "\n";
          }
          if (2-rLost != 0) {
              out += "r" + " " + (2-rLost) + "\n";
          }
          if (2-bLost != 0) {
              out += "b" + " " +(2- bLost) + "\n";
          }
          if (2-nLost != 0) {
              out += "n" + " " + (2-nLost) + "\n";
          }
          if (8-pLost != 0) {
              out += "p" + " " + (8-pLost) + "\n";
          }
          return out;
      } else {
          out = "";
          if (1-KLost != 0) {
              out += "K" + " " + (1-KLost) + "\n";
          }
          if (1-QLost != 0) {
              out += "Q" + " " + (1-QLost) + "\n";
          }
          if (2-RLost != 0) {
              out += "R" + " " + (2-RLost) + "\n";
          }
          if (2-BLost != 0) {
              out += "B" + " " +(2- BLost) + "\n";
          }
          if (2-NLost != 0) {
              out += "N" + " " + (2-NLost) + "\n";
          }
          if (8-PLost != 0) {
              out += "P" + " " + (8-PLost) + "\n";
          }
          return out;
      }
  }}
