package T3;


import java.util.List;

class GenericClass<T>{
    private List<T> list;

    public GenericClass(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "list=" + list +
                '}';
    }
}

class BasicClass{
    private List<String> names;


    public BasicClass(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public String toString() {
        return "BasicClass{" +
                "names=" + names +
                '}';
    }
}

public class GenericsTest {
    public static void main(String[] args) {
        List<String> names = List.of("name1","name2","name3");
        List<Integer> numbers = List.of(1,2,3,4,5);
        List<Boolean> booleans = List.of(true,false,false);

        GenericClass genericClass1 = new GenericClass<String>(names);
        GenericClass genericClass2 = new GenericClass<Integer>(numbers);
        GenericClass genericClass3 = new GenericClass<Boolean>(booleans);


//        BasicClass basicClass1 = new BasicClass(names);
//        BasicClass basicClass2 = new BasicClass(numbers);
//        BasicClass basicClass3 = new BasicClass(booleans);


        System.out.println(genericClass1);

        System.out.println();

        System.out.println(genericClass2);

        System.out.println();

        System.out.println(genericClass3);

    }
}
