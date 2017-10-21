package es.uji.lotery.observer;

import es.uji.lotery.subject.ISubject;

public interface IJugador extends IObserver, ISubject{
	
	int numeroAciertos(int[] boletoAComparar) throws Exception;
	
}
