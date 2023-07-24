package service;

public class cabService {

	public double bill(double km, String cabtype) {
		
		double billAmt = 0;

		if(cabtype.equals("mini")) {
			double kmAmt=10*km;
			billAmt=kmAmt+kmAmt*0.05;
		}else if(cabtype.equals("micro")) {
			double kmAmt=15*km;
			billAmt=kmAmt+kmAmt*0.08;
		}else if(cabtype.equals("prime")) {
			double kmAmt=20*km;
			billAmt=kmAmt+kmAmt*0.1;
		}
		return billAmt;
	}

}
