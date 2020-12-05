package lap;

public class Device extends Thread {
    String name;
    String type;
    static int threadnum=0;

    Device (String name,String type)
    {
        this.name=name;
        this.type=type;
        this.threadnum=++threadnum;
    }

    @Override
    public void run() {
        System.out.println("-Connection "+ threadnum+" : "+name+" performs online activity"); }

}
