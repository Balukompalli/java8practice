import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import Comparator.*;
import  Thread.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {


        List<Integer> nums = Arrays.asList(4,8,3,6,9,10);

        nums.stream().filter(n -> n*2==0).sorted()
                .map(n -> n*3).forEach(System.out::println);
        //nums.stream().filter(oddPredicate).sorted().map(n -> n*3).forEach(System.out::println);

        Stream.iterate(new int[] {0,1},
                        t-> new int[] {t[1],t[0]+t[1]})
                .limit(10).forEach(x->System.out.println(x[0]));

        Stream.iterate(new int[]{0,1}, t -> new  int[]{t[1],t[0]+t[1]}).limit(5).forEach(n-> System.out.println(n[0]));
        System.out.println("----------------");

        List<String> strList=Arrays.asList("abc","","abcd","","defg","jkA","","","aa aa");
        long count=strList.stream().filter(x->x.isEmpty()).count();
        System.out.println(count);

        long num=strList.stream().filter(x->x.length()>3).count();
        System.out.println(num);

        long startsWithA=strList.stream().filter(x->x.startsWith("a")).count();
        System.out.println(startsWithA);

        long endsWithA=strList.stream().filter(x->x.endsWith("a")).count();
        System.out.println(endsWithA);

        List<String> strList1=Arrays.asList("abc","abc","abcd","code","code","decode");
        Set<String> names=new HashSet<String>();
        Set<String> duplicateNames=strList1.stream().filter(name -> !names.add(name))
                .collect(Collectors.toSet());
        duplicateNames.forEach(n->System.out.println(n));

//		Map<String, Long> nameCount=strList1.stream().
//				collect(Collectors.groupingBy(Function.identity(),
//				Collectors.counting()));
//		System.out.println("Count is ::"+nameCount);
//
//		Set<String> singleName= nameCount.entrySet().stream()
//				.filter(entry -> entry.getValue()>1)
//		.map(entry -> entry.getKey()).collect(Collectors.toSet());
//-----------
        Set<String> singleName1= strList1.stream().
                collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting())).entrySet().stream()
                .filter(entry -> entry.getValue()>1)
                .map(Map.Entry::getKey).collect(Collectors.toSet());

        System.out.println("==================");
        //Set<String> stringSet =
        Set<String> stringSet= strList1.stream()
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet().stream()
                        .filter(stringLongEntry -> stringLongEntry.getValue()>1)
                        .map(stringLongEntry -> stringLongEntry.getKey()+":--->"+stringLongEntry.getValue())
                                .collect(Collectors.toSet());
    //.forEach(stringLongEntry -> System.out.println(stringLongEntry));
        System.out.println("stringSet :"+stringSet);
        System.out.println(""+strList1.stream().filter(s -> Collections.frequency(strList1, s)>1).collect(Collectors.toSet()));
        System.out.println("==================");

        System.out.println("singleName is ::"+singleName1);

        Set<String> namess=strList1.stream().
                filter(name-> Collections.frequency(strList1, name)>1).
                collect(Collectors.toSet());



        System.out.println("namess :: "+namess);
        Address address = new Address("bng","1111");
        Employee employee = new Employee(1,"balu",new Date(),
                Arrays.stream(new String[]{"1234","23435"}).collect(Collectors.toList()), address);

        employee.getAddress().setCity("pune");
        employee.getAddress().setZip("1222");
        employee.getDoj().setTime(12);
        employee.getMobile().add("9020");
        System.out.println(employee);

        String strPwd = "ab";
         char[] chars= new char[]{'a','b'};
        System.out.println(strPwd+":"+chars);

        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("1");
        System.out.println("List allowed duplicates:"+list);


        final Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("1");
        System.out.println("set Not allowed duplicates:"+set);

        CustomArrayList customArrayList = new CustomArrayList();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(1);
        System.out.println("List not allowed duplicates:"+customArrayList);

        CustomHashSet customHashSet = new CustomHashSet();
        customHashSet.add(1);
        customHashSet.add(2);
        customHashSet.add(3);
        customHashSet.add(1);
        System.out.println("Set allowed duplicates:"+customHashSet);

        Student student1 = new Student(1,"balu");
        Student student2 = new Student(2,"siva");
        Student student3 = new Student(1,"prasad");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        System.out.println("before sort studentList :"+studentList);
        Collections.sort(studentList);
        System.out.println("After sort studentList :"+studentList);

        System.out.println( " ---------------- ");
        System.out.println("before Id Comparator sort studentList :"+studentList);
        Collections.sort(studentList, new IdComparator());
        System.out.println("After Id Comparator sort studentList :"+studentList);


        System.out.println("before name Comparator sort studentList :"+studentList);
        Collections.sort(studentList, new StudentNameComparator());
        System.out.println("After name comparator sort studentList :"+studentList);

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);

        System.out.println(studentSet);

        //ConcurrentModificationException ..
        List<String> stringList = new ArrayList<>();


        stringList.add("a");
        stringList.add("b");

        Iterator iterator = stringList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            //root cause of concurrentModification exception...
            //  stringList.add("d");
        }

        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add("a");
        copyOnWriteArrayList.add("b");

        Iterator copyOnWirteArrayListIterator = copyOnWriteArrayList.iterator();
        while (copyOnWirteArrayListIterator.hasNext()) {
            //not giving concurrentModification exception...
            copyOnWriteArrayList.add("d");
            System.out.println(copyOnWirteArrayListIterator.next());

        }

        System.out.println("---------------------");

        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1,"one");
        hashMap.put(2,"two");

        Iterator hashMapIterator = hashMap.keySet().iterator();
        while (hashMapIterator.hasNext()) {
            Integer key = (Integer)hashMapIterator.next();
            System.out.println(key+":"+hashMap.get(key));
           //root cause of concurrentModification exception...
            // hashMap.put(3, "three");
        }

        System.out.println("---------------------");

        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put(1,"one");
        concurrentHashMap.put(2,"two");

        for (Integer key : concurrentHashMap.keySet()) {
            System.out.println(key + ":" + concurrentHashMap.get(key));
            //resolve the root cause of concurrentModification exception...No clone copy provided so key 3 is also printing..
            concurrentHashMap.put(3, "three");
        }

        Map<String, String> mapObj =  new TreeMap<>();
        mapObj.put("a","abc");
        mapObj.put("d","def");
        mapObj.put("m","mno");
        mapObj.put("c","cde");
        mapObj.put("b","bcd");
        mapObj.put("f","fgh");

        System.out.println("Default sorting by treemap :: "+mapObj);




    }

}