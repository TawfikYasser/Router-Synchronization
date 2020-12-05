package lap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Device d1=new Device("c1","pc");
        d1.start();
       Device d2=new Device("c2","mobile");
       d2.start();
       d2.stop();
       if (d1.isAlive())
           System.out.println(000);
        if (d2.isAlive())
            System.out.println(444);


    }
}
