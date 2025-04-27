package inter;
import lexer.*; import symbols.*;

public class Or extends Logical {

   public Or(Token tok, Expr x1, Expr x2) { super(tok, x1, x2); }

   /**
    * 布尔表达式跳转，
    * @param t true 出口
    * @param f false出口
    */
   public void jumping(int t, int f) {
      int label = t != 0 ? t : newlabel();
      expr1.jumping(label, 0);
      expr2.jumping(t,f);
      if( t == 0 ) emitlabel(label);
   }
}
