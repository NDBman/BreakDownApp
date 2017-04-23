package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import hu.unideb.inf.dandy.szd.service.dto.BreakEvent;
import hu.unideb.inf.dandy.szd.service.dto.Event;

public class BreakEventToEventConverter implements Converter<BreakEvent, Event>{

	@Override
	public Event convert(MappingContext<BreakEvent, Event> context) {
		Event event = new Event();
		event.setTitle(context.getSource().getName());
		event.setBreakevent(true);
		event.setDescription(context.getSource().getDescription());
		event.setStartTime(context.getSource().getStartTime().getTime());
		event.setEndTime(context.getSource().getEndTime().getTime());
		return event;
	}

}
