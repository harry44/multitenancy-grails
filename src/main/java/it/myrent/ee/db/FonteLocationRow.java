/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myrent.ee.db;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 *
 * @author Madhvendra
 */
public class FonteLocationRow implements it.aessepi.utils.db.PersistentInstance,Comparable<FonteLocationRow>{
    private Integer id;
    private MROldFonteCommissione reservationSourceId;
    private MROldSede locationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MROldFonteCommissione getReservationSourceId() {
        return reservationSourceId;
    }

    public void setReservationSourceId(MROldFonteCommissione reservationSourceId) {
        this.reservationSourceId = reservationSourceId;
    }

    public MROldSede getLocationId() {
        return locationId;
    }

    public void setLocationId(MROldSede locationId) {
        this.locationId = locationId;
    }
    
    
    @Override
    public int compareTo(FonteLocationRow o) {
        if (o == null) {
            return 1;
        } else {
            return new CompareToBuilder().//append(getDescription(), o.getDescription()).
                    append(getId(), o.getId()).
                    toComparison();
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof FonteLocationRow)) {
            return false;
        }
        FonteLocationRow castOther = (FonteLocationRow) other;
        return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
    }

}
