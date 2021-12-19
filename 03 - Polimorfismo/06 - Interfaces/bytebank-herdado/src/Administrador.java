
public class Administrador extends Funcionario implements Autenticavel{

	private AutenticacaoUtil autenticador;
	
	public Administrador() {
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
	
	@Override
	public double getBonificacao() {
		// TODO Auto-generated method stub
		return 50;
	}

}
