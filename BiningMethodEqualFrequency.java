import java.util.Arrays;
import java.util.Scanner;

public class BiningMethodEqualFrequency {
	
	public static float mean(float[] m) {
	    float sum = 0;
	    for (int i = 0; i < m.length; i++) {
	        sum += m[i];
	    }
	    return sum / m.length;
	}
	public static float median(float[] m) {
	    int middle = m.length/2;
	    if (m.length%2 == 1) {
	        return m[middle];
	    } else {
	        return  (float) ((m[middle-1] + m[middle]) / 2.0);
	    }
	}

	public static void main(String[] args) {
		
      Scanner sc =  new Scanner(System.in);
		
		System.out.println("Enter the number of Frequencies");
		int nof=sc.nextInt();
		
		System.out.println("Enter the number of Bins");
		int nob=sc.nextInt();
		
		if(nof%nob==0)
		{
			float f[]=new float[nof];
			
			for(int i=0;i<nof;i++)
			{
				System.out.print("Enter frequency " + (i+1) + ":");
				f[i]=sc.nextInt();
				System.out.println();
				
			}
			
			Arrays.sort(f);
			
			float bin[][]=new float[nob][nof/nob];
			float bsmean[][]=new float[nob][nof/nob];
			float bsmedian[][]=new float[nob][nof/nob];
			float bsboundaryvalue[][]=new float[nob][nof/nob];
			
			int from=0;
			int to=nof/nob;
			
			for(int i=0;i<nob;i++)
			{
				bin[i]=Arrays.copyOfRange(f,from ,to );
				from=from +nof/nob;
				to=to+nof/nob;
			}
			
			float mean[]=new float[nob];
			float median[]=new float[nob];
			for(int i=0;i<nob;i++)
			{
				mean[i]= BiningMethodEqualFrequency.mean(bin[i]);
				median[i]= BiningMethodEqualFrequency.median(bin[i]);
				
				for(int j=0;j<(nof/nob);j++)
				{
					bsmean[i][j]=mean[i];
					bsmedian[i][j]=median[i];
					
					if(bin[i][j]-bin[i][0] <= bin[i][((nof/nob)-1)]-bin[i][j])
					{
						bsboundaryvalue[i][j]=bin[i][0];
					}
					else
					{
						bsboundaryvalue[i][j]=bin[i][((nof/nob)-1)];
					}
				}
			}
			
			System.out.println("BINS Values ");
			for(int i=0;i<nob;i++)
			{
				System.out.println("BIN " + i + ":" + Arrays.toString(bin[i]));
			}
			System.out.println("Smoothing by Mean ");
			for(int i=0;i<nob;i++)
			{
				System.out.println("BIN " + i + ":" + Arrays.toString(bsmean[i]));
			}
			System.out.println("Smoothing by Median ");
			for(int i=0;i<nob;i++)
			{
				System.out.println("BIN " + i + ":" + Arrays.toString(bsmedian[i]));
			}
			System.out.println("Smoothing by Boundary Values ");
			for(int i=0;i<nob;i++)
			{
				System.out.println("BIN " + i + ":" + Arrays.toString(bsboundaryvalue[i]));
			}
			
			
		}
		else
		{
			System.out.println("Wrong number of frequencies");
		}
		
		
	}

}
