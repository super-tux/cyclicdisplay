// oeis.org has prime numbers

public class genpattern {

	public static void main(String[] args) {
		
		int firstArg = 1;
		if (args.length > 0) {
		    try {
		        firstArg = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument" + args[0] + " must be an integer.");
		        System.exit(1);
		    }
		}
		
		int prime = firstArg;
		int base = 2;
		int number = numgen(base, prime);
		System.out.println(number);
		int[] bin = convert(base, number);
		print(bin, prime);
	}


	public static int numgen(int b, int p){
		int t = 0;
		int r = 1;
		int n = 0;
		int d, x;

		do{
			t++;
			x = r * b;
			d = (int) x / p;
			r = x % p;
			n = n * b + d;
		}while(r != 1);

		if(t == p - 1)return n;
		else return -1;
	}


	public static int[] convert(int b, int num){
		int r, c = 0;
		int[] bin = new int[100];

		while(num > 0){
			r = num % b;
			num = (int)num / b;
			bin[c] = r;
			c++;
		}
		return bin;
	}


	public static void print(int[] bin, int p){

		for(int i = p - 2; i >= 0; i--){
			System.out.print(bin[i]+",");
		}

		System.out.println();
	}
}
