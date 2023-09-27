package csc212;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(PowerR(4,6));
		System.out.println(PowerI(4,6));
	}
	
	public static int PowerR(int x, int n) {
		if(n == 0)
			return 1;
		return x * PowerR(x,n-1);
	}
	
	public static int PowerI(int x, int n) {
		int power =1;
		for(int i =0; i<n; i++)
			power *=  x;
		return power;
	}
}
