public class EqualityTest {
    public static void main(String[] args){
        String x = "park";
        String y = "home";
        String z = x;
        String w = "park";

        System.out.println(x == y);
        System.out.println(x == z);

        System.out.println(x == w);
    }
}