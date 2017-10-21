package es.uji.lotery.subject;

public interface ILoteria extends ISubject{
	
	public static final int FIRST_NUM=1;
	public static final int LAST_NUM=49;
	public static final int LENGTH=7;
	
	void nuevoSorteo();
}
