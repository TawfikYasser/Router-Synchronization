package synchronizationPackage;

public class Device {
	
	
    String name;
    String type;
    
    //static int threadnum=0;

    Device (String name,String type)
    {
        this.name=name;
        this.type=type;
        //this.threadnum=++threadnum;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    

//    @Override
//    public void run() {
//        System.out.println("-Connection "+ threadnum+" : "+name+" performs online activity"); }

}
