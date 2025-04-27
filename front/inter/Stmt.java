package inter;

public class Stmt extends Node {

   public Stmt() { }

   public static Stmt Null = new Stmt();

   /**
    * 处理三地址码生成
    * @param b 语句代码的开始地址
    * @param a 语句代码的后一条指令地址
    */
   public void gen(int b, int a) {} // called with labels begin and after

   /**
    * 处理三地址码生成
    */
   int after = 0;                   // saves label after
   /**
    * 处理三地址码生成
    */
   public static Stmt Enclosing = Stmt.Null;  // used for break stmts
}
