package antonionorfo;

import antonionorfo.dao.EventoDao;
import antonionorfo.entities.Evento;
import antonionorfo.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("firstJava");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDao eventoDao = new EventoDao(em);

        Evento evento = new Evento();
        evento.setTitolo("Sample Event");
        evento.setDataEvento(LocalDate.now());
        evento.setDescrizione("This is a sample event.");
        evento.setTipoEvento(TipoEvento.PUBBLICO);
        evento.setNumeroMassimoPartecipanti(100);


        eventoDao.save(evento);


        Evento foundEvento = eventoDao.findById(evento.getId());
        System.out.println("Found Evento: " + foundEvento);


        eventoDao.deleteById(evento.getId());

        em.close();
        emf.close();
    }
}
