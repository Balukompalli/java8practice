package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8CodeDecodePractice {
    public static void main(String[] args) {
        EmployeeJava8 employeeJava8 = new EmployeeJava8();

//        Map<Integer, List<EmployeeJava8>> integerListMap = employeeJava8.getEmployeeList().stream()
//                .sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()))
//                ///.limit(3) //top 3 slaries
//                .skip(3) // skip the first 3 highest salaries and print them..
//                .collect(Collectors.groupingBy(employeeJava81 -> employeeJava81.getAge(),
//                        Collectors.toList()));

        Stream<Map.Entry<Integer, List<EmployeeJava8>>> limit = employeeJava8.getEmployeeList().stream().sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()))
                .collect(Collectors.groupingBy(employeeJava81 -> employeeJava81.getAge(), Collectors.toList()))
                .entrySet().stream().sorted((o1, o2) -> o1.getKey() - o2.getKey()).limit(3);
        System.out.println(limit.collect(Collectors.toList()));
    }
}
