package hu.unideb.inf.dandy.szd.jpa.entity;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseName extends BaseId {

	private String name;
}
