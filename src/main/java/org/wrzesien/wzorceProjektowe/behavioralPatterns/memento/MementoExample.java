package org.wrzesien.wzorceProjektowe.behavioralPatterns.memento;

public class MementoExample {
	public static void main(final String[] args) {
		final TextEditor editor = new TextEditor();
		final History history = new History();

		editor.write("Hello");
		history.save(editor);

		editor.write(" World!");
		history.save(editor);

		System.out.println("Aktualny tekst: " + editor.getText());

		history.undo(editor);
		System.out.println("Po cofnięciu: " + editor.getText());

		history.undo(editor);
		System.out.println("Po kolejnym cofnięciu: " + editor.getText());
	}
}
