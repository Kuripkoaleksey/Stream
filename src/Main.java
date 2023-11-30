import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.Arrays.stream;
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a2");
        list.add("a2");
        list.add("a5");
        list.add("a1");
        // 1. Дана коллекция строк { "a1","a2","a3","a2","a2","a5","a1"} вернцть количество вхождений объекта "а1" c помощью streamApi
        long results =list.stream().filter("a1"::equals).count();
        System.out.println("Количество вхождений объекта \"а1\" составляет " + results);
        // 2. Найти элемент в коллекции равный "a3" или вывести "ошибку"
        String result2 = list.stream().filter(n -> n.equals("a3")).findAny().orElse("1");
        System.out.println(result2);
        //3. Вернуть последний элемент коллекции или "empty" если коллекция пуста
        String result3=list.stream ().skip (list.size ()-1).findAny ().orElse ("empty");
        System.out.println(result3);
        //4. Вернуть два элемента начиная со второго элемента коллекции
        List<String> result4 =list.stream ().skip (1).limit(2).collect(Collectors.toList());
        System.out.println(result4);
        //5. Из коллекции имен убрать все повторения и найти среднию длинну имен
        long result5 =list.stream ().distinct().flatMap(s-> stream(s.split(""))).count();
        System.out.println("Средняя длинна имен составляет " + result5/list.stream().distinct().count() + " символа") ;
        //6. Отсортировать коллекцию строк по убыванию и убрать дубликаты
        List<String> result6 =list.stream ().sorted((x,y)->x.compareTo(y)).distinct().collect(Collectors.toList());
        System.out.println(result6);
        //7. Вернуть сумму нечетных чисел или 0
        IntStream resault7 = list.stream().mapToInt(s -> Integer.parseInt(s.substring(1)));
        int sum = resault7.filter(x -> x % 2 != 0).sum();
        System.out.println(sum);
    }}