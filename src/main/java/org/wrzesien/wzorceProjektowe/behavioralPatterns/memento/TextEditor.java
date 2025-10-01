package org.wrzesien.wzorceProjektowe.behavioralPatterns.memento;

public class TextEditor {
	private String text = "";

	public void write(final String newText) {
		text += newText;
	}

	public String getText() {
		return text;
	}

	// Tworzy memento (snapshot)
	public TextMemento save() {
		return new TextMemento(text);
	}

	// Przywraca stan z memento
	public void restore(final TextMemento memento) {
		text = memento.state();
	}
}
