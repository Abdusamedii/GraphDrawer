import com.github.ayaanqui.expressionresolver.Resolver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {
        drawkodi(1);
    }
    public static double[] y(String s, int i){
        String output;
        com.github.ayaanqui.expressionresolver.Resolver res = new Resolver();
        //System.out.println("x: "+i);
        //if (s.contains("sqr")&&i<0){
        //   i=0;
        //}
        output = s.replace("x",String.valueOf(i));

        res.setExpression(output);
        res.solveExpression();
        //System.out.println("y: " + (int)res.getLastResult());
        double[] values = new double[2];

        values[0] = i;
        values[1] = res.getLastResult() * (-1);
        return values;


    }
    public static void drawkodi(double scale) {
        String st = " ";
        st = JOptionPane.showInputDialog("y = ");
        String s = st;


        JFrame f = new JFrame();
        f.getContentPane().setBackground(Color.black);
        if (!st.equals("")) {
            JPanel p = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {

                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    super.paintComponent(g);
                    int w = f.getWidth();
                    int h = f.getHeight();

                    g2d.translate(w / 2, h / 2);
                    g2d.scale(scale, scale);
                    g2d.translate(-w / 2, -h / 2);
                    for (int i = -540; i <= 540; i++) {

                        double[] values = y(s, i);
                        double[] valuess = y(s, (int) (i + 1));
                        g.setColor(Color.red);
                        //g2d.drawOval((int) values[0]+ 540,(int) values[1] + 540,1,1);

                        g2d.drawLine((int) values[0] + 540, (int) values[1] + 540, (int) valuess[0] + 540, (int) valuess[1] + 540);

                        g.setColor(Color.white);
                        g2d.drawString("0", 530, 550);
                        g2d.drawString("100", 450 + 140, 409 + 140);
                        g2d.drawString("200", 550 + 140, 409 + 140);
                        g2d.drawString("300", 650 + 140, 409 + 140);
                        g2d.drawString("400", 750 + 140, 409 + 140);
                        g2d.drawString("500", 850 + 140, 409 + 140);

                        g2d.drawString("100", f.getWidth() / 2 - 20, 350 + 140);
                        g2d.drawString("200", f.getWidth() / 2 - 20, 250 + 140);
                        g2d.drawString("300", f.getWidth() / 2 - 20, 150 + 140);
                        g2d.drawString("400", f.getWidth() / 2 - 20, 50 + 140);
                        g2d.drawString("500", f.getWidth() / 2 - 20, 90);


                    }


                    g.setColor(Color.white);
                    g.drawLine(540, 1080, 540, 0);
                    g.drawLine(1080, 540, 0, 540);
                    setBackground(Color.black);

                    f.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == 82) {
                                f.dispose();
                                drawkodi(1);
                            }
                            if (e.getKeyCode() == 38) {
                                f.dispose();
                                drawkodi(2);
                            }
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {


                        }
                    });
                }

            };

            f.setSize(1080, 1080);
            f.add(p);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }
    }

}
