package Final.demo;

import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;

@Component
public class TelaVendas extends JFrame {
    
    private final VendaRepository repository;

    public TelaVendas(VendaRepository repository) {
        this.repository = repository;
        
        // 1. Configurações da Janela
        setTitle("Gerenciar Vendas");
        setSize(400, 300);
        // IMPORTANTE: Use DISPOSE_ON_CLOSE para não fechar o programa inteiro ao fechar essa tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLayout(new GridLayout(4, 1, 10, 10)); // Layout simples para organizar em linhas

        // 2. Criando componentes
        JLabel label = new JLabel("Digite o valor da venda:");
        JTextField txtValor = new JTextField();
        JButton btnSalvar = new JButton("Salvar Venda");

        // 3. Adicionando na tela (O "add" faz a mágica)
        add(label);
        add(txtValor);
        add(btnSalvar);

        // 4. Ação do botão (Exemplo)
        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Botão Salvar clicado! Valor: " + txtValor.getText());
        });

        setLocationRelativeTo(null); // Centraliza a tela
    }
}