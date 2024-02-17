package T6;

// Threads ni ovozmozuvat poekje programi(Procesi) da rabotat paralelno.
// imame 2 nacini da implementirame Threads: 1. extends Thread. 2. implement Runnable
// Ako ima exception programata ne prestanuva da rabote

import java.util.List;

class NameNotValidException extends Exception{
    public NameNotValidException(String message) {
        super(message + " is not valid name");
    }
}

class ThreadMain extends Thread{

    private int threadNumber;
    private List<String> threadNames = List.of("Ace","Tose","Marko");
    private String threadName;

    public String getThreadName() {
        return threadName;
    }

    public ThreadMain(int threadNumber) {
        this.threadNumber = threadNumber;

        if(threadNumber == 0){
            this.threadName = threadNames.get(0);
        }else if(threadNumber == 1){
            this.threadName = threadNames.get(1);
        }if(threadNumber == 2){
            this.threadName = threadNames.get(2);
        }
    }

    @Override
    public void run() {
        for(int i = 1;i <= 5;i++){
            System.out.println(i + " from Thread: " + threadNumber +  " - Thread Name: " + threadName);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}

public class ThreadMainClass {

    public static void main(String[] args) throws InterruptedException, NameNotValidException {

        for(int i = 0;i < 3;i++){
            System.out.println("Thread " + i + " is starting...");
            ThreadMain threadMain = new ThreadMain(i);
            threadMain.start();
            if(threadMain.getThreadName().equals("Marko")){
                throw new NameNotValidException(threadMain.getThreadName());
            }
//            Thread thread = new Thread(threadMain);
//            thread.start();





        }



    }
}
