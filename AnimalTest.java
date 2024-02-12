package T5;

abstract class Animal{

    public abstract void sleep();

    public void bark() {
        System.out.println("aff aff");
    }


}

class Dog extends Animal{

    private String name;

    public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }


    @Override
    public void sleep() {
        System.out.println("Zzz");
    }
}

abstract class Presmetki{

    abstract int zbir(int a,int b);
    abstract int odzemi(int a,int b);

    public float presmetkaPoeni(int a, int b){
        float rez = (float) ((a+b)/(2*1.0));
        return rez;
    }
}



class Broj extends Presmetki{

    @Override
    int zbir(int a, int b) {
        return a+b;
    }

    @Override
    int odzemi(int a, int b) {
        return a-b;
    }

//    @Override
//    public float presmetkaPoeni(int a, int b) {
//        return a+a;
//    }
}

class Broj2 extends Presmetki{

    @Override
    int zbir(int a, int b) {
        return (a+a) + (b+b);
    }

    @Override
    int odzemi(int a, int b) {
        return b-a;
    }
}


public class AnimalTest {
    public static void main(String[] args) {
        Broj broj = new Broj();
        System.out.println("Presmetki za Broj1 Class: "+ broj.zbir(1,2));

        Broj2 broj2 = new Broj2();

        System.out.println("Presmetki za Broj2 Class: " + broj2.zbir(1,2));

        System.out.println("Class Broj Presmetka poeni: " + broj.presmetkaPoeni(2,3));
        System.out.println("Class Broj2 Presmetka poeni: " + broj2.presmetkaPoeni(2,3));

    }
}
