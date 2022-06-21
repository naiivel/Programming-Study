package e.poly;

public interface DataBaseAccessObject {
	void connect();
	void select();
	void insert();
	void update();
	void delete();
	void close();
}