package org.wrzesien.wzorceProjektowe.behavioralPatterns.visitor;

public interface Visitor {
	void visit(Book book);

	void visit(Fruit fruit);
}
