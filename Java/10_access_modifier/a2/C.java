package a2;

//import a1.B;  import조차 안됌

class C {
	a1.A a = new a1.A();
	// a1.B b = new a1.b();  a1.b는 default라 다른 패키지에서 호출안됌
}
