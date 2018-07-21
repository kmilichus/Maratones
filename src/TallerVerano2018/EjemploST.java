
public class EjemploST {

	static final int INF = Integer.MAX_VALUE;


	public static void main(String[] args) {
        SegmentTree st = new SegmentTree(0, 8);  // 9 numeros

        // asigno el arreglo {-20, 19, 7, 4, -10, 5, 100, 1, 3}
        int[] initialValues = new int[]{-20, 19, 7, 4, -10, 5, 100, 1, 3};
        for(int i = 0; i < initialValues.length; i++)
            st.set(i, initialValues[i]);

        System.out.println("min in [0,8]: " + st.getMin(0, 8));
        System.out.println("min in [1,7]: " + st.getMin(1, 7));
        System.out.println("min in [5,5]: " + st.getMin(5, 5));
        st.set(0, 8);
        System.out.println("min in [0,8]: " + st.getMin(0, 8));

	}


	static class SegmentTree {
		int start, end;
		SegmentTree leftTree, rightTree;
		int minValue;

		public SegmentTree(int start, int end) {
			this.start = start;
			this.end = end;
			this.minValue = INF;
			if(start == end) {  // es una hoja
				leftTree = rightTree = null;
				return;
			}
			int mid = (start + end) / 2;
			leftTree = new SegmentTree(start, mid);
			rightTree = new SegmentTree(mid + 1, end);

		}

		public void set(int pos, int value) {
			// es una hoja, CASO BASE
			if(start == end) {
				minValue = value;
				return;
			}

			int mid = (start + end) / 2;

			if(pos <= mid)
				leftTree.set(pos, value);
			else
				rightTree.set(pos, value);

			minValue = Math.min(leftTree.minValue, rightTree.minValue);

		}
		public int getMin(int low, int high) {

			// [low,high] = [start,end]
			if(start == low && end == high)
				return minValue;

			int mid = (start + end) / 2;

			// [low,high] totalmente incluido en [start,mid]
			if(high <= mid)
				return leftTree.getMin(low, high);

			// [low,high] totalmente incluido en [mid+1,end]
			if(low > mid)
				return rightTree.getMin(low, high);

			// debemos dividir el intervalo en [low,mid] y [mid+1,high]
			int leftMin = leftTree.getMin(low, mid);
			int rightMin = rightTree.getMin(mid+1, high);
			return Math.min(leftMin, rightMin);

		}
	}


}
