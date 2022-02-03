
abstract class Surface {

	protected byte[] ambientBGR, diffuseBGR, specularBGR;
	protected double phong;

	public abstract boolean hit(Ray r, double t0, double t1, HitRecord record);

	public Surface() {
		ambientBGR = new byte[3];
		diffuseBGR = new byte[3];
		specularBGR = new byte[3];
		phong = 100;
	}

	public void setRGB(int r, int g, int b) {
		if (!(inRange(r, 0, 255) && inRange(g, 0, 255) && inRange(b, 0, 255)))
			throw new IllegalArgumentException();
		ambientBGR = new byte[] {(byte) b, (byte) g, (byte) r};
		diffuseBGR = new byte[] {(byte) b, (byte) g, (byte) r};
		specularBGR = new byte[] {30, 30, 30};
	}

	protected boolean inRange(double t, double t0, double t1) {
		return t >= t0 && t <= t1;
	}

}