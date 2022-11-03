import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionTricks {
    private static void playWithArrays() {
        int[] a = {1, 2, 3};
        int[][] b = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        String[] names = {"James Harden", "Kevin Durant", "Kyrie Irving"};

        // 数组求和
        System.out.println(
                Arrays.stream(a)
                        .sum()
        );

        // 二维数组，找行和最大值
        System.out.println(
                Arrays.stream(b)
                        .map(row -> Arrays.stream(row).sum())
                        .max(Integer::compareTo).get()
        );

        // 二维数组求和
        System.out.println(
                Arrays.stream(b)
                        .flatMapToInt(row -> Arrays.stream(row))
                        .sum()
        );

        Arrays.stream(names).forEach(System.out::println);

        IntStream.range(0, names.length)
                .mapToObj(i -> String.format("#%d: %s %d", i, names[i], names[i].length()))
                .forEach(System.out::println);

        System.out.println(Arrays.asList(a));

        List<String> nameList = Arrays.asList(names);
        System.out.println(nameList);

        List<Integer> aToList =
                Arrays.stream(a)
                        .boxed()
                        .collect(Collectors.toList());
        System.out.println(aToList);

        String[] nameArray = nameList.toArray(String[]::new);
        Arrays.stream(nameArray).forEach(System.out::println);

        int[] aArray = aToList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(aArray).forEach(System.out::println);
    }

    private static void playWithNLists() {
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("James", "Harden"),
                Arrays.asList("Kevin", "Durant"),
                Arrays.asList("Kyrie", "Irving")
        );

        List<List<Integer>> ageHeights = List.of(
                List.of(35, 200),
                List.of(32, 211),
                List.of(30, 192)
        );

        System.out.println(lists);
        System.out.println(ageHeights);

        String[][] nameArrays = lists.stream()
                .map(row -> row.toArray(String[]::new))
                .toArray(String[][]::new);
        System.out.println(Arrays.deepToString(nameArrays));

        int[][] ageArrays = ageHeights.stream()
                .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        System.out.println(Arrays.deepToString(ageArrays));

        List<String> nameList = Arrays.stream(nameArrays)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(nameList);

        List<Integer> ageList = Arrays.stream(ageArrays)
                .flatMapToInt(Arrays::stream)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(ageList);

        List<List<String>> nameNList = Arrays.stream(nameArrays)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        System.out.println(nameNList);

        List<List<Integer>> ageNList = Arrays.stream(ageArrays)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(ageNList);
    }

    private static void playWithMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Guard", "James Harden");
        map.put("Forward", "Kevin Durant");
        map.put("Point Guard", "Kyrie Irving");

        map.forEach(
                (k, v) -> System.out.println(k + " -> " + v)
        );

        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        map.keySet().forEach(System.out::println);

        map.values().stream().forEach(System.out::println);

        List<String> guards = map.entrySet().stream()
                .filter(entry -> entry.getKey().contains("Guard"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println(guards);

        List<String> positions = map.keySet().stream().collect(Collectors.toList());
        System.out.println(positions);

        List<String> players = map.values().stream().collect(Collectors.toList());
        System.out.println(players);

        String[] keyArray = map.keySet().toArray(String[]::new);
        System.out.println(Arrays.deepToString(keyArray));
        String[] valueArray = map.values().toArray(String[]::new);
        System.out.println(Arrays.deepToString(valueArray));
    }

    private static void playListOfArrays() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {1, 2});
        list.add(new int[] {3, 4});
        list.add(new int[] {5, 6});

        int[][] matrix = list.stream().toArray(int[][]::new);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        playWithArrays();

        playWithNLists();

        playWithMap();

        playListOfArrays();
    }
}
