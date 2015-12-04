package de.afbb.bibo.servletclient.connection;

import java.net.ConnectException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.afbb.bibo.share.IMediumService;
import de.afbb.bibo.share.beans.BeanExclusionStrategy;
import de.afbb.bibo.share.callback.EventListener;
import de.afbb.bibo.share.model.Borrower;
import de.afbb.bibo.share.model.Medium;

public class MediumServiceImpl implements IMediumService {

	private static final Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new BeanExclusionStrategy())
			.create();

	private final Set<EventListener> listeners = new HashSet<EventListener>();

	@Override
	public void update(final Medium medium) throws ConnectException {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(final Medium medium) throws ConnectException {
		// TODO Auto-generated method stub

	}

	@Override
	public Medium getMedium(final int id) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medium getMedium(final String isbn) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Borrower> listLent(final String isbn) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Medium> list() throws ConnectException {
		final HttpResponse resp = ServerConnection.getInstance().request("/stock/listMedia", "GET", null, null);
		if (resp.getStatus() == HttpServletResponse.SC_OK) {
			final Collection<Medium> result = new HashSet<>();
			final String[] data = resp.getData().split("\n");
			for (int i = 0; i < data.length; i++) {
				result.add(gson.fromJson(data[i], Medium.class));
			}
			return result;
		} else {
			throw new ConnectException("Wrong status code. Recieved was: " + resp.getStatus());
		}
	}

	@Override
	public void delete(final Medium medium) throws ConnectException {
		// TODO Auto-generated method stub

	}

	@Override
	public void register(final EventListener listener) {
		listeners.add(listener);
	}

}
