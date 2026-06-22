package Final.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;

@Component
public class TelaPratos extends JFrame {

    private final PratoRepository repository; // Mudamos o tipo aqui

    private JTextField txtNome = new JTextField(15);
    private JTextField txtPreco = new JTextField(15); // Mudamos de Cargo para Preço
    private JButton btnSalvar = new JButton("Salvar");

    public TelaPratos(PratoRepository repository) { // Mudamos o tipo aqui
        this.repository = repository;

        setTitle("Cadastro de Pratos");
        setSize(300, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Preço:"));
        add(txtPreco);
        add(new JLabel(""));
        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvar());
        setLocationRelativeTo(null);
    }

    private void salvar() {
        Prato p = new Prato(); // Mudamos para a classe Prato
        p.setNome(txtNome.getText());
        
        // Convertendo o texto do preço para número (Double)
        try {
            p.setPreco(Double.parseDouble(txtPreco.getText()));
            repository.save(p);
            JOptionPane.showMessageDialog(this, "Prato salvo!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: O preço deve ser um número!");
        }
    }
}