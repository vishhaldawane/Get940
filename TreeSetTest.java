import java.util.Iterator;
import java.util.TreeSet;

class ChemicalElement implements Comparable <ChemicalElement>
{
	int atomicNumber;
	String atomicName;
	String atomicFormula;
	float atomicWeight;
	
	public int compareTo(ChemicalElement otherElement)
	{
		System.out.println("Comparing..."+atomicNumber+" with "+otherElement.atomicNumber);
		return Integer.compare(atomicNumber, otherElement.atomicNumber);
	}
	public ChemicalElement(int atomicNumber, String atomicName, String atomicFormula, float atomicWeight) {
		super();
		this.atomicNumber = atomicNumber;
		this.atomicName = atomicName;
		this.atomicFormula = atomicFormula;
		this.atomicWeight = atomicWeight;
	}
	@Override
	public String toString() {
		return "ChemicalElement [atomicNumber=" + atomicNumber + ", atomicName=" + atomicName + ", atomicFormula="
				+ atomicFormula + ", atomicWeight=" + atomicWeight + "]";
	}
	
	
}
public class TreeSetTest {
	public static void main(String[] args) {
		ChemicalElement element1 = new ChemicalElement(1, "Hydrogen", "H", 1.008f);
		ChemicalElement element2 = new ChemicalElement(2, "Helium", "He", 4.0026f);
		ChemicalElement element3 = new ChemicalElement(8, "Oxygen", "O", 15.999f);
		ChemicalElement element4 = new ChemicalElement(14, "Silicon", "Si", 28.085f);
		ChemicalElement element5 = new ChemicalElement(3, "Lithium", "Li", 6.94f);
		System.out.println("Elements are created....");
		
		TreeSet<ChemicalElement> periodicTableSet = new TreeSet<ChemicalElement>();
		System.out.println("Empty Periodic Table is created....");
		
		System.out.println("NOW ..Adding the first element...");
		periodicTableSet.add(element1);
		
		System.out.println("NOW ..Adding the second element...");
		periodicTableSet.add(element2);
		
		System.out.println("NOW ..Adding the third element...");
		periodicTableSet.add(element3);
		
		System.out.println("NOW ..Adding the fourth element...");
		periodicTableSet.add(element4);
		
		System.out.println("NOW ..Adding the fifth element...");
		periodicTableSet.add(element5);
		
		System.out.println("Added all the elements...");
		
		Iterator<ChemicalElement> elementIterator =  periodicTableSet.iterator();
		while(elementIterator.hasNext()) {
			ChemicalElement theElement = elementIterator.next();
			System.out.println("Element : "+theElement );
		}
		
		
	}
}
