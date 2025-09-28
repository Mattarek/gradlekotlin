package org.wrzesien.wzorceProjektowe.structuralPatterns.facade.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarFactoryFacade {
	private FrameAssembler frameAssembler;
	private Painter painter;
	private EngineMaker engineMaker;
	private CockpitAssembler cockpitAssembler;
	private DoorMaker doorMaker;
	private SeatsMaker seatsMaker;
	private WheelsProducer wheelsProducer;

	public void produceCar() {
		frameAssembler.assembleFrame();
		painter.paintSkeleton();
		engineMaker.fastenEngine();
		cockpitAssembler.mountCockpit();
		doorMaker.installDoor();
		seatsMaker.attachSeats();
		wheelsProducer.attachWheels();
	}
}
