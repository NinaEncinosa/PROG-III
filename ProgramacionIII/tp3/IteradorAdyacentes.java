package ProgramacionIII.tp3;

import java.util.Iterator;

public class IteradorAdyacentes<T> implements Iterator<Integer>{

	private Iterator<Arco<T>> it;
	
	public IteradorAdyacentes (Iterator<Arco<T>> it) {
		this.it = it;
	}
	
	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public Integer next() {
		return it.next().getVerticeDestino();
	}
}
