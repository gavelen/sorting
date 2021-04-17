
import java.util.ArrayList;
import java.util.List;
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
        ArrayList<Integer> numbersSort1 = (ArrayList<Integer>)numbers.clone();
        System.out.println("Сортировка выбором: ");
        selectionSort(numbersSort1);
        System.out.println(numbersSort1);
        ArrayList<Integer> numbersSort2 = (ArrayList<Integer>)numbers.clone();
        System.out.println("Сортировка слиянием: ");
        System.out.println(mergeSort(numbersSort2));

    }


    public static void selectionSort(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            int min = array.get(i);
            int minId = i;
            // System.out.println("min " + min + ". MinID " + minId);
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j) < min) {
                    min = array.get(j);
                    minId = j;
                }
            }
            int temp = array.get(i);
            array.set(i, min);
            array.set(minId, temp);
            //System.out.println("min " + min + ". MinID " + minId);

        }
    }

    public static List<Integer> mergeSort(List<Integer> array) {
        if (array.size() == 1) {
            return array;
        }
        int mid = array.size()/2;
        List<Integer> left = mergeSort(array.subList(0, mid));
        List<Integer> right = mergeSort(array.subList(mid,array.size()));
        List<Integer> temp = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (true) {

            if (left.get(leftIndex) < right.get(rightIndex)) {
                temp.add(left.get(leftIndex));
                leftIndex++;
            }
            else {
                temp.add(right.get(rightIndex));
                rightIndex++;
            }

            if (leftIndex == left.size()) {
                temp.addAll(right.subList(rightIndex, right.size()));
                break;
            }

            if (rightIndex == right.size()) {
                temp.addAll(left.subList(leftIndex, left.size()));
                break;
            }

        }

        return temp;
    }
}
