import java.util.Scanner;
public class MeanMedianMode {
	
	public static double mean(int[] m) {
	    double sum = 0;
	    for (int i = 0; i < m.length; i++) {
	        sum += m[i];
	    }
	    return sum / m.length;
	}
	public static double median(int[] m) {
	    int middle = m.length/2;
	    if (m.length%2 == 1) {
	        return m[middle];
	    } else {
	        return (m[middle-1] + m[middle]) / 2.0;
	    }
	}
	public static int mode(int m[]) {
	    int maxValue=0,maxCount=0;

	    for (int i = 0; i < m.length; ++i) {
	        int count = 0;
	        for (int j = 0; j < m.length; ++j) {
	            if (m[j] == m[i]) 
	            	{++count;}
	        }
	        if (count > maxCount) {
	            maxCount = count;
	            maxValue = m[i];
	        }
	    }

	    return maxValue;
	}

	public static double calculateSD(int m[],double mean)
    {
        double standardDeviation = 0.0;
        int len = m.length;

        for(int i=0;i<len;i++) {
            standardDeviation += Math.pow((double)m[i] - mean, 2);
        }

        return Math.sqrt(standardDeviation/(len-1));
    }
	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		
		
		int m[]=new int[10];
		
		for(int i=0;i<m.length;i++)
		{
			m[i]=sc.nextInt();
			
		}
		double mean=MeanMedianMode.mean(m);
		double median=MeanMedianMode.median(m);
		int mode= MeanMedianMode.mode(m);
		double standardDeviation=MeanMedianMode.calculateSD(m, mean);
		
		System.out.println("mean=" + mean + "\nmedian=" + median + "\nmode=" + mode + "\nstandardDeviation=" + standardDeviation);

	}

}
