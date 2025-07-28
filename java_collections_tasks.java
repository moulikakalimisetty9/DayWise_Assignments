// Java Collections Coding Challenges - Complete Solutions

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsChallenges {
    public static void main(String[] args) {

        // 1. ArrayList Add/Print
        List<String> list = new ArrayList<>();
        list.add("Apple"); list.add("Banana"); list.add("Orange");
        System.out.println("ArrayList: " + list);

        // 2. Collections.max() and min()
        List<Integer> nums = Arrays.asList(10, 25, 5, 60);
        System.out.println("Max: " + Collections.max(nums));
        System.out.println("Min: " + Collections.min(nums));

        // 3. Collections.sort()
        List<String> cities = new ArrayList<>(Arrays.asList("Chennai", "Mumbai", "Delhi"));
        Collections.sort(cities);
        System.out.println("Sorted Cities: " + cities);

        // 4. Alphabetical student list
        List<String> students = new ArrayList<>();
        students.add("Kiran"); students.add("Anu"); students.add("Zara");
        Collections.sort(students);
        System.out.println("Students: " + students);

        // 5. Sum using Collection
        Scanner sc = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        System.out.println("Enter 3 numbers:");
        for (int i = 0; i < 3; i++) inputList.add(sc.nextInt());
        int sum = inputList.stream().mapToInt(i -> i).sum();
        System.out.println("Sum: " + sum);

        // List Interface examples
        List<String> todo = new ArrayList<>(Arrays.asList("Buy Milk", "Code Java", "Call Mom"));
        todo.remove("Buy Milk");
        System.out.println("Pending Tasks: " + todo);

        List<String> cart = new ArrayList<>();
        cart.add("Shoes"); cart.add("Shirt"); cart.remove("Shoes");
        System.out.println("Cart: " + cart);

        // Set Interface
        Set<Integer> rolls = new HashSet<>(Arrays.asList(101, 102, 101));
        System.out.println("Unique Roll Nos: " + rolls);

        Set<String> emails = new HashSet<>(Arrays.asList("a@gmail.com", "b@gmail.com", "a@gmail.com"));
        System.out.println("Emails: " + emails);

        Set<String> citiesInput = new LinkedHashSet<>(Arrays.asList("Hyd", "Chennai", "Hyd"));
        System.out.println("Cities (no duplicates): " + citiesInput);

        // Map Interface
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Ravi", 90); marks.put("Anu", 85);
        marks.put("Anu", 88); // update
        for (Map.Entry<String, Integer> entry : marks.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());

        // Phone directory
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Kiran", "9876543210");
        System.out.println("PhoneBook: " + phoneBook);

        // Word frequency
        String sentence = "hello world hello java";
        Map<String, Integer> freq = new HashMap<>();
        for (String word : sentence.split(" "))
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        System.out.println("Word Frequency: " + freq);

        // Queue Interface
        Queue<String> printQueue = new LinkedList<>();
        printQueue.offer("Doc1"); printQueue.offer("Doc2");
        System.out.println("Printing: " + printQueue.poll());

        PriorityQueue<Integer> taskQueue = new PriorityQueue<>();
        taskQueue.offer(3); taskQueue.offer(1);
        System.out.println("Next Task Priority: " + taskQueue.poll());

        // Iterator
        List<String> books = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));
        Iterator<String> it = books.iterator();
        while (it.hasNext()) {
            String book = it.next();
            if (book.startsWith("P")) it.remove();
        }
        System.out.println("Books after removal: " + books);

        ListIterator<String> li = books.listIterator(books.size());
        System.out.println("Reverse:");
        while (li.hasPrevious()) System.out.println(li.previous());

        // Sorting and Searching
        List<Integer> numsList = Arrays.asList(5, 1, 3, 9);
        Collections.sort(numsList);
        System.out.println("Sorted: " + numsList);
        int idx = Collections.binarySearch(numsList, 3);
        System.out.println("Index of 3: " + idx);

        // Custom Sort (Employee)
        List<Employee> empList = Arrays.asList(
            new Employee("Zara", 100),
            new Employee("Anu", 120)
        );
        empList.sort(Comparator.comparing(Employee::getName));
        System.out.println("Employees Sorted by Name: " + empList);
    }
}

class Employee {
    private String name;
    private int score;

    public Employee(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return name + " - " + score;
    }
}
