package Final.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;

@Component
public class TelaFuncionarios extends JFrame {

    private final FuncionarioRepository repository; // Mude conforme a tela
    
    // 1. Defina os campos aqui
    private JTextField txtNome = new JTextField(15);
    private JTextField txtCargo = new JTextField(15);
    private JButton btnSalvar = new JButton("Salvar");

    @Autowired
    public TelaFuncionarios(FuncionarioRepository repository) {
        this.repository = repository;
        
        setTitle("Cadastro de Funcionários");
        setSize(300, 250);
        setLayout(new GridLayout(4, 2, 10, 10)); // Grid ajuda a organizar

        // 2. Adicione os campos na tela
        add(new JLabel(" Nome:"));
        add(txtNome);
        add(new JLabel(" Cargo:"));
        add(txtCargo);
        add(new JLabel("")); 
        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvar());
        setLocationRelativeTo(null);
    }

    private void salvar() {
        // 3. Lógica de salvar
        Funcionario f = new Funcionario();
        f.setNome(txtNome.getText());
        f.setCargo(txtCargo.getText());
        repository.save(f);
        JOptionPane.showMessageDialog(this, "Salvo!");
    }
}