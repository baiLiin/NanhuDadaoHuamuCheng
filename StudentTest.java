package com.tg.arraysdemo1;

import java.util.Arrays;
import java.util.Comparator;

public class StudentTest {
    static void main() {
        Student s1 = new Student("shiroko",18,163);
        Student s2 = new Student("hoshino",17,158);
        Student s3 = new Student("serina",16,164);
        Student s4 = new Student("nonomi",16,164);

        Student[] arr = {s1,s2,s3,s4};

        Arrays.sort(arr,new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                double temp = o1.getHeight() - o2.getHeight();
                temp = temp == 0 ? o1.getAge() - o2.getAge() : temp;
                temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;

                if(temp < 0){
                    return -1;
                } else if (temp == 0){
                    return 0;
                } else {
                    return 1;
                }
            }
        });


        System.out.println(Arrays.toString(arr));
    }
}
