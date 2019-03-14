import java.math.BigDecimal;



//1 top 0
//i =5 from[i]=0 to[top]=i,top++ 1

public class BitVector {
    //如果N恰为BITPERWORD的倍数，那么又要浪费一个int的空间了
    //N取0时，仍会浪费一个int的空间
    //N非0非BITPERWORD的倍数时，最多是最后一个int不完全利用而已
    //i代表需要进行操作的第i个对象
    //i>>SHIFT相当于i/32，将i定位到具体是哪个int中，即a[i>>SHIFT]
    //i&MASK相当于i%32 只保留i的0至4位，即i在int中的第几位，然后把1左移这么多位
    //将a[i>>SHIFT]和(1<<(i&MASK))视需要进行操作
    //同1做或运算或即为位设置
    //同1取反再做与运算即为位清除
    //同1做与，结果为0则原位为0，为1则原位为1
    final int vectorLength = 10000000;
    final int BITPERWORD = 32;
    final int[] vector = new int[(vectorLength - 1) / BITPERWORD + 1];
    final int SHIFT = 5;
    final int MASK = 0x1F; //11111 31

    public BitVector() {
        for (int i : vector) {
            clr(i);
        }
    }

    void clr(int i) {
        vector[i >> SHIFT] &= ~(1 << (i & MASK));
    }

    void set(int i) {
        vector[i >> SHIFT] |= (1 << (i & MASK));
    }

    int test(int i) {
        return vector[i >> SHIFT] & (1 << (i & MASK));
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(2));
//        System.out.println(Integer.toBinaryString(34));
//        System.out.println(Integer.toBinaryString(64));
//        System.out.println(1 & 0x1F);
//        System.out.println(5 & 0x1F);
//        System.out.println(31 & 0x1F);
//        System.out.println(32 & 0x1F);
        BitVector bitVector = new BitVector();
        bitVector.set(1);
        bitVector.set(5);
        bitVector.set(70);
        for (int i = 0; i < 200; i++) {
            System.out.println(bitVector.test(i));
        }
//        System.out.println(10 >> 1);
//        System.out.println(Integer.toBinaryString(5));
//        System.out.println(Integer.toBinaryString(31));
//        System.out.println(0x1F);

        System.out.println("---------------1--------------");

        System.out.println(1 << (1 & 0x1F));
        System.out.println(Integer.toBinaryString(1 << (1 & 0x1F)));
        System.out.println("-------------3----------------");
        int i = (1 << (1 & 0x1F)) | (1 << (3 & 0x1F));
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println("-------------2----------------");
        int i1 = 10 | (1 << (2 & 0x1F));
        System.out.println(i1);
        System.out.println(Integer.toBinaryString(i1));
//        System.out.println(1 << (1 & 0x1F));
//        System.out.println(1 << (0 & 0x1F));
//        System.out.println(1 << (3 & 0x1F));
//        System.out.println(1 << (5 & 0x1F));
//        System.out.println(1 << (31 & 0x1F));
//        System.out.println(1 << (32 & 0x1F));
//        System.out.println(10 >> 5);
//        System.out.println(31 >> 5);
//        System.out.println(31 / 2 / 2 / 2 / 2 / 2);
//        System.out.println(32 >> 5);
//        System.out.println(100 >> 5);
//        System.out.println(100 / 2 / 2 / 2 / 2 / 2);

//101
//421
        System.out.println(new BigDecimal(10000000/32*4/1024/1024));


        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
    }
}
