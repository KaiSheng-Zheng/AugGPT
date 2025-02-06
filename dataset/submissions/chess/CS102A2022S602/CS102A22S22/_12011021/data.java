public class data {
    public static ChessComponent BlackKing=new KingChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'K');
    public static ChessComponent WhiteKing=new KingChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'k');

    public static ChessComponent BlackQueen=new QueenChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'Q');
    public static ChessComponent WhiteQueen=new QueenChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'q');

    public static ChessComponent BlackRook1=new RookChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'R');
    public static ChessComponent BlackRook2=new RookChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'R');
    public static ChessComponent WhiteRook1=new RookChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'r');
    public static ChessComponent WhiteRook2=new RookChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'r');

    public static ChessComponent BlackBishop1=new BishopChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'B');
    public static ChessComponent BlackBishop2=new BishopChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'B');
    public static ChessComponent WhiteBishop1=new BishopChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'b');
    public static ChessComponent WhiteBishop2=new BishopChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'b');

    public static ChessComponent BlackKnight1=new KnightChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'N');
    public static ChessComponent BlackKnight2=new KnightChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'N');
    public static ChessComponent WhiteKnight1=new KnightChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'n');
    public static ChessComponent WhiteKnight2=new KnightChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'n');

    public static ChessComponent BlackPawn1=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'P');
    public static ChessComponent BlackPawn2=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'P');
    public static ChessComponent BlackPawn3=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'P');
    public static ChessComponent BlackPawn4=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'P');
    public static ChessComponent BlackPawn5=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'P');
    public static ChessComponent BlackPawn6=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'P');
    public static ChessComponent BlackPawn7=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'P');
    public static ChessComponent BlackPawn8=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.BLACK,'P');
    public static ChessComponent WhitePawn1=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'p');
    public static ChessComponent WhitePawn2=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'p');
    public static ChessComponent WhitePawn3=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'p');
    public static ChessComponent WhitePawn4=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'p');
    public static ChessComponent WhitePawn5=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'p');
    public static ChessComponent WhitePawn6=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'p');
    public static ChessComponent WhitePawn7=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'p');
    public static ChessComponent WhitePawn8=new PawnChessComponent(new ChessboardPoint(-1,-1),ChessColor.WHITE,'p');

    public static ChessComponent[] allChessComponent=new ChessComponent[]{BlackKing,BlackQueen,BlackRook1,BlackRook2,
        BlackBishop1,BlackBishop2,BlackKnight1,BlackKnight2,BlackPawn1,BlackPawn2,BlackPawn3,BlackPawn4,BlackPawn5,
        BlackPawn6, BlackPawn7,BlackPawn8,WhiteKing,WhiteQueen, WhiteRook1,WhiteRook2,WhiteBishop1, WhiteBishop2,
        WhiteKnight1,WhiteKnight2,WhitePawn1,WhitePawn2,WhitePawn3,WhitePawn4,WhitePawn5,WhitePawn6,WhitePawn7,WhitePawn8};
}