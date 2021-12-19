
public abstract class Funcionario {	//n�o se instancia objetos de classes abstratas (new Funcionario)
	private String nome;			//Heran�a e polimorfismo s�o v�lidas
	private String cpf;
	private double salario;			//protected - p�blico para os filhos e outras classes private
	
	public Funcionario(String nome, String cpf, double salario) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setSalario(salario);
	}
	
	
	public Funcionario() {

	}
	
	public abstract double getBonificacao();		//m�todo sem corpo, sem implementa��o
													//apenas os filhos implementam esse m�todo
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return this.salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
