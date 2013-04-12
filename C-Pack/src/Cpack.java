import java.util.Random;


public class Cpack {
	
	public static int[] dictionary=new int[16];
	public static char[] compressed_text;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random randomGenerator = new Random();
		for (int i=0;i<dictionary.length;i++){
			dictionary[i]=randomGenerator.nextInt(0xFFFFFFF);
		}
		
		Cpack.dictionary[4]=0x54324512;
		
		Compression cmp=new Compression();
		cmp.main(0x3455657);
		compressed_text=Compression.compressed;
//		System.out.println("COmpreessed Text");
//		System.out.println(compressed_text);
		
		Decompression dcmp=new Decompression();
		dcmp.main(compressed_text);
		
	}

}
