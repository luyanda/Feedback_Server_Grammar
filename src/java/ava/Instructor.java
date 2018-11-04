package ava;
import java.util.Objects;

class instructor extends User{
	private int stuffNo;

	public int getStuffNo() {
		return stuffNo;
	}

	public void setStuffNo(int stuffNo) {
		this.stuffNo = stuffNo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		instructor that = (instructor) o;
		return stuffNo == that.stuffNo;
	}

	@Override
	public int hashCode() {

		return Objects.hash(stuffNo);
	}
}
