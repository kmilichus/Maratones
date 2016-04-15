import java.util.ArrayList;
import java.util.Collections;

public class nextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	public void nextPermutation(ArrayList<Integer> a) {
	    
	     boolean status;
	    status = nextPerm(a);
	    if (!status)
	        Collections.sort(a);
	    return;
	}
	
	
	
   public boolean nextPerm(ArrayList<Integer> A) {
	    
	    int i = 0;
	    int n = A.size();
	    
	    for (i = n - 2; i >= 0; i--) {
	        if (A.get(i) < A.get(i + 1))
	            break;
	    }
	    
	    if (i == -1)
	        return false;
	   
	    int j = n - 1;
	    
	    for (; j >= i; j--) {
	        if (A.get(j) > A.get(i))
	            break;
	    }
	    
	    swap(A, i, j);
	    
	    i++;
	    int steps = (n - i + 1) / 2;
	    
	    for (int k = 0; k < steps; k++) {
	        swap(A, i + k, n - k - 1);
	    }
	    
	    return true;
	}
	
	public void swap(ArrayList<Integer> A, int i, int j) {
	    int temp = A.get(i);
	    A.set(i, A.get(j));
	    A.set(j, temp);
	}
	
	


}
