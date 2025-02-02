import java.util.ArrayList;
import java.util.List;

// Singleton - Garantindo que haja apenas uma instância do banco
public class Banco {
	private static Banco instancia;
	private String nome;
	private List<Conta> contas = new ArrayList<>();

	private Banco() {}

	public static Banco getInstance() {
		if (instancia == null) {
			instancia = new Banco();
		}
		return instancia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}

	public void listarContas() {
		System.out.println("=== Contas no Banco ===");
		for (Conta conta : contas) {
			System.out.println(String.format("Titular: %s - Agencia: %d - Conta: %d", conta.cliente.getNome(), conta.getAgencia(), conta.getConta()));
		}
	}
}
// Strategy - Estratégia de cálculo de juros para empréstimos
interface EstrategiaEmprestimo {
	double calcularJuros(double valor, int numeroParcelas);
}

class JurosSimples implements EstrategiaEmprestimo {
	private int jurosPercentual;

	public JurosSimples(int jurosPercentual) {
		this.jurosPercentual = jurosPercentual;
	}

	@Override
	public double calcularJuros(double valor, int numeroParcelas) {
		return valor * (1 + (jurosPercentual / 100.0) * numeroParcelas);
	}
}