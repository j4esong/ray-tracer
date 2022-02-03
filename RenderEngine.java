
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.util.List;
import java.util.ArrayList;

class RenderEngine {

    final static int WIDTH = 400;
    final static int HEIGHT = 400;

    public static void main(String[] args) {

        List<Surface> surfaces = new ArrayList<>();
        Camera cam = new Camera(new Vector3D(0, 0, 60), new Vector3D(-1, 0, 0), new Vector3D(0, 0, 1));

        RenderPanel panel = new RenderPanel(WIDTH, HEIGHT, surfaces, cam);
        JFrame frame = new JFrame("Render Engine");

        frame.setResizable(false);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        panel.addLight(new Light(1, new Vector3D(700, -100, 200)));

        Sphere s = new Sphere(new Vector3D(800, 0, 40), 40);
        s.ambientBGR = new byte[] {100, 100, 100};
        s.diffuseBGR = new byte[] {100, 100, 100};
        s.specularBGR = new byte[] {30, 30, 30};

        Plane p = new Plane(0);

        p.ambientBGR = new byte[] {0, 0, 0};
        p.diffuseBGR = new byte[] {100, 100, 100};
        p.specularBGR = new byte[] {30, 30, 30};

        p.phong = 0;

        surfaces.add(s);
        surfaces.add(p);

        panel.render();

    }

}