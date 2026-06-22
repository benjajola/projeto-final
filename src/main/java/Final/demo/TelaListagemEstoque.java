package Final.demo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaListagemEstoque extends JFrame {
    private JTable tabela = new JTable();

    public TelaListagemEstoque(Produtorepository repo) {
        setTitle("Produtos Cadastrados");
        setSize(400, 300);
        
        // Criando a tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Qtd");
        
        // Buscando dados do banco
        List<Produto> lista = repo.findAll();
        for (Produto p : lista) {
            model.addRow(new Object[]{p.getId(), p.getNome(), p.getQuantidade()});
        }
        
        tabela.setModel(model);
        add(new JScrollPane(tabela));
        setVisible(true);
    }
}