package day3;


public class Koordinate{
	private int x;
	private int y;
	
	public Koordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() { 
		return x; 
	}

	public int getY() {
		return y;
	}
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Koordinate k = (Koordinate) o;
		return this.x == k.x && this.y == k.y;
	}
	@Override
	public String toString() {
		return "Koordinati [x=" + x + ", y=" + y + "]";
	}
}

