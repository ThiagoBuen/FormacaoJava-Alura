
// Gerente � um funcion�rio

public class Gerente extends Funcionario{
	
	private int senha;
	
	
	
	public boolean autentica(int senha) {
		if(this.senha == senha) {
			return true;
		}else {
			return false;
		}
	}
	
	public double getBonificacao() { 		//Reescrita do m�todo
		return super.getBonificacao() + super.getSalario();
	}
	
	public int getSenha() {
		return this.senha;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
	
}
