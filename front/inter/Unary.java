package inter;
import lexer.*; import symbols.*;

/**
 * 单目运算符表达式
 */
public class Unary extends Op {

   public Expr expr;

   public Unary(Token tok, Expr x) {    // handles minus, for ! see Not
      super(tok, null);  expr = x;
      type = Type.max(Type.Int, expr.type);
      if (type == null ) error("type error");
   }

   public Expr gen() { return new Unary(op, expr.reduce()); }

   public String toString() { return op.toString()+" "+expr.toString(); }
}
