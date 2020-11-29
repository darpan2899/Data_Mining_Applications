import java.util.Scanner;

public final class linearregression {
	
	public static double mean(int[] m) {
	    double sum = 0;
	    for (int i = 0; i < m.length; i++) {
	        sum += m[i];
	    }
	    return sum / m.length;
	}

	public static void main(String[] args) {
		
Scanner sc =  new Scanner(System.in);
		

        System.out.println("Enter the size of x and y");
		int n=sc.nextInt();
		int x[]=new int[n];
		int y[]=new int[n];
		
		System.out.println("Enter the values of x");
		for(int i=0;i<x.length;i++)
		{
			x[i]=sc.nextInt();
			
		}
		

		System.out.println("Enter the values of y");
		for(int i=0;i<y.length;i++)
		{
			y[i]=sc.nextInt();
			
		}
		
		double xmean = linearregression.mean(x);
		double ymean = linearregression.mean(y);
		
		double w0=0,w1=0,tnum=0,tden=0;
		
		
		for(int i=0;i<n;i++)
		{
			tnum = tnum + ((x[i]-xmean)*(y[i]-ymean));
			tden = tden +  Math.pow((x[i]-xmean), 2);
		}
		w1 = tnum / tden;
		w0 = ymean - (w1*xmean);
		
		System.out.println("Enter the value of x for which you want to predict y");
		double x1 = sc.nextDouble();
		double y1 = w0 + (w1*x1);
		System.out.println(" the value of  y for x = " + x1 + "is y=" + y1);

	}

}
