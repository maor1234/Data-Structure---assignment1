import java.util.Arrays;

public class hw1 {
	private static int FindMax(int[] arr, int l, int r){
		int IndexS = l;
		int IndexE = r;
		for (int i = IndexS; i < IndexE; i++) {
			if (arr[i] > arr[IndexS]){
				IndexS=i;
			}
		}
		return IndexS;
	}

	public static void squarerootSort(int[] A1){
		int IndexM = 0;
		while (IndexM != -1){

			int temp = Math.round((int)Math.sqrt(A1.length));
			int [] A2 = new int [temp];
			int counter = 0;

			if (Math.sqrt(A1.length)%1 == 0){ 
				for (int i = 0; i < A2.length; i++) {
					A2[i] = A1[FindMax(A1, temp*i, temp*(i+1))];
				}
			}
			else if (Math.sqrt(A1.length)%1 != 0){
				A2 = new int [temp+1];
				for (int i = 0; i < A2.length-1; i++) {
					A2[i] = A1[FindMax(A1, temp*i, temp*(i+1))];
					counter++;
				}
				int total = temp*counter;
				A2[A2.length-1] = A1[FindMax(A1, total, A1.length)];
			}
			System.out.println("A2 :  " +Arrays.toString(A2));
			System.out.println("A1 :  " +Arrays.toString(A1));		
			IndexM = A2[FindMax(A2, 0, A2.length)];
			A1[FindMax(A1, 0, A1.length)] = -1;
			System.out.println(" ");
		}
	}
	public static void thirdrootSort(int[] A1){
		int IndexM = 0;
		while (IndexM != -1){
			int temp = (int)Math.cbrt(A1.length);
			int [] A2 = new int [(int)Math.pow(temp, 2)];
			int [] A3 = new int[temp];
			int counter = 0;
			if (Math.cbrt(A1.length)%1 == 0){ 
				for (int i = 0; i < A2.length; i++) {
					A2[i] = A1[FindMax(A1, temp*i, temp*(i+1))];
				}
				for (int i = 0; i < A3.length; i++) {
					A3[i] = A2[FindMax(A2, temp*i, temp*(i+1))];
				}
			}
			else if (Math.cbrt(A1.length)%1 != 0){
				int count = 0;
				double help =  Math.ceil(Math.cbrt(A1.length));
				A2 = new int [(int) Math.ceil(A1.length/help)];
				A3 = new int [(int)Math.ceil((double)A2.length/help)];
				for (int i = 0; i < A2.length-1; i++) {
					A2[i] = A1[FindMax(A1, i*(int)help, (i+1)*(int)help)];
					count++;
				}
				int total = count*(int)help;
				int count1 =0;
				A2[A2.length-1] = A1[FindMax(A1, total, A1.length)];
				for (int i = 0; i < A3.length-1; i++) {
					A3[i] = A2[FindMax(A2, i*(int)help, (i+1)*(int)help)];
					count1++;
				}
				int help1 = count1*(int)help;
				A3[A3.length-1] = A2[FindMax(A2, help1, A2.length)];
			}
			System.out.println("A3 :  " +Arrays.toString(A3));	
			System.out.println("A2 :  " +Arrays.toString(A2));		
			System.out.println("A1 :  " +Arrays.toString(A1));	
			
			IndexM = A1[FindMax(A1, 0, A1.length)];
			A1[FindMax(A1, 0, A1.length)] = -1;
			System.out.println(" ");
		}
	}
	public static void main(String[] args) {
		

	}
}