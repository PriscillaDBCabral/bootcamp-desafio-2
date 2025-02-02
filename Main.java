public class Main {
	public static void main(String[] args) {
		Banco banco = Banco.getInstance();
		banco.setNome("Banco Priscilla");

		BancoFacade bancoFacade = new BancoFacade();

		Cliente cliente1 = new Cliente();
		cliente1.setNome("Priscilla");
		cliente1.setRendaMensal(5000);
		cliente1.setEstrategiaEmprestimo(new JurosSimples(5));

		bancoFacade.criarContaCorrente(cliente1);
		bancoFacade.criarContaPoupanca(cliente1);

		cliente1.solicitarEmprestimo(12, 2000);
		cliente1.exibirEmprestimos();
	}
}
