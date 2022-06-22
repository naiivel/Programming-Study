package generic04_extends;

public class Parent<K, M> {
	private K kind;
	private M model;
	
	//alt + s + r
	public K getKind() {
		return kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
}