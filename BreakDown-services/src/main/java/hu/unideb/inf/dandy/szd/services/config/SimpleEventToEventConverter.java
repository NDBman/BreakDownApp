package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import hu.unideb.inf.dandy.szd.service.dto.Event;
import hu.unideb.inf.dandy.szd.service.dto.SimpleEvent;

public class SimpleEventToEventConverter implements Converter<SimpleEvent, Event> {

	@Override
	public Event convert(MappingContext<SimpleEvent, Event> context) {
		Event event = new Event();
		event.setBreakevent(false);
		event.setTitle(context.getSource().getName());
		event.setStartTime(context.getSource().getStartTime().getTime());
		event.setEndTime(context.getSource().getEndTime().getTime());
		event.setDescription(context.getSource().getDescription());
		return event;
	}

}
