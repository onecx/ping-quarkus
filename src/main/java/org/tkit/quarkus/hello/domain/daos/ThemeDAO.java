package org.tkit.quarkus.hello.domain.daos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

import org.tkit.quarkus.hello.domain.models.Theme;
import org.tkit.quarkus.jpa.daos.AbstractDAO;
import org.tkit.quarkus.jpa.exceptions.DAOException;
import org.tkit.quarkus.jpa.models.TraceableEntity_;

@ApplicationScoped
public class ThemeDAO extends AbstractDAO<Theme> {

    // https://hibernate.atlassian.net/browse/HHH-16830#icft=HHH-16830
    @Override
    public Theme findById(Object id) throws DAOException {
        try {
            var cb = this.getEntityManager().getCriteriaBuilder();
            var cq = cb.createQuery(Theme.class);
            var root = cq.from(Theme.class);
            cq.where(cb.equal(root.get(TraceableEntity_.ID), id));
            return this.getEntityManager().createQuery(cq).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new DAOException(ErrorKeys.FIND_ENTITY_BY_ID_FAILED, e, entityName, id);
        }
    }

    public enum ErrorKeys {

        FIND_ENTITY_BY_ID_FAILED,
        ERROR_FIND_ALL_THEME_PAGE,
        ERROR_FIND_THEME_BY_NAMES,
        ERROR_FIND_THEME_BY_NAME,
    }
}
