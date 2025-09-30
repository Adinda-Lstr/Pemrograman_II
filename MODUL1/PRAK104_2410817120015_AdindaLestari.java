package MODUL1;
import java.util.Scanner;
public class PRAK104_2410817120015_AdindaLestari {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		System.out.print("Tangan Abu   :");
		String abuR1 = input.next();
		String abuR2 = input.next();
		String abuR3 = input.next();
		
		
		System.out.print("Tangan Bagas  :");
		String bagasR1 = input.next();
		String bagasR2 = input.next();
		String bagasR3 = input.next();
		
		int poinAbu = 0;
		int poinBagas= 0;
		
		if (abuR1.equals(bagasR1)) {
		}else if ((abuR1.equals("B") && bagasR1.equals("G")) ||
				  (abuR1.equals("G") && bagasR1.equals("K")) ||
				  (abuR1.equals("K") && bagasR1.equals("B"))) {
			poinAbu++;
		}else {
			poinBagas++;
		}
        if (abuR2.equals(bagasR2)) {
        	
        }else if ((abuR2.equals("B") && bagasR2.equals("G")) ||
		          (abuR2.equals("G") && bagasR2.equals("K")) ||
		          (abuR2.equals("K") && bagasR2.equals("B"))) {
	poinAbu++;
   }else {
	poinBagas++;
}
        if (abuR3.equals(bagasR3)) {
        	
        }else if ((abuR3.equals("B") && bagasR3.equals("G")) ||
			      (abuR3.equals("G") && bagasR3.equals("K")) ||
			      (abuR3.equals("K") && bagasR3.equals("B"))) {
			poinAbu++;
		}else {
			poinBagas++;
		}
        
        if (poinAbu > poinBagas) {
        	System.out.println("Abu");
        }else if (poinBagas > poinAbu) {
        	System.out.println("Bagas");
        }else {
        	System.out.println("Seri");
        }
	}

}
