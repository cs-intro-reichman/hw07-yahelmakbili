/** Draws the Koch Curve / Snowflake fractal. */
public class Koch {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		snowFlake(n);
	}

	/**
	 * Draws a Koch curve of depth n from (x1,y1) to (x2,y2).
	 */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}

		double ax = x1 + (x2 - x1) / 3.0;
		double ay = y1 + (y2 - y1) / 3.0;

		double bx = x1 + 2.0 * (x2 - x1) / 3.0;
		double by = y1 + 2.0 * (y2 - y1) / 3.0;

		double cx = (Math.sqrt(3) / 6.0) * (by - ay) + (ax + bx) / 2.0;
		double cy = (Math.sqrt(3) / 6.0) * (ax - bx) + (ay + by) / 2.0;

		curve(n - 1, x1, y1, ax, ay);
		curve(n - 1, ax, ay, cx, cy);
		curve(n - 1, cx, cy, bx, by);
		curve(n - 1, bx, by, x2, y2);
	}

	/**
	 */
	public static void snowFlake(int n) {
		StdDraw.setXscale(0, 1.1);
		StdDraw.setYscale(0, 1.1);
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.setPenColor(StdDraw.BLACK);

		double x1 = 0.25, y1 = 0.3767949;
		double x2 = 0.85, y2 = 0.3767949;
		double x3 = 0.55, y3 = 0.8964102;

		curve(n, x1, y1, x2, y2); // curve 1
		curve(n, x2, y2, x3, y3); // curve 2
		curve(n, x3, y3, x1, y1); // curve 3

		StdDraw.show();
	}
}
