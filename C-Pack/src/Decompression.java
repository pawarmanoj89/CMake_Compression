
public class Decompression {

	/**
	 * @param compressed_text
	 */
	public static int decompressed;
	public static int index=-1;
	public static char[] temp=new char[32];
	public static void main(char[] data) {
		// TODO Auto-generated method stub
	//	System.out.println("In Decomp");
	
		
		switch(data.length)
		{
		case 2:     // zzzz
			decompressed=0;
			break;
			
		case 6:		//mmmm	
			index=bitToInt(data,2,6);
			decompressed=Cpack.dictionary[index];
			break;
		
		case 12:	//zzzx	
			decompressed=bitToInt(data,4,12);
			break;
		
		case 16:	//mmmx
			decompressed=mmmx(data);
			break;
		
		case 24:	//mmxx
			
			decompressed=mmxx(data);
			break;
		
		case 34:	//xxxx
			decompressed=bitToInt(data,2,34);
			
			break;
		}
		System.out.println("Decompressed TExt");
		System.out.println(Integer.toHexString(decompressed));
		System.out.println(Integer.toBinaryString(decompressed));
	}
	
	
	private static int bitToInt(char[] data,int start,int end) {
		// TODO Auto-generated method stub
		int x=0;
		
		for(int i=start,j=end-start-1;i<end;i++)
		{
			//System.out.println(data[i]*1);
			
			x=x+ (data[i]-48) * (int)Math.pow(2, j);
			//System.out.println(x+"    "+j);
			j--;
		}
				
		return x;
	}


	private static int mmxx(char[] data) {
		// TODO Auto-generated method stub
		index=bitToInt(data,4,8);
		
		for(int i=0;i<32;i++){
			temp[i]='0';
		}
		String str;
		str=Integer.toBinaryString(Cpack.dictionary[index]);
		char[] temp1;
		temp1=str.toCharArray();
		
		for(int j=31, k=temp1.length-1;j>31-temp1.length;j--){
			temp[j]=temp1[k];
			//System.out.println("j "+j+" k "+k);
			k--;
		}
		
		
		for(int j=16, k=8;j<32;j++){
			temp[j]=data[k];
			//System.out.println("j "+j+" k "+k +" "+temp[j]+" "+data[k]);
			k++;
		}
		
		System.out.println("Temp");
		System.out.println(temp);
		
		return bitToInt(temp,0,32);
		
	}
	
	
	private static int mmmx(char[] data) {
		// TODO Auto-generated method stub
		index=bitToInt(data,4,8);
		
		for(int i=0;i<32;i++){
			temp[i]='0';
		}
		String str;
		str=Integer.toBinaryString(Cpack.dictionary[index]);
		char[] temp1;
		temp1=str.toCharArray();
		
		for(int j=31, k=temp1.length-1;j>31-temp1.length;j--){
			temp[j]=temp1[k];
			//System.out.println("j "+j+" k "+k);
			k--;
		}
		
		
		
		for(int j=24, k=8;j<32;j++){
			temp[j]=data[k];
			//System.out.println("j "+j+" k "+k +" "+temp[j]+" "+data[k]);
			k++;
		}
		
		System.out.println("Temp");
		System.out.println(temp);
		
		return bitToInt(temp,0,32);
	}
	

}
