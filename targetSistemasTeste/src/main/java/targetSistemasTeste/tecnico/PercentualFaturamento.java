package targetSistemasTeste.tecnico;

import java.util.HashMap;
import java.util.Map;

public class PercentualFaturamento {
	public static void main(String[] args) {
		// Dados de faturamento por estado
		Map<String, Double> faturamentoPorEstado = new HashMap<>();
		faturamentoPorEstado.put("SP", 67836.43);
		faturamentoPorEstado.put("RJ", 36678.66);
		faturamentoPorEstado.put("MG", 29229.88);
		faturamentoPorEstado.put("ES", 27165.48);
		faturamentoPorEstado.put("Outros", 19849.53);

		// Calcular o faturamento total
		double totalFaturamento = faturamentoPorEstado.values().stream().mapToDouble(Double::doubleValue).sum();

		// Calcular e exibir o percentual de representação de cada estado
		System.out.println("Percentual de Representação por Estado:");
		for (Map.Entry<String, Double> valor : faturamentoPorEstado.entrySet()) {
			String estado = valor.getKey();
			double faturamento = valor.getValue();
			double percentual = (faturamento / totalFaturamento) * 100;
			System.out.printf("%s: %.2f%%\n", estado, percentual);
		}
	}
}