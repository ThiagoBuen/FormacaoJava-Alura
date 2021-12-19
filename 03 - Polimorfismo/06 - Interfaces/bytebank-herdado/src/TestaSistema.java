
public class TestaSistema {
	public static void main(String[] args) {
		Gerente g = new Gerente();
		g.setSenha(2222);
		
		SistemaInterno s1 = new SistemaInterno();
		s1.autentica(g);
		
		Administrador adm = new Administrador();
		adm.setSenha(2222);
		
		s1.autentica(adm);
		
		Cliente cl = new Cliente();
		cl.setSenha(2222);
		
		s1.autentica(cl);
	}
}
