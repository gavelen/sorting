
import java.util.ArrayList;
import java.util.Scanner;

class selectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите несколько чисел : ");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String line = null;

        while (true) {
            line = sc.nextLine();
            if (line.equals("exit")) {
                System.out.println("Все данные введены.");
                break;
            } else {
                numbers.add(Integer.valueOf(line));
            }

        }
        System.out.println(numbers);
        System.out.println("Сортировка выбором: ");
        selectionSort(numbers);
        System.out.println(numbers);
    }


    public static void selectionSort (ArrayList<Integer> array){
        for (int i = 0; i < array.size(); i++) {
                int min = array.get(i);
                int minId = i;
                for (int j = i + 1; j < array.size(); j++) {
                    if (array.get(j) < min) {
                        min = array.get(j);
                        minId = j;
                    }
                }
            int temp = array.get(i);
            array.set(i, min);
            array.set(minId, temp);
        }
    }
}
