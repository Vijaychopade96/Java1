public class abc {

    static class sstatic{
        static int a = 10;
        static int b = 20;
    }
    class nstatic {
        String c  = "Dog";
        String d = "Cat";
    }
    public static void main(String[]args){
        abc s1=new abc();
        System.out.println(sstatic.a+ sstatic.b);

        abc.nstatic n1=new nstatic();
        System.out.println(n1.c);
        System.out.println(n1.d);
    }
}
