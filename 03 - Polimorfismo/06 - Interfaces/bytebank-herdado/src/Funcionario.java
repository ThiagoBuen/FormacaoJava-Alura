
public abstract class Funcionario {	//não se instancia objetos de classes abstratas (new Funcionario)
	private String nome;			//Herança e polimorfismo são válidas
	private String cpf;
	private double salario;			//protected - público para os filhos e outras classes private
	
	public Funcionario(String nome, String cpf, double salario) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setSalario(salario);
	}
	
	
	public Funcionario() {

	}
	
	public abstract double getBonificacao();		//método sem corpo, sem implementação
													//apenas os filhos implementam esse método
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
