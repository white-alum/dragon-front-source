package inter;
import lexer.*; import symbols.*;

/**
 * 表达式节点
 */
public class Expr extends Node {

   /**
    * 运算符
    */
   public Token op;
   /**
    * 类型
    */
   public Type type;

   Expr(Token tok, Type p) { op = tok; type = p; }

   /**
    * 返回一个三地址码的右部，E=E1+E2，返回E1+E2
    * @return
    */
   public Expr gen() { return this; }

   /**
    * 给定表达式E，返回存放E的值的临时变量t
    * @return
    */
   public Expr reduce() { return this; }

   /**
    * 为布尔表达式生成跳转代码
    * @param t
    * @param f
    */
   public void jumping(int t, int f) { emitjumps(toString(), t, f); }

   public void emitjumps(String test, int t, int f) {
      if( t != 0 && f != 0 ) {
         emit("if " + test + " goto L" + t);
         emit("goto L" + f);
      }
      else if( t != 0 ) emit("if " + test + " goto L" + t);
      else if( f != 0 ) emit("iffalse " + test + " goto L" + f);
      else ; // nothing since both t and f fall through
   }
   public String toString() { return op.toString(); }
}
