import java.util.Arrays;
import java.util.Scanner;

public class Permutator {

	public static void main(String[] args) {
		// variables
		int[] originalSet;
		int[] permutatedSet = null;
		int numberOfCards;
		int permutationCounter = 1;
		
		numberOfCards = setNumberOfCards();
		originalSet = setOriginalSet(numberOfCards);		
		permutatedSet = shuffle(originalSet);
		while (!Arrays.equals(originalSet, permutatedSet)) {
			permutatedSet = shuffle(permutatedSet);
			permutationCounter ++;
		}
		printOriginalSet(originalSet);
		System.out.print("\nIt took " + permutationCounter + " permutations to get back to the original set");		

	}
	
	static int setNumberOfCards() {
		// variables
		Scanner userInput = new Scanner(System.in);		
		System.out.print("Enter number of cards (even): "); // TODO: check if it is a even number
		int chosenNumberOfCards = userInput.nextInt(); // copy value from k to n
		userInput.close(); // close scanner
		return chosenNumberOfCards;
	}
	
	static int[] setOriginalSet(int numberOfCards) {
		int sizeOfSet = numberOfCards;
		int[] originalSet = new int[sizeOfSet];
		for (int i=0; i < sizeOfSet; i++) {
			originalSet[i] = i+1;
		}
		return originalSet;
	}
	
	static int[] shuffle(int[] originalSet) {
		// variables
		int halfLength = originalSet.length/2;
		int setLength = originalSet.length;
		int[] lowSet = new int[halfLength];
		int[] highSet = new int[halfLength];
		int[] permutatedSet = new int[setLength];
		
		// print the set
		for (int i=0; i < setLength; i++) {
			System.out.print(originalSet[i] + "\t"); // print the og_array
		}
		// print line space
		System.out.print(System.lineSeparator());
		
		// the set is split in two halves
		for (int i=0; i < halfLength; i++) {
			int j = i+halfLength; // j is the the number after the half
			lowSet[i] = originalSet[i];
			highSet[i] = originalSet[j];			
		}
		
		// the set is shuffled
		for (int i = setLength, j = 0; i > 0; i -= 2, j += 2) {
			permutatedSet[j] = lowSet[i/2-1]; // take top card of low set first
			permutatedSet[j+1] = highSet[i/2-1]; // then take top card of high set
		}
		
		return permutatedSet;
	}
	
	static void printOriginalSet(int[] originalSet) {
		// print the set
		for (int i=0; i < originalSet.length; i++) {
			System.out.print(originalSet[i] + "\t"); // print the og_array
		}
		// print line space
		System.out.print(System.lineSeparator());	
	}

}
