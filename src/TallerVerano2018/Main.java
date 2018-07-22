import java.lang.Math.*;
import java.lang.Integer.*;

import java.io.*;

public class Main {
	
	/**
	 * 
	 * @author Camilo Barrios <groovy.kmilo@gmail.com>
	 *
	 *	Solucion al problema Census de uva online judge
	 * 	Uso de Segment Tree
	 * 	Problem ID: 11297
	 */

    public static class SegTree{
					
        int minVal;
        int maxVal;
        int start;
        int end;
        SegTree left;
        SegTree right;
        
        SegTree(int start,int end){
            this.start = start;
            this.end = end;
            if(start == end){
                left =  null;
                right = null;
            }
            else{
                int mid = (start + end) / 2;
                left = new SegTree(start,mid);
                right = new SegTree(mid + 1,end);
            }
        }
        void set(int pos,int val){
            if(start == end && start == pos){
                minVal = val;
                maxVal = val;
                return;
            }
            int mid = (start + end) / 2;
            if( pos <= mid)
                left.set(pos,val);
            else
                right.set(pos,val);
           
            minVal = Math.min(left.minVal,right.minVal);
         
            maxVal = Math.max(left.maxVal,right.maxVal);
         
        }
        int getMin(int start,int end){
            if(this.start == start && this.end == end) return minVal;
            int mid = (this.start + this.end)/2;
            if(start <= mid && end <= mid) return left.getMin(start,end);
            if(start > mid && end > mid) return right.getMin(start,end);
            return Math.min(left.getMin(start,mid),right.getMin(mid+1,end));
        }
        int getMax(int start,int end){
            if(this.start == start && this.end == end) return maxVal;
            int mid = (this.start + this.end)/2;
            if(start <= mid && end <= mid) return left.getMax(start,end);
            if(start > mid && end > mid) return right.getMax(start,end);
            return Math.max(left.getMax(start,mid),right.getMax(mid+1,end));
        }
	}
	       
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    int n,q;
	    n = Integer.parseInt(in.readLine().trim().split("[ ]+")[0]);
	    SegTree[] arr = new SegTree[510];
	    for(int i=0;i<500;i++)
	        arr[i] = new SegTree(1,n);
	    for(int i=0;i<n;i++){
	    	String aux[] = in.readLine().trim().split("[ ]+");
	        for(int j=0;j<n;j++){
	            arr[i].set(j+1,Integer.parseInt(aux[j]));
	        }
	    }
	    q = Integer.parseInt(in.readLine().trim());
	    int x,y,val,ans_min,ans_max;
	    int x1,y1,x2,y2;
	    for(int i=0;i<q;i++){
	        String line[] = in.readLine().trim().split("[ ]+");
	        if(line[0].charAt(0) == 'c'){
	            x = Integer.parseInt(line[1]);
	            y = Integer.parseInt(line[2]);
	            val = Integer.parseInt(line[3]);
	            arr[x-1].set(y,val);
	        }
	        else{
	            x1 = Integer.parseInt(line[1]);
	            y1 = Integer.parseInt(line[2]);
	            x2 = Integer.parseInt(line[3]);
	            y2 = Integer.parseInt(line[4]);
	            ans_min = 100000000;
	            ans_max = 0;
	            for(int j=x1-1;j<x2;j++){
	                ans_min = Math.min(ans_min,arr[j].getMin(y1,y2));
	                ans_max = Math.max(ans_max,arr[j].getMax(y1,y2));
	            }
	            System.out.println(ans_max + " " + ans_min);
	        }
	    }
	}
}
