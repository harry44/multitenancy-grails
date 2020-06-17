package com.dogmasystems.myrent.db

import com.dogmasystems.touroperatorportal.Carburanti
import com.dogmasystems.touroperatorportal.Optionals
import grails.util.Holders

import java.text.MessageFormat

class MRRowRentalAgreement implements Serializable{


    Boolean tempoKm
    Boolean tempoExtra
    Boolean franchigia
    Integer rentalRowNumber
    String description
    String unitsOfMeasurement
    Double quantity
    Double unitPrice
    Double discount
    Double fixedDiscount
    Double taxableRowTotal
    Double vatRowTotal
    Double rowTotal
    MRVatCodes vatCodes
    Optionals optionals
    Carburanti carburanti
    MRChartAccount chartAccount
    MRRentalAgreement rentalAgreement

//	static belongsTo = [Carburanti, Codiciiva, MRHeaderInvoice, Optionals, MRChartAccount]
    static belongsTo =  [ MRVatCodes, MRRentalAgreement, MRChartAccount]

    static mapping = {
        cache true
        table name: "contrattonoleggio_riga"//, schema: "public"
        id generator: 'sequence', params: [sequence: 'contrattonoleggio_riga_seq']
        id column: "id", sqlType: "int4"
        vatCodes column: "id_aliquota_iva", sqlType: "int4"
        optionals column: "id_optional", sqlType: "int4"
        carburanti column: "id_carburante", sqlType: "int4"
        franchigia column: "franchigia"
        chartAccount column: "id_piano_dei_conti", sqlType: "int4"
        rentalAgreement column: "id_contrattonoleggio", sqlType: "int4"
        /*if(Holders.grailsApplication.config.com.dogmasystems.postgres==true){
            description column: "descrizione"
            unitsOfMeasurement column: "unita_misura"
        }else {
            description column: "descrizione", sqlType:"string"
            unitsOfMeasurement column: "unita_misura", sqlType:"string"
        }*/
        description column: "descrizione"
        unitsOfMeasurement column: "unita_misura"
        rentalRowNumber column: "numero_riga_contratto_noleggio", sqlType: "int4"

        quantity column: "quantita"
        unitPrice column: "prezzo_unitario"
        discount column: "sconto"
        fixedDiscount column: "sconto_fisso"
        taxableRowTotal column: "totale_imponibile_riga"
        vatRowTotal column: "totale_iva_riga"
        rowTotal column: "totale_riga"
      //  optionals column: "id_optional", sqlType: "int4"
        tempoExtra column: "tempo_extra"
        tempoKm column: "tempo_km"

        version false
    }
    static constraints = {
        tempoKm nullable: true
        tempoExtra nullable: true
        franchigia nullable: true
        rentalRowNumber nullable: true
        description nullable: true
        unitsOfMeasurement nullable: true
        quantity nullable: true, scale: 17
        unitPrice nullable: true, scale: 17
        discount nullable: true, scale: 17
        fixedDiscount nullable: true, scale: 17
        taxableRowTotal nullable: true, scale: 17
        vatRowTotal nullable: true, scale: 17
        rowTotal nullable: true, scale: 17
        carburanti nullable: true
        chartAccount nullable: true
       optionals nullable: true
        vatCodes nullable:true
    }

}