
public class TesteGerente {
	public static void main(String[] args) {
		Gerente g1 = new Gerente();
		
		g1.setNome("Ahab");
		g1.setSalario(3300);
		g1.setSenha(303);
		
		Funcionario f1 = new Gerente();
		
		f1.setNome("Joao das neves");
		f1.setSalario(300);
		
		EditorVideo ed1 = new EditorVideo();
		
		ed1.setNome("Edinho");
		ed1.setSalario(300);
		
		Designer ds = new Designer();
		ds.setSalario(2000);
		
		
		System.out.println(g1.autentica(303));
		
		
		System.out.println(g1.getBonificacao());
		
		ControleBonificacao controle = new ControleBonificacao();
		
		controle.registra(g1);
		
		System.out.println(controle.getSoma());
		
		controle.registra(f1);
		
		System.out.println(controle.getSoma());
		
		controle.registra(ed1);
		
		System.out.println(controle.getSoma());
		
		controle.registra(ds);
		
		System.out.println(controle.getSoma());
		
		
	}
}
