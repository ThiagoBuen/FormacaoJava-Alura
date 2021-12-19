
public class SistemaInterno {
	
	private int senha = 2222;
	
	public void autentica(Autenticavel aut) {
		boolean autenticou = aut.autentica(this.senha);
		if(autenticou) {
			System.out.println("Pode entrar no sistema");			
		}else {
			System.out.println("Acesso negado");
		}
	}
}
