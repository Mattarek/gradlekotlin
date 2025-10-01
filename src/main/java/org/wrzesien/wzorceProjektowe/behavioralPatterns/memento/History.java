package org.wrzesien.wzorceProjektowe.behavioralPatterns.memento;

import java.util.Stack;

public class History {
	private final Stack<TextMemento> history = new Stack<>();

	public void save(final TextEditor editor) {
		history.push(editor.save());
	}

	public void undo(final TextEditor editor) {
		if (!history.isEmpty()) {
			final TextMemento memento = history.pop();
			editor.restore(memento);
		}
	}
}
