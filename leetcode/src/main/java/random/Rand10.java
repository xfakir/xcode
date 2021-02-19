package random;

public class Rand10 {
    /**
     * 基于这样一个事实 (randX() - 1)*Y + randY() 可以等概率的生成[1, X * Y]范围的随机数
     * @return
     */
    public int rand10() {
        int num;
        do {
            num = (rand7()-1)*7 + rand7();
        } while (num > 40);
        return 1 + num % 10;
    }

    public int rand10_2() {
        while (true) {
            int num = (rand7()-1)*7 + rand7();
            if (num <= 40)  return 1 + num % 10;
            //41-49
            num = (num - 40 -1)*7 + rand7();
            if (num <= 60) return 1 + num % 10;
            //61-63
            num = (num - 60 - 1)*7 + rand7();
            if (num <= 20) return 1 + num % 10;
        }
    }

    private int rand7() {
        return 1;
    }
}
