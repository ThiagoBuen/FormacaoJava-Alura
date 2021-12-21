
public class FluxoComErro {
	public static void main(String[] args) {
		System.out.println("Ini do main");
		metodo1();
		System.out.println("Fim do main");
	}
	
	public static void metodo1() {
		System.out.println("Ini do metodo1");
		metodo2();
		System.out.println("Fim do metodo1");
		throw new MinhaExcecao("deu errado");

	}
	
	public static void metodo2() {
		System.out.println("Ini do metodo2");
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
			try {
				//int a = i / 0;
				Conta c = null;
				c.deposita();
			}
			catch(ArithmeticException | NullPointerException | MinhaExcecao ex){
				String msg = ex.getMessage();
				ex.printStackTrace();
				System.out.println("Exception: " + msg);
			}
				
		}
		
		System.out.println("Fim do metodo2");
	}
}
