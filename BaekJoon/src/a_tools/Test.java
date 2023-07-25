package a_tools;

// 걸린 시간을 출력하는 툴
public class Test {
	long startTime;
	public Test() {startTime = System.currentTimeMillis();}
    public void end() {
    	long time = System.currentTimeMillis() - startTime;
    	System.out.println("------------------------------------------------------");
    	System.out.println("time\t: " + time + "ms");
    }
}