package procedural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Adicao {
	static List<String> listaDeNomes = new ArrayList<String>();
	static List<Float> listaDeMedias = new ArrayList<Float>();
	static List<Integer> listaDeIdades = new ArrayList<Integer>();
	static List<String> listaDeEscolaridades = new ArrayList<String>();

	static int novoAluno = 0;
	static int qtdNotas;
	static float[] notas;
	static int somaDasNotas = 0;

	public static void main(String[] args) {

		autenticar();
		matricular();
		exibirRelatorio();
	}

	static void exibirRelatorio() {
		for (int i = 0; i < listaDeIdades.size(); i++) {
			String msg = "Nome: " + listaDeNomes.get(i);
			msg += "\nMedia: " + listaDeMedias.get(i);
			msg += "\nIdade: " + listaDeIdades.get(i);
			msg += "\nEscolaridade: " + listaDeEscolaridades.get(i);
			JOptionPane.showMessageDialog(null, msg, "Aluno " + listaDeNomes.get(i), JOptionPane.PLAIN_MESSAGE);
		}
	}

	static void matricular() {
		while (novoAluno == 0) {
			somaDasNotas = 0;

			String nome = JOptionPane.showInputDialog("Digite seu nome por favor: ");
			listaDeNomes.add(nome);

			int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade por favor: "));
			listaDeIdades.add(idade);

			String escolaridade = JOptionPane.showInputDialog("Digite sua escolaridade por favor: ");
			listaDeEscolaridades.add(escolaridade);

			qtdNotas = Integer.parseInt(JOptionPane.showInputDialog("Quantas notas você quer adicionar?"));
			notas = new float[qtdNotas];

			for (int i = 0; i < qtdNotas; i++) {
				notas[i] = Float
						.parseFloat(JOptionPane.showInputDialog("Por favor, digite sua nota numero " + (i + 1)));
				somaDasNotas += notas[i];
			}
			int faltas = Integer.parseInt(JOptionPane.showInputDialog("Quantas faltas voce tem?"));
			Object[] options = { "Sim", "Nao" };
			int trabalhoNoturno = JOptionPane.showOptionDialog(null, "Voce trabalha de noite?", "Trabalho noturno",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

			System.out.println(trabalhoNoturno);

			float media = somaDasNotas / qtdNotas;

			listaDeMedias.add(media);

			String msg = "Voce faltou " + faltas + " vezes e sua media e " + media + "\n Voce esta ";

			if (media >= 4 && media < 7) {
				if (faltas < 10) {
					msg += "recuperacao, porque sua media esta entre 4 e 7 e voce tem menos de 10 faltas";
				} else {
					msg += "reprovado, porque voce faltou mais de 10 vezes, apesar de sua media estar entre 4 e 7";
				}
			} else if (media >= 7 && media < 9) {
				if (faltas < 3) {
					msg += "aprovado, pois sua media esta entre 7 e 9, e voce possui menos de 3 faltas";
				} else if (trabalhoNoturno == 0) {
					msg += "aprovado, pois sua media esta entre 7 e 9, e voce trabalha a noite";
				} else {
					msg += "recuperacao, pois sua nota esta entre 7 e 9, mas voce nao trabalha a noite e tem mais de 2 faltas";
				}
			} else if (media < 4) {
				msg += "reprovado, pois sua media e menor que 4";
			} else {
				msg += "aprovado direto, pois sua nota e maior ou igual a 9";
			}

			JOptionPane.showMessageDialog(null, msg, "Calcular Media do Aluno", JOptionPane.PLAIN_MESSAGE);

			Object[] options2 = { "Sim", "Nao" };
			novoAluno = JOptionPane.showOptionDialog(null, "Quer cadastrar um novo aluno?", "Novo aluno",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options2, options2[0]);
		}
	}

	static void autenticar() {
		// Login
		boolean loginErrado = true;

		String usuarioLogado = "";
		String passwordLogado = "";

		Map<String, String> usuarios = new HashMap<String, String>();
		usuarios.put("p", "p");
		usuarios.put("diretor", "diretor");
		usuarios.put("coodenador", "coordenador");

		while (loginErrado) {
			String nomeDeUsuario = JOptionPane.showInputDialog("Por favor, digite seu nome de usuario");
			String password = JOptionPane.showInputDialog("Por favor, digite sua senha");

			for (Map.Entry<String, String> usuario : usuarios.entrySet()) {
				if (usuario.getKey().equals(nomeDeUsuario) && usuario.getValue().equals(password)) {
					usuarioLogado = nomeDeUsuario;
					passwordLogado = password;
					loginErrado = false;
					break;
				}

			}
		}
	}
}
