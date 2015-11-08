package de.afbb.bibo.share.model;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import de.afbb.bibo.share.beans.AbstractPropertyChangeSupport;

/**
 * model class for an administrator of the application
 */
public class Curator extends AbstractPropertyChangeSupport implements IEditorInput, Cloneable {

	public static final String FIELD_NAME = "name";//$NON-NLS-1$
	public static final String FIELD_PASSWORD = "password";//$NON-NLS-1$

	private Integer id;
	private String name;
	private String salt;
	private String passwordHash;
	private String password;

	/**
	 * Constructor. creates a dummy object with invalid id
	 */
	public Curator() {
		this(-1);
	}

	/**
	 * Constructor for an instance that has only the id field filled.
	 *
	 * @param id
	 */
	public Curator(final int id) {
		this(id, null, null, null);
	}

	/**
	 * regular Constructor.
	 *
	 * @param id
	 *            primary key
	 * @param name
	 *            displayable name
	 * @param salt
	 *            salt used for password hashing
	 * @param passwordHash
	 *            hashed password
	 */
	public Curator(final int id, final String name, final String salt, final String passwordHash) {
		super();
		this.id = id;
		this.name = name;
		this.salt = salt;
		this.passwordHash = passwordHash;
	}

	/**
	 * getter for password
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter for password
	 *
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		changeSupport.firePropertyChange(FIELD_PASSWORD, this.password, this.password = password);
	}

	/**
	 * getter for id
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * setter for id
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * getter for name
	 *
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * setter for name
	 *
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		changeSupport.firePropertyChange(FIELD_NAME, this.name, this.name = name);
	}

	/**
	 * getter for salt
	 *
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * setter for salt
	 *
	 * @param salt
	 *            the salt to set
	 */
	public void setSalt(final String salt) {
		this.salt = salt;
	}

	/**
	 * getter for passwordHash
	 *
	 * @return the passwordhash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * setter for passwordHash
	 *
	 * @param hash
	 *            the passwordHash to set
	 */
	public void setPasswordHash(final String hash) {
		passwordHash = hash;
	}

	@Override
	public Object getAdapter(final Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return name;
	}

	@Override
	public String toString() {
		return "Curator{" + "id=" + id + ", name=" + name + ", salt=" + salt + ", passwordHash=" + passwordHash + '}';
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (final CloneNotSupportedException e) {
			// swallow exception and return null
			return null;
		}
	}
}
