package wad.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Koe extends AbstractPersistable<Long> {

    private String kurssi;
    private boolean erillistentti;
}
