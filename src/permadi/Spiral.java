package permadi;

public class Spiral extends Pola {
	
	//	method get jumlah baris
	public static int getBaris(int lengthData) {

        int counter = 0;
        int nilai=1;
        while(counter != lengthData) {
            for (int j=0; j<nilai*2; j++) {
                counter++;
                if (counter == lengthData) {
                    break;
                }
                
            }
            nilai++;
        }        
        return nilai-1;

    }
	
	//	method get jumlah kolom
	public static int getKolom(int lengthData) {

        int counter = 0;
        int nilai= 0;
        while(counter != lengthData) {
            for (int j=1; j<nilai*2; j++) {
                counter++;
                if (counter == lengthData) {
                    break;
                }
                
            }
            nilai++;
        }        
        return nilai-1;

    }
	
	//	method menentukan arah pindah baris/kolom
	public static int getDirection(int lengthData) {
        
        int i, j, k;
        i = 1;
        k = 1;
        int counter = 0;
    
        while (counter != lengthData)
        {
            for (j = 1; j <= i; j+=2)
            {
                k = i % 4;                
                counter++;
                if (counter == lengthData) {
                    break;
                }                                                     
            }
            i++;
            
        }
        return k;

    }
	
	//	method get center baris	
	public static int getCenterBaris(int jmlBaris) {
		int nilai;
		nilai= (int) Math.ceil((float) jmlBaris / (float) 2) - 1;
		return nilai;
	}
	
	//	method get center kolom	
	public static int getCenterKolom(int jmlKolom) {
		int nilai;
		nilai= (int) Math.ceil((float) jmlKolom/ (float) 2) - 1;
		return nilai;
	}
	
	
	//	method tampil hasil enkripsi
	public String enkripsiKalimatSpiral(String input) {
		
		int jumlahBaris = Spiral.getBaris(input.length());
		int jumlahKolom = Spiral.getKolom(input.length());		
		int panjangKalimat = input.length();
		int centerBaris = Spiral.getCenterBaris(jumlahBaris);
        int centerKolom = Spiral.getCenterKolom(jumlahKolom);
        int pointerBaris = centerBaris;
        int pointerKolom = centerKolom;
        
		String[][] spiral = new String[jumlahBaris][jumlahKolom];
		
		for (int i=0; i <panjangKalimat; i++) {
            int ar = i+1;
            spiral[pointerBaris][pointerKolom] = input.charAt(i) + "";
            int arrowArray = getDirection(ar);
            if (arrowArray == 1) {
                pointerKolom++;
            } else if (arrowArray == 2) {
                pointerBaris++;
            } else if (arrowArray == 3) {
                pointerKolom--;
            } else if (arrowArray == 0) {
                pointerBaris--;
            }
        }
		
		StringBuffer sb = new StringBuffer();
        for (int i=0; i<spiral.length; i++) {
            for (int j=0; j<spiral[i].length; j++) {
                if (spiral[i][j]==null) {
                	sb.append("-");
                } else if (spiral[i][j].equals(" ")) {
                	sb.append("-");
                } else {
                	sb.append(spiral[i][j]);
                }
            }
            
        }        
        input = sb.toString();
        return input;
	}
	
	
	//	method tampil hasil enkripsi
	public String deskripsiKalimatSpiral(String encrypted) {
		
		int jumlahBaris = Spiral.getBaris(encrypted.length());
		int jumlahKolom = Spiral.getKolom(encrypted.length());		
		int panjangKalimat = encrypted.length();
		int centerBaris = Spiral.getCenterBaris(jumlahBaris);
        int centerKolom = Spiral.getCenterKolom(jumlahKolom);
        int pointerBaris = centerBaris;
        int pointerKolom = centerKolom;
        
		String[][] spiral = new String[jumlahBaris][jumlahKolom];
		
		int z = 0;
		for(int j = 0; j < jumlahBaris; j ++) {
	        for(int k = 0;k<jumlahKolom;k++) {
	        	spiral[j][k] = encrypted.charAt(z) + "";
	        	z++;
	        }
	    }
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i <panjangKalimat; i++) {
            int ar = i+1;
            if (spiral[pointerBaris][pointerKolom].equals("-")) {
            	sb.append(" ");
            } else {
            	sb.append(spiral[pointerBaris][pointerKolom]);
            }
            
            int arrowArray = getDirection(ar);
            if (arrowArray == 1) {
                pointerKolom++;
            } else if (arrowArray == 2) {
                pointerBaris++;
            } else if (arrowArray == 3) {
                pointerKolom--;
            } else if (arrowArray == 0) {
                pointerBaris--;
            }
        }
		
        encrypted = sb.toString();
        return encrypted;
	}
	
}
