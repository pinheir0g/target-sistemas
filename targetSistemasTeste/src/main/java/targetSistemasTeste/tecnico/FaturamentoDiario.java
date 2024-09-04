package targetSistemasTeste.tecnico;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FaturamentoDiario {

	// Classe para representar o faturamento diário
	static class Faturamento {
		int dia;
		double valor;

		public int getDia() {
			return dia;
		}

		public double getValor() {
			return valor;
		}
	}

	public static void main(String[] args) {
		try {
			// Ler o arquivo JSON
			Gson gson = new Gson();
			Type faturamentoListType = new TypeToken<List<Faturamento>>() {
			}.getType();
			InputStream inputStream = FaturamentoDiario.class.getClassLoader().getResourceAsStream("faturamento.json");
			InputStreamReader reader = new InputStreamReader(inputStream);
			List<Faturamento> faturamentos = gson.fromJson(reader, faturamentoListType);

			double menorFaturamento = Double.MAX_VALUE;
			double maiorFaturamento = Double.MIN_VALUE;
			double somaFaturamento = 0.0;
			int diasComFaturamento = 0;

			// Processar os dados de faturamento
			for (Faturamento f : faturamentos) {
				if (f.getValor() > 0) {
					if (f.getValor() < menorFaturamento) {
						menorFaturamento = f.getValor();
					}
					if (f.getValor() > maiorFaturamento) {
						maiorFaturamento = f.getValor();
					}
					somaFaturamento += f.getValor();
					diasComFaturamento++;
				}
			}

			// Calcular a média
			double mediaMensal = somaFaturamento / diasComFaturamento;

			// Contar dias com faturamento acima da média
			int diasAcimaDaMedia = 0;
			for (Faturamento f : faturamentos) {
				if (f.getValor() > mediaMensal) {
					diasAcimaDaMedia++;
				}
			}

			System.out.println("Menor faturamento: " + menorFaturamento);
			System.out.println("Maior faturamento: " + maiorFaturamento);
			System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
