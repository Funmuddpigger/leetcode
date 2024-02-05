package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2024/2/4 14:36
 */
public class Nim游戏_292_canWinNim {

    public static void main(String[] args) {
        System.out.println(canWinNim(4));
    }

    /**
     * 数学题：谁能一直把 “4个石子” 给到对方，对方就必输。因为剩下4个石子，对方不管怎么拿都会输
     *        由此也可以得出 4的倍数同样如此，相当于把 8 ，16 拆成多个4 来进行同样的游戏
     * @param n
     * @return
     */
    public static boolean canWinNim(int n) {
        return n%4 != 0;
    }
}
