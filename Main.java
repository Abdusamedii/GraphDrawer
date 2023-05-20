import com.github.ayaanqui.expressionresolver.Resolver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        drawkodi(0.001);
    }
    public static double[] y(String s, double i){
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
        //System.out.println(res.getLastResult());
        double result = res.getLastResult();



        int increase = 10000;

        values[0] = i * increase;
        values[1] = (result * (-1)) * increase;
        return values;


    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public static void drawkodi(double scale) {

        JFrame f = new JFrame();
        String st = " ";
        st = JOptionPane.showInputDialog("y = ");
        String s = st;

        if (!st.equals("")) {
            JPanel p = new JPanel() {


                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    super.paintComponent(g);
                    int w = f.getWidth();
                    int h = f.getHeight();
                    g2d.setColor(Color.white);
                    g2d.drawLine(0,400,800,400);
                    g2d.drawLine(400,800,400,0);
                    g2d.translate(w / 2, h / 2);
                    g2d.scale(scale, scale);
                    g2d.translate(-w / 2, -h / 2);
                    double max = 0;
                    double min = 0;
                    //long l = System.nanoTime();
                    for (double i = -40; i <= 40; i = i + 0.001) {
                    try {

                        double[] values = y(s, i);
                        //double[] valuess = y(s, (i + 0.001));
                       // double[] valuess2 = x(s1,(i + 0.1));
                       // if((values[1] < 0 && valuess[1] > 0) || (values[1] > 0 && valuess[1] < 0)){ // pastron tan(x) cos(x)
                       //     values[1] = 0;
                       //     valuess[1] = 0;
                        //}
                                g.setColor(Color.red);
                                    g2d.drawOval((int) values[0] + 400, (int) values[1] + 400, 1, 1);
                                    //g2d.drawLine((int) values[0] + 400, (int) values[1] + 400, (int) valuess[0] + 400, (int) valuess[1] + 400);
                                   // g.setColor(Color.blue);
                                   // g2d.drawLine((int) values2[0] + 400, (int) values2[1] + 400, (int) valuess2[0] + 400, (int) valuess2[1] + 400);
                                //System.out.println(values[1]);

                                if (values[1] > max){
                                    max = values[1];
                                }
                                if (values[1] < min){
                                    min = values[1];
                                }
                                //g.setColor(Color.blue);
                                //g2d.drawLine((int) values2[0] + 400, (int) values2[1] + 400, (int) valuess2[0] + 400, (int) valuess2[1] + 400);

                    }
                    catch (NullPointerException e){
                        //System.out.println(e);
                    }



                    }
                    //long elapsedTime = (System.nanoTime() - l)/1000;
                    //System.out.println(elapsedTime);
                    String maximum = ("Min: " + ((float)max/10000) * -1);
                    if (max/10000 > 38){
                        maximum = "i pa definuar";
                    }

                    String Minimum = ("Max: " + ((float)min/10000) * -1);
                    if (min/10000 < (-38)){
                        Minimum = "i pa definuar";
                    }
                    g.setColor(Color.white);
                    boolean calcdistance = (min/10000 < (-38)) && (max/10000 > 38);
                    double distance = 0;
                    if ((max > 0 && min < 0)){
                        distance = max + (min * -1);
                        distance = round(distance,2);
                        distance /= 10000;
                    }
                    if (calcdistance){
                        distance = 0;
                    }
                    if (distance != 0) {
                        System.out.println("\n" + "Distance: " + distance);
                    }
                    else {
                        System.out.println("Distanca e pa definuar");
                    }
                    System.out.println(maximum);
                    System.out.println(Minimum);

                    double epsilon = 0.001;
                    System.out.print("Limx---> " + epsilon + "  " + s + " = ");
                    double[] epsiloni = new double[2];
                    try {


                        epsiloni = y(s, epsilon);
                        epsiloni[1] = round(epsiloni[1], 1);
                    }
                    catch (NullPointerException e){
                        epsiloni[1] = 500000;
                    }
                    if ((epsiloni[1] / 10000) * -1 > 40 || (epsiloni[1] / 10000) * -1 < -40){
                        System.out.println("Limiti divergjohet");
                    }
                    else {
                        System.out.print((epsiloni[1] / 10000) * -1);
                        System.out.println("");
                    }


                    //g2d.drawString("0", 530, 550);
                    //g2d.drawString("100", 450 + 140, 409 + 140);
                    //g2d.drawString("200", 550 + 140, 409 + 140);
                    //g2d.drawString("300", 650 + 140, 409 + 140);
                    //g2d.drawString("400", 750 + 140, 409 + 140);
                    //g2d.drawString("500", 850 + 140, 409 + 140);

                    //g2d.drawString("100", f.getWidth() / 2 - 20, 350 + 140);
                    //g2d.drawString("200", f.getWidth() / 2 - 20, 250 + 140);
                    //g2d.drawString("300", f.getWidth() / 2 - 20, 150 + 140);
                    //g2d.drawString("400", f.getWidth() / 2 - 20, 50 + 140);
                    //g2d.drawString("500", f.getWidth() / 2 - 20, 90);
                    //g.setColor(Color.white);

                    f.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == 82) {
                                f.dispose();
                                drawkodi(0.001);
                            }
                            if (e.getKeyCode() == 38) {
                                //f.dispose();
                                drawkodi(0.005);
                            }

                            if (e.getKeyCode() == 40){
                             drawkodi(0.0005);
                            }
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {


                        }
                    });
                }

            };
            p.setBackground(Color.black);

            f.pack();
            f.setSize(800, 800);
            f.add(p);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setVisible(true);

        }
    }

}
