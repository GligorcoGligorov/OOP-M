package T1;

//Да се дефинира класа Person, во која ќе се чуваат информации за:
//
//        име: String
//        salary: int
//        JobPosition: enum(JobPosition)

//        Сите променливи треба да бидат приватни. Соодветно во рамките на класата да се дефинираат:
//
//default конструктор и конструктор со аргументи
//        метод за печатење на информациите за филмот
//        Дополнително да се реализира надворешна функција и да се промени класата со тоа што ќе додадеш и surname vo klasata:
//
//        void printPersonWithHighestSalary(List<Person>) која ќе прима lista od Personi i
//        треба да гo отпечати човекот со наголема сума na salary.
//

// klasa?
// metodi i promenlivi -> private, public i protected

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum JobPosition{
    DIRECTOR,
    MANAGER,
    WORKER
}

public class Person {

    private String name;
    private int salary;
    private JobPosition jobPosition;
    private String surname;

    public Person(String name,String surname, int salary, JobPosition jobPosition) {
        this.name = name;
        this.salary = salary;
        this.jobPosition = jobPosition;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public static Person printPersonWithHighestSalary(List<Person> people){

        //primer za Abstrakcija = list.size(), bufferedReader.readLine()

        Person personWithHighestSalary = null;
        int maxSalary = 0;

        for(int i = 0;i < people.size();i++){
            Person p1 = people.get(i);

            if(p1.getSalary() > maxSalary){
                maxSalary = p1.getSalary();
                personWithHighestSalary = p1;
            }
        }

        return personWithHighestSalary;

    }

    @Override
    public String toString() {
        return "Name: " + name + "\nSalary: " + salary + "\nJobPosition: " + jobPosition;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());


        List<Person> people = new ArrayList<>();


        for(int i = 0;i < n;i++){

            String name = bufferedReader.readLine();
            String surname = bufferedReader.readLine();
            int salary = Integer.parseInt(bufferedReader.readLine());
            JobPosition jobPosition = JobPosition.valueOf(bufferedReader.readLine());

            Person person = new Person(name,surname,salary,jobPosition);
            people.add(person);
        }

        Person personWithHighestSalary = printPersonWithHighestSalary(people);

        System.out.println("Person With Highest Salary:");
        System.out.println(personWithHighestSalary);


//        for(int i = 0;i < people.size();i++){
//            System.out.println("Person id. " + i);
//            System.out.println(people.get(i).toString());
//            System.out.println("------------------");
//        }







    }


}

// INPUT
//3 -> n
//Teo
//Prezime1
//2000
//MANAGER
//Andrej
//Prezime2
//1500
//WORKER
//Mihail
//Prezime3
//3000
//DIRECTOR

//OUTPUT
//Name: Mihail
//Salary: 3000
//JobPosition: DIRECTOR



// INPUT
//2 -> n
//Teo
//Prezime1
//500
//MANAGER
//Andrej
//Prezime2
//1500
//WORKER


//OUTPUT
//Name: Andrej
//Salary: 1500
//JobPosition: WORKER





// Koga treba da pecates povekje lugje ili podatoci od niza [] ili lista List<> -> for()