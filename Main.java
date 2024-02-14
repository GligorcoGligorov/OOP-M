package testAbstact;

//Секое плаќање преку картичка има некои подобности. Имено државата сакајќи
//да го поттикне користењето на картичките, нуди поволни услови за плаќање.
//Да се моделира основна абстрактна класа Kartichka како и класи Master и Maestro кои ја
//наследуваат. Една картичка е опишана со својот идентификациски број, како и
//со салдото на сметката која ја претставува.
//При плаќање со маестро картичка, секоја сума се плаќа со попуст од 5% за
//СИТЕ корисници на маестро картичка. Овој процент е фиксен и не смее да се
//менува!
//При плаќање со мастер картичка, ако лимитот на картичката е над 6000 денари
//тогаш попустот е 10%, наместо стандардните 3% за картички со лимит под 6000
//денари.
//Попустот од 10% е ист за сите корисници, но тој може да биде променет од
//страна на Народна Банка.

// Example usage

class NoMoneyException extends Exception{
    public NoMoneyException(double amount, double saldo) {
        super("Ne mozes da plates " + amount + "den. oti imas na saldoto samo " + saldo +"den.");
    }
}

abstract class Karticka{

    private String id;
    private double saldo;

    public Karticka(String id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }



    public String getId() {
        return id;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract double platiSoKartichka(double paymentAmount) throws NoMoneyException;


}

class Maestro extends Karticka{

    private static final double MAESTROPOPUST = 5.0;

    public Maestro(String id, double saldo) {
        super(id, saldo);
    }

    @Override
    public double platiSoKartichka(double paymentAmount) throws NoMoneyException {

        double popust = 1.0 -  (MAESTROPOPUST/100);
        double cenaSoPopust = paymentAmount * popust;

        if(getSaldo()  < cenaSoPopust){
            throw new NoMoneyException(cenaSoPopust,getSaldo());
        }


        setSaldo(getSaldo() - cenaSoPopust);
        return cenaSoPopust;


    }

    @Override
    public String toString() {
        return "TIP: MESTRO CARD\nID: " + getId() + "\nSALDO: " + getSaldo();
    }
}

class Master extends Karticka{

    private double limit;
    private static int POPUSTNADLIMIT = 10;
    private static final int POPUSTPODLIMIT = 3;

    public Master(String id, double saldo, double limit) {
        super(id, saldo);
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    @Override
    public double platiSoKartichka(double paymentAmount) throws NoMoneyException {

        double popust = 1.0 - (POPUSTPODLIMIT/100.0);
        double cenaSoPopust = paymentAmount * popust;

        if(getSaldo() < cenaSoPopust){
            throw new NoMoneyException(cenaSoPopust,getSaldo());
        }



        if(limit >= 6000){
            popust = 1.0 - (POPUSTNADLIMIT/100.0);
            cenaSoPopust = paymentAmount * popust;
        }

        setSaldo(getSaldo() - cenaSoPopust);
        return cenaSoPopust;

    }

    public static void setPOPUSTNADLIMIT(int POPUSTNADLIMIT) {
        Master.POPUSTNADLIMIT = POPUSTNADLIMIT;
    }

    @Override
    public String toString() {
        return "TIP: MASTER CARD\nID: " + getId() + "\nSALDO: " + getSaldo() + "\nLIMIT: " + getLimit();
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating instances of Master and Maestro cards
        Master masterCard = new Master("123456789", 7000,6100);
        Maestro maestroCard = new Maestro("987654321", 5000);


        // Making payments
        double paymentAmount = 1000;

        double masterCardPayment = 0;
        double maestroCardPayment = 0;
        try {
            masterCardPayment = masterCard.platiSoKartichka(paymentAmount);
            System.out.println("MasterCard Payment: " + masterCardPayment);
            System.out.println(masterCard);

            System.out.println();

            maestroCardPayment = maestroCard.platiSoKartichka(paymentAmount);
            System.out.println("MaestroCard Payment: " + maestroCardPayment);
            System.out.println(maestroCard);

        } catch (NoMoneyException e) {
            System.out.println(e.getMessage());
        }

        // Output the results
        //900
        //950
        //
        //6000
        //4050

        System.out.println();
        Master.setPOPUSTNADLIMIT(5);
        try {
            masterCardPayment = masterCard.platiSoKartichka(1000);
            System.out.println("MasterCard Payment with 5% discount: " + masterCardPayment);
            System.out.println(masterCard);
        } catch (NoMoneyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();



        //950
        //Saldo: 5150

        System.out.println();

        Master masterCardUnderLimit = new Master("123456777", 4000,3000);
        double masterCardUnderLimitPayment = 0;
        try {
            masterCardUnderLimitPayment = masterCardUnderLimit.platiSoKartichka(paymentAmount);
            System.out.println("Master Card Under Limit Payment: " + masterCardUnderLimitPayment);
            System.out.println(masterCardUnderLimit);
        } catch (NoMoneyException e) {
            System.out.println(e.getMessage());
        }


        // 970
        // 3030



        System.out.println();

        double smetka = 7000;
        //6,650
        //-1,650
        Maestro maestroCardWith5k = new Maestro("112233445",5000);
        double maestroWith5kPayment = 0;
        try {
            maestroWith5kPayment = maestroCardWith5k.platiSoKartichka(smetka);
            System.out.println("Maestro Card With 5k Payment: " + maestroWith5kPayment);
            System.out.println(maestroCardWith5k);
        } catch (NoMoneyException e) {
            System.out.println(e.getMessage());
        }




    }
}


