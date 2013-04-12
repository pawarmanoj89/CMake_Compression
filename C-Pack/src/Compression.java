import java.util.Dictionary;
import java.util.Random;


public class Compression {
	
	/**
	 * @param args
	 */
	
	
	public static int output,code=-1;
	public static char[] compressed,temp_char;
	public static char[] index_bit={'0','0','0','0'};
	public static char[] code_bit,unmached_char;
	public static void main(int data) {
		// TODO Auto-generated method stub
		
		
		int[] input=new int[32];
		
		
		
				
			
		
		
		
		
		//Cpack.dictionary[2]=0x54321111;
		input[0]=data;

		  
		  System.out.println("Input "); 
		  System.out.println(Integer.toHexString(data));
		  System.out.println(Integer.toBinaryString(input[0]));
		 
		  code=1;
		  System.out.println();
		  System.out.println("Patern: ");
		  if(zzzz(input[0]))
			  System.out.println(code_bit);
		  else if(mmmm(input[0]))
			  System.out.println(code_bit);
		  else if(mmmx(input[0]))
			  System.out.println(code_bit);
		  else if(mmxx(input[0]))
			  System.out.println(code_bit);
		  else if(zzzx(input[0]))
			  System.out.println(code_bit);
		  else xxxx(input[0]);
		  
		  System.out.println("Copressed WOrd ");
				  System.out.println(compressed);
				  System.out.println("Length = "+compressed.length+" bits");
				  System.out.println();

	}
	
	public static boolean mmmm(int ip_value){
		int flag=-1;
		for (int i=0;i<Cpack.dictionary.length;i++)
		{ 
			if((ip_value ^ Cpack.dictionary[i])==0)
			{
				System.out.println("mmmm");
				code=2;
				String bin =Integer.toBinaryString(2);
				code_bit=bin.toCharArray();
				
				output=i;
								
				bin =Integer.toBinaryString(i);
				temp_char=bin.toCharArray();

				
				for(int j=3, k=temp_char.length-1;j>3-temp_char.length;j--){
					index_bit[j]=temp_char[k];
					k--;
				}
							
								
				compressed=new char[6];
				for(int j=0;j<code_bit.length;j++)
					compressed[j]=code_bit[j];
				
				for(int j=2,k=0;j<6;j++)
				{
					compressed[j]=index_bit[k];
					k++;
				}
				
				flag=1;
				break;
			}
			
		}
		if (flag!=-1)
		 return true;
		
		return false;
		
		
	}

	public static boolean zzzz(int ip_value){
		int flag=-1;
		if(ip_value==0)
		{
			System.out.println("zzzz");
			code=0;
			code_bit=new char[2];
			code_bit[0]='0';
			code_bit[1]='0';
			
			compressed=new char[2];
			for(int j=0;j<code_bit.length;j++)
				compressed[j]=code_bit[j];
			
			
			return true;
		}
		return false;
		
	}
	
	
	public static boolean mmmx(int ip_value){
		int flag=-1;
		for (int i=0;i<Cpack.dictionary.length;i++)
		{ 
			if( ( ( (Cpack.dictionary[i] >>> 24) & 0xFF)  ^ ( (ip_value >>> 24) & 0xFF) )  ==0 )
			{
				if( ( ( (Cpack.dictionary[i] >>> 16) & 0xFF)  ^ ( (ip_value >>> 16) & 0xFF) )  ==0 )
				{
					if( ( ( (Cpack.dictionary[i] >>> 8) & 0xFF)  ^ ( (ip_value >>> 8) & 0xFF) )  ==0 )
					{
						System.out.println("mmmx");
						code=14;
						output=i;
						String bin =Integer.toBinaryString(14);
						code_bit=bin.toCharArray();
//						String bin =Integer.toBinaryString(i);
//						compressed=bin.toCharArray();
//						System.out.println();
//						System.out.println(compressed);
											
						bin =Integer.toBinaryString(i);
						temp_char=bin.toCharArray();
						for(int j=3, k=temp_char.length-1;j>3-temp_char.length;j--){
							index_bit[j]=temp_char[k];
							k--;
						}
						
						bin=Integer.toBinaryString(ip_value & 0xFF);
						temp_char=bin.toCharArray();
						unmached_char=new char[8];
						for(int k=0;k<8;k++)
							unmached_char[k]='0';
						for(int j=7, k=temp_char.length-1;j>7-temp_char.length;j--){
							unmached_char[j]=temp_char[k];
							k--;
						}
											
						compressed=new char[16];
						for(int j=0;j<code_bit.length;j++)
							compressed[j]=code_bit[j];
						
						for(int j=4,k=0;j<8;j++)
						{
							compressed[j]=index_bit[k];
							k++;
						}
						
						for(int j=8,k=0;j<16;j++)
						{
							compressed[j]=unmached_char[k];
							k++;
						}
						
						flag=1;
						break;
					}
				}
				
			}
			
		}
		if (flag!=-1)
		 return true;
		
		return false;
		
		
	}
	
	
	
	public static boolean mmxx(int ip_value){
		int flag=-1;
		for (int i=0;i<Cpack.dictionary.length;i++)
		{ 
			if( ( ( (Cpack.dictionary[i] >>> 24) & 0xFF)  ^ ( (ip_value >>> 24) & 0xFF) )  ==0 )
			{
				if( ( ( (Cpack.dictionary[i] >>> 16) & 0xFF)  ^ ( (ip_value >>> 16) & 0xFF) )  ==0 )
				{
					
						System.out.println("mmxx");
						code=12;
						output=i;
						String bin =Integer.toBinaryString(12);
						code_bit=bin.toCharArray();
				
						
						 bin =Integer.toBinaryString(i);
						temp_char=bin.toCharArray();
						for(int j=3, k=temp_char.length-1;j>3-temp_char.length;j--){
							index_bit[j]=temp_char[k];
							k--;
						}
						
						
						bin=Integer.toBinaryString(ip_value & 0xFFFF);
						temp_char=bin.toCharArray();
						unmached_char=new char[16];
						for(int k=0;k<unmached_char.length;k++)
							unmached_char[k]='0';
						for(int j=15, k=temp_char.length-1;j>15-temp_char.length;j--){
							unmached_char[j]=temp_char[k];
							k--;
						}
												
						compressed=new char[24];
						for(int j=0;j<code_bit.length;j++)
							compressed[j]=code_bit[j];
						
						for(int j=4,k=0;j<8;j++)
						{
							compressed[j]=index_bit[k];
							k++;
						}
						
						for(int j=8,k=0;j<24;j++)
						{
							compressed[j]=unmached_char[k];
							k++;
						}
						
						
						flag=1;
						break;
					
				}
				
			}
			
		}
		if (flag!=-1)
		 return true;
		
		return false;
		
		
	}
	
	
	public static boolean zzzx(int ip_value){
		int flag=-1;
		System.out.println();
		
		
			if( ( (ip_value >>> 8) & 0xFFFFFF)     ==0 )
			{
									
				System.out.println("zzzx");		
				code=13;
					flag=1;
					String bin =Integer.toBinaryString(13);
					code_bit=bin.toCharArray();
					
					bin=Integer.toBinaryString(ip_value & 0xFF);
					temp_char=bin.toCharArray();
					unmached_char=new char[8];
					for(int k=0;k<unmached_char.length;k++)
						unmached_char[k]='0';
					for(int j=7, k=temp_char.length-1;j>7-temp_char.length;j--){
						unmached_char[j]=temp_char[k];
						k--;
					}
										
					compressed=new char[12];
					for(int j=0;j<code_bit.length;j++)
						compressed[j]=code_bit[j];
					
					
					for(int j=4,k=0;j<12;j++)
					{
						compressed[j]=unmached_char[k];
						k++;
					}
					
				
	    	}
		if (flag!=-1)
		 return true;
		
		return false;
		
		
	}
	
	
	public static boolean xxxx(int ip_value){
		int flag=-1;
		System.out.println("xxxx");

	     
		  code_bit=new char[2];
			code_bit[0]='0';
			code_bit[1]='1';
		 
		 String bin=Integer.toBinaryString(ip_value & 0xFFFFFFFF);
			temp_char=bin.toCharArray();
			unmached_char=new char[32];
			for(int k=0;k<32;k++)
				unmached_char[k]='0';
			for(int j=31, k=temp_char.length-1;j>31-temp_char.length;j--){
				unmached_char[j]=temp_char[k];
				k--;
			}

			compressed=new char[34];
			for(int j=0;j<code_bit.length;j++)
				compressed[j]=code_bit[j];
							
			for(int j=2,k=0;j<34;j++)
			{
				compressed[j]=unmached_char[k];
				k++;
			}
			
	     
		
		
		return true;
	}
	
}
