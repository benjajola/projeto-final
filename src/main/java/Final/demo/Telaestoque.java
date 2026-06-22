package Final.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;

@Component
public class Telaestoque extends JFrame {

    private final Produtorepository repository;
    
    // Componentes da tela
    private JTextField txtNome = new JTextField(15);
    private JTextField txtQuantidade = new JTextField(5);
    private JButton btnSalvar = new JButton("Salvar");

    @Autowired
    public Telaestoque(Produtorepository repository) {
        this.repository = repository;
        
        setTitle("Controle de Estoque");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Qtd:"));
        add(txtQuantidade);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvar());
        
        setLocationRelativeTo(null);
    }

    private void salvar() {
        try {
            String nome = txtNome.getText();
            int qtd = Integer.parseInt(txtQuantidade.getText());
            
            // Supondo que sua classe Produto tenha esse construtor
            Produto p = new Produto(nome, qtd);
            repository.save(p);
            
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
            txtNome.setText("");
            txtQuantidade.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: Verifique os dados.");
        }
    }
}