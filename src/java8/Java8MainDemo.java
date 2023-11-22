package java8;

import javax.xml.namespace.QName;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8MainDemo {
    public static void main(String[] args) {
        EmployeeJava8 employeeJava8 = new EmployeeJava8();

        Map<Integer, Double> integerMap = employeeJava8.getEmployeeList().stream().filter(e -> e.getSalary() > 1000)
                .sorted((o1, o2) -> o1.getAge()- o2.getAge())
                .collect(Collectors.toMap(EmployeeJava8::getId, EmployeeJava8::getSalary));
        System.out.println("Employee Id and Salary : "+integerMap);

        Map<Integer, List<EmployeeJava8>> integerSetMap = employeeJava8.getEmployeeList().stream()
                .collect(Collectors.groupingBy(e-> e.getAge(), HashMap::new, Collectors.toList()));

        System.out.println(integerSetMap);

        Map<Object, Map<Integer, String>> mapMap = employeeJava8.getEmployeeList().stream()
                .collect(Collectors.groupingBy(e-> e.getAge(),  Collectors.toMap(EmployeeJava8::getId,EmployeeJava8::getName)));
        System.out.println(mapMap);

        //age statistics..
        List<Integer> ageList = employeeJava8.getEmployeeList().stream().map(employeeJava81 -> employeeJava81.getAge()).collect(Collectors.toList());
        System.out.println(ageList);
        IntSummaryStatistics intSummaryStatistics = ageList.stream().mapToInt(value -> value).summaryStatistics();
        System.out.println("statistics :: "+intSummaryStatistics);
        System.out.println(intSummaryStatistics.getMax()+" AVG AGE:"+intSummaryStatistics.getAverage());

        //Sorted order og age..
        List<Integer> sortedAgeList = employeeJava8.getEmployeeList().stream().map(employeeJava81 -> employeeJava81.getAge()).sorted()
                .collect(Collectors.toList());
        System.out.println("sortedAgeList :" +sortedAgeList);
        List<Integer> skipList = sortedAgeList.stream().skip(1).limit(3).collect(Collectors.toList());
        System.out.println("second, third youngest "+skipList);

        List<String> stringList = employeeJava8.getEmployeeList().stream()
                .map(employeeJava81 -> employeeJava81.getName())
                .sorted().collect(Collectors.toList());
        System.out.println("sorted names:: "+stringList);

        List<String> upperCaseNames = stringList.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
        System.out.println("upperCaseNames names:: "+upperCaseNames);

        String upperCaseNamesJoining = stringList.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println("upperCaseNamesJoining names:: "+upperCaseNamesJoining);

        Set<String> removedDuplicateNames = employeeJava8.getEmployeeList().stream()
                .map(EmployeeJava8::getName)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("removedDuplicateNames:: "+removedDuplicateNames);

        Map<String, Long> numberOfTimeNameComes= employeeJava8.getEmployeeList().stream().map(EmployeeJava8::getName).collect(Collectors.toList())
                .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("numberOfTimeNameComes: "+numberOfTimeNameComes);

        List<String> onlyDuplicateNameWhichComesMoreThan1 = employeeJava8.getEmployeeList().stream().map(EmployeeJava8::getName).collect(Collectors.toList())
                .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).collect(Collectors.toList());
        System.out.println(" onlyDuplicateNameWhichComesMoreThan1 :" + onlyDuplicateNameWhichComesMoreThan1);

        //find it frequency
        List<String> employeeNamesListObj = employeeJava8.getEmployeeList().stream()
                .map(employeeJava81 -> employeeJava81.getName()).collect(Collectors.toList());

        Set<String> frequencyOfNamesUsingFrequncy = employeeNamesListObj.stream()
                .filter(name -> Collections.frequency(employeeNamesListObj, name) > 1).collect(Collectors.toSet());
        System.out.println("frequencyOfNamesUsingFrequncy : "+frequencyOfNamesUsingFrequncy);

    }
}
