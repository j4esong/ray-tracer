
class Plane extends Surface {

	public double z = 0;

	public Plane(double z) {
		super();
		this.z = z;
		this.phong = 0;
	}

	@Override
	public boolean hit(Ray ray, double t0, double t1, HitRecord record) {
		if (ray.d.values[2] == 0)
			return false;
		double t = (z - ray.e.values[2]) / ray.d.values[2];
		record.t = t;
		record.p = ray.e.add(ray.d.multiply(record.t));
		record.normal = new Vector3D(0, 0, 1);
		return inRange(t, t0, t1);
	}

}