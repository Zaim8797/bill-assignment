import java.util.Scanner;
import java.text.DecimalFormat;
public class ElectricityBill {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df= new DecimalFormat("0.00");
		
		double tarif = 0;
		
		int usageNow;
		System.out.print("Penggunaan semasa (kWh) = ");
		usageNow = sc.nextInt();
		
	    int usageOld;
	    System.out.print("Penggunaan dahulu (kWh) = ");
	    usageOld = sc.nextInt();
		
		double lampuJalan;
		System.out.print("Lampu jalan (kWh) = ");
		lampuJalan = sc.nextDouble();
		
		int usageTotal = usageNow - usageOld;
		
		//TARIF
		if(usageTotal <= 200) {		
			tarif = usageTotal * 0.218;
		}
		else if(usageTotal <= 300) {	
			tarif = 0.218 * 200 + (usageTotal - 200) * 0.334;
		}
		else if(usageTotal <= 600) {	
			tarif = 0.218 * 200 + 0.334 * 100 + (usageTotal) * 0.516;
		}
		else if(usageTotal <= 900) {	
			tarif = 0.218 * 200 + 0.334 * 100 + 0.516 * 300 + (usageTotal - 600) * 0.546;
		}
		else if(usageTotal > 900) {
			tarif = 0.218 * 200 + 0.334 * 100 + 0.516 * 300 + 0.546 * 300 + (usageTotal - 900) * 0.571;
		}
		
		double ISL = lampuJalan * 0.183;
		double price = tarif + ISL;
		
		//ICPT
		double ICPT = 0;
		double ICPT_ISL = 0;
		
		ICPT = usageTotal * 0.02;
		ICPT_ISL = lampuJalan * 0.02;
	
		//SERVIS TAKS
		double ServTax = 0;
		
		if (usageTotal > 600) {
			ServTax = (price - 231.80) * 0.06;
		}
		
		//KWTBB
		double KWTBB = 0;
		
		if (usageTotal > 300) {
			KWTBB = price * 0.016;
		}
		else {
			KWTBB = ISL * 0.016;
		}
		
		//Jumlah Bil
		double bil = tarif + ISL - ICPT - ICPT_ISL + ServTax + KWTBB;
		
		//OUTPUT
		System.out.println("Tarif = RM" + df.format(tarif));
		System.out.println("ICPT : RM" + df.format(ICPT));
		System.out.println("ICPT ISL : RM" + df.format(ICPT_ISL));
		System.out.println("Service Tax : RM" + df.format(ServTax));
		System.out.println("KWTBB : RM" + df.format(KWTBB));
		System.out.println("Bil perlu dibayar : RM" + df.format(Math.round(bil * 100.00 / 5.00) * 5.00 / 100.00));
		}
}