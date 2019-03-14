public class Perf {

    void longa() {
        int i, j;
        for (i = 0; i < 1000000000; i++) {
            j = i;
        }
    }

    void foo2() {
        int i;
        for (i = 0; i < 10; i++) {
            longa();
        }

    }

    void foo1() {
        int i;
        for (i = 0; i < 100; i++) {
            longa();
        }

    }

    public static void main(String[] args) {
        Perf perf = new Perf();
        perf.foo2();
    }
}


