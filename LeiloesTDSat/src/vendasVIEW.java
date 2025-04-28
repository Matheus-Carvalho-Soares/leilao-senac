import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        listarProdutosVendidos();
    }

    private void initComponents() {
        setTitle("Vendas");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);

        tabelaVendas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabelaVendas);

        tabelaVendas.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nome", "Valor", "Status"}
        ));

        add(scrollPane);
    }

    private JTable tabelaVendas;

    private void listarProdutosVendidos() {
        try {
            ProdutosDAO produtosdao = new ProdutosDAO();
            DefaultTableModel model = (DefaultTableModel) tabelaVendas.getModel();
            model.setNumRows(0);

            ArrayList<ProdutosDTO> lista = produtosdao.listarProdutosVendidos();
            for (ProdutosDTO produto : lista) {
                model.addRow(new Object[]{
                        produto.getId(),
                        produto.getNome(),
                        produto.getValor(),
                        produto.getStatus()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vendas: " + e.getMessage());
        }
    }
}
