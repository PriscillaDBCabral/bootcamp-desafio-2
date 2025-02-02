import java.util.List;
import java.util.ArrayList;

class Cliente {
	private String nome;
	private String endereco;
	private double rendaMensal;
	private List<String> emprestimos = new ArrayList<>();
	private EstrategiaEmprestimo estrategiaEmprestimo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String novoEndereco) {
		this.endereco = novoEndereco;
	}

	public double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public void setEstrategiaEmprestimo(EstrategiaEmprestimo estrategia) {
		this.estrategiaEmprestimo = estrategia;
	}

	public void solicitarEmprestimo(int numeroParcelas, double valor) {
		double valorComJuros = estrategiaEmprestimo.calcularJuros(valor, numeroParcelas);
		String emprestimo = String.format("Emprestimo: Valor: %.2f, Parcelas: %d, Total a pagar: %.2f", valor, numeroParcelas, valorComJuros);
		emprestimos.add(emprestimo);
	}

	public void exibirEmprestimos() {
		System.out.println("=== Emprestimos do Cliente ===");
		for (String emprestimo : emprestimos) {
			System.out.println(emprestimo);
		}
	}
}