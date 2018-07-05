package microsoft;

public class FindTheSingleElement {

	public static void main(String[] args) {
		int arr[] = {1, 1 ,2, 2 ,3 ,3, 4, 50, 50, 65, 65};
		for(int i =0; i< arr.length; i = i+2 ){
		    if(arr[i]-arr[i+1] !=0 ){
		        System.out.println(arr[i]);
		        break;
		    }
		}
	}

}
