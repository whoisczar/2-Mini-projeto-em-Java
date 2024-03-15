package projetojava2poo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Pessoa {
  String nome;
  Date dataNascimento;
  int idade;

  public static Date pedir_data() {
    int opt;
    Date data = null;//Variável mais importante de tudo
    String data_aux;//String auiliar
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");//Formato das datas personalizado
    formato.setLenient(false); //Não deixa inserir datas malucas

    while (data == null) {
      
      //Entrada de dados
      data_aux = JOptionPane.showInputDialog(null,"Informe a data de nascimento seguindo o padrão DD/MM/YYYY");
      
      //Se a pessoa cancelar
      if(data_aux==null) return null;
      
      //Se a pesoa não inseriu nada
      if (data_aux.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nenhuma informação inserida", "Erro!", JOptionPane.PLAIN_MESSAGE);
        continue;
      }
      
      try { //Se tudo estiver ok já vai dar tudo certo aqui e fé
        data = formato.parse(data_aux);
      } catch (ParseException e) { //Se entrou aqui é pq a data está no formato errado
        JOptionPane.showMessageDialog(null, "Formato de data inválido!\nPor favor, insira a data no formato DD/MM/YYYY.", "Erro", JOptionPane.PLAIN_MESSAGE);
      }

    }

    return data;
  }

  public static int calcular_idade(Date data_aux) {
    //Variável da idade do usuário
    int idade;
    //Data de nascimento atual
    Calendar hoje = Calendar.getInstance();
    hoje.getTime();
    //Data do usuário
    Calendar usuario_data = Calendar.getInstance();
    usuario_data.setTime(data_aux);
    //Variável para descobrir idade
    idade = hoje.get(Calendar.YEAR) - usuario_data.get(Calendar.YEAR);
    System.out.print(idade);
    //Booleanas para me chatear
    Boolean mes = hoje.get(Calendar.MONTH) < usuario_data.get(Calendar.MONTH);
    Boolean dia = (hoje.get(Calendar.MONTH) == usuario_data.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < usuario_data.get(Calendar.DAY_OF_MONTH));
    //Verificação
    if (mes || dia) {
      idade--;
    }
    //Volta
    return idade;
  }

  public static void todas_informacoes(Pessoa usuario) {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");//Formatar a data
    formato.setLenient(false);//Não deixar a data ficar maluca
    JOptionPane.showMessageDialog(null, "Nome:" + usuario.nome + "\nData de nascimento: " + formato.format(usuario.dataNascimento) + "\nIdade: " + usuario.idade, "Informações Gerais", JOptionPane.PLAIN_MESSAGE);
  }
}