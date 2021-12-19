
// Gerente é um funcionário, assina o contrato Autenticavel

public class Gerente extends Funcionario implements Autenticavel{
	
	private AutenticacaoUtil autenticador;
	
	public Gerente() {
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
		return 150;
	}
	
	
	
}
