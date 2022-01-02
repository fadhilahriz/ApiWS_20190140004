/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.cemilan.pws.A.cemilan.pws;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import tugas.cemilan.pws.A.cemilan.pws.exceptions.NonexistentEntityException;
import tugas.cemilan.pws.A.cemilan.pws.exceptions.PreexistingEntityException;

/**
 *
 * @author FADHIL
 */
public class DatakomikJpaController implements Serializable {

    public DatakomikJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tugas.cemilan.pws_A.cemilan.pws_jar_0.0.1-SNAPSHOTPU");

    public DatakomikJpaController() {
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Datakomik datakomik) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(datakomik);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDatakomik(datakomik.getIdkomik()) != null) {
                throw new PreexistingEntityException("Datakomik " + datakomik + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Datakomik datakomik) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            datakomik = em.merge(datakomik);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = datakomik.getIdkomik();
                if (findDatakomik(id) == null) {
                    throw new NonexistentEntityException("The datakomik with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Datakomik datakomik;
            try {
                datakomik = em.getReference(Datakomik.class, id);
                datakomik.getIdkomik();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datakomik with id " + id + " no longer exists.", enfe);
            }
            em.remove(datakomik);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Datakomik> findDatakomikEntities() {
        return findDatakomikEntities(true, -1, -1);
    }

    public List<Datakomik> findDatakomikEntities(int maxResults, int firstResult) {
        return findDatakomikEntities(false, maxResults, firstResult);
    }

    private List<Datakomik> findDatakomikEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Datakomik.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Datakomik findDatakomik(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Datakomik.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatakomikCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Datakomik> rt = cq.from(Datakomik.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
