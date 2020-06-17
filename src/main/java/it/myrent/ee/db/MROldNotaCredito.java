/*
 * NotaCredito.java
 *
 * Created on 21 gennaio 2005, 17.01
 */

package it.myrent.ee.db;

import org.apache.commons.lang.builder.HashCodeBuilder;
import it.aessepi.utils.db.PersistentInstance;
import java.util.Date;

/**
 *
 * @author maio
 */
public class MROldNotaCredito extends MROldFatturaGenerica implements PersistentInstance{
    
    /**
     * Creates a new instance of MROldNotaCredito
     */
    public MROldNotaCredito() {
    }
    
    public MROldNotaCredito(
            MROldAffiliato affiliato,
            User user,
            MROldNumerazione numerazione,
            String prefisso,
            Integer numero,
            Date data,
            Integer anno
    ) {
        super(affiliato, user, numerazione, prefisso, numero, data, anno);
    }
    
    public String getTipoDocumento() {
        return NC;
    }

    public String getTipoNumerazione() {
        return MROldNumerazione.NOTE_CREDITO_VENDITA;
    }
     
//    public boolean equals(Object other) {
//        if ( !(other instanceof MROldNotaCredito)) return false;
//        MROldNotaCredito castOther = (MROldNotaCredito) other;
//        //return this.getId()==null?castOther.getId()==null:this.getId().equals(castOther.getId());
//
//        return new EqualsBuilder()
//        .append(this.getId(), castOther.getId())
//        .isEquals();
//    }
    
    public int hashCode() {
        return new HashCodeBuilder()
        .append(getId())
        .toHashCode();
    }
    
}
