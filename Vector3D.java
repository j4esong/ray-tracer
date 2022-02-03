
class Vector3D {

	public double[] values;

	public Vector3D(double x, double y, double z) {
		values = new double[3];
		values[0] = x;
		values[1] = y;
		values[2] = z;
	}

	public Vector3D subtract(Vector3D v) {
		return new Vector3D(values[0] - v.values[0], values[1] - v.values[1], values[2] - v.values[2]);
	}

	public Vector3D add(Vector3D v) {
		return new Vector3D(values[0] + v.values[0], values[1] + v.values[1], values[2] + v.values[2]);
	}

	public double dot(Vector3D v) {
		if (v.values.length != values.length)
			throw new IllegalArgumentException();
		double sum = 0;
		for (int i = 0; i < values.length; i++)
			sum += values[i] * v.values[i];
		return sum;
	}

	public Vector3D cross(Vector3D v) {
		return new Vector3D(values[1] * v.values[2] - values[2] * v.values[1],
		                    values[2] * v.values[0] - values[0] * v.values[2],
		                    values[0] * v.values[1] - values[1] * v.values[0]);
	}

	public Vector3D multiply(double s) {
		return new Vector3D(values[0] * s, values[1] * s, values[2] * s);
	}

	public Vector3D divide(double s) {
		return this.multiply(1.0 / s);
	}

	public Vector3D normalize() {
		return new Vector3D(values[0] / magnitude(), values[1] / magnitude(), values[2] / magnitude());
	}

	public double magnitude() {
		return Math.sqrt(Math.pow(values[0], 2) + Math.pow(values[1], 2) + Math.pow(values[2], 2));
	}

	@Override
	public String toString() {
		return "{" + values[0] + " " + values[1] + " " + values[2] + "}";
	}

}