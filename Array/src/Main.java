public class Main {

    public static void main(String[] args) {
	// write your code here
        Array<Integer> integerArray = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            integerArray.addLast(i);
        }
        System.out.println(integerArray);
        integerArray.add(1,100);
        System.out.println(integerArray);
    }
}
