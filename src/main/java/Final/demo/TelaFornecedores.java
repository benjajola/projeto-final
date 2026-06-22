package Final.demo;

import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;

@Component
public class TelaFornecedores extends JFrame {

    // 1. Usamos o Repository correto
    private final FornecedorRepository repository;

    private JTextField txtNome = new JTextField(15);
    private JTextField txtTelefone = new JTextField(15);
    private JButton btnSalvar = new JButton("Salvar");

    // 2. O construtor recebe o Repository correto
    public TelaFornecedores(FornecedorRepository repository) {
        this.repository = repository;

        setTitle("Cadastro de Fornecedores");
        setSize(300, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Telefone:"));
        add(txtTelefone);
        add(new JLabel(""));
        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvar());
        setLocationRelativeTo(null);
    }

    private void salvar() {
        // 3. Criamos o objeto Fornecedor, não Prato
        Fornecedor f = new Fornecedor();
        f.setNome(txtNome.getText());
        f.setTelefone(txtTelefone.getText());

        // 4. Salvamos no repositório de Fornecedores
        repository.save(f);
        
        JOptionPane.showMessageDialog(this, "Fornecedor salvo com sucesso!");
        dispose(); // Fecha a tela após salvar
    }
}