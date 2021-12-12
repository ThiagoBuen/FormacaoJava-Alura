
public class testaConversao {
	public static void main(String[] args) {
		double salario = 1280.50;				//double, int - primitivo
		int valor = (int)salario;				//casting
		System.out.println(valor);
		
		long numeroGrande = 12371742132123l;		//64 bytes?
		System.out.println(numeroGrande);
		
		short valorPequeno = 12374;		//2^15
		
		byte b = 127;		//-127 a 127
		
		double valor1 = 0.2;
		double valor2 = 0.1;
		
		double total = valor1 + valor2;
		
		System.out.println(total);
		
	}
}
