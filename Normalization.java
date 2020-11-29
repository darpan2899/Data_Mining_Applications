import java.util.Arrays;
import java.util.Scanner;

public class Normalization {
	public static double mean(double[] m) {
	    double sum = 0;
	    for (int i = 0; i < m.length; i++) {
	        sum += m[i];
	    }
	    return sum / m.length;
	}
	public static double calculateSD(double m[],double mean)
    {
        double standardDeviation = 0.0;
        int len = m.length;

        for(int i=0;i<len;i++) {
            standardDeviation += Math.pow((double)m[i] - mean, 2);
        }

        return Math.sqrt(standardDeviation/(len-1));
    }
	public static void main(String[] args)
	{
       Scanner sc =  new Scanner(System.in);
		double max,min,new_max,new_min;
		int n;
		
		System.out.println("Enter the number of Values");
		n=sc.nextInt();
		
		double m[]=new double[n];
		double mmn[]=new double[n];
		double zsn[]=new double[n];
		double dsn[]=new double[n];
		
		System.out.println("Enter the new Max");
		new_max=sc.nextInt();
		System.out.println("Enter the new Min");
		new_min=sc.nextInt();
		
		System.out.println("Enter the values");
		for(int i=0;i<m.length;i++)
		{
			m[i]=sc.nextInt();
			
		}
		
		max=Arrays.stream(m).max().getAsDouble();
		min=Arrays.stream(m).min().getAsDouble();
		
		
		for(int i=0;i<m.length;i++)
		{
			mmn[i]=((m[i]-min)/(max-min))*(new_max-new_min) + new_min;
			
		}
		
		double mean=Normalization.mean(m);
		double standardDeviation=Normalization.calculateSD(m, mean);
		
		for(int i=0;i<m.length;i++)
		{
			zsn[i]=(m[i] - mean) / standardDeviation;
			
		}
		int j= String.valueOf((int)max).length();
		for(int i=0;i<m.length;i++)
		{
			dsn[i]= m[i]/ Math.pow(10, j);
			
		}
		
		System.out.println("Value\tMin-Max\tZero Score\tDecimal Scaling");
		
		for(int i=0;i<m.length;i++)
		{
			System.out.println(m[i] + "\t" + mmn[i] + "\t" + (float)zsn[i] + "\t" + dsn[i]);
		}
		
		
	}

}
