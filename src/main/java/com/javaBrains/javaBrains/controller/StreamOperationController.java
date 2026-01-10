package com.javaBrains.javaBrains.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class StreamOperationController {


    // 1️⃣ Filter out even numbers from a list
    @GetMapping("/filter-even")
    public List<Integer> filterEvenNumbers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        return list.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
    }

    // 2️⃣ Find the maximum number in a list
    @GetMapping("/max")
    public int findMaxValue() {
        List<Integer> list = Arrays.asList(10, 25, 5, 99, 48);
        return list.stream().max(Integer::compare).orElse(0);
    }

    // 3️⃣ Sort a list in reverse order
    @GetMapping("/reverse-sort")
    public List<Integer> sortReverse() {
        List<Integer> list = Arrays.asList(5, 3, 8, 1);
        return list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    // 4️⃣ Count strings with a specific prefix
    @GetMapping("/count-prefix")
    public long countPrefix() {
        List<String> list = Arrays.asList("apple", "app", "banana", "application");
        return list.stream().filter(s -> s.startsWith("app")).count();
    }

    // 5️⃣ First non-repeated character in a string
    @GetMapping("/first-non-repeated")
    public Character firstNonRepeated() {
        String word = "swiss";
        return word.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> word.indexOf(ch) == word.lastIndexOf(ch))
                .findFirst()
                .orElse(null);
    }

    // 6️⃣ Convert a list of strings to uppercase
    @GetMapping("/uppercase")
    public List<String> convertToUppercase() {
        return Arrays.asList("apple", "ball", "cat")
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    // 7️⃣ Calculate the sum of numbers
    @GetMapping("/sum")
    public int sumNumbers() {
        return Arrays.asList(1, 2, 3, 4).stream().mapToInt(Integer::intValue).sum();
    }

    // 8️⃣ Check if any string matches a condition
    @GetMapping("/any-match")
    public boolean anyMatch() {
        List<String> list = Arrays.asList("hello", "world", "java");
        return list.stream().anyMatch(s -> s.contains("java"));
    }

    // 9️⃣ Find duplicates in a list
    @GetMapping("/duplicates")
    public Set<Integer> findDuplicates() {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 5, 1);
        return list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());
    }

    // 🔟 Group strings by length
    @GetMapping("/group-by-length")
    public Map<Integer, List<String>> groupByLength() {
        List<String> list = Arrays.asList("java", "api", "spring", "boot");
        return list.stream().collect(Collectors.groupingBy(String::length));
    }

    // 1️⃣1️⃣ Flatten a nested list
    @GetMapping("/flatten")
    public List<Integer> flattenList() {
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );
        return nested.stream().flatMap(List::stream).collect(Collectors.toList());
    }

    // 1️⃣2️⃣ Concatenate all strings in a list
    @GetMapping("/concat")
    public String concatenateStrings() {
        return Arrays.asList("Java", "Stream", "API").stream().collect(Collectors.joining(" "));
    }

    // 1️⃣3️⃣ Find the longest string in a list
    @GetMapping("/longest")
    public String longestString() {
        return Arrays.asList("cat", "elephant", "dog").stream()
                .max(Comparator.comparingInt(String::length)).orElse("");
    }

    // 1️⃣4️⃣ Calculate average of numbers
    @GetMapping("/average")
    public double calculateAverage() {
        return Arrays.asList(10, 20, 30).stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    // 1️⃣5️⃣ Convert a list into a map
    @GetMapping("/list-to-map")
    public Map<Integer, String> listToMap() {
        List<String> items = Arrays.asList("A", "B", "C");
        return IntStream.range(0, items.size())
                .boxed()
                .collect(Collectors.toMap(i -> i, items::get));
    }

    // 1️⃣6️⃣ Find the 3rd largest number
    @GetMapping("/third-largest")
    public int thirdLargest() {
        return Arrays.asList(10, 50, 20, 40, 30).stream()
                .sorted(Collections.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(-1);
    }

    // 1️⃣7️⃣ Detect palindromes in a list
    @GetMapping("/palindromes")
    public List<String> palindromes() {
        List<String> list = Arrays.asList("madam", "java", "mom", "apple");
        return list.stream()
                .filter(s -> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString()))
                .collect(Collectors.toList());
    }

    // 1️⃣8️⃣ Reverse each word in a list
    @GetMapping("/reverse-words")
    public List<String> reverseEachWord() {
        List<String> list = Arrays.asList("apple", "ball", "cat");
        return list.stream()
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.toList());
    }

    // 1️⃣9️⃣ Filter a map values greater than 10
    @GetMapping("/filter-map")
    public Map<String, Integer> filterMapValues() {
        Map<String, Integer> map = Map.of("A", 5, "B", 12, "C", 20);
        return map.entrySet().stream()
                .filter(e -> e.getValue() > 10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // 2️⃣0️⃣ Find common elements in two lists
    @GetMapping("/common-elements")
    public List<Integer> commonElements() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4);
        List<Integer> b = Arrays.asList(3, 4, 5);
        return a.stream().filter(b::contains).collect(Collectors.toList());
    }

    // 2️⃣1️⃣ Sum of squares of even numbers
    @GetMapping("/sum-squares-even")
    public int sumOfSquaresEven() {
        return Arrays.asList(1, 2, 3, 4, 5).stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
    }

    // 2️⃣2️⃣ Partition strings: Palindrome vs Non-Palindrome
    @GetMapping("/partition")
    public Map<Boolean, List<String>> partitionStrings() {
        List<String> list = Arrays.asList("madam", "apple", "mom", "dog");
        return list.stream()
                .collect(Collectors.partitioningBy(
                        s -> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString())
                ));
    }

    // 2️⃣3️⃣ Group strings by first character
    @GetMapping("/group-first-char")
    public Map<Character, List<String>> groupByFirstChar() {
        List<String> list = Arrays.asList("apple", "ant", "ball", "bat");
        return list.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
    }

    // 2️⃣4️⃣ Calculate product of numbers
    @GetMapping("/product")
    public int productOfNumbers() {
        return Arrays.asList(2, 3, 4).stream().reduce(1, (a, b) -> a * b);
    }

    // 2️⃣5️⃣ Convert a map to list of keys
    @GetMapping("/map-keys")
    public List<String> mapKeys() {
        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);
        return map.keySet().stream().collect(Collectors.toList());
    }


}
