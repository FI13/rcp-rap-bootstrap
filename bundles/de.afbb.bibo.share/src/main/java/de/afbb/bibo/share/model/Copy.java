package de.afbb.bibo.share.model;

import java.util.Date;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * one copy of a {@link Medium}
 */
public class Copy extends Medium implements IEditorInput, Cloneable {

	public static final String FIELD_EDITION = "edition";//$NON-NLS-1$
	public static final String FIELD_BARCODE = "barcode";//$NON-NLS-1$
	public static final String FIELD_DATE_INVENTORY = "inventoryDate";//$NON-NLS-1$
	public static final String FIELD_CONDITION = "condition";//$NON-NLS-1$
	public static final String FIELD_DATE_BORROW = "borrowDate";//$NON-NLS-1$
	public static final String FIELD_DATE_LAST_BORROW = "lastBorrowDate";//$NON-NLS-1$

	private Integer id;
	private String edition;
	private String barcode = "";
	private Date inventoryDate;
	private String condition;
	private Date borrowDate;
	private Date lastBorrowDate;
	private Curator curator;
	private Curator lastCurator;
	private Borrower borrower;
	private Borrower lastBorrower;
	private int groupId = -1;

	public Copy(final int id, final String edition, final String barcode, final Date date, final String condition, final Date date2,
			final Date date3, final int groupId, final Borrower borrower, final Borrower lastBorrower, final Curator curator,
			final Curator lastCurator, final int mediumId, final String isbn, final String title, final String author,
			final String language, final MediumType type, final String publisher) {
		super(mediumId, isbn, title, author, language, type, publisher);
		this.id = id;
		this.edition = edition;
		this.barcode = barcode;
		inventoryDate = date;
		this.condition = condition;
		borrowDate = date2;
		lastBorrowDate = date3;
		this.groupId = groupId;
		this.borrower = borrower;
		this.lastBorrower = lastBorrower;
		this.curator = curator;
		this.lastCurator = lastCurator;
	}

	public Copy() {
		super();
	}

	@Override
	public Integer getMediumId() {
		return id;
	}

	@Override
	public void setMediumId(final Integer id) {
		this.id = id;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(final String edition) {
		changeSupport.firePropertyChange(FIELD_EDITION, this.edition, this.edition = edition);
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(final String barcode) {
		changeSupport.firePropertyChange(FIELD_BARCODE, this.barcode, this.barcode = barcode);
	}

	public Date getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(final Date inventoryDate) {
		changeSupport.firePropertyChange(FIELD_DATE_INVENTORY, this.inventoryDate, this.inventoryDate = inventoryDate);
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(final String condition) {
		changeSupport.firePropertyChange(FIELD_CONDITION, this.condition, this.condition = condition);
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(final Date borrowDate) {
		changeSupport.firePropertyChange(FIELD_DATE_BORROW, this.borrowDate, this.borrowDate = borrowDate);
	}

	public Date getLastBorrowDate() {
		return lastBorrowDate;
	}

	public void setLastBorrowDate(final Date lastBorrowDate) {
		changeSupport.firePropertyChange(FIELD_DATE_LAST_BORROW, this.lastBorrowDate, this.lastBorrowDate = lastBorrowDate);
	}

	@Override
	public Object clone() {
		Object c = super.clone();
		((Copy) c).setBorrower((Borrower) getBorrower().clone());
		((Copy) c).setLastBorrower((Borrower) getLastBorrower().clone());
		((Copy) c).setCurator((Curator) getCurator().clone());
		((Copy) c).setLastCurator((Curator) getLastCurator().clone());
		return c;
	}

	public Curator getCurator() {
		return curator;
	}

	public void setCurator(final Curator curator) {
		this.curator = curator;
	}

	public Curator getLastCurator() {
		return lastCurator;
	}

	public void setLastCurator(final Curator lastCurator) {
		this.lastCurator = lastCurator;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(final Borrower borrower) {
		this.borrower = borrower;
	}

	public Borrower getLastBorrower() {
		return lastBorrower;
	}

	public void setLastBorrower(final Borrower lastBorrower) {
		this.lastBorrower = lastBorrower;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(final int groupElements) {
		groupId = groupElements;
	}

	@Override
	public Object getAdapter(final Class adapter) {
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
	public String getName() {
		return barcode;
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return barcode;
	}

	@Override
	public String toString() {
		return "Copy{" + "id=" + id + ", edition=" + edition + ", barcode=" + barcode + ", inventoryDate=" + inventoryDate + ", condition="
				+ condition + ", borrowDate=" + borrowDate + ", lastBorrowDate=" + lastBorrowDate + ", groupId=" + groupId + ", borrowerId="
				+ borrower + ", lastBorrowerId=" + lastBorrower + ", curator=" + curator + ", lastCurator=" + lastCurator + '}';
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (barcode == null ? 0 : barcode.hashCode());
		result = prime * result + (borrowDate == null ? 0 : borrowDate.hashCode());
		result = prime * result + (borrower == null ? 0 : borrower.hashCode());
		result = prime * result + (condition == null ? 0 : condition.hashCode());
		result = prime * result + (curator == null ? 0 : curator.hashCode());
		result = prime * result + (edition == null ? 0 : edition.hashCode());
		result = prime * result + groupId;
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (inventoryDate == null ? 0 : inventoryDate.hashCode());
		result = prime * result + (lastBorrowDate == null ? 0 : lastBorrowDate.hashCode());
		result = prime * result + (lastBorrower == null ? 0 : lastBorrower.hashCode());
		result = prime * result + (lastCurator == null ? 0 : lastCurator.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Copy)) {
			return false;
		}
		final Copy other = (Copy) obj;
		if (barcode == null) {
			if (other.barcode != null) {
				return false;
			}
		} else if (!barcode.equals(other.barcode)) {
			return false;
		}
		if (borrowDate == null) {
			if (other.borrowDate != null) {
				return false;
			}
		} else if (!borrowDate.equals(other.borrowDate)) {
			return false;
		}
		if (borrower == null) {
			if (other.borrower != null) {
				return false;
			}
		} else if (!borrower.equals(other.borrower)) {
			return false;
		}
		if (condition == null) {
			if (other.condition != null) {
				return false;
			}
		} else if (!condition.equals(other.condition)) {
			return false;
		}
		if (curator == null) {
			if (other.curator != null) {
				return false;
			}
		} else if (!curator.equals(other.curator)) {
			return false;
		}
		if (edition == null) {
			if (other.edition != null) {
				return false;
			}
		} else if (!edition.equals(other.edition)) {
			return false;
		}
		if (groupId != other.groupId) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (inventoryDate == null) {
			if (other.inventoryDate != null) {
				return false;
			}
		} else if (!inventoryDate.equals(other.inventoryDate)) {
			return false;
		}
		if (lastBorrowDate == null) {
			if (other.lastBorrowDate != null) {
				return false;
			}
		} else if (!lastBorrowDate.equals(other.lastBorrowDate)) {
			return false;
		}
		if (lastBorrower == null) {
			if (other.lastBorrower != null) {
				return false;
			}
		} else if (!lastBorrower.equals(other.lastBorrower)) {
			return false;
		}
		if (lastCurator == null) {
			if (other.lastCurator != null) {
				return false;
			}
		} else if (!lastCurator.equals(other.lastCurator)) {
			return false;
		}
		return true;
	}
}
