/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Entidades.Contato;
import Entidades.Telefone;
import Entidades.TipoContato;
import ImplementsDAO.ContatoDAOImplements;
import ImplementsDAO.TipoContatoDAOImplements;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.FileWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class JPanelRelatorio extends javax.swing.JPanel implements InterfaceGerenciaTabela {

    private static List<Object> CONTATOS = new ArrayList<>();

    /**
     * Creates new form JPanelRelatorio
     *
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public JPanelRelatorio() throws ClassNotFoundException, SQLException {
        initComponents();
        carregaTipoContatoComboBox(JPanelContatos.listaComboBoxTipoContato());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Jpanel = new javax.swing.JPanel();
        jLabelRelatorio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonGerarRelatorio = new javax.swing.JButton();
        jComboBoxRelatorio = new javax.swing.JComboBox<>();
        jButtonVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        Jpanel.setLayout(new java.awt.GridBagLayout());

        jLabelRelatorio.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabelRelatorio.setText("RELATÓRIOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(38, 29, 20, 35);
        Jpanel.add(jLabelRelatorio, gridBagConstraints);

        jLabel1.setText("Filtrar por tipo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        Jpanel.add(jLabel1, gridBagConstraints);

        jButtonGerarRelatorio.setText("Export to .CSV");
        jButtonGerarRelatorio.setBorder(null);
        jButtonGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarRelatorioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 14, 0);
        Jpanel.add(jButtonGerarRelatorio, gridBagConstraints);

        jComboBoxRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRelatorioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        Jpanel.add(jComboBoxRelatorio, gridBagConstraints);

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        Jpanel.add(jButtonVoltar, gridBagConstraints);

        add(Jpanel, new java.awt.GridBagConstraints());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Email", "Nascimento", "Tipo Contato"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(18, 7, 0, 8);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRelatorioActionPerformed
        try {
            TipoContatoDAOImplements tipoDaoImp = new TipoContatoDAOImplements();
            ContatoDAOImplements contatoDAOImp = new ContatoDAOImplements();
            String tipoSelecao = jComboBoxRelatorio.getSelectedItem().toString();
            if (tipoSelecao.equals("Todos")) {
                CONTATOS = contatoDAOImp.pesquisarTodos();
            }else{
                TipoContato tipoContatoSelecionado = tipoDaoImp.pesquisarNome(tipoSelecao);
                CONTATOS = contatoDAOImp.pesquisarPorTipoContato(tipoContatoSelecionado.getId());
            }
            List<Object> listaFiltro = CONTATOS;
            carregaTabela(listaFiltro);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jComboBoxRelatorioActionPerformed

    private void jButtonGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarRelatorioActionPerformed
        List<Object> listaFiltro = CONTATOS;
        geraCSV(listaFiltro);
    }//GEN-LAST:event_jButtonGerarRelatorioActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        Principal.chamaTelaContatos();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    public void geraCSV(List<Object> lista) {
        String filename = "contatos.csv";
        try {
            FileWriter fw = new FileWriter(filename);
            List<Object> listaContatos = lista;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Object obj : listaContatos) {
                Contato c = (Contato) obj;
                fw.append(c.getId().toString());
                fw.append(',');
                fw.append(c.getNome());
                fw.append(',');
                fw.append(c.getEmail());
                fw.append(',');
                fw.append(sdf.format(c.getNascimento()));
                fw.append(',');
                fw.append(c.getTipoContato().getNome());
                fw.append(',');
                if(c.getTelefones().size() > 0)
                    for(Telefone t : c.getTelefones()){
                        fw.append("(" + t.getDDD().toString() + ") ");
                        fw.append(t.getNumero());
                        fw.append(',');
                    }
                fw.append('\n');
            }
            fw.flush();
            fw.close();
            JOptionPane.showMessageDialog(null, "Exportado para pasta de projeto");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JButton jButtonGerarRelatorio;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public final void carregaTipoContatoComboBox(List<Object> lista) {
        List<Object> listaTipos = lista;
        TipoContato filtroTipoContatoTodos = new TipoContato();
        filtroTipoContatoTodos.setNome("Todos"); 
        listaTipos.add(0,filtroTipoContatoTodos);
        if (listaTipos != null) {
            for (Object obj : listaTipos) {
                TipoContato tipoContato = (TipoContato) obj;
                jComboBoxRelatorio.addItem(tipoContato.getNome());
            }
        }

    }

    @Override
    public void carregaTabela(List<Object> lista) {
        List<Object> listaContatos = lista;
        String[] colunas = {"Código", "Nome", "Email", "Nascimento", "Tipo Contato"};
        String[][] dados = new String[listaContatos.size()][colunas.length];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < listaContatos.size(); i++) {
            Contato contato = (Contato) listaContatos.get(i);
            dados[i][0] = String.valueOf(contato.getId());
            dados[i][1] = contato.getNome();
            dados[i][2] = contato.getEmail();
            dados[i][3] = sdf.format(contato.getNascimento());
            dados[i][4] = contato.getTipoContato().getNome();
        }
        DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
        jTable1.setModel(modelo);
    }

    @Override
    public boolean camposPreenchidos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object retornaSelecionadoTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       

}
