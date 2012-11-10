package zoo.mb.chapter11;

class SingleLinkQueue<E> {
	protected Cell<E> head;

	protected Cell<E> tail;

	public void add(E item) {
		Cell<E> cell = new Cell<E>(item);
		if (tail == null)
			head = tail = cell;
		else {
			tail.setNext(cell);
			tail = cell;
		}
	}

	public E remove() {
		if (head == null)
			return null;
		Cell<E> cell = head;
		head = head.getNext();
		if (head == null)
			tail = null; // empty queue
		return cell.getElement();
	}
}