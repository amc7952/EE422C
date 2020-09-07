// SortTools.java
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * Austin Chin
 * amc7952
 * 16160
 * Spring 2020
 * Slip days used:
 */

package assignment1;
public class SortTools {
    /**
      * Return whether the first n elements of x are sorted in non-decreasing
      * order.
      * @param x is the array
      * @param n is the size of the input to be checked
      * @return true if array is sorted
      */
    public static boolean isSorted(int[] x, int n) {
    	for(int i=0;i<n-1;i++) {
    		if(x[i]>x[i+1]) {
    			return false;
    		}
    	}
        return true;
    }

    /**
     * Return an index of value v within the first n elements of x.
     * @param x is the array
     * @param n is the size of the input to be checked
     * @param v is the value to be searched for
     * @return any index k such that k < n and x[k] == v, or -1 if no such k exists
     */
    public static int find(int[] x, int n, int v) {
    	for (int i=0;i<n;i++) {
    		if(x[i]==v) {
    			return i;
    		}
    	}
        return -1;
    }

    /**
     * Return a sorted, newly created array containing the first n elements of x
     * and ensuring that v is in the new array.
     * @param x is the array
     * @param n is the number of elements to be copied from x
     * @param v is the value to be added to the new array if necessary
     * @return a new array containing the first n elements of x as well as v
     */
    public static int[] copyAndInsert(int[] x, int n, int v) {
	//If n==0, return y;
		if(n==0) {
			int y[] = new int[1];
			y[0]=v;
			return y;
		}
    	
		//Determine if element already exists in array. If it does, y = x
    	for(int i=0;i<n;i++) {
        	if(x[i]==v) {
        		int y[] = new int[n];
        		for(int j=0;j<n;j++) {
        			y[j] = x[j];
        		}
        		return y;
        	}
        }
    	int y[] = new int[n+1];
    	int j = 0;
		//Copy array x until x[j] is greater than v
    	while(x[j] < v) {
        		y[j] = x[j];
        		j++;
        		if(j==n) {
        			y[j]=v;
        			return y;
        		}
    		}
    		y[j] = v;
    		j++;
    	while(j<n+1) {
    		y[j]=x[j-1];
    		j++;
    	}
        return y;
    }

    /**
     * Insert the value v in the first n elements of x if it is not already
     * there, ensuring those elements are still sorted.
     * @param x is the array
     * @param n is the number of elements in the array
     * @param v is the value to be added
     * @return n if v is already in x, otherwise returns n+1
     */
    public static int insertInPlace(int[] x, int n, int v) {
    	//Determine if element already exists in array. If it does, no changes are required
    	for(int i=0;i<n;i++) {
        	if(x[i]==v) {
        		return n;
        	}
        }
    	int y[] = new int[n+1];
    	y = copyAndInsert(x, n, v);
    	
    	for(int j=0;j<n+1;j++) {
			x[j] = y[j];
		}
    	
        return n+1;
    }

    /**
     * Sort the first n elements of x in-place in non-decreasing order using
     * insertion sort.
     * @param x is the array to be sorted
     * @param n is the number of elements of the array to be sorted
     */
    public static void insertSort(int[] x, int n) {
    	for(int i=0;i<n;i++) {
			int min = i;
    		for(int j=i;j<n;j++) {
    			if(x[min]>x[j]) {
    				min=j;
    			}
    		}
			int temp = x[i];
			x[i] = x[min];
			x[min] = temp;
    	}
    }
}
