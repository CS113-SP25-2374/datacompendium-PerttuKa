package CS113;

public class Main {
    public static void main(String[] args) {

        ArrayListPK<Integer> testArray = new ArrayListPK<>();

        for (int i = 0; i < 10; i++){
            testArray.add(i);
        }

        testArray.clear();

        System.out.println(testArray);

        System.out.println("Hello world!");
    }
}