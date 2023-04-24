package a출력객체;

public class P {
	public void print(Object o) {
		System.out.println("test");
	    if (o instanceof Integer) System.out.println(o);
	    else if (o instanceof String) System.out.println(o);
	    else if (o instanceof int[]) {
	    	for (int i : (int[]) o) System.out.print(i+" ");
	    	System.out.println();
	    }
	    else if (o instanceof int[][]) {
	        for (int[] arr : (int[][]) o) {
	            for (int i : arr) System.out.print(i+" ");
	            System.out.println();
	        }
	    } 
	    else if (o instanceof String[]) {
	    	for (String s : (String[]) o) System.out.print(s+" ");
	    	System.out.println();
	    }
	    else if (o instanceof String[][]) {
	        for (String[] arr : (String[][]) o) {
	            for (String s : arr) System.out.print(s+" ");
	            System.out.println();
	        }
	    }
	    else System.out.print("Unsupported data type");
	    System.out.println();
	}
}
