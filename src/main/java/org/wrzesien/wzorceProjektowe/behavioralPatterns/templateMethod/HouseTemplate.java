package org.wrzesien.wzorceProjektowe.behavioralPatterns.templateMethod;

public abstract class HouseTemplate {
	protected final void build() {
		digHole();
		buildFundation();
		buildWhalls();
		makeRoof();
		insertWindows();
	}

	protected void digHole() {
		System.out.println("Digging hole");
	}

	protected abstract void buildFundation();

	protected abstract void buildWhalls();

	protected abstract void makeRoof();

	protected abstract void insertWindows();
}
