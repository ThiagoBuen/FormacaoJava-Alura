
public class Cliente implements Autenticavel {

	private AutenticacaoUtil autenticador;
	
	public Cliente() {
		this.autenticador = new AutenticacaoUtil();
	}
	
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}
	

	public int getSenha() {
		return this.autenticador.getSenha();
	}
	
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}
	

}
