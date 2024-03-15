package projetojava2poo;
import javax.swing.JOptionPane;
public class ProjetoJava2POO {

  public static void main(String[] args) {
    Pessoa p = new Pessoa();
    int loop = 0;
    //Informar o nome
    do {
      //Pede o nome do úsuario
      p.nome = JOptionPane.showInputDialog("Informe seu nome");
      
      //Caso cancele
      if(p.nome==null)break;
      
      //Caso o campo esteja nulo
      if(p.nome.isEmpty()){
        JOptionPane.showMessageDialog(null, "Campo vazio!\nInsira um nome válido!", "Erro!", JOptionPane.WARNING_MESSAGE);
        continue;
      }
      
      //Informar a data de nascimento
      p.dataNascimento = Pessoa.pedir_data();
      if(p.dataNascimento==null)continue;
      
      //Cálculo de data
      p.idade = Pessoa.calcular_idade(p.dataNascimento);
      
      //Todas informações do usuário
      if (p.idade >= 0) Pessoa.todas_informacoes(p);
      
      //Reiniciar programa?
      loop = JOptionPane.showConfirmDialog(null, "Deseja usar o programa novamente?","Novamente?",JOptionPane.YES_NO_OPTION);
    } while (loop != JOptionPane.NO_OPTION);
  }
}