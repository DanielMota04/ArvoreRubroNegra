import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArvoreRubroNegra arvore = new ArvoreRubroNegra();
            ArvorePanel painel = new ArvorePanel(arvore);

            JFrame frame = new JFrame("Árvore Rubro-Negra");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            JButton botaoInserir = new JButton("Inserir");
            botaoInserir.setBounds(10, 10, 100, 30);
            frame.add(botaoInserir);

            JTextField campoValor = new JTextField();
            campoValor.setBounds(120, 10, 100, 30);
            frame.add(campoValor);

            painel.setBounds(10, 50, 760, 500);
            frame.add(painel);

            botaoInserir.addActionListener(e -> {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    arvore.inserir(valor);
                    painel.atualizar();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                }
            });

            frame.setVisible(true);
        });
    }
}
