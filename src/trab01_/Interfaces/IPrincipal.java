/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab01_.Interfaces;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import trab01_.Codigos.Graph;
import trab01_.Codigos.ListAdjacency;
import trab01_.Codigos.MatrixAdjacency;


/**
 *
 * @author user
 */
public class IPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public IPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arqName = new javax.swing.JTextField();
        arqLabel = new javax.swing.JLabel();
        matrizBtn = new javax.swing.JButton();
        listaBtn = new javax.swing.JButton();
        dovinLabel = new javax.swing.JLabel();
        fabinLabel = new javax.swing.JLabel();
        luquinhaLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sisteminha de Grafos");

        arqName.setToolTipText("Ex.: arq.txt");
        arqName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        arqName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arqNameActionPerformed(evt);
            }
        });

        arqLabel.setText("Arquivo:");

        matrizBtn.setText("Carregar como Matriz");
        matrizBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matrizBtnActionPerformed(evt);
            }
        });

        listaBtn.setText("Carregar como Lista");
        listaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaBtnActionPerformed(evt);
            }
        });

        dovinLabel.setText("Arthur Moraes Pires");

        fabinLabel.setText("Fabio da Silva Takaki");

        luquinhaLabel.setText("Lucas Martins Valladares Ribeiro");

        jLabel1.setText("Prof. Danilo Eler Medeiros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arqName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arqLabel)
                    .addComponent(luquinhaLabel)
                    .addComponent(fabinLabel)
                    .addComponent(dovinLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(listaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(matrizBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(arqLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arqName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(listaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matrizBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dovinLabel)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fabinLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(luquinhaLabel)
                .addContainerGap())
        );

        arqName.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arqNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arqNameActionPerformed
        
    }//GEN-LAST:event_arqNameActionPerformed

    private void matrizBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matrizBtnActionPerformed
        String nome = arqName.getText();
        int tipo, tam;
        String valores[];
        
        try {   
            BufferedReader arq = new BufferedReader(new FileReader(nome));
            String line, result[];
            
            line = arq.readLine();
            tipo = Integer.valueOf(line);
            
            line = arq.readLine();
            tam = Integer.valueOf(line);

            Graph g = new Graph(tam, new MatrixAdjacency(tam));
            
            if (tipo == 0){
                while((line = arq.readLine()) != null){
                    valores = line.split(" ");
                    g.addEdge( Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), Integer.parseInt(valores[2]) );
                }
                IGrafo grafo = new IGrafo(g);
                grafo.setVisible(true);
                
            }
            
            else if(tipo == 1){//Caso Digrafo
                while((line = arq.readLine()) != null){
                    valores = line.split(" ");
                    g.addEdgeD( Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), Integer.parseInt(valores[2]) );
                }
                IDigrafo dgrafo = new IDigrafo(g);
                dgrafo.setVisible(true);
            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Arquivo não encontrado", "Erro no carregamento",JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Erro na leitura do Arquivo", "Erro na leitura",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_matrizBtnActionPerformed

    private void listaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaBtnActionPerformed
        String nome = arqName.getText();
        int tipo, tam;
        String valores[];
        
        try {   
            BufferedReader arq = new BufferedReader(new FileReader(nome));
            String line, result[];
            
            line = arq.readLine();
            tipo = Integer.valueOf(line);
            
            line = arq.readLine();
            tam = Integer.valueOf(line);

            Graph g = new Graph(tam, new ListAdjacency(tam));
            
            if (tipo == 0){// Caso for um grafo
                while((line = arq.readLine()) != null){
                    valores = line.split(" ");
                    g.addEdge( Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), Integer.parseInt(valores[2]) );
                }
                IGrafo grafo = new IGrafo(g);
                grafo.setVisible(true);
            }
            else if(tipo == 1){//Caso digrafo
                while((line = arq.readLine()) != null){
                    valores = line.split(" ");
                    g.addEdgeD( Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), Integer.parseInt(valores[2]) );
                }
                IDigrafo dgrafo = new IDigrafo(g);
                dgrafo.setVisible(true);
            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Arquivo não encontrado", "Erro no carregamento",JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Erro na leitura do Arquivo", "Erro na leitura",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_listaBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arqLabel;
    private javax.swing.JTextField arqName;
    private javax.swing.JLabel dovinLabel;
    private javax.swing.JLabel fabinLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton listaBtn;
    private javax.swing.JLabel luquinhaLabel;
    private javax.swing.JButton matrizBtn;
    // End of variables declaration//GEN-END:variables
}
