//contrato Autenticavel

	//quem assinar esse contrato precisa implementar
		//metodo setSenha
		//metodo autentica

public abstract interface Autenticavel {
	
	//Interface não pode ter nada concreto
	
	public abstract void setSenha(int senha);
	
	public abstract boolean autentica(int senha);


}
