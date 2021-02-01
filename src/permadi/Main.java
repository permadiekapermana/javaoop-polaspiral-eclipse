package permadi;

import java.util.Scanner;

public class Main {
	
public static void main(String[] args) {
		
	//	object spiral dengan tipe Pola
	Pola spiral = new Spiral();
	System.out.print("Masukkan Kalimat\t: ");
	//	scanner input user
    Scanner kalimat = new Scanner(System.in);
    //	get input user
    String input = kalimat.nextLine();

    // validasi length input
    if(input.length()>250){       
      System.out.println("Panjang Kalimat yang diinputkan tidak boleh lebih dari 250 karakter!");
    }else if (input.length()<=250){ 
    
    String encrypted = spiral.enkripsiKalimatSpiral(input);
    System.out.println("\nEnkripsi Kalimat\t: " + encrypted);

    String descrypted = spiral.deskripsiKalimatSpiral(encrypted);
    System.out.println("\nDesripsi Kalimat\t: " + descrypted);

    // end if
    }
        
	}

}
