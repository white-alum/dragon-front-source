package symbols;

import inter.Id;
import lexer.Token;

import java.util.Hashtable;


/**
 * 符号链表
 */
public class Env {

    private Hashtable table;
    protected Env prev;

    public Env(Env n) {
        table = new Hashtable();
        prev = n;
    }

    public void put(Token w, Id i) {
        table.put(w, i);
    }

    /**
     * 把token映射为对应的Id
     * @param w
     * @return
     */
    public Id get(Token w) {
        for (Env e = this; e != null; e = e.prev) {
            Id found = (Id) (e.table.get(w));
            if (found != null) return found;
        }
        return null;
    }
}
