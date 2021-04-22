import java.util.*;

class BigDiffer { 
    
    Scanner sc = new Scanner( System.in );
    int max;
    int min;
    int bigDiff;

    void readArray() { 
        int[] nums;
        int n;

        System.out.println( "How many values?" );
        n = sc.nextInt();
        nums = new int[n];

        System.out.println( "Enter values" );
        /** @inv i numbers from input read and stored in nums[0..i−1] is */
        for (int i=0; i<nums.length; i++ ){ 
             nums[i] = sc.nextInt();
        } 
        max = nums[0]; //guaranteed to exist
        min = nums[0];
        
        /** @inv max = max(nums[0..i−1]) &&
 
        * min = min(nums[0..i−1]) */
 
        for (int i=1; i<nums.length; i++ ){ 
            if ( nums[i] > max ) {  
                max = nums[i];
        } else if (nums[i]< min) { 
            min = nums[i];
        }  
    }  
    }
    
    void calculateBigDiff() {
    bigDiff = max - min;
}
    void printResult(){
        System.out.println( "The biggest difference in these values is: ");
        System.out.println( bigDiff );
}
    void readAndGiveBigDiff(){
        readArray();
        calculateBigDiff();
        printResult();
    }

    public static void main( String[] a) { 
        ( new BigDiffer() ).readAndGiveBigDiff();
    }  
}