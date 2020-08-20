package mines;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class CampoMinado extends JFrame {

    private JLabel quadro;

    public CampoMinado() {
        initUI();
    }

    private void initUI() {

    	quadro = new JLabel("");
        add(quadro, BorderLayout.SOUTH);
        add(new Board(quadro));
        setResizable(false);
        pack();

        setTitle("Campo Minado");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
        	CampoMinado ex = new CampoMinado();
            ex.setVisible(true);
        });
    }
}
