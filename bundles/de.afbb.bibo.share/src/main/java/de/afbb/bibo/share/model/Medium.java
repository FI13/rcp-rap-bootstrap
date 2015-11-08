package de.afbb.bibo.share.model;

import de.afbb.bibo.share.beans.AbstractPropertyChangeSupport;

public class Medium extends AbstractPropertyChangeSupport implements Cloneable {

	public static final String FIELD_ISBN = "isbn";//$NON-NLS-1$
	public static final String FIELD_TITLE = "title";//$NON-NLS-1$
	public static final String FIELD_AUTHOR = "author";//$NON-NLS-1$
	public static final String FIELD_LANGUAGE = "language";//$NON-NLS-1$
	public static final String FIELD_TYP_ID = "typeId";//$NON-NLS-1$
	public static final String FIELD_PUBLISHER = "publisher";//$NON-NLS-1$

	private Integer id;
	private String isbn;
	private String title;
	private String author;
	private String language;
	private MediumType type;
	private String publisher;

	public Medium() {
	}

	public Medium(final int id, final String isbn, final String title, final String author, final String language, final MediumType type,
			final String publisher) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.language = language;
		this.type = type;
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		changeSupport.firePropertyChange(FIELD_TITLE, this.title, this.title = title);
	}

	public MediumType getType() {
		return type;
	}

	public void setType(final MediumType type) {
		this.type = type;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(final String publisher) {
		changeSupport.firePropertyChange(FIELD_PUBLISHER, this.publisher, this.publisher = publisher);
	}

	public Integer getMediumId() {
		return id;
	}

	public void setMediumId(final Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(final String isbn) {
		changeSupport.firePropertyChange(FIELD_ISBN, this.isbn, this.isbn = isbn);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		changeSupport.firePropertyChange(FIELD_AUTHOR, this.author, this.author = author);
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(final String language) {
		changeSupport.firePropertyChange(FIELD_LANGUAGE, this.language, this.language = language);
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (author == null ? 0 : author.hashCode());
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (isbn == null ? 0 : isbn.hashCode());
		result = prime * result + (language == null ? 0 : language.hashCode());
		result = prime * result + (publisher == null ? 0 : publisher.hashCode());
		result = prime * result + (title == null ? 0 : title.hashCode());
		result = prime * result + (type == null ? 0 : type.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Medium)) {
			return false;
		}
		final Medium other = (Medium) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (isbn == null) {
			if (other.isbn != null) {
				return false;
			}
		} else if (!isbn.equals(other.isbn)) {
			return false;
		}
		if (language == null) {
			if (other.language != null) {
				return false;
			}
		} else if (!language.equals(other.language)) {
			return false;
		}
		if (publisher == null) {
			if (other.publisher != null) {
				return false;
			}
		} else if (!publisher.equals(other.publisher)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Medium{" + "id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", language=" + language + ", type="
				+ type + ", publisher=" + publisher + '}';
	}

	@Override
	public Object clone() {
		try {
			Object c = super.clone();
			((Medium) c).setType((MediumType) getType().clone());
			return c;
		} catch (final CloneNotSupportedException e) {
			// swallow exception and return null
			return null;
		}
	}
}
