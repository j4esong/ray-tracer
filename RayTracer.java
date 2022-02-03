
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.util.List;
import java.util.ArrayList;

class RayTracer {

    final static int WIDTH = 800;
    final static int HEIGHT = 600;

    public static void main(String[] args) {

        List<Surface> surfaces = new ArrayList<>();
        Camera cam = new Camera(new Vector3D(0, 0, 100), new Vector3D(-1, 0, 0), new Vector3D(0, 0, 1));

        RenderPanel panel = new RenderPanel(WIDTH, HEIGHT, surfaces, cam);
        JFrame frame = new JFrame("Ray Tracer");

        frame.setResizable(false);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        panel.addLight(new Light(0.5, new Vector3D(300, -200, 200)));
        panel.addLight(new Light(0.5, new Vector3D(300, 100, 130)));

        Sphere s = new Sphere(new Vector3D(800, 0, 40), 40);
        s.setRGB(75, 75, 75);

        Sphere s1 = new Sphere(new Vector3D(700, -80, 40), 40);
        s1.setRGB(35, 65, 5);

        Plane p = new Plane(0);
        p.setRGB(35, 35, 35);

        surfaces.add(s);
        surfaces.add(s1);
        surfaces.add(p);

        panel.render();

    }

}