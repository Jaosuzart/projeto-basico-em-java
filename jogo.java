import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class jogo extends JPanel implements ActionListener, KeyListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int TAMANHO_BLOCO = 10;
    private final int LARGURA = 300;
    private final int ALTURA = 300;
    private int[] x = new int[900], y = new int[900];
    private int tamanhoCobra = 5;
    private char direcao = 'R';
    private Timer timer;
    private boolean emJogo = true;

    public void JogoCobrinha() {
        setPreferredSize(new Dimension(LARGURA, ALTURA));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        iniciarJogo();
    }

    public void iniciarJogo() {
        for (int i = 0; i < tamanhoCobra; i++) {
            x[i] = 50 - (i * TAMANHO_BLOCO);
            y[i] = 50;
        }
        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (emJogo) {
            g.setColor(Color.green);
            for (int i = 0; i < tamanhoCobra; i++) {
                g.fillRect(x[i], y[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
            }
        } else {
            g.setColor(Color.red);
            g.drawString("Game Over!", LARGURA / 2 - 30, ALTURA / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (emJogo) {
            for (int i = tamanhoCobra; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            if (direcao == 'R') x[0] += TAMANHO_BLOCO;
            if (direcao == 'L') x[0] -= TAMANHO_BLOCO;
            if (direcao == 'U') y[0] -= TAMANHO_BLOCO;
            if (direcao == 'D') y[0] += TAMANHO_BLOCO;

            if (x[0] >= LARGURA || x[0] < 0 || y[0] >= ALTURA || y[0] < 0) emJogo = false;

            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_LEFT) && direcao != 'R') direcao = 'L';
        if ((key == KeyEvent.VK_RIGHT) && direcao != 'L') direcao = 'R';
        if ((key == KeyEvent.VK_UP) && direcao != 'D') direcao = 'U';
        if ((key == KeyEvent.VK_DOWN) && direcao != 'U') direcao = 'D';
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo da Cobrinha");
        jogo jogo = new jogo();
        frame.add(jogo);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
