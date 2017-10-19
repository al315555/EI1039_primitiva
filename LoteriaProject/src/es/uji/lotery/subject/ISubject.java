package es.uji.lotery.subject;

import es.uji.lotery.observer.IObserver;

public interface ISubject {
	void registrarObervador(IObserver observador);
	void eliminarObservador(IObserver observador) throws Exception;
	void notificar();
}
