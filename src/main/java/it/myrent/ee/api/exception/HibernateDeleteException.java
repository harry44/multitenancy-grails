/*
 * HibernateDeleteException.java
 *
 * Created on 10 octombrie 2005, 10:58
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package it.myrent.ee.api.exception;

/**
 *
 * @author jamess
 */
public class HibernateDeleteException extends DatabaseException {
    
    public HibernateDeleteException(Throwable cause) {
        super(bundle.getString("delete_error_message"), bundle.getString("delete_error_title"), cause); //NOI18N
    }
}
