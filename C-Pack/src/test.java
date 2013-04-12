
public class test {

//	for (int i=0;i<input.length;i++){
//	input[i]=randomGenerator.nextInt(0xFFFF);
//}

//for(int i=1;i<dictionary.length;i++)
//{
//	//System.out.println(dictionary[i]  ^ dictionary[i-1]);
// System.out.println(Integer.toHexString(dictionary[i]));
//}

//System.out.println("**************");
//for(int i=0;i<input.length;i++)
//{
//	//System.out.println(dictionary[i]  ^ dictionary[i-1]);
// System.out.println(Integer.toHexString(input[i]));
//}


//int [] aRGB = {0xF1, 0x00, 0x00, 0xFF};
//  int color_val = aRGB[3];
//  color_val = color_val | (aRGB[2] << 8);
//  color_val = color_val | (aRGB[1] << 16);
//  color_val = color_val | (aRGB[0] << 24);
//  System.out.println("COlor "+ Integer.toHexString(color_val));
//  
//
//  int alpha_val = (color_val >>> 24) & 0xFF;
//  int red_val   = (color_val >>> 16) & 0xFF;
//  int green_val = (color_val >>>  8) & 0xFF;
//  int blue_val  =  color_val & 0xFF;
  
//  System.out.println(alpha_val+"  "+red_val+"  "+green_val+"  "+blue_val);
	public static void main(String[] args) {
	int n = 6;

	String bin = Integer.toBinaryString(n);
	System.out.println(bin);
	System.out.println(Integer.numberOfLeadingZeros(n));
	char arr[] = bin.toCharArray();
	for(int i = 0; i < arr.length; ++i) {
	        System.out.println("Bit number " + (i + 1) + " = " + arr[i]);
	}
	
	}
	
}
