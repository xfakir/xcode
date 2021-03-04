import java.util.ArrayList;

public class HashTest {
    public static void main(String[] args) {
        String key = "aisjdaois";
        int length = 1024;
        //System.out.println(key.hashCode()); //1195817757
        int hash = key.hashCode();
        System.out.println(hash % length);
        System.out.println(hash & (length - 1));

        int resize = length*2;
        System.out.println(hash % resize);
        System.out.println(hash & (resize - 1));

        ArrayList<Integer> integers = new ArrayList<>();

    }
}
