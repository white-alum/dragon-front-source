package inter;
import lexer.*;

/**
 * 语法树节点，node节点只有两个直接子类 {@link Expr} 和 {@link Stmt}
 */
public class Node {

   /**
    * 行号，用于错误报告。
    */
   int lexline = 0;

   Node() { lexline = Lexer.line; }

   void error(String s) { throw new Error("near line "+lexline+": "+s); }

   /**
    * 用于生成三地址码
    */
   static int labels = 0;
   /**
    * 用于生成三地址码 实现L1: 等标签号的递增
    */
   public int newlabel() { return ++labels; }
   /**
    * 用于生成三地址码 的L1: 等标签
    */
   public void emitlabel(int i) { System.out.print("L" + i + ":"); }
   /**
    * 用于生成三地址码
    */
   public void emit(String s) { System.out.println("\t" + s); }
}
