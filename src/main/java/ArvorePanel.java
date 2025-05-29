import javax.swing.*;
import java.awt.*;

public class ArvorePanel extends JPanel {
    private ArvoreRubroNegra arvore;

    public ArvorePanel(ArvoreRubroNegra arvore) {
        this.arvore = arvore;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharArvore(g, arvore.getRaiz(), getWidth() / 2, 30, getWidth() / 4);
    }

    private void desenharArvore(Graphics g, No no, int x, int y, int distancia) {
        if (no == null) return;

        g.setColor(no.cor ? Color.RED : Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(no.valor), x - 6, y + 4);

        if (no.esquerda != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x - distancia, y + 50);
            desenharArvore(g, no.esquerda, x - distancia, y + 50, distancia / 2);
        }

        if (no.direita != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x + distancia, y + 50);
            desenharArvore(g, no.direita, x + distancia, y + 50, distancia / 2);
        }
    }

    public void atualizar() {
        repaint();
    }
}
