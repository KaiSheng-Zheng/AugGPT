public class chess {

  public static ChessboardPoint defaultSource=new ChessboardPoint(-1,-1);
//    public static ChessboardPoint Source1=new ChessboardPoint(1,1);
//  public static ChessboardPoint Source2=new ChessboardPoint(2,1);
//  public static ChessboardPoint Source3=new ChessboardPoint(3,1);
//  public static ChessboardPoint Source4=new ChessboardPoint(4,1);
//  public static ChessboardPoint Source5=new ChessboardPoint(5,1);
//  public static ChessboardPoint Source6=new ChessboardPoint(6,1);
//  public static ChessboardPoint Source7=new ChessboardPoint(7,1);


  public static ChessComponent wKing=new KingChessComponent(defaultSource,ChessColor.WHITE,'k');
  public static ChessComponent bKing=new KingChessComponent(defaultSource,ChessColor.BLACK,'K');

  public static ChessComponent wQueen=new QueenChessComponent(defaultSource,ChessColor.WHITE,'q');
  public static ChessComponent bQueen=new QueenChessComponent(defaultSource,ChessColor.BLACK,'Q');

  public static ChessComponent wRook1=new RookChessComponent(defaultSource,ChessColor.WHITE,'r');
  public static ChessComponent wRook2=new RookChessComponent(defaultSource,ChessColor.WHITE,'r');
  public static ChessComponent bRook1=new RookChessComponent(defaultSource,ChessColor.BLACK,'R');
  public static ChessComponent bRook2=new RookChessComponent(defaultSource,ChessColor.BLACK,'R');


  public static ChessComponent wKnight1=new KnightChessComponent(defaultSource,ChessColor.WHITE,'n');
  public static ChessComponent wKnight2=new KnightChessComponent(defaultSource,ChessColor.WHITE,'n');
  public static ChessComponent bKnight1=new KnightChessComponent(defaultSource,ChessColor.BLACK,'N');
  public static ChessComponent bKnight2=new KnightChessComponent(defaultSource,ChessColor.BLACK,'N');

  public static ChessComponent wBishop1=new BishopChessComponent(defaultSource,ChessColor.WHITE,'b');
  public static ChessComponent wBishop2=new BishopChessComponent(defaultSource,ChessColor.WHITE,'b');
  public static ChessComponent bBishop1=new BishopChessComponent(defaultSource,ChessColor.BLACK,'B');
  public static ChessComponent bBishop2=new BishopChessComponent(defaultSource,ChessColor.BLACK,'B');

 public  static ChessComponent wPawn1=new PawnChessComponent(defaultSource,ChessColor.WHITE,'p');
  public static ChessComponent wPawn2=new PawnChessComponent(defaultSource,ChessColor.WHITE,'p');
  public static ChessComponent wPawn3=new PawnChessComponent(defaultSource,ChessColor.WHITE,'p');
  public static ChessComponent wPawn4=new PawnChessComponent(defaultSource,ChessColor.WHITE,'p');
  public static ChessComponent wPawn5=new PawnChessComponent(defaultSource,ChessColor.WHITE,'p');
  public static ChessComponent wPawn6=new PawnChessComponent(defaultSource,ChessColor.WHITE,'p');
  public static  ChessComponent wPawn7=new PawnChessComponent(defaultSource,ChessColor.WHITE,'p');
  public static  ChessComponent wPawn8=new PawnChessComponent(defaultSource,ChessColor.WHITE,'p');

  public static  ChessComponent bPawn1=new PawnChessComponent(defaultSource,ChessColor.BLACK,'P');
  public static  ChessComponent bPawn2=new PawnChessComponent(defaultSource,ChessColor.BLACK,'P');
  public static  ChessComponent bPawn3=new PawnChessComponent(defaultSource,ChessColor.BLACK,'P');
  public  static ChessComponent bPawn4=new PawnChessComponent(defaultSource,ChessColor.BLACK,'P');
  public static  ChessComponent bPawn5=new PawnChessComponent(defaultSource,ChessColor.BLACK,'P');
  public  static ChessComponent bPawn6=new PawnChessComponent(defaultSource,ChessColor.BLACK,'P');
  public  static ChessComponent bPawn7=new PawnChessComponent(defaultSource,ChessColor.BLACK,'P');
  public  static ChessComponent bPawn8=new PawnChessComponent(defaultSource,ChessColor.BLACK,'P');

                                          //0   1      2        3      4     5      6      7      8        9       10        11       12        13     14       15        16     17     18     19     20    21     22     23     24     25      26    27     28      29    30      31
//public static ChessComponent[] chessList={wKing,bKing,wQueen,bQueen,wRook1,wRook2,bRook1,bRook2,wKnight1,wKnight2,bKnight1,bKnight2,wBishop1,wBishop2,bBishop1,bBishop2,wPawn1,wPawn2,wPawn3,wPawn4,wPawn5,wPawn6,wPawn7,wPawn8,bPawn1,bPawn2,bPawn3,bPawn4,bPawn5,bPawn6,bPawn7,bPawn8};

    public static ChessComponent[] pawnList={wPawn1,wPawn2,wPawn3,wPawn4,wPawn5,wPawn6,wPawn7,wPawn8,bPawn1,bPawn2,bPawn3,bPawn4,bPawn5,bPawn6,bPawn7,bPawn8};






}
