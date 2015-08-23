package stackOverflow;

import java.awt.Canvas;

import javax.swing.*;
public class Panel {

private static JFrame frame = new JFrame("World Editor v0.1");;
private static JPanel panel = new JPanel();
private static JPanel panel2 = new JPanel();
private static JPanel panel3 = new JPanel();
private static Canvas glCanvas = new Canvas();
private static JMenuBar mb = new JMenuBar();
private static Loader loader;
private static Renderer renderer;
private static File f = new File("Entites.txt");

public static void gui()
{
    panel2.setBorder(BorderFactory.createTitledBorder("Settings"));  
    panel2.setLayout(new GridLayout(1,2));
    panel2.setBackground(Color.GRAY);

    panel3.setBorder(BorderFactory.createTitledBorder("Top Panel"));  
    panel3.setLayout(new GridLayout(1,1));
    panel3.setBackground(Color.YELLOW);


    frame.add(panel2);
    frame.add(panel3);
    frame.setLocationRelativeTo(null);
    frame.add(panel, BorderLayout.WEST);
    frame.setVisible(true);
    frame.setSize(1280, 1024);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.setBackground(Color.GRAY);
    frame.getContentPane().setBackground(Color.GRAY);
    panel.setLayout(new BorderLayout());
}

public static void main(String[] args)
{
    gui();
    setCanvas();
    DisplayManager.createDisplay();
    loader = new Loader();
    renderer = new Renderer();

    float[] vertices =
    { -0.5f, 0.5f, 0f, -0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f,

    0.5f, -0.5f, 0f, 0.5f, 0.5f, 0f, -0.5f, 0.5f, 0f };

    RawModel model = loader.loadToVAO(vertices);

    while (!Display.isCloseRequested())
    {
        renderer.prepare();
        renderer.render(model);
        DisplayManager.updateDisplay();
    }

    DisplayManager.closeDisplay();

}


private static void setCanvas()
{
    glCanvas.setIgnoreRepaint(true);
    glCanvas.setSize(720, 480);
    panel.add(glCanvas, BorderLayout.SOUTH);
    try
    {
        Display.setParent(glCanvas);
    }
    catch (LWJGLException e)
    {
        e.printStackTrace();
    }
}
}
