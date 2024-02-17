package Abtest;

//package Abtest;
//

class Schalter{

    void betaetigen(){
        System.out.println("...");
    }
}

class EinAusSchalter extends Schalter{
    @Override
    void betaetigen() {
        System.out.println("Aaa");
    }
}
class WechselSchalter extends Schalter{


}
public class Auto{

    public static void main(String[] args) {
        Schalter s1, s2;
        s1 = new EinAusSchalter();
        s2 = new WechselSchalter();
        s1.betaetigen();
        s2.betaetigen();
    }
}
