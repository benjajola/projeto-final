package Final.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;

@Component
public class MenuPrincipal extends JFrame {
    
    // Injeta os repositórios aqui para passar para as telas
    @Autowired private FuncionarioRepository funRepo;
@Autowired private Produtorepository prodRepo; // Ajuste o nome conforme seu arquivo
@Autowired private PratoRepository pratoRepo;   // Adicione isso se for usar a 
@Autowired private FornecedorRepository fornecedorRepo;
@Autowired private VendaRepository vendaRepo;
    public MenuPrincipal() {
        setTitle("Sistema de Gerenciamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 10));

        JButton btnFun = new JButton("Gerenciar Funcionários");
        btnFun.addActionListener(e -> new TelaFuncionarios(funRepo).setVisible(true));
        
        JButton btnEst = new JButton("Gerenciar Estoque");
        btnEst.addActionListener(e -> new Telaestoque(prodRepo).setVisible(true));

        add(btnFun);
        add(btnEst);
        // 3. Botão de Pratos
        JButton btnPratos = new JButton("Gerenciar Pratos");
        btnPratos.addActionListener(e -> new TelaPratos(pratoRepo).setVisible(true));
        add(btnPratos);

        // 4. Botão de Listagem
        JButton btnListEstoque = new JButton("Ver Estoque");
        btnListEstoque.addActionListener(e -> new TelaListagemEstoque(prodRepo).setVisible(true));
        add(btnListEstoque);
        setLocationRelativeTo(null);
        
        JButton btnFornecedor = new JButton("Gerenciar Fornecedores");
btnFornecedor.addActionListener(e -> new TelaFornecedores(fornecedorRepo).setVisible(true));
add(btnFornecedor);

JButton btnVendas = new JButton("Gerenciar Vendas"); // Troque o nome do botão se preferir
btnVendas.addActionListener(e -> new TelaVendas(vendaRepo).setVisible(true)); // Troque "TelaVendas" pelo nome da sua classe
add(btnVendas);
        
        
    }
}