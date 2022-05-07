package Run;
import Q1.*;
/**
 * Utility class for generic methods.
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 */
public class Utility {
    /** 
     * function that get array of {@code MyDate} elmements and bubble sort them
     * @param arr[]
     */
    
    /** 
     *  A function that gets an array of {@code Swimmable } elmements in the aquarium and prints them
       <p>
     * @param arr[]
     */
    public static void printAquarium(Swimmable[] arr){
        int n = arr.length;
        System.out.println("Aquarium[type/color/actual size/eat count]:");
        for(int i = 0; i < n; i++){
            System.out.println(arr[i].getAnimalName() + " " + arr[i].getColour() + " " + arr[i].getSize() + " " + arr[i].getEatCount());
        } 
    }
    /**
    * returns a random number in a given range
    *
    * @param min  to be given as {@code int}
    * @param max to be given as {@code int}
    * @return int
    */

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    /** 
     *  A function that gets an array of {@code Swimmable } elmements and amount of food ,and then in a random manner
       <p>
     * @param arr[]
     * @param foodCount
     */
    public static void feedAquaticAnimal(Swimmable[] arr, int foodNum){
        int n = arr.length;
        while(foodNum > 0){
            int i = getRandomNumber(0,n);
            arr[i].eatInc();
            foodNum--;
        }
    }
    /** 
     * Takes an array of {@code Swimmable} objects and returns the amount of sealife smaller in size than the first creature in the array.
     * @param arr - the array to perform the operation on.
     * @return sealife count as an {@code int}.
     */
    public static int countAquaticAnimal(Swimmable[] arr){
        int n = arr.length, count = 0;
        for(int i = 1; i < n; i++){
            if(arr[i].getSize() < arr[0].getSize()) count++;
        } 
        return count;
    }
    /** 
     * Takes an array of {@code Swimmable} objects and sorts them according to their size using bubble sort.
     * @param arr - the array of {@code Swimmable} objects.
     */
    public static void sortAquaticAnimal(Swimmable[] arr){
        Swimmable temp;
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].getSize() > arr[j+1].getSize())
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        printAquarium(arr);
    }
    /**
     * 
     * @param arr which is given to the function, arr[] is an array of locations
     * @param AvgArr is an array which spoused to hold the average temerature for each city
     * @count is the value we return -it is the index of the desired city
     * @return the index of the city which has the highest average temperature
     * @see former functions such as tempIsnull and getAverage
     */
    
}