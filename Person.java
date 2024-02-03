package T1;

//Да се дефинира класа Person, во која ќе се чуваат информации за:
//
//        име: String
//        salary: int
//        JobPosition: enum(JobPosition)

//        Сите променливи треба да бидат приватни. Соодветно во рамките на класата да се дефинираат:
//
//default конструктор и конструктор со аргументи
//        метод за печатење на информациите за Person
//        Дополнително да се реализира надворешна функција и да се промени класата со тоа што ќе додадеш и surname vo klasata:
//
//        void printPersonWithHighestSalary(List<Person>) која ќе прима lista od Personi i
//        треба да гo отпечати човекот со наголема сума na salary.
//

// klasa?
// metodi i promenlivi -> private, public i protected

// Koga zboruvame za kreiranje na Objekt(Klasa) gledame vo Constructor
// Koga zboruvame za printanje gledame vo toString
// Koga praveme default constructor, sekogas treba da imame setteri za atributite
// BufferedReader - Go koristeme za da citame i zapisanje podatoci od: vlez,file,input.

import java.io.BufferedReader;
import java.io.FileInputStream;
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

class KFCWorker{
    private String name;
    private String surname;
    private JobPosition jobPosition;

    public KFCWorker(String name, String surname, JobPosition jobPosition) {
        this.name = name;
        this.surname = surname;
        this.jobPosition = jobPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    @Override
    public String toString() {
        return "KFCWorker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", jobPosition=" + jobPosition +
                '}';
    }
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

    public Person(){
        this.name = "Teo";
        this.salary = 0;
        this.jobPosition = JobPosition.WORKER;
        this.surname =  "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setSurname(String surname) {
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
        return "Name: " + name +"\nSurnname: " + surname + "\nSalary: " + salary + "\nJobPosition: " + jobPosition;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // procitaj od terminal i zacuvaj ja vrednosta vo promenlivata n
        int n = Integer.parseInt(bufferedReader.readLine());


        List<Person> people = new ArrayList<>();

//        Person p = new Person("asd","asd",243,JobPosition.DIRECTOR);
//        Person p2 = new Person();
//        p2.setName("Mihail");
//        p2.setSurname("Mijalov");
//        p2.salary = 1000;
//        System.out.println(p);
//        System.out.println();
//        System.out.println(p2);


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

        //KFC
        KFCWorker kfcWorker = new KFCWorker("w1","s1",JobPosition.WORKER);
        System.out.println(kfcWorker);







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