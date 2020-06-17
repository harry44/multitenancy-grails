/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.myrent.ee.db;

/**
 *
 * @author bogdan
 */
public abstract class PersistentObject {

    private String id = java.util.UUID.randomUUID().toString();
    private Integer version;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||
            !(o instanceof PersistentObject)) {

            return false;
        }

        PersistentObject other
            = (PersistentObject)o;

        // if the id is missing, return false
        if (id == null) return false;

        // equivalence by id
        return id.equals(other.getId());
    }

    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        } else {
            return super.hashCode();
        }
    }

    public String toString() {
        return this.getClass().getName()
            + "[id=" + id + "]";
    }
}