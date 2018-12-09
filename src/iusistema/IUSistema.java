
package iusistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IUSistema {

    private static HashMap<String, Object> cmds = new HashMap<String, Object>();

	private static void addCmds() {

		cmds.put("emp", new EmprestimoCmd());
		cmds.put("dev", new DevolucaoCmd());
		cmds.put("res", new ReservaCmd());
		cmds.put("obs", new ObservadorCmd());
		cmds.put("liv", new ConsultaLivroCmd());
		cmds.put("usu", new ConsultaUsuarioCmd());
		cmds.put("ntf", new NotificacaoCmd());
		cmds.put("sai", new SairCmd());

	}

	private static void tratarDados(String[] parametros) {

		System.out.println("Digite o comando desejado.\n"); // Apagar linha

		// Ler a entrada
		Scanner sc = new Scanner(System.in);
		String stringCmd;
		stringCmd = sc.nextLine();

		// Separa os comandos em uma lista de comandos
		List<String> listaParametros = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(stringCmd);
	    while (st.hasMoreTokens()) {
	    	listaParametros.add(st.nextToken());
	    }

	    int i = 0;
	    for (Iterator iterator = listaParametros.iterator(); iterator.hasNext();) {
	    	parametros[i] = (String) iterator.next();
			i += 1;
		}
	}

	private static void executarComando(String[] parametros) {

		String comando, usuarioId, livroId;
		comando = parametros[0];
		usuarioId = parametros[1];
		livroId = parametros[2];

		Cmd c = (Cmd) cmds.get(comando);
		c.executar(usuarioId, livroId);
	}

    public static void main(String[] args) {

        // Inicializar Sistema
        addCmds();
		String[] parametros;
	    parametros = new String[3];
	    parametros[0] = null;
	    parametros[1] = null;
	    parametros[2] = null;

        // Entrada de dados
	    tratarDados(parametros);

	    executarComando(parametros);
    }

}
