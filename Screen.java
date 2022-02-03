
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

class RenderPanel extends JPanel {

	private int width, height;
	public int[] pixels;

	private BufferedImage screen;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		BufferedImage = new BufferedImage
	}

	public void render() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x + y * width] = 0xFFFFFF;
			}
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

}