import java.util.*;
import com.google.common.*;
public class aprori {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of transactions");
		int n= sc.nextInt();
		
		System.out.println("Enter number of distinct data items");
		int noi= sc.nextInt();
		
		System.out.println("Enter number of minimum support count");
		int minsup= sc.nextInt();
		
		System.out.println("Enter number of minimum confidence count");
		int mincon= sc.nextInt();
		
		String Transactions[] =new String[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the items of transaction " + i + "\n(Separated by comma)");
			Transactions[i]=sc.next();
		}
		
		int frequency[]= new int[noi];
		int c1frequency[]= new int[noi];
		int c2frequency[]= new int[noi];
		int c3frequency[]= new int[noi];
		float confidence[] = new float[noi];
		int tempfrequency[]= new int[noi];
		String items[]=new String[noi];
		String c1items[]=new String[noi];
		String c2items[]=new String[noi];
		String c3items[]=new String[noi];
		String temp[]=new String[noi*noi];
		String tempitem="";
		
		
		for(int i=0;i<n;i++)
		{
			temp = Transactions[i].split(",");
			
			for(int j=0;j<temp.length;j++)
			{
				if(!tempitem.contains(temp[j]))
				{
					tempitem= tempitem +  temp[j] + ",";
				}
			}
		}
		System.out.println(tempitem);
		
		items = tempitem.split(",");
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<items.length;j++)
			{
				if(Transactions[i].contains(items[j]))
				{
					frequency[j]++;
				}
			}
		}
		
		tempitem="";
		int t=0;
		for(int i=0;i<items.length;i++)
		{
			if(frequency[i]>=minsup)
			{
				tempitem=tempitem + items[i] + ",";
				frequency[t]=frequency[i];
				t++;
			}
		}
		
		items = tempitem.split(",");
		c1items=items.clone();
		c1frequency=frequency.clone();
		System.out.println("Table C1");
		System.out.println("Items\tFrequency");
		for(int i=0;i<items.length;i++)
		{
			
			System.out.println(items[i] + "\t" + frequency[i]);
		}
		
		
		tempitem="";
		t=0;
			for(int j=0;j<items.length-1;j++)
			{
				for(int k=j+1;k<items.length;k++)
				{
					tempitem=tempitem + items[j] + "," +items[k] + "_";
					for(int i=0;i<n;i++)
					{
				     if(Transactions[i].contains(items[j]) && Transactions[i].contains(items[k]))
				     {
					  
					  tempfrequency[t]++;
					  
				     }
					}
					t++;
				}
			}
		
		items = tempitem.split("_");
		
		
		System.out.println("Table C2");
		System.out.println("Items\tFrequency");
		for(int i=0;i<items.length;i++)
		{
			frequency[i]=tempfrequency[i];
			tempfrequency[i]=0;
			System.out.println(items[i] + "\t" + frequency[i]);
		}
		
		tempitem="";
		t=0;
		for(int i=0;i<items.length;i++)
		{
			if(frequency[i]>=minsup)
			{
				tempitem=tempitem + items[i] + "_";
				frequency[t]=frequency[i];
				t++;
			}
		}
		items = tempitem.split("_");
		c2items=items.clone();
		c2frequency=frequency.clone();
		System.out.println("Table C2");
		System.out.println("Items\tFrequency");
		for(int i=0;i<items.length;i++)
		{
			System.out.println(items[i] + "\t" + frequency[i]);
		}
		
		tempitem="";
		
			for(int j=0;j<items.length-1;j++)
			{
				for(int k=j+1;k<items.length;k++)
				{
					temp= items[j].split(",");
					if(items[k].contains(temp[0]) || items[k].contains(temp[1]))
					{
						if(items[k].contains(temp[0]))
						{
							tempitem=tempitem + temp[1] + "," + items[k] + "_";
						}
						else
						{
							tempitem=tempitem + temp[0] + "," + items[k] + "_";
						}
						
						
					}
					
					
				}
			}
		
		items = tempitem.split("_");
		t=0;
		
		for(int j=0;j<items.length;j++)
		{
			temp=items[j].split(",");
			for(int i=0;i<n;i++)
			{
		     if(Transactions[i].contains(temp[0]) && Transactions[i].contains(temp[1]) && Transactions[i].contains(temp[2]))
		     {
			  
			  tempfrequency[t]++;
			  
		     }
			}
			t++;
		}
		System.out.println("Table C3");
		System.out.println("Items\tFrequency");
		for(int i=0;i<items.length;i++)
		{
			frequency[i]=tempfrequency[i];
			tempfrequency[i]=0;
			System.out.println(items[i] + "\t" + frequency[i]);
		}
		
		tempitem="";
		t=0;
		for(int i=0;i<items.length;i++)
		{
			if(frequency[i]>=minsup)
			{
				tempitem=tempitem + items[i] + "_";
				frequency[t]=frequency[i];
				t++;
			}
			else
			{
				frequency[i]=0;
			}
		}
		System.out.println(tempitem);
		items = tempitem.split("_");
		c3items=items.clone();
		c3frequency=frequency.clone();
		System.out.println("Table C3");
		System.out.println("Items\tFrequency");
		for(int i=0;i<items.length;i++)
		{
			if(!tempitem.isEmpty())
			{
			System.out.println(c3items[i] + "\t" + c3frequency[i]);
			}
		}
		
		int c=0;
		t=0;
		
			items=c2items;
			frequency=c2frequency;
			
			for(int i=0;i<items.length;i++)
			{
				temp = items[i].split(",");
				for(int j=0;j<temp.length;j++)
				{
					for(int k=0;k<c1items.length;k++)
					{
						if(c1items[k].equals(temp[j]))
						{
							t=k;
							break;
						}
					}
					confidence[c] = ((float)frequency[i]/c1frequency[t])*n;
					//System.out.println(frequency[i] + " " + c1frequency[t]);
					if(confidence[c]>mincon)
					{
						if(j==0)
						{
							System.out.println("rule " + c);
							System.out.println(temp[0]+"--->"+temp[1]);
							System.out.println("Confidence = " + confidence[c]);
						}
						else
						{
							System.out.println("rule " + c);
							System.out.println(temp[1]+"--->"+temp[0]);
							System.out.println("Confidence = " + confidence[c]);
						}
						
						
					}
					c++;
				}
				
			}
			
		
		

	}

}
