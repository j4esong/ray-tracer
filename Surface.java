abstract class Surface {

	public byte[] ambientBGR, diffuseBGR, specularBGR; 
	public double phong;

	public abstract boolean hit(Ray r, double t0, double t1, HitRecord record);

	public Surface() {
		ambientBGR = new byte[3];
		diffuseBGR = new byte[3];
		specularBGR = new byte[3];
		phong = 100;
	}

	public boolean inRange(double t, double t0, double t1) {
		return t >= t0 && t <= t1;
	}

}