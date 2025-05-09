package inter;
import lexer.*; import symbols.*;

public class Op extends Expr {

   public Op(Token tok, Type p)  { super(tok, p); }

   public Expr reduce() {
      //生成一个三地址的右部
      Expr x = gen();
      Temp t = new Temp(type);
      emit( t.toString() + " = " + x.toString() );
      return t;
   }
}
